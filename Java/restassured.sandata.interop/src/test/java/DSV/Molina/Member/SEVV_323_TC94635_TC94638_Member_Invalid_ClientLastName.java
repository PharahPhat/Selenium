
package DSV.Molina.Member;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SEVV_323_TC94635_TC94638_Member_Invalid_ClientLastName extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	String timeStamp;  
	FileContentReader FileContentReader =new FileContentReader();
	@BeforeMethod(alwaysRun = true)
	public void tearDown()
	{
		this.timeStamp=CommonMethods.getTimeStamp();
	
	}
	@Test(enabled = true, groups = {"All"})
	public void SEVV_323_TC94635_Member_Invalid_ClientLastName_greater_Max() throws InterruptedException, java.text.ParseException,  Exception{
		//////////////Variable declaration ///////////////////
		Map<String ,String> mapUpdateFileData = new HashMap<>();
		Map<String ,String> finalMapapdataByRow = new HashMap<>();
		Map<String ,String> mapOutboundData = new HashMap<>();
		String FileName;
		List<String> fileNames;

		List<String> Errormessage = new ArrayList<String>();
		// logger = extent.startTest("SEVV_323_TC94635_Member_Invalid_ClientLastName_greater_Max");

		logger.log(LogStatus.INFO,"Creating map for removing the required  Field map");
		
		mapUpdateFileData=GenerateUniqueParam.MemberParams_PipeDelimited();
		mapUpdateFileData.put(globalVariables.molinaClientLastName,  CommonMethods.generateRandomStringOfFixLength(31));
		logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
		FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.molinaGenericFile, mapUpdateFileData,globalVariables.memberGenericFileName,globalVariables.member,timeStamp);


		logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
		mapOutboundData.put(FileName, "1");
		String outboundFileName= FileContentReader.createOutboundFileAndEncrypt(mapOutboundData,timeStamp);

		logger.log(LogStatus.INFO,"process the Files and get the control file ");
		finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
		fileNames=FileContentReader.putGetFilefromServer(FileName,outboundFileName,globalVariables.member,timeStamp);

		logger.log(LogStatus.INFO,"Veirfying the ErrorFile generated ");
		Errormessage.add(globalVariables.memberClientLastNameLengthError);
		assertionDbVerifier.assertControlFileInValid(fileNames,FileName,Errormessage, globalVariables.member,timeStamp);
	}
	@Test(enabled = true, groups = {"All"})
	public void SEVV_323_TC94638_Member_ClientLastName_blank () throws Exception{
		//////////////Variable declaration ///////////////////
		Map<String ,String> mapUpdateFileData;
		Map<String ,String> mapOutboundData = new HashMap<>();
		String FileName;
		List<String> fileNames;

		List<String> Errormessage = new ArrayList<>();
		
		
		mapUpdateFileData=GenerateUniqueParam.MemberParams_PipeDelimited();
		mapUpdateFileData.put(globalVariables.molinaClientLastName,  " ");
		logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
		FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.molinaGenericFile, mapUpdateFileData,globalVariables.memberGenericFileName,globalVariables.member,timeStamp);


		logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
		mapOutboundData.put(FileName, "1");
		String outboundFileName= FileContentReader.createOutboundFileAndEncrypt(mapOutboundData,timeStamp);

		logger.log(LogStatus.INFO,"process the Files and get the control file ");
		fileNames=FileContentReader.putGetFilefromServer(FileName,outboundFileName,globalVariables.member,timeStamp);

		logger.log(LogStatus.INFO,"Veirfying the ErrorFile generated ");
		Errormessage.add(globalVariables.memberClientLastNameNotNull1);
		assertionDbVerifier.assertControlFileInValid(fileNames,FileName,Errormessage, globalVariables.member,timeStamp);
	}

}

