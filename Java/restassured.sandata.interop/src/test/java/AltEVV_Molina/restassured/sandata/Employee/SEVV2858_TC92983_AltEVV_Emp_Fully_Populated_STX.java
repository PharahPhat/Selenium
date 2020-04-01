package AltEVV_Molina.restassured.sandata.Employee;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author MayankM
 */

public class SEVV2858_TC92983_AltEVV_Emp_Fully_Populated_STX extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	//To validate the DB for fully populated employee
	@Test(groups = {"All"})
	public void SEVV2858_TC92983_AltEVV_Employee_Fully_Populated_STX() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, java.text.ParseException, ClassNotFoundException

	{
		// logger = extent.startTest("SEVV2858_TC92983_AltEVV_Employee_Fully_Populated_STX");

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		String bodyAsString = CommonMethods.verifyPostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp),
				CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp_get));

		assertionDbVerifier.jsonAssert_InboxWorker_AltEVV_Molina(bodyAsString, jsonObject);
	
	}


}