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

public class SEVV_7371_TC99749_no_requestfile_with_outboundfile extends BaseTest{
	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	Assertion_DbVerifier Assertion_DbVerifier=new Assertion_DbVerifier();
	
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
	
	String invalidtime, invalidbatch="1223";

	@Test(groups = {"All"})
	public void TC99748_outboundfile_with_correct_recordnumber() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC99748_outboundfile_with_correct_recordnumber");
		logger.log(LogStatus.INFO,"Creating unique parameters for claim file");	
	fileUpdateValue=GenerateUniqueParam.ohioclaim_PipeDelimited();
	logger.log(LogStatus.INFO,"Creating request and outbound files");
	String fileName = FileContentReader.createPipeDelimFilefileohio(globalVariables.OhioGenericFile,fileUpdateValue,timeStamp);
	fileUpdateValueOutbound.put(fileName, "1");
	String outBoundFileName =FileContentReader.createOutboundFileOhio(fileUpdateValueOutbound,invalidtime,fileUpdateValue.get(invalidbatch));
	logger.log(LogStatus.INFO,"Creating request and outbound files");
	finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.getOhioClaimFilePick+fileName);
	fileNames=FileContentReader.putGetFilefromServerOhio(fileName,outBoundFileName,null,timeStamp,fileUpdateValue.get(globalVariables.batchid));


	logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
	List<String> status = new ArrayList<String>();
	status.add("true");
	Assertion_DbVerifier.assertControlFileValidOhio(fileNames,finalMapapdataByRow,timeStamp,fileUpdateValue.get(globalVariables.batchid),status);
    
  
    
    	
	}

}
