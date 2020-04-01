package Ohio.sandata.batchclaim;

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

public class SEVV_4799_verify_payer_and_payerID_in_response extends BaseTest{
	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); 
	Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	
	Map<String ,String> fileUpdateValue = new HashMap<String,String>();
	Map<String ,String> fileUpdateValueOutbound = new HashMap<String,String>();
	Map<String ,String> finalMapapdataByRow = new HashMap<>();
	List<String> fileNames;	
	String timeStamp;  FileContentReader FileContentReader =new FileContentReader(); 
	@BeforeMethod(alwaysRun = true)
	public void tearDown()
	{
	this.timeStamp =CommonMethods.getTimeStamp();	
	FileContentReader.cleanupOHIO();
	}
	
	//Covered in other case
//	@Test(groups = {"All"})
	public void SEVV4799_Batch_Claim_verify_payer_in_response() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("SEVV4799_Batch_Claim_verify_payer_in_response");
    
		logger.log(LogStatus.INFO,"Creating unique parameters for claim file");	
	fileUpdateValue=GenerateUniqueParam.ohioclaim_PipeDelimited();
	
	logger.log(LogStatus.INFO,"Creating request and outbound files");	
	String fileName = FileContentReader.createPipeDelimFilefileohio(globalVariables.OhioGenericFile,fileUpdateValue,timeStamp);
	fileUpdateValueOutbound.put(fileName, "1");
	String outBoundFileName =FileContentReader.createOutboundFileOhio(fileUpdateValueOutbound,timeStamp,fileUpdateValue.get(globalVariables.batchid));
	logger.log(LogStatus.INFO,"put and get files from server");
	finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.getOhioClaimFilePick+fileName);
	fileNames=FileContentReader.putGetFilefromServerOhio(fileName,outBoundFileName,null,timeStamp,fileUpdateValue.get(globalVariables.batchid));


	logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
	List<String> status = new ArrayList<String>();
	status.add(fileUpdateValue.get(globalVariables.payer));
	assertionDbVerifier.assertControlFileValidOhio(fileNames,finalMapapdataByRow,timeStamp,fileUpdateValue.get(globalVariables.batchid),status);
    
    
    	
	}

	//	@Test(groups = {"All"})
	public void SEVV4799_Batch_Claim_ProviderQualifier_in_response() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("SEVV4799_Batch_Claim_ProviderQualifier_in_response");
    
		logger.log(LogStatus.INFO,"Creating unique parameters for claim file");	
	fileUpdateValue=GenerateUniqueParam.ohioclaim_PipeDelimited();
	
	logger.log(LogStatus.INFO,"Creating request and outbound files");	
	String fileName = FileContentReader.createPipeDelimFilefileohio(globalVariables.OhioGenericFile,fileUpdateValue,timeStamp);
	fileUpdateValueOutbound.put(fileName, "1");
	String outBoundFileName =FileContentReader.createOutboundFileOhio(fileUpdateValueOutbound,timeStamp,fileUpdateValue.get(globalVariables.batchid));
	logger.log(LogStatus.INFO,"put and get files from server");
	finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.getOhioClaimFilePick+fileName);
	fileNames=FileContentReader.putGetFilefromServerOhio(fileName,outBoundFileName,null,timeStamp,fileUpdateValue.get(globalVariables.batchid));


	logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
	List<String> status = new ArrayList<String>();
	status.add(fileUpdateValue.get(globalVariables.PatientQualifier));
	assertionDbVerifier.assertControlFileValidOhio(fileNames,finalMapapdataByRow,timeStamp,fileUpdateValue.get(globalVariables.batchid),status);
    
    
    	
	}

	//	@Test(groups = {"All"})
	public void SEVV4799_Batch_Claim_PatientQualifier_in_response() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("SEVV4799_Batch_Claim_PatientQualifier_in_response");
    
		logger.log(LogStatus.INFO,"Creating unique parameters for claim file");	
	fileUpdateValue=GenerateUniqueParam.ohioclaim_PipeDelimited();
	
	logger.log(LogStatus.INFO,"Creating request and outbound files");	
	String fileName = FileContentReader.createPipeDelimFilefileohio(globalVariables.OhioGenericFile,fileUpdateValue,timeStamp);
	fileUpdateValueOutbound.put(fileName, "1");
	String outBoundFileName =FileContentReader.createOutboundFileOhio(fileUpdateValueOutbound,timeStamp,fileUpdateValue.get(globalVariables.batchid));
	logger.log(LogStatus.INFO,"put and get files from server");
	finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.getOhioClaimFilePick+fileName);
	fileNames=FileContentReader.putGetFilefromServerOhio(fileName,outBoundFileName,null,timeStamp,fileUpdateValue.get(globalVariables.batchid));


	logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
	List<String> status = new ArrayList<String>();
	status.add(fileUpdateValue.get(globalVariables.ProviderQualifier));
	assertionDbVerifier.assertControlFileValidOhio(fileNames,finalMapapdataByRow,timeStamp,fileUpdateValue.get(globalVariables.batchid),status);
    
    
    	
	}

	

}
