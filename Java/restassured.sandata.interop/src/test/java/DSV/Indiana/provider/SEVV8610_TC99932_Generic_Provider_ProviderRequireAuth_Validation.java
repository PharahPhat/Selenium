package DSV.Indiana.provider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.FileContentReader;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;

public class SEVV8610_TC99932_Generic_Provider_ProviderRequireAuth_Validation extends BaseTest{

	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	Assertion_DbVerifier Assertion_DbVerifier=new Assertion_DbVerifier();

	
	String timeStamp;  FileContentReader FileContentReader =new FileContentReader();
	
	@BeforeMethod(alwaysRun = true)
	public void tearDown()
	{
		this.timeStamp =CommonMethods.getTimeStamp();	

	}

	@Test(enabled = true, groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void SEVV8610_TC99932_Generic_Provider_ProviderRequireAuth_1() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("SEVV8610_TC99932_Generic_Provider_ProviderRequireAuth_1");
		Map<String ,String> fileUpdateValue = new HashMap<>();
		String fileName;
		//////////////Variable declaration ///////////////////
		Map<String ,String> mapUpdateFileData = new HashMap<>();
		Map<String ,String> finalMapapdataByRow = new HashMap<>();
		Map<String ,String> mapOutboundData = new HashMap<>();
		List<String> Errormessage = new ArrayList<String>();
		String FileName;
		List<String> fileNames;
		logger.log(LogStatus.INFO,"Creating map for required Field map");
		fileUpdateValue=GenerateUniqueParam.providerParams_PipeDelimited();

		fileUpdateValue.put(globalVariables.ProviderRequireAuth,"1");

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

	@Test(enabled = true, groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void SEVV8610_TC99932_Generic_Provider_ProviderRequireAuth_0() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("SEVV8610_TC99932_Generic_Provider_ProviderRequireAuth_1");
		Map<String ,String> fileUpdateValue = new HashMap<>();
		String fileName;
		//////////////Variable declaration ///////////////////
		Map<String ,String> mapUpdateFileData = new HashMap<>();
		Map<String ,String> finalMapapdataByRow = new HashMap<>();
		Map<String ,String> mapOutboundData = new HashMap<>();
		List<String> Errormessage = new ArrayList<String>();
		String FileName;
		List<String> fileNames;
		logger.log(LogStatus.INFO,"Creating map for required Field map");
		fileUpdateValue=GenerateUniqueParam.providerParams_PipeDelimited();

		fileUpdateValue.put(globalVariables.ProviderRequireAuth,"0");

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

	@Test(enabled = true, groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void SEVV8610_TC99932_Generic_Provider_ProviderRequireAuth_2() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("SEVV8610_TC99932_Generic_Provider_ProviderRequireAuth_1");
		Map<String ,String> fileUpdateValue = new HashMap<>();
		String fileName;
		//////////////Variable declaration ///////////////////
		Map<String ,String> mapUpdateFileData = new HashMap<>();
		Map<String ,String> finalMapapdataByRow = new HashMap<>();
		Map<String ,String> mapOutboundData = new HashMap<>();
		List<String> Errormessage = new ArrayList<String>();
		String FileName;
		List<String> fileNames;
		logger.log(LogStatus.INFO,"Creating map for required Field map");
		fileUpdateValue=GenerateUniqueParam.providerParams_PipeDelimited();

		fileUpdateValue.put(globalVariables.ProviderRequireAuth,"2");

		logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
		FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.indianaProviderGenericFile, fileUpdateValue,globalVariables.indianaGenericFileFormat, globalVariables.provider,timeStamp);

		logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
		mapOutboundData.put(FileName, "1");
		String outboundFileName= FileContentReader.createOutboundFileAndEncryptGeneric(mapOutboundData,timeStamp,globalVariables.indianaGenericFileFormat);

		logger.log(LogStatus.INFO,"process the Files and get the control file ");
		finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
		fileNames=FileContentReader.putGetFilefromServerIndiana(FileName,outboundFileName,null,timeStamp);

		logger.log(LogStatus.INFO,"Verifying the value in Db and control File dat");
		Errormessage.add(globalVariables.ProviderRequireAuthFormatError);
		Assertion_DbVerifier.assertControlFileInValidindiana(fileNames,FileName,Errormessage,globalVariables.provider,timeStamp);

	}

	@Test(enabled = true, groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void SEVV8610_TC99932_Generic_Provider_ProviderRequireAuth_blank() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("SEVV8610_TC99932_Generic_Provider_ProviderRequireAuth_1");
		Map<String ,String> fileUpdateValue = new HashMap<>();
		String fileName;
		//////////////Variable declaration ///////////////////
		Map<String ,String> mapUpdateFileData = new HashMap<>();
		Map<String ,String> finalMapapdataByRow = new HashMap<>();
		Map<String ,String> mapOutboundData = new HashMap<>();
		List<String> Errormessage = new ArrayList<String>();
		String FileName;
		List<String> fileNames;
		logger.log(LogStatus.INFO,"Creating map for required Field map");
		fileUpdateValue=GenerateUniqueParam.providerParams_PipeDelimited();

		fileUpdateValue.put(globalVariables.ProviderRequireAuth,"");

		logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
		FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.indianaProviderGenericFile, fileUpdateValue,globalVariables.indianaGenericFileFormat, globalVariables.provider,timeStamp);

		logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
		mapOutboundData.put(FileName, "1");
		String outboundFileName= FileContentReader.createOutboundFileAndEncryptGeneric(mapOutboundData,timeStamp,globalVariables.indianaGenericFileFormat);

		logger.log(LogStatus.INFO,"process the Files and get the control file ");
		finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
		fileNames=FileContentReader.putGetFilefromServerIndiana(FileName,outboundFileName,globalVariables.provider,timeStamp);
		
		logger.log(LogStatus.INFO,"Verifying the value in Db and control File dat");
		Errormessage.add(globalVariables.ProviderRequireAuthFormatError);
		Assertion_DbVerifier.assertControlFileInValidindiana(fileNames,FileName,Errormessage,globalVariables.provider,timeStamp);
	}

	

}
