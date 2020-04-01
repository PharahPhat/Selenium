/**
 *
 */
package Ohio_V1.Patient;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.globalMethods.core.globalVariables.ClientAddressLine1;
import static com.globalMethods.core.globalVariables.ClientAddressLine2;

/**
 * @author Anupam
 */

public class SEVV_1214_TC96639_OhioV1_PatientAddressLine1_Validation extends BaseTest {
    private GenerateUniqueParam GenerateUniqueParam = new GenerateUniqueParam();

    @DataProvider(name = "dataProvider")
    public static Object[][] dataProvider() {
        return new Object[][]
                {
                        {true, "C'D", ""},
                        {true, "C.D", ""},
                        {true, "C,D", ""},
                        {true, "C-D", ""},
                };
    }

    @Test(groups = {"All"}, dataProvider = "dataProvider")
    @AdditionalInfo(module = "OhioPatient")
    public void TC96639_OhioV1_PatientAddressLine1_Validation(boolean isValid, String value, String errorMessage) throws Exception {
        JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.Ohio_patientJson_v1);
        JSONObject jsonObject = (JSONObject) jsonArray.get(0);
        JSONArray jsonArrayAdd = (JSONArray) jsonObject.get(globalVariables.Addressjson);
        JSONObject jsonObjectAdd = (JSONObject) jsonArrayAdd.get(0);
        jsonObjectAdd.put(ClientAddressLine1, value);
        if (isValid) {
            String bodyAsStringGet = CommonMethods.captureGetResponse(jsonArray,
                    CommonMethods.propertyfileReader(globalVariables.ohio_patient_v1),
                    CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v1));
            CommonMethods.verifyJsonPassCase(bodyAsStringGet);
        } else {
            String bodyAsStringGet = CommonMethods.captureGetResponse(jsonArray,
                    CommonMethods.propertyfileReader(globalVariables.ohio_patient_v1),
                    CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v1));
            CommonMethods.verifyJsonPassCase(bodyAsStringGet);
        }
    }
}
