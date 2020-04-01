package openevv.PA.Member;

import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.ohio.intake.patient.v1.DataGeneratorV1;

import Utills_ExtentReport_Log4j.BaseTest;

import com.globalMethods.core.Assertion_DbVerifier; 

public class R2223_TC94698_OpenEVV_Member_Validate_maximum_length_for_ClientContactEmailAddress extends BaseTest { 
	
	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); 
	Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	DataGeneratorV1 dataGenerator=new DataGeneratorV1();
	
	@Test(groups = {"All"})
	public void R2223_TC94522_OpenEVV_Member_Validate_maximum_length_for_ClientContactEmailAddress_morethan64() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R2223_TC94522_OpenEVV_Member_Validate_maximum_length_for_ClientContactEmailAddress_morethan64");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONObject jsonObjectClientContact=dataGenerator.subArrayCreation(jsonObject,"ClientContact", 0);

		jsonObjectClientContact.put(globalVariables.ClientContactEmailAddress, CommonMethods.generateRandomNumberOfFixLength(55));	

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactEmailAddresserror);
	}
	

}
