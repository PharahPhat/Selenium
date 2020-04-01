package com.globalMethods.core;

import Utills_ExtentReport_Log4j.BaseTest;
import com.relevantcodes.extentreports.LogStatus;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ErrorCode_Verification extends BaseTest
{
	private DataBaseVerifier dataBaseVerifier= new DataBaseVerifier();

	// ***********************mySQl (member & Auth) method mapping ****************************************//


	public void DataInsertionExceptErrorCode_Zero(String StxTableSQLStatement, String DbColumnName1, String DbColumnName2) throws InterruptedException, java.text.ParseException,  SQLException, InterruptedException, ClassNotFoundException, ParseException, java.text.ParseException
	{

		logger.log(LogStatus.INFO, "Validating DB response "); 

		int count=dataBaseVerifier.returnRowNumber(String.format(StxTableSQLStatement, DbColumnName1, DbColumnName2));		

		Thread.sleep(2000);

		CommonMethods.AssertEqualsAndPrintValuesString("0", String.valueOf(count), "Verified that data is not inserted in DB");

	}

	@SuppressWarnings("unchecked")
	public void StxVerification(String StxTableSQLStatement, JSONObject jsonObject_Map, String DbColumnName1, String DbColumnName2) throws InterruptedException, java.text.ParseException,  SQLException, InterruptedException, ClassNotFoundException, ParseException, java.text.ParseException
	{

		logger.log(LogStatus.INFO, "Validating DB response "); 


		Map<String,String> DbMap;

		DbMap=dataBaseVerifier.executeQuery(String.format(StxTableSQLStatement, DbColumnName1, DbColumnName2));		
		
		dataBaseVerifier.compareMap(DbMap,jsonObject_Map);

	}

	@SuppressWarnings("unchecked")
	public void StxVerificationohio(String StxTableSQLStatement, JSONObject jsonObject_Map, String DbColumnName1, String DbColumnName2) throws InterruptedException, java.text.ParseException,  SQLException, InterruptedException, ClassNotFoundException, ParseException, java.text.ParseException
	{

		logger.log(LogStatus.INFO, "Validating DB response "); 


		Map<String,String> DbMap=new HashMap<String, String>();

		DbMap=dataBaseVerifier.executeQuery(String.format(StxTableSQLStatement, DbColumnName1, DbColumnName2));		
		
		jsonObject_Map.put("CLIENTKEY", DbMap.get("CLIENTKEY").toString());	
		dataBaseVerifier.compareMap(DbMap,jsonObject_Map);

	}

	@SuppressWarnings("unchecked")
	public void errorCodeVerificationOtherThanZero(JSONObject jsonObject_Map, Map<String,String> DbMap, Map<String,String> DbValue) throws InterruptedException, java.text.ParseException, ClassNotFoundException, SQLException, ParseException, java.text.ParseException
	{

		if( String.valueOf(DbMap.get("ERROR_CODE")).equals("null"))
		{
			jsonObject_Map.put("ERROR_CODE", null);	
			dataBaseVerifier.compareMap(DbMap,jsonObject_Map);
			StxVerification(DbValue.get("stxSqlQuery"), jsonObject_Map, DbValue.get("DbColumnName1"), DbValue.get("DbColumnName2"));


		}else if(DbMap.get("ERROR_CODE").equals("0"))
		{
			jsonObject_Map.put("ERROR_CODE", "0");		
			dataBaseVerifier.compareMap(DbMap,jsonObject_Map);
			StxVerification(DbValue.get("stxSqlQuery"), jsonObject_Map, DbValue.get("DbColumnName1"), DbValue.get("DbColumnName2"));

		} else 
		{
			DataInsertionExceptErrorCode_Zero(DbValue.get("stxSqlQuery"), DbValue.get("DbColumnName1"), DbValue.get("DbColumnName2") );
			Assert.fail("Error Code Return from Db is " + DbMap.get("ERROR_CODE") + " which is not equal to 0.");

		}

	}
	
	@SuppressWarnings("unchecked")
	public void errorCodeVerificationOtherThanZeroOhio(JSONObject jsonObject_Map, Map<String,String> DbMap, Map<String,String> DbValue) throws InterruptedException, java.text.ParseException, ClassNotFoundException, SQLException, ParseException, java.text.ParseException
	{

		if( String.valueOf(DbMap.get("ERROR_CODE")).equals("null"))
		{
			jsonObject_Map.put("ERROR_CODE", null);	
			dataBaseVerifier.compareMap(DbMap,jsonObject_Map);

			StxVerificationohio(DbValue.get("stxSqlQuery"), jsonObject_Map, DbValue.get("DbColumnName1"), DbValue.get("DbColumnName2"));


		}else if(DbMap.get("ERROR_CODE").equals("0"))
		{
			jsonObject_Map.put("ERROR_CODE", "0");
			DbMap.remove("CLIENTID");//ohio does not need this field in payload
			dataBaseVerifier.compareMap(DbMap,jsonObject_Map);
	
			StxVerificationohio(DbValue.get("stxSqlQuery"), jsonObject_Map, DbValue.get("DbColumnName1"), DbValue.get("DbColumnName2"));

		} else 
		{
			
			DataInsertionExceptErrorCode_Zero(DbValue.get("stxSqlQuery"), DbValue.get("DbColumnName1"), DbValue.get("DbColumnName2") );
			Assert.fail("Error Code Return from Db is " + DbMap.get("ERROR_CODE") + " which is not equal to 0.");

		}

	}

	@SuppressWarnings("unchecked")
	public void errorCodeVerificationOtherThanZeroXrefSpecific(JSONObject jsonObject_Map, Map<String,String> DbMap, Map<String,String> DbValue) throws InterruptedException, java.text.ParseException, ClassNotFoundException, SQLException, ParseException, java.text.ParseException
	{

		if( String.valueOf(DbMap.get("ERROR_CODE")).equals("null"))
		{
			jsonObject_Map.put("ERROR_CODE", null);	
			dataBaseVerifier.compareMap(DbMap,jsonObject_Map);
			StxVerificationXrefSpecific(DbValue.get("stxSqlQuery"), jsonObject_Map, DbValue.get("DbColumnName1"), DbValue.get("DbColumnName2"));


		}else if(DbMap.get("ERROR_CODE").equals("0"))
		{
			jsonObject_Map.put("ERROR_CODE", "0");		
			dataBaseVerifier.compareMap(DbMap,jsonObject_Map);
			StxVerificationXrefSpecific(DbValue.get("stxSqlQuery"), jsonObject_Map, DbValue.get("DbColumnName1"), DbValue.get("DbColumnName2"));

		} else 
		{
			DataInsertionExceptErrorCode_Zero(DbValue.get("stxSqlQuery"), DbValue.get("DbColumnName1"), DbValue.get("DbColumnName2") );
			Assert.fail("Error Code Return from Db is " + DbMap.get("ERROR_CODE") + " which is not equal to 0.");

		}

	}

	@SuppressWarnings("unchecked")
	public void errorCodeVerificationOtherThanZeroXrefDuplicate(JSONObject jsonObject_Map, Map<String,String> DbMap, Map<String,String> DbValue) throws InterruptedException, java.text.ParseException, ClassNotFoundException, SQLException, ParseException, java.text.ParseException
	{

		if( String.valueOf(DbMap.get("ERROR_CODE")).equals("null"))
		{
			jsonObject_Map.put("ERROR_CODE", null);	
			dataBaseVerifier.compareMap(DbMap,jsonObject_Map);
			StxVerificationXrefSpecific(DbValue.get("stxSqlQuery"), jsonObject_Map, DbValue.get("DbColumnName1"), DbValue.get("DbColumnName2"));


		}else if(DbMap.get("ERROR_CODE").equals("0"))
		{
			jsonObject_Map.put("ERROR_CODE", "0");		
			dataBaseVerifier.compareMap(DbMap,jsonObject_Map);
			StxVerificationXrefSpecific(DbValue.get("stxSqlQuery"), jsonObject_Map, DbValue.get("DbColumnName1"), DbValue.get("DbColumnName2"));

		} else 
		{
			DataInsertionExceptErrorCode_Zero(DbValue.get("stxSqlQuery"), DbValue.get("DbColumnName1"), DbValue.get("DbColumnName2") );
			Assert.assertEquals("-1115", DbMap.get("ERROR_CODE") );

		}

	}

	@SuppressWarnings("unchecked")
	public void StxVerificationXrefSpecific(String StxTableSQLStatement, JSONObject jsonObject_Map, String DbColumnName1, String DbColumnName2) throws InterruptedException, java.text.ParseException,  SQLException, InterruptedException, ClassNotFoundException, ParseException, java.text.ParseException
	{

		logger.log(LogStatus.INFO, "Validating DB response "); 


		Map<String,String> DbMap=new HashMap<String, String>();

		DbMap=dataBaseVerifier.executeQuery(String.format(StxTableSQLStatement, DbColumnName1, DbColumnName2));		
		if(String.valueOf(jsonObject_Map.get("XRefEndDate")).equalsIgnoreCase("null"))
		{
			jsonObject_Map.put("XRefEndDate","2999-12-31 00:00:00.0");
		}
		ClientStatusVerification(jsonObject_Map,DbMap);

		dataBaseVerifier.compareMap(DbMap,jsonObject_Map);


		//	DbMap=dataBaseVerifier.executeQuery(String.format(Constant_SQL.stxClientSql_OpenEvv,jsonObject_Map.get("ClientID").toString(),jsonObject_Map.get("ClientLastName").toString()));		

	}




	@SuppressWarnings("unchecked")
	public void ClientStatusVerification(JSONObject jsonObject_Map, Map<String,String> DbMap)
	{
		if(jsonObject_Map.get("ClientStatus").toString().equals("01"))
			jsonObject_Map.put("ClientStatus", "0");
		else if (jsonObject_Map.get("ClientStatus").toString().equals("04"))
			jsonObject_Map.put("ClientStatus", "1");
		jsonObject_Map.put("XRefEndDate",DbMap.get("XREFENDDATE"));
	}

	@SuppressWarnings("unchecked")
	public void ClientStatusVerification(JSONObject jsonObject_Map)
	{
		if(jsonObject_Map.get("ClientStatus").toString().equals("01"))
			jsonObject_Map.put("ClientStatus", "0");
		else if (jsonObject_Map.get("ClientStatus").toString().equals("04"))
			jsonObject_Map.put("ClientStatus", "1");
	}

	@SuppressWarnings("unchecked")
	public void clientIDQualifier_NameMappingJsonToDB(JSONObject jsonObject_Map)
	{
		if(jsonObject_Map.get("ClientIDQualifier").toString().equals("ClientOtherID"))
			jsonObject_Map.put("ClientIDQualifier", "CLIENT_ID_CUSTOM2");
		else if (jsonObject_Map.get("ClientIDQualifier").toString().equals("ClientSSN")) 
			jsonObject_Map.put("ClientIDQualifier", "CLIENT_SSN");
		else if (jsonObject_Map.get("ClientIDQualifier").toString().equals("ClientID")) 
			jsonObject_Map.put("ClientIDQualifier", "LOC");
		else if (jsonObject_Map.get("ClientIDQualifier").toString().equals("ClientCustomID")) 
			jsonObject_Map.put("ClientIDQualifier", "CLIENT_ID_CUSTOM1");
	}

	@SuppressWarnings("unchecked")
	public void EmployeeQualifier_NameMappingJsonToDB(JSONObject jsonObject_Map)
	{
		if(jsonObject_Map.get("EmployeeQualifier").toString().equals("EmployeeRegID"))
			jsonObject_Map.put("EmployeeQualifier", "STX_ID");
		else if (jsonObject_Map.get("EmployeeQualifier").toString().equals("EmployeeSSN")) 
			jsonObject_Map.put("EmployeeQualifier", "WORKER_SSN");
		else if (jsonObject_Map.get("EmployeeQualifier").toString().equals("EmployeePIN")) 
			jsonObject_Map.put("EmployeeQualifier", "STX_ID");
		else if (jsonObject_Map.get("EmployeeQualifier").toString().equals("EmployeeCustomID")) 
			jsonObject_Map.put("EmployeeQualifier", "WORKER_ID_CUSTOM1");
	}

	@SuppressWarnings("unchecked")
	public void XRefStartDate_EndDateDateFormatChange(JSONObject jsonObject_Map) throws InterruptedException, java.text.ParseException, ParseException, java.text.ParseException
	{
		jsonObject_Map.put("XRefStartDate", CommonMethods.dateToDateTimeFormat(String.valueOf(jsonObject_Map.get("XRefStartDate"))));

		jsonObject_Map.put("XRefEndDate", CommonMethods.dateToDateTimeFormat(String.valueOf(jsonObject_Map.get("XRefEndDate"))));

		if(String.valueOf(jsonObject_Map.get("XRefStartDate")).equalsIgnoreCase("null")) {

			jsonObject_Map.put("XRefStartDate",CommonMethods.dateToDateTimeFormat(CommonMethods.generateTodayDate_MMddyyyy()));
		}

	}

	public JSONObject employeeQualifierValue(JSONObject jsonobject )
	{
		if(jsonobject.get("EmployeeQualifier").toString().equals("EmployeeRegID"))
		{
			jsonobject.put("EmployeeSSN", jsonobject.get("EmployeeSSN").toString());
		}
		else if (jsonobject.get("EmployeeQualifier").toString().equals("EmployeeSSN")) 
		{
			jsonobject.put("EmployeeSSN",jsonobject.get("EmployeeIdentifier").toString());
		}

		else if (jsonobject.get("EmployeeQualifier").toString().equals("EmployeeCustomID")) 
		{
			jsonobject.put("EmployeeOtherID", jsonobject.get("EmployeeIdentifier").toString());
		}
		return jsonobject; 
	}
	public JSONObject employeeQualifier_preadd(JSONObject jsonobject )
	{ 
		if (jsonobject.get("EmployeeIdentifier").toString().length() < 9)
		{	
			jsonobject.put("EmployeeIdentifier", String.format("%09d", Integer.parseInt(jsonobject.get("EmployeeIdentifier").toString())));

		} else if (jsonobject.get("EmployeeIdentifier").toString().length() > 9)
		{
			jsonobject.put("EmployeeIdentifier", jsonobject.get("EmployeeIdentifier").toString().replaceFirst(".$",""));

		}
		return jsonobject;
	}
}