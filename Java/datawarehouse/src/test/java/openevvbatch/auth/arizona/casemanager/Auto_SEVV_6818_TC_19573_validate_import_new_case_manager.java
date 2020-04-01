/**
        * account:
        * dev: AZ_CM, HI_CM, PA_68611
        * qa: AZ_AMP_WS, HI_AMP_WS
 */
package openevvbatch.auth.arizona.casemanager;

import com.interop.common.constants.utils.RabbitMQUtils;
import com.interop.models.db.inbox.InboxAppUser;
import com.interop.models.db.inbox.InboxAuthorization;
import com.interop.models.db.staging.StagingAuth;
import com.interop.models.db.stx.STXAppUser;
import com.interop.models.db.stx.STXAppUserCLI;
import com.interop.models.db.stx.STXClientAuth;
import com.interop.models.openevv.batch.AuthorizationCSVModel;
import com.interop.models.openevv.authorization.OpenEvvAuthorization;
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
import java.util.Map;
import java.util.concurrent.TimeoutException;

import static com.interop.common.constants.utils.db.AppUserDBUtils.*;
import static com.interop.common.constants.utils.db.AuthDBUtils.getInboxAuthorization;
import static com.interop.common.constants.utils.db.AuthDBUtils.getStagingAuthorization;
import static com.interop.common.constants.utils.db.ClientDBUtils.getIDAndMedicaidIDOfMemberHavingSpecificMedicaidID;
import static com.interop.common.constants.utils.db.ClientDBUtils.getMedicaidID;

public class Auto_SEVV_6818_TC_19573_validate_import_new_case_manager extends ImportBaseTest {
    ImportAuthService importAuthService;

