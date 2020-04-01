package openevv.PA.Provider;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;

import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author Anupam
 *
 */
public class SEVV_6926_TC103260_OpenEVV_Provider_PrimaryContactFirstName_Lastname_null extends BaseTest{

	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	@Test(groups = {"All"})
	public void TC103260_OpenEVV_Provider_PrimaryContactFirstName_Lastname_null() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
	// logger = extent.startTest("TC103260_OpenEVV_Provider_PrimaryContactFirstName_Lastname_null");

	JSONArray jsonArray = GenerateUniqueParam.ProviderParams_OpenEVV(globalVariables.openevv_provider_json);
	JSONObject jsonObject = (JSONObject) jsonArray.get(0);

	jsonObject.put(globalVariables.PrimaryContactLastName, null);
	
	jsonObject.put(globalVariables.PrimaryContactFirstName, null);

	String bodyAsString = CommonMethods.captureResponseIndiana_Provider(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.provider_post_url));

	CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.PrimaryContactLastNameNullError);
}
	
	@Test(groups = {"All"})
	public void TC103260_OpenEVV_Provider_PrimaryContactFirstName_Lastname_blank() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
	// logger = extent.startTest("TC103260_OpenEVV_Provider_PrimaryContactFirstName_Lastname_blank");
	
	List<String> Errormessage = new ArrayList<String>();
	JSONArray jsonArray = GenerateUniqueParam.ProviderParams_OpenEVV(globalVariables.openevv_provider_json);
	JSONObject jsonObject = (JSONObject) jsonArray.get(0);

	jsonObject.put(globalVariables.PrimaryContactLastName, "");
	
	jsonObject.put(globalVariables.PrimaryContactFirstName, "");

	String bodyAsString = CommonMethods.captureResponseIndiana_Provider(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.provider_post_url));

	Errormessage.add(globalVariables.PrimaryContactLastNameLengthError);
	Errormessage.add(globalVariables.PrimaryContactLastNameNullError);
	
	CommonMethods.verifyjsonassertFailcaseList(bodyAsString, Errormessage);
	
}
	

}
