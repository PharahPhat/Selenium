package Ohio_V1.Staff;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class SEVV6163_TC98748_TC98747_TC98750_Ohio_Employeecreation_with_SSN_Otherid_Seqid_combination extends BaseTest{
	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	Assertion_DbVerifier Assertion_DbVerifier=new Assertion_DbVerifier();
	
	
	// Employee creation (Keep SSN same, change StaffOtherID and SequenceID)
	@SuppressWarnings("unused")
	@Test(groups = {"All","fixing"})
	@AdditionalInfo(module = "OhioStaff")
	public void TC98748_Ohio_Employeecreation_with_SameSSN_different_OtheridSeqid() throws Exception {

			// logger = extent.startTest("TC98748_Ohio_Employeecreation_with_SameSSN_different_OtheridSeqid");
		
			String SSN= CommonMethods.generateRandomNumberOfFixLength(9);
			
			JSONArray jsonArr=GenerateUniqueParam.EmpParams_Ohio_V1(globalVariables.ThreeP_Staff_Json);

			JSONObject jsonobject = (JSONObject) jsonArr.get(0);
		
			jsonobject.put("StaffSSN", SSN);
			jsonobject.put("StaffOtherID", CommonMethods.generateRandomNumberOfFixLength(9));
			jsonobject.put("SequenceID", CommonMethods.generateRandomNumberOfFixLength(10));

			String bodyAsString = CommonMethods.captureResponseOhio_v1(jsonArr, CommonMethods.propertyfileReader(globalVariables.ohio_staff_v1));
			
			String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v1(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_staff_get_v1));
			
			jsonobject.put("StaffSSN", SSN);
			jsonobject.put("StaffOtherID", CommonMethods.generateRandomNumberOfFixLength(9));
			jsonobject.put("SequenceID", CommonMethods.generateRandomNumberOfFixLength(10));
			
			String bodyAsString1 = CommonMethods.captureResponseOhio_v1(jsonArr, CommonMethods.propertyfileReader(globalVariables.ohio_staff_v1));
	
			String bodyAsStringget1=CommonMethods.captureGetResponseOhioGetWithUID_v1(bodyAsString1, CommonMethods.propertyfileReader(globalVariables.ohio_staff_get_v1));

			Assertion_DbVerifier.jsonAssert_InboxWorker_Ohio(bodyAsStringget1, jsonobject);
		
		}

	// TC98747_StaffOtherID & SSN should be kept same, SequenceID should be changed
	@SuppressWarnings("unused")
	@Test(groups = {"All","fixing"})
	@AdditionalInfo(module = "OhioStaff")
	public void TC98747_Ohio_Employeecreation_with_Same_Otherid_SSN_different_Seqid() throws Exception {

			// logger = extent.startTest("TC98747_Ohio_Employeecreation_with_Same_Otherid_SSN_different_Seqid");
			String Staffotherid= CommonMethods.generateRandomNumberOfFixLength(9);
			
			String SSN= CommonMethods.generateRandomNumberOfFixLength(9);
			
			JSONArray jsonArr=GenerateUniqueParam.EmpParams_Ohio_V1(globalVariables.ThreeP_Staff_Json);

			JSONObject jsonobject = (JSONObject) jsonArr.get(0);
		
			jsonobject.put("StaffSSN", SSN);
			jsonobject.put("StaffOtherID", Staffotherid);
			jsonobject.put("SequenceID", CommonMethods.generateRandomNumberOfFixLength(10));

			String bodyAsString = CommonMethods.captureResponseOhio_v1(jsonArr, CommonMethods.propertyfileReader(globalVariables.ohio_staff_v1));
			
			String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v1(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_staff_get_v1));
			
			jsonobject.put("StaffSSN", SSN);
			jsonobject.put("StaffOtherID", Staffotherid);
			jsonobject.put("SequenceID", CommonMethods.generateRandomNumberOfFixLength(10));
			
			String bodyAsString1 = CommonMethods.captureResponseOhio_v1(jsonArr, CommonMethods.propertyfileReader(globalVariables.ohio_staff_v1));
			
			String bodyAsStringget1=CommonMethods.captureGetResponseOhioGetWithUID_v1(bodyAsString1, CommonMethods.propertyfileReader(globalVariables.ohio_staff_get_v1));

			Assertion_DbVerifier.jsonAssert_InboxWorker_Ohio(bodyAsStringget1, jsonobject);
		
		}
	
	// TC98750_ Keep StaffOtherID same, change SSN  and SequenceID)
	@SuppressWarnings("unused")
	@Test(groups = {"All", "Regression","fixing"})
	@AdditionalInfo(module = "OhioStaff")
	public void TC98747_Ohio_Employeecreation_with_Same_Otherid_Seqid_different_SSN() throws Exception {

				// logger = extent.startTest("TC98747_Ohio_Employeecreation_with_Same_Otherid_Seqid_different_SSN");
				
				String SSN= CommonMethods.generateRandomNumberOfFixLength(9);
				
				JSONArray jsonArr=GenerateUniqueParam.EmpParams_Ohio_V1(globalVariables.ThreeP_Staff_Json);

				JSONObject jsonobject = (JSONObject) jsonArr.get(0);
			
				jsonobject.put("StaffSSN", SSN);
				jsonobject.put("StaffOtherID", CommonMethods.generateRandomNumberOfFixLength(9));
				jsonobject.put("SequenceID", CommonMethods.generateRandomNumberOfFixLength(10));

				String bodyAsString = CommonMethods.captureResponseOhio_v1(jsonArr, CommonMethods.propertyfileReader(globalVariables.ohio_staff_v1));
				
				String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v1(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_staff_get_v1));
				
				jsonobject.put("StaffSSN", SSN);
				jsonobject.put("StaffOtherID", CommonMethods.generateRandomNumberOfFixLength(9));
				jsonobject.put("SequenceID", CommonMethods.generateRandomNumberOfFixLength(10));
				
				String bodyAsString1 = CommonMethods.captureResponseOhio_v1(jsonArr, CommonMethods.propertyfileReader(globalVariables.ohio_staff_v1));
				
				String bodyAsStringget1=CommonMethods.captureGetResponseOhioGetWithUID_v1(bodyAsString1, CommonMethods.propertyfileReader(globalVariables.ohio_staff_get_v1));

			//	Assert.assertTrue(bodyAsStringget1.contains("Version number is duplicated or older than current"));
			
			}


}