    @Test(groups = {"non-regression"}) //passed
    @QTest(keys = {"TC-21754"})
    public void Auto_SEVV_6818_TC_19573_validate_import_new_case_manager() throws IOException, InterruptedException, SftpException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchAlgorithmException, KeyManagementException, URISyntaxException, TimeoutException {
        final String queueName = "QAAutomation";
        importAuthService = new ImportAuthService();
        String authRefNum = importAuthService.generateAuthRefNumber();
        STXClientAuth clientInfo = getIDAndMedicaidIDOfMemberHavingSpecificMedicaidID(stateAccount, 9).get(0);

        List<AuthorizationCSVModel> lstAuthInfo = new ArrayList<>();
        AuthorizationCSVModel authInfo = new AuthorizationCSVModel();
        authInfo.setClientIdentifier(clientInfo.getMEDICAID_ID());
        authInfo.setAuthorizationReferenceNumber(authRefNum);
        authInfo.setProviderID(clientInfo.getPROVIDER_ID());
        authInfo.setPayerID(stateAccount.getPayerId());
        authInfo.setPayerProgram(stateAccount.getDefaultPayerProgram());
        authInfo.setAuthorizationServiceID(stateAccount.getDefaultProcedureCode());
        authInfo.setPayerRegion("01");
        authInfo.setCaseManagerFirstName(baseObj.generateRandomString(10));
        authInfo.setCaseManagerLastName(baseObj.generateRandomString(10));
        authInfo.setCaseManagerEmail(baseObj.generateRandomNumberObsolete(7) + "@email.com");
        lstAuthInfo.add(authInfo);

        baseObj.info("Step 1: Prepare data to import");
        importAuthService.initFileImportAuthAndOutboundWithCustomData(lstAuthInfo);

        baseObj.info("Step 2: Upload file to SFTP");
        RabbitMQUtils.purseMessage(queueName);//Purse the message on rabbitMQ to avoid trash data
        importAuthService.uploadFileToServer(importAuthService.getListFileUpload(), ImportServices.config.getEnvironment("Default_Upload_folder_SFTP"));

        baseObj.info("Step 3: Validate rabbit mq");
        baseObj.sleep(60000);
        List<String> listMessages = RabbitMQUtils.getMessagesFromQueue(queueName);
        OpenEvvAuthorization bodyOnRabbitMQ = RabbitMQUtils.parseSpecificMessageOnQueueToModel(listMessages, OpenEvvAuthorization.class, authRefNum);
        Assert.assertTrue(bodyOnRabbitMQ.getCaseManagerEmail().equalsIgnoreCase(authInfo.getCaseManagerEmail()));

        baseObj.info("Step 4: Verify in staging DB");
        baseObj.sleep(120000);
        List<StagingAuth> authRecordsStaging = getStagingAuthorization(authRefNum);

        baseObj.info("Step 5: Verify in staging DB Auth");
        Assert.assertTrue(authRecordsStaging.size()>0);
        for (StagingAuth authRecordStaging : authRecordsStaging) {
            AuthorizationCSVModel line = (AuthorizationCSVModel) importAuthService.getRecords().get(0);
            Assert.assertEquals(line.caseManagerFirstName, authRecordStaging.getCase_manager_f_name());
            Assert.assertEquals(line.caseManagerLastName, authRecordStaging.getCase_manager_l_name());
            Assert.assertEquals(line.caseManagerEmail, authRecordStaging.getCase_manager_e_mail());
        }
        baseObj.info("Step 6: Verify ERROR CODE in INBOX EVV");
        baseObj.sleep(60000);
        List<InboxAuthorization> authRecords = getInboxAuthorization(authRefNum);
        Assert.assertTrue(authRecords.size() > 0);
        for (InboxAuthorization record : authRecords) {
            Assert.assertEquals(record.getERROR_CODE(), "0 Operation success");
        }
        baseObj.info("Step 7: Verify ERROR CODE in INBOX.APP_USERS EVV");
        List<InboxAppUser> appUsers = getInboxAppUser(authInfo.getCaseManagerEmail());
        Assert.assertTrue(appUsers.size() > 0);
        for (InboxAppUser appUser : appUsers) {
            baseObj.info("error code of case manager in app user table is: " + appUser.getERROR_CODE());
            Assert.assertEquals(appUser.getERROR_CODE().toString(), "0");
        }

        baseObj.info("Step 8: Verify CM in STX.APP_USERS EVV");
        baseObj.sleep(30000);
        List<STXAppUser> stxAppUsers = getAppUser("9999", authInfo.getCaseManagerEmail());
        Assert.assertTrue(stxAppUsers.size() > 0);
        for (STXAppUser stxAppUser : stxAppUsers) {
            Assert.assertEquals(stxAppUser.getDELETED(), null);
            Assert.assertEquals(stxAppUser.getACCOUNT(), "9999");
            Assert.assertEquals(stxAppUser.getACCOUNT_STATUS(), "OPEN");
        }

        baseObj.info("Step 9: Verify STX.APP_USERS_CLI");
        List<STXAppUserCLI> stxAppUserCLIS = getSTXAppUserCLI(authInfo.getCaseManagerEmail());
        for (STXAppUserCLI stxAppUserCLI : stxAppUserCLIS) {
            Assert.assertEquals(stxAppUserCLI.getLOC(), clientInfo.getLOC());
        }

        baseObj.info("VERIFY POINT: UPDATE ABOVE CLIENT WITH NEW CM AND TERMINATE OLD CM");
        baseObj.info("Step 10: Update case manager for above client");
        lstAuthInfo.clear();

        AuthorizationCSVModel authInfo2 = new AuthorizationCSVModel();
        authInfo2.setClientIdentifier(authInfo.getClientIdentifier());
        authInfo2.setAuthorizationReferenceNumber(authRefNum);
        authInfo2.setProviderID(clientInfo.getPROVIDER_ID());
        authInfo2.setCaseManagerFirstName(baseObj.generateRandomString(10));
        authInfo2.setCaseManagerLastName(baseObj.generateRandomString(10));
        authInfo2.setCaseManagerEmail(baseObj.generateRandomNumberObsolete(7) + "@email.com");
        authInfo2.setPayerID(stateAccount.getPayerId());
        authInfo2.setPayerProgram(stateAccount.getDefaultPayerProgram());
        authInfo2.setAuthorizationServiceID(stateAccount.getDefaultProcedureCode());
        authInfo2.setPayerRegion("01");
        lstAuthInfo.add(authInfo2);

        baseObj.info("Step 10.1: Prepare data to import");
        ImportAuthService importAuthService2 = new ImportAuthService();
        importAuthService2.initFileImportAuthAndOutboundWithCustomData(lstAuthInfo); // should init new import service instance

        baseObj.info("Step 11: Upload file to SFTP");
        importAuthService2.uploadFileToServer(importAuthService2.getListFileUpload(), ImportServices.config.getEnvironment("Default_Upload_folder_SFTP"));

        baseObj.info("Step 12: Verify ERROR CODE in INBOX.APP_USERS EVV");
        baseObj.sleep(120000);
        List<InboxAppUser> appUsers2 = getInboxAppUser(authInfo2.getCaseManagerEmail());
        Assert.assertTrue(appUsers2.size() > 0);
        for (InboxAppUser appUser2 : appUsers2) {
            Assert.assertTrue(appUsers2.size() > 0);
            baseObj.info("error code of case manager in app user table is: " + appUser2.getERROR_CODE());
            Assert.assertEquals(appUser2.getERROR_CODE().toString(), "0");
        }

        baseObj.info("Step 13: Verify old CM in STX.APP_USERS EVV is terminated");
        List<STXAppUser> stxAppUsers2 = getAppUser("9999", authInfo.getCaseManagerEmail());
        for (STXAppUser stxAppUser2 : stxAppUsers2) {
            Assert.assertTrue(stxAppUser2.getDELETED() != null);
        }
    }

