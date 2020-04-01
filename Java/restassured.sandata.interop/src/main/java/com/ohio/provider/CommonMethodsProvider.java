package com.ohio.provider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeMethod;

import com.globalMethods.core.CommonMethods;


public class CommonMethodsProvider {

	//public final static String ENVIORNMENT = propertyfileReader("Enviornment");
	DataGeneratorProvider dg = new DataGeneratorProvider();

	InputStream input = null;

	// To read data from properties file
	public static String propertyfileReader(String propertyname) {
		File file = new File(System.getProperty("user.dir") + "/config/config.properties");

		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();

		// load properties file
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop.getProperty(propertyname);
	}

	public static Connection connection;
	public static Connection CreateConnection() throws InterruptedException, java.text.ParseException,  ClassNotFoundException, SQLException{


		if (connection == null) {
			System.out.println("Connection");
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				connection = DriverManager.getConnection(CommonMethodsProvider.propertyfileReader("DbConnectionurl"), CommonMethodsProvider.propertyfileReader("db_username"), CommonMethodsProvider.propertyfileReader("db_password"));
			} catch (ClassNotFoundException | SQLException e) {
				// Java 7+
				e.printStackTrace();
			}
		}
		return connection;
	}
	public static String jsonasString(String fileName) {
		JSONParser parser = new JSONParser();

		JSONArray a = null;
		try {
			a = (JSONArray) parser.parse(new FileReader(fileName + ".json"));
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		return a.toJSONString();
	}

	public String readPropertyFile(String key) {
		Properties prop = new Properties();
		try {
			input = new FileInputStream("config.properties");
			prop.load(input);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return (prop.getProperty(key));
	}
	public static String dateToDateTimeFormat_yyyy_mm_dd(String dateToFormat) throws InterruptedException,  ParseException, java.text.ParseException
	{

		Date dateConverted=new SimpleDateFormat("yyyy-MM-dd").parse(dateToFormat);

		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String dt =simpleDateFormat.format(dateConverted);
		return (dt+".0");
	}

	public void holdOn(int milis) {
		try {
			Thread.sleep(milis);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	public static String getSaltString(int max) {
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < max) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;
	}

	/* @Author	: Jitendra Kumar
	 * @Date	: 6-Sept-2017
	 * Takes the number range[Min and max value]
	 * Max should be greater than min
	 * */
	public static long getRandomLong(long min, long max)
	{
	    try
	    {
	        Random  random  = new Random();
	        long    result  = min + (long) (random.nextDouble() * (max - min));
	        return  result;
	    }
	    catch (Throwable t) {t.printStackTrace();}
	    return 0L;
	}
	public static String generateRandomAlphaNumeric(int count) {
		String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
	}
	public static int getRandomInt(int min, int max) {
		try {
			int result = min + (int)(Math.random() * max); 
			return result;
		} catch (Throwable t) {
			t.printStackTrace();
		}
		return 0;
	}
	public static void writePropertiesFile(String key, String value,String key1, String value1) {
		Properties prop = new Properties();
		OutputStream output = null;

		try {

			output = new FileOutputStream("claimFiles.properties");
			prop.setProperty(key, value);
			prop.setProperty(key1, value1);
			// save properties to project root folder
			prop.store(output, null);

		} catch (IOException io) {
			io.printStackTrace();
		}
	}

	public static void writeProviderProperties4File(String key, String value,String key1, String value1,
													String key2,String value2, String key3, String value3)
	{
		Properties prop = new Properties();
		OutputStream output = null;

		try {

			prop.setProperty(key, value);
			prop.setProperty(key1, value1);
			prop.setProperty(key2, value2);
			prop.setProperty(key3, value3);
			// save properties to project root folder
			output = new FileOutputStream("claimFiles.properties");
			prop.store(output, "jmeter file");

		} catch (IOException io) {
			io.printStackTrace();
		}

	}

	public static void writeProviderPropertiesFile(String key, String value,String key1, String value1,String key2,String value2)
	{
		Properties prop = new Properties();
		OutputStream output = null;

		try {


			prop.setProperty(key, value);
			prop.setProperty(key1, value1);
			prop.setProperty(key2, value2);
			// save properties to project root folder
			output = new FileOutputStream("claimFiles.properties");
			prop.store(output, "jmeter file");

		} catch (IOException io) {
			io.printStackTrace();
		}

	}

	public static Date addDays(Date date, int days)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, days); //minus number would decrement the days
		return cal.getTime();
	}

	public static String providerTimeStamp(int days){

		Date date =Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Date myDate = addDays(date, days);
		String strDate = dateFormat.format(myDate);

		String newdateunique= (strDate+'_'+CommonMethods.generateRandomNumberOfFixLength(4));
		return newdateunique;
	}

	public static String providerTimeStamp(){

		Date date =Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		String strDate = dateFormat.format(date);

		String newdateunique= (strDate+'_'+CommonMethods.generateRandomNumberOfFixLength(4));
		return newdateunique;
	}

	public synchronized Map<String,String> createProviderFilesName(int days){

		String nameValue=providerTimeStamp(days);
		Map<String,String> fileName =new HashMap<String,String>();

		fileName.put("prov_PMF_Full_Extract","PROV_PMF_FULL_EXTRACT_"+nameValue+ ".txt");
		fileName.put("PROV_PMF_CONTRACT_EXTRACT","PROV_PMF_CONTRACT_EXTRACT_"+nameValue+ ".txt");
		fileName.put("PROV_PMF_SPECIALTY_EXTRACT","PROV_PMF_SPECIALTY_EXTRACT_"+nameValue+ ".txt");
		return fileName;

	}

	public synchronized Map<String,String> createProvider4FilesName(int days){

		String nameValue=providerTimeStamp(days);
		Map<String,String> fileName =new HashMap<String,String>();

		fileName.put("prov_PMF_Full_Extract","PROV_PMF_FULL_EXTRACT_"+nameValue+ ".txt");
		fileName.put("PROV_PMF_CONTRACT_EXTRACT","PROV_PMF_CONTRACT_EXTRACT_"+nameValue+ ".txt");
		fileName.put("PROV_PMF_SPECIALTY_EXTRACT","PROV_PMF_SPECIALTY_EXTRACT_"+nameValue+ ".txt");
		fileName.put("PROV_PMF_SUPPLEMENTAL","PROV_PMF_SUPPLEMENTAL_"+nameValue+ ".txt");

		return fileName;

	}

	public synchronized Map<String,String> createProviderFilesName(){

		 String nameValue=providerTimeStamp();
			Map<String,String> fileName =new HashMap<String,String>();

			fileName.put("prov_PMF_Full_Extract","PROV_PMF_FULL_EXTRACT_"+nameValue+ ".txt");
			fileName.put("PROV_PMF_CONTRACT_EXTRACT","PROV_PMF_CONTRACT_EXTRACT_"+nameValue+ ".txt");
			fileName.put("PROV_PMF_SPECIALTY_EXTRACT","PROV_PMF_SPECIALTY_EXTRACT_"+nameValue+ ".txt");
			return fileName;

	}

	public synchronized  Map<String,FileWriter> createProviderFiles(Map<String,String> fileNames) throws IOException, InterruptedException {

		Map<String,FileWriter> fileWriters =new HashMap<String,FileWriter>();
		CommonMethodsProvider.writeProviderPropertiesFile("fullFileName", fileNames.get("prov_PMF_Full_Extract")
				,"contractFileName", fileNames.get("PROV_PMF_CONTRACT_EXTRACT"),
				"SpecialFileName",fileNames.get("PROV_PMF_SPECIALTY_EXTRACT"));

		String tmpFilePath = GlobalVariables_provider.getOhioproviderlocation+fileNames.get("PROV_PMF_CONTRACT_EXTRACT");

		fileWriters.put("PROV_PMF_CONTRACT_EXTRACT_File" ,new FileWriter(GlobalVariables_provider.getOhioproviderlocation+fileNames.get("PROV_PMF_CONTRACT_EXTRACT"),true));
		fileWriters.put("PROV_PMF_SPECIALTY_EXTRACTFile",new FileWriter(GlobalVariables_provider.getOhioproviderlocation+fileNames.get("PROV_PMF_SPECIALTY_EXTRACT"),true));
		fileWriters.put("prov_PMF_Full_Extract_File",new FileWriter(GlobalVariables_provider.getOhioproviderlocation+fileNames.get("prov_PMF_Full_Extract"),true));
		return fileWriters;
	}

	public synchronized  Map<String,FileWriter> createProvider4Files(Map<String,String> fileNames) throws IOException, InterruptedException {

		Map<String,FileWriter> fileWriters =new HashMap<String,FileWriter>();
			CommonMethodsProvider.writeProviderProperties4File("fullFileName", fileNames.get("prov_PMF_Full_Extract")
					,"contractFileName", fileNames.get("PROV_PMF_CONTRACT_EXTRACT"),
					"SpecialFileName",fileNames.get("PROV_PMF_SPECIALTY_EXTRACT"),
					"supplemental", fileNames.get("PROV_PMF_SUPPLEMENTAL"));

		fileWriters.put("PROV_PMF_CONTRACT_EXTRACT_File" ,new FileWriter(GlobalVariables_provider.getOhioproviderlocation+fileNames.get("PROV_PMF_CONTRACT_EXTRACT"),true));
		fileWriters.put("PROV_PMF_SPECIALTY_EXTRACTFile",new FileWriter(GlobalVariables_provider.getOhioproviderlocation+fileNames.get("PROV_PMF_SPECIALTY_EXTRACT"),true));
		fileWriters.put("prov_PMF_Full_Extract_File",new FileWriter(GlobalVariables_provider.getOhioproviderlocation+fileNames.get("prov_PMF_Full_Extract"),true));
		fileWriters.put("PROV_PMF_SUPPLEMENTAL",new FileWriter(GlobalVariables_provider.getOhioproviderlocation+fileNames.get("PROV_PMF_SUPPLEMENTAL"),true));

		return fileWriters;
	}

	public synchronized void writeAllProviderFiles(Map<String,FileWriter> fileWriters,Map<String,String> UniqueValues) throws IOException{
		writeprovPMFFullExtractFile(fileWriters.get("prov_PMF_Full_Extract_File"),UniqueValues);
		writeProvPMFContractExtractFile(fileWriters.get("PROV_PMF_CONTRACT_EXTRACT_File"),UniqueValues);
		writeProvPMFSpecialityExtractFile(fileWriters.get("PROV_PMF_SPECIALTY_EXTRACTFile"),UniqueValues);
	}

	public synchronized void writeAllProvider4Files(Map<String,FileWriter> fileWriters,Map<String,String> UniqueValues) throws IOException{
		writeprovPMFFullExtractFile(fileWriters.get("prov_PMF_Full_Extract_File"),UniqueValues);
		writeProvPMFContractExtractFile(fileWriters.get("PROV_PMF_CONTRACT_EXTRACT_File"),UniqueValues);
		writeProvPMFSpecialityExtractFile(fileWriters.get("PROV_PMF_SPECIALTY_EXTRACTFile"),UniqueValues);
		writeprovPMFSUPPLEMENTAL(fileWriters.get("PROV_PMF_SUPPLEMENTAL"));
	}

	public synchronized void writeprovPMFSUPPLEMENTAL(FileWriter ProvPMFSupplementalFileName){
		try {
			ProvPMFSupplementalFileName.write("1111111111111111111111111111111");
			ProvPMFSupplementalFileName.write('\n');
			ProvPMFSupplementalFileName.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public synchronized void writeprovPMFFullExtractFile(FileWriter provPMFFullExtractName,Map<String,String> UniqueValues) throws IOException{
		try {


			provPMFFullExtractName.write(GlobalVariables_provider.SAK_PROV
				+dg.space(4)
				+UniqueValues.get("ID_PROVIDER_MCD")
				 +dg.space(3)
				 +UniqueValues.get("Prov_lname")
				 +UniqueValues.get("Prov_fname")
				 +GlobalVariables_provider.CDE_COUNTY
				 +dg.space(8)
				 +GlobalVariables_provider.DTE_CYCLE
				 +dg.space(1)
				 +UniqueValues.get("NUM_TAX_ID")
				 +dg.space(1)
				 +UniqueValues.get("NUM_PROV_SSN")
				 +GlobalVariables_provider.ID_PROVIDER_NPI
				 +dg.space(10)
				 +GlobalVariables_provider.DERIVED
				 +dg.space(8)
				 +GlobalVariables_provider.DERIVED1
				 +dg.space(13)
				 +GlobalVariables_provider.DERIVED2
				 +dg.space(1)
				 +GlobalVariables_provider.NA
				 +dg.space(15)
				 +GlobalVariables_provider.NA1
				 +dg.space(20)
				 +GlobalVariables_provider.CDE_ORGANIZ
				 +dg.space(1)
				 +GlobalVariables_provider.NUM_PROV_LIC
				 +dg.space(48)
				 +GlobalVariables_provider.DTE_EFF_MCD_AGREEMENT
				 +dg.space(37)
				 +GlobalVariables_provider.DERIVED3
				 +dg.space(3)
				 +GlobalVariables_provider.DERIVED4
				 +dg.space(6)
				 +UniqueValues.get("NUM_PHONE")
				 +GlobalVariables_provider.NUM_PHONE_INT
				 +dg.space(2)
				 +GlobalVariables_provider.DERIVED5
				 +dg.space(1)
				 +GlobalVariables_provider.NUM_LONGITUDE
				 +dg.space(1)
				 +GlobalVariables_provider.NA2
				 +dg.space(1)
				 +GlobalVariables_provider.NA3
				 +dg.space(3)
				 +UniqueValues.get("ADR_MAIL_STRT1")
				 +UniqueValues.get("ADR_MAIL_STRT2")
				 +UniqueValues.get("ADR_MAIL_CITY")
				 +UniqueValues.get("ADR_MAIL_STATE")
				 +UniqueValues.get("ADR_MAIL_ZIP")
				 +UniqueValues.get("ADR2_MAIL_STRT1")
				 +UniqueValues.get("ADR2_MAIL_STRT2")
				 +UniqueValues.get("ADR2_MAIL_CITY")
				 +UniqueValues.get("ADR2_MAIL_STATE")
				 +UniqueValues.get("ADR2_MAIL_ZIP")
				 +UniqueValues.get("ADR3_MAIL_STRT1")
				 +UniqueValues.get("ADR3_MAIL_STRT2")
				 +UniqueValues.get("ADR3_MAIL_CITY")
				 +UniqueValues.get("ADR3_MAIL_STATE")
				 +UniqueValues.get("ADR3_MAIL_ZIP")
				 +GlobalVariables_provider.DTE_EFFECTIVE
				 +dg.space(1)
				 +GlobalVariables_provider.NA4
				 +dg.space(1)
				 +GlobalVariables_provider.NA5
				 +dg.space(1)
				 +GlobalVariables_provider.NA6
				 +dg.space(1)
				 +GlobalVariables_provider.NA7
				 +dg.space(1)
				 +GlobalVariables_provider.NA8
				 +dg.space(2)
				 +GlobalVariables_provider.DTE_EFFECTIVE3
				 +dg.space(11)
				 +GlobalVariables_provider.DTE_EFFECTIVE1
				 +dg.space(3)
				 +GlobalVariables_provider.DTE_EFFECTIVE2
				 +UniqueValues.get("ADR_EMAIL")
				 +dg.space(26)
				 +UniqueValues.get("NUM_PHONE1")
				 +GlobalVariables_provider.NA9
				 +GlobalVariables_provider.CDE_PROV_PGM
				 +GlobalVariables_provider.Add5
				 +GlobalVariables_provider.Add6
				 );
			provPMFFullExtractName.write('\n');
			provPMFFullExtractName.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public synchronized void writeProvPMFContractExtractFile(FileWriter ProvPMFContractExtractFileName,Map<String,String> UniqueValues) throws IOException{
		try {


			ProvPMFContractExtractFileName.write(GlobalVariables_provider.contract1
					+UniqueValues.get("ID_PROVIDER_MCD")
					+GlobalVariables_provider.contract2+UniqueValues.get("ProvTypeSpeciality")+GlobalVariables_provider.contract3);
			ProvPMFContractExtractFileName.write('\n');
			ProvPMFContractExtractFileName.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public synchronized void writeProvPMFSpecialityExtractFile(FileWriter ProvPMFSpecialityExtractFileName,Map<String,String> UniqueValues) throws IOException{
		try {


			ProvPMFSpecialityExtractFileName.write(GlobalVariables_provider.special1+UniqueValues.get("ID_PROVIDER_MCD")
					  +GlobalVariables_provider.contract2+UniqueValues.get("ProvTypeSpeciality")+GlobalVariables_provider.specialpart2);
			ProvPMFSpecialityExtractFileName.write('\n');
			ProvPMFSpecialityExtractFileName.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}

