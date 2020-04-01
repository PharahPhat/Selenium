package DSV.Molina.Provider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.FileContentReader;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;

import com.globalMethods.core.Assertion_DbVerifier; public class R2138_TC96264_Verify_ProviderAPI_ProviderNPI_ProviderFax_SSN_TaxID_ProviderTaxonomy extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	
	Map<String ,String> fileUpdateValue = new HashMap<>();
	 String fileName;
	
	String timeStamp;  FileContentReader FileContentReader =new FileContentReader(); 
	@BeforeMethod(alwaysRun = true)
	public void tearDown()
	{
		 this.timeStamp =CommonMethods.getTimeStamp();	
	  
	}
	
	@Test(enabled = true, groups = {"All"})

	 public void TC96264_Verify_ProviderAPI_ProviderNPI_ProviderFax_SSN_TaxID_ProviderTaxonomy_maxlength() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC96264_Verify_ProviderAPI_ProviderNPI_ProviderFax_SSN_TaxID_ProviderTaxonomy_maxlength");
			System.out.println(globalVariables.genericfile+globalVariables.molinaProviderFileName);
//////////////Variable declaration ///////////////////
	Map<String ,String> mapUpdateFileData = new HashMap<>();
	Map<String ,String> finalMapapdataByRow = new HashMap<>();
	Map<String ,String> mapOutboundData = new HashMap<>();
	String FileName;
	List<String> errorMessage =new ArrayList<String>();
	List<String> fileNames;

	logger.log(LogStatus.INFO,"Creating map for required Field map");
	fileUpdateValue=GenerateUniqueParam.providerParams_PipeDelimited();
	fileUpdateValue.put(globalVariables.ProviderAPI,CommonMethods.generateRandomNumberOfFixLength(31));
	fileUpdateValue.put(globalVariables.ProviderNPI,CommonMethods.generateRandomNumberOfFixLength(11));
	fileUpdateValue.put(globalVariables.ProviderFax,CommonMethods.generateRandomNumberOfFixLength(11));
	fileUpdateValue.put(globalVariables.SSN,CommonMethods.generateRandomNumberOfFixLength(10));
	fileUpdateValue.put(globalVariables.TaxID,CommonMethods.generateRandomNumberOfFixLength(10));
	fileUpdateValue.put(globalVariables.providertaxonomy,CommonMethods.generateRandomNumberOfFixLength(10));

	logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
	FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.molinaProviderGenericFile, fileUpdateValue,globalVariables.memberProviderFileName, globalVariables.provider,timeStamp);

	logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
	mapOutboundData.put(FileName, "1");
	String outboundFileName= FileContentReader.createOutboundFileAndEncrypt(mapOutboundData,timeStamp);

	logger.log(LogStatus.INFO,"process the Files and get the control file ");
	finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
	fileNames=FileContentReader.putGetFilefromServer(FileName,outboundFileName,null,timeStamp);
	logger.log(LogStatus.INFO,"Veirfying the ErrorFile generated ");
	
	errorMessage.add(globalVariables.memberClientLastNameNotNull);
	assertionDbVerifier.assertControlFileInValid(fileNames,FileName,errorMessage, globalVariables.provider,timeStamp);
			
	 }
	 
	
	@Test(enabled = true, groups = {"All"})

	 public void TC96264_Verify_ProviderAPI_ProviderNPI_ProviderFax_SSN_TaxID_ProviderTaxonomy_alphanumeric() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC96264_Verify_ProviderAPI_ProviderNPI_ProviderFax_SSN_TaxID_ProviderTaxonomy_alphanumeric");
			System.out.println(globalVariables.genericfile+globalVariables.molinaProviderFileName);

