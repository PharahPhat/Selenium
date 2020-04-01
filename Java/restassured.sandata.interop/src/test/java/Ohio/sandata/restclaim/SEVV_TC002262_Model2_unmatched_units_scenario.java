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

public class SEVV_TC002262_Model2_unmatched_units_scenario extends BaseTest {

    private com.globalMethods.core.GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
    private Assertion_DbVerifier assertion_DbVerifier = new Assertion_DbVerifier();

    @DataProvider(name = "dataProvider")
    public static Object[][] dataProvider() {
        return new Object[][]
                {
                        {"ExactMatch"},
                        {"EqualOrGreaterThan"}

                };
    }


    @Test(groups = {"All", "Regression"}, dataProvider = "dataProvider")

    public  void SEVV_TC002262_Model2_unmatched_units_scenario(String value) throws InterruptedException, IOException, ParseException, SQLException, java.text.ParseException, ClassNotFoundException {
        Map<String, JSONObject> MapjsonObject=GenerateUniqueParam.ohioclaim_Rest_V2();


        JSONArray claimSubArray= (JSONArray) MapjsonObject.get("rest").get("EVV_Request");
        JSONObject claimSubobject =  (JSONObject) claimSubArray.get(0);
        claimSubobject.put(globalVariables.matchingRulejson, value);
        claimSubobject.put(globalVariables.businnesmedicaidid, "1234567");
        claimSubobject.put(globalVariables.PatientID, "128128128128");
        claimSubobject.put(globalVariables.ServiceStartDate, "2019-10-08");
        claimSubobject.put(globalVariables.ServiceEndDate, "2019-10-08");
        claimSubobject.put(globalVariables.ProcedureCode, "HPC");
        claimSubobject.put(globalVariables.Units, "14");
        claimSubobject.put(globalVariables.ProviderID, "1234567");
        claimSubobject.put(globalVariables.payer, "DODD");

        JSONArray bodyAsArray= CommonMethods.captureMultiResponseClaim_V2(MapjsonObject.get("rest"), CommonMethods.propertyfileReader("Rest_claim"));

        logger.log(LogStatus.INFO,"Verifying the number of visits return");

        Assert.assertEquals(bodyAsArray.size(),1);

        logger.log(LogStatus.INFO,"Verifying the unmatched units message");

        for(int i = 0; i<bodyAsArray.size(); i++){
            JSONObject visit = (JSONObject) bodyAsArray.get(i);
            Assert.assertEquals(visit.get("VisitFound").toString(),"false");
            Assert.assertEquals(visit.get("Details").toString(),"Unmatched Units");
            assertion_DbVerifier.claim_assertion_DLN_ICN(visit.get("DLN").toString(), visit.get("ICN").toString(),"0");

        }

    }
}
