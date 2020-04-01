/**
 * 
 */
package AltEVV_Molina.restassured.sandata.Visit;

import java.io.IOException;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

/**
 * @author Neeraj
 *
 */
import com.globalMethods.core.*;
import Utills_ExtentReport_Log4j.BaseTest;

public class SEVV2858_TC96108_Visit_WithoutCall_BillVisit_false extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
		
		@Test(groups = {"All"})
		public void SEVV2858_TC96108_Visit_WithoutCall_BillVisit_false_valid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
		{
			// logger = extent.startTest("SEVV2858_TC96108_Visit_WithoutCall_BillVisit_false");
			 

			JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
			JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
			jsonObjectVisit.put(globalVariables.BillVisitjson,false);
			
			jsonObjectVisit.remove("Calls");
			
			CommonMethods.validateResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));
		}
		
		@Test(groups = {"All"})
		public void SEVV2858_TC96108_Visit_BillVisit_passed_with_null() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
		{
			// logger = extent.startTest("TC96108_Visit_BillVisit_passed_with_null");
			 

			JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
			JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
			jsonObjectVisit.put(globalVariables.BillVisitjson, null);
			
			String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));
			
			CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.BillVisitNull);
}
}
