package Production;

import java.io.IOException;
import java.sql.SQLException;

import com.globalMethods.core.globalVariables;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import Utills_ExtentReport_Log4j.BaseTest; 

public class Bug4647_TC96532_3PVisit_BusinessEntityMedicaidIdentifier extends BaseTest { 
	
	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); 
	Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	@Test(groups = {"All"})
	public void TC96532_3PVisit_BusinessEntityMedicaidIdentifier_valid_10010() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, Exception
	{
		// logger = extent.startTest("TC96532_3PVisit_BusinessEntityMedicaidIdentifier_valid_10010");

		JSONArray jsonArr=GenerateUniqueParam.VisitParam_3P();

		JSONObject js = (JSONObject) jsonArr.get(0);
		
		String bodyAsString = CommonMethods.captureResponseOhio_v1(jsonArr, CommonMethods.propertyfileReader(globalVariables.ohio_visit_v1));

		String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v1(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_visit_get_v1));

		assertionDbVerifier.jsonAssertInboxVisitAltevvGeneric(bodyAsStringget, js);

	}

	@Test(groups = {"All"})
	public void Bug4647_TC96532_3PVisit_BusinessEntityMedicaidIdentifier_valid_010010() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, Exception
	{
		// logger = extent.startTest("Bug4647_TC96532_3PVisit_BusinessEntityMedicaidIdentifier_valid_010010");

		JSONArray jsonArr=GenerateUniqueParam.VisitParam_3P();

		JSONObject js = (JSONObject) jsonArr.get(0);

		String bodyAsString = CommonMethods.captureResponseOhio_v1(jsonArr, CommonMethods.propertyfileReader(globalVariables.ohio_visit_v1));

		String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v1(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_visit_get_v1));

		assertionDbVerifier.jsonAssertInboxVisitAltevvGeneric(bodyAsStringget, js);

	}

	@Test(groups = {"All"})
	public void Bug4647_TC96532_3PVisit_BusinessEntityMedicaidIdentifier_valid_0010010() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, Exception
	{
		// logger = extent.startTest("Bug4647_TC96532_3PVisit_BusinessEntityMedicaidIdentifier_valid_0010010");

		JSONArray jsonArr=GenerateUniqueParam.VisitParam_3P();

		JSONObject js = (JSONObject) jsonArr.get(0);

		String bodyAsString = CommonMethods.captureResponseOhio_v1(jsonArr, CommonMethods.propertyfileReader(globalVariables.ohio_visit_v1));

		String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v1(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_visit_get_v1));

		assertionDbVerifier.jsonAssertInboxVisitAltevvGeneric(bodyAsStringget, js);

	}

}
