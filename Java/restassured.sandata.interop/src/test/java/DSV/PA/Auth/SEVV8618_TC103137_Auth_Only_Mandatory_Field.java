package DSV.PA.Auth;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SEVV8618_TC103137_Auth_Only_Mandatory_Field extends BaseTest {
	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); 
	Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	String timeStamp;  FileContentReader FileContentReader =new FileContentReader(); 
	
	
	@BeforeMethod(alwaysRun = true)
	public void tearDown()
	{
		 this.timeStamp =CommonMethods.getTimeStamp();	
	 
	}

	@Test(enabled = true, groups = {"All"})
	public void SEVV8618_TC103137_Auth_Only_Mandatory_Field() throws Exception{
		// logger = extent.startTest("SEVV8618_TC103137_Auth_Only_Mandatory_Field");

		//////////////Variable declaration ///////////////////
		Map<String, String> mapOutboundData = new HashMap<>();
		String FileName;
		Map<String, String> finalMapapdataByRow;
		List<String> fileNames;
		List<String> mapdataByValue;
		List<String> mapdataByValueNonMandatory = new ArrayList<>();


		logger.log(LogStatus.INFO, "Creating map for removing the required  Field map");
		mapdataByValue = GenerateUniqueParam.authParamsPipeDelimitedNonRequiredField();
		finalMapapdataByRow = FileContentReader.readFileDataAddToMapWithRowNo(globalVariables.molinaAuthGenericFile, 3);
		for (String value : finalMapapdataByRow.keySet()) {
			mapdataByValueNonMandatory.add(value.replaceAll("^[\"']+|[\"']+$", "").toLowerCase());
		}

		for (int i = 0; i < mapdataByValue.size(); i++) {
			mapdataByValueNonMandatory.remove(mapdataByValue.get(i).toLowerCase());
		}

		logger.log(LogStatus.INFO, "create the PipeDeliminated File and Encrypt to GPG");
		FileName = FileContentReader.createPipeDelimFileAndConvertToGPGWithRemovalField(globalVariables.molinaAuthGenericFileSegment, mapdataByValueNonMandatory, globalVariables.auth, timeStamp);

		logger.log(LogStatus.INFO, "No of file processed and data in the file and create the Outbound file ");
		mapOutboundData.put(FileName, "1");
		String outboundFileName = FileContentReader.createOutboundFileAndEncrypt(mapOutboundData, timeStamp);

		logger.log(LogStatus.INFO, "process the Files and get the control file ");
		fileNames = FileContentReader.putGetFilefromServerSegmentField(FileName, outboundFileName, null, timeStamp);

		logger.log(LogStatus.INFO, "Verifying the value in Db and control File dat");
		assertionDbVerifier.verifyInboundFile(fileNames,mapOutboundData,timeStamp);
		

	}


}
