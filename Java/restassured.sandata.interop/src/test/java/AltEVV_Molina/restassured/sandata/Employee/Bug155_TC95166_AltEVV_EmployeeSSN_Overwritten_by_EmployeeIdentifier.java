package AltEVV_Molina.restassured.sandata.Employee;

import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import Utills_ExtentReport_Log4j.BaseTest;

//Test Case 95166:Validate if EmployeeQualifier is "EmployeeSSN", EmployeeSSN will be overwritten by EmployeeIdentifier

import com.globalMethods.core.Assertion_DbVerifier;
public class Bug155_TC95166_AltEVV_EmployeeSSN_Overwritten_by_EmployeeIdentifier extends BaseTest {

	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	@Test(groups = {"ALL"})
	public void TC95166_AltEVV_EmployeeQualifier_with_EmployeeSSN_Valid_Value() throws IOException, ParseException
	{
		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("EmployeeQualifier", "EmployeeSSN");
		jsonObject.put("EmployeeIdentifier", CommonMethods.generateRandomNumberOfFixLength(9));
		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));
	}

	@DataProvider(name = "dataProvider")
	public static Object[][] dataProvider() {
		return new Object[][]{
				{CommonMethods.generateRandomNumberOfFixLength(10), globalVariables.StaffSSNFormatError},
				{null, "The EmployeeSSN cannot be NULL"},
				{"",globalVariables.StaffSSNFormatError}};}

	@Test(dataProvider = "dataProvider")
	public void TC95166_AltEVV_EmployeeQualifier_with_EmployeeSSN_Invalid_Value(String value, String errorMessage) throws IOException, ParseException
	{
		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("EmployeeSSN", value);

		String bodyAsString =CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, errorMessage);
	}
}