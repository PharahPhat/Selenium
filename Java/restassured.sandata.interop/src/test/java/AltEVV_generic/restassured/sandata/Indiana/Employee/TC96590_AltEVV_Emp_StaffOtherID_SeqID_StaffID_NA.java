package AltEVV_generic.restassured.sandata.Indiana.Employee;

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
 * @author MayankM
 */

public class TC96590_AltEVV_Emp_StaffOtherID_SeqID_StaffID_NA extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	@Test(groups = {"All"})
	public void TC96590_AltEVV_Emp_StaffOtherID_SeqID_StaffID_blank() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC96590_AltEVV_Emp_StaffOtherID_SeqID_StaffID_blank");

		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV(globalVariables.Staff_intake);
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeOtherID","");
		js.put("EmployeeIdentifier","");

		String bodyAsString = CommonMethods.capturePostResponse(j,
				CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.errorEmployeeIdentifierFormat);
	}

	@Test(groups = {"All"})
	public void TC96590_AltEVV_Emp_StaffOtherID_SeqID_StaffID_null() throws InterruptedException,  IOException, ParseException
	{
		// logger = extent.startTest("TC96590_AltEVV_Emp_StaffOtherID_SeqID_StaffID_null");

		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV(globalVariables.Staff_intake);
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeOtherID",null);
		js.put("SequenceID",null);
		js.put("EmployeeIdentifier",null);

		String bodyAsString = CommonMethods.capturePostResponse(j,
				CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeeIdentifier_Error);
	}

	@Test(groups = {"All"})
	public void TC96590_AltEVV_Emp_StaffOtherID_SeqID_StaffID_Not_Present() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC96590_AltEVV_Emp_StaffOtherID_SeqID_StaffID_Not_Present");

		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV(globalVariables.Staff_intake);
		JSONObject js = (JSONObject) j.get(0);
		js.remove("EmployeeOtherID");
		js.remove("SequenceID");
		js.remove("EmployeeIdentifier");

		String bodyAsString = CommonMethods.capturePostResponse(j,
				CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeeIdentifier_Error);
	}

}
