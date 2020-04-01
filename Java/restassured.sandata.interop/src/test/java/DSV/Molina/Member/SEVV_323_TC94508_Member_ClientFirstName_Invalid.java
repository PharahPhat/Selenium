package DSV.Molina.Member;

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

import com.globalMethods.core.Assertion_DbVerifier; public class SEVV_323_TC94508_Member_ClientFirstName_Invalid extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	String timeStamp;  FileContentReader FileContentReader =new FileContentReader(); 

	@BeforeMethod(alwaysRun = true)
	public void tearDown()
	{
		this.timeStamp =CommonMethods.getTimeStamp();	
	
	}

	@Test(enabled = true, groups = {"All"})
	public void SEVV_323_TC94508_Member_ClientFirstName_Blank() throws InterruptedException, java.text.ParseException,  Exception{

		// logger = extent.startTest("SEVV_323_TC94508_Member_ClientFirstName_Blank");
		//////////////Variable declaration ///////////////////
		Map<String ,String> mapUpdateFileData = new HashMap<>();

		Map<String ,String> mapOutboundData = new HashMap<>();
		String FileName;
		List<String> fileNames;
		List<String> Errormessage = new ArrayList<String>();

		logger.log(LogStatus.INFO,"Creating map for removing the required  Field map");
		mapUpdateFileData=GenerateUniqueParam.MemberParams_PipeDelimited();
		mapUpdateFileData.put(globalVariables.molinaClientFirstName, "");
		logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
		FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.molinaGenericFile, mapUpdateFileData,globalVariables.memberGenericFileName,globalVariables.member,timeStamp);

		logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
		mapOutboundData.put(FileName, "1");
		String outboundFileName= FileContentReader.createOutboundFileAndEncrypt(mapOutboundData,timeStamp);

		logger.log(LogStatus.INFO,"process the Files and get the control file ");

		fileNames=FileContentReader.putGetFilefromServer(FileName,outboundFileName,globalVariables.member,timeStamp);

		logger.log(LogStatus.INFO,"Veirfying the ErrorFile generated ");
		Errormessage.add(globalVariables.memberClientFirstNameNullError);
		assertionDbVerifier.assertControlFileInValid(fileNames,FileName,Errormessage, globalVariables.member,timeStamp);


	}

	@Test(enabled = true, groups = {"All"})
	public void SEVV_323_TC94508_Member_ClientFirstName_GreaterThanMax() throws InterruptedException, java.text.ParseException,  Exception{

		// logger = extent.startTest("SEVV_323_TC94508_Member_ClientFirstName_GreaterThanMax");
		//////////////Variable declaration ///////////////////
		Map<String ,String> mapUpdateFileData = new HashMap<>();
		Map<String ,String> mapOutboundData = new HashMap<>();
		String FileName;
		List<String> fileNames;

		List<String> Errormessage = new ArrayList<String>();
		logger.log(LogStatus.INFO,"Creating map for removing the required  Field map");
		mapUpdateFileData=GenerateUniqueParam.MemberParams_PipeDelimited();
		mapUpdateFileData.put(globalVariables.molinaClientFirstName, CommonMethods.generateRandomStringOfFixLength(31));
		logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
		FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.molinaGenericFile, mapUpdateFileData,globalVariables.memberGenericFileName,globalVariables.member,timeStamp);

		logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
		mapOutboundData.put(FileName, "1");
		String outboundFileName= FileContentReader.createOutboundFileAndEncrypt(mapOutboundData,timeStamp);

		logger.log(LogStatus.INFO,"process the Files and get the control file ");

		fileNames=FileContentReader.putGetFilefromServer(FileName,outboundFileName,globalVariables.member,timeStamp);

		logger.log(LogStatus.INFO,"Veirfying the ErrorFile generated ");
		Errormessage.add("The ClientFirstName length is invalid. The length should be between 1 and 30.");
		assertionDbVerifier.assertControlFileInValid(fileNames,FileName,Errormessage, globalVariables.member,timeStamp);


	}


}
