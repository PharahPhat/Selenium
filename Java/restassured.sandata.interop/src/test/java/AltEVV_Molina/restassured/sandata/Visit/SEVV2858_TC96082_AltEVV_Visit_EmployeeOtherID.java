package AltEVV_Molina.restassured.sandata.Visit;

/*
@Neeraj

OpenEVV-altEVV- Visits- VisitOtherID field formats/values

*/

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class SEVV2858_TC96082_AltEVV_Visit_EmployeeOtherID extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	
	@Test(groups = {"All"})
	public void SEVV2858_TC96082_AltEVV_EmployeeOtherID_validValue() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException{
		// logger = extent.startTest("SEVV2858_TC96082_AltEVV_EmployeeOtherID_validValue");

		
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.VisitEmployeeOtherID,CommonMethods.generateRandomNumberOfFixLength(64));
		CommonMethods.validateResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));
	}
	
	@Test(groups = {"All"})
	public void SEVV2858_TC96082_AltEVV_EmployeeOtherID_greaterThan_Max() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException{
		// logger = extent.startTest("SEVV2858_TC96082_AltEVV_EmployeeOtherID_greaterThan_Max");


		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.VisitEmployeeOtherID,CommonMethods.generateRandomNumberOfFixLength(65));
		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.errorEmployeeOtherIDlength);
		
	}

	@Test(groups = {"All"})
	public void SEVV2858_TC96082_AltEVV_EmployeeOtherID_AlphaNumeric() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException{
		// logger = extent.startTest("SEVV2858_TC96082_AltEVV_EmployeeOtherID_AlphaNumeric");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
	
		jsonObjectVisit.put(globalVariables.VisitEmployeeOtherID,CommonMethods.generateRandomAlphaNumeric(23));
			
		CommonMethods.validateResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));
	}
	
	@Test(groups = {"All"})
	public void SEVV2858_TC96082_AltEVV_EmployeeOtherID_null() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException{
		// logger = extent.startTest("SEVV2858_TC96082_AltEVV_EmployeeOtherID_null");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
	
		jsonObjectVisit.put(globalVariables.VisitEmployeeOtherID, null);
		
		CommonMethods.validateResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));
	}
	
	@Test(groups = {"All"})
	public void SEVV2858_TC96082_AltEVV_EmployeeOtherID_specialChar() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException{
		
		// logger = extent.startTest("SEVV2858_TC96082_AltEVV_EmployeeOtherID_specialChar");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		
		
		jsonObjectVisit.put(globalVariables.VisitEmployeeOtherID,CommonMethods.generateSpecialChar(5));
		
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.errorEmployeeOtherIDFormat);
		
		
	}
}
