package openevv.PA.Authorization;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.List;

public class SEVV_8617_TC102282_Mandatory_only extends BaseTest {
	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	Assertion_DbVerifier assertionDbVerifier=new Assertion_DbVerifier();
	@Test(groups = {"All"})
	public void SEVV_8617_TC102282_Mandatory_only() throws Exception
	{
        List<String> requiredField;

        // // logger = extent.startTest("SEVV_8617_TC102282_Mandatory_only");
        JSONArray jsonArrayrequiredField;

        JSONArray jsonArray = GenerateUniqueParam.OpenEVV_auth(globalVariables.Auth_json);

        JSONObject jsonObject = (JSONObject) jsonArray.get(0);

        requiredField = GenerateUniqueParam.authParamsPipeDelimitedOnlyRequiredField();

        logger.log(LogStatus.INFO, "Removing the non  requiredField");
        requiredField.add("ClientIdentifier");
        jsonArrayrequiredField = CommonMethods.createJsonArrayWithRequiredField(requiredField, jsonObject);

        CommonMethods.validateResponse(jsonArrayrequiredField, CommonMethods.propertyfileReader(globalVariables.openEVV_auth));
    }
}

