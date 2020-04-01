/**
 * 
 */
package Ohio_V2.Patient;

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

/**
 * @author Anupam
 */
//Test Case 96812:OpenEVV-altEVV- Client- General Information - SequenceID validation field formats/values


public class SEVV_1556_TC96812_AltEVV_General_Information_SequenceID_format extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	@Test(groups = {"All"})
	public void TC96679_AltEVV_General_Information_SequenceID_format() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException


	{
		// logger = extent.startTest("TC96812_AltEVV_General_Information_SequenceID");
		logger.log(LogStatus.INFO, "TC96812_AltEVV_General_Information_SequenceID"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("SequenceID", CommonMethods.generateRandomNumberOfFixLength(16));
	
		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));

		}

	@Test(groups = {"All"})
	public void TC96812_AltEVV_General_Information_SequenceID_length() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC96812_AltEVV_General_Information_SequenceID_length");
		logger.log(LogStatus.INFO, "TC96812_AltEVV_General_Information_SequenceID_length");

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("SequenceID", CommonMethods.generateRandomAlphaNumeric(15));

		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));

	}


}