//////////////Variable declaration ///////////////////
	Map<String ,String> mapUpdateFileData = new HashMap<>();
	Map<String ,String> finalMapapdataByRow = new HashMap<>();
	Map<String ,String> mapOutboundData = new HashMap<>();
	String FileName;
	List<String> errorMessage =new ArrayList<String>();
	List<String> fileNames;
	logger.log(LogStatus.INFO,"Creating map for required Field map");
	fileUpdateValue=GenerateUniqueParam.providerParams_PipeDelimited();
	fileUpdateValue.put(globalVariables.ProviderAPI,CommonMethods.generateRandomAlphaNumeric(30));
	fileUpdateValue.put(globalVariables.ProviderNPI,CommonMethods.generateRandomAlphaNumeric(10));
	fileUpdateValue.put(globalVariables.ProviderFax,CommonMethods.generateRandomAlphaNumeric(10));
	fileUpdateValue.put(globalVariables.SSN,CommonMethods.generateRandomAlphaNumeric(9));
	fileUpdateValue.put(globalVariables.TaxID,CommonMethods.generateRandomAlphaNumeric(9));
	fileUpdateValue.put(globalVariables.providertaxonomy,CommonMethods.generateRandomAlphaNumeric(9));
	
	logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
	FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.molinaProviderGenericFile, fileUpdateValue,globalVariables.memberProviderFileName, globalVariables.provider,timeStamp);

	logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
	mapOutboundData.put(FileName, "1");
	String outboundFileName= FileContentReader.createOutboundFileAndEncrypt(mapOutboundData,timeStamp);

	logger.log(LogStatus.INFO,"process the Files and get the control file ");
	finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
	fileNames=FileContentReader.putGetFilefromServer(FileName,outboundFileName,null,timeStamp);
	logger.log(LogStatus.INFO,"Veirfying the ErrorFile generated ");
	
	errorMessage.add(globalVariables.memberClientLastNameNotNull);
	assertionDbVerifier.assertControlFileInValid(fileNames,FileName,errorMessage, globalVariables.provider,timeStamp);
		
	 }
	 

	 
	@Test(enabled = true, groups = {"All"})

	 public void TC96264_Verify_ProviderAPI_ProviderNPI_ProviderFax_SSN_TaxID_ProviderTaxonomy_withspace() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC96264_Verify_ProviderAPI_ProviderNPI_ProviderFax_SSN_TaxID_ProviderTaxonomy_withspace");
			System.out.println(globalVariables.genericfile+globalVariables.molinaProviderFileName);
//////////////Variable declaration ///////////////////
	Map<String ,String> mapUpdateFileData = new HashMap<>();
	Map<String ,String> finalMapapdataByRow = new HashMap<>();
	Map<String ,String> mapOutboundData = new HashMap<>();
	String FileName;
	List<String> errorMessage =new ArrayList<String>();
	List<String> fileNames;

	logger.log(LogStatus.INFO,"Creating map for required Field map");
	fileUpdateValue=GenerateUniqueParam.providerParams_PipeDelimited();
	fileUpdateValue.put(globalVariables.ProviderMedicaidID,CommonMethods.generateRandomNumberOfFixLength(6)+ "  "+CommonMethods.generateRandomNumberOfFixLength(2));
	fileUpdateValue.put(globalVariables.ProviderAPI,CommonMethods.generateRandomNumberOfFixLength(6)+ "  "+CommonMethods.generateRandomNumberOfFixLength(2));
	fileUpdateValue.put(globalVariables.ProviderNPI,CommonMethods.generateRandomNumberOfFixLength(6)+ "  "+CommonMethods.generateRandomNumberOfFixLength(2));
	fileUpdateValue.put(globalVariables.ProviderFax,CommonMethods.generateRandomNumberOfFixLength(6)+ "  "+CommonMethods.generateRandomNumberOfFixLength(2));
	fileUpdateValue.put(globalVariables.SSN,CommonMethods.generateRandomNumberOfFixLength(6)+ " "+CommonMethods.generateRandomNumberOfFixLength(2));
	fileUpdateValue.put(globalVariables.TaxID,CommonMethods.generateRandomNumberOfFixLength(6)+ " "+CommonMethods.generateRandomNumberOfFixLength(2));
	fileUpdateValue.put(globalVariables.providertaxonomy,CommonMethods.generateRandomNumberOfFixLength(6)+ " "+CommonMethods.generateRandomNumberOfFixLength(2));
	
	
	logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
	FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.molinaProviderGenericFile, fileUpdateValue,globalVariables.memberProviderFileName, globalVariables.provider,timeStamp);

	logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
	mapOutboundData.put(FileName, "1");
	String outboundFileName= FileContentReader.createOutboundFileAndEncrypt(mapOutboundData,timeStamp);

	logger.log(LogStatus.INFO,"process the Files and get the control file ");
	finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
	fileNames=FileContentReader.putGetFilefromServer(FileName,outboundFileName,null,timeStamp);
	logger.log(LogStatus.INFO,"Veirfying the ErrorFile generated ");
	
	errorMessage.add(globalVariables.memberClientLastNameNotNull);
	assertionDbVerifier.assertControlFileInValid(fileNames,FileName,errorMessage, globalVariables.provider,timeStamp);
			
			
	 }
	 
	@Test(enabled = true, groups = {"All"})

	 public void TC96264_Verify_ProviderAPI_ProviderNPI_ProviderFax_SSN_TaxID_ProviderTaxonomy_leadingspace() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC96264_Verify_ProviderAPI_ProviderNPI_ProviderFax_SSN_TaxID_ProviderTaxonomy_leadingspace");
			System.out.println(globalVariables.genericfile+globalVariables.molinaProviderFileName);
