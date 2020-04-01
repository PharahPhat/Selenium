package DSV.Molina.Auth;

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


public class SEVV8617_TC102261_Auth_Required_MultipleEntry extends BaseTest {
	GenerateUniqueParam GenerateUniqueParam =new GenerateUniqueParam();
	Assertion_DbVerifier Assertion_DbVerifier =new Assertion_DbVerifier();
	FileContentReader FileContentReader =new FileContentReader();
	//////////////Variable declaration ///////////////////
	Map<String ,String> mapUpdateFileData = new HashMap<>();
	Map<String ,String> finalMapapdataByRow = new HashMap<>();
	Map<String ,String> mapOutboundData = new HashMap<>();
	Map<String ,String> fileUpdateValue = new HashMap<>();
	String FileName;
	List<String> fileNames;
	String timeStamp; 
	
	@BeforeMethod(alwaysRun = true)
	public void tearDown()
	{
		this.timeStamp =CommonMethods.getTimeStamp();	
		//
	}

	@Test(groups = {"All", "Regression"})
    public void TC102261_Auth_Required_MultipleEntry() throws InterruptedException, java.text.ParseException,  Exception{
		
		// logger = extent.startTest("TC102261_Auth_Required_MultipleEntry");

//////////////Variable declaration ///////////////////
	Map<String ,String> mapOutboundData = new HashMap<>();
	String FileName;

	List<String> fileNames;

	Map<String ,String> mapUpdateFileData = new HashMap<>();
	Map<String ,String> mapUpdateFileData1 = new HashMap<>();
	Map<String ,String> mapUpdateFileData2 = new HashMap<>();
	List<Map<String,String>> mapMultipleEntry=new ArrayList<Map<String,String>>();
	
	
	logger.log(LogStatus.INFO,"Creating map for removing the required  Field map");
	mapUpdateFileData=GenerateUniqueParam.AuthParams_PipeDelimited_PositveValue();
	mapUpdateFileData1=GenerateUniqueParam.AuthParams_PipeDelimited_PositveValue();
	mapUpdateFileData2=GenerateUniqueParam.AuthParams_PipeDelimited_PositveValue();
   
	mapMultipleEntry.add(mapUpdateFileData);
	mapMultipleEntry.add(mapUpdateFileData1);
	mapMultipleEntry.add(mapUpdateFileData2);
      
		logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
		FileName =FileContentReader.createPipeDelimFileAndConvertToGPGMultiple(globalVariables.molinaAuthGenericFile, mapMultipleEntry,globalVariables.memberAuthFileName,globalVariables.auth,timeStamp);


		
		logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
		mapOutboundData.put(FileName, "3");
		String outboundFileName= FileContentReader.createOutboundFileAndEncrypt(mapOutboundData,timeStamp);

		logger.log(LogStatus.INFO,"process the Files and get the control file ");
		finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
		fileNames=FileContentReader.putGetFilefromServer(FileName,outboundFileName,null,timeStamp);

		logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
		for(String filevalue:fileNames){
		if((filevalue).contains("Inbound")){
			System.out.println("-------------Verifying Control File----------");

			Map<String ,String> controlFileData = new HashMap<>();
			controlFileData=	FileContentReader.readFileDataAddToMap(globalVariables.decryptedfileResultTo+filevalue.replace(".gpg", ""));

			CommonMethods.AssertEqualsAndPrintValuesString(FileName+".gpg", controlFileData.get("\"FileName\"").replace("\"", ""), "Processed File Name");
			CommonMethods.AssertEqualsAndPrintValuesString("3", controlFileData.get("\"RecordCount\"").replace("\"", ""), "Total Record Count");
			CommonMethods.AssertEqualsAndPrintValuesString("3", controlFileData.get("\"Success Count\"").replace("\"", ""), "Total Success Count");
			CommonMethods.AssertEqualsAndPrintValuesString("0", controlFileData.get("\"Failed Count\"").replace("\"", ""), "Total Failed Count");
			

		}

	}

}
}
