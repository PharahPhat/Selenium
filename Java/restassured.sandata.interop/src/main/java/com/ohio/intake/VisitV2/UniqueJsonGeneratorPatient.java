package com.ohio.intake.VisitV2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.Constant_SQL;
import com.globalMethods.core.DataBaseVerifier;
import Utills_ExtentReport_Log4j.BaseTest;

public class UniqueJsonGeneratorPatient extends BaseTest{
	
	DataBaseVerifier dataBaseVerifier=new DataBaseVerifier();
	Constant_SQL Constant_SQL=new Constant_SQL();
	UniqueJsonGenerator_Patient_Staff jsonGeneratorStaffPatient = new UniqueJsonGenerator_Patient_Staff();


	@SuppressWarnings({ "unchecked" })
	public JSONArray ClientParam_v2_SEVV9533_ProcedureCode_G0156() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, ClassNotFoundException {

			JSONArray j= CommonMethods.LoadJSON_Ohio("patientIntake_v2");

			JSONObject js = (JSONObject) j.get(0);

			js.put("PatientOtherID", CommonMethods.generateUniqueID());
			js.put("SequenceID", CommonMethods.generateUniqueID());
			js.put("PatientMedicaidID", CommonMethods.generateRandomNumberOfFixLength(12)); 
			js.put("PatientLastName", CommonMethods.generateRandomStringOfFixLength(10));
			js.put("PatientFirstName",  CommonMethods.generateRandomStringOfFixLength(10));

			JSONArray jsAdd = (JSONArray) js.get("Address");
			JSONObject jsObj = (JSONObject) jsAdd.get(0);
			jsObj.put("PatientAddressLine1", CommonMethods.generateRandomStringOfFixLength(9));
			jsObj.put("PatientZip", CommonMethods.generateRandomNumberOfFixLength(9));

			JSONObject jsObj1 = (JSONObject) jsAdd.get(1);
			jsObj1.put("PatientAddressLine1", CommonMethods.generateRandomStringOfFixLength(9));
			jsObj1.put("PatientZip", CommonMethods.generateRandomNumberOfFixLength(9));


			JSONArray jsonarrayclientcontact = (JSONArray) js.get("ResponsibleParty");
			JSONObject jsonObjectClientContact = (JSONObject) jsonarrayclientcontact.get(0);
			jsonObjectClientContact.put("PatientResponsiblePartyLastName", CommonMethods.generateRandomStringOfFixLength(9));
			jsonObjectClientContact.put("PatientResponsiblePartyFirstName", CommonMethods.generateRandomStringOfFixLength(9));

			
			JSONArray jsonarrayPayerInformation = (JSONArray) js.get("IndividualPayerInformation");
			JSONObject jsonObjectPayerInformation = (JSONObject) jsonarrayPayerInformation.get(0);
			jsonObjectPayerInformation.put("ProcedureCode" ,"G0156");

			return j;
		}

