package DSV.Indiana.provider;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SEVV8610_TC99931_Generic_Provider_Taxonomy_Validation extends BaseTest{

	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	Assertion_DbVerifier Assertion_DbVerifier=new Assertion_DbVerifier();

	Map<String ,String> fileUpdateValue = new HashMap<>();
	
	//////////////Variable declaration ///////////////////
	Map<String ,String> mapUpdateFileData = new HashMap<>();
	Map<String ,String> finalMapapdataByRow = new HashMap<>();
	Map<String ,String> mapOutboundData = new HashMap<>();
	List<String> Errormessage = new ArrayList<String>();
	String FileName;
	List<String> fileNames;
	String timeStamp;  
	FileContentReader FileContentReader =new FileContentReader(); 
	
	@BeforeMethod(alwaysRun = true)
	public void tearDown()
	{
		this.timeStamp =CommonMethods.getTimeStamp();	

	}

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC99931_Generic_Provider_Taxonomy_valid_length() throws Exception{
		// logger = extent.startTest("TC99931_Generic_Provider_Taxonomy_valid_length");

		logger.log(LogStatus.INFO,"Creating map for required Field map");
		fileUpdateValue=GenerateUniqueParam.providerParams_PipeDelimited();

		fileUpdateValue.put(globalVariables.providertaxonomy,CommonMethods.generateRandomStringOfFixLength(9));

		logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
		FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.indianaProviderGenericFile, fileUpdateValue,globalVariables.indianaGenericFileFormat, globalVariables.provider,timeStamp);

		logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
		mapOutboundData.put(FileName, "1");
		String outboundFileName= FileContentReader.createOutboundFileAndEncryptGeneric(mapOutboundData,timeStamp,globalVariables.indianaGenericFileFormat);

		logger.log(LogStatus.INFO,"process the Files and get the control file ");
		finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
		fileNames=FileContentReader.putGetFilefromServerIndiana(FileName,outboundFileName,null,timeStamp);

		logger.log(LogStatus.INFO,"Verifying the value in Db and control File dat");
		Assertion_DbVerifier.assertControlFileValidindiana(fileNames, FileName, finalMapapdataByRow, outboundFileName, globalVariables.provider,timeStamp);
	}

	public void TC99931_Generic_Provider_Taxonomy_invalid_length() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC99931_Generic_Provider_Taxonomy_invalid_length");

		logger.log(LogStatus.INFO,"Creating map for required Field map");
		fileUpdateValue=GenerateUniqueParam.providerParams_PipeDelimited();

		fileUpdateValue.put(globalVariables.providertaxonomy,CommonMethods.generateRandomStringOfFixLength(10));

		logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
		FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.indianaProviderGenericFile, fileUpdateValue,globalVariables.indianaGenericFileFormat, globalVariables.provider,timeStamp);

		logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
		mapOutboundData.put(FileName, "1");
		String outboundFileName= FileContentReader.createOutboundFileAndEncryptGeneric(mapOutboundData,timeStamp,globalVariables.indianaGenericFileFormat);

		logger.log(LogStatus.INFO,"process the Files and get the control file ");
		finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
		fileNames=FileContentReader.putGetFilefromServerIndiana(FileName,outboundFileName,null,timeStamp);

		logger.log(LogStatus.INFO,"Verifying the value in Db and control File dat");
		Errormessage.add(globalVariables.providerTaxonomyerror);
		Assertion_DbVerifier.assertControlFileValidindiana(fileNames, FileName, finalMapapdataByRow, outboundFileName, globalVariables.provider,timeStamp);
	}
	
	public void TC99931_Generic_Provider_Taxonomy_blank() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC99931_Generic_Provider_Taxonomy_blank");

		logger.log(LogStatus.INFO,"Creating map for required Field map");
		fileUpdateValue=GenerateUniqueParam.providerParams_PipeDelimited();

		fileUpdateValue.put(globalVariables.providertaxonomy,"");

		logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
		FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.indianaProviderGenericFile, fileUpdateValue,globalVariables.indianaGenericFileFormat, globalVariables.provider,timeStamp);

		logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
		mapOutboundData.put(FileName, "1");
		String outboundFileName= FileContentReader.createOutboundFileAndEncryptGeneric(mapOutboundData,timeStamp,globalVariables.indianaGenericFileFormat);

		logger.log(LogStatus.INFO,"process the Files and get the control file ");
		finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
		fileNames=FileContentReader.putGetFilefromServerIndiana(FileName,outboundFileName,null,timeStamp);

		logger.log(LogStatus.INFO,"Verifying the value in Db and control File dat");
		Assertion_DbVerifier.assertControlFileValidindiana(fileNames, FileName, finalMapapdataByRow, outboundFileName, globalVariables.provider,timeStamp);
	}

	public void TC99931_Generic_Provider_Taxonomy_null() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC99931_Generic_Provider_Taxonomy_null");

		logger.log(LogStatus.INFO,"Creating map for required Field map");
		fileUpdateValue=GenerateUniqueParam.providerParams_PipeDelimited();

		fileUpdateValue.put(globalVariables.providertaxonomy,null);

		logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
		FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.indianaProviderGenericFile, fileUpdateValue,globalVariables.indianaGenericFileFormat, globalVariables.provider,timeStamp);

		logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
		mapOutboundData.put(FileName, "1");
		String outboundFileName= FileContentReader.createOutboundFileAndEncryptGeneric(mapOutboundData,timeStamp,globalVariables.indianaGenericFileFormat);

		logger.log(LogStatus.INFO,"process the Files and get the control file ");
		finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
		fileNames=FileContentReader.putGetFilefromServerIndiana(FileName,outboundFileName,null,timeStamp);

		logger.log(LogStatus.INFO,"Verifying the value in Db and control File dat");
		Assertion_DbVerifier.assertControlFileValidindiana(fileNames, FileName, finalMapapdataByRow, outboundFileName, globalVariables.provider,timeStamp);
	}

	public void TC99931_Generic_Provider_Taxonomy_alphanumeric() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC99931_Generic_Provider_Taxonomy_alphanumeric");

		logger.log(LogStatus.INFO,"Creating map for required Field map");
		fileUpdateValue=GenerateUniqueParam.providerParams_PipeDelimited();

		fileUpdateValue.put(globalVariables.providertaxonomy,CommonMethods.generateRandomAlphaNumeric(9));

		logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
		FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.indianaProviderGenericFile, fileUpdateValue,globalVariables.indianaGenericFileFormat, globalVariables.provider,timeStamp);

		logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
		mapOutboundData.put(FileName, "1");
		String outboundFileName= FileContentReader.createOutboundFileAndEncryptGeneric(mapOutboundData,timeStamp,globalVariables.indianaGenericFileFormat);

		logger.log(LogStatus.INFO,"process the Files and get the control file ");
		finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
		fileNames=FileContentReader.putGetFilefromServerIndiana(FileName,outboundFileName,null,timeStamp);

		logger.log(LogStatus.INFO,"Verifying the value in Db and control File dat");
		Errormessage.add(globalVariables.providerTaxonomyerror);
		Assertion_DbVerifier.assertControlFileValidindiana(fileNames, FileName, finalMapapdataByRow, outboundFileName, globalVariables.provider,timeStamp);
	}


}