package openevvbatch.auth.molinak;

import com.interop.models.db.inbox.InboxAuthorization;
import com.interop.models.db.staging.StagingAuth;
import com.interop.models.db.staging.StagingAuthLimit;
import com.interop.models.openevv.batch.AuthorizationCSVModel;
import com.interop.services.base.ImportBaseTest;
import com.interop.services.openevv.batch.ImportAuthService;
import com.interop.services.openevv.batch.ImportServices;
import com.jcraft.jsch.SftpException;
import com.sandata.utilities.sftp.utils.SftpUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import static com.interop.common.constants.utils.db.AuthDBUtils.*;
import static com.interop.common.constants.FieldConstants.MAX_TIME_ATTEMPT;
import static com.sandata.utilities.sftp.utils.SftpUtils.isSftpFileExisted;

public class Auto_SEVV_18559_TC_40770_Full_authorization_for_Generic_ClientQualifier_is_ClientMedicaidID_for_state_differ_from_PA extends ImportBaseTest {
    ImportAuthService importAuthService;

    @Test(groups = {"non-regression"})
    public void TC_40770_Full_authorization_for_Generic_ClientQualifier_is_ClientMedicaidID_for_state_differ_from_PA() throws IOException, InterruptedException, SftpException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        importAuthService = new ImportAuthService();

        String authRefNum = importAuthService.generateAuthRefNumber();
        List<AuthorizationCSVModel> lstAuthInfo = new ArrayList<>();
        AuthorizationCSVModel authInfo = new AuthorizationCSVModel();
        authInfo.setClientIdentifier("01066666101");
        authInfo.setClientQualifier("ClientMedicaidID");
        authInfo.setAuthorizationReferenceNumber(authRefNum);
        authInfo.setProviderID(ImportServices.config.getEnvironment("providerID"));
        authInfo.setClientDiagnosisCode("A75");
        authInfo.setAuthorizationEndDate("2020-01-01");
        authInfo.setAuthorizationStartDate("2019-01-01");
        authInfo.setClientDiagnosisCodeBeginDate("2020-01-01");
        authInfo.setClientDiagnosisCodeEndDate("2019-01-01");
        authInfo.setPayerID("MEDHHS");
        authInfo.setPayerProgram("40");
        authInfo.setAuthorizationServiceID("G0152");
        lstAuthInfo.add(authInfo);

        baseObj.info("Step 1: Prepare data to import");
        importAuthService.initFileImportAuthAndOutboundWithCustomData(lstAuthInfo);

        baseObj.info("Step 2: Upload file to SFTP");
        importAuthService.uploadFileToServer(importAuthService.getListFileUpload(), ImportServices.config.getEnvironment("Default_Upload_folder_SFTP"));
        String errorFile = importAuthService.generateErrorFileName(ImportServices.ImportType.AUTHORIZATION.getFileType(), importAuthService.getListFileUpload());

        baseObj.info("Step 4: Verify in staging DB");
        baseObj.sleep(5000);
        List<StagingAuth> authRecordsStaging = getStagingAuthorization(authRefNum);

        baseObj.info("Step 4.1: Verify in staging DB Auth");
        String tranGUID = null;
        for (StagingAuth authRecordStaging : authRecordsStaging) {
            tranGUID = authRecordStaging.getAccount_intf_trans_guid().toString();
            AuthorizationCSVModel line = (AuthorizationCSVModel) importAuthService.getRecords().get(0);
            Assert.assertEquals(authRecordStaging.getDx_code(), line.getClientDiagnosisCode());
            Assert.assertEquals(authRecordStaging.getDx_code_prmy_ind(), line.getClientDiagnosisCodeIsPrimary());
        }

        baseObj.info("Step 4.2: Verify in staging DB Auth Limit");
        List<StagingAuthLimit> authLimitRecords = getStagingAuthLimit(tranGUID);
        int numberRecordsInDB = 0;
        for (StagingAuthLimit authLimitRecord : authLimitRecords) {
            for (Object csvLine : importAuthService.getRecords()) {
                AuthorizationCSVModel line = (AuthorizationCSVModel) csvLine;
                if (line.getAuthorizationServiceID().equalsIgnoreCase(authLimitRecord.getService().toString())) {
                    numberRecordsInDB++;
                }
            }
        }
        Assert.assertEquals(numberRecordsInDB, 1);

        baseObj.info("Step 5: Verify ERROR CODE in INBOX EVV");
        List<InboxAuthorization> authRecords = getInboxAuthorization(authRefNum);
        for (InboxAuthorization record : authRecords) {
            Assert.assertEquals(record.getERROR_CODE(), "0 Operation success");
        }

    }

    @Test(groups = {"non-regression"})
    public void Auto_SEVV_18559_TC_40770_Full_authorization_for_Generic_ClientQualifier_is_invalid_for_state_differ_from_PA() throws Exception {
        importAuthService = new ImportAuthService();
        String authRefNum = importAuthService.generateAuthRefNumber();
        List<AuthorizationCSVModel> lstAuthInfo = new ArrayList<>();
        AuthorizationCSVModel authInfo = new AuthorizationCSVModel();
        authInfo.setClientIdentifier("01066666101");
        authInfo.setClientQualifier("ClientMedicaidID");
        authInfo.setAuthorizationReferenceNumber(authRefNum);
        authInfo.setProviderID(ImportServices.config.getEnvironment("providerID"));
        authInfo.setClientDiagnosisCode("A75");
        authInfo.setAuthorizationEndDate("2020-01-01");
        authInfo.setAuthorizationStartDate("2019-01-01");
        authInfo.setClientDiagnosisCodeBeginDate("2020-01-01");
        authInfo.setClientDiagnosisCodeEndDate("2019-01-01");
        authInfo.setPayerID("MEDHHS");
        authInfo.setPayerProgram("40");
        authInfo.setAuthorizationServiceID("G0152");
        lstAuthInfo.add(authInfo);

        baseObj.info("Step 1: Prepare data to import");
        importAuthService.initFileImportAuthAndOutboundWithCustomData(lstAuthInfo);

        baseObj.info("Step 2: Upload file to SFTP");
        importAuthService.uploadFileToServer(importAuthService.getListFileUpload(), ImportServices.config.getEnvironment("Default_Upload_folder_SFTP"));
        String errorFile = importAuthService.generateErrorFileName(ImportServices.ImportType.AUTHORIZATION.getFileType(), importAuthService.getListFileUpload());

        baseObj.info("Step 3: Download Error file");
        Assert.assertTrue(isSftpFileExisted(ImportServices.config.getEnvironment("Default_folder_Get_Error_SFTP") + errorFile, MAX_TIME_ATTEMPT));
        importAuthService.downloadSpecificFileFromSFTPForOpenEVV(errorFile, SftpUtils.FileType.ZIP);

        baseObj.info("Step 5: Verify Error Code in file error with the expectation");
        ImportServices.verifyErrorMessageForTheSingleRecord("The ClientQualifier format is incorrect. The record should satisfy this regular expression ['ClientSSN|ClientOtherID|ClientCustomID|ClientMedicaidID']", errorFile);
    }
}
