/**
 * 
 */
package AltEVV_generic.restassured.sandata.Indiana.Client;

import Utills_ExtentReport_Log4j.BaseTest;
import com.common.Validation;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

import static com.globalMethods.core.globalVariables.*;
import static com.globalMethods.core.globalVariables.altevv_clients;

public class R2267_TC91264_AltEVV_ProviderQualifier_Validation extends BaseTest {
	private GenerateUniqueParam generateUniqueParam=new GenerateUniqueParam();

	@DataProvider(name = "dataProvider")
	public static Object[][] dataProvider() {
		switch (state) {
			default: return new Object[][]
					{
							{true, "SandataID", ""},
							{true, "TaxID", ""},
							{true, "Taxonomy", ""},
							{true, "Legacy", ""},
							{true, "Other", ""},
							{true, "NPI", ""},
							{true, "API", ""},
							{true, "MedicaidID", ""},
					};
			case "PA": return new Object[][]
					{
							{true, "MedicaidID", ""},
							{false, "TaxID", ProviderQualifier_Format},
							{false, "Taxonomy", ProviderQualifier_Format},
							{false, "Legacy", ProviderQualifier_Format},
							{false, "Other", ProviderQualifier_Format},
							{false, "SandataID", ProviderQualifier_Format},
							{false, "NPI", ProviderQualifier_Format},
							{false, "API", ProviderQualifier_Format},
							{false, "medicaidID", ProviderQualifier_Format},
							{false, null, ProviderQualifierNullError}
					};
		}
	}

	@Test(dataProvider = "dataProvider")
	public void TC37746_AltEVV_Client_ProviderQualifier_Validation(boolean isValid, String value, String errorMessage) throws IOException, ParseException, InterruptedException {
		JSONArray altEVVJsonArray = generateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		Validation.validationProviderIdentificationField(altEVVJsonArray, ProviderQualifier, isValid, value,
				errorMessage, CommonMethods.propertyfileReader(altevv_clients), 200);
	}

}

