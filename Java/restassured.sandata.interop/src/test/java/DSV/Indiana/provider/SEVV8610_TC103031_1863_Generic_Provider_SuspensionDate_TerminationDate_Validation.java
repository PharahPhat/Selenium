package DSV.Indiana.provider;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SEVV8610_TC103031_1863_Generic_Provider_SuspensionDate_TerminationDate_Validation extends BaseTest {

	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	Assertion_DbVerifier Assertion_DbVerifier=new Assertion_DbVerifier();

	Map<String ,String> fileUpdateValue = new HashMap<>();
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

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC103031_Generic_Provider_SuspensionDate_TerminationDate_null() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC103031_Generic_Provider_SuspensionDate_TerminationDate_null");

		logger.log(LogStatus.INFO,"Creating map for required Field map");
		fileUpdateValue=GenerateUniqueParam.providerParams_PipeDelimited();

		fileUpdateValue.put(globalVariables.SuspensionDate,null);
		fileUpdateValue.put(globalVariables.TerminationDate,null);

		logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
		FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.indianaProviderGenericFile, fileUpdateValue,globalVariables.indianaGenericFileFormat, globalVariables.provider,timeStamp);

		logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
		mapOutboundData.put(FileName, "1");
		String outboundFileName= FileContentReader.createOutboundFileAndEncryptGeneric(mapOutboundData,timeStamp,globalVariables.indianaGenericFileFormat);

		logger.log(LogStatus.INFO,"process the Files and get the control file ");
		finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
		fileNames=FileContentReader.putGetFilefromServerIndiana(FileName,outboundFileName,null,timeStamp);

		logger.log(LogStatus.INFO,"Verifying the value in Db and control File dat");
		Assertion_DbVerifier.assertControlFileValidindiana(fileNames,FileName,finalMapapdataByRow,outboundFileName,globalVariables.provider,timeStamp);

	}

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC103031_Generic_Provider_SuspensionDate_TerminationDate_valid() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC103031_Generic_Provider_SuspensionDate_TerminationDate_valid");

		logger.log(LogStatus.INFO,"Creating map for required Field map");
		fileUpdateValue=GenerateUniqueParam.providerParams_PipeDelimited();

		fileUpdateValue.put(globalVariables.SuspensionDate,CommonMethods.genFutureDate_YYYY_MM_dd(350));
		fileUpdateValue.put(globalVariables.TerminationDate,CommonMethods.genFutureDate_YYYY_MM_dd(360));

		logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
		FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.indianaProviderGenericFile, fileUpdateValue,globalVariables.indianaGenericFileFormat, globalVariables.provider,timeStamp);

		logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
		mapOutboundData.put(FileName, "1");
		String outboundFileName= FileContentReader.createOutboundFileAndEncryptGeneric(mapOutboundData,timeStamp,globalVariables.indianaGenericFileFormat);

		logger.log(LogStatus.INFO,"process the Files and get the control file ");
		finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
		fileNames=FileContentReader.putGetFilefromServerIndiana(FileName,outboundFileName,null,timeStamp);

		logger.log(LogStatus.INFO,"Verifying the value in Db and control File dat");
		Assertion_DbVerifier.assertControlFileValidindiana(fileNames,FileName,finalMapapdataByRow,outboundFileName,globalVariables.provider,timeStamp);

	}

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC103031_Generic_Provider_SuspensionDate_TerminationDate_invalid_mmddyyyy() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC103031_Generic_Provider_SuspensionDate_TerminationDate_invalid_mmddyyyy");

		logger.log(LogStatus.INFO,"Creating map for required Field map");
		fileUpdateValue=GenerateUniqueParam.providerParams_PipeDelimited();

		fileUpdateValue.put(globalVariables.SuspensionDate,"01/01/2020");
		fileUpdateValue.put(globalVariables.TerminationDate,"01/10/2020");

		logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
		FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.indianaProviderGenericFile, fileUpdateValue,globalVariables.indianaGenericFileFormat, globalVariables.provider,timeStamp);

		logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
		mapOutboundData.put(FileName, "1");
		String outboundFileName= FileContentReader.createOutboundFileAndEncryptGeneric(mapOutboundData,timeStamp,globalVariables.indianaGenericFileFormat);

		logger.log(LogStatus.INFO,"process the Files and get the control file ");
		finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
		fileNames=FileContentReader.putGetFilefromServerIndiana(FileName,outboundFileName,null,timeStamp);

		logger.log(LogStatus.INFO,"Verifying the value in Db and control File dat");
		Assertion_DbVerifier.assertControlFileValidindiana(fileNames,FileName,finalMapapdataByRow,outboundFileName,globalVariables.provider,timeStamp);

	}

}
