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
import com.globalMethods.core.SftpUtils;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;

import com.globalMethods.core.Assertion_DbVerifier; public class SEVV_4799_TC98529_TC98530_Batch_Claim_request_visit_based_service_exactmatch extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
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
	public void TC98529_Batch_Claim_request_visit_based_service_exactmatch() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC98529_Batch_Claim_request_visit_based_service_exactmatch");
   
    fileUpdateValue=GenerateUniqueParam.ohioclaim_PipeDelimited();
    fileUpdateValue.put(globalVariables.MatchingRule,"ExactMatch");
	fileUpdateValue.put(globalVariables.PatientID,"223373834325");;
	fileUpdateValue.put(globalVariables.ProcedureCode,"T1001");
	fileUpdateValue.put(globalVariables.Units,"99");
	String fileName = FileContentReader.createPipeDelimFilefileohio(globalVariables.OhioGenericFile,fileUpdateValue,timeStamp);
	fileUpdateValueOutbound.put(fileName, "1");
	String outBoundFileName =FileContentReader.createOutboundFileOhio(fileUpdateValueOutbound,timeStamp,fileUpdateValue.get(globalVariables.batchid));
	finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.getOhioClaimFilePick+fileName);
	fileNames=FileContentReader.putGetFilefromServerOhio(fileName,outBoundFileName,null,timeStamp,fileUpdateValue.get(globalVariables.batchid));


	logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
	List<String> status = new ArrayList<String>();
	status.add(globalVariables.truResponse);
	assertionDbVerifier.assertControlFileValidOhio(fileNames,finalMapapdataByRow,timeStamp,fileUpdateValue.get(globalVariables.batchid),status);
	}
	
	@Test(groups = {"All", "Regression"})
	public void TC98530_Batch_Claim_request_visit_based_service() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC98530_Batch_Claim_request_visit_based_service");
   
    fileUpdateValue=GenerateUniqueParam.ohioclaim_PipeDelimited();
    fileUpdateValue.put(globalVariables.MatchingRule,"EqualOrGreaterThan");
	fileUpdateValue.put(globalVariables.PatientID,"223373834325");;
	fileUpdateValue.put(globalVariables.ProcedureCode,"T1001");
	String fileName = FileContentReader.createPipeDelimFilefileohio(globalVariables.OhioGenericFile,fileUpdateValue,timeStamp);
	fileUpdateValueOutbound.put(fileName, "1");
	String outBoundFileName =FileContentReader.createOutboundFileOhio(fileUpdateValueOutbound,timeStamp,fileUpdateValue.get(globalVariables.batchid));
	finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.getOhioClaimFilePick+fileName);
	fileNames=FileContentReader.putGetFilefromServerOhio(fileName,outBoundFileName,null,timeStamp,fileUpdateValue.get(globalVariables.batchid));


	logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
	List<String> status = new ArrayList<String>();
	status.add(globalVariables.truResponse);
	assertionDbVerifier.assertControlFileValidOhio(fileNames,finalMapapdataByRow,timeStamp,fileUpdateValue.get(globalVariables.batchid),status);
    
    	
	}

}
