package DSV.Molina.Auth;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class SEVV_360_TC94423_AuthorizationAmountType extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();



	String timeStamp;  FileContentReader FileContentReader =new FileContentReader(); 
	@BeforeMethod(alwaysRun = true)
	public void tearDown()
	{
		this.timeStamp =CommonMethods.getTimeStamp();	
		
	}

	@Test(groups = {"All"})
	public void SEVV_360_TC94423_AuthorizationAmountType_valid() throws Exception{

		// logger = extent.startTest("SEVV_360_TC8624_AuthorizationAmountType_valid");
		Map<String ,String> fileUpdateValue;
		//////////////Variable declaration ///////////////////
		Map<String ,String> finalMapapdataByRow;
		Map<String ,String> mapOutboundData = new HashMap<>();
		String FileName;
		List<String> fileNames;
		fileUpdateValue=GenerateUniqueParam.AuthParams_PipeDelimited();
		fileUpdateValue.put("authorizationAmountType", CommonMethods.Authaccounttype_array()); 

		logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
				FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.molinaAuthGenericFile, fileUpdateValue,globalVariables.memberAuthFileName,globalVariables.auth,timeStamp);

		//logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
		mapOutboundData.put(FileName, "1");
		String outboundFileName= FileContentReader.createOutboundFileAndEncrypt(mapOutboundData,timeStamp);

		//logger.log(LogStatus.INFO,"process the Files and get the control file ");
		finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
		fileNames=FileContentReader.putGetFilefromServer(FileName,outboundFileName,null,timeStamp);

		//logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
		assertionDbVerifier.assertControlFileValid(fileNames,FileName,finalMapapdataByRow,outboundFileName,globalVariables.auth,timeStamp);

	}

	@Test(groups = {"All"})
	public void SEVV_360_TC94423_AuthorizationAmountType_valid_fixed() throws Exception{

		// logger = extent.startTest("SEVV_360_TC8624_AuthorizationAmountType_valid_fixed");
		Map<String ,String> fileUpdateValue;
		//////////////Variable declaration ///////////////////
		Map<String ,String> finalMapapdataByRow;
		Map<String ,String> mapOutboundData = new HashMap<>();
		String FileName;
		List<String> fileNames;
		fileUpdateValue=GenerateUniqueParam.AuthParams_PipeDelimited();
		fileUpdateValue.put("authorizationAmountType", CommonMethods.AuthAccountType("H")); 

		logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
				FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.molinaAuthGenericFile, fileUpdateValue,globalVariables.memberAuthFileName,globalVariables.auth,timeStamp);

		//logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
		mapOutboundData.put(FileName, "1");
		String outboundFileName= FileContentReader.createOutboundFileAndEncrypt(mapOutboundData,timeStamp);

		//logger.log(LogStatus.INFO,"process the Files and get the control file ");
		finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
		fileNames=FileContentReader.putGetFilefromServer(FileName,outboundFileName,null,timeStamp);

		//logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
		assertionDbVerifier.assertControlFileValid(fileNames,FileName,finalMapapdataByRow,outboundFileName,globalVariables.auth,timeStamp);

	}

	@Test(groups = {"All"})
	public void SEVV_360_TC94423_AuthorizationAmountType_valid_fixed2() throws Exception{

		// logger = extent.startTest("SEVV_360_TC8624_AuthorizationAmountType_valid_fixed2");
		Map<String ,String> fileUpdateValue;
		//////////////Variable declaration ///////////////////
		Map<String ,String> finalMapapdataByRow;
		Map<String ,String> mapOutboundData = new HashMap<>();
		String FileName;
		List<String> fileNames;
		fileUpdateValue=GenerateUniqueParam.AuthParams_PipeDelimited();
		fileUpdateValue.put("authorizationAmountType", CommonMethods.AuthAccountType("V")); 

		logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
				FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.molinaAuthGenericFile, fileUpdateValue,globalVariables.memberAuthFileName,globalVariables.auth,timeStamp);

		//logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
		mapOutboundData.put(FileName, "1");
		String outboundFileName= FileContentReader.createOutboundFileAndEncrypt(mapOutboundData,timeStamp);

		//logger.log(LogStatus.INFO,"process the Files and get the control file ");
		finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
		fileNames=FileContentReader.putGetFilefromServer(FileName,outboundFileName,null,timeStamp);

		//logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
		assertionDbVerifier.assertControlFileValid(fileNames,FileName,finalMapapdataByRow,outboundFileName,globalVariables.auth,timeStamp);

	}

	@Test(groups = {"All"})
	public void SEVV_360_TC94423_AuthorizationAmountType_valid_fixed3() throws Exception{

		// logger = extent.startTest("SEVV_360_TC8624_AuthorizationAmountType_valid_fixed3");
		Map<String ,String> fileUpdateValue;
		//////////////Variable declaration ///////////////////
		Map<String ,String> finalMapapdataByRow;
		Map<String ,String> mapOutboundData = new HashMap<>();
		String FileName;
		List<String> fileNames;
		fileUpdateValue=GenerateUniqueParam.AuthParams_PipeDelimited();
		fileUpdateValue.put("authorizationAmountType", CommonMethods.AuthAccountType("U")); 

		logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
				FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.molinaAuthGenericFile, fileUpdateValue,globalVariables.memberAuthFileName,globalVariables.auth,timeStamp);

		//logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
		mapOutboundData.put(FileName, "1");
		String outboundFileName= FileContentReader.createOutboundFileAndEncrypt(mapOutboundData,timeStamp);

		//logger.log(LogStatus.INFO,"process the Files and get the control file ");
		finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
		fileNames=FileContentReader.putGetFilefromServer(FileName,outboundFileName,null,timeStamp);

		//logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
		assertionDbVerifier.assertControlFileValid(fileNames,FileName,finalMapapdataByRow,outboundFileName,globalVariables.auth,timeStamp);

	}

	@Test(groups = {"All"})
	public void SEVV_360_TC94423_AuthorizationAmountType_valid_fixed4() throws Exception{

		// logger = extent.startTest("SEVV_360_TC8624_AuthorizationAmountType_valid_fixed4");
		Map<String ,String> fileUpdateValue;
		//////////////Variable declaration ///////////////////
		Map<String ,String> finalMapapdataByRow;
		Map<String ,String> mapOutboundData = new HashMap<>();
		String FileName;
		List<String> fileNames;
		fileUpdateValue=GenerateUniqueParam.AuthParams_PipeDelimited();
		fileUpdateValue.put("authorizationAmountType", CommonMethods.AuthAccountType("M")); 

		logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
				FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.molinaAuthGenericFile, fileUpdateValue,globalVariables.memberAuthFileName,globalVariables.auth,timeStamp);

		//logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
		mapOutboundData.put(FileName, "1");
		String outboundFileName= FileContentReader.createOutboundFileAndEncrypt(mapOutboundData,timeStamp);

		//logger.log(LogStatus.INFO,"process the Files and get the control file ");
		finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
		fileNames=FileContentReader.putGetFilefromServer(FileName,outboundFileName,null,timeStamp);

		//logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
		assertionDbVerifier.assertControlFileValid(fileNames,FileName,finalMapapdataByRow,outboundFileName,globalVariables.auth,timeStamp);

	}

	@Test(groups = {"All"})
	public void SEVV_360_TC94423_AuthorizationAmountType_Invalid() throws Exception{

		// logger = extent.startTest("SEVV_360_TC8624_AuthorizationAmountType_Invalid");
		Map<String ,String> fileUpdateValue;
		//////////////Variable declaration ///////////////////
		Map<String ,String> mapOutboundData = new HashMap<>();
		String FileName;
		List<String> fileNames;
		List<String> Errormessage = new ArrayList<>();
		fileUpdateValue=GenerateUniqueParam.AuthParams_PipeDelimited();
		fileUpdateValue.put("authorizationAmountType", CommonMethods.getSaltString(2)); 

		logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
				FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.molinaAuthGenericFile, fileUpdateValue,globalVariables.memberAuthFileName,globalVariables.auth,timeStamp);

		//logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
		mapOutboundData.put(FileName, "1");
		String outboundFileName= FileContentReader.createOutboundFileAndEncrypt(mapOutboundData,timeStamp);

		//logger.log(LogStatus.INFO,"process the Files and get the control file ");
		fileNames=FileContentReader.putGetFilefromServer(FileName,outboundFileName,globalVariables.auth,timeStamp);

		logger.log(LogStatus.INFO,"Verifying the ErrorFile generated ");
		Errormessage.add(globalVariables.AuthAuthorizationAmountTypeNullError);
		assertionDbVerifier.assertControlFileInValid(fileNames,FileName,Errormessage, globalVariables.auth,timeStamp);

	}
}

