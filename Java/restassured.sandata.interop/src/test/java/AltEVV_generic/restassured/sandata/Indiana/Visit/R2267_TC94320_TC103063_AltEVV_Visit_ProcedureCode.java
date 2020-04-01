package AltEVV_generic.restassured.sandata.Indiana.Visit;

/*
@Neeraj

OpenEVV-altEVV- Visits- ProcedureCode field formats/values

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
import java.sql.SQLException;

public class R2267_TC94320_TC103063_AltEVV_Visit_ProcedureCode extends BaseTest { 
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	@Test(groups = {"All"})
	public void R2267_TC94320_AltEVV_ProcedureCode_greaterThan_Max() throws InterruptedException, IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException{

		// logger = extent.startTest("R2267_TC94320_AltEVV_ProcedureCode_greaterThan_Max");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.ProcedureCode,CommonMethods.generateRandomAlphaNumeric(6));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
				CommonMethods.propertyfileReader(globalVariables.altevv_visit));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.errorProcedureCodelength);

	}

	@Test(groups = {"All"})
	public void R2267_TC94320_AltEVV_ProcedureCode_null() throws InterruptedException, IOException, ParseException {
		// logger = extent.startTest("R2267_TC94320_AltEVV_ProcedureCode_null");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put(globalVariables.ProcedureCode,null);

		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
				CommonMethods.propertyfileReader(globalVariables.altevv_visit));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.errorProcedureCodeNull);

	}

	@Test(groups = {"All"})
	public void R2267_TC94320_AltEVV_ProcedureCode_specialChar() throws InterruptedException, IOException, ParseException{

		// logger = extent.startTest("R2267_TC94320_AltEVV_ProcedureCode_specialChar");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);


		jsonObjectVisit.put(globalVariables.ProcedureCode,CommonMethods.generateSpecialChar(5));


		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
				CommonMethods.propertyfileReader(globalVariables.altevv_visit));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ProcedureCodeFormatError);
	}
}