//////////////Variable declaration ///////////////////
	Map<String ,String> mapUpdateFileData = new HashMap<>();
	Map<String ,String> finalMapapdataByRow = new HashMap<>();
	Map<String ,String> mapOutboundData = new HashMap<>();
	String FileName;
	List<String> errorMessage =new ArrayList<String>();
	List<String> fileNames;

	logger.log(LogStatus.INFO,"Creating map for required Field map");
	fileUpdateValue=GenerateUniqueParam.providerParams_PipeDelimited();
	fileUpdateValue.put(globalVariables.ProviderAPI," " +CommonMethods.generateRandomNumberOfFixLength(20));
	fileUpdateValue.put(globalVariables.ProviderNPI," " +CommonMethods.generateRandomNumberOfFixLength(9));
	fileUpdateValue.put(globalVariables.ProviderFax," " +CommonMethods.generateRandomNumberOfFixLength(9));
	fileUpdateValue.put(globalVariables.SSN," " +CommonMethods.generateRandomNumberOfFixLength(8));
	fileUpdateValue.put(globalVariables.TaxID," " +CommonMethods.generateRandomNumberOfFixLength(8));
	fileUpdateValue.put(globalVariables.providertaxonomy," " +CommonMethods.generateRandomNumberOfFixLength(8));

	
	logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
	FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.molinaProviderGenericFile, fileUpdateValue,globalVariables.memberProviderFileName, globalVariables.provider,timeStamp);

	logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
	mapOutboundData.put(FileName, "1");
	String outboundFileName= FileContentReader.createOutboundFileAndEncrypt(mapOutboundData,timeStamp);

	logger.log(LogStatus.INFO,"process the Files and get the control file ");
	finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
	fileNames=FileContentReader.putGetFilefromServer(FileName,outboundFileName,null,timeStamp);
	logger.log(LogStatus.INFO,"Veirfying the ErrorFile generated ");
	
	errorMessage.add(globalVariables.memberClientLastNameNotNull);
	assertionDbVerifier.assertControlFileInValid(fileNames,FileName,errorMessage, globalVariables.provider,timeStamp);
			
	 }

	@Test(enabled = true, groups = {"All"})

	 public void TC96264_Verify_ProviderAPI_ProviderNPI_ProviderFax_SSN_TaxID_ProviderTaxonomy_trailingspace() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC96264_Verify_ProviderAPI_ProviderNPI_ProviderFax_SSN_TaxID_ProviderTaxonomy_trailingspace");
			System.out.println(globalVariables.genericfile+globalVariables.molinaProviderFileName);

//////////////Variable declaration ///////////////////
	Map<String ,String> mapUpdateFileData = new HashMap<>();
	Map<String ,String> finalMapapdataByRow = new HashMap<>();
	Map<String ,String> mapOutboundData = new HashMap<>();
	String FileName;
	List<String> errorMessage =new ArrayList<String>();
	List<String> fileNames;
	logger.log(LogStatus.INFO,"Creating map for required Field map");
	fileUpdateValue=GenerateUniqueParam.providerParams_PipeDelimited();
	fileUpdateValue.put(globalVariables.ProviderAPI,CommonMethods.generateRandomNumberOfFixLength(20)+" ");
	fileUpdateValue.put(globalVariables.ProviderNPI,CommonMethods.generateRandomNumberOfFixLength(9)+" ");
	fileUpdateValue.put(globalVariables.ProviderFax,CommonMethods.generateRandomNumberOfFixLength(9)+" ");
	fileUpdateValue.put(globalVariables.SSN,CommonMethods.generateRandomNumberOfFixLength(8)+" ");
	fileUpdateValue.put(globalVariables.TaxID,CommonMethods.generateRandomNumberOfFixLength(8)+" ");
	fileUpdateValue.put(globalVariables.providertaxonomy,CommonMethods.generateRandomNumberOfFixLength(8)+" ");

	logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
	FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.molinaProviderGenericFile, fileUpdateValue,globalVariables.memberProviderFileName, globalVariables.provider,timeStamp);

	logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
	mapOutboundData.put(FileName, "1");
	String outboundFileName= FileContentReader.createOutboundFileAndEncrypt(mapOutboundData,timeStamp);

	logger.log(LogStatus.INFO,"process the Files and get the control file ");
	finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
	fileNames=FileContentReader.putGetFilefromServer(FileName,outboundFileName,null,timeStamp);
	logger.log(LogStatus.INFO,"Veirfying the ErrorFile generated ");
	
	errorMessage.add(globalVariables.memberClientLastNameNotNull);
	assertionDbVerifier.assertControlFileInValid(fileNames,FileName,errorMessage, globalVariables.provider,timeStamp);
			
	 }


}
