package openevv.arizona.auth;

import com.interop.common.StateAccount;
import com.interop.common.constants.utils.db.AppUserDBUtils;
import com.interop.models.db.inbox.InboxAuthorization;
import com.interop.models.db.stx.STXAuthorization;
import com.interop.services.atlevv.AltEvvClientService;
import com.interop.services.openevv.OpenEvvAuthService;
import generic.GenericTest;
import org.testng.annotations.Test;

import static com.interop.common.constants.utils.db.AuthDBUtils.getInboxAuthorization;
import static com.interop.common.constants.utils.db.AuthDBUtils.getSTXAuthorization;

/**
 * Author by Nhon Nguyen
 * Only run test case with account PA 68611 (bit 17 enabled)
 */

public class Auto_SEVV_6818_TC_41964_OpenEVV_CaseManagerWithNewClient extends GenericTest {
    @Test(groups = {"openEVVAuth"})
    public void Auto_SEVV_6818_TC_41964_OpenEVV_CaseManagerWithNewClient() {
        baseObj.info("Step 1: Create new Client");
        AltEvvClientService client = AltEvvClientService.init();
        String clientCustomID = client.getModels().get(0).getClientIdentifier();
        client.post();

        baseObj.info("Step 2: Create Auth with new client above");
        OpenEvvAuthService openEVVAuth = OpenEvvAuthService.init();
        openEVVAuth.getModels().get(0).setClientIdentifier(clientCustomID);
        openEVVAuth.loadPayload(openEVVAuth.getModels());
        openEVVAuth.post();
        openEVVAuth.verifyPostStatus("SUCCESS");
        openEVVAuth.requestUUIDStatus();
        openEVVAuth.verifyUUIDStatus("SUCCESS");

        baseObj.info("Verify data storing in database");
        baseObj.sleep(10000);
        for (int i = 0; i < openEVVAuth.getModels().size(); i++) {
            String authRefNum = openEVVAuth.getModels().get(i).getAuthorizationReferenceNumber();
            String fNameCaseManager = openEVVAuth.getModels().get(i).getCaseManagerFirstName();
            String lNameCaseManager = openEVVAuth.getModels().get(i).getCaseManagerLastName();
            String emailCaseManager = openEVVAuth.getModels().get(i).getCaseManagerEmail();

            baseObj.info("Step 3: Verify ERROR CODE in INBOX EVV");
            InboxAuthorization inboxAuthorization = getInboxAuthorization(authRefNum).get(0);
            baseObj.validateActualAndExpectedText(inboxAuthorization.getERROR_CODE().toString(), "0 Operation success");

            baseObj.info("Step 4: Verify ERROR CODE in STX EVV");
            STXAuthorization stxAuthorization = getSTXAuthorization(authRefNum).get(0);
            baseObj.info("Verify field CaseManagerFirstName");
            baseObj.validateActualAndExpectedText(stxAuthorization.getCASE_MANAGER_F_NAME().toString(), fNameCaseManager);
            baseObj.info("Verify field CaseManagerLastName");
            baseObj.validateActualAndExpectedText(stxAuthorization.getCASE_MANAGER_L_NAME().toString(), lNameCaseManager);
            baseObj.info("Verify field CaseManagerEmail");
            baseObj.validateActualAndExpectedText(stxAuthorization.getCASE_MANAGER_E_MAIL().toString(), emailCaseManager);

            StateAccount stateAccount = StateAccount.loadStateAccount();
            if (stateAccount.getStateName().equalsIgnoreCase("PA_68611")) {
                baseObj.info("Step 5: Verify Case Manager Existing in STX.APP_USER");
                baseObj.info(AppUserDBUtils.getAppUser("9999", emailCaseManager).toString());
            }
        }
        baseObj.info("Data is stored in database successfully");
    }
}
