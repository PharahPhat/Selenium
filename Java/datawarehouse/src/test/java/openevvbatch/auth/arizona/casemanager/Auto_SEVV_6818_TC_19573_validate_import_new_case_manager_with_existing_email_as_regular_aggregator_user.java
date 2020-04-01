/**
 * account:
 * dev: AZ_CM, HI_CM, PA_68611
 * qa: AZ_AMP_WS, HI_AMP_WS
 */
package openevvbatch.auth.arizona.casemanager;

import com.interop.common.constants.utils.RabbitMQUtils;
import com.interop.models.db.inbox.InboxAppUser;
import com.interop.models.db.staging.StagingAuth;
import com.interop.models.db.stx.STXAppUser;
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
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

import static com.interop.common.constants.utils.db.AppUserDBUtils.getInboxAppUser;
import static com.interop.common.constants.utils.db.AppUserDBUtils.getRegAggregatorAcc;
import static com.interop.common.constants.utils.db.AuthDBUtils.getStagingAuthorization;
import static com.interop.common.constants.utils.db.ClientDBUtils.getIDAndMedicaidIDOfMemberHavingSpecificMedicaidID;

public class Auto_SEVV_6818_TC_19573_validate_import_new_case_manager_with_existing_email_as_regular_aggregator_user extends ImportBaseTest {
    ImportAuthService importAuthService ;

    @Test(groups = {"batch","non-regression"}) //passed
    public void Auto_SEVV_6818_TC_19573_validate_import_new_case_manager_with_existing_email_as_regular_aggregator_user() throws IOException, InterruptedException, SftpException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchAlgorithmException, KeyManagementException, URISyntaxException, TimeoutException, NoSuchFieldException, SQLException {
        importAuthService = new ImportAuthService();
        final String queueName = "QAAutomation";
        final List<STXAppUser> regAggregetorAcc = getRegAggregatorAcc();
        STXClientAuth clientInfo = getIDAndMedicaidIDOfMemberHavingSpecificMedicaidID(stateAccount, 9).get(0);

        baseObj.info("Step 0: Modifying data with CM email : " + regAggregetorAcc.get(1).getUSERNAME().toString() );
        List<AuthorizationCSVModel> lstAuthInfo = new ArrayList<>();
        AuthorizationCSVModel authInfo = new AuthorizationCSVModel();

        authInfo.setClientIdentifier(clientInfo.getMEDICAID_ID().substring(0, 9));
        authInfo.setAuthorizationReferenceNumber(importAuthService.generateAuthRefNumber());
        authInfo.setProviderID(clientInfo.getPROVIDER_ID());
        authInfo.setCaseManagerFirstName(baseObj.generateRandomString(10));
        authInfo.setCaseManagerLastName(baseObj.generateRandomString(10));
        authInfo.setPayerID(stateAccount.getDefaultPayerID());
        authInfo.setPayerProgram(stateAccount.getDefaultPayerProgram());
        authInfo.setAuthorizationServiceID(stateAccount.getDefaultProcedureCode());
        authInfo.setPayerRegion("01");
        authInfo.setCaseManagerEmail(regAggregetorAcc.get(3).getUSERNAME().toString());
        lstAuthInfo.add(authInfo);

        baseObj.info("Step 1: Prepare data to import");
        importAuthService.initFileImportAuthAndOutboundWithCustomData(lstAuthInfo);

        baseObj.info("Step 2: Upload file to SFTP");
        RabbitMQUtils.purseMessage(queueName);//Purse the message on rabbitMQ to avoid trash data
        importAuthService.uploadFileToServer(importAuthService.getListFileUpload(), ImportServices.config.getEnvironment("Default_Upload_folder_SFTP"));

        baseObj.info("Step 5: Verify in staging DB");
//        runTriggerForSpecificService(MATCHING_SERVICE, "60130");//Run trigger to make the service import auth run first
        List<StagingAuth> authRecordsStaging = getStagingAuthorization(authInfo.getAuthorizationReferenceNumber());

        baseObj.info("Step 5: Verify in staging DB Auth");
        baseObj.sleep(60000);
        for (StagingAuth authRecordStaging : authRecordsStaging) {
            AuthorizationCSVModel line = (AuthorizationCSVModel) importAuthService.getRecords().get(0);
            Assert.assertEquals(line.caseManagerFirstName, authRecordStaging.getCase_manager_f_name());
            Assert.assertEquals(line.caseManagerLastName, authRecordStaging.getCase_manager_l_name());
            Assert.assertEquals(line.caseManagerEmail, authRecordStaging.getCase_manager_e_mail());

        }
        baseObj.info("Step 6: Verify ERROR CODE in INBOX.APP_USERS EVV");
        baseObj.sleep(20000);
        List<InboxAppUser> appUsers  = getInboxAppUser(authInfo.getCaseManagerEmail());
        Assert.assertTrue(appUsers.size()>0);
        for(InboxAppUser appUser : appUsers){
            baseObj.info("error code of case manager in app user table is: " + appUser.getERROR_CODE());
            Assert.assertEquals(appUser.getERROR_CODE().toString(), "-1138");
        }
    }
}
