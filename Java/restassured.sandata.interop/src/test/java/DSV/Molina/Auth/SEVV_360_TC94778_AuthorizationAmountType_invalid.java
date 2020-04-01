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
public class SEVV_360_TC94778_AuthorizationAmountType_invalid extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	Map<String ,String> fileUpdateValue = new HashMap<>();
	String fileName;
	//////////////Variable declaration ///////////////////
	Map<String ,String> mapUpdateFileData = new HashMap<>();
	Map<String ,String> finalMapapdataByRow = new HashMap<>();
	Map<String ,String> mapOutboundData = new HashMap<>();
	String FileName;
	List<String> fileNames;
	List<String> Errormessage = new ArrayList<String>();

	String timeStamp;
	FileContentReader FileContentReader = new FileContentReader();

	@BeforeMethod(alwaysRun = true)
	public void tearDown() {
		this.timeStamp = CommonMethods.getTimeStamp();

	}

	@Test(groups = {"All"})
	public void SEVV_360_TC94778_AuthorizationAmountType_invalid_blank() throws Exception {

		// logger = extent.startTest("SEVV_360_TC8700_AuthorizationAmountType_invalid_blank");

		fileUpdateValue = GenerateUniqueParam.AuthParams_PipeDelimited();
		fileUpdateValue.put("authorizationAmountType", "");

		logger.log(LogStatus.INFO, "create the PipeDeliminated File and Encrypt to GPG");
		FileName = FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.molinaAuthGenericFile, fileUpdateValue, globalVariables.memberAuthFileName, globalVariables.auth, timeStamp);

		logger.log(LogStatus.INFO, "No of file processed and data in the file and create the Outbound file ");
		mapOutboundData.put(FileName, "1");
		String outboundFileName = FileContentReader.createOutboundFileAndEncrypt(mapOutboundData, timeStamp);

		logger.log(LogStatus.INFO, "process the Files and get the control file ");
		finalMapapdataByRow = FileContentReader.getFileDataOnMap(globalVariables.Encryptfile + FileName);
		fileNames = FileContentReader.putGetFilefromServer(FileName, outboundFileName, globalVariables.auth, timeStamp);

		logger.log(LogStatus.INFO, "Veirfying the ErrorFile generated ");
		Errormessage.add(globalVariables.AuthAuthorizationAmountTypeNullOrEmptyError);
		assertionDbVerifier.assertControlFileInValid(fileNames,FileName,Errormessage, globalVariables.auth, timeStamp);

	}

}
