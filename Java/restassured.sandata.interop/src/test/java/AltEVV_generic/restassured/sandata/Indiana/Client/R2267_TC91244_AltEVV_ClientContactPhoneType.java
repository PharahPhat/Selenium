package AltEVV_generic.restassured.sandata.Indiana.Client;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

//TC91118: OpenEVV-altEVV- Client: Validate If the ClientSSN field is left empty

public class R2267_TC91244_AltEVV_ClientContactPhoneType extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	// Validating valid altEVV  ClientContactphonetype having list Business"
	@Test(groups = {"All"})
	public void R2267_TC91244_AltEVV_ClientContactPhoneType_Valid_Business_asValue() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R2267_TC91244_AltEVV_ClientContactPhoneType_Valid_Business_asValue");
		logger.log(LogStatus.INFO, "Validating valid altEVV  ClientContactphonetype having list Business\""); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientResponsibleParty);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);

		jsonObject1.put(globalVariables.ClientContactPhoneType, "Business");

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));
	}

	// Validating valid altEVV  ClientContactphonetype having list  Home"
	@Test(groups = {"All"})
	public void R2267_TC91244_AltEVV_ClientContactPhoneType_Valid_Home_asValue() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R2267_TC91244_AltEVV_ClientContactPhoneType_Valid_Home_asValue");
		logger.log(LogStatus.INFO, "Validating valid altEVV  ClientContactphonetype having list  Home"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientResponsibleParty);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);

		jsonObject1.put(globalVariables.ClientContactPhoneType,"Home");

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));
	}

	// Validating valid altEVV  ClientContactphonetype having  Mobile"
	@Test(groups = {"All"})
	public void R2267_TC91244_AltEVV_ClientContactPhoneType_Valid_Mobile_asValue() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R2267_TC91244_AltEVV_ClientContactPhoneType_Valid_Mobile_asValue");
		logger.log(LogStatus.INFO, "Validating valid altEVV  ClientContactphonetype having  Mobile"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientResponsibleParty);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);

		jsonObject1.put(globalVariables.ClientContactPhoneType, "Mobile");

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));
	}

	// Validating valid altEVV  ClientContactphonetype having  Other"
	@Test(groups = {"All"})
	public void R2267_TC91244_AltEVV_ClientContactPhoneType_Valid_Other_asValue() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R2267_TC91244_AltEVV_ClientContactPhoneType_Valid_Other_asValue");
		logger.log(LogStatus.INFO, "Validating valid altEVV  ClientContactphonetype having  Other"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientResponsibleParty);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);

		jsonObject1.put(globalVariables.ClientContactPhoneType, "Other");

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));
	}

	// Validating invalid altEVV  ClientContactphonetype having other than assigned value"
	@Test(groups = {"All"})
	public void R2267_TC91244_AltEVV_ClientContactPhoneType_inValid__otherThanassignedValue() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("R2267_TC91244_AltEVV_ClientContactPhoneType_inValid__otherThanassignedValue");
		logger.log(LogStatus.INFO, "Validating valid altEVV  ClientContactphonetype having other than assigned value"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientResponsibleParty);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);

		jsonObject1.put(globalVariables.ClientContactPhoneType, CommonMethods.generateRandomStringOfFixLength(12));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString,globalVariables.ClientContactPhoneTypeFormatError);
	}
}