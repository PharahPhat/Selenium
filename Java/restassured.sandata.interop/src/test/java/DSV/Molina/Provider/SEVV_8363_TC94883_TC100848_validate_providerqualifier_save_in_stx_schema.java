package DSV.Molina.Provider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.globalMethods.core.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;

public class SEVV_8363_TC94883_TC100848_validate_providerqualifier_save_in_stx_schema extends BaseTest{
	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	

	
	String timeStamp;  FileContentReader FileContentReader =new FileContentReader(); 
	@BeforeMethod(alwaysRun = true)
	public void tearDown()
	{
		 this.timeStamp =CommonMethods.getTimeStamp();	
	  
	}
	
	@Test(enabled = true, groups = {"All", "Regression"})

	 public void TC100848_Verify_Valid_providerqualifier_field_NPI() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC96283_Verify_Valid_ProviderMedicaidID_field_alphabet");
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
	fileUpdateValue.put(globalVariables.ProviderQualifier,"NPI");

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
	
	@Test(enabled = true, groups = {"All", "Regression"})

	 public void TC100848_Verify_Valid_providerqualifier_field_API() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC96283_Verify_Valid_ProviderMedicaidID_field_alphabet");
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
	fileUpdateValue.put(globalVariables.ProviderQualifier,"NPI");

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
	
	@Test(enabled = true, groups = {"All", "Regression"})

	 public void TC100848_Verify_Valid_providerqualifier_field_MedicaidID() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC96283_Verify_Valid_ProviderMedicaidID_field_alphabet");
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
	
	@Test(enabled = true, groups = {"All", "Regression"})

	 public void TC100848_Verify_Valid_providerqualifier_field_Other() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC96283_Verify_Valid_ProviderMedicaidID_field_alphabet");
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
	fileUpdateValue.put(globalVariables.ProviderQualifier,"Other");

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

	@Test(enabled = true, groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")

	public void TC94883_Validat_Invalid_ProviderQualifier() throws Exception{
		Map<String ,String> mapOutboundData = new HashMap<>();
		// logger = extent.startTest("TC94883_Validat_Invalid_ProviderQualifier");
		System.out.println(globalVariables.genericfile+globalVariables.molinaProviderFileName);


		logger.log(LogStatus.INFO,"Creating map for required Field map");
		Map<String ,String> fileUpdateValue=GenerateUniqueParam.providerParams_PipeDelimited();



		logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
		String FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.molinaProviderGenericFile, fileUpdateValue,globalVariables.memberProviderFileName, globalVariables.provider,timeStamp);

		logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
		mapOutboundData.put(FileName, "1");
		String outboundFileName= FileContentReader.createOutboundFileAndEncrypt(mapOutboundData,timeStamp);

		logger.log(LogStatus.INFO,"process the Files and get the control file ");
		Map<String ,String>finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
		List<String> fileNames=FileContentReader.putGetFilefromServer(FileName,outboundFileName,null,timeStamp);

		logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
		assertionDbVerifier.assertControlFileValid(fileNames,FileName,finalMapapdataByRow,outboundFileName,globalVariables.provider,timeStamp);
	}
}



