package AltEVV_generic.restassured.sandata.Indiana.Visit;

/*
@MayankM

OpenEVV-altEVV- Visits- HoursToPay field formats/values
 */

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

public class R2267_TC95240_AltEVV_Visit_HoursToPay extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	@Test(groups = {"All"})
	public void R2267_TC95240_AltEVV_HoursToPay_valid_numeric() throws InterruptedException, IOException, ParseException
	{

		// logger = extent.startTest("R2267_TC7476_AltEVV_HoursToPay_valid_numeric");
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.HoursToPayjson, CommonMethods.getRandomDouble_Two_Decimal(0, 23.999));
		
		CommonMethods.validateResponse(jsonArrayVisit,
					CommonMethods.propertyfileReader(globalVariables.altevv_visit));
	}

	@Test(groups = {"All"})
	public void R2267_TC95240_AltEVV_HoursToPay_valid_decimal() throws InterruptedException, IOException, ParseException {

		// logger = extent.startTest("R2267_TC7476_AltEVV_HoursToPay_valid_decimal");
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.HoursToPayjson, CommonMethods.getRandomDoubleBetweenRange(0, 9));
		CommonMethods.validateResponse(jsonArrayVisit,
					CommonMethods.propertyfileReader(globalVariables.altevv_visit));
	}

	@Test(groups = {"All"})
	public void R2267_TC95240_AltEVV_HoursToPay_null() throws InterruptedException, IOException, ParseException {

		// logger = extent.startTest("R2267_TC7476_AltEVV_HoursToPay_null");
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.HoursToPayjson, null);

		CommonMethods.validateResponse(jsonArrayVisit,
					CommonMethods.propertyfileReader(globalVariables.altevv_visit));
	}

	@Test(groups = {"All"})
	public void R2267_TC95240_AltEVV_HoursToPay_invalid_format() throws InterruptedException, IOException, ParseException {

		// logger = extent.startTest("R2267_TC95239_AltEVV_HoursToPay_invalid_format");
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.HoursToPayjson, CommonMethods.generateRandomStringOfFixLength(6));

		CommonMethods.capturePostResponse_400(jsonArrayVisit,
				CommonMethods.propertyfileReader(globalVariables.altevv_visit));
	}
}
