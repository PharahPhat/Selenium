/**
 * account: AZ_CM, HI_CM
 */
package openevvbatch.auth.arizona.casemanager;

import com.interop.common.constants.utils.RabbitMQUtils;
import com.interop.models.db.inbox.InboxAppUser;
import com.interop.models.db.stx.STXAppUser;
import com.interop.models.db.stx.STXClientAuth;
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

import static com.interop.common.constants.utils.db.AppUserDBUtils.*;
import static com.interop.common.constants.utils.db.ClientDBUtils.getIDAndMedicaidIDOfMemberHavingSpecificMedicaidID;
public class Auto_SEVV_6818_TC_19573_validate_update_case_manager extends ImportBaseTest {
    ImportAuthService importAuthService ;

    @Test()
    @QTest(keys = {"TC-21806"})
    public void Auto_SEVV_6818_TC_19573_validate_update_email_cm() throws IOException, InterruptedException, SftpException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchAlgorithmException, KeyManagementException, URISyntaxException, TimeoutException, NoSuchFieldException, SQLException{
        importAuthService = new ImportAuthService();
        final String queueName = "QAAutomation";
        STXAppUser preSTXAppUser = getSTXAppUserCM(stateAccount.getAccountID()).get(0);
        String cmEmail = preSTXAppUser.getUSERNAME().toString();
        String cmFirstName = preSTXAppUser.getUSER_F_NAME().toString();
        String cmLastName = preSTXAppUser.getUSER_L_NAME().toString();
        String userID = preSTXAppUser.getUSER_ID().toString();

        STXClientAuth clientInfo = getIDAndMedicaidIDOfMemberHavingSpecificMedicaidID(stateAccount, 9).get(0);

        baseObj.info("Step 1: Modifying email and keep first/last name of CM : " + cmEmail);
        List<AuthorizationCSVModel> lstAuthInfo = new ArrayList<>();
        AuthorizationCSVModel authInfo = new AuthorizationCSVModel();

        authInfo.setClientIdentifier(clientInfo.getMEDICAID_ID());
        authInfo.setAuthorizationReferenceNumber(importAuthService.generateAuthRefNumber());
        authInfo.setProviderID(clientInfo.getPROVIDER_ID());
        authInfo.setCaseManagerFirstName(cmFirstName);
        authInfo.setCaseManagerLastName(cmLastName);
        authInfo.setCaseManagerEmail(baseObj.generateRandomNumberObsolete(7) + "@email.com");
        lstAuthInfo.add(authInfo);

        baseObj.info("Step 2: Prepare data to import");
        importAuthService.initFileImportAuthAndOutboundWithCustomData(lstAuthInfo);

        baseObj.info("Step 3: Upload file to SFTP");
        RabbitMQUtils.purseMessage(queueName);//Purse the message on rabbitMQ to avoid trash data
        importAuthService.uploadFileToServer(importAuthService.getListFileUpload(), ImportServices.config.getEnvironment("Default_Upload_folder_SFTP"));

        baseObj.info("Step 4: Verify ERROR CODE in INBOX.APP_USERS EVV");
        baseObj.sleep(60000);
        List<InboxAppUser> appUsers = getInboxAppUser(authInfo.getCaseManagerEmail());
        for (InboxAppUser appUser : appUsers) {
            baseObj.info("error code of case manager in app user table is: " + appUser.getERROR_CODE());
            Assert.assertEquals(appUser.getERROR_CODE().toString(), "0");
        }
        baseObj.info("Step 5: Verify CM in STX.APP_USERS EVV updated");
        baseObj.sleep(20000);
        List<STXAppUser> stxAppUsers = getSTXAppUserByUserID(userID);
        Assert.assertTrue(stxAppUsers.size()>0);
        for(int i = 0; i < stxAppUsers.size(); i++) {
            STXAppUser stxAppUser = stxAppUsers.get(i);
            Assert.assertEquals(stxAppUser.getDELETED(), null);
            Assert.assertEquals(stxAppUser.getACCOUNT(), "9999");
            Assert.assertEquals(stxAppUser.getACCOUNT_STATUS(), "OPEN");
            Assert.assertEquals(stxAppUser.getUSERNAME(), authInfo.getCaseManagerEmail());
        }
    }
    @Test()
    public void Auto_SEVV_6818_TC_19573_validate_update_first_name() throws IOException, InterruptedException, SftpException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchAlgorithmException, KeyManagementException, URISyntaxException, TimeoutException, NoSuchFieldException, SQLException{
        importAuthService = new ImportAuthService();
        STXAppUser preSTXAppUser = getSTXAppUserCM(stateAccount.getAccountID()).get(0);
        String cmEmail = preSTXAppUser.getUSERNAME().toString();
        String cmLastName = preSTXAppUser.getUSER_L_NAME().toString();
        String userID = preSTXAppUser.getUSER_ID().toString();

        STXClientAuth clientInfo = getIDAndMedicaidIDOfMemberHavingSpecificMedicaidID(stateAccount, 9).get(0);

        baseObj.info("Step 1: Modifying first name and keep email : " + cmEmail);
        List<AuthorizationCSVModel> lstAuthInfo = new ArrayList<>();
        AuthorizationCSVModel authInfo = new AuthorizationCSVModel();

        authInfo.setClientIdentifier(clientInfo.getMEDICAID_ID());
        authInfo.setAuthorizationReferenceNumber(importAuthService.generateAuthRefNumber());
        authInfo.setProviderID(clientInfo.getPROVIDER_ID());
        authInfo.setCaseManagerFirstName(baseObj.generateRandomString(10));
        authInfo.setCaseManagerLastName(cmLastName);
        authInfo.setCaseManagerEmail(cmEmail);
        lstAuthInfo.add(authInfo);

        baseObj.info("Step 2: Prepare data to import");
        importAuthService.initFileImportAuthAndOutboundWithCustomData(lstAuthInfo);

        baseObj.info("Step 3: Upload file to SFTP");
        importAuthService.uploadFileToServer(importAuthService.getListFileUpload(), ImportServices.config.getEnvironment("Default_Upload_folder_SFTP"));

        baseObj.info("Step 4: Verify CM in STX.APP_USERS EVV updated");
        baseObj.sleep(240000);
        List<STXAppUser> stxAppUsers = getSTXAppUserByUserID(userID);
        Assert.assertTrue(stxAppUsers.size()>0);
        for(int i = 0; i < stxAppUsers.size(); i++) {
            STXAppUser stxAppUser = stxAppUsers.get(i);
            Assert.assertEquals(stxAppUser.getUSER_F_NAME(), authInfo.getCaseManagerFirstName());
        }

    }

