package Ohio.sandata.restclaim;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

public class SEVV_14472_TC39071_Full_Setup_For_Existing_Account extends BaseTest {

    private com.globalMethods.core.GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

    @DataProvider(name = "dataProviderValid")
    public static Object[][] dataProvider() {
        return new Object[][]
                {
                        {"none","valid","valid"},//1
                        {"valid","valid","valid"},//2
                        {"valid","share","share"},//3
                        {"none","share","share"},//4
                };
    }

    @Test(groups = {"All", "Regression","fixing"},dataProvider = "dataProviderValid")
    public  void SEVV_14472_TC39071_Full_Setup_For_Existing_Account_Valid(String entityId, String username, String password)
            throws InterruptedException, IOException, ParseException,
            SQLException, java.text.ParseException{
        Map<String, JSONObject> MapjsonObject=GenerateUniqueParam.ohioclaim_Rest_V2();


        JSONArray claimSubArray= (JSONArray) MapjsonObject.get("rest").get("EVV_Request");
        JSONObject claimSubobject =  (JSONObject) claimSubArray.get(0);
        claimSubobject.put(globalVariables.matchingRulejson, "ExactMatch");
        claimSubobject.put(globalVariables.businnesmedicaidid, "1234567");
        claimSubobject.put(globalVariables.PatientID, "123456789500");
        claimSubobject.put(globalVariables.ServiceStartDate, "2019-08-01");
        claimSubobject.put(globalVariables.ServiceEndDate, "2019-08-01");
        claimSubobject.put(globalVariables.ProcedureCode, "T1000");
        claimSubobject.put(globalVariables.Units, "10");
        claimSubobject.put(globalVariables.ProviderID, "1234567");

        String bodyString = CommonMethods.captureResponseClaimDependencyApiSetingV2(MapjsonObject.get("rest"),
                CommonMethods.propertyfileReader("Rest_claim"),entityId, username, password, true);

        CommonMethods.verifyJsonPassCaseForClaim(bodyString);
    }

    @DataProvider(name = "dataProviderInValid")
    public static Object[][] dataProviderInvalid() {
        return new Object[][]
                {
                        {"invalid","valid","valid"},//1
                        {"valid","","valid"},//2
                        {"valid","invalid","valid"},//3
                        {"valid","valid",""},//4
                        {"valid","valid","invalid"},//5
                };
    }

    @Test(groups = {"All", "Regression","fixing"},dataProvider = "dataProviderInValid")
    public  void SEVV_14472_TC39071_Full_Setup_For_Existing_Account_InValid(String entityId, String username, String password)
            throws InterruptedException, IOException, ParseException,
            SQLException, java.text.ParseException{
        Map<String, JSONObject> MapjsonObject=GenerateUniqueParam.ohioclaim_Rest_V2();

        JSONArray claimSubArray= (JSONArray) MapjsonObject.get("rest").get("EVV_Request");
        JSONObject claimSubobject =  (JSONObject) claimSubArray.get(0);
        claimSubobject.put(globalVariables.matchingRulejson, "ExactMatch");
        claimSubobject.put(globalVariables.businnesmedicaidid, "1234567");
        claimSubobject.put(globalVariables.PatientID, "123456789500");
        claimSubobject.put(globalVariables.ServiceStartDate, "2019-08-01");
        claimSubobject.put(globalVariables.ServiceEndDate, "2019-08-01");
        claimSubobject.put(globalVariables.ProcedureCode, "T1000");
        claimSubobject.put(globalVariables.Units, "10");
        claimSubobject.put(globalVariables.ProviderID, "1234567");

        String bodyString = CommonMethods.captureResponseClaimDependencyApiSetingV2(MapjsonObject.get("rest"),
                CommonMethods.propertyfileReader("Rest_claim"),entityId, username, password, false);

        CommonMethods.verifyjsonassertFailcaseForClaim(bodyString);
    }

}
