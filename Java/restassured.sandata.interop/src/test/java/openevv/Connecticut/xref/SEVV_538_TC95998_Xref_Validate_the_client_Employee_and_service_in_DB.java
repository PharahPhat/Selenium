package openevv.Connecticut.xref;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.*;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

public class SEVV_538_TC95998_Xref_Validate_the_client_Employee_and_service_in_DB extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	//To validate the valid XRefStartDate future
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "Client Xref")
	public void TC95998_Xref_Validate_the_client_Employee_and_service_in_DB() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException, ClassNotFoundException
	{
		// logger = extent.startTest("TC95998_Xref_Validate_the_client_Employee_and_service_in_DB");  // adding method name info via logger

		//Using Reusable method to load client json
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);
		JSONObject jsonObject = (JSONObject) jsonarray.get(0);

		//Using Assert to validate the expected result
		String bodyAsString = CommonMethods.validateResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		assertionDbVerifier.jsonAssert_XrefService(bodyAsString, jsonObject);
	}

}
