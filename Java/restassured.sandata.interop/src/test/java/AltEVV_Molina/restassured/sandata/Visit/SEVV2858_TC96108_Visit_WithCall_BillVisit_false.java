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

import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;
import junit.framework.Assert;

/**
 * @author Neeraj
 *
 */
import com.globalMethods.core.Assertion_DbVerifier; 

public class SEVV2858_TC96108_Visit_WithCall_BillVisit_false extends BaseTest { 
	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); 
	Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	
	
	
		@Test(groups = {"All"})
		public void SEVV2858_TC96108_Visit_WithCall_BillVisit_false_method() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException
		{
			// logger = extent.startTest("R2267_TC92430_Visit_WithoutCall_BillVisit_false");
			 

			JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
			JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
			jsonObjectVisit.put(globalVariables.BillVisitjson,false);
			
			CommonMethods.validateResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));
}
}
