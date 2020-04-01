/**
 * 
 */
package openevv.Connecticut.Client;

import java.io.IOException;
import java.sql.SQLException;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author RRohiteshwar
 *
 */

public class Bug3577_TC94733_ClientAddressLine1_ClientAddressline2_number extends BaseTest
{
	
	Assertion_DbVerifier assertionDbVerifier=new Assertion_DbVerifier();
	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	//To validate valid ClientAddressLine1_ClientAddressline2_ClientCity accepts number
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void Bug_3577_TC94733_ClientAddressLine1_ClientAddressline2_number_valid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, ClassNotFoundException, java.text.ParseException
	{

		// logger = extent.startTest("Bug_3577_TC94733_ClientAddressLine1_ClientAddressline2_number_valid");
	
		logger.log(LogStatus.INFO, "To validate valid ClientAddressLine1_ClientAddressline2 accepts number");
		
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);

		js.put(globalVariables.ClientAddressLine1, CommonMethods.generateRandomNumberOfFixLength(15));
		js.put(globalVariables.ClientAddressLine2, CommonMethods.generateRandomNumberOfFixLength(15) );
		js.put(globalVariables.ClientCity, CommonMethods.generateRandomStringOfFixLength(16));

		JSONArray jsonArray_Sub = (JSONArray) js.get("ClientAddress");
		JSONObject jsonObjectMap_Supp = (JSONObject) jsonArray_Sub.get(0);
		JSONObject jsonObjectMap_Address = (JSONObject) jsonArray_Sub.get(1);
		
		jsonObjectMap_Supp.put(globalVariables.ClientAddressLine1, CommonMethods.generateRandomNumberOfFixLength(15));
		jsonObjectMap_Supp.put(globalVariables.ClientAddressLine2, CommonMethods.generateRandomNumberOfFixLength(15) );
		jsonObjectMap_Supp.put(globalVariables.ClientCity, CommonMethods.generateRandomStringOfFixLength(16));

		jsonObjectMap_Address.put(globalVariables.ClientAddressLine1, CommonMethods.generateRandomNumberOfFixLength(15));
		jsonObjectMap_Address.put(globalVariables.ClientAddressLine2, CommonMethods.generateRandomNumberOfFixLength(15) );
		jsonObjectMap_Address.put(globalVariables.ClientCity, CommonMethods.generateRandomStringOfFixLength(16));

		CommonMethods.validateResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url));
	}

}
