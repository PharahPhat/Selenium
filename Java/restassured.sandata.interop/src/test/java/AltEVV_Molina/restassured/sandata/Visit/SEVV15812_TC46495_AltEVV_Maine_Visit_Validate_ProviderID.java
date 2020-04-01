package AltEVV_Molina.restassured.sandata.Visit;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.globalMethods.core.globalVariables.*;

public class SEVV15812_TC46495_AltEVV_Maine_Visit_Validate_ProviderID extends BaseTest {
    private GenerateUniqueParam generateUniqueParam = new GenerateUniqueParam();

    @DataProvider(name = "dataProvider")
    public static Object[][] dataProvider() {
        return new Object[][]
                {
                        {true, stateInfo.get(ProviderID), ""},
                        {false, CommonMethods.generateRandomAlphaNumeric(10), ProviderIDInvalid},
                        {false, null, ProviderIDInvalid},
                        {false, "", ProviderIDInvalid}
                };
    }

    @Test(dataProvider = "dataProvider")
    public void TC36584_AltEVV_Maine_Visit_Validate_ProviderID(boolean isValid, String value, String errorMessage) throws
            ParseException, IOException, InterruptedException {
        JSONArray jsonArrayVisit= generateUniqueParam.VisitParams_AltEVV_Molina();
        JSONObject jsonObject = (JSONObject) jsonArrayVisit.get(0);
        jsonObject.put(globalVariables.VisitOtherID, CommonMethods.generateRandomAlphaNumeric(50));

        JSONObject jsonProvider =  (JSONObject) jsonObject.get(globalVariables.ProviderIdentification);
        jsonProvider.put(ProviderID, value);

        if (isValid) {
            CommonMethods.validateResponse(jsonArrayVisit, CommonMethods.propertyfileReader(altevv_Molina_visit));
        }
        else {
            String bodyAsString = CommonMethods.capturePostResponse_500(jsonArrayVisit, CommonMethods.propertyfileReader(altevv_Molina_visit));
            CommonMethods.verifyjsonassertFailcase(bodyAsString, errorMessage);
        }
    }
}
