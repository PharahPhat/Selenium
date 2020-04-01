package Production;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Rahul Rohit
 */

public class Bug4647_TC96515_3PPatient_BusinessEntityMedicaidIdentifier extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	@Test(groups = {"All"})
	public void Bug4647_TC96515_3PPatient_BusinessEntityMedicaidIdentifier_valid_10010() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, Exception
	{
		// logger = extent.startTest("Bug4647_TC96515_3PPatient_BusinessEntityMedicaidIdentifier");

		JSONArray jsonArr=GenerateUniqueParam.ClientParams_3P(globalVariables.ThreeP_patientJson);

		JSONObject js = (JSONObject) jsonArr.get(0);

		String bodyAsString = CommonMethods.captureResponseOhio_v1(jsonArr, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v1));

		String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v1(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v1));

		assertionDbVerifier.jsonAssert_InboxClient_3P(bodyAsStringget, js);

	}

	@Test(groups = {"All"})
	public void Bug4647_TC96515_3PPatient_BusinessEntityMedicaidIdentifier_valid_0010010() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, Exception
	{
		// logger = extent.startTest("Bug4647_TC96515_3PPatient_BusinessEntityMedicaidIdentifier");

		JSONArray jsonArr=GenerateUniqueParam.ClientParams_3P(globalVariables.ThreeP_patientJson);

		JSONObject js = (JSONObject) jsonArr.get(0);

		String bodyAsString = CommonMethods.captureResponseOhio_v1(jsonArr, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v1));

		String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v1(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v1));

		assertionDbVerifier.jsonAssert_InboxClient_3P(bodyAsStringget, js);
	}

	@Test(groups = {"All"})
	public void Bug4647_TC96515_3PPatient_BusinessEntityMedicaidIdentifier_valid_010010() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, Exception
	{
		// logger = extent.startTest("Bug4647_TC96515_3PPatient_BusinessEntityMedicaidIdentifier");

		JSONArray jsonArr=GenerateUniqueParam.ClientParams_3P(globalVariables.ThreeP_patientJson);

		JSONObject js = (JSONObject) jsonArr.get(0);

		String bodyAsString = CommonMethods.captureResponseOhio_v1(jsonArr, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v1));

		String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v1(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v1));

		assertionDbVerifier.jsonAssert_InboxClient_3P(bodyAsStringget, js);

	}
}
