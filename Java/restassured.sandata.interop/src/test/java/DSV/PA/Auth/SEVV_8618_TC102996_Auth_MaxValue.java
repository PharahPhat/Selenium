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

public class SEVV_8618_TC102996_Auth_MaxValue extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();


String timeStamp;  FileContentReader FileContentReader =new FileContentReader(); 
@BeforeMethod(alwaysRun = true)
public void tearDown()
{
	this.timeStamp =CommonMethods.getTimeStamp();	

}

@Test(enabled = true, groups = {"All"})
public void SEVV_8618_TC102996_Auth_MaxValue() throws InterruptedException, java.text.ParseException,  Exception{

	// logger = extent.startTest("SEVV_8618_TC102996_Auth_MaxValue");
	Map<String ,String> fileUpdateValue = new HashMap<>();
	String fileName;
	//////////////Variable declaration ///////////////////
	Map<String ,String> mapUpdateFileData = new HashMap<>();
	Map<String ,String> finalMapapdataByRow = new HashMap<>();
	Map<String ,String> mapOutboundData = new HashMap<>();
	String FileName;
	List<String> fileNames;
	List<String> Errormessage =new ArrayList<String>();
	fileUpdateValue=GenerateUniqueParam.AuthParams_PipeDelimited_MaxValue();
	fileUpdateValue.put("payerId", "PAOLTL" );
	
	fileUpdateValue.put("clientQualifier", "ClientCustomID");
	
	fileUpdateValue.put("providerQualifier", "MedicaidID");

	logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
	FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.molinaAuthGenericFileSegment, fileUpdateValue,globalVariables.memberAuthFileName,globalVariables.auth,timeStamp);

	logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
	mapOutboundData.put(FileName, "1");
	String outboundFileName= FileContentReader.createOutboundFileAndEncrypt(mapOutboundData,timeStamp);

	logger.log(LogStatus.INFO,"process the Files and get the control file ");
	finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
	System.out.println(finalMapapdataByRow);
	fileNames=FileContentReader.putGetFilefromServerSegmentField(FileName,outboundFileName,null,timeStamp);
	logger.log(LogStatus.INFO,"Veirfying the ErrorFile generated ");

	Errormessage.add(globalVariables.AuthorizationMaximum_Length);

	assertionDbVerifier.assertControlFileInValid(fileNames,FileName,Errormessage,globalVariables.auth,timeStamp );

}


}