	@SuppressWarnings({ "unchecked"})
	public JSONArray ClientParam_v2_SEVV9533_ProcedureCode_G0299() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, ClassNotFoundException {


		JSONArray j= CommonMethods.LoadJSON_Ohio("patientIntake_v2");
		Map<String,String> DbMap=new HashMap<String, String>();

		DbMap=dataBaseVerifier.executeQuery(String.format(Constant_SQL.stxAccount,CommonMethods.propertyfileReader(globalVariables.ohio_accid)));

		String BusinessEntityMedicaidIdentifier= DbMap.get("PROVIDER_ID");
		String BusinessEntityID= DbMap.get("ACCOUNT");

		JSONObject js = (JSONObject) j.get(0);

		js.put("BusinessEntityID", BusinessEntityID);
		js.put("BusinessEntityMedicaidIdentifier", BusinessEntityMedicaidIdentifier);
		js.put("PatientOtherID", CommonMethods.generateRandomNumberOfFixLength(10));
		js.put("SequenceID", CommonMethods.generateRandomNumberOfFixLength(9));
		js.put("PatientMedicaidID", CommonMethods.generateRandomNumberOfFixLength(12)); 
		js.put("PatientLastName", CommonMethods.generateRandomStringOfFixLength(10));
		js.put("PatientFirstName",  CommonMethods.generateRandomStringOfFixLength(10));

		JSONArray jsAdd = (JSONArray) js.get("Address");
		JSONObject jsObj = (JSONObject) jsAdd.get(0);
		jsObj.put("PatientAddressLine1", CommonMethods.generateRandomStringOfFixLength(9));
		jsObj.put("PatientZip", CommonMethods.generateRandomNumberOfFixLength(9));

		JSONObject jsObj1 = (JSONObject) jsAdd.get(1);
		jsObj1.put("PatientAddressLine1", CommonMethods.generateRandomStringOfFixLength(9));
		jsObj1.put("PatientZip", CommonMethods.generateRandomNumberOfFixLength(9));


		JSONArray jsonarrayclientcontact = (JSONArray) js.get("ResponsibleParty");
		JSONObject jsonObjectClientContact = (JSONObject) jsonarrayclientcontact.get(0);
		jsonObjectClientContact.put("PatientResponsiblePartyLastName", CommonMethods.generateRandomStringOfFixLength(9));
		jsonObjectClientContact.put("PatientResponsiblePartyFirstName", CommonMethods.generateRandomStringOfFixLength(9));

		
		JSONArray jsonarrayPayerInformation = (JSONArray) js.get("IndividualPayerInformation");
		JSONObject jsonObjectPayerInformation = (JSONObject) jsonarrayPayerInformation.get(0);
		jsonObjectPayerInformation.put("ProcedureCode" ,"G0299");

		return j;
	}

	@SuppressWarnings({ "unchecked"})
	public JSONArray ClientParam_v2_SEVV9533_ProcedureCode_G0300() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, ClassNotFoundException {


		JSONArray j= CommonMethods.LoadJSON_Ohio("patientIntake_v2");
		Map<String,String> DbMap=new HashMap<String, String>();

		DbMap=dataBaseVerifier.executeQuery(String.format(Constant_SQL.stxAccount,CommonMethods.propertyfileReader(globalVariables.ohio_accid)));

		String BusinessEntityMedicaidIdentifier= DbMap.get("PROVIDER_ID");
		String BusinessEntityID= DbMap.get("ACCOUNT");

		JSONObject js = (JSONObject) j.get(0);

		js.put("BusinessEntityID", BusinessEntityID);
		js.put("BusinessEntityMedicaidIdentifier", BusinessEntityMedicaidIdentifier);
		js.put("PatientOtherID", CommonMethods.generateRandomNumberOfFixLength(10));
		js.put("SequenceID", CommonMethods.generateRandomNumberOfFixLength(9));
		js.put("PatientMedicaidID", CommonMethods.generateRandomNumberOfFixLength(12)); 
		js.put("PatientLastName", CommonMethods.generateRandomStringOfFixLength(10));
		js.put("PatientFirstName",  CommonMethods.generateRandomStringOfFixLength(10));

		JSONArray jsAdd = (JSONArray) js.get("Address");
		JSONObject jsObj = (JSONObject) jsAdd.get(0);
		jsObj.put("PatientAddressLine1", CommonMethods.generateRandomStringOfFixLength(9));
		jsObj.put("PatientZip", CommonMethods.generateRandomNumberOfFixLength(9));

		JSONObject jsObj1 = (JSONObject) jsAdd.get(1);
		jsObj1.put("PatientAddressLine1", CommonMethods.generateRandomStringOfFixLength(9));
		jsObj1.put("PatientZip", CommonMethods.generateRandomNumberOfFixLength(9));


		JSONArray jsonarrayclientcontact = (JSONArray) js.get("ResponsibleParty");
		JSONObject jsonObjectClientContact = (JSONObject) jsonarrayclientcontact.get(0);
		jsonObjectClientContact.put("PatientResponsiblePartyLastName", CommonMethods.generateRandomStringOfFixLength(9));
		jsonObjectClientContact.put("PatientResponsiblePartyFirstName", CommonMethods.generateRandomStringOfFixLength(9));

		
		JSONArray jsonarrayPayerInformation = (JSONArray) js.get("IndividualPayerInformation");
		JSONObject jsonObjectPayerInformation = (JSONObject) jsonarrayPayerInformation.get(0);
		jsonObjectPayerInformation.put("ProcedureCode" ,"G0300");

		return j;

	}

