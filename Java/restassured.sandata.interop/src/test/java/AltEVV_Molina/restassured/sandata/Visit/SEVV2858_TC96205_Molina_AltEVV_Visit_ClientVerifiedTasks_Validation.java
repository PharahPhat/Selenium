package AltEVV_Molina.restassured.sandata.Visit;

/*
@MayankM

OpenEVV-altEVV- Visits- VisitOtherID field formats/values

 */

import Utills_ExtentReport_Log4j.BaseTest;
import com.common.Validation;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import static com.globalMethods.core.globalVariables.*;
import static com.globalMethods.core.globalVariables.altevv_Molina_visit;

public class SEVV2858_TC96205_Molina_AltEVV_Visit_ClientVerifiedTasks_Validation extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	private GenerateUniqueParam generateUniqueParam=new GenerateUniqueParam();

	@DataProvider(name = "dataProvider")
	public static Object[][] dataProvider() {
		return new Object[][]
				{
						{true, "True", ""},
						{true, "False", ""},
						{true, "FALSE", ""},
						{true, "TRUE", ""},
						{true, null, ""},
						{false, CommonMethods.generateRandomStringOfFixLength(6), ClientVerifiedTasksError}
				};
	}

	@Test(dataProvider = "dataProvider")
	public void TC96205_Molina_AltEVV_Visit_ClientVerifiedTasks_Validation(boolean isValid, String value, String errorMessage) throws
			ParseException, IOException {
		JSONArray jsonArrayVisit= generateUniqueParam.VisitParams_AltEVV_Molina();
		Validation.validationField(jsonArrayVisit, ClientVerifiedTasksjson, isValid, value,
				errorMessage, CommonMethods.propertyfileReader(altevv_Molina_visit));
	}
}
