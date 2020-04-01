package DSV.Molina.Auth;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SEVV_360_TC94309_Auth_Maximum_Value extends BaseTest {
	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
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

	@Test(groups = {"All"})
	public void SEVV_360_TC94309_Auth_Maximum_Value_valid() throws Exception{

		// logger = extent.startTest("SEVV_360_TC94309_Auth_Maximum_Value_valid");

		fileUpdateValue=GenerateUniqueParam.AuthParams_PipeDelimited_MaxValue();

		logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
		FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.molinaAuthGenericFile, fileUpdateValue,globalVariables.memberAuthFileName,globalVariables.auth,timeStamp);

		//logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
		mapOutboundData.put(FileName, "1");
		String outboundFileName= FileContentReader.createOutboundFileAndEncrypt(mapOutboundData,timeStamp);

		//logger.log(LogStatus.INFO,"process the Files and get the control file ");
		finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
		fileNames=FileContentReader.putGetFilefromServer(FileName,outboundFileName,null,timeStamp);

		//logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
		assertionDbVerifier.assertControlFileValid(fileNames,FileName,finalMapapdataByRow,outboundFileName,globalVariables.auth,timeStamp);

	}



}