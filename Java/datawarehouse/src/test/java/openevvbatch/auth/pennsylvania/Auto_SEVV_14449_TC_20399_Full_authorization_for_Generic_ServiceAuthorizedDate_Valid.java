package openevvbatch.auth.pennsylvania;

import com.interop.common.constants.utils.RabbitMQUtils;
import com.interop.models.db.stx.STXAuthorization;
import com.interop.models.db.stx.STXClientAuth;
import com.interop.models.openevv.batch.AuthorizationCSVModel;
import com.interop.services.base.ImportBaseTest;
import com.interop.services.openevv.batch.ImportAuthService;
import com.interop.services.openevv.batch.ImportServices;
import com.jcraft.jsch.SftpException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeoutException;

import static com.interop.common.constants.utils.TriggerUtils.runTriggerForSpecificService;
import static com.interop.common.constants.utils.TriggerUtils.servicesNeedToTrigger.EVV_IMPORT_AUTH;
import static com.interop.common.constants.utils.TriggerUtils.servicesNeedToTrigger.MATCHING_SERVICE;
import static com.interop.common.constants.utils.db.AuthDBUtils.*;
import static com.interop.common.constants.utils.db.ClientDBUtils.getIDAndMedicaidIDOfMemberHavingSpecificMedicaidID;
import static com.interop.common.constants.FieldConstants.EMPTY_VALUE;

public class Auto_SEVV_14449_TC_20399_Full_authorization_for_Generic_ServiceAuthorizedDate_Valid extends ImportBaseTest {
    ImportAuthService importAuthService;
    String queueName = "QAAutomation";

    STXClientAuth clientInfo = getIDAndMedicaidIDOfMemberHavingSpecificMedicaidID(stateAccount, 10).get(0);

    @Test(groups = {"non-regression"})
    public void Import_Auth_Without_ServiceAuthorizedDate() throws IOException, InterruptedException, SftpException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchAlgorithmException, KeyManagementException, URISyntaxException, TimeoutException, NoSuchFieldException, SQLException {
        importAuthService = new ImportAuthService();
        String authRefNum = importAuthService.generateAuthRefNumber();

        List<AuthorizationCSVModel> lstAuthInfo = new ArrayList<>();
        AuthorizationCSVModel authInfo = new AuthorizationCSVModel();
        authInfo.setClientIdentifier(clientInfo.getMEDICAID_ID().substring(0, 9));
        authInfo.setAuthorizationReferenceNumber(authRefNum);
        authInfo.setProviderID(clientInfo.getPROVIDER_ID());
        lstAuthInfo.add(authInfo);

        baseObj.info("Step 1: Prepare data to import");
        List<String> modifiedHeader = importAuthService.getCsvHeaders();
        modifiedHeader.remove("ServiceAuthorizedDate");
        importAuthService.setCsvHeaders(modifiedHeader);
        importAuthService.initFileImportAuthAndOutboundWithCustomData(lstAuthInfo);

        performImportAndVerify(clientInfo, authInfo);
    }

    @Test(groups = {"non-regression"})
    public void Import_Auth_With_ServiceAuthorizedDate_empty() throws IOException, InterruptedException, SftpException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchAlgorithmException, KeyManagementException, URISyntaxException, TimeoutException, NoSuchFieldException, SQLException {
        importAuthService = new ImportAuthService();
        String authRefNum = importAuthService.generateAuthRefNumber();

        STXClientAuth clientInfo = getIDAndMedicaidIDOfMemberHavingSpecificMedicaidID(stateAccount, 10).get(0);
        List<AuthorizationCSVModel> lstAuthInfo = new ArrayList<>();
        AuthorizationCSVModel authInfo = new AuthorizationCSVModel();
        authInfo.setClientIdentifier(clientInfo.getMEDICAID_ID().substring(0, 9));
        authInfo.setAuthorizationReferenceNumber(authRefNum);
        authInfo.setProviderID(clientInfo.getPROVIDER_ID());
        authInfo.setServiceAuthorizedDate(EMPTY_VALUE);
        lstAuthInfo.add(authInfo);

        baseObj.info("Step 1: Prepare data to import");
        importAuthService.initFileImportAuthAndOutboundWithCustomData(lstAuthInfo);

        performImportAndVerify(clientInfo, authInfo);
    }

