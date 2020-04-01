package DSV.Indiana.member;

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

public class SEVV_7364_TC100024_Indiana_Member_ProviderQualifier extends BaseTest{
	GenerateUniqueParam GenerateUniqueParam =new GenerateUniqueParam();
	Assertion_DbVerifier Assertion_DbVerifier =new Assertion_DbVerifier();
	FileContentReader FileContentReader =new FileContentReader();
	//////////////Variable declaration ///////////////////
	Map<String ,String> mapUpdateFileData = new HashMap<>();
	Map<String ,String> finalMapapdataByRow = new HashMap<>();
	Map<String ,String> mapOutboundData = new HashMap<>();
	Map<String ,String> fileUpdateValue = new HashMap<>();
	String FileName;
	List<String> fileNames;
	String timeStamp; 
	List<String> Errormessage = new ArrayList<String>();
	@BeforeMethod(alwaysRun = true)
	public void tearDown()
	{
		this.timeStamp =CommonMethods.getTimeStamp();	
		//
	}

	@Test(enabled = true, groups = {"All", "Regression"})
    public void SEVV_7364_TC100024_Indiana_Member_ProviderQualifier_Valid() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("SEVV_7364_TC100024_Indiana_Member_ProviderQualifier_Valid");
		//////////////Variable declaration ///////////////////
		Map<String ,String> mapUpdateFileData = new HashMap<>();
		Map<String ,String> finalMapapdataByRow = new HashMap<>();
		Map<String ,String> mapOutboundData = new HashMap<>();
		Map<String ,String> fileUpdateValue = new HashMap<>();
		List<String> Errormessage = new ArrayList<String>();
		String FileName;
		List<String> fileNames;
		logger.log(LogStatus.INFO,"Creating map for required Field map");
		fileUpdateValue=GenerateUniqueParam.MemberParams_PipeDelimited();
		fileUpdateValue.put("ProviderQualifier", "SandataID");
		logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
		FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.indianaMemberGenericFile, fileUpdateValue,globalVariables.indianaGenericFileFormat,globalVariables.member,timeStamp);

		logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
		mapOutboundData.put(FileName, "1");
		String outboundFileName= FileContentReader.createOutboundFileAndEncryptGeneric(mapOutboundData,timeStamp,globalVariables.indianaGenericFileFormat);

		logger.log(LogStatus.INFO,"process the Files and get the control file ");
		finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
		fileNames=FileContentReader.putGetFilefromServerIndiana(FileName,outboundFileName,null,timeStamp);

		logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
		Assertion_DbVerifier.assertControlFileValidindiana(fileNames,FileName,finalMapapdataByRow,outboundFileName,globalVariables.member,timeStamp);
	}
	@Test(enabled = true, groups = {"All", "Regression"})
    public void SEVV_7364_TC100024_Indiana_Member_ProviderQualifier_InValid() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("SEVV_7364_TC100024_Indiana_Member_ProviderQualifier_InValid");
		//////////////Variable declaration ///////////////////
		Map<String ,String> mapUpdateFileData = new HashMap<>();
		Map<String ,String> finalMapapdataByRow = new HashMap<>();
		Map<String ,String> mapOutboundData = new HashMap<>();
		Map<String ,String> fileUpdateValue = new HashMap<>();
		List<String> Errormessage = new ArrayList<String>();
		String FileName;
		List<String> fileNames;
		logger.log(LogStatus.INFO,"Creating map for required Field map");
		fileUpdateValue=GenerateUniqueParam.MemberParams_PipeDelimited();
		fileUpdateValue.put("ProviderQualifier", CommonMethods.generateRandomStringOfFixLength(4));
		
		logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
		FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.indianaMemberGenericFile, fileUpdateValue,globalVariables.indianaGenericFileFormat,globalVariables.member,timeStamp);

		logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
		mapOutboundData.put(FileName, "1");
		String outboundFileName= FileContentReader.createOutboundFileAndEncryptGeneric(mapOutboundData,timeStamp,globalVariables.indianaGenericFileFormat);

		logger.log(LogStatus.INFO,"process the Files and get the control file ");
		finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
		fileNames=FileContentReader.putGetFilefromServerIndiana(FileName,outboundFileName,globalVariables.member,timeStamp);

		logger.log(LogStatus.INFO,"Veirfying the value in error response");
		Errormessage.add(globalVariables.ProvideQualifier_generic);
		Assertion_DbVerifier.assertControlFileInValidindiana(fileNames,FileName,Errormessage,globalVariables.member,timeStamp);
	}
}