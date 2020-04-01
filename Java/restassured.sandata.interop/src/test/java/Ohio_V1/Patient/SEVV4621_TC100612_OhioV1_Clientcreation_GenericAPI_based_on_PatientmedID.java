package Ohio_V1.Patient;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.ohio.intake.patient.v1.GlobalVariable_V1;
import com.relevantcodes.extentreports.LogStatus;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

public class SEVV4621_TC100612_OhioV1_Clientcreation_GenericAPI_based_on_PatientmedID extends BaseTest{
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	
	@Test(groups = {"All"})
	public void TC100612_OhioV1_Clientcreation_GenericAPI_based_on_PatientmedID() throws java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException
	{
		// logger = extent.startTest("TC100612_OhioV1_Clientcreation_GenericAPI_based_on_PatientmedID");
		logger.log(LogStatus.INFO, "TC100612_OhioV1_Clientcreation_GenericAPI_based_on_PatientmedID");

        JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.Ohio_patientJson_v1);

        JSONObject jsonObject = (JSONObject) jsonArray.get(0);

        CommonMethods.validateResponse_Ohio(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v1),
                CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v1));

        jsonObject.remove("PatientMedicaidID");

        String bodyGet = CommonMethods.getResponse_Ohio_get_V1(jsonArray);
        Assert.assertTrue(bodyGet.contains(GlobalVariable_V1.PatientMedicaidIDLengthError_Generic));
    }
}
