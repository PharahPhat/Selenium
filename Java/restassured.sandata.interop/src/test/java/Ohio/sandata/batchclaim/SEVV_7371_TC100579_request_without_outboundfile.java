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

import com.globalMethods.core.Assertion_DbVerifier; 

public class SEVV_7371_TC100579_request_without_outboundfile extends BaseTest { 

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

	// File will not be processed when missing outbound file
//	@Test(groups = {"All"})
	public void TC100579_request_without_outboundfile() throws InterruptedException, java.text.ParseException,  Exception{

		// logger = extent.startTest("TC100579_request_without_outboundfile");
		logger.log(LogStatus.INFO,"Creating unique parameters for claim file");	
		fileUpdateValue=GenerateUniqueParam.ohioclaim_PipeDelimited();
		fileUpdateValue.put(globalVariables.MatchingRule,"EqualOrGreaterThan");
		logger.log(LogStatus.INFO,"Creating request and outbound files");
		String fileName = FileContentReader.createPipeDelimFilefileohio(globalVariables.OhioGenericFile,fileUpdateValue,timeStamp);
		fileUpdateValueOutbound.put(fileName, "1");
		logger.log(LogStatus.INFO,"put and get files from server without outbound files");
		//String outBoundFileName =FileContentReader.createOutboundFileOhio(fileUpdateValueOutbound,timeStamp,fileUpdateValue.get(globalVariables.batchid));
		finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.getOhioClaimFilePick+fileName);
		fileNames=FileContentReader.putGetFilefromServerOhio_without_outbound(fileName,null,timeStamp,fileUpdateValue.get(globalVariables.batchid));


		logger.log(LogStatus.INFO,"Veirfying that inbound and response file should not be there");
		List<String> status = new ArrayList<String>();
		status.add("true");
		assertionDbVerifier.assertControlFileValidOhio(fileNames,finalMapapdataByRow,timeStamp,fileUpdateValue.get(globalVariables.batchid),status);




	}

	@Test(groups = {"All"})
	public void TC98525_Batch_Claim_should_get_error_if_mathcingrule_Invalid() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC98525_Batch_Claim_should_get_error_if_mathcingrule_Invalid");


		fileUpdateValue=GenerateUniqueParam.ohioclaim_PipeDelimited();
		fileUpdateValue.put(globalVariables.MatchingRule,"Greater");
		String fileName = FileContentReader.createPipeDelimFilefileohio(globalVariables.OhioGenericFile,fileUpdateValue,timeStamp);
		fileUpdateValueOutbound.put(fileName, "1");
		String outBoundFileName =FileContentReader.createOutboundFileOhio(fileUpdateValueOutbound,timeStamp,fileUpdateValue.get(globalVariables.batchid));
		finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.getOhioClaimFilePick+fileName);
		fileNames=FileContentReader.putGetFilefromServerOhio(fileName,outBoundFileName,null,timeStamp,fileUpdateValue.get(globalVariables.batchid));


		logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
		List<String> status = new ArrayList<String>();
		status.add(globalVariables.exactMathcRuleError);
		assertionDbVerifier.assertControlFileValidOhio_error(fileNames,finalMapapdataByRow,timeStamp,fileUpdateValue.get(globalVariables.batchid),status);


	}

	@Test(groups = {"All"})
	public void TC98525_Batch_Claim_should_get_error_if_mathcingrule_space() throws InterruptedException, java.text.ParseException,  Exception
	{

		// logger = extent.startTest("TC98525_Batch_Claim_should_get_error_if_mathcingrule_space");


		fileUpdateValue=GenerateUniqueParam.ohioclaim_PipeDelimited();
		fileUpdateValue.put(globalVariables.MatchingRule,"");
		String fileName = FileContentReader.createPipeDelimFilefileohio(globalVariables.OhioGenericFile,fileUpdateValue,timeStamp);
		fileUpdateValueOutbound.put(fileName, "1");
		String outBoundFileName =FileContentReader.createOutboundFileOhio(fileUpdateValueOutbound,timeStamp,fileUpdateValue.get(globalVariables.batchid));
		finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.getOhioClaimFilePick+fileName);
		fileNames=FileContentReader.putGetFilefromServerOhio(fileName,outBoundFileName,null,timeStamp,fileUpdateValue.get(globalVariables.batchid));


		logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
		List<String> status = new ArrayList<String>();
		status.add(globalVariables.exactMathcRuleError);
		assertionDbVerifier.assertControlFileValidOhio_error(fileNames,finalMapapdataByRow,timeStamp,fileUpdateValue.get(globalVariables.batchid),status);



	}

}
