package openevvbatch.auth.generic;

import com.interop.models.db.stx.STXClientAuth;
import com.interop.models.db.stx.STXPayorID;
import com.interop.models.openevv.batch.AuthorizationCSVModel;
import com.interop.services.base.ImportBaseTest;
import com.interop.services.openevv.batch.ImportAuthService;
import com.interop.services.openevv.batch.ImportServices;
import com.interop.common.TestDataHelper;
import com.sandata.qtest.QTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static com.interop.common.constants.utils.TriggerUtils.runTriggerForSpecificService;
import static com.interop.common.constants.utils.TriggerUtils.servicesNeedToTrigger.EVV_IMPORT_AUTH;
import static com.interop.common.constants.utils.TriggerUtils.servicesNeedToTrigger.MATCHING_SERVICE;
import static com.interop.common.constants.utils.db.AuthDBUtils.verifyAuthImportedSuccessWithoutErrorCode;
import static com.interop.common.constants.utils.db.ClientDBUtils.getIDAndMedicaidIDOfMemberHavingSpecificMedicaidID;

public class Auto_SEVV_6955_TC_21998_Validation_Import_Combination_Authorization_ServiceID extends ImportBaseTest {
    ImportAuthService importAuth;
    String combinationServices = "OpenEVV/Auth/Valid_File_EVV_Combination_Services.csv";

    @Test(groups = {"regression"})
    @QTest(keys = {"TC-22397"})
    public void Import_Base_Auth_AZ_With_Valid_Combination_Authorization_ServiceID() throws Exception {
        importAuth = new ImportAuthService();
        String comment = commons.generateRandomStringOfFixLength(20);
        List<STXPayorID> listCombinationService = TestDataHelper.getListPayerIDCombinationDataRows(stateAccount.getStateName(), combinationServices);
        STXClientAuth clientAuth = getIDAndMedicaidIDOfMemberHavingSpecificMedicaidID(stateAccount, 10).get(0);
        baseObj.info("Step 1: Prepare data");
        importAuth.generateFileWithMultipleLine(listCombinationService.size());
        List<AuthorizationCSVModel> lstAuthInfo = new ArrayList<>();
        for (int i = 0; i < listCombinationService.size(); i++) {
            baseObj.info(String.format("Prepare Data for line %s", i));
            AuthorizationCSVModel auth = new AuthorizationCSVModel();
            String authRefNum = commons.generateRandomAlphaNumeric(23);
            auth.setAuthorizationReferenceNumber(authRefNum);
            auth.setAuthorizationComments(comment);
            auth.setPayerID(listCombinationService.get(i).PAYOR_ID);
            auth.setAuthorizationServiceID(listCombinationService.get(i).PROC_CODE);
            auth.setPayerProgram(listCombinationService.get(i).PROGRAM);
            auth.setClientIdentifier(clientAuth.getMEDICAID_ID());
            auth.setModifier1(listCombinationService.get(i).MODIFIER1);
            auth.setModifier2(listCombinationService.get(i).MODIFIER2);
            auth.setModifier3(listCombinationService.get(i).MODIFIER3);
            auth.setModifier4(listCombinationService.get(i).MODIFIER4);
            auth.setProviderID(stateAccount.getProviderID());
            lstAuthInfo.add(auth);
        }
        baseObj.info("Step 1: Prepare data to import");
        importAuth.initFileImportAuthAndOutboundWithCustomData(lstAuthInfo);

        baseObj.info("Step 2: Upload file to SFTP server");
        importAuth.uploadFileToServer(importAuth.getListFileUpload(), ImportServices.config.getEnvironment("Default_Upload_folder_SFTP"));

        baseObj.info("Step 3: Check in Oracle Table");
        runTriggerForSpecificService(EVV_IMPORT_AUTH);
        runTriggerForSpecificService(MATCHING_SERVICE);
        verifyAuthImportedSuccessWithoutErrorCode(comment, listCombinationService.size());
    }
}