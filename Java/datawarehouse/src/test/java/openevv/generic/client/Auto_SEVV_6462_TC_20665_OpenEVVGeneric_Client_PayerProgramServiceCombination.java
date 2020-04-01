/**
 * account: AZOpenEVV, HIOpenEVV, VT
 *
 */
package openevv.generic.client;

import com.interop.common.TestDataHelper;
import com.interop.common.constants.utils.db.AuthDBUtils;
import com.interop.common.dataprovider.DataPayerProgramCombination;
import com.interop.models.db.inbox.InboxAuthorization;
import com.interop.models.openevv.client.ClientPayerInformation;
import com.interop.models.openevv.client.OpenEvvClient;
import com.interop.services.openevv.OpenEvvClientService;
import com.sandata.qtest.QTest;
import generic.GenericTest;
import io.qameta.allure.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static com.interop.sql.AuthSQL.SQL_INBOX_AUTHORIZATION;

public class Auto_SEVV_6462_TC_20665_OpenEVVGeneric_Client_PayerProgramServiceCombination extends GenericTest {

    private final String stringKey = stateAccount.getStateEnum().getStringKey();
    @DataProvider(name = "combineFieldValidation")
    public Object[][] getDataDriven() {
        final String fileName;
        switch (stateAccount.getStateEnum()){
            case HAWAII:
                fileName = "OpenEVV/OpenEVV_"+stringKey+"_PayerProgramServiceCombination_"+System.getProperty("environment")+".csv";
                break;
            default:
                fileName = "OpenEVV/OpenEVV_"+stringKey+"_PayerProgramServiceCombination.csv";
                break;
        }
        return TestDataHelper.getCombinationDataRows(state, fileName);
    }

    @Test(dataProvider = "combineFieldValidation", groups = {"openEVVClient"})
    @Description("Field Validation Test for openevv Client endpoint")
    @QTest(keys = {"TC-23045"})
    public void TC_20665_OpenEVVGeneric_Client_PayerProgramServiceCombination(DataPayerProgramCombination dataTest) {
        OpenEvvClientService clientAPI = OpenEvvClientService.init();
        switch (stateAccount.getStateEnum()){
            case HAWAII:
                clientAPI.isModifyAccount(true);
                clientAPI.setAccount(dataTest.getAccount());
                clientAPI.getModels().get(0).setAccount(dataTest.getAccount());
                clientAPI.getModels().get(0).getClientAddress().get(0).setAccount(dataTest.getAccount());
                clientAPI.getModels().get(0).getClientPhone().get(0).setAccount(dataTest.getAccount());
                break;
            default:
                break;
        }
        OpenEvvClient client = clientAPI.getModels().get(0);
        ClientPayerInformation clientPayerInformation = client.getClientPayerInformation().get(0);
        clientPayerInformation.setPayerID(dataTest.getPayer());
        clientPayerInformation.setPayerProgram(dataTest.getProgram());
        clientPayerInformation.setProcedureCode(dataTest.getService());
        clientPayerInformation.setModifier1(dataTest.getModifier1());
        clientPayerInformation.setModifier2(dataTest.getModifier2());
        clientPayerInformation.setModifier3(dataTest.getModifier3());
        clientPayerInformation.setModifier4(dataTest.getModifier4());

        clientAPI.loadPayload(clientAPI.getModels());
        clientAPI.post();

        clientAPI.verifyPostStatus(dataTest.getExpectedStatus());
        if (dataTest.getExpectedStatus().equalsIgnoreCase("SUCCESS")) {
            String querySQL = String.format(SQL_INBOX_AUTHORIZATION, client.getAccount(), client.getClientID(),
                    client.getClientPayerInformation().get(0).getPayerID(),
                    client.getClientPayerInformation().get(0).getClientPayerID());
            List<InboxAuthorization> result = AuthDBUtils.getInboxAuthorizationFromQuery(querySQL);

            InboxAuthorization inboxAuthorization = result.get(0);
            baseObj.validateActualAndExpectedText(inboxAuthorization.getERROR_CODE().toString(), dataTest.getExpectedMessage());
        }
    }
}
