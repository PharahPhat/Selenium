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

public class SEVV_4799_TC98611_TC98610_98609_Batch_Claim_for_multiple_records extends BaseTest{
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
	timeStamp =CommonMethods.getTimeStamp();	
	FileContentReader.cleanupOHIO();
	}

	@Test(groups = {"All", "Regression"})
    public void TC98611__Batch_Claim_for_multiple_records_valid_with_inound_file_validation() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("SEVV_7366_TC_99744_Indiana_Member_MultipleField_Valid");
		Map<String ,String> mapUpdateFileData = new HashMap<>();
		Map<String ,String> mapUpdateFileData1 = new HashMap<>();
		Map<String ,String> mapUpdateFileData2 = new HashMap<>();
		Map<String ,String> mapOutboundData = new HashMap<>();
		List<Map<String,String>> mapMultipleEntry=new ArrayList<Map<String,String>>();
		String FileName;
		List<String> fileNames;

		logger.log(LogStatus.INFO,"Creating map for required Field map");
		String batchId= CommonMethods.generateRandomNumberOfFixLength(12);
		mapUpdateFileData=GenerateUniqueParam.ohioclaim_PipeDelimited();
		mapUpdateFileData.put(globalVariables.batchid, batchId);
		mapUpdateFileData1=GenerateUniqueParam.ohioclaim_PipeDelimited();
		mapUpdateFileData1.put(globalVariables.batchid, batchId);
		mapUpdateFileData2=GenerateUniqueParam.ohioclaim_PipeDelimited();
		mapUpdateFileData2.put(globalVariables.batchid, batchId);
 
         
		mapMultipleEntry.add(mapUpdateFileData);
		mapMultipleEntry.add(mapUpdateFileData1);
		mapMultipleEntry.add(mapUpdateFileData2);
      
		logger.log(LogStatus.INFO,"Creating request and outbound files");	
		FileName = FileContentReader.createPipeDelimFilefileohioMultiple(globalVariables.OhioGenericFile,mapMultipleEntry,timeStamp,batchId);
		mapOutboundData.put(FileName, "3");
		String outBoundFileName =FileContentReader.createOutboundFileOhio(mapOutboundData,timeStamp,mapUpdateFileData.get(globalVariables.batchid));
		
		logger.log(LogStatus.INFO,"put and get files from server");
		FileContentReader.getFileDataOnMap(globalVariables.getOhioClaimFilePick+FileName);
		fileNames=FileContentReader.putGetFilefromServerOhio(FileName,outBoundFileName,null,timeStamp,mapUpdateFileData.get(globalVariables.batchid));

		String FileName1 = (globalVariables.ohioproductionFileNamegenerated+timeStamp+"_"+batchId+".dsv");
		logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
		for(String filevalue:fileNames){
		if((filevalue).contains("Inbound")){
			System.out.println("-------------Verifying Control File----------");

			Map<String ,String> controlFileData = new HashMap<>();
			controlFileData=	FileContentReader.readFileDataAddToMap(globalVariables.getOhioClaimFileDrop+filevalue.replace(".gpg", ""));


			CommonMethods.AssertEqualsAndPrintValuesString(FileName1, controlFileData.get("\"FileName\"").replace("\"", ""), "Processed File Name");
			CommonMethods.AssertEqualsAndPrintValuesString("3", controlFileData.get("\"RecordCount\"").replace("\"", ""), "Total Record Count");
			CommonMethods.AssertEqualsAndPrintValuesString("3", controlFileData.get("\"Success Count\"").replace("\"", ""), "Total Success Count");
			CommonMethods.AssertEqualsAndPrintValuesString("0", controlFileData.get("\"Failed Count\"").replace("\"", ""), "Total Failed Count");
			

		}
		}
	}

	@Test(groups = {"All", "Regression"})
    public void TC98610__Batch_Claim_for_multiple_records_invalid() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("SEVV_7366_TC_99744_Indiana_Member_MultipleField_Valid");
		Map<String ,String> mapUpdateFileData = new HashMap<>();
		Map<String ,String> mapUpdateFileData1 = new HashMap<>();
		Map<String ,String> mapUpdateFileData2 = new HashMap<>();
		Map<String ,String> mapOutboundData = new HashMap<>();
		List<Map<String,String>> mapMultipleEntry=new ArrayList<Map<String,String>>();
		String FileName;
		List<String> fileNames;

		logger.log(LogStatus.INFO,"Creating map for required Field map");
		String batchId= CommonMethods.generateRandomNumberOfFixLength(12);
		mapUpdateFileData=GenerateUniqueParam.ohioclaim_PipeDelimited();
		mapUpdateFileData.put(globalVariables.batchid, "");
		mapUpdateFileData1=GenerateUniqueParam.ohioclaim_PipeDelimited();
		mapUpdateFileData1.put(globalVariables.batchid, "");
		mapUpdateFileData2=GenerateUniqueParam.ohioclaim_PipeDelimited();
		mapUpdateFileData2.put(globalVariables.batchid, "");
 
         
		mapMultipleEntry.add(mapUpdateFileData);
		mapMultipleEntry.add(mapUpdateFileData1);
		mapMultipleEntry.add(mapUpdateFileData2);
      
		logger.log(LogStatus.INFO,"Creating request and outbound files");	
		FileName = FileContentReader.createPipeDelimFilefileohioMultiple(globalVariables.OhioGenericFile,mapMultipleEntry,timeStamp,batchId);
		mapOutboundData.put(FileName, "3");
		String outBoundFileName =FileContentReader.createOutboundFileOhio(mapOutboundData,timeStamp,mapUpdateFileData.get(globalVariables.batchid));
		
		logger.log(LogStatus.INFO,"put and get files from server");
		FileContentReader.getFileDataOnMap(globalVariables.getOhioClaimFilePick+FileName);
		fileNames=FileContentReader.putGetFilefromServerOhio(FileName,outBoundFileName,null,timeStamp,mapUpdateFileData.get(globalVariables.batchid));


		String FileName1 = (globalVariables.ohioproductionFileNamegenerated+timeStamp+"_"+batchId+".dsv");
		logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
		for(String filevalue:fileNames){
		if((filevalue).contains("Inbound")){
			System.out.println("-------------Verifying Control File----------");

			Map<String ,String> controlFileData = new HashMap<>();
			controlFileData=	FileContentReader.readFileDataAddToMap(globalVariables.getOhioClaimFileDrop+filevalue.replace(".gpg", ""));

	



			CommonMethods.AssertEqualsAndPrintValuesString(FileName1, controlFileData.get("\"FileName\"").replace("\"", ""), "Processed File Name");
			CommonMethods.AssertEqualsAndPrintValuesString("3", controlFileData.get("\"RecordCount\"").replace("\"", ""), "Total Record Count");
			CommonMethods.AssertEqualsAndPrintValuesString("0", controlFileData.get("\"Success Count\"").replace("\"", ""), "Total Success Count");
			CommonMethods.AssertEqualsAndPrintValuesString("3", controlFileData.get("\"Failed Count\"").replace("\"", ""), "Total Failed Count");
			

		}
		}

	}
	
	@Test(groups = {"All", "Regression"})
    public void TC98609__Batch_Claim_for_multiple_records_invalid_valid() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("SEVV_7366_TC_99744_Indiana_Member_MultipleField_Valid");
		Map<String ,String> mapUpdateFileData = new HashMap<>();
		Map<String ,String> mapUpdateFileData1 = new HashMap<>();
		Map<String ,String> mapUpdateFileData2 = new HashMap<>();
		Map<String ,String> mapOutboundData = new HashMap<>();
		List<Map<String,String>> mapMultipleEntry=new ArrayList<Map<String,String>>();
		String FileName;
		List<String> fileNames;

		logger.log(LogStatus.INFO,"Creating map for required Field map");
		String batchId= CommonMethods.generateRandomNumberOfFixLength(12);
		mapUpdateFileData=GenerateUniqueParam.ohioclaim_PipeDelimited();
		mapUpdateFileData.put(globalVariables.batchid, batchId);
		mapUpdateFileData1=GenerateUniqueParam.ohioclaim_PipeDelimited();
		mapUpdateFileData1.put(globalVariables.batchid, "");
		mapUpdateFileData2=GenerateUniqueParam.ohioclaim_PipeDelimited();
		mapUpdateFileData2.put(globalVariables.batchid, batchId);
 
         
		mapMultipleEntry.add(mapUpdateFileData);
		mapMultipleEntry.add(mapUpdateFileData1);
		mapMultipleEntry.add(mapUpdateFileData2);
      
		logger.log(LogStatus.INFO,"Creating request and outbound files");	
		FileName = FileContentReader.createPipeDelimFilefileohioMultiple(globalVariables.OhioGenericFile,mapMultipleEntry,timeStamp,batchId);
		mapOutboundData.put(FileName, "3");
		String outBoundFileName =FileContentReader.createOutboundFileOhio(mapOutboundData,timeStamp,mapUpdateFileData.get(globalVariables.batchid));
		
		logger.log(LogStatus.INFO,"put and get files from server");
		FileContentReader.getFileDataOnMap(globalVariables.getOhioClaimFilePick+FileName);
		fileNames=FileContentReader.putGetFilefromServerOhio(FileName,outBoundFileName,null,timeStamp,mapUpdateFileData.get(globalVariables.batchid));

		String FileName1 = (globalVariables.ohioproductionFileNamegenerated+timeStamp+"_"+batchId+".dsv");
		logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
		for(String filevalue:fileNames){
		if((filevalue).contains("Inbound")){
			System.out.println("-------------Verifying Control File----------");

			Map<String ,String> controlFileData = new HashMap<>();
			controlFileData=	FileContentReader.readFileDataAddToMap(globalVariables.getOhioClaimFileDrop+filevalue.replace(".gpg", ""));

			CommonMethods.AssertEqualsAndPrintValuesString(FileName1, controlFileData.get("\"FileName\"").replace("\"", ""), "Processed File Name");
			CommonMethods.AssertEqualsAndPrintValuesString("3", controlFileData.get("\"RecordCount\"").replace("\"", ""), "Total Record Count");
			CommonMethods.AssertEqualsAndPrintValuesString("2", controlFileData.get("\"Success Count\"").replace("\"", ""), "Total Success Count");
			CommonMethods.AssertEqualsAndPrintValuesString("1", controlFileData.get("\"Failed Count\"").replace("\"", ""), "Total Failed Count");
			

		}
		}
	}
}
