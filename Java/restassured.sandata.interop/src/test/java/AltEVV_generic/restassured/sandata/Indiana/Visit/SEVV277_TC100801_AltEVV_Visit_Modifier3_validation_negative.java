package AltEVV_generic.restassured.sandata.Indiana.Visit;

import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;

public class SEVV277_TC100801_AltEVV_Visit_Modifier3_validation_negative extends BaseTest{
	
	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	
	@Test(groups = {"All", "Regression"})
	public void TC100801_AltEVV_Visit_Modifier3_with_specialchars() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("TC100801_AltEVV_Visit_Modifier3_with_specialchars");
		logger.log(LogStatus.INFO, "TC100801_AltEVV_Visit_Modifier3_with_specialchars"); 
		
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		
		jsonObjectVisit.put(globalVariables.Modifier3, CommonMethods.generateRandomStringOfFixLength(1) +CommonMethods.generateSpecialChar(1));
	
		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
			CommonMethods.propertyfileReader(globalVariables.altevv_visit));
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.Modifier3FormatError);
		
	}
	@Test(groups = {"All", "Regression"})
	public void SEVV277_TC100801_AltEVV_Visit_Modifier3_exceeds_maxlength() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("SEVV277_TC100801_AltEVV_Visit_Modifier3_exceeds_maxlength");
		logger.log(LogStatus.INFO, "SEVV277_TC100801_AltEVV_Visit_Modifier3_exceeds_maxlength"); 
		
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		
		jsonObjectVisit.put(globalVariables.Modifier3, CommonMethods.generateRandomStringOfFixLength(3));
	
		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
			CommonMethods.propertyfileReader(globalVariables.altevv_visit));
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.Modifier3LengthErrorgneric);
		
		
	}
	
	@Test(groups = {"All", "Regression"})
	public void SEVV277_TC100801_AltEVV_Visit_Modifier3_with_leadingspace() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("SEVV277_TC100801_AltEVV_Visit_Modifier3_with_leadingspace");
		logger.log(LogStatus.INFO, "SEVV277_TC100801_AltEVV_Visit_Modifier3_with_leadingspace"); 
		
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		
		jsonObjectVisit.put(globalVariables.Modifier3, " " +CommonMethods.generateRandomNumberOfFixLength(1));
	
		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
			CommonMethods.propertyfileReader(globalVariables.altevv_visit));
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.Modifier3FormatError);
		
		
	}
	
	@Test(groups = {"All", "Regression"})
	public void SEVV277_TC100801_AltEVV_Visit_Modifier3_with_trailingspace() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("SEVV277_TC100801_AltEVV_Visit_Modifier3_with_trailingspace");
		logger.log(LogStatus.INFO, "SEVV277_TC100801_AltEVV_Visit_Modifier3_with_trailingspace"); 
		
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		
		jsonObjectVisit.put(globalVariables.Modifier3, CommonMethods.generateRandomNumberOfFixLength(1) +" " );
	
		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
			CommonMethods.propertyfileReader(globalVariables.altevv_visit));
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.Modifier3FormatError);
		
	}

}
