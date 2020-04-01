package Ohio.sandata.batchclaim;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SEVV_4799_TC98525_Batch_Claim_request_MatchingRule_validation extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
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
	@Test(groups = {"All", "Regression"})
	public void TC10027_Batch_Claim_request_MatchingRule_EqualOrGreaterThan() throws Exception{
		// logger = extent.startTest("TC10027_Batch_Claim_request_MatchingRule_EqualOrGreaterThan");
	
		logger.log(LogStatus.INFO,"Generating unique parameters file");	
	fileUpdateValue=GenerateUniqueParam.ohioclaim_PipeDelimited();
	fileUpdateValue.put(globalVariables.MatchingRule,"EqualOrGreaterThan");
	logger.log(LogStatus.INFO,"Creating request and outbound files");	
	String fileName = FileContentReader.createPipeDelimFilefileohio(globalVariables.OhioGenericFile,fileUpdateValue,timeStamp);
	fileUpdateValueOutbound.put(fileName, "1");
	String outBoundFileName =FileContentReader.createOutboundFileOhio(fileUpdateValueOutbound,timeStamp,fileUpdateValue.get(globalVariables.batchid));
	finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.getOhioClaimFilePick+fileName);
	fileNames=FileContentReader.putGetFilefromServerOhio(fileName,outBoundFileName,null,timeStamp,fileUpdateValue.get(globalVariables.batchid));


	logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
	List<String> status = new ArrayList<String>();
	status.add("true");
	assertionDbVerifier.assertControlFileValidOhio(fileNames,finalMapapdataByRow,timeStamp,fileUpdateValue.get(globalVariables.batchid),status);
    
  
    
    	
	}

	@Test(groups = {"All", "Regression"})
	public void TC98525_Batch_Claim_should_get_error_if_mathcingrule_Invalid() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC98525_Batch_Claim_should_get_error_if_mathcingrule_Invalid");

		logger.log(LogStatus.INFO,"Generating unique parameters file");	
	fileUpdateValue=GenerateUniqueParam.ohioclaim_PipeDelimited();
	fileUpdateValue.put(globalVariables.MatchingRule,"Greater");
	
	logger.log(LogStatus.INFO,"Creating request and outbound files");
	String fileName = FileContentReader.createPipeDelimFilefileohio(globalVariables.OhioGenericFile,fileUpdateValue,timeStamp);
	fileUpdateValueOutbound.put(fileName, "1");
	String outBoundFileName =FileContentReader.createOutboundFileOhio(fileUpdateValueOutbound,timeStamp,fileUpdateValue.get(globalVariables.batchid));
	finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.getOhioClaimFilePick+fileName);
	fileNames=FileContentReader.putGetFilefromServerOhio(fileName,outBoundFileName,null,timeStamp,fileUpdateValue.get(globalVariables.batchid));


	logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
	List<String> status = new ArrayList<String>();
	status.add(globalVariables.exactMathcRuleError);
	assertionDbVerifier.assertControlFileValidOhio(fileNames,finalMapapdataByRow,timeStamp,fileUpdateValue.get(globalVariables.batchid),status);
    
    	
	}

	
	@Test(groups = {"All"})
	public void TC98525_Batch_Claim_should_get_error_if_mathcingrule_space() throws InterruptedException, java.text.ParseException,  Exception{
		
		// logger = extent.startTest("TC98525_Batch_Claim_should_get_error_if_mathcingrule_space");

		logger.log(LogStatus.INFO,"Generating unique parameters file");	
    fileUpdateValue=GenerateUniqueParam.ohioclaim_PipeDelimited();
    fileUpdateValue.put(globalVariables.MatchingRule,"");
    logger.log(LogStatus.INFO,"Creating request and outbound files");
	String fileName = FileContentReader.createPipeDelimFilefileohio(globalVariables.OhioGenericFile,fileUpdateValue,timeStamp);
	fileUpdateValueOutbound.put(fileName, "1");
	String outBoundFileName =FileContentReader.createOutboundFileOhio(fileUpdateValueOutbound,timeStamp,fileUpdateValue.get(globalVariables.batchid));
	logger.log(LogStatus.INFO,"Uploading and downloading files");
	finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.getOhioClaimFilePick+fileName);
	fileNames=FileContentReader.putGetFilefromServerOhio(fileName,outBoundFileName,null,timeStamp,fileUpdateValue.get(globalVariables.batchid));

	
	logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
	List<String> status = new ArrayList<String>();
	status.add(globalVariables.exactMathcRuleError);
	assertionDbVerifier.assertControlFileValidOhio(fileNames,finalMapapdataByRow,timeStamp,fileUpdateValue.get(globalVariables.batchid),status);
    
    
    	
	}
	
	@Test(groups = {"All"})
	public void TC98525_Batch_Claim_should_get_error_if_mathcingrule_number() throws InterruptedException, java.text.ParseException,  Exception{
		
		// logger = extent.startTest("TC98525_Batch_Claim_should_get_error_if_mathcingrule_number");
		logger.log(LogStatus.INFO,"Generating unique parameters file");
	fileUpdateValue=GenerateUniqueParam.ohioclaim_PipeDelimited();
	fileUpdateValue.put(globalVariables.MatchingRule,"12345678");
	 
	logger.log(LogStatus.INFO,"Creating request and outbound files");
	String fileName = FileContentReader.createPipeDelimFilefileohio(globalVariables.OhioGenericFile,fileUpdateValue,timeStamp);
	fileUpdateValueOutbound.put(fileName, "1");
	String outBoundFileName =FileContentReader.createOutboundFileOhio(fileUpdateValueOutbound,timeStamp,fileUpdateValue.get(globalVariables.batchid));
	
	logger.log(LogStatus.INFO,"Uploading and downloading files");
	finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.getOhioClaimFilePick+fileName);
	fileNames=FileContentReader.putGetFilefromServerOhio(fileName,outBoundFileName,null,timeStamp,fileUpdateValue.get(globalVariables.batchid));


	logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
	List<String> status = new ArrayList<String>();
	status.add(globalVariables.exactMathcRuleError);
	assertionDbVerifier.assertControlFileValidOhio(fileNames,finalMapapdataByRow,timeStamp,fileUpdateValue.get(globalVariables.batchid),status);
    
    
    	
	}
	@Test(groups = {"All", "Regression"})
	public void TC98525_Batch_Claim_should_get_error_if_mathcingrule_null() throws InterruptedException, java.text.ParseException,  Exception{
		
		// logger = extent.startTest("TC98525_Batch_Claim_should_get_error_if_mathcingrule_null");
    
	fileUpdateValue=GenerateUniqueParam.ohioclaim_PipeDelimited();
	fileUpdateValue.put(globalVariables.MatchingRule,null);
	String fileName = FileContentReader.createPipeDelimFilefileohio(globalVariables.OhioGenericFile,fileUpdateValue,timeStamp);
	fileUpdateValueOutbound.put(fileName, "1");
	String outBoundFileName =FileContentReader.createOutboundFileOhio(fileUpdateValueOutbound,timeStamp,fileUpdateValue.get(globalVariables.batchid));
	finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.getOhioClaimFilePick+fileName);
	fileNames=FileContentReader.putGetFilefromServerOhio(fileName,outBoundFileName,null,timeStamp,fileUpdateValue.get(globalVariables.batchid));


	logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
	List<String> status = new ArrayList<String>();
	status.add(globalVariables.exactMathcRuleError);
	assertionDbVerifier.assertControlFileValidOhio(fileNames,finalMapapdataByRow,timeStamp,fileUpdateValue.get(globalVariables.batchid),status);
     
    	
	}
	@Test(groups = {"All", "Regression"})
	public void TC10028_Batch_Claim_request_MatchingRule_ExcludeUnits () throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC10028_Batch_Claim_request_MatchingRule_ExcludeUnits");
    
	fileUpdateValue=GenerateUniqueParam.ohioclaim_PipeDelimited();
	fileUpdateValue.put(globalVariables.MatchingRule,"ExcludeUnits");
	String fileName = FileContentReader.createPipeDelimFilefileohio(globalVariables.OhioGenericFile,fileUpdateValue,timeStamp);
	fileUpdateValueOutbound.put(fileName, "1");
	String outBoundFileName =FileContentReader.createOutboundFileOhio(fileUpdateValueOutbound,timeStamp,fileUpdateValue.get(globalVariables.batchid));
	finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.getOhioClaimFilePick+fileName);
	fileNames=FileContentReader.putGetFilefromServerOhio(fileName,outBoundFileName,null,timeStamp,fileUpdateValue.get(globalVariables.batchid));


	logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
	List<String> status = new ArrayList<String>();
	status.add("true");
	assertionDbVerifier.assertControlFileValidOhio(fileNames,finalMapapdataByRow,timeStamp,fileUpdateValue.get(globalVariables.batchid),status);
    
    	
	}
}

