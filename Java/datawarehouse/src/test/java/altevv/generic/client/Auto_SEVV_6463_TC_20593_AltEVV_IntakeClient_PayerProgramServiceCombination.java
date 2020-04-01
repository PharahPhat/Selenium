package altevv.generic.client;

import com.interop.common.StateAccount;
import com.interop.common.TestDataHelper;
import com.interop.common.constants.utils.db.AuthDBUtils;
import com.interop.common.dataprovider.DataPayerProgramCombination;
import com.interop.models.altevv.client.AltEvvClient;
import com.interop.models.altevv.client.AltEvvClientDataGenerator;
import com.interop.models.altevv.client.ClientPayerInformation;
import com.interop.models.db.inbox.InboxAuthorization;
import com.interop.services.atlevv.AltEvvClientService;
import com.sandata.qtest.QTest;
import generic.GenericTest;
import io.qameta.allure.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static com.interop.sql.AuthSQL.SQL_INBOX_AUTHORIZATION;

/**
 * Author by NhonNguyen
 * Script could be run on VT, RI, HI, AZ, PA
 */

public class Auto_SEVV_6463_TC_20593_AltEVV_IntakeClient_PayerProgramServiceCombination extends GenericTest {
    private final String stringKey = stateAccount.getStateEnum().getStringKey();
    @DataProvider(name = "invalidFieldValidation")
    public Object[][] getDataDriven() {
        String fileName = "AltEVV/AltEVV_" + stringKey + "_PayerProgramServiceCombination.csv";
        return TestDataHelper.getCombinationDataRows(state, fileName);
    }

    @Test(dataProvider = "invalidFieldValidation", groups = {"generic", "altClient"})
    @QTest(keys = {"TC-23323"})
    @Description("Field Validation Test for AltEVV Client endpoint")
    public void TC_20593_AltEVV_IntakeClient_PayerProgramServiceCombination(DataPayerProgramCombination dataTest) {
        AltEvvClientService clientAPI = new AltEvvClientService();
        AltEvvClient altEvvClient = AltEvvClientDataGenerator.getDefaultAltEvvClientWithUniqueValue(stateAccount);
        ClientPayerInformation clientPayerInformation = altEvvClient.getClientPayerInformation().get(0);
        clientPayerInformation.setPayerID(dataTest.getPayer());
        clientPayerInformation.setPayerProgram(dataTest.getProgram());
        clientPayerInformation.setProcedureCode(dataTest.getService());
        clientPayerInformation.setModifier1(dataTest.getModifier1());
        clientPayerInformation.setModifier2(dataTest.getModifier2());
        clientPayerInformation.setModifier3(dataTest.getModifier3());
        clientPayerInformation.setModifier4(dataTest.getModifier4());
        clientAPI.addModel(altEvvClient);
        clientAPI.post();

        clientAPI.verifyPostStatus(dataTest.getExpectedStatus());

        String querySQL = String.format(SQL_INBOX_AUTHORIZATION, StateAccount.loadStateAccount().getAccountID(),
                altEvvClient.getClientPayerInformation().get(0).getPayerID(),
                altEvvClient.getClientPayerInformation().get(0).getClientPayerID());
        List<InboxAuthorization> result = AuthDBUtils.getInboxAuthorizationFromQuery(querySQL);
        InboxAuthorization inboxAuthorization = result.get(0);

        baseObj.info("Verify Error Code in Inbox.Authorization");
        baseObj.validateActualAndExpectedText(inboxAuthorization.getERROR_CODE().toString(), dataTest.getExpectedMessage());
    }
}
