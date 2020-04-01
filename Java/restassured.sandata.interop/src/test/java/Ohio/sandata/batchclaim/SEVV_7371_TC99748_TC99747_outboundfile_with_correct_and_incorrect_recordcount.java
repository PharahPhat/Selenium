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

public class SEVV_7371_TC99748_TC99747_outboundfile_with_correct_and_incorrect_recordcount extends BaseTest {
    GenerateUniqueParam GenerateUniqueParam = new GenerateUniqueParam();
    Assertion_DbVerifier Assertion_DbVerifier = new Assertion_DbVerifier();

    Map<String, String> fileUpdateValue = new HashMap<String, String>();
    Map<String, String> fileUpdateValueOutbound = new HashMap<String, String>();
    Map<String, String> finalMapapdataByRow = new HashMap<>();
    List<String> fileNames;
    String timeStamp;
    FileContentReader FileContentReader = new FileContentReader();
    String invalidtime, invalidbatch = "1223";

    @BeforeMethod(alwaysRun = true)
    public void tearDown() {
        this.timeStamp = CommonMethods.getTimeStamp();
        FileContentReader.cleanupOHIO();
    }

    @Test(groups = {"All"})
    public void TC99748_outboundfile_with_correct_recordnumber() throws Exception {
        // logger = extent.startTest("TC99748_outboundfile_with_correct_recordnumber");
        logger.log(LogStatus.INFO, "Creating unique parameters for claim file");
        fileUpdateValue = GenerateUniqueParam.ohioclaim_PipeDelimited();
        logger.log(LogStatus.INFO, "Creating request and outbound files");
        String fileName = FileContentReader.createPipeDelimFilefileohio(globalVariables.OhioGenericFile, fileUpdateValue, timeStamp);
        fileUpdateValueOutbound.put(fileName, "1");
        String outBoundFileName = FileContentReader.createOutboundFileOhio(fileUpdateValueOutbound, invalidtime, fileUpdateValue.get(invalidbatch));
        logger.log(LogStatus.INFO, "Creating request and outbound files");
        finalMapapdataByRow = FileContentReader.getFileDataOnMap(globalVariables.getOhioClaimFilePick + fileName);
        fileNames = FileContentReader.putGetFilefromServerOhio(fileName, outBoundFileName, null, timeStamp, fileUpdateValue.get(globalVariables.batchid));


        logger.log(LogStatus.INFO, "Veirfying the value in Db and control File dat");
        List<String> status = new ArrayList<String>();
        status.add("true");
        Assertion_DbVerifier.assertControlFileValidOhio(fileNames, finalMapapdataByRow, timeStamp, fileUpdateValue.get(globalVariables.batchid), status);


    }

    @Test(groups = {"All"})
    public void TC99747_outboundfile_with_incorrect_recordnumbere() throws Exception {
        // logger = extent.startTest("TC99747_outboundfile_with_incorrect_recordnumbere");

        logger.log(LogStatus.INFO, "Creating request and outbound files");
        fileUpdateValue = GenerateUniqueParam.ohioclaim_PipeDelimited();
        fileUpdateValue.put(globalVariables.MatchingRule, "Greater");
        logger.log(LogStatus.INFO, "Creating request and outbound files");
        String fileName = FileContentReader.createPipeDelimFilefileohio(globalVariables.OhioGenericFile, fileUpdateValue, timeStamp);
        fileUpdateValueOutbound.put(fileName, "1");
        String outBoundFileName = FileContentReader.createOutboundFileOhio(fileUpdateValueOutbound, invalidtime, fileUpdateValue.get(invalidtime));
        logger.log(LogStatus.INFO, "Creating request and outbound files");
        finalMapapdataByRow = FileContentReader.getFileDataOnMap(globalVariables.getOhioClaimFilePick + fileName);
        fileNames = FileContentReader.putGetFilefromServerOhio(fileName, outBoundFileName, null, timeStamp, fileUpdateValue.get(globalVariables.batchid));


        logger.log(LogStatus.INFO, "Veirfying the value in Db and control File dat");
        List<String> status = new ArrayList<String>();
        status.add(globalVariables.exactMathcRuleError);
        Assertion_DbVerifier.assertControlFileValidOhio_error(fileNames, finalMapapdataByRow, timeStamp, fileUpdateValue.get(globalVariables.batchid), status);


    }


}
