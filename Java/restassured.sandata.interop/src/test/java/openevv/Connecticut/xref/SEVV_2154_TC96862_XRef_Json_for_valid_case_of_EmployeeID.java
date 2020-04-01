package openevv.Connecticut.xref;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

public class SEVV_2154_TC96862_XRef_Json_for_valid_case_of_EmployeeID extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	//To validate the valid ClientIDQualifier valid cases
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void SEVV_2154_TC96862_XRef_Json_for_valid_case_of_EmployeeID_valid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException, ClassNotFoundException
	{
		// logger = extent.startTest("SEVV_2154_TC96862_XRef_Json_fo@AdditionalInfo(module = "OpenEVV")@AdditionalInfo(module = "OpenEVV")@AdditionalInfo(module = "OpenEVV")@AdditionalInfo(module = "OpenEVV")@AdditionalInfo(module = "OpenEVV")@AdditionalInfo(module = "OpenEVV")@AdditionalInfo(module = "OpenEVV")@AdditionalInfo(module = "OpenEVV")@AdditionalInfo(module = "OpenEVV")@AdditionalInfo(module = "OpenEVV")@AdditionalInfo(module = "OpenEVV")@AdditionalInfo(module = "OpenEVV")@AdditionalInfo(module = "OpenEVV")@AdditionalInfo(module = "OpenEVV")@AdditionalInfo(module = "OpenEVV")@AdditionalInfo(module = "OpenEVV")@AdditionalInfo(module = "OpenEVV")@AdditionalInfo(module = "OpenEVV")@AdditionalInfo(module = "OpenEVV")r_valid_case_of_EmployeeID_valid");  // adding method name info via logger
		 
		//Using Reusable method to load client json
	
		   JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);
			
			JSONObject jsonobject = (JSONObject) jsonarray.get(0);
			
			jsonobject.put("EmployeeID",CommonMethods.generateRandomNumberOfFixLength(5) );
		
		//Using Assert to validate the expected result
			CommonMethods.validateResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		 }
		
	
	}
	


