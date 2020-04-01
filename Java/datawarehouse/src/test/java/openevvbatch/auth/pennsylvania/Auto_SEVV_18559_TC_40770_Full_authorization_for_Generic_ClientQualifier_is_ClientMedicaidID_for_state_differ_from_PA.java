package openevvbatch.auth.pennsylvania;

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

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.interop.common.constants.Constant.DOWNLOADED_FILES;
import static com.interop.common.constants.utils.ZipFileUtils.unzip;
import static com.interop.common.constants.utils.db.AuthDBUtils.*;
import static com.sandata.utilities.sftp.utils.SftpUtils.*;

public class Auto_SEVV_18559_TC_40770_Full_authorization_for_Generic_ClientQualifier_is_ClientMedicaidID_for_state_differ_from_PA extends ImportBaseTest {
    ImportAuthService importAuthService;

    @Test(groups = {"non-regression"})
    public void Auto_SEVV_18559_TC_40770_Full_authorization_for_Generic_ClientQualifier_is_ClientMedicaidID_for_state_differ_from_PA() throws IOException, InterruptedException, SftpException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        importAuthService = new ImportAuthService();

        String authRefNum = importAuthService.generateAuthRefNumber();
        setDstPath(ImportServices.config.getEnvironment("Default_Upload_folder_SFTP"));
        setToInboxPath(ImportServices.config.getEnvironment("Default_folder_Get_Error_SFTP"));

        importAuthService.generateFileWithMultipleLine(1);
        List<Map<Field, String>> lstAuthInfo = new ArrayList<>();
        for (int i = 0; i < importAuthService.getRecords().size(); i++) {
            Map<Field, String> authInfo = new HashMap<>();
            authInfo.put(AuthorizationCSVModel.class.getField("clientIdentifier"), "01066666101");
            authInfo.put(AuthorizationCSVModel.class.getField("clientQualifier"), "ClientMedicaidID");
            authInfo.put(AuthorizationCSVModel.class.getField("authorizationReferenceNumber"), authRefNum);
            authInfo.put(AuthorizationCSVModel.class.getField("providerId"), ImportServices.config.getEnvironment("providerID"));
            authInfo.put(AuthorizationCSVModel.class.getField("clientDiagnosisCode"), "A75");
            authInfo.put(AuthorizationCSVModel.class.getField("authorizationEndDate"), "2020-01-01");
            authInfo.put(AuthorizationCSVModel.class.getField("authorizationStartDate"), "2019-01-01");
            authInfo.put(AuthorizationCSVModel.class.getField("clientDiagnosisCodeBeginDate"), "2020-01-01");
            authInfo.put(AuthorizationCSVModel.class.getField("clientDiagnosisCodeEndDate"), "2019-01-01");
            authInfo.put(AuthorizationCSVModel.class.getField("payerId"), "MEDHHS");
            authInfo.put(AuthorizationCSVModel.class.getField("payerProgram"), "40");
            authInfo.put(AuthorizationCSVModel.class.getField("authorizationServiceID"), "G0152");

            lstAuthInfo.add(authInfo);
        }
        baseObj.info("Step 1: Prepare data to import");
        importAuthService.initFileImportAuthAndOutboundWithCustomData(lstAuthInfo);

        baseObj.info("Step 2: Upload file to SFTP");
        for (File file : importAuthService.getListFileUpload()) {
            sftpSendFile(file.getPath(), getDstPath());
        }

        baseObj.sleep(60000);
        baseObj.info("Step 4: Verify in staging DB");
//        runTriggerForSpecificService(MATCHING_SERVICE, 28000);//Run trigger to make the service import auth run first
        List<StagingAuth> authRecordsStaging = getStagingAuthorization(authRefNum);

        baseObj.info("Step 4.1: Verify in staging DB Auth");
        String tranGUID = null;
        for (StagingAuth authRecordStaging : authRecordsStaging) {
            tranGUID = authRecordStaging.getAccount_intf_trans_guid().toString();
            AuthorizationCSVModel line = (AuthorizationCSVModel) importAuthService.getRecords().get(0);
            Assert.assertEquals(line.getClientDiagnosisCode(), authRecordStaging.getDx_code());
            Assert.assertEquals(line.getClientDiagnosisCodeIsPrimary(), authRecordStaging.getDx_code_prmy_ind());
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
        setDstPath(ImportServices.config.getEnvironment("Default_Upload_folder_SFTP"));
        setToInboxPath(ImportServices.config.getEnvironment("Default_folder_Get_Error_SFTP"));

        importAuthService.generateFileWithMultipleLine(1);
        List<Map<Field, String>> lstAuthInfo = new ArrayList<>();
        for (int i = 0; i < importAuthService.getRecords().size(); i++) {
            Map<Field, String> authInfo = new HashMap<>();
            authInfo.put(AuthorizationCSVModel.class.getField("clientIdentifier"), "01066666101");
            authInfo.put(AuthorizationCSVModel.class.getField("clientQualifier"), "ClientMedicaidIDD");
            authInfo.put(AuthorizationCSVModel.class.getField("authorizationReferenceNumber"), authRefNum);
            authInfo.put(AuthorizationCSVModel.class.getField("providerId"), ImportServices.config.getEnvironment("providerID"));
            authInfo.put(AuthorizationCSVModel.class.getField("clientDiagnosisCode"), "A75");
            authInfo.put(AuthorizationCSVModel.class.getField("authorizationEndDate"), "2020-01-01");
            authInfo.put(AuthorizationCSVModel.class.getField("authorizationStartDate"), "2019-01-01");
            authInfo.put(AuthorizationCSVModel.class.getField("clientDiagnosisCodeBeginDate"), "2020-01-01");
            authInfo.put(AuthorizationCSVModel.class.getField("clientDiagnosisCodeEndDate"), "2019-01-01");
            authInfo.put(AuthorizationCSVModel.class.getField("payerId"), "MEDHHS");
            authInfo.put(AuthorizationCSVModel.class.getField("payerProgram"), "40");
            authInfo.put(AuthorizationCSVModel.class.getField("authorizationServiceID"), "G0152");

            lstAuthInfo.add(authInfo);
        }
        baseObj.info("Step 1: Prepare data to import");
        importAuthService.initFileImportAuthAndOutboundWithCustomData(lstAuthInfo);

        baseObj.info("Step 2: Upload file to SFTP");
        for (File file : importAuthService.getListFileUpload()) {
            sftpSendFile(file.getPath(), getDstPath());
        }
        String errorFile = importAuthService.generateErrorFileName(ImportServices.ImportType.AUTHORIZATION.getFileType(), importAuthService.getListFileUpload());

        baseObj.sleep(60000);
        baseObj.info("Step 3: Download Error file");
        boolean isFileErrorExisted = isSftpFileExisted(getToInboxPath() + errorFile, 15);
        Assert.assertTrue(isFileErrorExisted);
        getFile(getToInboxPath(), SftpUtils.FileType.ZIP, errorFile, DOWNLOADED_FILES);

        baseObj.info("Step 4: Unzip file downloaded");
        unzip(new File(DOWNLOADED_FILES + errorFile), DOWNLOADED_FILES);

        baseObj.info("Step 5: Verify Error Code in file error with the expectation");
        ImportServices.verifyErrorMessageForTheSingleRecord("The ClientQualifier format is incorrect. The record should satisfy this regular expression ['ClientSSN|ClientOtherID|ClientCustomID|ClientMedicaidID']", errorFile);

    }

}
