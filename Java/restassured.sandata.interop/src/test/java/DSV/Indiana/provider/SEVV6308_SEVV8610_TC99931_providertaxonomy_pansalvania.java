package DSV.Indiana.provider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.FileContentReader;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;

public class SEVV6308_SEVV8610_TC99931_providertaxonomy_pansalvania extends BaseTest{
	
	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	Assertion_DbVerifier Assertion_DbVerifier=new Assertion_DbVerifier();


	Map<String ,String> fileUpdateValue = new HashMap<>();
	 String fileName;
	//////////////Variable declaration ///////////////////
	Map<String ,String> mapUpdateFileData = new HashMap<>();
	Map<String ,String> finalMapapdataByRow = new HashMap<>();
	Map<String ,String> mapOutboundData = new HashMap<>();
	List<String> Errormessage = new ArrayList<String>();
	String FileName;
	List<String> fileNames;
	String timeStamp;  FileContentReader FileContentReader =new FileContentReader(); 
	@BeforeMethod(alwaysRun = true)
	public void tearDown()
	{
		 this.timeStamp =CommonMethods.getTimeStamp();	
	  
	}

	 	@Test(enabled = false, groups = {"All", "Regression"})
		@AdditionalInfo(module = "OpenEVV")
		 public void SEVV6308_SEVV8610_TC99931_ProviderTaxonomy_length_morethan_allowed() throws InterruptedException, java.text.ParseException,  Exception{
			// logger = extent.startTest("SEVV6308_SEVV8610_TC99931_ProviderTaxonomy_length_morethan_allowed");
				

		logger.log(LogStatus.INFO,"Creating map for required Field map");
		fileUpdateValue=GenerateUniqueParam.providerParams_PipeDelimited();
		
		fileUpdateValue.put(globalVariables.providertaxonomy,CommonMethods.generateRandomStringOfFixLength(10));
		fileUpdateValue.put(globalVariables.PayerID,"PADHS");
		
		logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
		String outboundFileName= FileContentReader.createOutboundFileAndEncryptGeneric(mapOutboundData,timeStamp,globalVariables.indianaGenericFileFormat);

		logger.log(LogStatus.INFO,"process the Files and get the control file ");
		finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
		
		fileNames=FileContentReader.putGetFilefromServerPensolvania(FileName,outboundFileName,null,timeStamp);
		
		logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
		Errormessage=CommonMethods.getProviderErrorMessageForMissingRequiredField();
		Assertion_DbVerifier.assertControlFileInValidpenselvania(fileNames,FileName,Errormessage,globalVariables.provider,timeStamp);
		
		}
	
	 	@Test(enabled = false, groups = {"All", "Regression"})
		@AdditionalInfo(module = "OpenEVV")
		 public void SEVV6308_SEVV8610_TC99931_ProviderTaxonomy_length_valid_allowed() throws InterruptedException, java.text.ParseException,  Exception{
			
	 	// logger = extent.startTest("SEVV6308_SEVV8610_TC99931_ProviderTaxonomy_length_morethan_allowed");
				

		logger.log(LogStatus.INFO,"Creating map for required Field map");
		fileUpdateValue=GenerateUniqueParam.providerParams_PipeDelimited();
		
		fileUpdateValue.put(globalVariables.providertaxonomy,CommonMethods.generateRandomStringOfFixLength(9));
		fileUpdateValue.put(globalVariables.PayerID,"PADHS");
		

		logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
		String outboundFileName= FileContentReader.createOutboundFileAndEncryptGeneric(mapOutboundData,timeStamp,globalVariables.indianaGenericFileFormat);

		logger.log(LogStatus.INFO,"process the Files and get the control file ");
		finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
		fileNames=FileContentReader.putGetFilefromServerIndiana(FileName,outboundFileName,null,timeStamp);
		
		logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
		Assertion_DbVerifier.assertControlFileValidpensolvania(fileNames,FileName,finalMapapdataByRow,outboundFileName,globalVariables.provider,timeStamp);
		
		}

	 	@Test(enabled = true, groups = {"All"})
		@AdditionalInfo(module = "OpenEVV") 
		 public void SEVV6308_SEVV8610_TC99931_providertaxonomy_length_blank() throws InterruptedException, java.text.ParseException,  Exception{
				// logger = extent.startTest("SEVV6308_SEVV8610_TC99930_Taxid_length_blank");
					

			logger.log(LogStatus.INFO,"Creating map for required Field map");
			fileUpdateValue=GenerateUniqueParam.providerParams_PipeDelimited();
			
			fileUpdateValue.put(globalVariables.providertaxonomy,"");
			fileUpdateValue.put(globalVariables.PayerID,"PADHS");
			

			logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
			
			logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
			Errormessage=CommonMethods.getProviderErrorMessageForMissingRequiredField();
			Assertion_DbVerifier.assertControlFileInValidindiana(fileNames,FileName,Errormessage,globalVariables.provider,timeStamp);
			

		}
		 
