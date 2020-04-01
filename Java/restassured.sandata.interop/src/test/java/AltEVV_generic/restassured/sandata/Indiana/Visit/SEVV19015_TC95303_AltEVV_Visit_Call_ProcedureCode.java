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

public class SEVV19015_TC95303_AltEVV_Visit_Call_ProcedureCode extends BaseTest {
    private com.globalMethods.core.GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

    @Test(groups = {"All"})
    public void R19015_TC95303_AltEVV_Visit_Call_ProcedureCode_Optional_validation() throws  IOException, ParseException{

        JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
        JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

        JSONArray jsonArrayVisitCalls = (JSONArray) jsonObjectVisit.get("Calls");
        JSONObject jsonObjectVisitCalls =  (JSONObject) jsonArrayVisitCalls.get(0);
        jsonObjectVisitCalls.put(globalVariables.CallProcedureCode, "");

        JSONObject jsonObjectVisitCalls1 =  (JSONObject) jsonArrayVisitCalls.get(1);
        jsonObjectVisitCalls1.put(globalVariables.CallProcedureCode, null);

        CommonMethods.validateResponse(jsonArrayVisit,
                CommonMethods.propertyfileReader(globalVariables.altevv_visit));
    }

    @Test(groups = {"All"})
    public void R19015_TC95303_AltEVV_Visit_Call_ProcedureCode_invalid_validation() throws  IOException, ParseException{


        JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
        JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

        JSONArray jsonArrayVisitCalls = (JSONArray) jsonObjectVisit.get("Calls");
        JSONObject jsonObjectVisitCalls =  (JSONObject) jsonArrayVisitCalls.get(0);

        if(state.equalsIgnoreCase("Vermont")) {
            jsonObjectVisitCalls.put(globalVariables.CallProcedureCode, "T1001011");
            String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_visit));
            CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.errorProcedureCodelength);
        } else {

            jsonObjectVisitCalls.put(globalVariables.CallProcedureCode, "T100101");
            String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_visit));
            CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.errorProcedureCodelength);


        }


    }
}
