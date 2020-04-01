package AltEVV_generic.restassured.sandata.Indiana.Visit;

/*
@Neeraj

OpenEVV-altEVV- Visits- PayorProgram field formats/values

*/
import java.io.FileNotFoundException;
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
import Utills_ExtentReport_Log4j.BaseTest;

public class R2267_TC94319_TC103062_AltEVV_Visit_PayerProgram extends BaseTest {
	
	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	


	@Test(groups = {"All"})
	public void R2267_TC94319_AltEVV_PayerProgram_AlphaNumeric() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException{
		// logger = extent.startTest("R2267_TC7463_AltEVV_PayerProgram_AlphaNumeric");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
	//	As per requirement specification, PayerProgram is not generating randomly.
	//	jsonObjectVisit.put(globalVariables.PayerProgram,CommonMethods.generateRandomAlphaNumeric(7));

		CommonMethods.validateResponse(jsonArrayVisit,
				CommonMethods.propertyfileReader(globalVariables.altevv_visit));

	}
	
	@Test(groups = {"All"})
	public void R2267_TC94319_AltEVV_PayerProgram_null() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException{
		// logger = extent.startTest("R2267_TC7463_AltEVV_PayerProgram_null");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
	
		jsonObjectVisit.put(globalVariables.PayerProgram,null);
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
			CommonMethods.propertyfileReader(globalVariables.altevv_visit));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.errorPayorProgramNull);
		
	}
	
	@Test(groups = {"All"})
	public void R2267_TC94319_AltEVV_PayerProgram_specialChar() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException{
		
		// logger = extent.startTest("R2267_TC7463_AltEVV_PayerProgram_specialChar");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
				
		jsonObjectVisit.put(globalVariables.PayerProgram,CommonMethods.generateSpecialChar(5));	
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
			CommonMethods.propertyfileReader(globalVariables.altevv_visit));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.errorPayorProgramSpecialcharFormat);
		
		
	}
}
