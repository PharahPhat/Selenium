package openevv.pennsylvania.authstaging;

import com.interop.models.db.staging.StagingAuth;
import com.interop.services.openevv.OpenEVVAuthStagingService;
import com.interop.services.openevv.batch.ImportAuthService;
import generic.GenericTest;
import io.qameta.allure.Description;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import static com.interop.common.constants.utils.db.AuthDBUtils.getStagingAuthorization;

public class Auto_SEVV_18437_TC_21174_REST_API_Auth_PA_Handle_ICD10_Missing_Decimal extends GenericTest {
    final String dxCodeField = "$.DiagnosisCode[0].ClientDiagnosisCode";
    final String authRefNumField = "$.AuthorizationReferenceNumber";

    @Test()
    @Description("case_DXCODE_HAS_10_CHARACTERS")
    public void case_DXCODE_HAS_10_CHARACTERS() throws IllegalAccessException, InvocationTargetException, InstantiationException {
        baseObj.info("Prepare a payload with specific DX code");
        String authRefNumValue = new ImportAuthService().generateAuthRefNumber();
        String dxCodeValue = RandomStringUtils.randomNumeric(10);

        OpenEVVAuthStagingService authStagingAPI = OpenEVVAuthStagingService.init();
        authStagingAPI.modifyPropertyValue(dxCodeField, "String", dxCodeValue);
        authStagingAPI.modifyPropertyValue(authRefNumField, "String", authRefNumValue);

        baseObj.info("Step 2: Send Post Request");
        authStagingAPI.post();
        authStagingAPI.verifyPostStatus("SUCCESS");

        baseObj.info("Step 3: Send GET Request");
        authStagingAPI.requestUUIDStatus();
        authStagingAPI.verifyUUIDStatus("FAILED");
        authStagingAPI.verifyErrorMessage("ERROR: The ClientDiagnosisCode value is incorrect. The record should satisfy ICD-10 format.");

        baseObj.info("Step 4: Verify Staging DB");
        List<StagingAuth> stagingAuth = getStagingAuthorization(authRefNumValue);
        Assert.assertEquals(stagingAuth.get(0).getDx_code(), dxCodeValue);
        Assert.assertEquals(stagingAuth.get(0).getStatus_code(), "-2");
        Assert.assertTrue(stagingAuth.get(0).getStatus_memo().toString().contains("ERROR: The ClientDiagnosisCode value is incorrect. The record should satisfy ICD-10 format."));
    }

    @Test()
    @Description("case_DXCODE_HAS_3_CHARACTERS")
    public void case_DXCODE_HAS_3_CHARACTERS() throws IllegalAccessException, InvocationTargetException, InstantiationException {
        baseObj.info("Prepare a payload with specific DX code");
        String authRefNumValue = new ImportAuthService().generateAuthRefNumber();
        String dxCodeValue = RandomStringUtils.randomNumeric(3);

        OpenEVVAuthStagingService authStagingAPI = OpenEVVAuthStagingService.init();
        authStagingAPI.modifyPropertyValue(dxCodeField, "String", dxCodeValue);
        authStagingAPI.modifyPropertyValue(authRefNumField, "String", authRefNumValue);

        baseObj.info("Step 2: Send Post Request");
        authStagingAPI.post();
        authStagingAPI.verifyPostStatus("SUCCESS");

        baseObj.info("Step 3: Send GET Request");
        authStagingAPI.requestUUIDStatus();
        authStagingAPI.verifyUUIDStatus("SUCCESS");

        baseObj.info("Step 4: Verify Staging DB");
        List<StagingAuth> stagingAuth = getStagingAuthorization(authRefNumValue);
        Assert.assertEquals(stagingAuth.get(0).getDx_code(), dxCodeValue);
        Assert.assertEquals(stagingAuth.get(0).getStatus_code(), "0");
        Assert.assertEquals(stagingAuth.get(0).getStatus_memo(), "");
    }

