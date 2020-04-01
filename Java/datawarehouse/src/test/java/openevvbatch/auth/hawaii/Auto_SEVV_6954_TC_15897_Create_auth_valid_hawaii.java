package openevvbatch.auth.hawaii;

import com.interop.common.TestDataHelper;
import com.interop.models.db.stx.STXAuthorization;
import com.interop.models.db.stx.STXClientAuth;
import com.interop.models.db.stx.STXPayorID;
import com.interop.models.openevv.batch.AuthorizationCSVModel;
import com.interop.services.base.ImportBaseTest;
import com.interop.services.openevv.batch.ImportAuthService;
import com.interop.services.openevv.batch.ImportServices;
import com.jcraft.jsch.SftpException;
import com.sandata.qtest.QTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

import static com.interop.common.constants.utils.TriggerUtils.runTriggerForSpecificService;
import static com.interop.common.constants.utils.TriggerUtils.servicesNeedToTrigger.EVV_IMPORT_AUTH;
import static com.interop.common.constants.utils.TriggerUtils.servicesNeedToTrigger.MATCHING_SERVICE;
import static com.interop.common.constants.utils.db.AuthDBUtils.*;
import static com.interop.common.constants.utils.db.ClientDBUtils.getIDAndMedicaidIDOfMemberHavingSpecificMedicaidID;

public class Auto_SEVV_6954_TC_15897_Create_auth_valid_hawaii extends ImportBaseTest {
    ImportAuthService importAuthService;

    @Test(groups = {"regression"})
    @QTest()
    public void Auto_SEVV_6954_TC_15897_Create_auth_valid_hawaii() throws IOException, InterruptedException, SftpException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchAlgorithmException, KeyManagementException, URISyntaxException, TimeoutException, NoSuchFieldException, SQLException {
        STXClientAuth clientInfo = getIDAndMedicaidIDOfMemberHavingSpecificMedicaidID(stateAccount, 10).get(0);
        importAuthService = new ImportAuthService();
        String authRefNum = importAuthService.generateAuthRefNumber();
        //TODO REMOVE AUTH LIMIT TYPE HEADER
        List<String> modifiedHeader = importAuthService.getCsvHeaders();
        importAuthService.setCsvHeaders(modifiedHeader);
        List<STXPayorID>listCombinationService = TestDataHelper.getListAuthorizationServicesIDCombination();

        List<AuthorizationCSVModel> lstAuthInfo = new ArrayList<>();
        AuthorizationCSVModel authInfo = new AuthorizationCSVModel();
        authInfo.setClientIdentifier(clientInfo.getMEDICAID_ID());
        authInfo.setAuthorizationReferenceNumber(authRefNum);
        authInfo.setProviderID(clientInfo.getPROVIDER_ID());
        authInfo.setPayerID(listCombinationService.get(0).PAYOR_ID);
        authInfo.setPayerProgram(listCombinationService.get(0).PROGRAM);
        authInfo.setAuthorizationServiceID(listCombinationService.get(0).PROC_CODE);
        authInfo.setModifier1(listCombinationService.get(0).MODIFIER1);
        authInfo.setModifier2(listCombinationService.get(0).MODIFIER2);
        authInfo.setModifier3(listCombinationService.get(0).MODIFIER3);
        authInfo.setModifier4(listCombinationService.get(0).MODIFIER4);
        authInfo.setAuthorizationLimitType("N");
        authInfo.setAuthorizationLimit("12344");
        authInfo.setPayerRegion("01");
        authInfo.setClientDiagnosisCodeBeginDate("2020-01-01");
        authInfo.setClientDiagnosisCodeEndDate("2021-01-01");
        authInfo.setAuthorizationStartDate("2020-01-01");
        authInfo.setAuthorizationEndDate("2021-01-01");
        authInfo.setHFAAssessmentDate("2021-01-01");
        lstAuthInfo.add(authInfo);

        baseObj.info("Step 1: Prepare test data");
        importAuthService.initFileImportAuthAndOutboundWithCustomData(lstAuthInfo);

        baseObj.info("Step 2: Upload file to SFTP server");
        importAuthService.uploadFileToServer(importAuthService.getListFileUpload(), ImportServices.config.getEnvironment("Default_Upload_folder_SFTP"));

        baseObj.info("Step 3: Check in Oracle Table");
        runTriggerForSpecificService(EVV_IMPORT_AUTH);
        runTriggerForSpecificService(MATCHING_SERVICE);
        String authorizationReferenceNumber = authInfo.getAuthorizationReferenceNumber();
        verifyProviderImportedSuccessWithoutErrorCode(authorizationReferenceNumber);

        baseObj.info("Step 4: Is auth stored in STX without error code");
        boolean isDataExisted = getSTXAuthorization(authorizationReferenceNumber).isEmpty();
        Assert.assertFalse(isDataExisted, "No data is stored in dB");

        baseObj.info("Step 5: Check in Auth Limit Table");
        String authID = getAuthID(authorizationReferenceNumber);
        isDataExisted = isTheAuthorizationExistedInAuthLimitTable(authID);
        Assert.assertTrue(isDataExisted, "No data is stored in dB");

        baseObj.info("Step 6: Verify LOC in Auth with the using member");
        for (STXAuthorization recordDb : getSTXAuthorization(authorizationReferenceNumber)) {
            Assert.assertEquals(recordDb.getLOC(), clientInfo.getLOC(), "LOC of client is not matching");
        }
    }
}
