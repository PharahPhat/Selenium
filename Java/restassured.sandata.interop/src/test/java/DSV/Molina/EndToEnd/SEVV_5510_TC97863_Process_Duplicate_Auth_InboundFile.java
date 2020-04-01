package DSV.Molina.EndToEnd;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.FileContentReader;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;

public class SEVV_5510_TC97863_Process_Duplicate_Auth_InboundFile extends BaseTest{
	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	Assertion_DbVerifier Assertion_DbVerifier= new Assertion_DbVerifier();
	
	Map<String ,String> fileUpdateValue = new HashMap<>();
	 String fileName;
	//////////////Variable declaration ///////////////////
	Map<String ,String> mapUpdateFileData = new HashMap<>();
	Map<String ,String> finalMapapdataByRow = new HashMap<>();
	Map<String ,String> mapOutboundData = new HashMap<>();
	String FileName;
	List<String> fileNames;
	
	String timeStamp;  FileContentReader FileContentReader =new FileContentReader(); 
	@BeforeMethod(alwaysRun = true)
	public void tearDown()
	{
		 this.timeStamp =CommonMethods.getTimeStamp();	
	  
	}
	
	
	@Test(enabled = true, groups = {"All", "Regression"})
	public void SEVV_5510_TC97863_Process_Duplicate_Auth_InboundFile() throws InterruptedException, java.text.ParseException,  Exception{
		
		// logger = extent.startTest("SEVV_5510_TC97863_Process_Duplicate_Auth_InboundFile");
		
		fileUpdateValue=GenerateUniqueParam.AuthParams_PipeDelimited_PositveValue();
		
		logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
				FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.molinaAuthGenericFile, fileUpdateValue,globalVariables.memberAuthFileName,globalVariables.auth,timeStamp);

		//logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
		mapOutboundData.put(FileName, "1");
		String outboundFileName= FileContentReader.createOutboundFileAndEncrypt(mapOutboundData,timeStamp);

		//logger.log(LogStatus.INFO,"process the Files and get the control file ");
		finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
		fileNames=FileContentReader.putGetFilefromServer(FileName,outboundFileName,null,timeStamp);
		
		//logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
		Assertion_DbVerifier.assertControlFileValid(fileNames,FileName,finalMapapdataByRow,outboundFileName,globalVariables.auth,timeStamp);
		
	}
	


}
