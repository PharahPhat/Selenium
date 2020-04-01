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

public class R2858_TC96203_Client_MaxLength  extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	//Validating AltEVV Client Creation in Inbox DB 
	@Test(groups = {"All"})
	public void R2858_TC96203_Client_FullyPopulated_validate() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R2858_TC96203_Client_FullyPopulated_validate");

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
	}
}

