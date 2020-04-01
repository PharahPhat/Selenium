package AltEVV_generic.restassured.sandata.Indiana.Employee;

import Utills_ExtentReport_Log4j.BaseTest;
import com.common.Validation;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.globalMethods.core.globalVariables.*;

/**
 * @author MayankM
 */
//Test Case 91411: OpenEVV-altEVV- employee - SequenceID validation field formats/values

public class R2267_TC91411_AltEVV_EmpSequenceID_Validation extends BaseTest {
	private GenerateUniqueParam generateUniqueParam=new GenerateUniqueParam();

	@DataProvider(name = "dataProvider")
	public static Object[][] dataProvider() {
		switch (state) {
			default: return new Object[][]
					{
							{true, CommonMethods.generateRandomNumberOfFixLength(1), ""},
							{true, CommonMethods.generateRandomNumberOfFixLength(16), ""},
							{false, CommonMethods.generateRandomNumberOfFixLength(17), SequenceIDMaxLengthError},
							{false, null, SequenceLengthNullError},
							{false, "",SequenceIDMaxLengthError},
					};
		}}

	@Test(dataProvider = "dataProvider", groups = "fixing")
		public void TC91411_AltEVV_EmpSequenceID_Validation(boolean isValid, String value, String errorMessage) throws IOException, ParseException {
			JSONArray altEVVJsonArray = generateUniqueParam.EmpParams_AltEVV(Staff_intake);
			Validation.validationField(altEVVJsonArray,SequenceID, isValid, value, errorMessage,
					CommonMethods.propertyfileReader(altevv_emp));
		}

	}