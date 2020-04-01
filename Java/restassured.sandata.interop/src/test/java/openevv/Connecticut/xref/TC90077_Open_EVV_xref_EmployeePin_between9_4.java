package openevv.Connecticut.xref;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

public class TC90077_Open_EVV_xref_EmployeePin_between9_4 extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

//To validate the valid Employee_Pin
@Test(groups = {"All"})
@AdditionalInfo(module = "OpenEVV")
public void TC90077_validate_xref_relation_when_EmployeePIN_is_valid_with_9_digits() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException, ClassNotFoundException
{
	// logger = extent.startTest("TC90077_validate_xref_relation_when_EmployeePIN_is_valid_with_9_digits");  // adding method name info via logger

	//Using Reusable method to load client json


	//Making json values dynamic
	JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

	JSONObject jsonobject = (JSONObject) jsonarray.get(0);

	jsonobject.put("EmployeePIN", CommonMethods.generateRandomNumberOfFixLength(9));


	//Using Assert to validate the expected result
	CommonMethods.validateResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));


}

//To validate the valid Employee_Pin
@Test(groups = {"All"})
@AdditionalInfo(module = "OpenEVV")
public void TC90077_validate_xref_relation_when_EmployeePIN_is_valid_with_8_digits() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException, ClassNotFoundException
{
	// logger = extent.startTest("TC90077_validate_xref_relation_when_EmployeePIN_is_valid_with_8_digits");  // adding method name info via logger

	//Using Reusable method to load client json


	//Making json values dynamic
	JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

	JSONObject jsonobject = (JSONObject) jsonarray.get(0);

	jsonobject.put("EmployeePIN", CommonMethods.generateRandomNumberOfFixLength(8));


	//Using Assert to validate the expected result
	CommonMethods.validateResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));


}

  

//To validate the valid Employee_Pin
@Test(groups = {"All"})
@AdditionalInfo(module = "OpenEVV")
public void TC90077_validate_xref_relation_when_EmployeePIN_is_valid_with_7_digits() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException, ClassNotFoundException
{
	// logger = extent.startTest("TC90077_validate_xref_relation_when_EmployeePIN_is_valid_with_7_digits");  // adding method name info via logger

	//Using Reusable method to load client json


	//Making json values dynamic
	JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

	JSONObject jsonobject = (JSONObject) jsonarray.get(0);

	jsonobject.put("EmployeePIN", CommonMethods.generateRandomNumberOfFixLength(7));


	//Using Assert to validate the expected result
	CommonMethods.validateResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));


}
//To validate the valid Employee_Pin
@Test(groups = {"All"})
@AdditionalInfo(module = "OpenEVV")
public void TC90077_validate_xref_relation_when_EmployeePIN_is_valid_with_6_digits() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException, ClassNotFoundException
{
	// logger = extent.startTest("TC90077_validate_xref_relation_when_EmployeePIN_is_valid_with_6_digits");  // adding method name info via logger

	//Using Reusable method to load client json


	//Making json values dynamic
	JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

	JSONObject jsonobject = (JSONObject) jsonarray.get(0);

	jsonobject.put("EmployeePIN", CommonMethods.generateRandomNumberOfFixLength(6));

	//Using Assert to validate the expected result
	CommonMethods.validateResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));
}
//To validate the valid Employee_Pin
@Test(groups = {"All"})
@AdditionalInfo(module = "OpenEVV")
public void TC90077_validate_xref_relation_when_EmployeePIN_is_valid_with_5_digits() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException, ClassNotFoundException
{
	// logger = extent.startTest("TC90077_validate_xref_relation_when_EmployeePIN_is_valid_with_5_digits");  // adding method name info via logger

	//Using Reusable method to load client json


	//Making json values dynamic
	JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

	JSONObject jsonobject = (JSONObject) jsonarray.get(0);

	jsonobject.put("EmployeePIN", CommonMethods.generateRandomNumberOfFixLength(5));


	//Using Assert to validate the expected result
	CommonMethods.validateResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));
}

//To validate the valid Employee_Pin
@Test(groups = {"All"})
@AdditionalInfo(module = "OpenEVV")
public void TC90077_validate_xref_relation_when_EmployeePIN_is_valid_with_4_digits() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException, ClassNotFoundException
{
	// logger = extent.startTest("TC90077_validate_xref_relation_when_EmployeePIN_is_valid_with_4_digits");  // adding method name info via logger

	//Using Reusable method to load client json


	//Making json values dynamic
	JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

	JSONObject jsonobject = (JSONObject) jsonarray.get(0);

	jsonobject.put("EmployeePIN", CommonMethods.generateRandomNumberOfFixLength(4));

	//Using Assert to validate the expected result
	CommonMethods.validateResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));
}

}
