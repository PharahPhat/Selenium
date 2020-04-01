package openevv.PA.Member;

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

/**
 * @author MayankM
 */
//OpenEVV Member: Validate maximum length for ClientMedicalRecordNumber(12)

public class R2223_TC94482_OpenEVV_Member_MemberMedicalRecordNum_MaxLength extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	@Test(groups = {"All"})
	public void R2223_TC94482_OpenEVV_Member_MemberMedicalRecordNum_MaxLength_valid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("R2223_TC94482_OpenEVV_Member_MemberMedicalRecordNum_MaxLength_valid");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put(globalVariables.ClientMedicalRecordNumber, CommonMethods.generateRandomStringOfFixLength(12));

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.member_post_url));
	}

	@Test(groups = {"All"})
	public void R2223_TC94482_OpenEVV_Member_MemberMedicalRecordNum_MaxLength_invalid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("R2223_TC94482_OpenEVV_Member_MemberMedicalRecordNum_MaxLength_valid");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put(globalVariables.ClientMedicalRecordNumber, CommonMethods.generateRandomStringOfFixLength(13));	

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientMedicalRecordNumberLengthError);
	}
}