	@SuppressWarnings({ "unchecked"})
	public JSONArray ClientParam_v2_SEVV9533_ProcedureCode_HPC() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, ClassNotFoundException {


		JSONArray j= CommonMethods.LoadJSON_Ohio("patientIntake_v2");
		Map<String,String> DbMap=new HashMap<String, String>();

		DbMap=dataBaseVerifier.executeQuery(String.format(Constant_SQL.stxAccount,CommonMethods.propertyfileReader(globalVariables.ohio_accid)));

		String BusinessEntityMedicaidIdentifier= DbMap.get("PROVIDER_ID");
		String BusinessEntityID= DbMap.get("ACCOUNT");

		JSONObject js = (JSONObject) j.get(0);

		js.put("BusinessEntityID", BusinessEntityID);
		js.put("BusinessEntityMedicaidIdentifier", BusinessEntityMedicaidIdentifier);
		js.put("PatientOtherID", CommonMethods.generateRandomNumberOfFixLength(10));
		js.put("SequenceID", CommonMethods.generateRandomNumberOfFixLength(9));
		js.put("PatientMedicaidID", CommonMethods.generateRandomNumberOfFixLength(12)); 
		js.put("PatientLastName", CommonMethods.generateRandomStringOfFixLength(10));
		js.put("PatientFirstName",  CommonMethods.generateRandomStringOfFixLength(10));

		JSONArray jsAdd = (JSONArray) js.get("Address");
		JSONObject jsObj = (JSONObject) jsAdd.get(0);
		jsObj.put("PatientAddressLine1", CommonMethods.generateRandomStringOfFixLength(9));
		jsObj.put("PatientZip", CommonMethods.generateRandomNumberOfFixLength(9));

		JSONObject jsObj1 = (JSONObject) jsAdd.get(1);
		jsObj1.put("PatientAddressLine1", CommonMethods.generateRandomStringOfFixLength(9));
		jsObj1.put("PatientZip", CommonMethods.generateRandomNumberOfFixLength(9));


		JSONArray jsonarrayclientcontact = (JSONArray) js.get("ResponsibleParty");
		JSONObject jsonObjectClientContact = (JSONObject) jsonarrayclientcontact.get(0);
		jsonObjectClientContact.put("PatientResponsiblePartyLastName", CommonMethods.generateRandomStringOfFixLength(9));
		jsonObjectClientContact.put("PatientResponsiblePartyFirstName", CommonMethods.generateRandomStringOfFixLength(9));

		
		JSONArray jsonarrayPayerInformation = (JSONArray) js.get("IndividualPayerInformation");
		JSONObject jsonObjectPayerInformation = (JSONObject) jsonarrayPayerInformation.get(0);
		jsonObjectPayerInformation.put("ProcedureCode" ,"HPC");

		return j;

	}

