package com.ohio.intake.VisitV2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.Constant_SQL;
import com.globalMethods.core.DataBaseVerifier;
import com.globalMethods.core.globalVariables;
import Utills_ExtentReport_Log4j.BaseTest;

public class UniqueJsonGeneratorVisit extends BaseTest{
	
	DataBaseVerifier dataBaseVerifier=new DataBaseVerifier();
	Constant_SQL Constant_SQL=new Constant_SQL();
	UniqueJsonGenerator_Patient_Staff jsonGeneratorStaffPatient = new UniqueJsonGenerator_Patient_Staff();


	@SuppressWarnings({ "unchecked", "unused" })
	public JSONArray VisitParam_v2_SEVV9533_ProcedureCode_G0156() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, ClassNotFoundException {


		////////////Generating Unique patient detail using  Ohio v2 json//////////////
		JSONArray jsonArrayClient = jsonGeneratorStaffPatient.patient_Ohio("patientIntake_v2");
		JSONObject jsonObjectClient = (JSONObject) jsonArrayClient.get(0);
		JSONArray jsonarrayclientPayerInformation = (JSONArray) jsonObjectClient.get("IndividualPayerInformation");
		JSONObject jsonObjectClientPayerInformation = (JSONObject) jsonarrayclientPayerInformation.get(0);
		jsonObjectClientPayerInformation.put("ProcedureCode", "G0156");
		jsonObjectClientPayerInformation.put(globalVariables.payer, "Aetna");
		jsonObjectClientPayerInformation.put(globalVariables.PayerProgram, "SP");
			
		String bodyAsStringClient = CommonMethods.captureResponseOhio_v2(jsonArrayClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));
		String bodyAsStringGet=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsStringClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));

		////////////Generating Unique Employee detail from Ohio v2 employee json//////////////
		JSONArray jsonArrayEmp = jsonGeneratorStaffPatient.Staff_Params_3p_v2("worker_v2");
		JSONObject jsonObjectEmp = (JSONObject) jsonArrayEmp.get(0);
		
		String bodyAsStringEmp = CommonMethods.captureResponseOhio_v2(jsonArrayEmp, CommonMethods.propertyfileReader("ohio_staff_v2"));
		String bodyAsStringEmpGet=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsStringEmp, CommonMethods.propertyfileReader("ohio_staff_get_v2"));

		////////////Generating Unique visit detail from ohio v2 visitjson//////////////
		JSONArray jsonArrayVisit = CommonMethods.LoadJSON_Ohio(globalVariables.Ohio_visit_v2_json);

		Map<String,String> DbMap=new HashMap<String, String>();
		DbMap=dataBaseVerifier.executeQuery(String.format(Constant_SQL.stxAccount,CommonMethods.propertyfileReader(globalVariables.ohio_accid)));
		String BusinessEntityMedicaidIdentifier= DbMap.get("PROVIDER_ID");
		String BusinessEntityID= DbMap.get("ACCOUNT");
		
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put("BusinessEntityID", BusinessEntityID);
		jsonObjectVisit.put("BusinessEntityMedicaidIdentifier", BusinessEntityMedicaidIdentifier);
		jsonObjectVisit.put("PatientMedicaidID",jsonObjectClient.get("PatientMedicaidID").toString());
		jsonObjectVisit.put("PatientOtherID",jsonObjectClient.get("PatientOtherID").toString());
		jsonObjectVisit.put("StaffOtherID",jsonObjectEmp.get("StaffOtherID").toString());
		jsonObjectVisit.put("ProcedureCode","G0156");

		String sequenceid = CommonMethods.generateRandomNumberOfFixLength(9);
		jsonObjectVisit.put("SequenceID",sequenceid);
		jsonObjectVisit.put("VisitOtherID",CommonMethods.generateRandomNumberOfFixLength(8));

		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges = (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put("SequenceID", sequenceid);
		
		JSONArray jsonArrayVisitCall = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitCall = (JSONObject) jsonArrayVisitCall.get(0);
		jsonObjectVisitCall.put("ProcedureCode","G0156");


		return jsonArrayVisit;

	}
	

	@SuppressWarnings({ "unchecked", "unused" })
	public JSONArray VisitParam_v2_SEVV9533_ProcedureCode_G0299() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, ClassNotFoundException {


		////////////Generating Unique patient detail using  Ohio v2 json//////////////
		JSONArray jsonArrayClient = jsonGeneratorStaffPatient.patient_Ohio("patientIntake_v2");
		JSONObject jsonObjectClient = (JSONObject) jsonArrayClient.get(0);
		JSONArray jsonarrayclientPayerInformation = (JSONArray) jsonObjectClient.get("IndividualPayerInformation");
		JSONObject jsonObjectClientPayerInformation = (JSONObject) jsonarrayclientPayerInformation.get(0);
		jsonObjectClientPayerInformation.put("ProcedureCode", "G0299");
		jsonObjectClientPayerInformation.put(globalVariables.payer, "Aetna");
		jsonObjectClientPayerInformation.put(globalVariables.PayerProgram, "OHC");
			
		String bodyAsStringClient = CommonMethods.captureResponseOhio_v2(jsonArrayClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));
		String bodyAsStringGet=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsStringClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));
		
		////////////Generating Unique Employee detail from Ohio v2 employee json//////////////
		JSONArray jsonArrayEmp = jsonGeneratorStaffPatient.Staff_Params_3p_v2("worker_v2");
		JSONObject jsonObjectEmp = (JSONObject) jsonArrayEmp.get(0);
		
		String bodyAsStringEmp = CommonMethods.captureResponseOhio_v2(jsonArrayEmp, CommonMethods.propertyfileReader("ohio_staff_v2"));
		String bodyAsStringEmpGet=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsStringEmp, CommonMethods.propertyfileReader("ohio_staff_get_v2"));
		
		////////////Generating Unique visit detail from ohio v2 visitjson//////////////
		JSONArray jsonArrayVisit = CommonMethods.LoadJSON_Ohio(globalVariables.Ohio_visit_v2_json);

		Map<String,String> DbMap=new HashMap<String, String>();
		DbMap=dataBaseVerifier.executeQuery(String.format(Constant_SQL.stxAccount,CommonMethods.propertyfileReader(globalVariables.ohio_accid)));
		String BusinessEntityMedicaidIdentifier= DbMap.get("PROVIDER_ID");
		String BusinessEntityID= DbMap.get("ACCOUNT");
		
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put("BusinessEntityID", BusinessEntityID);
		jsonObjectVisit.put("BusinessEntityMedicaidIdentifier", BusinessEntityMedicaidIdentifier);
		jsonObjectVisit.put("PatientMedicaidID",jsonObjectClient.get("PatientMedicaidID").toString());
		jsonObjectVisit.put("PatientOtherID",jsonObjectClient.get("PatientOtherID").toString());
		jsonObjectVisit.put("StaffOtherID",jsonObjectEmp.get("StaffOtherID").toString());
		jsonObjectVisit.put("ProcedureCode","G0299");

		String sequenceid = CommonMethods.generateRandomNumberOfFixLength(9);
		jsonObjectVisit.put("SequenceID",sequenceid);
		jsonObjectVisit.put("VisitOtherID",CommonMethods.generateRandomNumberOfFixLength(8));

		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges = (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put("SequenceID", sequenceid);
		
		JSONArray jsonArrayVisitCall = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitCall = (JSONObject) jsonArrayVisitCall.get(0);
		jsonObjectVisitCall.put("ProcedureCode","G0299");


		return jsonArrayVisit;

	}


	@SuppressWarnings({ "unchecked", "unused" })
	public JSONArray VisitParam_v2_SEVV9533_ProcedureCode_G0300() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, ClassNotFoundException {


		////////////Generating Unique patient detail using  Ohio v2 json//////////////
		JSONArray jsonArrayClient = jsonGeneratorStaffPatient.patient_Ohio("patientIntake_v2");
		JSONObject jsonObjectClient = (JSONObject) jsonArrayClient.get(0);
		JSONArray jsonarrayclientPayerInformation = (JSONArray) jsonObjectClient.get("IndividualPayerInformation");
		JSONObject jsonObjectClientPayerInformation = (JSONObject) jsonarrayclientPayerInformation.get(0);
		jsonObjectClientPayerInformation.put("ProcedureCode", "G0300");
		jsonObjectClientPayerInformation.put(globalVariables.payer, "Aetna");
		jsonObjectClientPayerInformation.put(globalVariables.PayerProgram, "OHC");
			
		String bodyAsStringClient = CommonMethods.captureResponseOhio_v2(jsonArrayClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));
		String bodyAsStringGet=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsStringClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));
		
		////////////Generating Unique Employee detail from Ohio v2 employee json//////////////
		JSONArray jsonArrayEmp = jsonGeneratorStaffPatient.Staff_Params_3p_v2("worker_v2");
		JSONObject jsonObjectEmp = (JSONObject) jsonArrayEmp.get(0);
		
		String bodyAsStringEmp = CommonMethods.captureResponseOhio_v2(jsonArrayEmp, CommonMethods.propertyfileReader("ohio_staff_v2"));
		String bodyAsStringEmpGet=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsStringEmp, CommonMethods.propertyfileReader("ohio_staff_get_v2"));
		
		////////////Generating Unique visit detail from ohio v2 visitjson//////////////
		JSONArray jsonArrayVisit = CommonMethods.LoadJSON_Ohio(globalVariables.Ohio_visit_v2_json);

		Map<String,String> DbMap=new HashMap<String, String>();
		DbMap=dataBaseVerifier.executeQuery(String.format(Constant_SQL.stxAccount,CommonMethods.propertyfileReader(globalVariables.ohio_accid)));
		String BusinessEntityMedicaidIdentifier= DbMap.get("PROVIDER_ID");
		String BusinessEntityID= DbMap.get("ACCOUNT");
		
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put("BusinessEntityID", BusinessEntityID);
		jsonObjectVisit.put("BusinessEntityMedicaidIdentifier", BusinessEntityMedicaidIdentifier);
		jsonObjectVisit.put("PatientMedicaidID",jsonObjectClient.get("PatientMedicaidID").toString());
		jsonObjectVisit.put("PatientOtherID",jsonObjectClient.get("PatientOtherID").toString());
		jsonObjectVisit.put("StaffOtherID",jsonObjectEmp.get("StaffOtherID").toString());
		jsonObjectVisit.put("ProcedureCode","G0300");

		String sequenceid = CommonMethods.generateUniqueID();
		jsonObjectVisit.put("SequenceID",sequenceid);
		jsonObjectVisit.put("VisitOtherID",CommonMethods.generateUniqueID());

		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges = (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put("SequenceID", sequenceid);
		
		JSONArray jsonArrayVisitCall = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitCall = (JSONObject) jsonArrayVisitCall.get(0);
		jsonObjectVisitCall.put("ProcedureCode","G0300");


		return jsonArrayVisit;

	}


	@SuppressWarnings({ "unchecked", "unused" })
	public JSONArray VisitParam_v2_SEVV9533_ProcedureCode_HPC() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, ClassNotFoundException {


		////////////Generating Unique patient detail using  Ohio v2 json//////////////
		JSONArray jsonArrayClient = jsonGeneratorStaffPatient.patient_Ohio("patientIntake_v2");
		JSONObject jsonObjectClient = (JSONObject) jsonArrayClient.get(0);
		JSONArray jsonarrayclientPayerInformation = (JSONArray) jsonObjectClient.get("IndividualPayerInformation");
		JSONObject jsonObjectClientPayerInformation = (JSONObject) jsonarrayclientPayerInformation.get(0);
		jsonObjectClientPayerInformation.put("ProcedureCode", "HPC");
		jsonObjectClientPayerInformation.put(globalVariables.payer, "Aetna");
		jsonObjectClientPayerInformation.put(globalVariables.PayerProgram, "OHC");
			
		String bodyAsStringClient = CommonMethods.captureResponseOhio_v2(jsonArrayClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));
		String bodyAsStringGet=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsStringClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));
		
		////////////Generating Unique Employee detail from Ohio v2 employee json//////////////
		JSONArray jsonArrayEmp = jsonGeneratorStaffPatient.Staff_Params_3p_v2("worker_v2");
		JSONObject jsonObjectEmp = (JSONObject) jsonArrayEmp.get(0);
		
		String bodyAsStringEmp = CommonMethods.captureResponseOhio_v2(jsonArrayEmp, CommonMethods.propertyfileReader("ohio_staff_v2"));
		String bodyAsStringEmpGet=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsStringEmp, CommonMethods.propertyfileReader("ohio_staff_get_v2"));
		
		////////////Generating Unique visit detail from ohio v2 visitjson//////////////
		JSONArray jsonArrayVisit = CommonMethods.LoadJSON_Ohio(globalVariables.Ohio_visit_v2_json);

		Map<String,String> DbMap;
		DbMap=dataBaseVerifier.executeQuery(String.format(Constant_SQL.stxAccount,CommonMethods.propertyfileReader(globalVariables.ohio_accid)));
		String BusinessEntityMedicaidIdentifier= DbMap.get("PROVIDER_ID");
		String BusinessEntityID= DbMap.get("ACCOUNT");
		
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put("BusinessEntityID", BusinessEntityID);
		jsonObjectVisit.put("BusinessEntityMedicaidIdentifier", BusinessEntityMedicaidIdentifier);
		jsonObjectVisit.put("PatientMedicaidID",jsonObjectClient.get("PatientMedicaidID").toString());
		jsonObjectVisit.put("PatientOtherID",jsonObjectClient.get("PatientOtherID").toString());
		jsonObjectVisit.put("StaffOtherID",jsonObjectEmp.get("StaffOtherID").toString());
		jsonObjectVisit.put("ProcedureCode", "HPC");

		String sequenceid = CommonMethods.generateUniqueID();
		jsonObjectVisit.put("SequenceID",sequenceid);
		jsonObjectVisit.put("VisitOtherID",CommonMethods.generateUniqueID());

		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges = (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put("SequenceID", sequenceid);
		
		JSONArray jsonArrayVisitCall = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitCall = (JSONObject) jsonArrayVisitCall.get(0);
		jsonObjectVisitCall.put("ProcedureCode", "HPC");


		return jsonArrayVisit;

	}


	@SuppressWarnings({ "unchecked", "unused" })
	public JSONArray VisitParam_v2_SEVV9533_ProcedureCode_S5125() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, ClassNotFoundException {


		////////////Generating Unique patient detail using  Ohio v2 json//////////////
		JSONArray jsonArrayClient = jsonGeneratorStaffPatient.patient_Ohio("patientIntake_v2");
		JSONObject jsonObjectClient = (JSONObject) jsonArrayClient.get(0);
		JSONArray jsonarrayclientPayerInformation = (JSONArray) jsonObjectClient.get("IndividualPayerInformation");
		JSONObject jsonObjectClientPayerInformation = (JSONObject) jsonarrayclientPayerInformation.get(0);
		jsonObjectClientPayerInformation.put("ProcedureCode", "S5125");
		jsonObjectClientPayerInformation.put(globalVariables.payer, "Aetna");
		jsonObjectClientPayerInformation.put(globalVariables.PayerProgram, "OHC");
			
		String bodyAsStringClient = CommonMethods.captureResponseOhio_v2(jsonArrayClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));
		String bodyAsStringGet=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsStringClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));
		
		////////////Generating Unique Employee detail from Ohio v2 employee json//////////////
		JSONArray jsonArrayEmp = jsonGeneratorStaffPatient.Staff_Params_3p_v2("worker_v2");
		JSONObject jsonObjectEmp = (JSONObject) jsonArrayEmp.get(0);
		
		String bodyAsStringEmp = CommonMethods.captureResponseOhio_v2(jsonArrayEmp, CommonMethods.propertyfileReader("ohio_staff_v2"));
		String bodyAsStringEmpGet=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsStringEmp, CommonMethods.propertyfileReader("ohio_staff_get_v2"));
		
		////////////Generating Unique visit detail from ohio v2 visitjson//////////////
		JSONArray jsonArrayVisit = CommonMethods.LoadJSON_Ohio(globalVariables.Ohio_visit_v2_json);

		Map<String,String> DbMap=new HashMap<String, String>();
		DbMap=dataBaseVerifier.executeQuery(String.format(Constant_SQL.stxAccount,CommonMethods.propertyfileReader(globalVariables.ohio_accid)));
		String BusinessEntityMedicaidIdentifier= DbMap.get("PROVIDER_ID");
		String BusinessEntityID= DbMap.get("ACCOUNT");
		
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put("BusinessEntityID", BusinessEntityID);
		jsonObjectVisit.put("BusinessEntityMedicaidIdentifier", BusinessEntityMedicaidIdentifier);
		jsonObjectVisit.put("PatientMedicaidID",jsonObjectClient.get("PatientMedicaidID").toString());
		jsonObjectVisit.put("PatientOtherID",jsonObjectClient.get("PatientOtherID").toString());
		jsonObjectVisit.put("StaffOtherID",jsonObjectEmp.get("StaffOtherID").toString());
		jsonObjectVisit.put("ProcedureCode","S5125");

		String sequenceid = CommonMethods.generateUniqueID();
		jsonObjectVisit.put("SequenceID",sequenceid);
		jsonObjectVisit.put("VisitOtherID",CommonMethods.generateUniqueID());

		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges = (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put("SequenceID", sequenceid);
		
		JSONArray jsonArrayVisitCall = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitCall = (JSONObject) jsonArrayVisitCall.get(0);
		jsonObjectVisitCall.put("ProcedureCode","S5125");


		return jsonArrayVisit;

	}


	@SuppressWarnings({ "unchecked", "unused" })
	public JSONArray VisitParam_v2_SEVV9533_ProcedureCode_T1000() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, ClassNotFoundException {


		////////////Generating Unique patient detail using  Ohio v2 json//////////////
		JSONArray jsonArrayClient = jsonGeneratorStaffPatient.patient_Ohio("patientIntake_v2");
		JSONObject jsonObjectClient = (JSONObject) jsonArrayClient.get(0);
		JSONArray jsonarrayclientPayerInformation = (JSONArray) jsonObjectClient.get("IndividualPayerInformation");
		JSONObject jsonObjectClientPayerInformation = (JSONObject) jsonarrayclientPayerInformation.get(0);
		jsonObjectClientPayerInformation.put("ProcedureCode", "T1000");
		jsonObjectClientPayerInformation.put(globalVariables.payer, "Aetna");
		jsonObjectClientPayerInformation.put(globalVariables.PayerProgram, "OHC");
			
		String bodyAsStringClient = CommonMethods.captureResponseOhio_v2(jsonArrayClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));
		String bodyAsStringGet=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsStringClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));
		
		////////////Generating Unique Employee detail from Ohio v2 employee json//////////////
		JSONArray jsonArrayEmp = jsonGeneratorStaffPatient.Staff_Params_3p_v2("worker_v2");
		JSONObject jsonObjectEmp = (JSONObject) jsonArrayEmp.get(0);
		
		String bodyAsStringEmp = CommonMethods.captureResponseOhio_v2(jsonArrayEmp, CommonMethods.propertyfileReader("ohio_staff_v2"));
		String bodyAsStringEmpGet=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsStringEmp, CommonMethods.propertyfileReader("ohio_staff_get_v2"));
		
		////////////Generating Unique visit detail from ohio v2 visitjson//////////////
		JSONArray jsonArrayVisit = CommonMethods.LoadJSON_Ohio(globalVariables.Ohio_visit_v2_json);

		Map<String,String> DbMap=new HashMap<String, String>();
		DbMap=dataBaseVerifier.executeQuery(String.format(Constant_SQL.stxAccount,CommonMethods.propertyfileReader(globalVariables.ohio_accid)));
		String BusinessEntityMedicaidIdentifier= DbMap.get("PROVIDER_ID");
		String BusinessEntityID= DbMap.get("ACCOUNT");
		
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put("BusinessEntityID", BusinessEntityID);
		jsonObjectVisit.put("BusinessEntityMedicaidIdentifier", BusinessEntityMedicaidIdentifier);
		jsonObjectVisit.put("PatientMedicaidID",jsonObjectClient.get("PatientMedicaidID").toString());
		jsonObjectVisit.put("PatientOtherID",jsonObjectClient.get("PatientOtherID").toString());
		jsonObjectVisit.put("StaffOtherID",jsonObjectEmp.get("StaffOtherID").toString());
		jsonObjectVisit.put("ProcedureCode", "T1000");

		String sequenceid = CommonMethods.generateRandomNumberOfFixLength(9);
		jsonObjectVisit.put("SequenceID",sequenceid);
		jsonObjectVisit.put("VisitOtherID",CommonMethods.generateRandomNumberOfFixLength(8));

		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges = (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put("SequenceID", sequenceid);
		
		JSONArray jsonArrayVisitCall = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitCall = (JSONObject) jsonArrayVisitCall.get(0);
		jsonObjectVisitCall.put("ProcedureCode", "T1000");


		return jsonArrayVisit;

	}


	@SuppressWarnings({ "unchecked", "unused" })
	public JSONArray VisitParam_v2_SEVV9533_ProcedureCode_T1001() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, ClassNotFoundException {


		////////////Generating Unique patient detail using  Ohio v2 json//////////////
		JSONArray jsonArrayClient = jsonGeneratorStaffPatient.patient_Ohio("patientIntake_v2");
		JSONObject jsonObjectClient = (JSONObject) jsonArrayClient.get(0);
		JSONArray jsonarrayclientPayerInformation = (JSONArray) jsonObjectClient.get("IndividualPayerInformation");
		JSONObject jsonObjectClientPayerInformation = (JSONObject) jsonarrayclientPayerInformation.get(0);
		jsonObjectClientPayerInformation.put("ProcedureCode", "T1001");
		jsonObjectClientPayerInformation.put(globalVariables.payer, "Aetna");
		jsonObjectClientPayerInformation.put(globalVariables.PayerProgram, "OHC");
			
		String bodyAsStringClient = CommonMethods.captureResponseOhio_v2(jsonArrayClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));
		String bodyAsStringGet=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsStringClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));
		
		////////////Generating Unique Employee detail from Ohio v2 employee json//////////////
		JSONArray jsonArrayEmp = jsonGeneratorStaffPatient.Staff_Params_3p_v2("worker_v2");
		JSONObject jsonObjectEmp = (JSONObject) jsonArrayEmp.get(0);
		
		String bodyAsStringEmp = CommonMethods.captureResponseOhio_v2(jsonArrayEmp, CommonMethods.propertyfileReader("ohio_staff_v2"));
		String bodyAsStringEmpGet=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsStringEmp, CommonMethods.propertyfileReader("ohio_staff_get_v2"));
		
		////////////Generating Unique visit detail from ohio v2 visitjson//////////////
		JSONArray jsonArrayVisit = CommonMethods.LoadJSON_Ohio(globalVariables.Ohio_visit_v2_json);

		Map<String,String> DbMap=new HashMap<String, String>();
		DbMap=dataBaseVerifier.executeQuery(String.format(Constant_SQL.stxAccount,CommonMethods.propertyfileReader(globalVariables.ohio_accid)));
		String BusinessEntityMedicaidIdentifier= DbMap.get("PROVIDER_ID");
		String BusinessEntityID= DbMap.get("ACCOUNT");
		
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put("BusinessEntityID", BusinessEntityID);
		jsonObjectVisit.put("BusinessEntityMedicaidIdentifier", BusinessEntityMedicaidIdentifier);
		jsonObjectVisit.put("PatientMedicaidID",jsonObjectClient.get("PatientMedicaidID").toString());
		jsonObjectVisit.put("PatientOtherID",jsonObjectClient.get("PatientOtherID").toString());
		jsonObjectVisit.put("StaffOtherID",jsonObjectEmp.get("StaffOtherID").toString());
		jsonObjectVisit.put("ProcedureCode","T1001");

		String sequenceid = CommonMethods.generateRandomNumberOfFixLength(9);
		jsonObjectVisit.put("SequenceID",sequenceid);
		jsonObjectVisit.put("VisitOtherID",CommonMethods.generateRandomNumberOfFixLength(8));

		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges = (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put("SequenceID", sequenceid);
		
		JSONArray jsonArrayVisitCall = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitCall = (JSONObject) jsonArrayVisitCall.get(0);
		jsonObjectVisitCall.put("ProcedureCode","T1001");


		return jsonArrayVisit;

	}


	@SuppressWarnings({ "unchecked", "unused" })
	public JSONArray VisitParam_v2_SEVV9533_ProcedureCode_T1002() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, ClassNotFoundException {


		////////////Generating Unique patient detail using  Ohio v2 json//////////////
		JSONArray jsonArrayClient = jsonGeneratorStaffPatient.patient_Ohio("patientIntake_v2");
		JSONObject jsonObjectClient = (JSONObject) jsonArrayClient.get(0);
		JSONArray jsonarrayclientPayerInformation = (JSONArray) jsonObjectClient.get("IndividualPayerInformation");
		JSONObject jsonObjectClientPayerInformation = (JSONObject) jsonarrayclientPayerInformation.get(0);
		jsonObjectClientPayerInformation.put("ProcedureCode", "T1002");
		jsonObjectClientPayerInformation.put(globalVariables.payer, "Aetna");
		jsonObjectClientPayerInformation.put(globalVariables.PayerProgram, "OHC");
			
		String bodyAsStringClient = CommonMethods.captureResponseOhio_v2(jsonArrayClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));
		String bodyAsStringGet=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsStringClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));
		
		////////////Generating Unique Employee detail from Ohio v2 employee json//////////////
		JSONArray jsonArrayEmp = jsonGeneratorStaffPatient.Staff_Params_3p_v2("worker_v2");
		JSONObject jsonObjectEmp = (JSONObject) jsonArrayEmp.get(0);
		
		String bodyAsStringEmp = CommonMethods.captureResponseOhio_v2(jsonArrayEmp, CommonMethods.propertyfileReader("ohio_staff_v2"));
		String bodyAsStringEmpGet=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsStringEmp, CommonMethods.propertyfileReader("ohio_staff_get_v2"));
		
		////////////Generating Unique visit detail from ohio v2 visitjson//////////////
		JSONArray jsonArrayVisit = CommonMethods.LoadJSON_Ohio(globalVariables.Ohio_visit_v2_json);

		Map<String,String> DbMap=new HashMap<String, String>();
		DbMap=dataBaseVerifier.executeQuery(String.format(Constant_SQL.stxAccount,CommonMethods.propertyfileReader(globalVariables.ohio_accid)));
		String BusinessEntityMedicaidIdentifier= DbMap.get("PROVIDER_ID");
		String BusinessEntityID= DbMap.get("ACCOUNT");
		
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put("BusinessEntityID", BusinessEntityID);
		jsonObjectVisit.put("BusinessEntityMedicaidIdentifier", BusinessEntityMedicaidIdentifier);
		jsonObjectVisit.put("PatientMedicaidID",jsonObjectClient.get("PatientMedicaidID").toString());
		jsonObjectVisit.put("PatientOtherID",jsonObjectClient.get("PatientOtherID").toString());
		jsonObjectVisit.put("StaffOtherID",jsonObjectEmp.get("StaffOtherID").toString());
		jsonObjectVisit.put("ProcedureCode","T1002");

		String sequenceid = CommonMethods.generateRandomNumberOfFixLength(9);
		jsonObjectVisit.put("SequenceID",sequenceid);
		jsonObjectVisit.put("VisitOtherID",CommonMethods.generateRandomNumberOfFixLength(8));

		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges = (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put("SequenceID", sequenceid);
		
		JSONArray jsonArrayVisitCall = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitCall = (JSONObject) jsonArrayVisitCall.get(0);
		jsonObjectVisitCall.put("ProcedureCode","T1002");


		return jsonArrayVisit;

	}


	@SuppressWarnings({ "unchecked", "unused" })
	public JSONArray VisitParam_v2_SEVV9533_ProcedureCode_T1003() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, ClassNotFoundException {


		////////////Generating Unique patient detail using  Ohio v2 json//////////////
		JSONArray jsonArrayClient = jsonGeneratorStaffPatient.patient_Ohio("patientIntake_v2");
		JSONObject jsonObjectClient = (JSONObject) jsonArrayClient.get(0);
		JSONArray jsonarrayclientPayerInformation = (JSONArray) jsonObjectClient.get("IndividualPayerInformation");
		JSONObject jsonObjectClientPayerInformation = (JSONObject) jsonarrayclientPayerInformation.get(0);
		jsonObjectClientPayerInformation.put("ProcedureCode", "T1003");
		jsonObjectClientPayerInformation.put(globalVariables.payer, "Aetna");
		jsonObjectClientPayerInformation.put(globalVariables.PayerProgram, "OHC");
			
		String bodyAsStringClient = CommonMethods.captureResponseOhio_v2(jsonArrayClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));
		String bodyAsStringGet=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsStringClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));
		
		////////////Generating Unique Employee detail from Ohio v2 employee json//////////////
		JSONArray jsonArrayEmp = jsonGeneratorStaffPatient.Staff_Params_3p_v2("worker_v2");
		JSONObject jsonObjectEmp = (JSONObject) jsonArrayEmp.get(0);
		
		String bodyAsStringEmp = CommonMethods.captureResponseOhio_v2(jsonArrayEmp, CommonMethods.propertyfileReader("ohio_staff_v2"));
		String bodyAsStringEmpGet=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsStringEmp, CommonMethods.propertyfileReader("ohio_staff_get_v2"));
		
		////////////Generating Unique visit detail from ohio v2 visitjson//////////////
		JSONArray jsonArrayVisit = CommonMethods.LoadJSON_Ohio(globalVariables.Ohio_visit_v2_json);

		Map<String,String> DbMap=new HashMap<String, String>();
		DbMap=dataBaseVerifier.executeQuery(String.format(Constant_SQL.stxAccount,CommonMethods.propertyfileReader(globalVariables.ohio_accid)));
		String BusinessEntityMedicaidIdentifier= DbMap.get("PROVIDER_ID");
		String BusinessEntityID= DbMap.get("ACCOUNT");
		
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put("BusinessEntityID", BusinessEntityID);
		jsonObjectVisit.put("BusinessEntityMedicaidIdentifier", BusinessEntityMedicaidIdentifier);
		jsonObjectVisit.put("PatientMedicaidID",jsonObjectClient.get("PatientMedicaidID").toString());
		jsonObjectVisit.put("PatientOtherID",jsonObjectClient.get("PatientOtherID").toString());
		jsonObjectVisit.put("StaffOtherID",jsonObjectEmp.get("StaffOtherID").toString());
		jsonObjectVisit.put("ProcedureCode","T1003");

		String sequenceid = CommonMethods.generateRandomNumberOfFixLength(9);
		jsonObjectVisit.put("SequenceID",sequenceid);
		jsonObjectVisit.put("VisitOtherID",CommonMethods.generateRandomNumberOfFixLength(8));

		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges = (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put("SequenceID", sequenceid);
		
		JSONArray jsonArrayVisitCall = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitCall = (JSONObject) jsonArrayVisitCall.get(0);
		jsonObjectVisitCall.put("ProcedureCode","T1003");


		return jsonArrayVisit;

	}


	@SuppressWarnings({ "unchecked", "unused" })
	public JSONArray VisitParam_v2_SEVV9533_ProcedureCode_T1019() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, ClassNotFoundException {


		////////////Generating Unique patient detail using  Ohio v2 json//////////////
		JSONArray jsonArrayClient = jsonGeneratorStaffPatient.patient_Ohio("patientIntake_v2");
		JSONObject jsonObjectClient = (JSONObject) jsonArrayClient.get(0);
		JSONArray jsonarrayclientPayerInformation = (JSONArray) jsonObjectClient.get("IndividualPayerInformation");
		JSONObject jsonObjectClientPayerInformation = (JSONObject) jsonarrayclientPayerInformation.get(0);
		jsonObjectClientPayerInformation.put("ProcedureCode", "T1019");
		jsonObjectClientPayerInformation.put(globalVariables.payer, "Aetna");
		jsonObjectClientPayerInformation.put(globalVariables.PayerProgram, "OHC");
			
		String bodyAsStringClient = CommonMethods.captureResponseOhio_v2(jsonArrayClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));
		String bodyAsStringGet=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsStringClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));
		
		////////////Generating Unique Employee detail from Ohio v2 employee json//////////////
		JSONArray jsonArrayEmp = jsonGeneratorStaffPatient.Staff_Params_3p_v2("worker_v2");
		JSONObject jsonObjectEmp = (JSONObject) jsonArrayEmp.get(0);
		
		String bodyAsStringEmp = CommonMethods.captureResponseOhio_v2(jsonArrayEmp, CommonMethods.propertyfileReader("ohio_staff_v2"));
		String bodyAsStringEmpGet=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsStringEmp, CommonMethods.propertyfileReader("ohio_staff_get_v2"));
		
		////////////Generating Unique visit detail from ohio v2 visitjson//////////////
		JSONArray jsonArrayVisit = CommonMethods.LoadJSON_Ohio(globalVariables.Ohio_visit_v2_json);

		Map<String,String> DbMap=new HashMap<String, String>();
		DbMap=dataBaseVerifier.executeQuery(String.format(Constant_SQL.stxAccount,CommonMethods.propertyfileReader(globalVariables.ohio_accid)));
		String BusinessEntityMedicaidIdentifier= DbMap.get("PROVIDER_ID");
		String BusinessEntityID= DbMap.get("ACCOUNT");
		
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put("BusinessEntityID", BusinessEntityID);
		jsonObjectVisit.put("BusinessEntityMedicaidIdentifier", BusinessEntityMedicaidIdentifier);
		jsonObjectVisit.put("PatientMedicaidID",jsonObjectClient.get("PatientMedicaidID").toString());
		jsonObjectVisit.put("PatientOtherID",jsonObjectClient.get("PatientOtherID").toString());
		jsonObjectVisit.put("StaffOtherID",jsonObjectEmp.get("StaffOtherID").toString());
		jsonObjectVisit.put("ProcedureCode","T1019");

		String sequenceid = CommonMethods.generateRandomNumberOfFixLength(9);
		jsonObjectVisit.put("SequenceID",sequenceid);
		jsonObjectVisit.put("VisitOtherID",CommonMethods.generateRandomNumberOfFixLength(8));

		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges = (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put("SequenceID", sequenceid);
		
		JSONArray jsonArrayVisitCall = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitCall = (JSONObject) jsonArrayVisitCall.get(0);
		jsonObjectVisitCall.put("ProcedureCode","T1019");


		return jsonArrayVisit;

	}

}
