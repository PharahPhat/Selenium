package DSV.PA.Auth;

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

public class SEVV_8615_TC102873_Auth_Some_NonSegement extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
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
	
	@Test(enabled = true, groups = {"All"})
	public void SEVV_8615_TC102873_Auth_Some_NonSegement() throws InterruptedException,  Exception{
		
		// logger = extent.startTest("SEVV_8615_TC102873_Auth_Some_NonSegement");
		
		fileUpdateValue=GenerateUniqueParam.AuthParams_PipeDelimited_PositveValue_Pensyl();
		fileUpdateValue.put("segmentName",null);
		fileUpdateValue.put("authorizationLimit", null);
		fileUpdateValue.put("authorizationWeekStart",  null);
		
		fileUpdateValue.put("clientDiagnosisCodeBeginDate", null);
		fileUpdateValue.put("clientDiagnosisCodeEndDate", null );
		
		
		logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
				FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.molinaAuthGenericFileSegment, fileUpdateValue,globalVariables.memberAuthFileName,globalVariables.auth,timeStamp);

		logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
		mapOutboundData.put(FileName, "1");
		String outboundFileName= FileContentReader.createOutboundFileAndEncrypt(mapOutboundData,timeStamp);

		logger.log(LogStatus.INFO,"process the Files and get the control file ");
		finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
		System.out.println(finalMapapdataByRow);
		fileNames=FileContentReader.putGetFilefromServerSegmentField(FileName,outboundFileName,null,timeStamp);
		
		logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
		assertionDbVerifier.assertControlFileValidSegment(fileNames,FileName,finalMapapdataByRow,outboundFileName,timeStamp);
		
	}
	


}
