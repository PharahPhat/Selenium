package DSV.Molina.Provider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.DataGeneratorClient;
import com.globalMethods.core.FileContentReader;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;

import com.globalMethods.core.Assertion_DbVerifier;
public class SEVV6926_TC103553_Verify_PrimaryContactLastName_updated extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

Map<String ,String> fileUpdateValue = new HashMap<>();
String fileName;
//////////////Variable declaration ///////////////////
Map<String ,String> mapUpdateFileData = new HashMap<>();
Map<String ,String> finalMapapdataByRow = new HashMap<>();
Map<String ,String> mapOutboundData = new HashMap<>();
String FileName,FileNameNew;
List<String> errorMessage =new ArrayList<String>();
List<String> fileNames,fileNamesnew;
String timeStamp;  FileContentReader FileContentReader =new FileContentReader(); 
@BeforeMethod(alwaysRun = true)
public void tearDown()
{
	this.timeStamp=CommonMethods.getTimeStamp();	

}

@Test(enabled = true, groups = {"All"})

public void Verify_PrimaryContactLastName_updated() throws InterruptedException, java.text.ParseException,  Exception{
	// logger = extent.startTest("Verify_PrimaryContactLastName_updated");
	System.out.println(globalVariables.genericfile+globalVariables.molinaProviderFileName);


	logger.log(LogStatus.INFO,"Creating map for required Field map");
	fileUpdateValue=GenerateUniqueParam.providerParams_PipeDelimited();
	fileUpdateValue.put(globalVariables.PrimaryContactLastName,CommonMethods.generateRandomStringOfFixLength(24));
	fileUpdateValue.put(globalVariables.PrimaryContactFirstName,"");

	logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
	FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.molinaProviderGenericFile, fileUpdateValue,globalVariables.memberProviderFileName, globalVariables.provider,timeStamp);

	logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
	mapOutboundData.put(FileName, "1");
	String outboundFileName= FileContentReader.createOutboundFileAndEncrypt(mapOutboundData,timeStamp);

	logger.log(LogStatus.INFO,"process the Files and get the control file ");
	finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
	fileNames=FileContentReader.putGetFilefromServer(FileName,outboundFileName,null,timeStamp);
	DataGeneratorClient.Provider_primarycontactlastnameBatch(finalMapapdataByRow);
	assertionDbVerifier.assertControlFileValid(fileNames,FileName,finalMapapdataByRow,outboundFileName,globalVariables.provider,timeStamp);


	Map<String ,String> mapOutboundDatanew = new HashMap<>();
	//updating the PrimaryContactFirstName with valid value
	timeStamp=CommonMethods.getTimeStamp();
	fileUpdateValue.put(globalVariables.PrimaryContactLastName,CommonMethods.generateRandomStringOfFixLength(24));

	logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
	FileNameNew =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.molinaProviderGenericFile, fileUpdateValue,globalVariables.memberProviderFileName, globalVariables.provider,timeStamp);

	logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
	mapOutboundDatanew.put(FileNameNew, "1");
	String outboundFileNameNew= FileContentReader.createOutboundFileAndEncrypt(mapOutboundDatanew,timeStamp);

	logger.log(LogStatus.INFO,"process the Files and get the control file ");
	finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileNameNew);
	fileNamesnew=FileContentReader.putGetFilefromServer(FileNameNew,outboundFileNameNew,null,timeStamp);
	DataGeneratorClient.Provider_primarycontactlastnameBatch(finalMapapdataByRow);
	assertionDbVerifier.verify_ImportFile_Provider_STx_Account(finalMapapdataByRow);

}

}
