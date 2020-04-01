package DSV.Molina.EndToEnd;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;

import com.globalMethods.core.FileContentReader;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.MYSQL_Database_Verifier;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;

public class SEVV_5510_TC97866_Process_Auth_Provider_InboundFile extends BaseTest

{
	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	Assertion_DbVerifier Assertion_DbVerifier=new Assertion_DbVerifier();
	
	Map<String ,String> fileUpdateValue = new HashMap<>();
	String fileName;
	//////////////Variable declaration ///////////////////
	Map<String ,String> providerUpdateFileData = new HashMap<>();
	Map<String ,String> authUpdateFileData = new HashMap<>();

	Map<String ,String> finalMapapdataByRow = new HashMap<>();
	Map<String ,String> mapOutboundData = new HashMap<>();
	String FileName_provider,FileName_auth, FileName_member;
	List<String> fileNames;

	String timeStamp;  FileContentReader FileContentReader =new FileContentReader(); 
	@BeforeMethod(alwaysRun = true)
	public void tearDown()
	{
		this.timeStamp =CommonMethods.getTimeStamp();	
		
	}

	@Test(enabled = true, groups = {"All", "Regression"})
	public void SEVV_5510_TC97866_Process_Auth_Provider_InboundFile() throws Exception
	{



		// logger = extent.startTest("SEVV_5510_TC97866_Process_Auth_Provider_InboundFile");


		authUpdateFileData=GenerateUniqueParam.AuthParams_PipeDelimited_MaxValue();


		logger.log(LogStatus.INFO,"create the PipeDeliminated File for Auth and Encrypt to GPG");
		FileName_auth =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.molinaAuthGenericFile, fileUpdateValue,globalVariables.memberAuthFileName,globalVariables.auth,timeStamp);

		
		providerUpdateFileData=GenerateUniqueParam.providerParams_PipeDelimited();
	
		logger.log(LogStatus.INFO,"create the PipeDeliminated File for provider and Encrypt to GPG");
		FileName_provider =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.molinaProviderGenericFile, fileUpdateValue,globalVariables.memberProviderFileName, globalVariables.provider,timeStamp);

		logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");

		mapOutboundData.put(FileName_auth, "1");
		mapOutboundData.put(FileName_provider, "1");

		String outboundFileName= FileContentReader.createOutboundFileAndEncrypt(mapOutboundData,timeStamp);

		logger.log(LogStatus.INFO,"process the Files and get the control file ");
		fileNames=FileContentReader.putGetFilefromServer_Control(mapOutboundData,outboundFileName,null,timeStamp);
		Assertion_DbVerifier.verifyInboundFile(fileNames,mapOutboundData,timeStamp);


	}
}

