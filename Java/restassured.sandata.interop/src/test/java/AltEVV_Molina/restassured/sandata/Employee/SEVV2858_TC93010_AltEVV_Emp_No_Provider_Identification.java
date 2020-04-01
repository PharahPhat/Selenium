package AltEVV_Molina.restassured.sandata.Employee;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.globalMethods.core.globalVariables.ACCID;
import static com.globalMethods.core.globalVariables.ProviderID;

public class SEVV2858_TC93010_AltEVV_Emp_No_Provider_Identification extends BaseTest {

	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	//Validate the invalid without provider id
	@Test(groups = {"All", "Regression"})
	public void SEVV2858_TC93010_AltEVV_Emp_Values_No_ProviderID() throws InterruptedException, IOException, ParseException
	{
		logger.log(LogStatus.INFO, "//Validate the invalid without provider id");
		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);
		JSONObject js = (JSONObject) j.get(0);
		JSONObject jsonObjectPay =  (JSONObject) js.get("ProviderIdentification");
		jsonObjectPay.remove("ProviderID");
		CommonMethods.capturePostResponse_500(j, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));
	}

	@DataProvider(name = "dataProvider")
	public static Object[][] dataProvider() {
		return new Object[][]{
				{"SandataID"},
//				{"NPI"},
//				{"API"},
				{"MedicaidID"}};
//				{"TaxID"},
//				{"Taxonomy"},
//				{"Legacy"},
//				{"Other"}};}
	}
	@Test(dataProvider = "dataProvider")
	public void SEVV2858_TC93010_AltEVV_ProviderQualifier_valid_value(String value) throws IOException, ParseException
	{
		logger.log(LogStatus.INFO, "validating valid altEVV client validation for providerQualifier field with expected values");
		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONObject jsonObjectPay =  (JSONObject) jsonObject.get("ProviderIdentification");
		if (value.equalsIgnoreCase("SandataID")) {
			jsonObjectPay.put(ProviderID, stateInfo.get(ACCID));
		}
		jsonObjectPay.put("ProviderQualifier", value);
		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));
	}

	@DataProvider(name = "dataProviderInvalid")
	public static Object[][] dataProviderInvalid() {
		return new Object[][]{
				{"", globalVariables.ProvideQualifier_generic},
				{null, globalVariables.ProvideQualifier_null},
				{"API ", globalVariables.ProvideQualifier_generic},
				{" API", globalVariables.ProvideQualifier_generic}};}

	@Test(dataProvider = "dataProviderInvalid")
	public void SEVV2858_TC93010_AltEVV_ProviderQualifier_Invalid_value(String value, String errorMessage) throws IOException, ParseException
	{
		logger.log(LogStatus.INFO, "validating valid altEVV client validation for providerQualifier field with invalid values");
		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONObject jsonObjectPay =  (JSONObject) jsonObject.get("ProviderIdentification");
		jsonObjectPay.put("ProviderQualifier", value);
		String bodyAsString =CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));

		CommonMethods.verifyjsonassertFailcase(bodyAsString,
				errorMessage);
	}

}