    @Test
    public void Auto_SEVV_6818_TC_19573_validate_import_multiple_case_manager() throws IOException, InterruptedException, SftpException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchAlgorithmException, KeyManagementException, URISyntaxException, TimeoutException, NoSuchFieldException, SQLException {
        final String queueName = "QAAutomation";
        importAuthService = new ImportAuthService();

        importAuthService.generateFileWithMultipleLine(2);
        List<AuthorizationCSVModel> lstAuthInfo = new ArrayList<>();
        for (int i = 0; i < importAuthService.getRecords().size(); i++) {
            STXClientAuth clientInfo = getIDAndMedicaidIDOfMemberHavingSpecificMedicaidID(stateAccount, 9).get(0);

            AuthorizationCSVModel authInfo = new AuthorizationCSVModel();
            authInfo.setClientIdentifier(clientInfo.getMEDICAID_ID());
            authInfo.setAuthorizationReferenceNumber("AUTO" + baseObj.generateRandomNumberObsolete(7));
            authInfo.setProviderID(clientInfo.getPROVIDER_ID());
            authInfo.setCaseManagerFirstName(baseObj.generateRandomString(10));
            authInfo.setCaseManagerLastName(baseObj.generateRandomString(10));
            authInfo.setCaseManagerEmail(baseObj.generateRandomNumberObsolete(7) + "@email.com");
            authInfo.setPayerID(stateAccount.getDefaultPayerID());
            authInfo.setPayerProgram(stateAccount.getDefaultPayerProgram());
            authInfo.setAuthorizationServiceID(stateAccount.getDefaultProcedureCode());
            authInfo.setPayerRegion("01");
            lstAuthInfo.add(authInfo);
        }

        baseObj.info("Step 1: Prepare data to import");
        importAuthService.initFileImportAuthAndOutboundWithCustomData(lstAuthInfo);

        baseObj.info("Step 2: Upload file to SFTP");
        RabbitMQUtils.purseMessage(queueName);//Purse the message on rabbitMQ to avoid trash data
        importAuthService.uploadFileToServer(importAuthService.getListFileUpload(), ImportServices.config.getEnvironment("Default_Upload_folder_SFTP"));

        baseObj.info("Step 3: Verify only one case manager is associated with client");
        baseObj.sleep(120000);
        List<STXAppUser> stxAppUsers = getCaseManager(lstAuthInfo.get(0).caseManagerEmail);
        List<STXAppUser> stxAppUsers2 = getCaseManager(lstAuthInfo.get(1).caseManagerEmail);
        switch (stateAccount.getStateName()){
            case "Pennsylvania":
                Assert.assertTrue((stxAppUsers.get(0).DELETED!=null&&stxAppUsers2.get(0).DELETED==null)||(stxAppUsers.get(0).DELETED==null&&stxAppUsers2.get(0).DELETED!=null));
                break;
             default:
                 Assert.assertTrue((stxAppUsers.get(0).DELETED==null&&stxAppUsers2.get(0).DELETED==null));

        }
    }