    @Test()
    @Description("case_DXCODE_HAS_2_CHARACTERS")
    public void case_DXCODE_HAS_2_CHARACTERS() throws IllegalAccessException, InvocationTargetException, InstantiationException {
        baseObj.info("Prepare a payload with specific DX code");
        String authRefNumValue = new ImportAuthService().generateAuthRefNumber();
        String dxCodeValue = RandomStringUtils.randomNumeric(2);

        OpenEVVAuthStagingService authStagingAPI = OpenEVVAuthStagingService.init();
        authStagingAPI.modifyPropertyValue(dxCodeField, "String", dxCodeValue);
        authStagingAPI.modifyPropertyValue(authRefNumField, "String", authRefNumValue);

        baseObj.info("Step 2: Send Post Request");
        authStagingAPI.post();
        authStagingAPI.verifyPostStatus("SUCCESS");

        baseObj.info("Step 3: Send GET Request");
        authStagingAPI.requestUUIDStatus();
        authStagingAPI.verifyUUIDStatus("SUCCESS");

        baseObj.info("Step 4: Verify Staging DB");
        List<StagingAuth> stagingAuth = getStagingAuthorization(authRefNumValue);
        Assert.assertEquals(stagingAuth.get(0).getDx_code(), dxCodeValue);
        Assert.assertEquals(stagingAuth.get(0).getStatus_code(), "0");
        Assert.assertEquals(stagingAuth.get(0).getStatus_memo(), "");
    }

    @Test()
    @Description("case_DXCODE_HAS_VALUE_W2800")
    public void case_DXCODE_HAS_VALUE_W2800() throws IllegalAccessException, InvocationTargetException, InstantiationException {
        baseObj.info("Prepare a payload with specific DX code");
        String authRefNumValue = new ImportAuthService().generateAuthRefNumber();
        String dxCodeValue = "W2800";

        OpenEVVAuthStagingService authStagingAPI = OpenEVVAuthStagingService.init();
        authStagingAPI.modifyPropertyValue(dxCodeField, "String", dxCodeValue);
        authStagingAPI.modifyPropertyValue(authRefNumField, "String", authRefNumValue);

        baseObj.info("Step 2: Send Post Request");
        authStagingAPI.post();
        authStagingAPI.verifyPostStatus("SUCCESS");

        baseObj.info("Step 3: Send GET Request");
        authStagingAPI.requestUUIDStatus();
        authStagingAPI.verifyUUIDStatus("SUCCESS");

        baseObj.info("Step 4: Verify Staging DB");
        List<StagingAuth> stagingAuth = getStagingAuthorization(authRefNumValue);
        Assert.assertEquals(stagingAuth.get(0).getDx_code(), new ImportAuthService().convertInputtedDXCodeToICD10Standard(dxCodeValue, 3));
        Assert.assertEquals(stagingAuth.get(0).getStatus_code(), "0");
        Assert.assertEquals(stagingAuth.get(0).getStatus_memo(), "");
    }

    @Test()
    @Description("case_DXCODE_ALREADY_HAS_PERIOD")
    public void case_DXCODE_ALREADY_HAS_PERIOD() throws IllegalAccessException, InvocationTargetException, InstantiationException {
        baseObj.info("Prepare a payload with specific DX code");
        String authRefNumValue = new ImportAuthService().generateAuthRefNumber();
        String dxCodeValue = "W28.00";

        OpenEVVAuthStagingService authStagingAPI = OpenEVVAuthStagingService.init();
        authStagingAPI.modifyPropertyValue(dxCodeField, "String", dxCodeValue);
        authStagingAPI.modifyPropertyValue(authRefNumField, "String", authRefNumValue);

        baseObj.info("Step 2: Send Post Request");
        authStagingAPI.post();
        authStagingAPI.verifyPostStatus("SUCCESS");

        baseObj.info("Step 3: Send GET Request");
        authStagingAPI.requestUUIDStatus();
        authStagingAPI.verifyUUIDStatus("SUCCESS");

        baseObj.info("Step 4: Verify Staging DB");
        List<StagingAuth> stagingAuth = getStagingAuthorization(authRefNumValue);
        Assert.assertEquals(stagingAuth.get(0).getDx_code(), dxCodeValue);
        Assert.assertEquals(stagingAuth.get(0).getStatus_code(), "0");
        Assert.assertEquals(stagingAuth.get(0).getStatus_memo(), "");
    }
}
