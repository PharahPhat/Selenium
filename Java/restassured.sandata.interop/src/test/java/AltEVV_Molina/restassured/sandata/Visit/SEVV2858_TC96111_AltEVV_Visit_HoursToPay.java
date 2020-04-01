package AltEVV_Molina.restassured.sandata.Visit;

/*
@MayankM

OpenEVV-altEVV- Visits- HoursToPay field formats/values
 */

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class SEVV2858_TC96111_AltEVV_Visit_HoursToPay extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	@Test(groups = {"All"})
	public void SEVV2858_TC96111_AltEVV_HoursToPay_valid_numeric() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException{

		// logger = extent.startTest("SEVV2858_TC96111_AltEVV_HoursToPay_valid_numeric");
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.HoursToPayjson, CommonMethods.getRandomDouble_Two_Decimal(0, 23.999));

		CommonMethods.validateResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));
	}

	@Test(groups = {"All"})
	public void SEVV2858_TC96111_AltEVV_HoursToPay_valid_decimal() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException{

		// logger = extent.startTest("SEVV2858_TC96111_AltEVV_HoursToPay_valid_decimal");
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.HoursToPayjson, CommonMethods.getRandomDoubleBetweenRange(0, 9));

		CommonMethods.validateResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));
	}

	@Test(groups = {"All"})
	public void SEVV2858_TC96111_AltEVV_HoursToPay_invalid() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException{

		// logger = extent.startTest("SEVV2858_TC96111_AltEVV_HoursToPay_invalid");
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.HoursToPayjson, CommonMethods.generateRandomNumberOfFixLength(5));
		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.HoursToPayValueError);
	}

	@Test(groups = {"All"})
	public void SEVV2858_TC96111_AltEVV_HoursToPay_null() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException{

		// logger = extent.startTest("SEVV2858_TC96111_AltEVV_HoursToPay_null");
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.HoursToPayjson, null);

		CommonMethods.validateResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));
	}

	@Test(groups = {"All"})
	public void SEVV2858_TC96111_AltEVV_HoursToPay_optional() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException{

		// logger = extent.startTest("SEVV2858_TC96111_AltEVV_HoursToPay_optional");
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.HoursToPayjson, "");
		
		CommonMethods.capturePostResponse_400(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));
	}

	@Test(groups = {"All"})
	public void R2267_TC95239_AltEVV_HoursToPay_invalid_format() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException {

		// logger = extent.startTest("SEVV2858_TC96111_AltEVV_HoursToPay_invalid_format");
		JSONArray jsonArrayVisit = GenerateUniqueParam.VisitParams_AltEVV_Molina();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.HoursToBilljson, CommonMethods.generateRandomStringOfFixLength(6));

		CommonMethods.capturePostResponse_400(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));
	}
}
