package DSV.Molina.Member;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class SEVV323_SEVV8612_TC101709_TC101711_TC94435_Member_Missing_RequiredField extends BaseTest {
	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); 
	Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	String timeStamp;  FileContentReader FileContentReader =new FileContentReader(); 
	@BeforeMethod(alwaysRun = true)
	public void tearDown()
	{
		 this.timeStamp =CommonMethods.getTimeStamp();	
	 
	}
	//Inter-Op - Molina - Member: Missing Required Fields
	@Test(enabled = true, groups = {"All"})
	public void SEVV323_SEVV8612_TC101709_TC94435_Member_Missing_RequiredField() throws Exception{
		// logger = extent.startTest("SEVV323_SEVV8612_TC101709_TC94435_Member_Missing_RequiredField");

		//////////////Variable declaration ///////////////////
		Map<String ,String> mapOutboundData = new HashMap<>();
		String FileName;
		List<String> fileNames;
		List<String> mapdataByValue;
		List<String> Errormessage;
		logger.log(LogStatus.INFO,"Creating map for removing the required  Field map");
		mapdataByValue=GenerateUniqueParam.MemberParams_PipeDelimited_Missing_RequiredField();

		logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
		FileName =FileContentReader.createPipeDelimFileAndConvertToGPGWithRemovalField(globalVariables.molinaGenericFile,mapdataByValue,globalVariables.member, timeStamp);

		logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
		mapOutboundData.put(FileName, "1");
		String outboundFileName= FileContentReader.createOutboundFileAndEncrypt(mapOutboundData,timeStamp);

		logger.log(LogStatus.INFO,"process the Files and get the control file ");
		fileNames=FileContentReader.putGetFilefromServer(FileName,outboundFileName,globalVariables.member,timeStamp);
		
		
		logger.log(LogStatus.INFO,"Veirfying the ErrorFile generated ");
		Errormessage=CommonMethods.getMemberErrorMessageForMissingRequiredField();
		assertionDbVerifier.assertControlFileInValid(fileNames,FileName,Errormessage,globalVariables.member,timeStamp );

	}


}
