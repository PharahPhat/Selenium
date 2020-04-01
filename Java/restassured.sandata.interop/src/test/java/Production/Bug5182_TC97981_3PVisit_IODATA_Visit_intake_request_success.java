package Production;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import Utills_ExtentReport_Log4j.BaseTest;
import io.restassured.path.json.JsonPath;

/**
 * @author rahul Rohit
 *
 */
public class Bug5182_TC97981_3PVisit_IODATA_Visit_intake_request_success extends BaseTest {
	
GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); 
	
	Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	@Test
	public void Bug5182_TC97981_3PVisit_IODATA_Visit_intake_request_success_Valid() throws IOException, ParseException, ConfigurationException, SQLException, Exception
	{
		// logger = extent.startTest("Bug5182_TC97981_3PVisit_IODATA_Visit_intake_request_success_Valid");

		JSONArray jsonArr=GenerateUniqueParam.VisitParam_3P();

		JSONObject js = (JSONObject) jsonArr.get(0);
		js.put("BusinessEntityMedicaidIdentifier", "10010");

		String bodyAsString = CommonMethods.captureResponseOhio_v1(jsonArr, CommonMethods.propertyfileReader(globalVariables.ohio_visit_v1));

		String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v1(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_visit_get_v1));

		assertionDbVerifier.jsonAssert_inboxVisit_Ohio(bodyAsStringget, js);
		
		assertionDbVerifier.jsonAssert_iodata(bodyAsStringget, CommonMethods.capturegetIDonly(bodyAsStringget));

	}

}
