package AltEVV_Molina.restassured.sandata.Employee;

import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;

import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author MayankM
 *
 */
import com.globalMethods.core.Assertion_DbVerifier; public class TC96590_AltEVV_Emp_StaffOtherID_SeqID_StaffID_NA extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	@Test(groups = {"All", "Regression"})
	public void TC96590_AltEVV_Emp_StaffOtherID_SeqID_StaffID_blank() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("TC96590_AltEVV_Emp_StaffOtherID_SeqID_StaffID_blank");

		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeOtherID","");
		js.put("EmployeeIdentifier","");

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.StaffOtherIDFormatError);
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.StaffIDFormatErrorMolina);
	}

	@Test(groups = {"All", "Regression"})
	public void TC96590_AltEVV_Emp_StaffOtherID_SeqID_StaffID_null() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("TC96590_AltEVV_Emp_StaffOtherID_SeqID_StaffID_null");

		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeOtherID",null);
		js.put("SequenceID",null);
		js.put("EmployeeIdentifier",null);

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.StaffSequenceIDNullError);
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.StaffIDNullError);
	}

	@Test(groups = {"All", "Regression"})
	public void TC96590_AltEVV_Emp_StaffOtherID_SeqID_StaffID_Not_Present() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("TC96590_AltEVV_Emp_StaffOtherID_SeqID_StaffID_Not_Present");

		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);
		JSONObject js = (JSONObject) j.get(0);
		js.remove("EmployeeOtherID");
		js.remove("SequenceID");
		js.remove("EmployeeIdentifier");

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.StaffSequenceIDNullError);
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.StaffIDNullError);
	}

}
