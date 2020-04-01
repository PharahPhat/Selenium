package openevv.Connecticut.Client;

import java.io.IOException;
import java.sql.SQLException;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import Utills_ExtentReport_Log4j.BaseTest;

public class SEVV3068_TC94594_ClientID_MultipleRow extends BaseTest {

	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	Assertion_DbVerifier Assertion_DbVerifier= new Assertion_DbVerifier();
	DataBaseVerifier DataBaseVerfier=new DataBaseVerifier();
	
	//To validate the scenario with null ClientID
	@Test(enabled = false, groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void SEVV3068_TC94594_ClientID_MultipleRow_Valid_multipleRow() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("SEVV3068_TC94594_ClientID_MultipleRow_Valid_multipleRow");

		String ClientLname= CommonMethods.generateRandomStringOfFixLength(10);
		String ClientFname= CommonMethods.generateRandomStringOfFixLength(10);
		String ClientEmailid= CommonMethods.generateEmailAddress_string(10);

		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);	
		jsonObject.put("ClientFirstName", ClientLname);
		jsonObject.put("ClientLastName", ClientFname);
		jsonObject.put("ClientEmailAddress", ClientEmailid);

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("ClientFirstName", ClientLname);
		jsonObject.put("ClientLastName", ClientFname);
		jsonObject.put("ClientEmailAddress", ClientEmailid);

		 bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		String ClientID=jsonObject.get("ClientID").toString();
		
		CommonMethods.AssertEqualsAndPrintValuesString
		("2", 
		String.valueOf(DataBaseVerfier.returnRowNumber("select * from inbox.clients where " + "LOC"+ "=" + "'" +ClientID +"'" + " ")),
				"duplicate clientID with multiple row");
		
	
	}

}