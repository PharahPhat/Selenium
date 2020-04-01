package Ohio_V2.Patient;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.Assertion_DbVerifier;
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


public class SEVV4621_TC100597_OhioV2_Clientcreation_with_multiple_Payers extends BaseTest {
    GenerateUniqueParam GenerateUniqueParam = new GenerateUniqueParam();
    Assertion_DbVerifier assertionDbVerifier = new Assertion_DbVerifier();


    @Test(groups = {"All"})
    public void TC100597_OhioV2_Clientcreation_with_multiple_Payers() throws java.text.ParseException, IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException {
        // logger = extent.startTest("TC100597_OhioV2_Clientcreation_with_multiple_Payers");
        logger.log(LogStatus.INFO, "TC100597_OhioV2_Clientcreation_with_multiple_Payers");

        JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
        JSONObject jsonObject = (JSONObject) jsonArray.get(0);
        jsonObject.put("PatientAlternateID", CommonMethods.generateRandomNumberOfFixLength(7));

        JSONArray jsonArrayAdd = (JSONArray) jsonObject.get("IndividualPayerInformation");
        JSONObject jsonObjectsub = (JSONObject) jsonArrayAdd.get(0);

        jsonObjectsub.put("Payer", CommonMethods.generatepayer());
        jsonObjectsub.put("PayerProgram", CommonMethods.generatepayerprogram());
        jsonObjectsub.put("ProcedureCode", CommonMethods.generateProcedurecode());


        String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

        String bodyAsStringget = CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));

        assertionDbVerifier.jsonAssert_InboxClient_3P(bodyAsStringget, jsonObject);
    }
}
