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

public class SEVV_4799_TC98518_TC98517_Batch_Claim_with_and_without_T1001_service extends BaseTest{
	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	Assertion_DbVerifier Assertion_DbVerifier=new Assertion_DbVerifier();
	
	Map<String ,String> fileUpdateValue = new HashMap<String,String>();
	Map<String ,String> fileUpdateValueOutbound = new HashMap<String,String>();
	Map<String ,String> finalMapapdataByRow = new HashMap<>();
	List<String> fileNames;	
	List<String> status = new ArrayList<String>();
	
	String timeStamp;  FileContentReader FileContentReader =new FileContentReader(); 
	@BeforeMethod(alwaysRun = true)
	public void tearDown()
	{
	this.timeStamp =CommonMethods.getTimeStamp();	
	FileContentReader.cleanupOHIO();
	}
	
	@Test(groups = {"All", "Regression"})
	public void TC98518_Batch_Claim_with_T1001_service() throws InterruptedException, java.text.ParseException,  Exception{
	// logger = extent.startTest("TC98518_Batch_Claim_with_T1001_servce");
  
	logger.log(LogStatus.INFO,"Generating unique parameters file");
	fileUpdateValue=GenerateUniqueParam.ohioclaim_PipeDelimited();
	fileUpdateValue.put(globalVariables.ServiceStartDate,"2019-04-03");
	fileUpdateValue.put(globalVariables.ServiceEndDate,"2019-04-03");
	fileUpdateValue.put(globalVariables.ProcedureCode,"T1001");
	fileUpdateValue.put(globalVariables.Units,"3");
	
	
	
	logger.log(LogStatus.INFO,"Creating request and outbound files");
	String fileName = FileContentReader.createPipeDelimFilefileohio(globalVariables.OhioGenericFile,fileUpdateValue,timeStamp);
	fileUpdateValueOutbound.put(fileName, "1");
	String outBoundFileName =FileContentReader.createOutboundFileOhio(fileUpdateValueOutbound,timeStamp,fileUpdateValue.get(globalVariables.batchid));
	
	logger.log(LogStatus.INFO,"Uploading and downloading files");
	finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.getOhioClaimFilePick+fileName);
	fileNames=FileContentReader.putGetFilefromServerOhio(fileName,outBoundFileName,null,timeStamp,fileUpdateValue.get(globalVariables.batchid));
	
	logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
	
	status.add("true");
	Assertion_DbVerifier.assertControlFileValidOhio(fileNames,finalMapapdataByRow,timeStamp,fileUpdateValue.get(globalVariables.batchid),status);
	
    	
	}
	
	@Test(groups = {"All", "Regression"})
	public void TC98517_Batch_Claim_without_T1001_servce() throws InterruptedException, java.text.ParseException,  Exception{
	// logger = extent.startTest("TC98517_Batch_Claim_without_T1001_servce");
  
	logger.log(LogStatus.INFO,"Generating unique parameters file");
	fileUpdateValue=GenerateUniqueParam.ohioclaim_PipeDelimited();
	fileUpdateValue.put(globalVariables.MatchingRule,"ExcludeUnits");
	
	logger.log(LogStatus.INFO,"Creating request and outbound files");
	String fileName = FileContentReader.createPipeDelimFilefileohio(globalVariables.OhioGenericFile,fileUpdateValue,timeStamp);
	fileUpdateValueOutbound.put(fileName, "1");
	String outBoundFileName =FileContentReader.createOutboundFileOhio(fileUpdateValueOutbound,timeStamp,fileUpdateValue.get(globalVariables.batchid));
	
	logger.log(LogStatus.INFO,"Uploading and downloading files");
	finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.getOhioClaimFilePick+fileName);
	fileNames=FileContentReader.putGetFilefromServerOhio(fileName,outBoundFileName,null,timeStamp,fileUpdateValue.get(globalVariables.batchid));
	
	logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
	
	status.add("true");
	Assertion_DbVerifier.assertControlFileValidOhio(fileNames,finalMapapdataByRow,timeStamp,fileUpdateValue.get(globalVariables.batchid),status);
	
    	
	}
}
