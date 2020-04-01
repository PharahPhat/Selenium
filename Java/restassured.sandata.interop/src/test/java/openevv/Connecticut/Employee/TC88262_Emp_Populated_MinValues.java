package openevv.Connecticut.Employee;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @author MayankM
 */
//Test Case 88262:Open EVV -Worker-Load-Minimum Values

public class TC88262_Emp_Populated_MinValues extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	//To validate the employee with fields populated with minimum length values
	@Test(groups = {"All"})
	public void TC88262_OpenEVV_Emp_Populated_with_Min_values() throws InterruptedException, IOException, ParseException, java.text.ParseException
	{
		// logger = extent.startTest("TC88262_OpenEVV_Emp_Populated_with_Min_values");
		 
		JSONArray jsonArray = GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_min_openevv_Json);

		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
	}


}



