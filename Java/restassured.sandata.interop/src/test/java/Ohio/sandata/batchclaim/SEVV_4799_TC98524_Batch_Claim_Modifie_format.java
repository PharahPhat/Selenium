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

import com.globalMethods.core.Assertion_DbVerifier; public class SEVV_4799_TC98524_Batch_Claim_Modifie_format extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	
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
	public void TC98524_Batch_Claim_Modifie_format_invalid_value() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC98525_Batch_Claim_unitbased_get_error_if_unique_fileds_invalid_with_wrong_businnesmedicaidid");
		logger.log(LogStatus.INFO,"Creating unique parameters for claim file");	
	fileUpdateValue=GenerateUniqueParam.ohioclaim_PipeDelimited();
	fileUpdateValue.put(globalVariables.dbModifier1,"TC");
	
	logger.log(LogStatus.INFO,"Creating request and outbound files");	
	String fileName = FileContentReader.createPipeDelimFilefileohio(globalVariables.OhioGenericFile,fileUpdateValue,timeStamp);
	fileUpdateValueOutbound.put(fileName, "1");
	String outBoundFileName =FileContentReader.createOutboundFileOhio(fileUpdateValueOutbound,timeStamp,fileUpdateValue.get(globalVariables.batchid));
	
	logger.log(LogStatus.INFO,"put and get files from server");
	finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.getOhioClaimFilePick+fileName);
	fileNames=FileContentReader.putGetFilefromServerOhio(fileName,outBoundFileName,null,timeStamp,fileUpdateValue.get(globalVariables.batchid));


	logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
	List<String> status = new ArrayList<String>();
	status.add(globalVariables.noVisitError);
	assertionDbVerifier.assertControlFileValidOhio(fileNames,finalMapapdataByRow,timeStamp,fileUpdateValue.get(globalVariables.batchid),status);
    	
    
    	
	}
	
	@Test(groups = {"All", "Regression"})
	public void TC98524_Batch_Claim_Modifie_format_invalid_value_blank() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC98524_Batch_Claim_Modifie_format_invalid_value_blank");
    
		logger.log(LogStatus.INFO,"Creating unique parameters for claim file");
	fileUpdateValue=GenerateUniqueParam.ohioclaim_PipeDelimited();
	fileUpdateValue.put(globalVariables.dbModifier1,"");
	
	logger.log(LogStatus.INFO,"Creating request and outbound files");	
	String fileName = FileContentReader.createPipeDelimFilefileohio(globalVariables.OhioGenericFile,fileUpdateValue,timeStamp);
	fileUpdateValueOutbound.put(fileName, "1");
	String outBoundFileName =FileContentReader.createOutboundFileOhio(fileUpdateValueOutbound,timeStamp,fileUpdateValue.get(globalVariables.batchid));
	
	logger.log(LogStatus.INFO,"put and get files from server");
	finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.getOhioClaimFilePick+fileName);
	fileNames=FileContentReader.putGetFilefromServerOhio(fileName,outBoundFileName,null,timeStamp,fileUpdateValue.get(globalVariables.batchid));


	logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
	List<String> status = new ArrayList<String>();
	status.add(globalVariables.noVisitError);
	assertionDbVerifier.assertControlFileValidOhio(fileNames,finalMapapdataByRow,timeStamp,fileUpdateValue.get(globalVariables.batchid),status);
    	
    	
	}

	@Test(groups = {"All", "Regression"})
	public void TC98524_Batch_Claim_Modifie_format_invalid_value_numeric() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC98524_Batch_Claim_Modifie_format_invalid_value_numeric");
    
		logger.log(LogStatus.INFO,"Creating unique parameters for claim file");
	fileUpdateValue=GenerateUniqueParam.ohioclaim_PipeDelimited();
	fileUpdateValue.put(globalVariables.dbModifier1,CommonMethods.generateRandomNumberOfFixLength(2));
	
	logger.log(LogStatus.INFO,"Creating request and outbound files");
	String fileName = FileContentReader.createPipeDelimFilefileohio(globalVariables.OhioGenericFile,fileUpdateValue,timeStamp);
	fileUpdateValueOutbound.put(fileName, "1");
	String outBoundFileName =FileContentReader.createOutboundFileOhio(fileUpdateValueOutbound,timeStamp,fileUpdateValue.get(globalVariables.batchid));
	
	logger.log(LogStatus.INFO,"put and get files from server");
	finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.getOhioClaimFilePick+fileName);
	fileNames=FileContentReader.putGetFilefromServerOhio(fileName,outBoundFileName,null,timeStamp,fileUpdateValue.get(globalVariables.batchid));


	logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
	List<String> status = new ArrayList<String>();
	status.add(globalVariables.noVisitError);
	assertionDbVerifier.assertControlFileValidOhio(fileNames,finalMapapdataByRow,timeStamp,fileUpdateValue.get(globalVariables.batchid),status);
    	
    	
	}
	
	@Test(groups = {"All", "Regression"})
	public void TC98524_Batch_Claim_Modifie_format_invalid_value_alphanumeric() throws InterruptedException, java.text.ParseException,  Exception{
		
		// logger = extent.startTest("TC98524_Batch_Claim_Modifie_format_invalid_value_alphanumeric");
    
		logger.log(LogStatus.INFO,"Creating unique parameters for claim file");
	fileUpdateValue=GenerateUniqueParam.ohioclaim_PipeDelimited();
	fileUpdateValue.put(globalVariables.dbModifier1,CommonMethods.generateRandomAlphaNumeric(2));
	
	logger.log(LogStatus.INFO,"Creating request and outbound files");
	String fileName = FileContentReader.createPipeDelimFilefileohio(globalVariables.OhioGenericFile,fileUpdateValue,timeStamp);
	fileUpdateValueOutbound.put(fileName, "1");
	String outBoundFileName =FileContentReader.createOutboundFileOhio(fileUpdateValueOutbound,timeStamp,fileUpdateValue.get(globalVariables.batchid));
	
	logger.log(LogStatus.INFO,"put and get files from server");
	finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.getOhioClaimFilePick+fileName);
	fileNames=FileContentReader.putGetFilefromServerOhio(fileName,outBoundFileName,null,timeStamp,fileUpdateValue.get(globalVariables.batchid));


	logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
	List<String> status = new ArrayList<String>();
	status.add(globalVariables.noVisitError);
	assertionDbVerifier.assertControlFileValidOhio(fileNames,finalMapapdataByRow,timeStamp,fileUpdateValue.get(globalVariables.batchid),status);
    	
	}
	
	@Test(groups = {"All", "Regression"})
	public void TC98524_Batch_Claim_Modifie_format_invalid_value_specialcharacter() throws InterruptedException, java.text.ParseException,  Exception{
		
		// logger = extent.startTest("TC98524_Batch_Claim_Modifie_format_invalid_value_specialcharacter");
    
	fileUpdateValue=GenerateUniqueParam.ohioclaim_PipeDelimited();
	fileUpdateValue.put(globalVariables.dbModifier1,CommonMethods.generateSpecialChar(2));
	String fileName = FileContentReader.createPipeDelimFilefileohio(globalVariables.OhioGenericFile,fileUpdateValue,timeStamp);
	fileUpdateValueOutbound.put(fileName, "1");
	String outBoundFileName =FileContentReader.createOutboundFileOhio(fileUpdateValueOutbound,timeStamp,fileUpdateValue.get(globalVariables.batchid));
	finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.getOhioClaimFilePick+fileName);
	fileNames=FileContentReader.putGetFilefromServerOhio(fileName,outBoundFileName,null,timeStamp,fileUpdateValue.get(globalVariables.batchid));

	logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
	List<String> status = new ArrayList<String>();
	status.add(globalVariables.noVisitError);
	assertionDbVerifier.assertControlFileValidOhio(fileNames,finalMapapdataByRow,timeStamp,fileUpdateValue.get(globalVariables.batchid),status);
	}
    
}
