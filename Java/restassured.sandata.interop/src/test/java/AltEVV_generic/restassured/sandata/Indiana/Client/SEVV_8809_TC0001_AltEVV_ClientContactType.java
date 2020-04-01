package AltEVV_generic.restassured.sandata.Indiana.Client;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.DataGeneratorClient;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Priyank
 *
 */

public class SEVV_8809_TC0001_AltEVV_ClientContactType extends BaseTest {

	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	
	// Validating valid altEVV ClientContact type with Family as value
	@Test(enabled = false, groups = {"All"})
	public void SEVV_8809_TC0001_AltEVV_ClientContactTypeExcludeExtendedFamily() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("SEVV_8809_TC0001_AltEVV_ClientContactTypeExcludeExtendedFamily");
		logger.log(LogStatus.INFO, "Validating the exclusion of Extended Family from ClientContactType Value"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientResponsibleParty);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);

		jsonObject1.put(globalVariables.ClientContactType, DataGeneratorClient.clientcontactlist_altevv[1]);

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactTypeFormatError);

	}
}