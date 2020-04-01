package Ohio.sandata.restclaim.RestClaimV2;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

import static com.globalMethods.core.globalVariables.ClaimValidationBusinessMedicaidIdentifierError;
import static com.globalMethods.core.globalVariables.businnesmedicaidid;

public class SEVV1246_TC38423_Ohio_ODM_V2_ValidateBusinessMedicaidIdentifier extends BaseTest {

    private com.globalMethods.core.GenerateUniqueParam GenerateUniqueParam = new GenerateUniqueParam();

    @DataProvider(name = "dataProvider")
    public static Object[][] dataProvider() {
        return new Object[][]
                {
                        {true, "12354658778123ABcas2354658778123546587788569702321", ""},
                        {true, "123546", ""},
                        {false, "12354658778123ABcas2354658778123546587788569701211231321", ClaimValidationBusinessMedicaidIdentifierError},
                        {false, null, ClaimValidationBusinessMedicaidIdentifierError},
                        {false, "", ClaimValidationBusinessMedicaidIdentifierError},
                };
    }
    @Test(dataProvider = "dataProvider")
    public void SEVV1246_TC38423_Ohio_ODM_V2_ValidateBusinessMedicaidIdentifier (boolean isValid, String value, String errorMessage) throws
            IOException, ParseException, InterruptedException, java.text.ParseException, SQLException, ClassNotFoundException {

        JSONArray openEVVJsonArray = GenerateUniqueParam.ohioclaim_Rest_fail();

        JSONObject claimobject = (JSONObject) openEVVJsonArray.get(0);
        JSONArray claimSubArray= (JSONArray) claimobject.get("EVV_Request");
        JSONObject claimSubobject = (JSONObject) claimSubArray.get(0);
        claimSubobject.put(businnesmedicaidid,value);

        if (isValid) {
            String bodyAsString= CommonMethods.captureResponseClaim(claimobject, CommonMethods.propertyfileReader("Rest_claim"));
            CommonMethods.verifyStatusSUCCESS(bodyAsString);
            CommonMethods.CapterrestclaimResponse(bodyAsString, errorMessage);
           }
        else {
            String body = CommonMethods.captureResponseClaim(claimobject, CommonMethods.propertyfileReader("Rest_claim"));
            CommonMethods.verifyStatusFAILED(body);
            CommonMethods.CapterrestclaimResponse_invalid(body, errorMessage);
        }
    }
}
