package DSV.Molina.Auth;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SEVV8617_TC102263_Auth_Only_NonMandatory_Field extends BaseTest {
    GenerateUniqueParam GenerateUniqueParam = new GenerateUniqueParam();
    Assertion_DbVerifier assertionDbVerifier = new Assertion_DbVerifier();
    String timeStamp;
    FileContentReader FileContentReader = new FileContentReader();


    @BeforeMethod(alwaysRun = true)
    public void tearDown() {
        this.timeStamp = CommonMethods.getTimeStamp();

    }

    //Inter-Op - Molina - Auth: Missing Required Fields
    @Test(groups = {"All"})
    public void SEVV8617_TC102263_Auth_Only_NonMandatory_Field() throws Exception {
        // logger = extent.startTest("TC102260_TC102266_102267_Auth_Only_Mandatory_Field");

        //////////////Variable declaration ///////////////////
        Map<String, String> mapOutboundData = new HashMap<>();
        String FileName;
        List<String> fileNames, Errormessage;
        List<String> mapdataByValue;

        logger.log(LogStatus.INFO, "Creating map for removing the required  Field map");
        mapdataByValue = GenerateUniqueParam.authParamsPipeDelimitedOnlyRequiredField();

        logger.log(LogStatus.INFO, "create the PipeDeliminated File and Encrypt to GPG");
        FileName = FileContentReader.createPipeDelimFileAndConvertToGPGWithRemovalField(globalVariables.molinaAuthGenericFile, mapdataByValue, globalVariables.auth, timeStamp);

        logger.log(LogStatus.INFO, "No of file processed and data in the file and create the Outbound file ");
        mapOutboundData.put(FileName, "1");
        String outboundFileName = FileContentReader.createOutboundFileAndEncrypt(mapOutboundData, timeStamp);

        logger.log(LogStatus.INFO, "process the Files and get the control file ");
        FileContentReader.getFileDataOnMap(globalVariables.Encryptfile + FileName);

        logger.log(LogStatus.INFO, "Put and Get File to/from server");
        fileNames = FileContentReader.putGetFilefromServer(FileName, outboundFileName, globalVariables.auth, timeStamp);


        logger.log(LogStatus.INFO, "Verifying the ErrorFile generated ");
        Errormessage = CommonMethods.getAuthErrorMessageForMissingRequiredField();
        assertionDbVerifier.assertControlFileInValid(fileNames, FileName, Errormessage, globalVariables.auth, timeStamp);
    }
}