    @Test()
    public void Auto_SEVV_6818_TC_19573_validate_update_last_name() throws IOException, InterruptedException, SftpException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchAlgorithmException, KeyManagementException, URISyntaxException, TimeoutException, NoSuchFieldException, SQLException{
        importAuthService = new ImportAuthService();
        STXAppUser preSTXAppUser = getSTXAppUserCM(stateAccount.getAccountID()).get(0);
        String cmEmail = preSTXAppUser.getUSERNAME().toString();
        String cmFirstName = preSTXAppUser.getUSER_F_NAME().toString();
        String userID = preSTXAppUser.getUSER_ID().toString();

        STXClientAuth clientInfo = getIDAndMedicaidIDOfMemberHavingSpecificMedicaidID(stateAccount, 9).get(0);

        baseObj.info("Step 1: Modifying first name and keep email : " + cmEmail);
        List<AuthorizationCSVModel> lstAuthInfo = new ArrayList<>();
        AuthorizationCSVModel authInfo = new AuthorizationCSVModel();

        authInfo.setClientIdentifier(clientInfo.getMEDICAID_ID());
        authInfo.setAuthorizationReferenceNumber(importAuthService.generateAuthRefNumber());
        authInfo.setProviderID(clientInfo.getPROVIDER_ID());
        authInfo.setCaseManagerFirstName(cmFirstName);
        authInfo.setCaseManagerLastName(baseObj.generateRandomString(10));
        authInfo.setCaseManagerEmail(cmEmail);
        lstAuthInfo.add(authInfo);

        baseObj.info("Step 2: Prepare data to import");
        importAuthService.initFileImportAuthAndOutboundWithCustomData(lstAuthInfo);

        baseObj.info("Step 3: Upload file to SFTP");
        importAuthService.uploadFileToServer(importAuthService.getListFileUpload(), ImportServices.config.getEnvironment("Default_Upload_folder_SFTP"));

        baseObj.info("Step 4: Verify CM in STX.APP_USERS EVV updated");
        baseObj.sleep(240000);
        List<STXAppUser> stxAppUsers = getSTXAppUserByUserID(userID);
        Assert.assertTrue(stxAppUsers.size()>0);
        for(int i = 0; i < stxAppUsers.size(); i++) {
            STXAppUser stxAppUser = stxAppUsers.get(i);
            Assert.assertEquals(stxAppUser.getDELETED(), null);
            Assert.assertEquals(stxAppUser.getACCOUNT(), "9999");
            Assert.assertEquals(stxAppUser.getACCOUNT_STATUS(), "OPEN");
            Assert.assertEquals(stxAppUser.getUSER_L_NAME(), authInfo.getCaseManagerLastName());
        }

    }

}
