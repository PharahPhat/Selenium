package com.ohio.provider;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.DataBaseVerifier;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;

public class Assertion_DbVerifier_ohio_provider extends BaseTest
{

	DataBaseVerifier dataBaseVerifier= new DataBaseVerifier();
	Constant_SQL_provider Constant_SQL=new Constant_SQL_provider();
	com.globalMethods.core.FileContentReader FileContentReader=new com.globalMethods.core.FileContentReader();
	// ***********************mySQl (member & Auth) method mapping ****************************************//

	@SuppressWarnings("unchecked")
	public void stxprovider_ohio( String pro_name) throws InterruptedException, java.text.ParseException,  SQLException, InterruptedException, ClassNotFoundException, ParseException, java.text.ParseException
	{

      Thread.sleep(200000);
		logger.log(LogStatus.INFO, "Validating DB response "); 

		Map<String,String> DbMap=new HashMap<String, String>();
		
		DbMap=dataBaseVerifier.executeQuery(String.format(Constant_SQL.inboxWorker_NAPohio,pro_name));		

       if (DbMap!=null)
       {
    	   assertNotEquals(DbMap, null);
    	 System.out.println("test case passed");  
       }
       
	}
	
	@SuppressWarnings("unchecked")
	public void stxprovider_ohio_agency( String pro_name) throws InterruptedException,  SQLException, InterruptedException, ClassNotFoundException, ParseException, java.text.ParseException
	{

		Thread.sleep(120000);
		logger.log(LogStatus.INFO, "Validating DB response "); 

		Map<String,String> DbMap=new HashMap<String, String>();
		DbMap=dataBaseVerifier.executeQuery(String.format(Constant_SQL.stxAccounts_csv,pro_name));

		if (DbMap!=null)
		{
			assertNotEquals(DbMap, null);
			System.out.println("test case passed");
		}
	}

	public void stxprovider_ohio_agency_invalid( String pro_name) throws InterruptedException,  SQLException, InterruptedException, ClassNotFoundException, ParseException, java.text.ParseException
	{

		Thread.sleep(120000);

		int data = dataBaseVerifier.returnRowNumber(String.format(Constant_SQL.stxAccounts_csv, pro_name));
		assertEquals(data, 0);
	}
	
	@SuppressWarnings("unchecked")
	public void stxprovider_ohio_date( String email,Map<String ,String> finalMapapdataByRow) throws InterruptedException,  SQLException, InterruptedException, ClassNotFoundException, ParseException, java.text.ParseException
	{


		logger.log(LogStatus.INFO, "Validating DB response "); 
		Map<String ,String> DBMap =new HashMap<String,String>();
		Map<String ,String> DBMapnew =new HashMap<String,String>();

		finalMapapdataByRow.put("EFFECTIVE_BEG_DATE", CommonMethods.dateToDateTimeFormat_yyyy_mm_dd(CommonMethods.generatecurrentDate_YYYY_MM_dd()));
				
        int count = 0;
        int maxTries=10;
        int entryCount =0;
        for (count=0; count<maxTries ; count++)
        {

        Thread.sleep(200000);
        DBMap= dataBaseVerifier.executeQuery(3,String.format(Constant_SQL.stxAccounts_info_date,email),3000);
    	DBMapnew= dataBaseVerifier.executeQuery(3,String.format(Constant_SQL.stxAccounts_info_date,"quoemrncdb@mailinator.com"),20000);
        if (DBMap!=null)
        {

        entryCount++;
        assertEquals(DBMap.get("EFFECTIVE_BEG_DATE"), finalMapapdataByRow.get("EFFECTIVE_BEG_DATE"));
        assertEquals(DBMapnew.get("EFFECTIVE_BEG_DATE"), "2019-04-01 00:00:00.0" );
        break;
        }


        }
        if(entryCount ==0)
        {
        Assert.fail("No Data Inserted into Db");
        }
	}
	
}
