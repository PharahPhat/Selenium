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

public class SEVV_323_TC94839_PayerProgram_InValid extends BaseTest {

	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier Assertion_DbVerifier= new Assertion_DbVerifier();
	private FileContentReader FileContentReader =new FileContentReader();

	String timeStamp;
	@BeforeMethod(alwaysRun = true)
	public void tearDown()
	{
		this.timeStamp =CommonMethods.getTimeStamp();	
		
	}
	@Test(enabled = true, groups = {"All", "Regression"})
	public void SEVV_323_TC94662_ClientSSN_InValid_Alphabet() throws Exception{
		// logger = extent.startTest("SEVV_323_TC94662_ClientSSN_InValid_Alphabet");
		//////////////Variable declaration ///////////////////
		Map<String ,String> mapUpdateFileData;
		Map<String ,String> mapOutboundData = new HashMap<>();
		String FileName;
		List<String> fileNames;
	
		List<String> Errormessage = new ArrayList<String>();

		logger.log(LogStatus.INFO,"Creating map for required Field map");
		mapUpdateFileData=GenerateUniqueParam.MemberParams_PipeDelimited();
		mapUpdateFileData.put("payerProgram", CommonMethods.generateRandomAlphaNumeric(10));
	
		
		logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
		FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.molinaGenericFile, mapUpdateFileData,globalVariables.memberGenericFileName,globalVariables.member,timeStamp);

		logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
		mapOutboundData.put(FileName, "1");
		String outboundFileName= FileContentReader.createOutboundFileAndEncrypt(mapOutboundData,timeStamp);

		logger.log(LogStatus.INFO,"process the Files and get the control file ");

		fileNames=FileContentReader.putGetFilefromServer(FileName,outboundFileName,globalVariables.member,timeStamp);

		logger.log(LogStatus.INFO,"Veirfying the ErrorFile generated ");
		Errormessage.add("The PayerProgram value is incorrect. The length should be between 0 and 9");
		Assertion_DbVerifier.assertControlFileInValid(fileNames,FileName,Errormessage, globalVariables.member,timeStamp);
	}
	
}
