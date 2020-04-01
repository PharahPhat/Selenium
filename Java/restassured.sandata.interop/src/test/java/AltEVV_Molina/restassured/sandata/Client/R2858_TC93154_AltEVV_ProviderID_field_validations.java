package AltEVV_Molina.restassured.sandata.Client;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.globalMethods.core.globalVariables.*;

public class R2858_TC93154_AltEVV_ProviderID_field_validations extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	@DataProvider(name = "dataProvider")
	public static Object[][] dataProvider() {
		return new Object[][]
				{
						{true, stateInfo.get(ProviderID), ""},
						{false, CommonMethods.generateRandomAlphaNumeric(51), ProviderIDInvalid},
						{false, null, ProviderIDInvalid},
						{false, "", ProviderIDInvalid}
				};
	}

	@Test(dataProvider = "dataProvider")
	public void TC93154_AltEVV_ProviderID_field_validations(boolean isValid, String value, String errorMessage)
			throws InterruptedException, IOException, ParseException
	{
		logger = extent.startTest("TC93154_AltEVV_ProviderID_field_validations");

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONObject jsonProvider =  (JSONObject) jsonObject.get(globalVariables.ProviderIdentification);
		jsonProvider.put(ProviderID, value);

		if (isValid) {
			CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(altevvMolinaClients));
		}
		else {
			String bodyAsString = CommonMethods.capturePostResponse_500(jsonArray, CommonMethods.propertyfileReader(altevvMolinaClients));
			CommonMethods.verifyjsonassertFailcase(bodyAsString, errorMessage);
		}
	}
}
