/**
 * 
 */
package openevv.Connecticut.xref;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC95799_Xref_EmployeeQual_EmployeCustomID_and_ClientQual_ClientcustomID extends BaseTest
{
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC95799_Xref_EmployeeQual_EmployeCustomID_and_ClientQual_ClientCustomID_Valid() throws InterruptedException, IOException, ParseException
	{

		// logger = extent.startTest("TC95799_Xref_EmployeeQual_EmployeCustomID_and_ClientQual_ClientcustomID_Valid");
	
		logger.log(LogStatus.INFO, "To validate valid TC95799_Xref_EmployeeQual_EmployeCustomID_and_ClientQual_ClientcustomID_Valid");
		
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);
		JSONObject jsonobject = (JSONObject) jsonarray.get(0);
		jsonobject.put("EmployeeQualifier", "EmployeeCustomID");
		jsonobject.put("ClientIDQualifier", "ClientCustomID");

				
		CommonMethods.validateResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));
	}

}
	