		 @Test(enabled = false, groups = {"All"})
		 @AdditionalInfo(module = "OpenEVV")
		 public void SEVV6308_SEVV8610_TC99931_providertaxonomy_alphanumeric() throws InterruptedException, java.text.ParseException,  Exception{
				// logger = extent.startTest("SEVV6308_SEVV8610_TC99930_Taxid_special_alphanumeric");
					

			logger.log(LogStatus.INFO,"Creating map for required Field map");
			fileUpdateValue=GenerateUniqueParam.providerParams_PipeDelimited();
			
			fileUpdateValue.put(globalVariables.providertaxonomy,CommonMethods.generateRandomAlphaNumeric(9));
			fileUpdateValue.put(globalVariables.PayerID,"PADHS");
		

			logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
			FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.indianaProviderGenericFile, fileUpdateValue,globalVariables.indianaGenericFileFormat, globalVariables.provider,timeStamp);

			logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
			mapOutboundData.put(FileName, "1");
			String outboundFileName= FileContentReader.createOutboundFileAndEncryptGeneric(mapOutboundData,timeStamp,globalVariables.indianaGenericFileFormat);

			logger.log(LogStatus.INFO,"process the Files and get the control file ");
			finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
			fileNames=FileContentReader.putGetFilefromServerIndiana(FileName,outboundFileName,null,timeStamp);
			
			
			logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
			Assertion_DbVerifier.assertControlFileValidindiana(fileNames,FileName,finalMapapdataByRow,outboundFileName,globalVariables.provider,timeStamp);
		}
		 
		 @Test(enabled = false, groups = {"All"})
		 @AdditionalInfo(module = "OpenEVV")
		 public void SEVV6308_SEVV8610_TC99931_providertaxonomy_with_special_char() throws InterruptedException, java.text.ParseException,  Exception{
				// logger = extent.startTest("SEVV6308_SEVV8610_TC99931_providertaxonomy_with_special_char");
					

			logger.log(LogStatus.INFO,"Creating map for required Field map");
			fileUpdateValue=GenerateUniqueParam.providerParams_PipeDelimited();
			
			fileUpdateValue.put(globalVariables.providertaxonomy,CommonMethods.generateRandomAlphaNumeric(9)+"@");
			fileUpdateValue.put(globalVariables.PayerID,"PADHS");
		

			logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
			FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.indianaProviderGenericFile, fileUpdateValue,globalVariables.indianaGenericFileFormat, globalVariables.provider,timeStamp);

			logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
			mapOutboundData.put(FileName, "1");
			String outboundFileName= FileContentReader.createOutboundFileAndEncryptGeneric(mapOutboundData,timeStamp,globalVariables.indianaGenericFileFormat);

			logger.log(LogStatus.INFO,"process the Files and get the control file ");
			finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
			fileNames=FileContentReader.putGetFilefromServerIndiana(FileName,outboundFileName,null,timeStamp);
			
			
			logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
			Assertion_DbVerifier.assertControlFileValidindiana(fileNames,FileName,finalMapapdataByRow,outboundFileName,globalVariables.provider,timeStamp);
		}
		 
		 @Test(enabled = false, groups = {"All"})
		 @AdditionalInfo(module = "OpenEVV")
		 public void SEVV6308_SEVV8610_TC99931_providertaxonomy_null() throws InterruptedException, java.text.ParseException,  Exception{
				// logger = extent.startTest("SEVV6308_SEVV8610_TC99931_providertaxonomy_null");
					

			logger.log(LogStatus.INFO,"Creating map for required Field map");
			fileUpdateValue=GenerateUniqueParam.providerParams_PipeDelimited();
			
			fileUpdateValue.put(globalVariables.providertaxonomy,null);
			fileUpdateValue.put(globalVariables.PayerID,"PADHS");
		

			logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
			FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.indianaProviderGenericFile, fileUpdateValue,globalVariables.indianaGenericFileFormat, globalVariables.provider,timeStamp);

			logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
			mapOutboundData.put(FileName, "1");
			String outboundFileName= FileContentReader.createOutboundFileAndEncryptGeneric(mapOutboundData,timeStamp,globalVariables.indianaGenericFileFormat);

			logger.log(LogStatus.INFO,"process the Files and get the control file ");
			finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
			fileNames=FileContentReader.putGetFilefromServerIndiana(FileName,outboundFileName,null,timeStamp);
			
			logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
			Assertion_DbVerifier.assertControlFileValidindiana(fileNames,FileName,finalMapapdataByRow,outboundFileName,globalVariables.provider,timeStamp);
		}
}