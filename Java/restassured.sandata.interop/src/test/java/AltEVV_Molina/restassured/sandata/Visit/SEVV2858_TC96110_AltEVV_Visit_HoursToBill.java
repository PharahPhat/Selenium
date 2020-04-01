package AltEVV_Molina.restassured.sandata.Visit;

/*
@MayankM

OpenEVV-altEVV- Visits- HoursToBill field formats/values
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

public class SEVV2858_TC96110_AltEVV_Visit_HoursToBill extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	@Test(groups = {"All"})
	public void SEVV2858_TC96110_AltEVV_HoursToBill_valid_numeric() throws InterruptedException, IOException, ParseException, java.text.ParseException{

		// logger = extent.startTest("SEVV2858_TC96110_AltEVV_HoursToBill_valid");
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.HoursToBilljson, CommonMethods.getRandomDouble_Two_Decimal(0, 99.99));
		
		CommonMethods.validateResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));
	}

	@Test(groups = {"All"})
	public void SEVV2858_TC96110_AltEVV_HoursToBill_valid_decimal() throws InterruptedException, IOException, ParseException, java.text.ParseException{

		// logger = extent.startTest("SEVV2858_TC96110_AltEVV_HoursToBill_valid_decimal");
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.HoursToBilljson, CommonMethods.getRandomDoubleBetweenRange(0, 9));
		
		CommonMethods.validateResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));
	}

	@Test(groups = {"All"})
	public void SEVV2858_TC96110_AltEVV_HoursToBill_invalid() throws InterruptedException, java.text.ParseException, IOException, ParseException {

		// logger = extent.startTest("SEVV2858_TC96110_AltEVV_HoursToBill_invalid");
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.HoursToBilljson, CommonMethods.generateRandomNumberOfFixLength(5));
		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.HoursToBillValueError_Molina);
	}

	@Test(groups = {"All"})
	public void SEVV2858_TC96110_AltEVV_HoursToBill_null() throws InterruptedException, IOException, ParseException, java.text.ParseException{

		// logger = extent.startTest("SEVV2858_TC96110_AltEVV_HoursToBill_null");
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.HoursToBilljson, null);

		CommonMethods.validateResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));
	}

	@Test(groups = {"All"})
	public void SEVV2858_TC96110_AltEVV_HoursToBill_optional() throws InterruptedException, IOException, ParseException, java.text.ParseException{

		// logger = extent.startTest("SEVV2858_TC96110_AltEVV_HoursToBill_optional");
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.HoursToBilljson, "");

		CommonMethods.capturePostResponse_400(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));
	}

	@Test(groups = {"All"})
	public void SEVV2858_TC96110_AltEVV_HoursToBill_invalid_format() throws InterruptedException, java.text.ParseException, IOException, ParseException{

		// logger = extent.startTest("SEVV2858_TC96110_AltEVV_HoursToBill_invalid_format");
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.HoursToBilljson, CommonMethods.generateRandomStringOfFixLength(6));
		
		CommonMethods.capturePostResponse_400(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));
	}

}
