package AltEVV_generic.restassured.sandata.Indiana.Client;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

public class Bug17390_TC95157_AltEVV_Allow_to_create_multiple_clients_per_a_request extends BaseTest {

    private com.globalMethods.core.GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

    @Test(groups = {"All", "Regression"})
    @AdditionalInfo(module = "AltEVVclient")
    public void Bug17390_TC95157_AltEVV_Allow_to_create_multiple_clients_with_and_without_clientID() throws IOException, ParseException {

        JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
        JSONArray postJsonArray = new JSONArray();
        JSONObject jsonObject1 = (JSONObject) jsonArray.get(0);
        jsonObject1.remove("ClientID");
        jsonObject1.put("ClientCustomID", CommonMethods.generateRandomNumberOfFixLength(8));
        jsonObject1.put("ClientOtherID",CommonMethods.generateRandomNumberOfFixLength(8));


        jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
        JSONObject jsonObject2 = (JSONObject) jsonArray.get(0);
        jsonObject2.put("ClientID",CommonMethods.generateRandomNumberOfFixLength(5));
        jsonObject2.put("ClientCustomID", CommonMethods.generateRandomNumberOfFixLength(8));
        jsonObject2.put("ClientOtherID",CommonMethods.generateRandomNumberOfFixLength(8));

        postJsonArray.add(jsonObject1);
        postJsonArray.add(jsonObject2);

        CommonMethods.validateResponse(postJsonArray,
                CommonMethods.propertyfileReader(globalVariables.altevv_clients));

    }
}
