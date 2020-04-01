package AltEVV_generic.restassured.sandata.Indiana.Visit;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

public class SEVV277_TC100798_AltEVV_Visit_Modifier4field_validation_positive extends BaseTest{
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	
	@Test(groups = {"All", "Regression"})
	public void TC100798_AltEVV_Visit_Modifier4field_validation_positive() throws InterruptedException, IOException,
			ParseException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("TC100798_AltEVV_Visit_Modifier4field_validation_positive");
		logger.log(LogStatus.INFO, "TC100798_AltEVV_Visit_Modifier4field_validation_positive"); 
		
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.Modifier4, CommonMethods.generateRandomStringOfFixLength(2));
	
		CommonMethods.validateResponse(jsonArrayVisit,
					CommonMethods.propertyfileReader(globalVariables.altevv_visit));
	}
	
	@Test(groups = {"All", "Regression"})
	public void TC100798_AltEVV_Visit_Modifier4field_alphanumeric() throws InterruptedException, IOException,
			ParseException
	{
		// logger = extent.startTest("TC100798_AltEVV_Visit_Modifier4field_alphanumeric");
		logger.log(LogStatus.INFO, "TC100798_AltEVV_Visit_Modifier4field_alphanumeric"); 
		
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.Modifier4, CommonMethods.generateRandomAlphaNumeric(2));
	
		CommonMethods.validateResponse(jsonArrayVisit,
				CommonMethods.propertyfileReader(globalVariables.altevv_visit));
	}
	
	@Test(groups = {"All", "Regression"})
	public void TC100798_AltEVV_Visit_Modifier4field_singlechar() throws InterruptedException, IOException,
			ParseException
	{
		// logger = extent.startTest("TC100798_AltEVV_Visit_Modifier4field_singlechar");
		logger.log(LogStatus.INFO, "TC100798_AltEVV_Visit_Modifier4field_singlechar"); 
		
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.Modifier4, CommonMethods.generateRandomStringOfFixLength(1));
	
		CommonMethods.validateResponse(jsonArrayVisit,
					CommonMethods.propertyfileReader(globalVariables.altevv_visit));
	}
}
