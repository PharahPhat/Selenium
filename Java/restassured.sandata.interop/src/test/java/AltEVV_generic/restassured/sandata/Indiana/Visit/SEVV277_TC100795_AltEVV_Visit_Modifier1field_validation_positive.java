package AltEVV_generic.restassured.sandata.Indiana.Visit;

import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;

public class SEVV277_TC100795_AltEVV_Visit_Modifier1field_validation_positive extends BaseTest{
	

	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	Assertion_DbVerifier Assertion_DbVerifier= new Assertion_DbVerifier();
	
	@Test(groups = {"All", "Regression"})
	public void TC100795_AltEVV_Visit_Modifier1field_validation_positive() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("TC100795_AltEVV_Visit_Modifier1field_validation_positive");
		logger.log(LogStatus.INFO, "TC100795_AltEVV_Visit_Modifier1field_validation_positive"); 
		
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		
		jsonObjectVisit.put(globalVariables.Modifier1, CommonMethods.generateRandomStringOfFixLength(2));
	
		CommonMethods.validateResponse(jsonArrayVisit,
			CommonMethods.propertyfileReader(globalVariables.altevv_visit));
	}
	
	@Test(groups = {"All", "Regression"})
	public void TC100795_AltEVV_Visit_Modifier1field_alphanumeric() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("TC100795_AltEVV_Visit_Modifier1field_alphanumeric");
		logger.log(LogStatus.INFO, "TC100795_AltEVV_Visit_Modifier1field_alphanumeric"); 
		
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		
		jsonObjectVisit.put(globalVariables.Modifier1, CommonMethods.generateRandomAlphaNumeric(2));
	
		CommonMethods.validateResponse(jsonArrayVisit,
			CommonMethods.propertyfileReader(globalVariables.altevv_visit));
	}
	
	@Test(groups = {"All", "Regression"})
	public void TC100795_AltEVV_Visit_Modifier1field_singlechar() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("TC100795_AltEVV_Visit_Modifier1field_singlechar");
		logger.log(LogStatus.INFO, "TC100795_AltEVV_Visit_Modifier1field_singlechar"); 
		
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		
		jsonObjectVisit.put(globalVariables.Modifier1, CommonMethods.generateRandomStringOfFixLength(1));
	
		CommonMethods.validateResponse(jsonArrayVisit,
			CommonMethods.propertyfileReader(globalVariables.altevv_visit));
	}

}
