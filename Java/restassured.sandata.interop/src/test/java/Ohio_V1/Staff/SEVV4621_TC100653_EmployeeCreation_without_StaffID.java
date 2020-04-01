package Ohio_V1.Staff;

import java.io.IOException;
import java.sql.SQLException;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;

import Utills_ExtentReport_Log4j.BaseTest;

public class SEVV4621_TC100653_EmployeeCreation_without_StaffID extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OhioStaff")
	@SuppressWarnings("unused")
	public void TC100653_EmployeeCreation_passing_jsontwice_without_StaffID() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, Exception {

			// logger = extent.startTest("TC100653_EmployeeCreation_passing_jsontwice_without_StaffID");

			JSONArray jsonArr=GenerateUniqueParam.EmpParams_Ohio_V1(globalVariables.ThreeP_Staff_Json);

			JSONObject jsonobject = (JSONObject) jsonArr.get(0);
		
			jsonobject.put("StaffID", CommonMethods.generateRandomNumberOfFixLength(9));

			String bodyAsString = CommonMethods.captureResponseOhio_v1(jsonArr, CommonMethods.propertyfileReader(globalVariables.ohio_staff_v1));
			
			
			String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v1(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_staff_get_v1));
	
			jsonobject.remove("StaffID");

			String bodyAsStringnew = CommonMethods.captureResponseOhio_v1(jsonArr, CommonMethods.propertyfileReader(globalVariables.ohio_staff_v1));
			Thread.sleep(2000);
			Assert.assertTrue(bodyAsStringnew.contains("Transaction Received."));
			
		
		}

}
