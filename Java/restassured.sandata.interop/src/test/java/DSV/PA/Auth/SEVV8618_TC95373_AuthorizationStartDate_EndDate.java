package DSV.PA.Auth;

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

public class SEVV8618_TC95373_AuthorizationStartDate_EndDate extends BaseTest {
	Map<String ,String> fileUpdateValue = new HashMap<>();
	FileContentReader FileContentReader=new FileContentReader();
	GenerateUniqueParam GenerateUniqueParam =new GenerateUniqueParam();
	Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();



	String fileName;
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
	public void SEVV8618_TC95373_AuthorizationStartDate_EndDate_Valid() throws InterruptedException, java.text.ParseException,  Exception{

		// logger = extent.startTest("SEVV8618_TC95373_AuthorizationStartDate_EndDate_Valid");

		fileUpdateValue=GenerateUniqueParam.AuthParams_PipeDelimited_PositveValue_Pensyl();
		fileUpdateValue.put(globalVariables.authorizationStartDate, CommonMethods.generatePastDate_YYYY_MM_dd() );
		fileUpdateValue.put(globalVariables.authorizationEndDate, CommonMethods.generateTodayDate_YYYY_MM_dd());

		logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
		FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.molinaAuthGenericFileSegment, fileUpdateValue,globalVariables.memberAuthFileName,globalVariables.auth,timeStamp);

		logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
		mapOutboundData.put(FileName, "1");
		String outboundFileName= FileContentReader.createOutboundFileAndEncrypt(mapOutboundData,timeStamp);

		logger.log(LogStatus.INFO,"process the Files and get the control file ");
		finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
		System.out.println(finalMapapdataByRow);
		fileNames=FileContentReader.putGetFilefromServerSegmentField(FileName,outboundFileName,null,timeStamp);
	
		//logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
		assertionDbVerifier.assertControlFileValid(fileNames,FileName,finalMapapdataByRow,outboundFileName,globalVariables.auth,timeStamp);

	}


	@Test(enabled = true, groups = {"All"})
	public void SEVV8618_TC95373_AuthorizationStartDate_EndDate_InValid() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("SEVV8618_TC95373_AuthorizationStartDate_EndDate_InValid");

		//////////////Variable declaration ///////////////////
		Map<String ,String> mapOutboundData = new HashMap<>();
		String FileName;
		Map<String ,String> finalMapapdataByRow = new HashMap<>();
		List<String> fileNames;
		
		List<String> Errormessage = new ArrayList<String>();
		List<String> mapdataByValueNonMandatory = new ArrayList<String>();



		logger.log(LogStatus.INFO,"Creating map for removing the required  Field map");
		fileUpdateValue=GenerateUniqueParam.AuthParams_PipeDelimited_PositveValue_Pensyl();
		fileUpdateValue.put(globalVariables.authorizationStartDate, "201-07-13" );
		fileUpdateValue.put(globalVariables.authorizationEndDate, "90-12-13");

		FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.molinaAuthGenericFileSegment, fileUpdateValue,globalVariables.memberAuthFileName,globalVariables.auth,timeStamp);

		logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
		mapOutboundData.put(FileName, "1");
		String outboundFileName= FileContentReader.createOutboundFileAndEncrypt(mapOutboundData,timeStamp);

		logger.log(LogStatus.INFO,"process the Files and get the control file ");
		finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
		System.out.println(finalMapapdataByRow);
		fileNames=FileContentReader.putGetFilefromServerSegmentField(FileName,outboundFileName,globalVariables.auth,timeStamp);
	

		logger.log(LogStatus.INFO,"Veirfying the ErrorFile generated ");
		Errormessage.add(globalVariables.AuthorizationEndDateError);
		Errormessage.add(globalVariables.AuthorizationStartDateError);
		assertionDbVerifier.assertControlFileInValid(fileNames,FileName,Errormessage,globalVariables.auth,timeStamp );

	}
	@Test(enabled = true, groups = {"All"})
	public void SEVV8618_TC95373_AuthorizationStartDate_EndDate_InValid_Length() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("SEVV8618_TC95373_AuthorizationStartDate_EndDate_InValid_Length");

		//////////////Variable declaration ///////////////////
		Map<String ,String> mapOutboundData = new HashMap<>();
		String FileName;
		Map<String ,String> finalMapapdataByRow = new HashMap<>();
		List<String> fileNames;
		List<String> Errormessage = new ArrayList<String>();
		List<String> mapdataByValueNonMandatory = new ArrayList<String>();



		logger.log(LogStatus.INFO,"Creating map for removing the required  Field map");
		fileUpdateValue=GenerateUniqueParam.AuthParams_PipeDelimited_PositveValue_Pensyl();
		fileUpdateValue.put(globalVariables.authorizationStartDate, "201-07-13" );
		fileUpdateValue.put(globalVariables.authorizationEndDate, "90-12-13");

		logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
		FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.molinaAuthGenericFileSegment, fileUpdateValue,globalVariables.memberAuthFileName,globalVariables.auth,timeStamp);

		logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
		mapOutboundData.put(FileName, "1");
		String outboundFileName= FileContentReader.createOutboundFileAndEncrypt(mapOutboundData,timeStamp);

		logger.log(LogStatus.INFO,"process the Files and get the control file ");
		finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
		System.out.println(finalMapapdataByRow);
		fileNames=FileContentReader.putGetFilefromServerSegmentField(FileName,outboundFileName,globalVariables.auth,timeStamp);
	

		logger.log(LogStatus.INFO,"Veirfying the ErrorFile generated ");
		Errormessage.add(globalVariables.AuthorizationEndDateError);
		Errormessage.add(globalVariables.AuthorizationStartDateError);
		assertionDbVerifier.assertControlFileInValid(fileNames,FileName,Errormessage,globalVariables.auth,timeStamp );

	}
	@Test(enabled = true, groups = {"All"})
	public void SEVV8618_TC95373_AuthorizationStartDate_InValid_Null() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("SEVV8618_TC95373_AuthorizationStartDate_InValid_Null");

		//////////////Variable declaration ///////////////////
		Map<String ,String> mapOutboundData = new HashMap<>();
		String FileName;
		Map<String ,String> finalMapapdataByRow = new HashMap<>();
		List<String> fileNames;
		List<String> Errormessage = new ArrayList<String>();
		List<String> mapdataByValueNonMandatory = new ArrayList<String>();



		logger.log(LogStatus.INFO,"Creating map for removing the required  Field map");
		fileUpdateValue=GenerateUniqueParam.AuthParams_PipeDelimited_PositveValue_Pensyl();
		fileUpdateValue.put(globalVariables.authorizationStartDate, "" );

		logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
		FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.molinaAuthGenericFileSegment, fileUpdateValue,globalVariables.memberAuthFileName,globalVariables.auth,timeStamp);

		logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
		mapOutboundData.put(FileName, "1");
		String outboundFileName= FileContentReader.createOutboundFileAndEncrypt(mapOutboundData,timeStamp);

		logger.log(LogStatus.INFO,"process the Files and get the control file ");
		finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
		System.out.println(finalMapapdataByRow);
		fileNames=FileContentReader.putGetFilefromServerSegmentField(FileName,outboundFileName,globalVariables.auth,timeStamp);
	
		logger.log(LogStatus.INFO,"Veirfying the ErrorFile generated ");
		
		Errormessage.add(globalVariables.AuthorizationStartDateError);
		assertionDbVerifier.assertControlFileInValid(fileNames,FileName,Errormessage,globalVariables.auth,timeStamp );

	}
	
}
