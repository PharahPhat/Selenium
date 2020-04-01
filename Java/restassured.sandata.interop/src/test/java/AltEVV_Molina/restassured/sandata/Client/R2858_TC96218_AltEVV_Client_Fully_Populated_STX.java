package AltEVV_Molina.restassured.sandata.Client;

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

public class R2858_TC96218_AltEVV_Client_Fully_Populated_STX extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	//Validating AltEVV Client Creation in STX DB 
	@Test(groups = {"All", "fixing"})
	public void R2858_TC96218_AltEVV_Client_Fully_Populated_STX_DB() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R2858_TC96218_AltEVV_Client_Fully_Populated_STX_DB");

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		String bodyAsString =CommonMethods.verifyPostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients),
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClientsGet));

		assertionDbVerifier.jsonAssert_InboxClient_AltEVVMolina(bodyAsString, jsonObject);
	}
}