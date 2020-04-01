package openevv.PA.Authorization;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class SEVV_18559_TC40770_ClientQualifier_field_Validation extends BaseTest {
	
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	@Test(groups = {"All"})
    public void TC95399_ClientQualifier_Valid_validation() throws Exception {
        // // logger = extent.startTest("TC95399_Validate_ClientQualifier_field_for_Invalid_null");

        JSONArray jsonArray = GenerateUniqueParam.OpenEVV_auth(globalVariables.Auth_json);
        CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.openEVV_auth));

    }

    @Test(groups = {"All"})
    public void TC95399_ClientQualifier_inValid_PA_validation() throws Exception {
        // // logger = extent.startTest("TC95399_Validate_ClientQualifier_field_for_Invalid_null");

        JSONArray jsonArray = GenerateUniqueParam.OpenEVV_auth(globalVariables.Auth_json);

        JSONObject jsonObject = (JSONObject) jsonArray.get(0);
        if (!state.equalsIgnoreCase("PA")) {
            jsonObject.put("ClientQualifier", "ClientMedicaidIDa");
            String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.openEVV_auth));
            CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientQualifierFormatError);
        }
    }

    @Test(groups = {"All"})
    public void TC95399_Validate_ClientQualifier_field_for_Invalid_null() throws Exception
	{
		// // logger = extent.startTest("TC95399_Validate_ClientQualifier_field_for_Invalid_null");

		JSONArray jsonArray=GenerateUniqueParam.OpenEVV_auth(globalVariables.Auth_json);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("ClientQualifier", null);
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.openEVV_auth));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientQualifierNullError);
	}
	
	@Test(groups = {"All"})
    public void TC95399_Validate_ClientQualifier_field_for_Invalid_other_than_valid() throws Exception
	{
		// // logger = extent.startTest("TC95399_Validate_ClientQualifier_field_for_Invalid_other_than_invalid");

		JSONArray jsonArray=GenerateUniqueParam.OpenEVV_auth(globalVariables.Auth_json);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("ClientQualifier", CommonMethods.generateRandomStringOfFixLength(9));
		
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.openEVV_auth));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientQualifierFormatError);
		
	
	
	}
	
	@Test(groups = {"All"})
    public void TC95399_Validate_ClientQualifier_field_for_Invalid_blank() throws Exception
	{
		// // logger = extent.startTest("TC95399_Validate_ClientQualifier_field_for_Invalid_blank");

		JSONArray jsonArray=GenerateUniqueParam.OpenEVV_auth(globalVariables.Auth_json);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("ClientQualifier", "");
		
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.openEVV_auth));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientQualifierFormatError);
		
	
	
	}
	
	@Test(groups = {"All"})
    public void TC95399_Validate_ClientQualifier_field_for_Invalid_more_than_allowed_length() throws Exception
	{
		// // logger = extent.startTest("TC95399_Validate_ClientQualifier_field_for_Invalid_more_than_allowed_length");

		JSONArray jsonArray=GenerateUniqueParam.OpenEVV_auth(globalVariables.Auth_json);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("ClientQualifier", CommonMethods.generateRandomStringOfFixLength(21));
		
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.openEVV_auth));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientQualifierFormatError);
		
	
	
	}
	

}
