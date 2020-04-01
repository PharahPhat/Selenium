package openevvbatch.auth.pennsylvania;

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
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

import static com.interop.common.constants.utils.TriggerUtils.runTriggerForSpecificService;
import static com.interop.common.constants.utils.TriggerUtils.servicesNeedToTrigger.EVV_IMPORT_AUTH;
import static com.interop.common.constants.utils.TriggerUtils.servicesNeedToTrigger.MATCHING_SERVICE;
import static com.interop.common.constants.utils.db.AuthDBUtils.*;
import static com.interop.common.constants.utils.db.ClientDBUtils.getIDAndMedicaidIDOfMemberHavingSpecificMedicaidID;

public class Auto_SEVV_18404_TC_18485_Import_Base_auth_having_AuthEndDate_greater_than_AuthStartDate extends ImportBaseTest {
    ImportAuthService importAuthService;
    STXClientAuth clientInfo = getIDAndMedicaidIDOfMemberHavingSpecificMedicaidID(stateAccount, 9).get(0);


    @Test(groups = {"non-regression"})
    public void Auto_SEVV_18404_TC_18485_Import_auth_having_AuthEndDate_greater_than_AuthStartDate() throws IOException, InterruptedException, SftpException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchAlgorithmException, KeyManagementException, URISyntaxException, TimeoutException, NoSuchFieldException, SQLException {
        importAuthService = new ImportAuthService();
        String authRefNum = importAuthService.generateAuthRefNumber();

        List<AuthorizationCSVModel> lstAuthInfo = new ArrayList<>();
        AuthorizationCSVModel authInfo = new AuthorizationCSVModel();
        authInfo.setClientIdentifier(clientInfo.getMEDICAID_ID());
        authInfo.setAuthorizationReferenceNumber(authRefNum);
        authInfo.setAuthorizationStartDate("01/01/2019");
        authInfo.setAuthorizationEndDate("12/01/2019");
        authInfo.setProviderID(clientInfo.getPROVIDER_ID());
        lstAuthInfo.add(authInfo);

        baseObj.info("Step 1: Prepare test data");
        importAuthService.initFileImportAuthAndOutboundWithCustomData(lstAuthInfo);

        baseObj.info("Step 2: Upload file to SFTP");
        importAuthService.uploadFileToServer(importAuthService.getListFileUpload(), ImportServices.config.getEnvironment("Default_Upload_folder_SFTP"));

        baseObj.info("Step 3: Verify is the file processed success");
        runTriggerForSpecificService(EVV_IMPORT_AUTH);
        runTriggerForSpecificService(MATCHING_SERVICE);
        baseObj.info("Step 4: Check in Oracle Table");
        baseObj.info("Step 4.1: Is auth stored in INBOX without error code");
        String authorizationReferenceNumber = authInfo.getAuthorizationReferenceNumber();
        verifyProviderImportedSuccessWithoutErrorCode(authorizationReferenceNumber);

        baseObj.info("Step 4.2: Is auth stored in STX without error code");
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