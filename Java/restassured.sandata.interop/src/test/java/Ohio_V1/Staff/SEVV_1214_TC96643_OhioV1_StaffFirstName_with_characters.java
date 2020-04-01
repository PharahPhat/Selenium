package Ohio_V1.Staff;

import java.io.IOException;
import java.sql.SQLException;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import Utills_ExtentReport_Log4j.BaseTest; 

public class SEVV_1214_TC96643_OhioV1_StaffFirstName_with_characters extends BaseTest { 
	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); 
	Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OhioStaff")
	public void TC96643_OhioV1_StaffFirstName_with_characters() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, Exception {

		// logger = extent.startTest("TC96643_OhioV1_StaffFirstName_with_characters");

		JSONArray jsonArr=GenerateUniqueParam.EmpParams_Ohio_V1(globalVariables.ThreeP_Staff_Json);

		JSONObject jsonobject = (JSONObject) jsonArr.get(0);
		jsonobject.put("StaffFirstName", CommonMethods.generateRandomStringOfFixLength(4));

		String bodyAsString = CommonMethods.captureResponseOhio_v1(jsonArr, CommonMethods.propertyfileReader(globalVariables.ohio_staff_v1));
		String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v1(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_staff_get_v1));

		assertionDbVerifier.jsonAssert_InboxWorker_Ohio(bodyAsStringget, jsonobject);

	}

	@Test(groups = {"All"})
	@AdditionalInfo(module = "OhioStaff")
	public void TC96643_OhioV1_StaffFirstName_with_singlebrackets() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, Exception {

		// logger = extent.startTest("TC96643_OhioV1_StaffFirstName_with_singlebrackets");

		JSONArray jsonArr=GenerateUniqueParam.EmpParams_Ohio_V1(globalVariables.ThreeP_Staff_Json);

		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		jsonObject.put("StaffFirstName", CommonMethods.generateRandomStringOfFixLength(2) +"(" + CommonMethods.generateRandomStringOfFixLength(3));

		String bodyAsString = CommonMethods.captureResponseOhio_v1(jsonArr, CommonMethods.propertyfileReader(globalVariables.ohio_staff_v1));

		String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v1(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_staff_get_v1));

		assertionDbVerifier.jsonAssert_InboxWorker_Ohio(bodyAsStringget, jsonObject);

	}

	@Test(groups = {"All"})
	@AdditionalInfo(module = "OhioStaff")
	public void TC96643_OhioV1_StaffFirstName_with_brackets() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, Exception {

		// logger = extent.startTest("TC96643_OhioV1_StaffFirstName_with_brackets");

		JSONArray jsonArr=GenerateUniqueParam.EmpParams_Ohio_V1(globalVariables.ThreeP_Staff_Json);

		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		jsonObject.put("StaffFirstName", CommonMethods.generateRandomStringOfFixLength(2) + ")" + CommonMethods.generateRandomStringOfFixLength(3));

		String bodyAsString = CommonMethods.captureResponseOhio_v1(jsonArr, CommonMethods.propertyfileReader(globalVariables.ohio_staff_v1));

		String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v1(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_staff_get_v1));

		assertionDbVerifier.jsonAssert_InboxWorker_Ohio(bodyAsStringget, jsonObject);

	}
}