	@SuppressWarnings({ "unchecked"})
	public JSONArray ClientParam_v2_SEVV9533_ProcedureCode_S5125() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, ClassNotFoundException {


		JSONArray j= CommonMethods.LoadJSON_Ohio("patientIntake_v2");
		Map<String,String> DbMap=new HashMap<String, String>();

		DbMap=dataBaseVerifier.executeQuery(String.format(Constant_SQL.stxAccount,CommonMethods.propertyfileReader(globalVariables.ohio_accid)));

		String BusinessEntityMedicaidIdentifier= DbMap.get("PROVIDER_ID");
		String BusinessEntityID= DbMap.get("ACCOUNT");

		JSONObject js = (JSONObject) j.get(0);

		js.put("BusinessEntityID", BusinessEntityID);
		js.put("BusinessEntityMedicaidIdentifier", BusinessEntityMedicaidIdentifier);
		js.put("PatientOtherID", CommonMethods.generateRandomNumberOfFixLength(10));
		js.put("SequenceID", CommonMethods.generateRandomNumberOfFixLength(9));
		js.put("PatientMedicaidID", CommonMethods.generateRandomNumberOfFixLength(12)); 
		js.put("PatientLastName", CommonMethods.generateRandomStringOfFixLength(10));
		js.put("PatientFirstName",  CommonMethods.generateRandomStringOfFixLength(10));

		JSONArray jsAdd = (JSONArray) js.get("Address");
		JSONObject jsObj = (JSONObject) jsAdd.get(0);
		jsObj.put("PatientAddressLine1", CommonMethods.generateRandomStringOfFixLength(9));
		jsObj.put("PatientZip", CommonMethods.generateRandomNumberOfFixLength(9));

		JSONObject jsObj1 = (JSONObject) jsAdd.get(1);
		jsObj1.put("PatientAddressLine1", CommonMethods.generateRandomStringOfFixLength(9));
		jsObj1.put("PatientZip", CommonMethods.generateRandomNumberOfFixLength(9));


		JSONArray jsonarrayclientcontact = (JSONArray) js.get("ResponsibleParty");
		JSONObject jsonObjectClientContact = (JSONObject) jsonarrayclientcontact.get(0);
		jsonObjectClientContact.put("PatientResponsiblePartyLastName", CommonMethods.generateRandomStringOfFixLength(9));
		jsonObjectClientContact.put("PatientResponsiblePartyFirstName", CommonMethods.generateRandomStringOfFixLength(9));

		
		JSONArray jsonarrayPayerInformation = (JSONArray) js.get("IndividualPayerInformation");
		JSONObject jsonObjectPayerInformation = (JSONObject) jsonarrayPayerInformation.get(0);
		jsonObjectPayerInformation.put("ProcedureCode" ,"S5125");

		return j;
	}

	@SuppressWarnings({ "unchecked"})
	public JSONArray ClientParam_v2_SEVV9533_ProcedureCode_T1000() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, ClassNotFoundException {


		JSONArray j= CommonMethods.LoadJSON_Ohio("patientIntake_v2");
		Map<String,String> DbMap=new HashMap<String, String>();

		DbMap=dataBaseVerifier.executeQuery(String.format(Constant_SQL.stxAccount,CommonMethods.propertyfileReader(globalVariables.ohio_accid)));

		String BusinessEntityMedicaidIdentifier= DbMap.get("PROVIDER_ID");
		String BusinessEntityID= DbMap.get("ACCOUNT");

		JSONObject js = (JSONObject) j.get(0);

		js.put("BusinessEntityID", BusinessEntityID);
		js.put("BusinessEntityMedicaidIdentifier", BusinessEntityMedicaidIdentifier);
		js.put("PatientOtherID", CommonMethods.generateRandomNumberOfFixLength(10));
		js.put("SequenceID", CommonMethods.generateRandomNumberOfFixLength(9));
		js.put("PatientMedicaidID", CommonMethods.generateRandomNumberOfFixLength(12)); 
		js.put("PatientLastName", CommonMethods.generateRandomStringOfFixLength(10));
		js.put("PatientFirstName",  CommonMethods.generateRandomStringOfFixLength(10));

		JSONArray jsAdd = (JSONArray) js.get("Address");
		JSONObject jsObj = (JSONObject) jsAdd.get(0);
		jsObj.put("PatientAddressLine1", CommonMethods.generateRandomStringOfFixLength(9));
		jsObj.put("PatientZip", CommonMethods.generateRandomNumberOfFixLength(9));

		JSONObject jsObj1 = (JSONObject) jsAdd.get(1);
		jsObj1.put("PatientAddressLine1", CommonMethods.generateRandomStringOfFixLength(9));
		jsObj1.put("PatientZip", CommonMethods.generateRandomNumberOfFixLength(9));


		JSONArray jsonarrayclientcontact = (JSONArray) js.get("ResponsibleParty");
		JSONObject jsonObjectClientContact = (JSONObject) jsonarrayclientcontact.get(0);
		jsonObjectClientContact.put("PatientResponsiblePartyLastName", CommonMethods.generateRandomStringOfFixLength(9));
		jsonObjectClientContact.put("PatientResponsiblePartyFirstName", CommonMethods.generateRandomStringOfFixLength(9));

		
		JSONArray jsonarrayPayerInformation = (JSONArray) js.get("IndividualPayerInformation");
		JSONObject jsonObjectPayerInformation = (JSONObject) jsonarrayPayerInformation.get(0);
		jsonObjectPayerInformation.put("ProcedureCode" ,"T1000");

		return j;
	}

