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

public class SEVV_538_TC95995_Validate_xref_when_XRefStartDate_greater_than_Current_Date extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	//To validate the valid XRefStartDate future
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC95995_Validate_xref_when_XRefStartDate_greater_than_Current_Date() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException, ClassNotFoundException
	{
		// logger = extent.startTest("TC95995_Validate_xref_when_XRefStartDate_greater_than_Current_Date");  // adding method name info via logger

		//Using Reusable method to load client json
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		JSONObject jsonobject = (JSONObject) jsonarray.get(0);

		jsonobject.put("XRefStartDate", CommonMethods.generateFutureDate_MM_DD_YYYY());
		jsonobject.put("XRefEndDate", null);
		//Using Assert to validate the expected result
		CommonMethods.validateResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));



	}



}
