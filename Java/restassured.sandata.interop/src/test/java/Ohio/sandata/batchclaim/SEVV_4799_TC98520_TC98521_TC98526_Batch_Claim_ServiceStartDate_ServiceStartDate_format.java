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

import com.globalMethods.core.Assertion_DbVerifier; public class SEVV_4799_TC98520_TC98521_TC98526_Batch_Claim_ServiceStartDate_ServiceStartDate_format extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	
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
	public void TC98521_Batch_Claim_ServiceStartDate_format_invalid() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC98520_Batch_Claim_ServiceStartDate_format_invalid");
    
		logger.log(LogStatus.INFO,"Generating unique parameters file");
	fileUpdateValue=GenerateUniqueParam.ohioclaim_PipeDelimited();
	fileUpdateValue.put(globalVariables.ServiceStartDate,"29-01-2018");
	
	logger.log(LogStatus.INFO,"Creating request and outbound files");
	String fileName = FileContentReader.createPipeDelimFilefileohio(globalVariables.OhioGenericFile,fileUpdateValue,timeStamp);
	fileUpdateValueOutbound.put(fileName, "1");
	String outBoundFileName =FileContentReader.createOutboundFileOhio(fileUpdateValueOutbound,timeStamp,fileUpdateValue.get(globalVariables.batchid));
	
	logger.log(LogStatus.INFO,"Uploading and downloading files");
	finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.getOhioClaimFilePick+fileName);
	fileNames=FileContentReader.putGetFilefromServerOhio(fileName,outBoundFileName,null,timeStamp,fileUpdateValue.get(globalVariables.batchid));


	logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
	List<String> status = new ArrayList<String>();
	status.add(globalVariables.dateformateerror);
	assertionDbVerifier.assertControlFileValidOhio_fail(fileNames,finalMapapdataByRow,timeStamp,fileUpdateValue.get(globalVariables.batchid),status);
    	
    
    	
	}
	
	@Test(groups = {"All"})
	public void TC98521_Batch_Claim_ServicestartDate_format_blank() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC98520_Batch_Claim_ServiceStartDate_format_blank");
    
		logger.log(LogStatus.INFO,"Generating unique parameters file");
	fileUpdateValue=GenerateUniqueParam.ohioclaim_PipeDelimited();
	fileUpdateValue.put(globalVariables.ServiceStartDate,"");
	
	logger.log(LogStatus.INFO,"Creating request and outbound files");
	String fileName = FileContentReader.createPipeDelimFilefileohio(globalVariables.OhioGenericFile,fileUpdateValue,timeStamp);
	fileUpdateValueOutbound.put(fileName, "1");
	String outBoundFileName =FileContentReader.createOutboundFileOhio(fileUpdateValueOutbound,timeStamp,fileUpdateValue.get(globalVariables.batchid));
	
	logger.log(LogStatus.INFO,"Uploading and downloading files");
	finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.getOhioClaimFilePick+fileName);
	fileNames=FileContentReader.putGetFilefromServerOhio(fileName,outBoundFileName,null,timeStamp,fileUpdateValue.get(globalVariables.batchid));

	logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
	List<String> status = new ArrayList<String>();
	status.add(globalVariables.dateformateerror);
	assertionDbVerifier.assertControlFileValidOhio_fail(fileNames,finalMapapdataByRow,timeStamp,fileUpdateValue.get(globalVariables.batchid),status);
    	
    	
	}

	@Test(groups = {"All", "Regression"})
	public void TC98520_Batch_Claim_ServiceStartDate_format_alphanumeric() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC98521_Batch_Claim_ServiceEndDate_format_alphanumeric");
    
		logger.log(LogStatus.INFO,"Generating unique parameters file");
	fileUpdateValue=GenerateUniqueParam.ohioclaim_PipeDelimited();
	fileUpdateValue.put(globalVariables.ServiceStartDate,CommonMethods.generateRandomAlphaNumeric(10));
	
	logger.log(LogStatus.INFO,"Creating request and outbound files");
	String fileName = FileContentReader.createPipeDelimFilefileohio(globalVariables.OhioGenericFile,fileUpdateValue,timeStamp);
	fileUpdateValueOutbound.put(fileName, "1");
	String outBoundFileName =FileContentReader.createOutboundFileOhio(fileUpdateValueOutbound,timeStamp,fileUpdateValue.get(globalVariables.batchid));
	
	logger.log(LogStatus.INFO,"Uploading and downloading files");
	finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.getOhioClaimFilePick+fileName);
	fileNames=FileContentReader.putGetFilefromServerOhio(fileName,outBoundFileName,null,timeStamp,fileUpdateValue.get(globalVariables.batchid));


	logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
	List<String> status = new ArrayList<String>();
	status.add(globalVariables.dateformateerror);
	assertionDbVerifier.assertControlFileValidOhio_fail(fileNames,finalMapapdataByRow,timeStamp,fileUpdateValue.get(globalVariables.batchid),status);
    	
	}
	
	@Test(groups = {"All", "Regression"})
	public void TC98520_Batch_Claim_ServiceStartDate_format_null() throws InterruptedException, java.text.ParseException,  Exception{
		
		// logger = extent.startTest("TC98521_Batch_Claim_ServiceEndDate_format_null");
		logger.log(LogStatus.INFO,"Generating unique parameters file");
	fileUpdateValue=GenerateUniqueParam.ohioclaim_PipeDelimited();
	fileUpdateValue.put(globalVariables.ServiceStartDate,"NULL");
	
	logger.log(LogStatus.INFO,"Creating request and outbound files");
	String fileName = FileContentReader.createPipeDelimFilefileohio(globalVariables.OhioGenericFile,fileUpdateValue,timeStamp);
	fileUpdateValueOutbound.put(fileName, "1");
	String outBoundFileName =FileContentReader.createOutboundFileOhio(fileUpdateValueOutbound,timeStamp,fileUpdateValue.get(globalVariables.batchid));
	
	logger.log(LogStatus.INFO,"Uploading and downloading files");
	finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.getOhioClaimFilePick+fileName);
	fileNames=FileContentReader.putGetFilefromServerOhio(fileName,outBoundFileName,null,timeStamp,fileUpdateValue.get(globalVariables.batchid));


	logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
	List<String> status = new ArrayList<String>();
	status.add(globalVariables.dateformateerror);
	assertionDbVerifier.assertControlFileValidOhio_fail(fileNames,finalMapapdataByRow,timeStamp,fileUpdateValue.get(globalVariables.batchid),status);
    	
	}
	
	@Test(groups = {"All", "Regression"})
	public void TC98521_Batch_Claim_ServiceEndDate_format_invalid() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC98521_Batch_Claim_ServiceEndDate_format_invalid");
		
		logger.log(LogStatus.INFO,"Generating unique parameters file");
	fileUpdateValue=GenerateUniqueParam.ohioclaim_PipeDelimited();
	fileUpdateValue.put(globalVariables.ServiceEndDate,"29-01-2018");
	
	logger.log(LogStatus.INFO,"Creating request and outbound files");
	String fileName = FileContentReader.createPipeDelimFilefileohio(globalVariables.OhioGenericFile,fileUpdateValue,timeStamp);
	fileUpdateValueOutbound.put(fileName, "1");
	String outBoundFileName =FileContentReader.createOutboundFileOhio(fileUpdateValueOutbound,timeStamp,fileUpdateValue.get(globalVariables.batchid));
	
	logger.log(LogStatus.INFO,"Uploading and downloading files");
	finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.getOhioClaimFilePick+fileName);
	fileNames=FileContentReader.putGetFilefromServerOhio(fileName,outBoundFileName,null,timeStamp,fileUpdateValue.get(globalVariables.batchid));


	logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
	List<String> status = new ArrayList<String>();
	status.add(globalVariables.dateformateerror);
	assertionDbVerifier.assertControlFileValidOhio_fail(fileNames,finalMapapdataByRow,timeStamp,fileUpdateValue.get(globalVariables.batchid),status);
    	
    
    	
	}
	
	@Test(groups = {"All"})
	public void TC98521_Batch_Claim_ServiceEndDate_format_blank() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC98521_Batch_Claim_ServiceEndDate_format_blank");
    
		logger.log(LogStatus.INFO,"Generating unique parameters file");
	fileUpdateValue=GenerateUniqueParam.ohioclaim_PipeDelimited();
	fileUpdateValue.put(globalVariables.ServiceEndDate,"");
	
	logger.log(LogStatus.INFO,"Creating request and outbound files");
	String fileName = FileContentReader.createPipeDelimFilefileohio(globalVariables.OhioGenericFile,fileUpdateValue,timeStamp);
	fileUpdateValueOutbound.put(fileName, "1");
	String outBoundFileName =FileContentReader.createOutboundFileOhio(fileUpdateValueOutbound,timeStamp,fileUpdateValue.get(globalVariables.batchid));
	
	logger.log(LogStatus.INFO,"Uploading and downloading files");
	finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.getOhioClaimFilePick+fileName);
	fileNames=FileContentReader.putGetFilefromServerOhio(fileName,outBoundFileName,null,timeStamp,fileUpdateValue.get(globalVariables.batchid));

	logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
	List<String> status = new ArrayList<String>();
	status.add(globalVariables.dateformateerror);
	assertionDbVerifier.assertControlFileValidOhio_fail(fileNames,finalMapapdataByRow,timeStamp,fileUpdateValue.get(globalVariables.batchid),status);
    	
    	
	}

	@Test(groups = {"All", "Regression"})
	public void TC98521_Batch_Claim_ServiceEndDate_format_alphanumeric() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC98521_Batch_Claim_ServiceEndDate_format_alphanumeric");
   
		
		logger.log(LogStatus.INFO,"Generating unique parameters file");
	fileUpdateValue=GenerateUniqueParam.ohioclaim_PipeDelimited();
	fileUpdateValue.put(globalVariables.ServiceEndDate,CommonMethods.generateRandomAlphaNumeric(10));
	
	logger.log(LogStatus.INFO,"Creating request and outbound files");
	String fileName = FileContentReader.createPipeDelimFilefileohio(globalVariables.OhioGenericFile,fileUpdateValue,timeStamp);
	fileUpdateValueOutbound.put(fileName, "1");
	String outBoundFileName =FileContentReader.createOutboundFileOhio(fileUpdateValueOutbound,timeStamp,fileUpdateValue.get(globalVariables.batchid));
	
	logger.log(LogStatus.INFO,"Uploading and downloading files");
	finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.getOhioClaimFilePick+fileName);
	fileNames=FileContentReader.putGetFilefromServerOhio(fileName,outBoundFileName,null,timeStamp,fileUpdateValue.get(globalVariables.batchid));


	logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
	List<String> status = new ArrayList<String>();
	status.add(globalVariables.dateformateerror);
	assertionDbVerifier.assertControlFileValidOhio_fail(fileNames,finalMapapdataByRow,timeStamp,fileUpdateValue.get(globalVariables.batchid),status);
    	
    	
	}
	
	@Test(groups = {"All", "Regression"})
	public void TC98521_Batch_Claim_ServiceEndDate_format_null() throws InterruptedException, java.text.ParseException,  Exception{
		
		// logger = extent.startTest("TC98521_Batch_Claim_ServiceEndDate_format_null");
    
		logger.log(LogStatus.INFO,"Generating unique parameters file");
	fileUpdateValue=GenerateUniqueParam.ohioclaim_PipeDelimited();
	fileUpdateValue.put(globalVariables.ServiceEndDate,"NULL");
	
	logger.log(LogStatus.INFO,"Creating request and outbound files");
	String fileName = FileContentReader.createPipeDelimFilefileohio(globalVariables.OhioGenericFile,fileUpdateValue,timeStamp);
	fileUpdateValueOutbound.put(fileName, "1");
	String outBoundFileName =FileContentReader.createOutboundFileOhio(fileUpdateValueOutbound,timeStamp,fileUpdateValue.get(globalVariables.batchid));
	
	logger.log(LogStatus.INFO,"Uploading and downloading files");
	finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.getOhioClaimFilePick+fileName);
	fileNames=FileContentReader.putGetFilefromServerOhio(fileName,outBoundFileName,null,timeStamp,fileUpdateValue.get(globalVariables.batchid));


	logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
	List<String> status = new ArrayList<String>();
	status.add(globalVariables.dateformateerror);
	assertionDbVerifier.assertControlFileValidOhio_fail(fileNames,finalMapapdataByRow,timeStamp,fileUpdateValue.get(globalVariables.batchid),status);
    	
	}

	@Test(groups = {"All", "Regression"})
	public void TC98526_Batch_Claim_servicestart_and_enddate_validation() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC98526_Batch_Claim_servicestart_and_enddate_validation");
    
		logger.log(LogStatus.INFO,"Generating unique parameters file");
    fileUpdateValue=GenerateUniqueParam.ohioclaim_PipeDelimited();
    fileUpdateValue.put(globalVariables.ServiceEndDate,CommonMethods.generateFutureDate_YYYY_MM_dd());
    logger.log(LogStatus.INFO,"Creating request and outbound files");
    String fileName = FileContentReader.createPipeDelimFilefileohio(globalVariables.OhioGenericFile,fileUpdateValue,timeStamp);
	fileUpdateValueOutbound.put(fileName, "1");
	String outBoundFileName =FileContentReader.createOutboundFileOhio(fileUpdateValueOutbound,timeStamp,fileUpdateValue.get(globalVariables.batchid));
	
	logger.log(LogStatus.INFO,"Uploading and downloading files");
	finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.getOhioClaimFilePick+fileName);
	fileNames=FileContentReader.putGetFilefromServerOhio(fileName,outBoundFileName,null,timeStamp,fileUpdateValue.get(globalVariables.batchid));


	logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
	List<String> status = new ArrayList<String>();
	status.add(globalVariables.noVisitError);
	assertionDbVerifier.assertControlFileValidOhio(fileNames,finalMapapdataByRow,timeStamp,fileUpdateValue.get(globalVariables.batchid),status);
    
    
    	
	}
	
	@Test(groups = {"All", "Regression"})
	public void TC98526_Batch_Claim_servicestart_and_enddate_validation_null() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC98526_Batch_Claim_servicestart_and_enddate_blank_validation");
    
		logger.log(LogStatus.INFO,"Generating unique parameters file");
	 fileUpdateValue=GenerateUniqueParam.ohioclaim_PipeDelimited();
	 fileUpdateValue.put(globalVariables.ServiceEndDate,"");
		
	 logger.log(LogStatus.INFO,"Creating request and outbound files");
	 String fileName = FileContentReader.createPipeDelimFilefileohio(globalVariables.OhioGenericFile,fileUpdateValue,timeStamp);
		fileUpdateValueOutbound.put(fileName, "1");
		String outBoundFileName =FileContentReader.createOutboundFileOhio(fileUpdateValueOutbound,timeStamp,fileUpdateValue.get(globalVariables.batchid));
		
		logger.log(LogStatus.INFO,"Uploading and downloading files");
		finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.getOhioClaimFilePick+fileName);
		fileNames=FileContentReader.putGetFilefromServerOhio(fileName,outBoundFileName,null,timeStamp,fileUpdateValue.get(globalVariables.batchid));


		logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
		List<String> status = new ArrayList<String>();
		status.add(globalVariables.noVisitError);
		assertionDbVerifier.assertControlFileValidOhio(fileNames,finalMapapdataByRow,timeStamp,fileUpdateValue.get(globalVariables.batchid),status);
	    
	}

}
