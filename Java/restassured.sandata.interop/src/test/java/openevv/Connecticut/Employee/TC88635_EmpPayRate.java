package openevv.Connecticut.Employee;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @author RRohiteshwar
 */
//Test Case 88635:Open EVV-Worker-Validate (mix) - PayRate field formats/values

public class TC88635_EmpPayRate extends BaseTest
{
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	//To validate the valid PayRate length min 4
	@Test(groups = {"All"})
	public void TC88635_OpenEVV_Emp_valid_PayRate_length_4_2afterdeci() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("TC88635_OpenEVV_Emp_valid_PayRate_length_4_2afterdeci");

		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("PayRate", CommonMethods.getRandomDoubleBetweenRange(1, 9));

		CommonMethods.validateResponse(j,
				CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
	}

	//To validate the valid PayRate length min 4
	@Test(groups = {"All"})
	public void TC88635_OpenEVV_Emp_valid_PayRate_length_4_2beforedeci() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("TC88635_OpenEVV_Emp_valid_PayRate_length_4_2beforedeci");

		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("PayRate", CommonMethods.getRandomDouble_Two_Decimal(11, 15));

		CommonMethods.validateResponse(j,
				CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
	}

	//To validate the valid PayRate length min 4
	@Test(groups = {"All"})
	public void TC88635_OpenEVV_Emp_valid_PayRate_length_4_2beforedeci_2afterdeci() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("TC88635_OpenEVV_Emp_valid_PayRate_length_4_2beforedeci_2afterdeci");

		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("PayRate", "54.23");

		CommonMethods.validateResponse(j,
				CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));

	}

	//To validate the invalid PayRate with leading space
	@Test(groups = {"All"})
	public void TC88635_OpenEVV_Emp_invalid_PayRate_leadingSpace() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("TC88635_OpenEVV_Emp_invalid_PayRate_leadingSpace");

		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);

		//Making json values dynamic
		JSONObject jsonObject = (JSONObject) j.get(0);
		jsonObject.put("PayRate", " " + CommonMethods.getRandomDoubleBetweenRange(0, 4));

		CommonMethods.capturePostResponse_400(j,
				CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
	}

	@Test(groups = {"All"})
	public void TC88635_OpenEVV_Emp_invalid_PayRate_Alpha_only() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("TC88635_OpenEVV_Emp_invalid_PayRate_Alpha_only");

		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("PayRate", CommonMethods.generateRandomStringOfFixLength(1)+ "." +
				CommonMethods.generateRandomStringOfFixLength(1));

		CommonMethods.capturePostResponse_400(j,
				CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
	}
}
