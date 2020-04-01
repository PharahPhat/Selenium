package openevv.Connecticut.Employee;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

/**
 * @author MayankM
 *
 */

//Test Case 88259:Open EVV -Worker-Load-Maximum Values

public class Bug_88400_TC88789_Emp_MaxValues_Type_Disc_Dept extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	//To validate the employee with fields populated with maximum length values
	@Test(groups = {"All"})
	public void Bug_88400_TC88789_OpenEVV_Emp_Populated_with_Max_values() throws Exception
	{
		// logger = extent.startTest("Bug_88400_TC88789_OpenEVV_Emp_Populated_with_Max_values");
		 
		JSONArray jsonArray = GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.openevv_emp_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("Discipline", CommonMethods.generateRandomStringOfFixLength(17));
		jsonObject.put("Department", CommonMethods.generateRandomStringOfFixLength(3));
		
		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
	}
}



