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
public class SEVV_TC002262_Model2_Multi_visits_having_different_adjusted_time extends BaseTest {

    private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
    private Assertion_DbVerifier assertion_DbVerifier = new Assertion_DbVerifier();
    @DataProvider(name = "dataProvider")
    public static Object[][] dataProvider() {
        return new Object[][]
                {
                        {"ExactMatch"},
                        {"EqualOrGreaterThan"},
                        {"ExcludeUnits"}


                };
    }


    @Test(groups = {"All", "Regression"}, dataProvider = "dataProvider")
    public  void SEVV_TC002262_Model2_ExactMatch_Multi_visits_having_different_adjusted_time(String value) throws InterruptedException, IOException, ParseException, SQLException, java.text.ParseException, ClassNotFoundException {
        Map<String, JSONObject> MapjsonObject=GenerateUniqueParam.ohioclaim_Rest_V2();

        JSONArray claimSubArray= (JSONArray) MapjsonObject.get("rest").get("EVV_Request");
        JSONObject claimSubobject =  (JSONObject) claimSubArray.get(0);
        claimSubobject.put(globalVariables.matchingRulejson, value);
        claimSubobject.put(globalVariables.businnesmedicaidid, "1234567");
        claimSubobject.put(globalVariables.PatientID, "232535325325");
        claimSubobject.put(globalVariables.ServiceStartDate, "2019-09-01");
        claimSubobject.put(globalVariables.ServiceEndDate, "2019-09-01");
        claimSubobject.put(globalVariables.ProcedureCode, "HPC");
        claimSubobject.put(globalVariables.Units, "12");
        claimSubobject.put(globalVariables.ProviderID, "1234567");
        claimSubobject.put(globalVariables.payer, "DODD");

        JSONArray bodyAsArray= CommonMethods.captureMultiResponseClaim_V2(MapjsonObject.get("rest"), CommonMethods.propertyfileReader("Rest_claim"));

        logger.log(LogStatus.INFO,"Verifying the number of visits return");

        Assert.assertEquals(bodyAsArray.size(), 3);

        logger.log(LogStatus.INFO,"Verifying the VisitFound status");

        for(int i = 0; i<bodyAsArray.size(); i++){
            JSONObject visit = (JSONObject) bodyAsArray.get(i);
            Assert.assertEquals(visit.get("VisitFound").toString(),"true");
            assertion_DbVerifier.claim_assertion_DLN_ICN(visit.get("DLN").toString(), visit.get("ICN").toString(),"1");


        }
    }
}