	@SuppressWarnings({ "unchecked"})
	public JSONArray ClientParam_v2_SEVV9533_ProcedureCode_T1001() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, ClassNotFoundException {


		JSONArray j= CommonMethods.LoadJSON_Ohio("patientIntake_v2");
		Map<String,String> DbMap=new HashMap<String, String>();

		DbMap=dataBaseVerifier.executeQuery(String.format(Constant_SQL.stxAccount,CommonMethods.propertyfileReader(globalVariables.ohio_accid)));

		String BusinessEntityMedicaidIdentifier= DbMap.get("PROVIDER_ID");
		String BusinessEntityID= DbMap.get("ACCOUNT");

		JSONObject js = (JSONObject) j.get(0);

		js.put("BusinessEntityID", BusinessEntityID);
		js.put("BusinessEntityMedicaidIdentifier", BusinessEntityMedicaidIdentifier);
		js.put("PatientOtherID", CommonMethods.generateRandomNumberOfFixLength(10));
		js.put("SequenceID", CommonMethods.generateRandomNumberOfFixLength(9));
		js.put("PatientMedicaidID", CommonMethods.generateRandomNumberOfFixLength(12)); 
		js.put("PatientLastName", CommonMethods.generateRandomStringOfFixLength(10));
		js.put("PatientFirstName",  CommonMethods.generateRandomStringOfFixLength(10));

		JSONArray jsAdd = (JSONArray) js.get("Address");
		JSONObject jsObj = (JSONObject) jsAdd.get(0);
		jsObj.put("PatientAddressLine1", CommonMethods.generateRandomStringOfFixLength(9));
		jsObj.put("PatientZip", CommonMethods.generateRandomNumberOfFixLength(9));

		JSONObject jsObj1 = (JSONObject) jsAdd.get(1);
		jsObj1.put("PatientAddressLine1", CommonMethods.generateRandomStringOfFixLength(9));
		jsObj1.put("PatientZip", CommonMethods.generateRandomNumberOfFixLength(9));


		JSONArray jsonarrayclientcontact = (JSONArray) js.get("ResponsibleParty");
		JSONObject jsonObjectClientContact = (JSONObject) jsonarrayclientcontact.get(0);
		jsonObjectClientContact.put("PatientResponsiblePartyLastName", CommonMethods.generateRandomStringOfFixLength(9));
		jsonObjectClientContact.put("PatientResponsiblePartyFirstName", CommonMethods.generateRandomStringOfFixLength(9));

		
		JSONArray jsonarrayPayerInformation = (JSONArray) js.get("IndividualPayerInformation");
		JSONObject jsonObjectPayerInformation = (JSONObject) jsonarrayPayerInformation.get(0);
		jsonObjectPayerInformation.put("ProcedureCode" ,"T1001");

		return j;

	}

