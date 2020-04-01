package AltEVV_generic.restassured.sandata.Indiana.Client;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

public class Generic_TC97930_AltEVV_Update_Primary_Phone_Existing_Client extends BaseTest {
    private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
    private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

    @Test(groups = {"All"})
    public void TC97930_AltEVV_update_client_data() throws InterruptedException, IOException,
            ParseException, SQLException, ClassNotFoundException
    {
        // logger = extent.startTest("TC97930_AltEVV_update_client_data");

        JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
        JSONObject jsonObject = (JSONObject) jsonArray.get(0);

        CommonMethods.validateResponse(jsonArray,
                CommonMethods.propertyfileReader(globalVariables.altevv_clients));

        Thread.sleep(5000);

        jsonObject.put("SequenceID", CommonMethods.generateUniqueID());
        JSONArray clientPhone = (JSONArray) jsonObject.get(globalVariables.ClientPhone);
        JSONObject phone = (JSONObject) clientPhone.get(0);
        phone.put(globalVariables.ClientPhoneType, "Other");
        phone.put(globalVariables.ClientPhone, CommonMethods.generateRandomNumberOfFixLength(10));

        CommonMethods.validateResponse(jsonArray,
                CommonMethods.propertyfileReader(globalVariables.altevv_clients));

        assertionDbVerifier.jsonAssert_InboxAni_OpenEVV(jsonObject, phone);
    }
}
