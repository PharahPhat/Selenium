package AltEVV_generic.restassured.sandata.Indiana.Client;

import java.io.IOException;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author MayankM
 *
 */

//Test Case 91344: Open EVV-altEVV-Client - Field Mapping-Schema:STX - Fully Populated

import com.globalMethods.core.Assertion_DbVerifier; public class R2267_TC91344_AltEVV_Client_Fully_Populated_STX extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	//Validating AltEVV Client Creation in STX DB 
	@Test(groups = {"All"})
	public void R2267_TC91344_AltEVV_Client_Fully_Populated_STX_DB() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R2267_TC91344_AltEVV_Client_Fully_Populated_STX_DB");

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));


	}


}