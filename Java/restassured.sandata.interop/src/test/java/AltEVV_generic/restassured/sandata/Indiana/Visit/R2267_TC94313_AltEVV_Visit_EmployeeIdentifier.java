package AltEVV_generic.restassured.sandata.Indiana.Visit;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

public class R2267_TC94313_AltEVV_Visit_EmployeeIdentifier extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	
	@Test(groups = {"All"})
	public void R2267_TC94313_AltEVV_EmployeeIdentifier_validValue() throws InterruptedException, IOException,
			ParseException, SQLException, ClassNotFoundException, java.text.ParseException{
		// logger = extent.startTest("R2267_TC94313_AltEVV_EmployeeIdentifier_validValue");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		
		CommonMethods.validateResponse(jsonArrayVisit,
				CommonMethods.propertyfileReader(globalVariables.altevv_visit));
	}
	
	@Test(groups = {"All"})
	public void R2267_TC94313_AltEVV_EmployeeIdentifier_greaterThan_Max() throws InterruptedException, IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException{
		// logger = extent.startTest("R2267_TC94313_AltEVV_EmployeeIdentifier_greaterThan_Max");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.VisitEmployeeIdentifierjson,
				CommonMethods.generateRandomNumberOfFixLength(10));
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
				CommonMethods.propertyfileReader(globalVariables.altevv_visit));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmpIdentifierLengthError);
	}

	@Test(groups = {"All"})
	public void R2267_TC94313_AltEVV_EmployeeIdentifier_null() throws InterruptedException, IOException, ParseException, SQLException{
		// logger = extent.startTest("R2267_TC94313_AltEVV_EmployeeIdentifier_null");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.VisitEmployeeIdentifierjson,null);
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
				CommonMethods.propertyfileReader(globalVariables.altevv_visit));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.errorEmployeeIdentifierNull);
	}
	
	@Test(groups = {"All"})
	public void R2267_TC94313_AltEVV_EmployeeIdentifier_specialChar() throws InterruptedException, IOException, ParseException, SQLException{
		
		// logger = extent.startTest("R2267_TC94313_AltEVV_EmployeeIdentifier_specialChar");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.VisitEmployeeIdentifierjson,CommonMethods.generateSpecialChar(5));
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
				CommonMethods.propertyfileReader(globalVariables.altevv_visit));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.errorEmployeeIdentifierFormat);
	}
}