	@SuppressWarnings({ "unchecked"})
	public JSONArray ClientParam_v2_SEVV9533_ProcedureCode_T1002() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, ClassNotFoundException {


		JSONArray j= CommonMethods.LoadJSON_Ohio("patientIntake_v2");
		Map<String,String> DbMap=new HashMap<String, String>();

		DbMap=dataBaseVerifier.executeQuery(String.format(Constant_SQL.stxAccount,CommonMethods.propertyfileReader(globalVariables.ohio_accid)));

		String BusinessEntityMedicaidIdentifier= DbMap.get("PROVIDER_ID");
		String BusinessEntityID= DbMap.get("ACCOUNT");

		JSONObject js = (JSONObject) j.get(0);

		js.put("BusinessEntityID", BusinessEntityID);
		js.put("BusinessEntityMedicaidIdentifier", BusinessEntityMedicaidIdentifier);
		js.put("PatientOtherID", CommonMethods.generateRandomNumberOfFixLength(10));
		js.put("SequenceID", CommonMethods.generateRandomNumberOfFixLength(9));
		js.put("PatientMedicaidID", CommonMethods.generateRandomNumberOfFixLength(12)); 
		js.put("PatientLastName", CommonMethods.generateRandomStringOfFixLength(10));
		js.put("PatientFirstName",  CommonMethods.generateRandomStringOfFixLength(10));

		JSONArray jsAdd = (JSONArray) js.get("Address");
		JSONObject jsObj = (JSONObject) jsAdd.get(0);
		jsObj.put("PatientAddressLine1", CommonMethods.generateRandomStringOfFixLength(9));
		jsObj.put("PatientZip", CommonMethods.generateRandomNumberOfFixLength(9));

		JSONObject jsObj1 = (JSONObject) jsAdd.get(1);
		jsObj1.put("PatientAddressLine1", CommonMethods.generateRandomStringOfFixLength(9));
		jsObj1.put("PatientZip", CommonMethods.generateRandomNumberOfFixLength(9));


		JSONArray jsonarrayclientcontact = (JSONArray) js.get("ResponsibleParty");
		JSONObject jsonObjectClientContact = (JSONObject) jsonarrayclientcontact.get(0);
		jsonObjectClientContact.put("PatientResponsiblePartyLastName", CommonMethods.generateRandomStringOfFixLength(9));
		jsonObjectClientContact.put("PatientResponsiblePartyFirstName", CommonMethods.generateRandomStringOfFixLength(9));

		
		JSONArray jsonarrayPayerInformation = (JSONArray) js.get("IndividualPayerInformation");
		JSONObject jsonObjectPayerInformation = (JSONObject) jsonarrayPayerInformation.get(0);
		jsonObjectPayerInformation.put("ProcedureCode" ,"T1002");

		return j;

	}

	@SuppressWarnings({ "unchecked"})
	public JSONArray ClientParam_v2_SEVV9533_ProcedureCode_T1003() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, ClassNotFoundException {


		JSONArray j= CommonMethods.LoadJSON_Ohio("patientIntake_v2");
		Map<String,String> DbMap=new HashMap<String, String>();

		DbMap=dataBaseVerifier.executeQuery(String.format(Constant_SQL.stxAccount,CommonMethods.propertyfileReader(globalVariables.ohio_accid)));

		String BusinessEntityMedicaidIdentifier= DbMap.get("PROVIDER_ID");
		String BusinessEntityID= DbMap.get("ACCOUNT");

		JSONObject js = (JSONObject) j.get(0);

		js.put("BusinessEntityID", BusinessEntityID);
		js.put("BusinessEntityMedicaidIdentifier", BusinessEntityMedicaidIdentifier);
		js.put("PatientOtherID", CommonMethods.generateRandomNumberOfFixLength(10));
		js.put("SequenceID", CommonMethods.generateRandomNumberOfFixLength(9));
		js.put("PatientMedicaidID", CommonMethods.generateRandomNumberOfFixLength(12)); 
		js.put("PatientLastName", CommonMethods.generateRandomStringOfFixLength(10));
		js.put("PatientFirstName",  CommonMethods.generateRandomStringOfFixLength(10));

		JSONArray jsAdd = (JSONArray) js.get("Address");
		JSONObject jsObj = (JSONObject) jsAdd.get(0);
		jsObj.put("PatientAddressLine1", CommonMethods.generateRandomStringOfFixLength(9));
		jsObj.put("PatientZip", CommonMethods.generateRandomNumberOfFixLength(9));

		JSONObject jsObj1 = (JSONObject) jsAdd.get(1);
		jsObj1.put("PatientAddressLine1", CommonMethods.generateRandomStringOfFixLength(9));
		jsObj1.put("PatientZip", CommonMethods.generateRandomNumberOfFixLength(9));


		JSONArray jsonarrayclientcontact = (JSONArray) js.get("ResponsibleParty");
		JSONObject jsonObjectClientContact = (JSONObject) jsonarrayclientcontact.get(0);
		jsonObjectClientContact.put("PatientResponsiblePartyLastName", CommonMethods.generateRandomStringOfFixLength(9));
		jsonObjectClientContact.put("PatientResponsiblePartyFirstName", CommonMethods.generateRandomStringOfFixLength(9));

		
		JSONArray jsonarrayPayerInformation = (JSONArray) js.get("IndividualPayerInformation");
		JSONObject jsonObjectPayerInformation = (JSONObject) jsonarrayPayerInformation.get(0);
		jsonObjectPayerInformation.put("ProcedureCode" ,"T1003");

		return j;

	}

