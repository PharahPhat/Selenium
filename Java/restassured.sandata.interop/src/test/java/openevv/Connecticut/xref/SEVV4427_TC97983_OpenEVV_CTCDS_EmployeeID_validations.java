/**
 * 
 */
package openevv.Connecticut.xref;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.*;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Anupam
 *
 */

public class SEVV4427_TC97983_OpenEVV_CTCDS_EmployeeID_validations extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97983_OpenEVV_CTCDS_EmployeeID_validations() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException, ClassNotFoundException
	{
		// logger = extent.startTest("TC97983_OpenEVV_CTCDS_EmployeeID_validations");  // adding method name info via logger
		 
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);
		
		JSONObject jsonobject = (JSONObject) jsonarray.get(0);
		
		jsonobject.put("EmployeeID", CommonMethods.generateRandomNumberOfFixLength(5));
	
		CommonMethods.validateResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));


}

	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97983_OpenEVV_CTCDS_EmployeeID_validations_maxlength() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException, ClassNotFoundException
	{
		// logger = extent.startTest("TC97983_OpenEVV_CTCDS_EmployeeID_validations_maxlength");  // adding method name info via logger
		 
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);
		
		JSONObject jsonobject = (JSONObject) jsonarray.get(0);
		
		jsonobject.put("EmployeeID", CommonMethods.generateRandomNumberOfFixLength(5));
	
		CommonMethods.validateResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));


}
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97983_OpenEVV_CTCDS_EmployeeID_validations_leading_zero() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException, ClassNotFoundException
	{
		// logger = extent.startTest("TC97983_OpenEVV_CTCDS_EmployeeID_validations_leading_zero");  // adding method name info via logger
		 
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);
		
		JSONObject jsonobject = (JSONObject) jsonarray.get(0);
		
		jsonobject.put("EmployeeID", "00" + CommonMethods.generateRandomNumberOfFixLength(3));
	
		CommonMethods.validateResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

	}
}
