package Ohio_V2.Patient;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.CommonMethods;
import com.ohio.intake.patient.v2.DataGeneratorV2;
import com.ohio.intake.patient.v2.GlobalVariable_V2;
import com.relevantcodes.extentreports.LogStatus;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class SEVV11831_TC103632_TC103633_TC103634_TC103635_OhioV2_PayerClientIdentifier_Validation_ODA extends BaseTest {
	DataGeneratorV2 dataGenerator = new DataGeneratorV2();
	Map<String, String> jsonField = new HashMap<String, String>();

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatientv2")
	public void OhioV2_PayerClientIdentifier_Validation_ODA_invalid_length() throws ClassNotFoundException, InterruptedException, IOException, ParseException, SQLException, java.text.ParseException {
		logger.log(LogStatus.INFO, GlobalVariable_V2.generateFieldValue);

		jsonField.put(GlobalVariable_V2.payerjson, "ODA");
		jsonField.put(GlobalVariable_V2.payerClientIdentifierjson, CommonMethods.generateRandomNumberOfFixLength(9));

		logger.log(LogStatus.INFO, GlobalVariable_V2.PostGetLog);
		Map<String, JSONObject> returnObject = dataGenerator.processOhioPatientV2WithSubArray(jsonField, GlobalVariable_V2.individualPayerInformationjson, 0);

		dataGenerator.assertFailErrorMessage(String.valueOf(returnObject.get(GlobalVariable_V2.bodyAsStrinqagGet)), GlobalVariable_V2.payerClientIdentifierError);


	}

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatientv2")
	public void OhioV2_PayerClientIdentifier_Validation_ODA_alphanumeric() throws ClassNotFoundException, InterruptedException, IOException, ParseException, SQLException, java.text.ParseException {

		// logger = extent.startTest("OhioV2_PayerClientIdentifier_Validation_ODA_alphanumeric");

		logger.log(LogStatus.INFO, GlobalVariable_V2.generateFieldValue);

		jsonField.put(GlobalVariable_V2.payerjson, "ODA");
		jsonField.put(GlobalVariable_V2.payerClientIdentifierjson, CommonMethods.generateRandomAlphaNumeric(7));

		logger.log(LogStatus.INFO, GlobalVariable_V2.PostGetLog);
		Map<String, JSONObject> returnObject = dataGenerator.processOhioPatientV2WithSubArray(jsonField, GlobalVariable_V2.individualPayerInformationjson, 0);

		dataGenerator.assertFailErrorMessage(String.valueOf(returnObject.get(GlobalVariable_V2.bodyAsStrinqagGet)), GlobalVariable_V2.payerClientIdentifierError);


	}

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatientv2")
	public void OhioV2_PayerClientIdentifier_Validation_ODA_string() throws ClassNotFoundException, InterruptedException, IOException, ParseException, SQLException, java.text.ParseException {

		// logger = extent.startTest("OhioV2_PayerClientIdentifier_Validation_ODA_string");

		logger.log(LogStatus.INFO, GlobalVariable_V2.generateFieldValue);

		jsonField.put(GlobalVariable_V2.payerjson, "ODA");
		jsonField.put(GlobalVariable_V2.payerClientIdentifierjson, CommonMethods.generateRandomStringOfFixLength(7));

		logger.log(LogStatus.INFO, GlobalVariable_V2.PostGetLog);
		Map<String, JSONObject> returnObject = dataGenerator.processOhioPatientV2WithSubArray(jsonField, GlobalVariable_V2.individualPayerInformationjson, 0);

		dataGenerator.assertFailErrorMessage(String.valueOf(returnObject.get(GlobalVariable_V2.bodyAsStrinqagGet)), GlobalVariable_V2.payerClientIdentifierError);


	}

}
