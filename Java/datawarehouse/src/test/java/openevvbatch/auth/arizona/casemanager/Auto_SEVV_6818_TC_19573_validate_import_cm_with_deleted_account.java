/**
 * account:
 * dev: AZ_CM, HI_CM, PA_68611
 * qa: AZ_AMP_WS, HI_AMP_WS
 */
package openevvbatch.auth.arizona.casemanager;

import com.interop.common.constants.utils.RabbitMQUtils;
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

import static com.interop.common.constants.utils.db.AppUserDBUtils.getDateletedCM;
import static com.interop.common.constants.utils.db.AppUserDBUtils.getSTXAppUserActive;
import static com.interop.common.constants.utils.db.ClientDBUtils.getIDAndMedicaidIDOfMemberHavingSpecificMedicaidID;

public class Auto_SEVV_6818_TC_19573_validate_import_cm_with_deleted_account extends ImportBaseTest {
    ImportAuthService importAuthService ;

    @Test(groups = {"batch","non-regression"})//passed
    public void Auto_SEVV_6818_TC_19573_validate_import_cm_with_deleted_account() throws IOException, InterruptedException, SftpException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchAlgorithmException, KeyManagementException, URISyntaxException, TimeoutException, NoSuchFieldException, SQLException {
        importAuthService = new ImportAuthService();
        final String queueName = "QAAutomation";
        final List<STXAppUser> deletedCMEmail = getDateletedCM();
        STXAppUser delAppUser = deletedCMEmail.get(1);
        STXClientAuth clientInfo = getIDAndMedicaidIDOfMemberHavingSpecificMedicaidID(stateAccount, 9).get(0);

        baseObj.info("Step 0: Modifying data with CM email : " + delAppUser.getUSERNAME().toString() );
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
        authInfo.setCaseManagerEmail(delAppUser.getUSERNAME().toString());
        lstAuthInfo.add(authInfo);

        baseObj.info("Step 1: Prepare data to import");
        importAuthService.initFileImportAuthAndOutboundWithCustomData(lstAuthInfo);

        baseObj.info("Step 2: Upload file to SFTP");
        RabbitMQUtils.purseMessage(queueName);//Purse the message on rabbitMQ to avoid trash data
        importAuthService.uploadFileToServer(importAuthService.getListFileUpload(), ImportServices.config.getEnvironment("Default_Upload_folder_SFTP"));

        baseObj.info("Step 3: Verify account status of case manager in EVV");
        baseObj.sleep(60000);
        List<STXAppUser> appUsers  = getSTXAppUserActive(delAppUser.getUSERNAME().toString());
        Assert.assertTrue(appUsers.size()>0);
        for(STXAppUser appUser : appUsers){
            baseObj.info("account deleted date of case manager in app user table is: " + appUser.getDELETED());
            Assert.assertTrue(appUser.getDELETED()== null);
        }
    }
}
