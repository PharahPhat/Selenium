package com.interop.common.constants.utils;

import com.interop.common.StateAccount;
import com.sandata.core.config.Configuration;
import com.sandata.core.config.TestContext;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.testng.Assert;

import static com.interop.common.constants.utils.db.AuthDBUtils.getIDMatchingService;
import static com.interop.common.constants.utils.db.AuthDBUtils.getIDServiceEVVImportAuth;
import static com.interop.common.constants.utils.db.ClientDBUtils.getIDServiceEVVImportMember;
import static com.interop.common.constants.utils.db.ProviderDBUtils.getIDServiceEVVImportProvider;
import static com.interop.services.openevv.batch.ImportClaimServices.getIDServiceBatchClaimValidationV2;
import static io.restassured.RestAssured.given;

public class TriggerUtils {
    private static final String END_POINT = "/interfaces/internal/schedule-etl-job/trigger-export";
    private static final Logger LOGGER = Logger.getLogger(TriggerUtils.class);

    @Step("Run trigger for Auth ETL Job services for current state")
    public static void runTriggerForSpecificService(servicesNeedToTrigger servicesName) throws InterruptedException {
        runTriggerForSpecificService(servicesName, StateAccount.loadStateAccount().getAccountTemplate());
    }

    @Step("Run trigger for Auth ETL Job services for given account template")
    public static void runTriggerForSpecificService(servicesNeedToTrigger servicesName, String accountNum) throws InterruptedException {
        Configuration config = TestContext.get().getConfiguration();
        String idServices = null;
        String uri = config.getHostName() + END_POINT;
        switch (servicesName) {
            case EVV_IMPORT_AUTH:
                idServices = getIDServiceEVVImportAuth(accountNum);
                break;
            case MATCHING_SERVICE:
                idServices = getIDMatchingService(accountNum);
                break;
            case EVV_IMPORT_PROVIDER:
                idServices = getIDServiceEVVImportProvider(accountNum);
                break;
            case EVV_IMPORT_MEMBER:
                idServices = getIDServiceEVVImportMember(accountNum);
                break;
            case EVV_CLAIM_VALIDATION_V2:
                idServices = getIDServiceBatchClaimValidationV2();
                break;
        }
        if (idServices == null) {
            String message = "ServiceId = null, Trigger Service " + servicesName + " maybe not ENABLED. Please check again";
            LOGGER.error(message);
        }
        String serviceGet = String.format("%s?start_date_time=2018-01-01 00:00:00&end_date_time=2018-07-17 00:00:00", idServices);
        RestAssured.baseURI = uri;
        Response response = given()
                .relaxedHTTPSValidation()
                .auth()
                .basic(config.get("trigger_username"), config.get("trigger_password"))
                .when()
                .log()
                .all()
                .get(serviceGet);
        Assert.assertEquals(200, response.getStatusCode());
        Thread.sleep(60000);//Sleep 1 minutes before running another services if needed
    }

    public enum servicesNeedToTrigger {
        EVV_IMPORT_AUTH,
        MATCHING_SERVICE,
        EVV_IMPORT_PROVIDER,
        EVV_IMPORT_MEMBER,
        EVV_CLAIM_VALIDATION_V2
    }
}
