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

public class SEVV_7364_TC100115_TC100116_TC100117_TC100118_validation_fields_formate extends BaseTest{
	
	GenerateUniqueParam GenerateUniqueParam =new GenerateUniqueParam();
	Assertion_DbVerifier Assertion_DbVerifier =new Assertion_DbVerifier();
	FileContentReader FileContentReader =new FileContentReader();

	String timeStamp; 
	
	@BeforeMethod(alwaysRun = true)
	public void tearDown()
	{
		this.timeStamp =CommonMethods.getTimeStamp();	
		
	}

	@Test(enabled = true, groups = {"All", "Regression"})
    public void SEVV_7364_TC100115_Indiana_Member_ClientPhone_PhoneType_invalid() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("SEVV_7364_TC100115_Indiana_Member_ClientPhone_PhoneType_invalid");
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
		fileUpdateValue.put("ClientPhoneType", "test");
		fileUpdateValue.put("ClientPhone", "abcd");
		logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
		FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.indianaMemberGenericFile, fileUpdateValue,globalVariables.indianaGenericFileFormat,globalVariables.member,timeStamp);

		logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
		mapOutboundData.put(FileName, "1");
		String outboundFileName= FileContentReader.createOutboundFileAndEncryptGeneric(mapOutboundData,timeStamp,globalVariables.indianaGenericFileFormat);

		logger.log(LogStatus.INFO,"process the Files and get the control file ");
		finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
		fileNames=FileContentReader.putGetFilefromServerIndiana(FileName,outboundFileName,globalVariables.member,timeStamp);

		logger.log(LogStatus.INFO,"Veirfying the value in error response");
		Errormessage.add(globalVariables.ClientPhoneType_Error_member);
		Assertion_DbVerifier.assertControlFileInValidindiana(fileNames,FileName,Errormessage,globalVariables.member,timeStamp);
	}
	
	@Test(enabled = true, groups = {"All", "Regression"})
    public void SEVV_7364_TC100117_Indiana_Member_ClientEligibilityDateBegin_invalid() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("SEVV_7364_TC100117_Indiana_Member_ClientEligibilityDateBegin_invalid");
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
		fileUpdateValue.put("ClientEligibilityDateBegin", CommonMethods.generatecurrentDate_YYYYMMdd());

		logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
		FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.indianaMemberGenericFile, fileUpdateValue,globalVariables.indianaGenericFileFormat,globalVariables.member,timeStamp);

		logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
		mapOutboundData.put(FileName, "1");
		String outboundFileName= FileContentReader.createOutboundFileAndEncryptGeneric(mapOutboundData,timeStamp,globalVariables.indianaGenericFileFormat);

		logger.log(LogStatus.INFO,"process the Files and get the control file ");
		finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
		fileNames=FileContentReader.putGetFilefromServerIndiana(FileName,outboundFileName,globalVariables.member,timeStamp);

		logger.log(LogStatus.INFO,"Veirfying the value in error response");
		Errormessage.add("The ClientEligibilityDateBegin format is incorrect. The record should satisfy the date format ['yyyy-MM-dd']");
		Assertion_DbVerifier.assertControlFileInValidindiana(fileNames,FileName,Errormessage,globalVariables.member,timeStamp);
	}
	
	@Test(enabled = true, groups = {"All", "Regression"})
    public void SEVV_7364_TC100116_Indiana_Member_ClientZip_invalid() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("SEVV_7364_TC100116_Indiana_Member_ClientZip_invalid");
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
		fileUpdateValue.put("ClientZip", "1234567890");
	
		logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
		FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.indianaMemberGenericFile, fileUpdateValue,globalVariables.indianaGenericFileFormat,globalVariables.member,timeStamp);

		logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
		mapOutboundData.put(FileName, "1");
		String outboundFileName= FileContentReader.createOutboundFileAndEncryptGeneric(mapOutboundData,timeStamp,globalVariables.indianaGenericFileFormat);

		logger.log(LogStatus.INFO,"process the Files and get the control file ");
		finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
		fileNames=FileContentReader.putGetFilefromServerIndiana(FileName,outboundFileName,globalVariables.member,timeStamp);

		logger.log(LogStatus.INFO,"Veirfying the value in error response");
		Errormessage.add("ERROR: The ClientZip format is incorrect.");
		Assertion_DbVerifier.assertControlFileInValidindiana(fileNames,FileName,Errormessage,globalVariables.member,timeStamp);
	}
	
	@Test(enabled = true, groups = {"All", "Regression"})
    public void SEVV_7364_TC100116_Indiana_Member_ClientZip_invalid_chracter() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("SEVV_7364_TC100116_Indiana_Member_ClientZip_invalid_chracter");
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
		fileUpdateValue.put("ClientZip", "testuu123");
	
		logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
		FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.indianaMemberGenericFile, fileUpdateValue,globalVariables.indianaGenericFileFormat,globalVariables.member,timeStamp);

		logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
		mapOutboundData.put(FileName, "1");
		String outboundFileName= FileContentReader.createOutboundFileAndEncryptGeneric(mapOutboundData,timeStamp,globalVariables.indianaGenericFileFormat);

		logger.log(LogStatus.INFO,"process the Files and get the control file ");
		fileNames=FileContentReader.putGetFilefromServerIndiana(FileName,outboundFileName,globalVariables.member,timeStamp);

		logger.log(LogStatus.INFO,"Veirfying the value in error response");
		Errormessage.add("ERROR: The ClientZip format is incorrect.");
		Assertion_DbVerifier.assertControlFileInValidindiana(fileNames,FileName,Errormessage,globalVariables.member,timeStamp);
	}
	
	@Test(enabled = true, groups = {"All", "Regression"})
    public void SEVV_7364_TC100118_Indiana_Member_ClientAddressType_invalid() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("SEVV_7364_TC100118_Indiana_Member_ClientAddressType_invalid");
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
		fileUpdateValue.put("ClientAddressType", "testuu123");
	
		logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
		FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.indianaMemberGenericFile, fileUpdateValue,globalVariables.indianaGenericFileFormat,globalVariables.member,timeStamp);

		logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
		mapOutboundData.put(FileName, "1");
		String outboundFileName= FileContentReader.createOutboundFileAndEncryptGeneric(mapOutboundData,timeStamp,globalVariables.indianaGenericFileFormat);

		logger.log(LogStatus.INFO,"process the Files and get the control file ");
		finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
		fileNames=FileContentReader.putGetFilefromServerIndiana(FileName,outboundFileName,globalVariables.member,timeStamp);

		logger.log(LogStatus.INFO,"Veirfying the value in error response");
		Errormessage.add("The ClientAddressType format is incorrect. The record should satisfy this regular expression ['Business|Home|Other']");
		Assertion_DbVerifier.assertControlFileInValidindiana(fileNames,FileName,Errormessage,globalVariables.member,timeStamp);
	}
}


