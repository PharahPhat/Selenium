package openevv.Connecticut.Client;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.globalMethods.core.globalVariables.*;
import static com.globalMethods.core.globalVariables.openevv_client_url;

public class R15830_TC23431_OpenEVV_EffectiveStartDate_Validation extends BaseTest {
    private com.globalMethods.core.GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

    @DataProvider(name = "dataProvider")
    public static Object[][] dataProvider() {
        return new Object[][]
                {
                        {true, null, ""},
                        {true, "", ""},
                        {false, "12-31-1990", EffectiveStartDateFormatError},
                        {false, "12/31/1990", EffectiveStartDateFormatError},
                        {false, CommonMethods.generateTodayDate_MMddyyyy(), EffectiveStartDateFormatError},
                        {false, "19903112", EffectiveStartDateFormatError},
                        {false, "31121990", EffectiveStartDateFormatError},

                };
    }

    @Test(dataProvider = "dataProvider")
    public void R15830_TC20948_OpenEVV_EffectiveStartDate_Validation (boolean isValid, String value, String errorMessage) throws
            IOException, ParseException {
        JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_OpenEVV("client");

        JSONObject jsonObject = (JSONObject) altEVVJsonArray.get(0);
        JSONArray jsonArrPayer = (JSONArray) jsonObject.get(globalVariables.Client_Payer_Information);
        JSONObject jsonObjectPayer = 	(JSONObject) jsonArrPayer.get(0);
        jsonObjectPayer.put(EffectiveStartDate, value);


        if (isValid) {
            CommonMethods.validateResponse(altEVVJsonArray, CommonMethods.propertyfileReader(openevv_client_url));
        }
        else {
            String body = CommonMethods.capturePostResponse(altEVVJsonArray, CommonMethods.propertyfileReader(openevv_client_url));
            CommonMethods.verifyjsonassertFailcase(body, errorMessage);
        }
    }

    @Test(groups = {"All", "fixing"})	@AdditionalInfo(module = "OpenEVV")
    public void R15830_TC96855_OpenEVV_EffectiveStartDate_InsertDB_Validation() throws InterruptedException, IOException, ParseException {

        JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
        JSONObject jsonObject = (JSONObject) jsonArray.get(0);

        JSONArray jsonArrPayer = (JSONArray) jsonObject.get(globalVariables.Client_Payer_Information);
        JSONObject jsonObjectPayer = 	(JSONObject) jsonArrPayer.get(0);
        jsonObjectPayer.put("EffectiveStartDate", CommonMethods.generatecurrentDate_YYYY_MM_dd());
        jsonObjectPayer.put("EffectiveEndDate",CommonMethods.generateFutureDate_YYYY_MM_dd() );

        String bodyAsString = CommonMethods.capturePostResponse(jsonArray,
                CommonMethods.propertyfileReader(globalVariables.openevv_client_url));

        String bodyAsStringGet=CommonMethods.captureResponseOpenEVVGetWithUID(bodyAsString, CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
        Assert.assertTrue(bodyAsStringGet.contains("\"status\": \"SUCCESS\","));
        Assert.assertTrue(bodyAsStringGet.contains("\"reason\": \"Transaction Received.\","));

    }
}
