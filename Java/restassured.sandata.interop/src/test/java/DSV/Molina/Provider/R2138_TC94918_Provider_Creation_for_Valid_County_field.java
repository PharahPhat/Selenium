package DSV.Molina.Provider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.FileContentReader;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;

import com.globalMethods.core.Assertion_DbVerifier; public class R2138_TC94918_Provider_Creation_for_Valid_County_field extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	
	
	String timeStamp;  FileContentReader FileContentReader =new FileContentReader(); 
	@BeforeMethod(alwaysRun = true)
	public void tearDown()
	{
		 this.timeStamp =CommonMethods.getTimeStamp();	
	  
	}
	
	 @Test(enabled = true, groups = {"All"})

	 public void TC94918_Provider_Creation_for_Valid_County_field_alphabet() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC94918_Provider_Creation_for_Valid_County_field_alphabet");
			System.out.println(globalVariables.genericfile+globalVariables.molinaProviderFileName);
			Map<String ,String> fileUpdateValue = new HashMap<>();
			 String fileName;
			//////////////Variable declaration ///////////////////
			Map<String ,String> mapUpdateFileData = new HashMap<>();
			Map<String ,String> finalMapapdataByRow = new HashMap<>();
			Map<String ,String> mapOutboundData = new HashMap<>();
			String FileName;
			List<String> fileNames;

	logger.log(LogStatus.INFO,"Creating map for required Field map");
	fileUpdateValue=GenerateUniqueParam.providerParams_PipeDelimited();
	fileUpdateValue.put(globalVariables.providerCounty,CommonMethods.generateRandomStringOfFixLength(12));

	logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
	FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.molinaProviderGenericFile, fileUpdateValue,globalVariables.memberProviderFileName, globalVariables.provider,timeStamp);

	logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
	mapOutboundData.put(FileName, "1");
	String outboundFileName= FileContentReader.createOutboundFileAndEncrypt(mapOutboundData,timeStamp);

	logger.log(LogStatus.INFO,"process the Files and get the control file ");
	finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
	fileNames=FileContentReader.putGetFilefromServer(FileName,outboundFileName,null,timeStamp);
	
	logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
	assertionDbVerifier.assertControlFileValid(fileNames,FileName,finalMapapdataByRow,outboundFileName,globalVariables.provider,timeStamp);
		 }
	 
	 @Test(enabled = true, groups = {"All"})

	 public void TC94918_Provider_Creation_for_Valid_County_field_numeric() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC94918_Provider_Creation_for_Valid_County_field_numeric");
			System.out.println(globalVariables.genericfile+globalVariables.molinaProviderFileName);
			Map<String ,String> fileUpdateValue = new HashMap<>();
			 String fileName;
			//////////////Variable declaration ///////////////////
			Map<String ,String> mapUpdateFileData = new HashMap<>();
			Map<String ,String> finalMapapdataByRow = new HashMap<>();
			Map<String ,String> mapOutboundData = new HashMap<>();
			String FileName;
			List<String> fileNames;

	logger.log(LogStatus.INFO,"Creating map for required Field map");
	fileUpdateValue=GenerateUniqueParam.providerParams_PipeDelimited();
	fileUpdateValue.put(globalVariables.providerCounty,CommonMethods.generateRandomNumberOfFixLength(14));

	logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
	FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.molinaProviderGenericFile, fileUpdateValue,globalVariables.memberProviderFileName, globalVariables.provider,timeStamp);

	logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
	mapOutboundData.put(FileName, "1");
	String outboundFileName= FileContentReader.createOutboundFileAndEncrypt(mapOutboundData,timeStamp);

	logger.log(LogStatus.INFO,"process the Files and get the control file ");
	finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
	fileNames=FileContentReader.putGetFilefromServer(FileName,outboundFileName,null,timeStamp);
	
	logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
	assertionDbVerifier.assertControlFileValid(fileNames,FileName,finalMapapdataByRow,outboundFileName,globalVariables.provider,timeStamp);
			
	 }

	 @Test(enabled = true, groups = {"All"})

	 public void TC94918_Provider_Creation_for_Valid_County_field_alphanumeric() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC94918_Provider_Creation_for_Valid_County_field_alphanumeric");
			System.out.println(globalVariables.genericfile+globalVariables.molinaProviderFileName);
			Map<String ,String> fileUpdateValue = new HashMap<>();
			 String fileName;
			//////////////Variable declaration ///////////////////
			Map<String ,String> mapUpdateFileData = new HashMap<>();
			Map<String ,String> finalMapapdataByRow = new HashMap<>();
			Map<String ,String> mapOutboundData = new HashMap<>();
			String FileName;
			List<String> fileNames;

	logger.log(LogStatus.INFO,"Creating map for required Field map");
	fileUpdateValue=GenerateUniqueParam.providerParams_PipeDelimited();
	fileUpdateValue.put(globalVariables.providerCounty,CommonMethods.generateRandomAlphaNumeric(12));

	logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
	FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.molinaProviderGenericFile, fileUpdateValue,globalVariables.memberProviderFileName, globalVariables.provider,timeStamp);

	logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
	mapOutboundData.put(FileName, "1");
	String outboundFileName= FileContentReader.createOutboundFileAndEncrypt(mapOutboundData,timeStamp);

	logger.log(LogStatus.INFO,"process the Files and get the control file ");
	finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
	fileNames=FileContentReader.putGetFilefromServer(FileName,outboundFileName,null,timeStamp);
	
	logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
	assertionDbVerifier.assertControlFileValid(fileNames,FileName,finalMapapdataByRow,outboundFileName,globalVariables.provider,timeStamp);
			
	 }
	 
	 @Test(enabled = true, groups = {"All"})

	 public void TC94918_Provider_Creation_for_Valid_County_field_withspecialcharacter() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC94918_Provider_Creation_for_Valid_County_field_withspecialcharacter");
			System.out.println(globalVariables.genericfile+globalVariables.molinaProviderFileName);
			Map<String ,String> fileUpdateValue = new HashMap<>();
			 String fileName;
			//////////////Variable declaration ///////////////////
			Map<String ,String> mapUpdateFileData = new HashMap<>();
			Map<String ,String> finalMapapdataByRow = new HashMap<>();
			Map<String ,String> mapOutboundData = new HashMap<>();
			String FileName;
			List<String> fileNames;

	logger.log(LogStatus.INFO,"Creating map for required Field map");
	fileUpdateValue=GenerateUniqueParam.providerParams_PipeDelimited();
	fileUpdateValue.put(globalVariables.providerCounty,CommonMethods.generateSpecialChar(12));

	logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
	FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.molinaProviderGenericFile, fileUpdateValue,globalVariables.memberProviderFileName, globalVariables.provider,timeStamp);

	logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
	mapOutboundData.put(FileName, "1");
	String outboundFileName= FileContentReader.createOutboundFileAndEncrypt(mapOutboundData,timeStamp);

	logger.log(LogStatus.INFO,"process the Files and get the control file ");
	finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
	fileNames=FileContentReader.putGetFilefromServer(FileName,outboundFileName,null,timeStamp);
	
	logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
	assertionDbVerifier.assertControlFileValid(fileNames,FileName,finalMapapdataByRow,outboundFileName,globalVariables.provider,timeStamp);
		
	 }
	 
	 @Test(enabled = true, groups = {"All"})

	 public void TC94918_Provider_Creation_for_Valid_County_field_withspace() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC94918_Provider_Creation_for_Valid_County_field_withspace");
			System.out.println(globalVariables.genericfile+globalVariables.molinaProviderFileName);
			Map<String ,String> fileUpdateValue = new HashMap<>();
			 String fileName;
			//////////////Variable declaration ///////////////////
			Map<String ,String> mapUpdateFileData = new HashMap<>();
			Map<String ,String> finalMapapdataByRow = new HashMap<>();
			Map<String ,String> mapOutboundData = new HashMap<>();
			String FileName;
			List<String> fileNames;

	logger.log(LogStatus.INFO,"Creating map for required Field map");
	fileUpdateValue=GenerateUniqueParam.providerParams_PipeDelimited();
	fileUpdateValue.put(globalVariables.providerCounty,CommonMethods.generateRandomStringOfFixLength(5)+ "  "+CommonMethods.generateRandomStringOfFixLength(5));

	logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
	FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.molinaProviderGenericFile, fileUpdateValue,globalVariables.memberProviderFileName, globalVariables.provider,timeStamp);

	logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
	mapOutboundData.put(FileName, "1");
	String outboundFileName= FileContentReader.createOutboundFileAndEncrypt(mapOutboundData,timeStamp);

	logger.log(LogStatus.INFO,"process the Files and get the control file ");
	finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
	fileNames=FileContentReader.putGetFilefromServer(FileName,outboundFileName,null,timeStamp);
	
	logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
	assertionDbVerifier.assertControlFileValid(fileNames,FileName,finalMapapdataByRow,outboundFileName,globalVariables.provider,timeStamp);
		
	 }
	 @Test(enabled = true, groups = {"All"})

	 public void TC94918_Provider_Creation_for_Valid_County_field_leadingspace() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC94918_Provider_Creation_for_Valid_County_field_withspace");
			System.out.println(globalVariables.genericfile+globalVariables.molinaProviderFileName);
			Map<String ,String> fileUpdateValue = new HashMap<>();
			 String fileName;
			//////////////Variable declaration ///////////////////
			Map<String ,String> mapUpdateFileData = new HashMap<>();
			Map<String ,String> finalMapapdataByRow = new HashMap<>();
			Map<String ,String> mapOutboundData = new HashMap<>();
			String FileName;
			List<String> fileNames;

	logger.log(LogStatus.INFO,"Creating map for required Field map");
	fileUpdateValue=GenerateUniqueParam.providerParams_PipeDelimited();
	fileUpdateValue.put(globalVariables.providerCounty, " " + CommonMethods.generateRandomStringOfFixLength(15));

	logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
	FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.molinaProviderGenericFile, fileUpdateValue,globalVariables.memberProviderFileName, globalVariables.provider,timeStamp);

	logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
	mapOutboundData.put(FileName, "1");
	String outboundFileName= FileContentReader.createOutboundFileAndEncrypt(mapOutboundData,timeStamp);

	logger.log(LogStatus.INFO,"process the Files and get the control file ");
	finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
	fileNames=FileContentReader.putGetFilefromServer(FileName,outboundFileName,null,timeStamp);
	
	logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
	assertionDbVerifier.assertControlFileValid(fileNames,FileName,finalMapapdataByRow,outboundFileName,globalVariables.provider,timeStamp);
		
	 }

	 @Test(enabled = true, groups = {"All"})

	 public void TC94918_Provider_Creation_for_Valid_County_field_trailingspace() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC94918_Provider_Creation_for_Valid_County_field_withspace");
			System.out.println(globalVariables.genericfile+globalVariables.molinaProviderFileName);
			Map<String ,String> fileUpdateValue = new HashMap<>();
			 String fileName;
			//////////////Variable declaration ///////////////////
			Map<String ,String> mapUpdateFileData = new HashMap<>();
			Map<String ,String> finalMapapdataByRow = new HashMap<>();
			Map<String ,String> mapOutboundData = new HashMap<>();
			String FileName;
			List<String> fileNames;

	logger.log(LogStatus.INFO,"Creating map for required Field map");
	fileUpdateValue=GenerateUniqueParam.providerParams_PipeDelimited();
	fileUpdateValue.put(globalVariables.providerCounty,CommonMethods.generateEmailAddress_alpha(15)+" ");

	logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
	FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.molinaProviderGenericFile, fileUpdateValue,globalVariables.memberProviderFileName, globalVariables.provider,timeStamp);

	logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
	mapOutboundData.put(FileName, "1");
	String outboundFileName= FileContentReader.createOutboundFileAndEncrypt(mapOutboundData,timeStamp);

	logger.log(LogStatus.INFO,"process the Files and get the control file ");
	finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
	fileNames=FileContentReader.putGetFilefromServer(FileName,outboundFileName,null,timeStamp);
	
	logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
	assertionDbVerifier.assertControlFileValid(fileNames,FileName,finalMapapdataByRow,outboundFileName,globalVariables.provider,timeStamp);
		
	 }
}
