package DSV.Indiana.provider;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SEVV8610_SEVV7361_TC99935_TC99937_Generic_Provider_mandatory_empty_fields extends BaseTest{

	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier Assertion_DbVerifier=new Assertion_DbVerifier();
	private String timeStamp;
	private FileContentReader FileContentReader =new FileContentReader(); 

	@BeforeMethod(alwaysRun = true)
	public void tearDown()
	{
		this.timeStamp =CommonMethods.getTimeStamp();	

	}

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void SEVV8610_SEVV_7361_TC_99935_Indiana_provider_only_mandatory_fileds() throws Exception{
		// logger = extent.startTest("SEVV8610_SEVV_7361_TC_99935_Indiana_provider_only_mandatory_fileds");

		//////////////Variable declaration ///////////////////
		Map<String ,String> mapUpdateFileData = new HashMap<>();
		Map<String ,String> finalMapapdataByRow = new HashMap<>();
		Map<String ,String> mapOutboundData = new HashMap<>();
		Map<String ,String> fileUpdateValue = new HashMap<>();
		List<String> Errormessage = new ArrayList<String>();
		String FileName;
		List<String> fileNames;
		logger.log(LogStatus.INFO,"Creating map for required Field map");
		fileUpdateValue=GenerateUniqueParam.providerParams_PipeDelimited();
		fileUpdateValue.put(globalVariables.ProviderDoingBusinessAs,"");
		fileUpdateValue.put(globalVariables.AddressLine2,"");
		fileUpdateValue.put(globalVariables.County,"");;
		fileUpdateValue.put(globalVariables.SSN,"");
		fileUpdateValue.put(globalVariables.TaxID,"");
		fileUpdateValue.put(globalVariables.ProviderDateBegin,"");
		fileUpdateValue.put(globalVariables.ProviderDateEnd,"");

		logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
		FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.indianaProviderGenericFile, fileUpdateValue,globalVariables.indianaGenericProviderFileName,globalVariables.provider,timeStamp);

		logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
		mapOutboundData.put(FileName, "1");
		String outboundFileName= FileContentReader.createOutboundFileAndEncryptGeneric(mapOutboundData,timeStamp,globalVariables.indianaGenericFileFormat);

		logger.log(LogStatus.INFO,"process the Files and get the control file ");
		finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
		fileNames=FileContentReader.putGetFilefromServerIndiana(FileName,outboundFileName,null,timeStamp);

		logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
		Assertion_DbVerifier.assertControlFileValidindiana(fileNames,FileName,finalMapapdataByRow,outboundFileName,globalVariables.provider,timeStamp);
	}

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void SEVV_7361_TC_99937_Indiana_provider_blank_file_with_header_only() throws Exception{
		// logger = extent.startTest("SEVV_7361_TC_99937_Indiana_provider_blank_file_with_header_only");

		//////////////Variable declaration ///////////////////
		Map<String ,String> mapUpdateFileData = new HashMap<>();
		Map<String ,String> finalMapapdataByRow = new HashMap<>();
		Map<String ,String> mapOutboundData = new HashMap<>();
		Map<String ,String> fileUpdateValue = new HashMap<>();
		List<String> Errormessage = new ArrayList<String>();
		String FileName;
		List<String> fileNames;
		logger.log(LogStatus.INFO,"Creating map for required Field map");
		fileUpdateValue=GenerateUniqueParam.providerParams_PipeDelimited();
		fileUpdateValue.put(globalVariables.providerID,"");
		fileUpdateValue.put(globalVariables.ProviderQualifier,"");
		fileUpdateValue.put(globalVariables.ProviderName,"");
		fileUpdateValue.put(globalVariables.PayerID,"");
		fileUpdateValue.put(globalVariables.ProviderDoingBusinessAs,"");
		fileUpdateValue.put(globalVariables.AddressLine1,"");
		fileUpdateValue.put(globalVariables.AddressLine2,"");
		fileUpdateValue.put(globalVariables.AddressCity,"");
		fileUpdateValue.put(globalVariables.AddressState,"");
		fileUpdateValue.put(globalVariables.AddressZip,"");
		fileUpdateValue.put(globalVariables.County,"");
		fileUpdateValue.put(globalVariables.AgencyPhone,"");
		fileUpdateValue.put(globalVariables.AgencyEmail,"");
		fileUpdateValue.put(globalVariables.PrimaryContactLastName,"");
		fileUpdateValue.put(globalVariables.PrimaryContactFirstName,"");
		fileUpdateValue.put(globalVariables.PorviderFax,"");
		fileUpdateValue.put(globalVariables.SSN,"");
		fileUpdateValue.put(globalVariables.TaxID,"");
		fileUpdateValue.put(globalVariables.ProviderDateBegin,"");
		fileUpdateValue.put(globalVariables.ProviderDateEnd,"");



		logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
		FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.indianaProviderGenericFile, fileUpdateValue,globalVariables.indianaGenericFileFormat, globalVariables.provider,timeStamp);

		logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
		mapOutboundData.put(FileName, "1");
		String outboundFileName= FileContentReader.createOutboundFileAndEncryptGeneric(mapOutboundData,timeStamp,globalVariables.indianaGenericFileFormat);

		logger.log(LogStatus.INFO,"process the Files and get the control file ");
		finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
		fileNames=FileContentReader.putGetFilefromServerIndiana(FileName,outboundFileName,globalVariables.provider,timeStamp);
		System.out.println(fileNames);

		logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
		Errormessage.add(globalVariables.providerSSNError);
		Assertion_DbVerifier.assertControlFileInValidindiana(fileNames,FileName,Errormessage,globalVariables.provider,timeStamp);
	}



}
