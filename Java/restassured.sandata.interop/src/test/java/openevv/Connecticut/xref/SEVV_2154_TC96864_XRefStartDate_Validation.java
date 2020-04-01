package openevv.Connecticut.xref;

import Utills_ExtentReport_Log4j.BaseTest;
import com.common.Validation;
import com.globalMethods.core.*;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

import static com.globalMethods.core.globalVariables.*;

// Test Case 96864: Open EVV Xref- Validate the Xref Json for valid case of XRefStartDate (Refer the steps for scenario)

public class SEVV_2154_TC96864_XRefStartDate_Validation extends BaseTest {
	private GenerateUniqueParam generateUniqueParam=new GenerateUniqueParam();

	@DataProvider(name = "dataProvider")
	public static Object[][] dataProvider() {
		switch (state) {
			default: return new Object[][]
					{
							{true, "2018-12-31", "2018-12-31", ""},
							{true, "12312018", "12312018", ""},
							{true, null, null, ""},
							{true, "", "" , ""},
							{true, "12312018", null, ""},
							{false, "20181231", "20181231", XRefStartDateformaterror},
							{false, "20190101", "20181231", XRefStartDateformaterror},
							{false, "2018/12/31", "2018/12/31", XRefStartDateformaterror},
							{false, "31-12-2018", "31-12-2018", XRefStartDateformaterror},
							{false, "12/31/2018", "12/31/2018", XRefStartDateformaterror},
							{false, "12-31-2018", "12-31-2018", XRefStartDateformaterror},
							{false, "31/12/2018", "31/12/2018", XRefStartDateformaterror},
							{false, "31122018", "31122018", XRefStartDateformaterror},
					};
		}
	}

	@Test(dataProvider = "dataProvider")
	public void TC96864_XRefStartDate_Validation(boolean isValid, String value, String xrefEndDate, String errorMessage) throws IOException, ParseException, InterruptedException {
		JSONArray jsonArray = generateUniqueParam.XrefParams(globalVariables.xref_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put(XRefEndDate, xrefEndDate);
		Validation.validationField(jsonArray, XRefStartDate, isValid, value, errorMessage, CommonMethods.propertyfileReader(openevv_xref_url));
	}
}
