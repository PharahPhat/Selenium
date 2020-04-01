/**
 * 
 */
package openevv.Connecticut.xref;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
/**
 * @author RRohiteshwar
 *
 */
import com.globalMethods.core.*;

import Utills_ExtentReport_Log4j.BaseTest; 
public class TC95800_Xref_EmployeeQual_random_and_ClientQual_random extends BaseTest
{
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	//To validate valid ClientAddressLine1_ClientAddressline2 accepts dash
	@SuppressWarnings("unused")
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC95800_Xref_EmployeeQual_num_and_ClientQual_num_valid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException
	{

		// logger = extent.startTest("TC95800_Xref_EmployeeQual_num_and_ClientQual_num_valid");

		logger.log(LogStatus.INFO, "To validate valid TC95800_Xref_EmployeeQual_num_and_ClientQual_num_valid");

		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);
		JSONObject jsonobject = (JSONObject) jsonarray.get(0);
		jsonobject.put("EmployeeQualifier", CommonMethods.generateRandomNumberOfFixLength(7));
		jsonobject.put("ClientIDQualifier", CommonMethods.generateRandomNumberOfFixLength(7));


		String bodyAsString = CommonMethods.capturePostResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientidQualifierFormatError);
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeeidQualifierFormatError);


	}

	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC95800_Xref_EmployeeQual_alpha_and_ClientQual_alpha_valid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException
	{

		// logger = extent.startTest("TC95800_Xref_EmployeeQual_num_and_ClientQual_num_valid");

		logger.log(LogStatus.INFO, "To validate valid TC95800_Xref_EmployeeQual_num_and_ClientQual_num_valid");

		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);
		JSONObject jsonobject = (JSONObject) jsonarray.get(0);
		jsonobject.put("EmployeeQualifier", CommonMethods.generateRandomStringOfFixLength(10));
		jsonobject.put("ClientIDQualifier", CommonMethods.generateRandomStringOfFixLength(10));


		String bodyAsString = CommonMethods.capturePostResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientidQualifierFormatError);
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeeidQualifierFormatError);


	}

	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC95800_Xref_EmployeeQual_alphanum_and_ClientQual_alphanum_valid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException
	{

		// logger = extent.startTest("TC95800_Xref_EmployeeQual_num_and_ClientQual_num_valid");

		logger.log(LogStatus.INFO, "To validate valid TC95800_Xref_EmployeeQual_num_and_ClientQual_num_valid");

		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);
		JSONObject jsonobject = (JSONObject) jsonarray.get(0);
		jsonobject.put("EmployeeQualifier", CommonMethods.generateRandomAlphaNumeric(10));
		jsonobject.put("ClientIDQualifier", CommonMethods.generateRandomAlphaNumeric(10));


		String bodyAsString = CommonMethods.capturePostResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientidQualifierFormatError);
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeeidQualifierFormatError);


	}

}

