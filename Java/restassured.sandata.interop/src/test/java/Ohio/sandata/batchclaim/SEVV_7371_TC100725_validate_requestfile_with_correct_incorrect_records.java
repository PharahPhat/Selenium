package Ohio.sandata.batchclaim;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SEVV_7371_TC100725_validate_requestfile_with_correct_incorrect_records extends BaseTest {
    GenerateUniqueParam GenerateUniqueParam = new GenerateUniqueParam();
    Assertion_DbVerifier Assertion_DbVerifier = new Assertion_DbVerifier();

    Map<String, String> fileUpdateValue = new HashMap<String, String>();
    Map<String, String> fileUpdateValueOutbound = new HashMap<String, String>();
    Map<String, String> finalMapapdataByRow = new HashMap<>();
    List<String> fileNames;
    List<String> status = new ArrayList<String>();

    String timeStamp;
    FileContentReader FileContentReader = new FileContentReader();

    @BeforeMethod(alwaysRun = true)
    public void tearDown() {
        this.timeStamp = CommonMethods.getTimeStamp();
        FileContentReader.cleanupOHIO();
    }

    @Test(groups = {"All"})
    public void TC100725_validate_requestFile_with_correct_incorrect_records() throws Exception {
        // logger = extent.startTest("TC10028_Batch_Claim_request_MatchingRule_ExcludeUnits");

        logger.log(LogStatus.INFO, "Generating unique parameters file");
        fileUpdateValue = GenerateUniqueParam.ohioclaim_PipeDelimited();
        fileUpdateValue.put(globalVariables.MatchingRule, "ExcludeUnits");

        logger.log(LogStatus.INFO, "Creating request and outbound files");
        String fileName = FileContentReader.createPipeDelimFilefileohio(globalVariables.OhioGenericFile, fileUpdateValue, timeStamp);
        fileUpdateValueOutbound.put(fileName, "3");
        String outBoundFileName = FileContentReader.createOutboundFileOhio(fileUpdateValueOutbound, timeStamp, fileUpdateValue.get(globalVariables.batchid));

        logger.log(LogStatus.INFO, "Uploading and downloading files");
        finalMapapdataByRow = FileContentReader.getFileDataOnMap(globalVariables.getOhioClaimFilePick + fileName);
        fileNames = FileContentReader.putGetFilefromServerOhio(fileName, outBoundFileName, null, timeStamp, fileUpdateValue.get(globalVariables.batchid));

        logger.log(LogStatus.INFO, "Veirfying the value in Db and control File dat");

        status.add("true");
        Assertion_DbVerifier.assertControlFileValidOhio_error(fileNames, finalMapapdataByRow, timeStamp, fileUpdateValue.get(globalVariables.batchid), status);
    }
}
