package DSV.Indiana.member;

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

public class SEVV_7366_TC99744_Indiana_Member_MultipleField_Valid extends BaseTest{
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

	@Test(enabled = true, groups = {"All", "Regression"})
    public void SEVV_7366_TC_99744_Indiana_Member_MultipleField_Valid() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("SEVV_7366_TC_99744_Indiana_Member_MultipleField_Valid");
		Map<String ,String> mapUpdateFileData = new HashMap<>();
		Map<String ,String> mapUpdateFileData1 = new HashMap<>();
		Map<String ,String> mapUpdateFileData2 = new HashMap<>();

		Map<String ,String> mapOutboundData = new HashMap<>();
		List<Map<String,String>> mapMultipleEntry=new ArrayList<Map<String,String>>();
		String FileName;
		List<String> fileNames;

		logger.log(LogStatus.INFO,"Creating map for required Field map");
		mapUpdateFileData=GenerateUniqueParam.MemberParams_PipeDelimited();
		mapUpdateFileData1=GenerateUniqueParam.MemberParams_PipeDelimited();
		mapUpdateFileData2=GenerateUniqueParam.MemberParams_PipeDelimited();
       
		mapMultipleEntry.add(mapUpdateFileData);
		mapMultipleEntry.add(mapUpdateFileData1);
		mapMultipleEntry.add(mapUpdateFileData2);
      
		logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
		FileName =FileContentReader.createPipeDelimFileAndConvertToGPGMultiple(globalVariables.indianaMemberGenericFile, mapMultipleEntry,globalVariables.indianaGenericFileFormat,globalVariables.member,timeStamp);


		
		logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
		mapOutboundData.put(FileName, "3");
		String outboundFileName= FileContentReader.createOutboundFileAndEncryptGeneric(mapOutboundData,timeStamp,globalVariables.indianaGenericFileFormat);

		logger.log(LogStatus.INFO,"process the Files and get the control file ");
		finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
		fileNames=FileContentReader.putGetFilefromServerIndiana(FileName,outboundFileName,null,timeStamp);

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