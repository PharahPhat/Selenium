package Ohio_V2.Patient;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

public class SEVV_1556_TC97395_PatientState_field_formats_values extends BaseTest {
    GenerateUniqueParam GenerateUniqueParam = new GenerateUniqueParam();
    Assertion_DbVerifier assertionDbVerifier = new Assertion_DbVerifier();


    @Test(groups = {"All", "Regression"})
    @AdditionalInfo(module = "OpenEVV")
    public void TC97395_PatientState_field_formats_values_valid() throws java.text.ParseException, IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException {
        // logger = extent.startTest("TC97395_PatientState_field_formats_values_valid");
        logger.log(LogStatus.INFO, "TC97395_PatientState_field_formats_values_valid");

        JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
        JSONObject jsonObject = (JSONObject) jsonArray.get(0);

        JSONArray jsonArrPay = (JSONArray) jsonObject.get("Address");
        JSONObject jsonObjectnew = (JSONObject) jsonArrPay.get(0);
        jsonObjectnew.put("PatientState", DataGeneratorClient.generateClientState());

        JSONArray jsonArrPaynew = (JSONArray) jsonObject.get("Address");
        JSONObject jsonObjectnew1 = (JSONObject) jsonArrPaynew.get(1);
        jsonObjectnew1.put("PatientState", DataGeneratorClient.generateClientState());


        String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

        String bodyAsStringget = CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));

        assertionDbVerifier.jsonAssert_InboxClient_3P(bodyAsStringget, jsonObject);
    }

    @Test(groups = {"All"})
    public void TC97395_PatientState_field_formats_values_invalid_null() throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, ClassNotFoundException {
        // logger = extent.startTest("TC97395_PatientState_field_formats_values_invalid_null");
        logger.log(LogStatus.INFO, "TC97395_PatientState_field_formats_values_invalid_null");

        JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
        JSONObject jsonObject = (JSONObject) jsonArray.get(0);

        JSONArray jsonArrPay = (JSONArray) jsonObject.get("Address");
        JSONObject jsonObjectnew = (JSONObject) jsonArrPay.get(0);
        jsonObjectnew.put("PatientState", null);

        JSONArray jsonArrPaynew = (JSONArray) jsonObject.get("Address");
        JSONObject jsonObjectnew1 = (JSONObject) jsonArrPaynew.get(1);
        jsonObjectnew1.put("PatientState", null);

        String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

        String bodyAsStringget = CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));

        CommonMethods.verifyjsonassertFailcaseinget(bodyAsStringget, globalVariables.Patientstatecodeenullrror);
    }

    @Test(groups = {"All"})
    public void TC97395_PatientState_field_formats_values_invalid_morethan_allowed_length() throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, ClassNotFoundException {
        // logger = extent.startTest("TC97395_PatientState_field_formats_values_invalid_morethan_allowed_length");
        logger.log(LogStatus.INFO, "TC97395_PatientState_field_formats_values_invalid_morethan_allowed_length");

        JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
        JSONObject jsonObject = (JSONObject) jsonArray.get(0);

        JSONArray jsonArrPay = (JSONArray) jsonObject.get("Address");
        JSONObject jsonObjectnew = (JSONObject) jsonArrPay.get(0);
        jsonObjectnew.put("PatientState", CommonMethods.generateRandomStringOfFixLength(3));

        JSONArray jsonArrPaynew = (JSONArray) jsonObject.get("Address");
        JSONObject jsonObjectnew1 = (JSONObject) jsonArrPaynew.get(1);
        jsonObjectnew1.put("PatientState", CommonMethods.generateRandomStringOfFixLength(3));

        String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

        String bodyAsStringget = CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));

        CommonMethods.verifyjsonassertFailcaseinget(bodyAsStringget, globalVariables.Patientstatecodeerror);
    }


    @Test(groups = {"All"})
    public void TC97395_PatientState_field_formats_values_blank() throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, ClassNotFoundException {
        // logger = extent.startTest("TC97395_PatientState_field_formats_values_blank");
        logger.log(LogStatus.INFO, "TC97395_PatientState_field_formats_values_blank");

        JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
        JSONObject jsonObject = (JSONObject) jsonArray.get(0);

        JSONArray jsonArrPay = (JSONArray) jsonObject.get("Address");
        JSONObject jsonObjectnew = (JSONObject) jsonArrPay.get(0);
        jsonObjectnew.put("PatientState", "");

        JSONArray jsonArrPaynew = (JSONArray) jsonObject.get("Address");
        JSONObject jsonObjectnew1 = (JSONObject) jsonArrPaynew.get(1);
        jsonObjectnew1.put("PatientState", "");

        String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

        String bodyAsStringget = CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));

        CommonMethods.verifyjsonassertFailcaseinget(bodyAsStringget, globalVariables.Patientstatecodeerror);
    }
}
