package DSV.Molina.Member;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SEVV_323_TC94641_ClientSSN_Valid extends BaseTest {
    GenerateUniqueParam GenerateUniqueParam = new GenerateUniqueParam();
    Assertion_DbVerifier assertionDbVerifier = new Assertion_DbVerifier();


    FileContentReader FileContentReader = new FileContentReader();
    String timeStamp;

    @BeforeMethod(alwaysRun = true)
    public void tearDown() {
        this.timeStamp = CommonMethods.getTimeStamp();

    }

    @Test(enabled = true, groups = {"All"})
    public void SEVV_323_TC94641_ClientSSN_Min_5() throws Exception {
        // logger = extent.startTest("SEVV_323_TC94641_ClientSSN_Min_5");
        //////////////Variable declaration ///////////////////
        Map<String, String> mapUpdateFileData = new HashMap<>();
        Map<String, String> finalMapapdataByRow = new HashMap<>();
        Map<String, String> mapOutboundData = new HashMap<>();
        String FileName;
        List<String> fileNames;

        logger.log(LogStatus.INFO, "Creating map for required Field map");
        mapUpdateFileData = GenerateUniqueParam.MemberParams_PipeDelimited();
        mapUpdateFileData.put(globalVariables.molinaClientSSN, CommonMethods.generateRandomNumberOfFixLength(9));
        logger.log(LogStatus.INFO, "create the PipeDeliminated File and Encrypt to GPG");
        FileName = FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.molinaGenericFile, mapUpdateFileData, globalVariables.memberGenericFileName, globalVariables.member, timeStamp);

        logger.log(LogStatus.INFO, "No of file processed and data in the file and create the Outbound file ");
        mapOutboundData.put(FileName, "1");
        String outboundFileName = FileContentReader.createOutboundFileAndEncrypt(mapOutboundData, timeStamp);

        logger.log(LogStatus.INFO, "process the Files and get the control file ");
        finalMapapdataByRow = FileContentReader.getFileDataOnMap(globalVariables.Encryptfile + FileName);
        fileNames = FileContentReader.putGetFilefromServer(FileName, outboundFileName, null, timeStamp);

        logger.log(LogStatus.INFO, "Veirfying the value in Db and control File dat");
        assertionDbVerifier.assertControlFileValid(fileNames, FileName, finalMapapdataByRow, outboundFileName, globalVariables.member, timeStamp);
    }

    @Test(enabled = true, groups = {"All"})
    public void SEVV_323_TC94641_ClientSSN_Max_9() throws Exception {
        // logger = extent.startTest("SEVV_323_TC94641_ClientSSN_Max_9");
        //////////////Variable declaration ///////////////////
        Map<String, String> mapUpdateFileData = new HashMap<>();
        Map<String, String> finalMapapdataByRow = new HashMap<>();
        Map<String, String> mapOutboundData = new HashMap<>();
        String FileName;
        List<String> fileNames;
        timeStamp = CommonMethods.getTimeStamp();
        logger.log(LogStatus.INFO, "Creating map for required Field map");
        mapUpdateFileData = GenerateUniqueParam.MemberParams_PipeDelimited();
        mapUpdateFileData.put(globalVariables.molinaClientSSN, CommonMethods.generateRandomNumberOfFixLength(9));
        logger.log(LogStatus.INFO, "create the PipeDeliminated File and Encrypt to GPG");
        FileName = FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.molinaGenericFile, mapUpdateFileData, globalVariables.memberGenericFileName, globalVariables.member, timeStamp);

        logger.log(LogStatus.INFO, "No of file processed and data in the file and create the Outbound file ");
        mapOutboundData.put(FileName, "1");
        String outboundFileName = FileContentReader.createOutboundFileAndEncrypt(mapOutboundData, timeStamp);

        logger.log(LogStatus.INFO, "process the Files and get the control file ");
        finalMapapdataByRow = FileContentReader.getFileDataOnMap(globalVariables.Encryptfile + FileName);
		fileNames=FileContentReader.putGetFilefromServer(FileName,outboundFileName,null,timeStamp);

		logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
		assertionDbVerifier.assertControlFileValid(fileNames,FileName,finalMapapdataByRow,outboundFileName,globalVariables.member,timeStamp);
	}
}
