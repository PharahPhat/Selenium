package AltEVV_generic.restassured.sandata.Indiana.Visit;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

public class SEVV15231_TC37463_AltEVV_Indiana_Sent_Multi_Request_Same_SequenceID_ClientID_EmployeeID_DIFF_VisitOtherID extends BaseTest {
    private GenerateUniqueParam generateUniqueParam = new GenerateUniqueParam();

    @Test(groups = {"PA_Visit", "fixing"})
    public void TC37463_AltEVV_Indiana_Sent_Multi_Request_Same_SequenceID_ClientID_EmployeeID_DIFF_VisitOtherID() throws
            ParseException, IOException, InterruptedException {
        JSONArray jsonArrayVisit = generateUniqueParam.multiVisitParams_AltEVV(2);
        JSONObject jsonObject = (JSONObject) jsonArrayVisit.get(0);
        jsonObject.put(globalVariables.VisitOtherID, CommonMethods.generateRandomAlphaNumeric(50));

        CommonMethods.verifyPostResponse(jsonArrayVisit,
                CommonMethods.propertyfileReader(globalVariables.altevv_visit),
                CommonMethods.propertyfileReader(globalVariables.altevv_visit_get));
    }
}
