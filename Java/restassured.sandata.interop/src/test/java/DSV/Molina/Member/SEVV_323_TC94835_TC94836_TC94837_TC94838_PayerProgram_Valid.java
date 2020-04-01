package DSV.Molina.Member;

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

public class SEVV_323_TC94835_TC94836_TC94837_TC94838_PayerProgram_Valid extends BaseTest {
	FileContentReader FileContentReader =new FileContentReader();
	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	Assertion_DbVerifier Assertion_DbVerifier= new Assertion_DbVerifier();
	

	//////////////Variable declaration ///////////////////
	Map<String ,String> mapUpdateFileData = new HashMap<>();
	Map<String ,String> finalMapapdataByRow = new HashMap<>();
	Map<String ,String> mapOutboundData = new HashMap<>();
	String FileName;
	List<String> fileNames;

	String timeStamp; 
	@BeforeMethod(alwaysRun = true)
	public void tearDown()
	{
		this.timeStamp =CommonMethods.getTimeStamp();	
	
	}
	@Test(enabled = true, groups = {"All"})
	public void SEVV_323_TC94835_PayerProgram_Valid_LeadingSpace() throws Exception{
		// logger = extent.startTest("SEVV_323_TC94835_PayerProgram_Valid_LeadingSpace");
			//////////////Variable declaration ///////////////////
		
			
			logger.log(LogStatus.INFO,"Creating map for required Field map");
			mapUpdateFileData=GenerateUniqueParam.MemberParams_PipeDelimited();
			mapUpdateFileData.put("payerProgram", " "+CommonMethods.generateRandomNumberOfFixLength(9));

			logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
			FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.molinaGenericFile, mapUpdateFileData,globalVariables.memberGenericFileName,globalVariables.member,timeStamp);

			logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
			mapOutboundData.put(FileName, "1");
			String outboundFileName= FileContentReader.createOutboundFileAndEncrypt(mapOutboundData,timeStamp);

			logger.log(LogStatus.INFO,"process the Files and get the control file ");
			finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
			fileNames=FileContentReader.putGetFilefromServer(FileName,outboundFileName,null,timeStamp);

			logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
			Assertion_DbVerifier.assertControlFileValid(fileNames,FileName,finalMapapdataByRow,outboundFileName,globalVariables.member,timeStamp);

		}
		@Test(enabled = true, groups = {"All"})
		public void SEVV_323_TC94836_PayerProgram_Valid_LeadingSpaceleading_Trailing_space() throws InterruptedException, java.text.ParseException,  Exception{
			// logger = extent.startTest("SEVV_323_TC94836_PayerProgram_Valid_LeadingSpaceleading_Trailing_space");
			
			logger.log(LogStatus.INFO,"Creating map for required Field map");
			mapUpdateFileData=GenerateUniqueParam.MemberParams_PipeDelimited();
			mapUpdateFileData.put("payerProgram", CommonMethods.generateRandomNumberOfFixLength(9)+"  ");

			logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
			FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.molinaGenericFile, mapUpdateFileData,globalVariables.memberGenericFileName,globalVariables.member,timeStamp);

			logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
			mapOutboundData.put(FileName, "1");
			String outboundFileName= FileContentReader.createOutboundFileAndEncrypt(mapOutboundData,timeStamp);

			logger.log(LogStatus.INFO,"process the Files and get the control file ");
			finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
			fileNames=FileContentReader.putGetFilefromServer(FileName,outboundFileName,null,timeStamp);

			logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
			Assertion_DbVerifier.assertControlFileValid(fileNames,FileName,finalMapapdataByRow,outboundFileName,globalVariables.member,timeStamp);
		}
		@Test(enabled = true, groups = {"All"})
		public void SEVV_323_TC94837_PayerProgram_leading_Trailing_space_Between_space () throws InterruptedException, java.text.ParseException,  Exception{
			// logger = extent.startTest("SEVV_323_TC94837_PayerProgram_leading_Trailing_space_Between_space ");
			
			logger.log(LogStatus.INFO,"Creating map for required Field map");
			mapUpdateFileData=GenerateUniqueParam.MemberParams_PipeDelimited();
			mapUpdateFileData.put("payerProgram", CommonMethods.generateRandomNumberOfFixLength(2)+"  "+CommonMethods.generateRandomNumberOfFixLength(2));
			logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
			FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.molinaGenericFile, mapUpdateFileData,globalVariables.memberGenericFileName,globalVariables.member,timeStamp);

			logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
			mapOutboundData.put(FileName, "1");
			String outboundFileName= FileContentReader.createOutboundFileAndEncrypt(mapOutboundData,timeStamp);

			logger.log(LogStatus.INFO,"process the Files and get the control file ");
			finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
			fileNames=FileContentReader.putGetFilefromServer(FileName,outboundFileName,null,timeStamp);

			logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
			Assertion_DbVerifier.assertControlFileValid(fileNames,FileName,finalMapapdataByRow,outboundFileName,globalVariables.member,timeStamp);

		}
		@Test(enabled = true, groups = {"All", "Regression"})
		public void SEVV_323_TC94838_PayerProgram_valid_Null() throws InterruptedException, java.text.ParseException,  Exception{
			// logger = extent.startTest("SEVV_323_TC94838_PayerProgram_valid_Null");
				logger.log(LogStatus.INFO,"Creating map for required Field map");
			mapUpdateFileData=GenerateUniqueParam.MemberParams_PipeDelimited();
			mapUpdateFileData.put("payerProgram", null);
			logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
			FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.molinaGenericFile, mapUpdateFileData,globalVariables.memberGenericFileName,globalVariables.member,timeStamp);

			logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
			mapOutboundData.put(FileName, "1");
			String outboundFileName= FileContentReader.createOutboundFileAndEncrypt(mapOutboundData,timeStamp);

			logger.log(LogStatus.INFO,"process the Files and get the control file ");
			finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
			fileNames=FileContentReader.putGetFilefromServer(FileName,outboundFileName,null,timeStamp);

			logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
			Assertion_DbVerifier.assertControlFileValid(fileNames,FileName,finalMapapdataByRow,outboundFileName,globalVariables.member,timeStamp);

		}

	
}
