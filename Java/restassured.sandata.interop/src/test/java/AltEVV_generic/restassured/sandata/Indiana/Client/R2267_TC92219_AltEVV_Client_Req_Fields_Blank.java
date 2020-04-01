package AltEVV_generic.restassured.sandata.Indiana.Client;

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
//Test Case 92219: Open EVV-altEVV-Client - Required Fields Blank

public class R2267_TC92219_AltEVV_Client_Req_Fields_Blank extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	//Validating AltEVV Client Creation with Req fields blank
	@Test(groups = {"All", "Smoke"})
	public void R2267_TC92219_AltEVV_Client_Req_Fields_Blank_Validation() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("R2267_TC92219_AltEVV_Client_Req_Fields_Blank_Validation");

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake_req_blank);

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientQualifierFormatError);
	}
}

