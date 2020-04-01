package openevv.pennsylvania.member;

import com.interop.models.openevv.client.OpenEvvClient;
import com.interop.services.openevv.OpenEvvClientService;
import com.sandata.qtest.QTest;
import generic.GenericTest;
import io.qameta.allure.Description;
import org.testng.annotations.Test;


public class Auto_SEVV_20622_OpenEVVClient_RecipientIDCustom2_Validation extends GenericTest {
    private OpenEvvClientService openEvvClient;

    @Test(groups = "openEVVClient")
    @QTest(keys = {"TC-22363"})
    @Description("OpenEVVClient_Send_RecipientIDCustom2_and_SSN_is_null")
    public void TC_22363_OpenEVVClient_Send_RecipientIDCustom2_and_SSN_is_null() {
        baseObj.info("Prepare a payload with specific DX code");
        OpenEvvClient model = OpenEvvClient.builder().build();
        model.setClientSSN(null);
        model.setRecipientIDCustom2(null);
        openEvvClient = new OpenEvvClientService();
        openEvvClient.addModel(model);

        baseObj.info("Step 2: Send Post Request");
        openEvvClient.post();
        openEvvClient.verifyPostStatus("SUCCESS");

        baseObj.info("Step 3: Send GET Request");
        openEvvClient.requestUUIDStatus();
        openEvvClient.verifyUUIDStatus("SUCCESS");

        baseObj.info("Step 4: Verify Staging DB");
        openEvvClient.verifyClientReqWithSTX(openEvvClient);
    }

    @Test(groups = "openEVVClient")
    @QTest(keys = {"TC-22312"})
    @Description("OpenEVVClient_Send_RecipientIDCustom2_and_SSN_is_empty")
    public void TC_22312_OpenEVVClient_Send_RecipientIDCustom2_and_SSN_is_empty() {
        baseObj.info("Prepare a payload with specific DX code");
        OpenEvvClient model = OpenEvvClient.builder().build();
        model.setClientSSN("");
        model.setRecipientIDCustom2("");
        openEvvClient = new OpenEvvClientService();
        openEvvClient.addModel(model);

        baseObj.info("Step 2: Send Post Request");
        openEvvClient.post();
        openEvvClient.verifyPostStatus("SUCCESS");

        baseObj.info("Step 3: Send GET Request");
        openEvvClient.requestUUIDStatus();
        openEvvClient.verifyUUIDStatus("SUCCESS");

        baseObj.info("Step 4: Verify Staging DB");
        openEvvClient.verifyClientReqWithSTX(openEvvClient);
    }

    @Test(groups = "openEVVClient")
    @QTest(keys = {"TC-22364"})
    @Description("OpenEVVClient_Send_RecipientIDCustom2_and_SSN_is_not null and having valid data")
    public void TC_22364_OpenEVVClient_Send_RecipientIDCustom2_and_SSN_is_not_null_and_having_valid_data() {
        baseObj.info("Prepare a payload with specific DX code");
        OpenEvvClient model = OpenEvvClient.builder().build();
        model.setClientSSN(commons.generateRandomSsn());
        model.setRecipientIDCustom2(null);
        openEvvClient = new OpenEvvClientService();
        openEvvClient.addModel(model);

        baseObj.info("Step 2: Send Post Request");
        openEvvClient.post();
        openEvvClient.verifyPostStatus("SUCCESS");

        baseObj.info("Step 3: Send GET Request");
        openEvvClient.requestUUIDStatus();
        openEvvClient.verifyUUIDStatus("SUCCESS");

        baseObj.info("Step 4: Verify Staging DB");
        openEvvClient.verifyClientReqWithSTX(openEvvClient);
    }
}
