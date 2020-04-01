package AltEVV_generic.restassured.sandata.Indiana.Client;

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

//TC91118: OpenEVV-altEVV- Client: Validate If the ClientSSN field is left empty

public class R2267_TC91122_AltEVV_ClientTimeZone extends BaseTest {
	private GenerateUniqueParam generateUniqueParam=new GenerateUniqueParam();

	@DataProvider(name = "dataProvider")
	public static Object[][] dataProvider() {
		switch (state) {
			default: return new Object[][]
					{
							{true, "US/Eastern", ""},
							{false, "Eastern", ClientTimeZoneError},
							{false, "Pacific", ClientTimeZoneError},
							{false, "eastern", ClientTimeZoneError},
							{false, null, ClientTimezonenullerror}
					};
			case "PA": return new Object[][]
					{
							{true, "Eastern", ""},
							{true, "US/Eastern", ""},
							{false, "Pacific", ClientTimeZoneError},
							{false, "eastern", ClientTimeZoneError},
							{false, null, ClientTimezonenullerror}
					};
			case "Colorado": return new Object[][]
					{
							{false, "Mountain", ""},
							{true, "US/Mountain", ""},
							{false, "US/mountain", ClientTimeZoneError},
							{false, "Pacific", ClientTimeZoneError},
							{false, null, ClientTimezonenullerror}
					};
		}
	}

	@Test(dataProvider = "dataProvider")
	public void TC91122_AltEVV_Client_ClientTimeZone_Validation(boolean isValid, String value, String errorMessage) throws IOException, ParseException {
		JSONArray altEVVJsonArray = generateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		Validation.validationField(altEVVJsonArray, ClientTimezone, isValid, value, errorMessage, CommonMethods.propertyfileReader(altevv_clients));
	}
}