package AltEVV_generic.restassured.sandata.Indiana.Visit;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

public class SEVV15231_TC37467_AltEVV_Indiana_Sent_Multi_Request_Same_SequenceID_VisitOtherID_DIFF_ClientID_Or_EmployeeID extends BaseTest {
    private GenerateUniqueParam generateUniqueParam = new GenerateUniqueParam();

    @Test(groups = {"PA_Visit"})
    public void TC37467_AltEVV_Indiana_Sent_Multi_Request_Same_SequenceID_VisitOtherID_DIFF_ClientID_Or_EmployeeID() throws
            ParseException, IOException {
        JSONArray jsonArrayVisit = generateUniqueParam.multiVisitParams_AltEVV(2);

        String bodyGet = CommonMethods.capturePostResponse(jsonArrayVisit,
                CommonMethods.propertyfileReader(globalVariables.altevv_visit));

        CommonMethods.verifyjsonassertFailcase(bodyGet, globalVariables.VisitOtherIDDuplicatedError);
    }
}
