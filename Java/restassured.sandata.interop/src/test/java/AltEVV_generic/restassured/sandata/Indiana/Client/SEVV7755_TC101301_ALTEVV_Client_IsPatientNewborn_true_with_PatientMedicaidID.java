package AltEVV_generic.restassured.sandata.Indiana.Client;

import Utills_ExtentReport_Log4j.BaseTest;
import com.AltEVV.client.generic_v1_1.GlobalVariable_generic;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

/**
 * @author Anupam
 *
 */
public class SEVV7755_TC101301_ALTEVV_Client_IsPatientNewborn_true_with_PatientMedicaidID extends BaseTest{
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	
	@Test(groups = {"All", "Regression"})
	public void TC101301_ALTEVV_Client_IsPatientNewborn_true_with_PatientMedicaidID_Is_Null() throws Exception
	{			
		// logger = extent.startTest("TC101301_ALTEVV_ClientGenInfo_IsPatientnewborn_true_with_PatientMedicaidID");
		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put(globalVariables.ClientMedicaidID, null);

		//Indicate that a patient is a newborn.If this value is provided, Client Medicaid ID will be ignored and will be valid as null.Values True/False
		jsonObject.put(GlobalVariable_generic.MissingMedicaidID, true);

		logger.log(LogStatus.INFO, GlobalVariable_generic.PostGetLog);
		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));
	}
	
	@Test(groups = {"All", "Regression"})
	public void TC101301_ALTEVV_Client_IsPatientNewborn_true_with_PatientMedicaidID() throws Exception
	{			
		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		//Indicate that a patient is a newborn.If this value is provided, Client Medicaid ID will be ignored and will be valid as null.Values True/False
		jsonObject.put(GlobalVariable_generic.MissingMedicaidID, true);
				
		logger.log(LogStatus.INFO, GlobalVariable_generic.PostGetLog);
		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));
	}

	@Test(groups = {"All", "Regression"})
	public void TC101301_ALTEVV_Client_IsPatientNewborn_false_with_PatientMedicaidID() throws Exception
	{
		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		//Indicate that a patient is a newborn.If this value is provided, Client Medicaid ID will be ignored and will be valid as null.Values True/False
		jsonObject.put(GlobalVariable_generic.MissingMedicaidID, false);

		logger.log(LogStatus.INFO, GlobalVariable_generic.PostGetLog);
		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));
	}
}
