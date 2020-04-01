package DSV.Indiana.provider;

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

public class SEVV_8605_TC102278_Update_Fields_Sent_Null_Batch extends BaseTest{
	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	Assertion_DbVerifier Assertion_DbVerifier=new Assertion_DbVerifier();

	
	Map<String ,String> fileUpdateValue = new HashMap<>();
	 String fileName;
	//////////////Variable declaration ///////////////////
	Map<String ,String> mapUpdateFileData = new HashMap<>();
	Map<String ,String> finalMapapdataByRow = new HashMap<>();
	Map<String ,String> mapOutboundData = new HashMap<>();
	String FileName;
	List<String> fileNames;
	String timeStamp;  FileContentReader FileContentReader =new FileContentReader(); 
	String timeStamp2;
	@BeforeMethod(alwaysRun = true)
	public void tearDown()
	{
		 this.timeStamp =CommonMethods.getTimeStamp();	
	  
	}
	
	@Test(enabled = true, groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	
	public void SEVV_8605_TC102278_Update_Fields_Sent_Null() throws InterruptedException, java.text.ParseException,  Exception{
	// logger = extent.startTest("SEVV_8605_TC102278_Update_Fields_Sent_Null_Batch");

	logger.log(LogStatus.INFO,"Creating map for required Field map");
	fileUpdateValue=GenerateUniqueParam.providerParams_PipeDelimited();
	fileUpdateValue.put(globalVariables.ProviderName,CommonMethods.generateRandomStringOfFixLength(10));
	fileUpdateValue.put(globalVariables.ProviderDoingBusinessAs,"");
	fileUpdateValue.put(globalVariables.AddressLine2,"");
	fileUpdateValue.put(globalVariables.County,"");
	fileUpdateValue.put(globalVariables.ProviderFax,"");
	fileUpdateValue.put(globalVariables.ProviderNPI,"");
	fileUpdateValue.put(globalVariables.ProviderAPI,"");
	fileUpdateValue.put(globalVariables.TaxID,"");

	logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
	FileName=FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.indianaProviderGenericFile, fileUpdateValue,globalVariables.indianaGenericFileFormat, globalVariables.provider,timeStamp);

	logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
	mapOutboundData.put(FileName, "1");
	String outboundFileName= FileContentReader.createOutboundFileAndEncryptGeneric(mapOutboundData,timeStamp,globalVariables.indianaGenericFileFormat);

	logger.log(LogStatus.INFO,"process the Files and get the control file ");
	finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);

	fileNames=FileContentReader.putGetFilefromServerIndiana(FileName,outboundFileName,null,timeStamp);
	
	System.out.println(finalMapapdataByRow);
	
	logger.log(LogStatus.INFO,"Changing the values in map from blank to null");
	
	System.out.println("Updating values to nul to get those matched with database");
	finalMapapdataByRow.put(globalVariables.ProviderDoingBusinessAs,null);
	finalMapapdataByRow.put(globalVariables.AddressLine2,null);
	finalMapapdataByRow.put(globalVariables.County,null);
	finalMapapdataByRow.put(globalVariables.ProviderFax,null);
	finalMapapdataByRow.put(globalVariables.ProviderNPI,null);
	finalMapapdataByRow.put(globalVariables.ProviderAPI,null);
	finalMapapdataByRow.put(globalVariables.TaxID,null);
	
	logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
	Assertion_DbVerifier.assertControlFileValidindiana(fileNames,FileName,finalMapapdataByRow,outboundFileName,globalVariables.provider,timeStamp);
	
	System.out.println("Inbound verified");
	
	
	Assertion_DbVerifier.ImportAssert_stx_Accounts_info(finalMapapdataByRow);
	Assertion_DbVerifier.ImportAssert_stx_stxAccouts_interfaces(finalMapapdataByRow);
	Assertion_DbVerifier.ImportAssert_stxAccounts_TaxID(finalMapapdataByRow);
	
    //**********now updating some valid values in fields which were sent null***************
	finalMapapdataByRow.put(globalVariables.ProviderDoingBusinessAs,CommonMethods.generateRandomStringOfFixLength(10));
	finalMapapdataByRow.put(globalVariables.AddressLine2,CommonMethods.generateRandomStringOfFixLength(20));
	finalMapapdataByRow.put(globalVariables.County,CommonMethods.generateRandomStringOfFixLength(10));
	finalMapapdataByRow.put(globalVariables.ProviderFax,CommonMethods.generateRandomNumberOfFixLength(10));
	finalMapapdataByRow.put(globalVariables.ProviderNPI,CommonMethods.generateRandomNumberOfFixLength(10));
	finalMapapdataByRow.put(globalVariables.ProviderAPI,CommonMethods.generateRandomNumberOfFixLength(10));
	finalMapapdataByRow.put(globalVariables.TaxID,CommonMethods.generateRandomNumberOfFixLength(9));
	
	System.out.println(finalMapapdataByRow);
	
	//**********Taking latest timestamp to create file with this timestamp*************** 
	timeStamp =CommonMethods.getTimeStamp();	
	
	logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
	FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.indianaProviderGenericFile, finalMapapdataByRow,globalVariables.indianaGenericFileFormat, globalVariables.provider,timeStamp);

	logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
	mapOutboundData.put(FileName, "1");
	outboundFileName= FileContentReader.createOutboundFileAndEncryptGeneric(mapOutboundData,timeStamp,globalVariables.indianaGenericFileFormat);

	
	
	logger.log(LogStatus.INFO,"process the Files and get the control file ");
	fileNames=FileContentReader.putGetFilefromServerIndiana(FileName,outboundFileName,null,timeStamp);
	
    //***********Verifying the updated values in DB*************************
	Assertion_DbVerifier.ImportAssert_stx_Accounts_info(finalMapapdataByRow);
	Assertion_DbVerifier.ImportAssert_stx_stxAccouts_interfaces(finalMapapdataByRow);
	Assertion_DbVerifier.ImportAssert_stxAccounts_TaxID(finalMapapdataByRow);
	
	
		}

}
