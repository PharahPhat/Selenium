package DSV.Molina.Provider;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class R2138_TC94907_Verify_Valid_AddressLine2_field extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	Map<String ,String> fileUpdateValue = new HashMap<>();
	 String fileName;
	//////////////Variable declaration ///////////////////
	
	String timeStamp;  FileContentReader FileContentReader =new FileContentReader(); 
	@BeforeMethod(alwaysRun = true)
	public void tearDown()
	{
		 this.timeStamp =CommonMethods.getTimeStamp();	
	  
	}
	
	 @Test(enabled = true, groups = {"All"})

	 public void TC94907_Verify_Valid_AddressLine2_field_alphabet() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC94907_Verify_Valid_AddressLine2_field_alphabet");
			System.out.println(globalVariables.genericfile+globalVariables.molinaProviderFileName);
			Map<String ,String> mapUpdateFileData = new HashMap<>();
			Map<String ,String> finalMapapdataByRow = new HashMap<>();
			Map<String ,String> mapOutboundData = new HashMap<>();
			String FileName;
			List<String> fileNames;

	logger.log(LogStatus.INFO,"Creating map for required Field map");
	fileUpdateValue=GenerateUniqueParam.providerParams_PipeDelimited();
	fileUpdateValue.put(globalVariables.AddressLine2,CommonMethods.generateRandomStringOfFixLength(12));

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

	 public void TC94907_Verify_Valid_AddressLine2_field_numeric() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC94907_Verify_Valid_AddressLine2_field_numeric");
			System.out.println(globalVariables.genericfile+globalVariables.molinaProviderFileName);

			Map<String ,String> mapUpdateFileData = new HashMap<>();
			Map<String ,String> finalMapapdataByRow = new HashMap<>();
			Map<String ,String> mapOutboundData = new HashMap<>();
			String FileName;
			List<String> fileNames;
	logger.log(LogStatus.INFO,"Creating map for required Field map");
	fileUpdateValue=GenerateUniqueParam.providerParams_PipeDelimited();
	fileUpdateValue.put(globalVariables.AddressLine2,CommonMethods.generateRandomNumberOfFixLength(14));

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

	 public void TC94907_Verify_Valid_AddressLine2_field_alphanumeric() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC94907_Verify_Valid_AddressLine2_field_alphanumeric");
			System.out.println(globalVariables.genericfile+globalVariables.molinaProviderFileName);

			Map<String ,String> mapUpdateFileData = new HashMap<>();
			Map<String ,String> finalMapapdataByRow = new HashMap<>();
			Map<String ,String> mapOutboundData = new HashMap<>();
			String FileName;
			List<String> fileNames;
	logger.log(LogStatus.INFO,"Creating map for required Field map");
	fileUpdateValue=GenerateUniqueParam.providerParams_PipeDelimited();
	fileUpdateValue.put(globalVariables.AddressLine2,CommonMethods.generateRandomAlphaNumeric(12));
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