    @Test(groups = {"non-regression"})
    public void Import_Auth_With_valid_format() throws IOException, InterruptedException, SftpException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchAlgorithmException, KeyManagementException, URISyntaxException, TimeoutException, NoSuchFieldException, SQLException {
        importAuthService = new ImportAuthService();
        String authRefNum = importAuthService.generateAuthRefNumber();

        List<AuthorizationCSVModel> lstAuthInfo = new ArrayList<>();
        AuthorizationCSVModel authInfo = new AuthorizationCSVModel();
        authInfo.setClientIdentifier(clientInfo.getMEDICAID_ID().substring(0, 9));
        authInfo.setAuthorizationReferenceNumber(authRefNum);
        authInfo.setProviderID(clientInfo.getPROVIDER_ID());
        authInfo.setServiceAuthorizedDate("2019-09-20");
        lstAuthInfo.add(authInfo);

        baseObj.info("Step 1: Prepare data to import");
        importAuthService.initFileImportAuthAndOutboundWithCustomData(lstAuthInfo);

        performImportAndVerify(clientInfo, authInfo);
    }

    @Test(groups = {"non-regression"})
    public void Import_Auth_With_value_today() throws IOException, InterruptedException, SftpException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchAlgorithmException, KeyManagementException, URISyntaxException, TimeoutException, NoSuchFieldException, SQLException {
        importAuthService = new ImportAuthService();
        String authRefNum = importAuthService.generateAuthRefNumber();
        String currentDate = "yyyy-MM-dd";
        SimpleDateFormat simpleDate = new SimpleDateFormat(currentDate);

        List<AuthorizationCSVModel> lstAuthInfo = new ArrayList<>();
        AuthorizationCSVModel authInfo = new AuthorizationCSVModel();
        authInfo.setClientIdentifier(clientInfo.getMEDICAID_ID().substring(0, 9));
        authInfo.setAuthorizationReferenceNumber(authRefNum);
        authInfo.setProviderID(clientInfo.getPROVIDER_ID());
        authInfo.setServiceAuthorizedDate(simpleDate.format(new Date()));
        lstAuthInfo.add(authInfo);

        baseObj.info("Step 1: Prepare data to import");
        importAuthService.initFileImportAuthAndOutboundWithCustomData(lstAuthInfo);

        performImportAndVerify(clientInfo, authInfo);
    }

    private void performImportAndVerify(STXClientAuth clientInfo, AuthorizationCSVModel authInfo) throws SftpException, IOException, InterruptedException, NoSuchFieldException, SQLException, URISyntaxException, TimeoutException, NoSuchAlgorithmException, KeyManagementException {
        RabbitMQUtils.purseMessage(queueName);

        baseObj.info("Step 2: Upload file to SFTP server");
        importAuthService.uploadFileToServer(importAuthService.getListFileUpload(), ImportServices.config.getEnvironment("Default_Upload_folder_SFTP"));

        baseObj.info("Step 3: Check in Oracle Table");
        runTriggerForSpecificService(EVV_IMPORT_AUTH);
        runTriggerForSpecificService(MATCHING_SERVICE);
        String authorizationReferenceNumber = authInfo.getAuthorizationReferenceNumber();
        verifyProviderImportedSuccessWithoutErrorCode(authorizationReferenceNumber);

        baseObj.info("Step 4: Is auth stored in STX without error code");
        Assert.assertFalse(getSTXAuthorization(authorizationReferenceNumber).isEmpty(), "No data is stored in dB");

        baseObj.info("Step 5: Check in Auth Limit Table");
        String authID = getAuthID(authorizationReferenceNumber);
        Assert.assertTrue(isTheAuthorizationExistedInAuthLimitTable(authID), "No data is stored in dB");

        baseObj.info("Step 6: Verify LOC in Auth with the using member");
        for (STXAuthorization recordDb : getSTXAuthorization(authorizationReferenceNumber)) {
            Assert.assertEquals(recordDb.getLOC(), clientInfo.getLOC(), "LOC of client is not matching");
        }
    }
}
