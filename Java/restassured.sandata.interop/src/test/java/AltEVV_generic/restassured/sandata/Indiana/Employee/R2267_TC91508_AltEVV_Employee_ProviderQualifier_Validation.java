package AltEVV_generic.restassured.sandata.Indiana.Employee;

import Utills_ExtentReport_Log4j.BaseTest;
import com.common.Validation;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.globalMethods.core.globalVariables.*;

/**
 * @author Neeraj kumar
 */

public class R2267_TC91508_AltEVV_Employee_ProviderQualifier_Validation extends BaseTest {
	private GenerateUniqueParam generateUniqueParam=new GenerateUniqueParam();

	@DataProvider(name = "dataProvider")
	public static Object[][] dataProvider() {
		switch (state) {
			case "Indiana": return new Object[][]
					{
							{true, "Other", ProviderQualifier_Format},
							{true, "MedicaidID", ""},
							{true, "TaxID", ProviderQualifier_Format},
							{true, "Taxonomy", ProviderQualifier_Format},
							{true, "Legacy", ProviderQualifier_Format},
							{true, "SandataID", ProviderQualifier_Format},
							{true, "NPI", ProviderQualifier_Format},
							{true, "API", ProviderQualifier_Format},
							{false, "medicaidID", ProviderQualifier_Format},
							{false, null, ProviderQualifierNullerror}
					};
			default: return new Object[][]
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
							{false, null, ProviderQualifierNullerror}
					};
		}
	}


	@Test(dataProvider = "dataProvider")
	public void TC91508_AltEVV_Employee_ProviderQualifier_Validation(boolean isValid, String value
			, String errorMessage) throws IOException, ParseException, InterruptedException {
		JSONArray altEVVJsonArray = generateUniqueParam.EmpParams_AltEVV(globalVariables.Staff_intake);
		Validation.validationProviderIdentificationField(altEVVJsonArray, ProviderQualifier, isValid, value,
				errorMessage, CommonMethods.propertyfileReader(altevv_emp), 200);
	}
}