    @Test(groups = {"batch","fixing"})//passed
    public void Auto_SEVV_6818_TC_19573_validate_import_new_case_manager_with_multi_client() throws IOException, InterruptedException, SftpException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchAlgorithmException, KeyManagementException, URISyntaxException, TimeoutException, NoSuchFieldException, SQLException {
        final String queueName = "QAAutomation";
        importAuthService = new ImportAuthService();

        final String caseMangerEmail = baseObj.generateRandomNumberObsolete(7) + "@email.com";
        final String casmangerFirstname = baseObj.generateRandomString(10);
        final String casmangerLastname = baseObj.generateRandomString(10);
        final String caseMangerEmail2 = baseObj.generateRandomNumberObsolete(7) + "@email.com";


        baseObj.info("Step 1: Prepare to import case manger with email : " + caseMangerEmail);
        List<Map<String, String>> clientInfo = getMedicaidID(stateAccount);

        importAuthService.generateFileWithMultipleLine(2);
        List<AuthorizationCSVModel> lstAuthInfo = new ArrayList<>();
        for (int i = 0; i < importAuthService.getRecords().size(); i++) {
            AuthorizationCSVModel authInfo = new AuthorizationCSVModel();
            authInfo.setClientIdentifier(clientInfo.get(i).get("MedicaidID"));
            authInfo.setAuthorizationReferenceNumber("AUTO" + baseObj.generateRandomNumberObsolete(7));
            authInfo.setProviderID(clientInfo.get(i).get("ProviderID"));
            authInfo.setCaseManagerFirstName(casmangerFirstname);
            authInfo.setCaseManagerLastName(casmangerLastname);
            authInfo.setCaseManagerEmail(caseMangerEmail);
            authInfo.setPayerID(stateAccount.getDefaultPayerID());
            authInfo.setPayerProgram(stateAccount.getDefaultPayerProgram());
            authInfo.setAuthorizationServiceID(stateAccount.getDefaultProcedureCode());
            authInfo.setPayerRegion("01");
            lstAuthInfo.add(authInfo);
        }

        baseObj.info("Step 2: Prepare data to import");
        importAuthService.initFileImportAuthAndOutboundWithCustomData(lstAuthInfo);

        baseObj.info("Step 3: Upload file to SFTP");
        RabbitMQUtils.purseMessage(queueName);//Purse the message on rabbitMQ to avoid trash data
        importAuthService.uploadFileToServer(importAuthService.getListFileUpload(), ImportServices.config.getEnvironment("Default_Upload_folder_SFTP"));

        baseObj.info("Step 4: Verify ERROR CODE in INBOX.APP_USERS EVV");
        baseObj.sleep(60000);
        List<InboxAppUser> appUsers = getInboxAppUser(lstAuthInfo.get(0).getCaseManagerEmail());
        for (InboxAppUser appUser : appUsers) {
            baseObj.info("error code of case manager in app user table is: " + appUser.getERROR_CODE());
            Assert.assertEquals(appUser.getERROR_CODE().toString(), "0");
        }
        baseObj.info("Step 5: Verify CM in STX.APP_USERS EVV");
        baseObj.sleep(30000);
        List<STXAppUser> stxAppUsers = getAppUser("9999", lstAuthInfo.get(0).getCaseManagerEmail());
        Assert.assertTrue(stxAppUsers.size() > 0);
        for (STXAppUser stxAppUser : stxAppUsers) {
            Assert.assertEquals(stxAppUser.getDELETED(), null);
            Assert.assertEquals(stxAppUser.getACCOUNT(), "9999");
            Assert.assertEquals(stxAppUser.getACCOUNT_STATUS(), "OPEN");
        }
        baseObj.info("Step 6: Verify STX.APP_USERS_CLI");
        List<STXAppUserCLI> stxAppUserCLIS = getSTXAppUserCLI(caseMangerEmail);
        baseObj.info("number of records in AUC is : " + stxAppUserCLIS.size());
        Assert.assertEquals(stxAppUserCLIS.size(), lstAuthInfo.size());

        baseObj.info("VERIFY POINT: CASE MANAGER ASSOCIATED WITH AT LEAST ONE CLIENT WILL BE NOT TERMINATED");
        baseObj.info("Step 7: Prepare to update one of above clients with new case manger : " + caseMangerEmail2);
        ImportAuthService importAuthService2 = new ImportAuthService();
        List<AuthorizationCSVModel> lstAuthInfo2 = new ArrayList<>();
        AuthorizationCSVModel authInfo2 = new AuthorizationCSVModel();
        authInfo2.setClientIdentifier(lstAuthInfo.get(0).getClientIdentifier());
        authInfo2.setAuthorizationReferenceNumber("AUTO" + baseObj.generateRandomNumberObsolete(7));
        authInfo2.setProviderID(lstAuthInfo.get(0).getProviderID());
        authInfo2.setCaseManagerFirstName(baseObj.generateRandomString(10));
        authInfo2.setCaseManagerLastName(baseObj.generateRandomString(10));
        authInfo2.setCaseManagerEmail(caseMangerEmail2);
        authInfo2.setPayerID(stateAccount.getDefaultPayerID());
        authInfo2.setPayerProgram(stateAccount.getDefaultPayerProgram());
        authInfo2.setAuthorizationServiceID(stateAccount.getDefaultProcedureCode());
        authInfo2.setPayerRegion("01");
        lstAuthInfo2.add(authInfo2);

        baseObj.info("Step 8: Prepare data to import");
        importAuthService2.initFileImportAuthAndOutboundWithCustomData(lstAuthInfo2);

        baseObj.info("Step 9: Upload file to SFTP");
        RabbitMQUtils.purseMessage(queueName);//Purse the message on rabbitMQ to avoid trash data
        importAuthService2.uploadFileToServer(importAuthService2.getListFileUpload(), ImportServices.config.getEnvironment("Default_Upload_folder_SFTP"));

        baseObj.info("Step 10: Verify ERROR CODE of new CM in INBOX.APP_USERS EVV");
        baseObj.sleep(60000);
        List<InboxAppUser> appUsers2 = getInboxAppUser(lstAuthInfo2.get(0).getCaseManagerEmail());
        Assert.assertTrue(appUsers2.size() > 0);
        for (InboxAppUser appUser : appUsers2) {
            baseObj.info("error code of new case manager in app user table is: " + appUser.getERROR_CODE());
            Assert.assertEquals(appUser.getERROR_CODE().toString(), "0");
        }

        baseObj.info("Step 11: Verify old CM in STX.APP_USERS EVV will be NOT terminated");
        List<STXAppUser> stxAppUsers3 = getAppUser("9999", caseMangerEmail);
        for (STXAppUser stxAppUser : stxAppUsers3) {
            Assert.assertEquals(stxAppUser.getDELETED(), null);
            Assert.assertEquals(stxAppUser.getACCOUNT(), "9999");
            Assert.assertEquals(stxAppUser.getACCOUNT_STATUS(), "OPEN");
        }

        baseObj.info("Step 12: Verify new CM in STX.APP_USERS EVV");
        baseObj.sleep(20000);
        List<STXAppUser> stxAppUsers4 = getAppUser("9999", caseMangerEmail2);
        Assert.assertTrue(stxAppUsers4.size() > 0);
        for (STXAppUser stxAppUser : stxAppUsers4) {
            Assert.assertEquals(stxAppUser.getDELETED(), null);
            Assert.assertEquals(stxAppUser.getACCOUNT(), "9999");
            Assert.assertEquals(stxAppUser.getACCOUNT_STATUS(), "OPEN");
        }

        baseObj.info("Step 13: Verify old CM records decreasing in STX.APP_USERS_CLI will be updated");
        List<STXAppUserCLI> stxAppUserCLIS2 = getSTXAppUserCLI(caseMangerEmail);
        switch (stateAccount.getStateName()){
            case "Pennsylvania":
                Assert.assertEquals(stxAppUserCLIS2.size(), lstAuthInfo.size() - 1);
                break;
            default:
                Assert.assertEquals(stxAppUserCLIS2.size(), lstAuthInfo.size());
        }

        baseObj.info("Step 14: Verify new CM in STX.APP_USERS_CLI ");
        List<STXAppUserCLI> stxAppUserCLIS3 = getSTXAppUserCLI(caseMangerEmail2);
        Assert.assertEquals(stxAppUserCLIS3.size(), lstAuthInfo2.size());
    }
}
