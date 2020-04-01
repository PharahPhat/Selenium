/**
 * 
 */
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

/**
 * @author RRohiteshwar
 *
 */

public class TC95796_Xref_EmployeeQual_Employepin_and_ClientQual_ClientID extends BaseTest
{
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	//To validate valid ClientAddressLine1_ClientAddressline2 accepts dash

	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC95796_Xref_EmployeeQual_Employepin_and_ClientQual_ClientID_valid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException, ClassNotFoundException
	{
		// logger = extent.startTest("TC95796_Xref_EmployeeQual_Employepin_and_ClientQual_ClientID_valid");
		
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);
		JSONObject jsonobject = (JSONObject) jsonarray.get(0);
		jsonobject.put("EmployeeQualifier", "EmployeePIN");
		jsonobject.put("ClientIDQualifier", "ClientID");
		
		CommonMethods.validateResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

	}

}
	
