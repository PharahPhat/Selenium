package DSV.Molina.Provider;

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
public class R2138_TC96253_Verify_Invalid_AgencyEmail_Value extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	
	
	
	List<String> errorMessage =new ArrayList<String>();
	String timeStamp;  FileContentReader FileContentReader =new FileContentReader(); 
	@BeforeMethod(alwaysRun = true)
	public void tearDown()
	{
		 this.timeStamp =CommonMethods.getTimeStamp();	
	  
	}
	
	 @Test(enabled = true, groups = {"All"})

	 public void TC96253_Verify_Invalid_AgencyEmail_Value_morethan_allowed_length() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC96253_Verify_Invalid_AgencyEmail_Value_morethan_allowed_length");
			System.out.println(globalVariables.genericfile+globalVariables.molinaProviderFileName);
			Map<String ,String> fileUpdateValue = new HashMap<>();
			 String fileName;
			//////////////Variable declaration ///////////////////
			Map<String ,String> mapUpdateFileData = new HashMap<>();
			Map<String ,String> finalMapapdataByRow = new HashMap<>();
			Map<String ,String> mapOutboundData = new HashMap<>();
			String FileName;
			List<String> fileNames;
	logger.log(LogStatus.INFO,"Creating map for required Field map");
	fileUpdateValue=GenerateUniqueParam.providerParams_PipeDelimited();
	fileUpdateValue.put(globalVariables.AgencyEmail,CommonMethods.generateEmailAddress_string(65));

	logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
	FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.molinaProviderGenericFile, fileUpdateValue,globalVariables.memberProviderFileName, globalVariables.provider,timeStamp);

	logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
	mapOutboundData.put(FileName, "1");
	String outboundFileName= FileContentReader.createOutboundFileAndEncrypt(mapOutboundData,timeStamp);

	logger.log(LogStatus.INFO,"process the Files and get the control file ");
	finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
	fileNames=FileContentReader.putGetFilefromServer(FileName,outboundFileName,globalVariables.provider,timeStamp);
	
	logger.log(LogStatus.INFO,"Veirfying the ErrorFile generated ");
	errorMessage.add("invalid");
	assertionDbVerifier.assertControlFileInValid(fileNames,FileName,errorMessage, globalVariables.provider,timeStamp);
		
	 }

	 
	
}