	@SuppressWarnings({ "unchecked"})
	public JSONArray ClientParam_v2_SEVV9533_ProcedureCode_T1019() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, ClassNotFoundException {


		JSONArray j= CommonMethods.LoadJSON_Ohio("patientIntake_v2");
		Map<String,String> DbMap=new HashMap<String, String>();

		DbMap=dataBaseVerifier.executeQuery(String.format(Constant_SQL.stxAccount,CommonMethods.propertyfileReader(globalVariables.ohio_accid)));

		String BusinessEntityMedicaidIdentifier= DbMap.get("PROVIDER_ID");
		String BusinessEntityID= DbMap.get("ACCOUNT");

		JSONObject js = (JSONObject) j.get(0);

		js.put("BusinessEntityID", BusinessEntityID);
		js.put("BusinessEntityMedicaidIdentifier", BusinessEntityMedicaidIdentifier);
		js.put("PatientOtherID", CommonMethods.generateRandomNumberOfFixLength(10));
		js.put("SequenceID", CommonMethods.generateRandomNumberOfFixLength(9));
		js.put("PatientMedicaidID", CommonMethods.generateRandomNumberOfFixLength(12)); 
		js.put("PatientLastName", CommonMethods.generateRandomStringOfFixLength(10));
		js.put("PatientFirstName",  CommonMethods.generateRandomStringOfFixLength(10));

		JSONArray jsAdd = (JSONArray) js.get("Address");
		JSONObject jsObj = (JSONObject) jsAdd.get(0);
		jsObj.put("PatientAddressLine1", CommonMethods.generateRandomStringOfFixLength(9));
		jsObj.put("PatientZip", CommonMethods.generateRandomNumberOfFixLength(9));

		JSONObject jsObj1 = (JSONObject) jsAdd.get(1);
		jsObj1.put("PatientAddressLine1", CommonMethods.generateRandomStringOfFixLength(9));
		jsObj1.put("PatientZip", CommonMethods.generateRandomNumberOfFixLength(9));


		JSONArray jsonarrayclientcontact = (JSONArray) js.get("ResponsibleParty");
		JSONObject jsonObjectClientContact = (JSONObject) jsonarrayclientcontact.get(0);
		jsonObjectClientContact.put("PatientResponsiblePartyLastName", CommonMethods.generateRandomStringOfFixLength(9));
		jsonObjectClientContact.put("PatientResponsiblePartyFirstName", CommonMethods.generateRandomStringOfFixLength(9));

		
		JSONArray jsonarrayPayerInformation = (JSONArray) js.get("IndividualPayerInformation");
		JSONObject jsonObjectPayerInformation = (JSONObject) jsonarrayPayerInformation.get(0);
		jsonObjectPayerInformation.put("ProcedureCode" ,"T1019");

		return j;
	}

}
