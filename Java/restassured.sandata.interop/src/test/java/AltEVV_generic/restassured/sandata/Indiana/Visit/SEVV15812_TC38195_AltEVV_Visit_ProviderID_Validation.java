package AltEVV_generic.restassured.sandata.Indiana.Visit;

import Utills_ExtentReport_Log4j.BaseTest;
import com.common.Validation;
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

public class SEVV15812_TC38195_AltEVV_Visit_ProviderID_Validation extends BaseTest {
    private GenerateUniqueParam generateUniqueParam = new GenerateUniqueParam();

    @DataProvider(name = "dataProvider")
    public static Object[][] dataProvider() {
        return new Object[][]
                {
                        {true, stateInfo.get(ProviderID), ""},
                        {false, CommonMethods.generateRandomAlphaNumeric(11), ProviderIDInvalid},
                        {false, null, ProviderIDInvalid},
                        {false, "", ProviderIDInvalid}
                };
    }

    @Test(dataProvider = "dataProvider")
    public void TC38195_AltEVV_Indiana_Visit_Validate_ProviderID(boolean isValid, String value, String errorMessage) throws
            ParseException, IOException, InterruptedException {
        JSONArray jsonArrayVisit= generateUniqueParam.VisitParams_AltEVV();
        Validation.validationProviderIdentificationField(jsonArrayVisit, ProviderID, isValid, value,
                errorMessage, CommonMethods.propertyfileReader(altevv_visit), 500);
    }
}
