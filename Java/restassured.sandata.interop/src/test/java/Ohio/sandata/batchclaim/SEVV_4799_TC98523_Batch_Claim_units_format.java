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

import com.globalMethods.core.Assertion_DbVerifier; public class SEVV_4799_TC98523_Batch_Claim_units_format extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	
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
	public void TC98523_Batch_Claim_units_format_morethan_allowed_lenghth() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC98523_Batch_Claim_units_format_morethan_allowed_lenghth");
    
	logger.log(LogStatus.INFO,"Generating unique parameters for claim file");
	fileUpdateValue=GenerateUniqueParam.ohioclaim_PipeDelimited();
	fileUpdateValue.put(globalVariables.Units,CommonMethods.generateRandomNumberOfFixLength(10));
	
	logger.log(LogStatus.INFO,"Creating unique reqest and outbound files for claim.");
	String fileName = FileContentReader.createPipeDelimFilefileohio(globalVariables.OhioGenericFile,fileUpdateValue,timeStamp);
	fileUpdateValueOutbound.put(fileName, "1");
	String outBoundFileName =FileContentReader.createOutboundFileOhio(fileUpdateValueOutbound,timeStamp,fileUpdateValue.get(globalVariables.batchid));
	finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.getOhioClaimFilePick+fileName);
	fileNames=FileContentReader.putGetFilefromServerOhio(fileName,outBoundFileName,null,timeStamp,fileUpdateValue.get(globalVariables.batchid));


	logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
	List<String> status = new ArrayList<String>();
	status.add(globalVariables.invalidunit);
	assertionDbVerifier.assertControlFileValidOhio_error(fileNames,finalMapapdataByRow,timeStamp,fileUpdateValue.get(globalVariables.batchid),status);
    	
    
    	
	}
	
	@Test(groups = {"All"})
	public void TC98523_Batch_Claim_units_format_blank() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC98523_Batch_Claim_units_format_blank");
    
	fileUpdateValue=GenerateUniqueParam.ohioclaim_PipeDelimited();
	fileUpdateValue.put(globalVariables.Units,"");
	String fileName = FileContentReader.createPipeDelimFilefileohio(globalVariables.OhioGenericFile,fileUpdateValue,timeStamp);
	fileUpdateValueOutbound.put(fileName, "1");
	String outBoundFileName =FileContentReader.createOutboundFileOhio(fileUpdateValueOutbound,timeStamp,fileUpdateValue.get(globalVariables.batchid));
	finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.getOhioClaimFilePick+fileName);
	fileNames=FileContentReader.putGetFilefromServerOhio(fileName,outBoundFileName,null,timeStamp,fileUpdateValue.get(globalVariables.batchid));

	logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
	List<String> status = new ArrayList<String>();
	status.add("Units is NULL");
	assertionDbVerifier.assertControlFileValidOhio_error(fileNames,finalMapapdataByRow,timeStamp,fileUpdateValue.get(globalVariables.batchid),status);
    	
    	
	}

	@Test(groups = {"All", "Regression"})
	public void TC98523_Batch_Claim_units_format_chracters() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC98523_Batch_Claim_units_format_chracters");
    
	fileUpdateValue=GenerateUniqueParam.ohioclaim_PipeDelimited();
	fileUpdateValue.put(globalVariables.Units,CommonMethods.generateRandomStringOfFixLength(6));
	String fileName = FileContentReader.createPipeDelimFilefileohio(globalVariables.OhioGenericFile,fileUpdateValue,timeStamp);
	fileUpdateValueOutbound.put(fileName, "1");
	String outBoundFileName =FileContentReader.createOutboundFileOhio(fileUpdateValueOutbound,timeStamp,fileUpdateValue.get(globalVariables.batchid));
	finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.getOhioClaimFilePick+fileName);
	fileNames=FileContentReader.putGetFilefromServerOhio(fileName,outBoundFileName,null,timeStamp,fileUpdateValue.get(globalVariables.batchid));


	logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
	List<String> status = new ArrayList<String>();
	status.add(globalVariables.invalidunit);
	assertionDbVerifier.assertControlFileValidOhio_error(fileNames,finalMapapdataByRow,timeStamp,fileUpdateValue.get(globalVariables.batchid),status);
    	
    	
	}
	
	@Test(groups = {"All", "Regression"})
	public void TC98523_Batch_Claim_units_format_null() throws InterruptedException, java.text.ParseException,  Exception{
		
		// logger = extent.startTest("TC98523_Batch_Claim_units_format_null");
    
	fileUpdateValue=GenerateUniqueParam.ohioclaim_PipeDelimited();
	fileUpdateValue.put(globalVariables.Units,"NULL");
	String fileName = FileContentReader.createPipeDelimFilefileohio(globalVariables.OhioGenericFile,fileUpdateValue,timeStamp);
	fileUpdateValueOutbound.put(fileName, "1");
	String outBoundFileName =FileContentReader.createOutboundFileOhio(fileUpdateValueOutbound,timeStamp,fileUpdateValue.get(globalVariables.batchid));
	finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.getOhioClaimFilePick+fileName);
	fileNames=FileContentReader.putGetFilefromServerOhio(fileName,outBoundFileName,null,timeStamp,fileUpdateValue.get(globalVariables.batchid));


	logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
	List<String> status = new ArrayList<String>();
	status.add(globalVariables.invalidunit);
	assertionDbVerifier.assertControlFileValidOhio_error(fileNames,finalMapapdataByRow,timeStamp,fileUpdateValue.get(globalVariables.batchid),status);
    	
	}
	
	

}
