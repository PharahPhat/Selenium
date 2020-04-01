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

public class SEVV_7371_TC100581_TC99751_otboundconrtolfile_value_validation extends BaseTest {
    GenerateUniqueParam GenerateUniqueParam = new GenerateUniqueParam();
    Assertion_DbVerifier assertionDbVerifier = new Assertion_DbVerifier();

    Map<String, String> fileUpdateValue = new HashMap<String, String>();
    Map<String, String> fileUpdateValueOutbound = new HashMap<String, String>();
    Map<String, String> finalMapapdataByRow = new HashMap<>();
    List<String> fileNames;
    String timeStamp;
    FileContentReader FileContentReader = new FileContentReader();

    @BeforeMethod(alwaysRun = true)
    public void tearDown() {
        this.timeStamp = CommonMethods.getTimeStamp();
        FileContentReader.cleanupOHIO();
    }

// File name outbound does not match with regex so will not have response file
//    @Test(groups = {"All"})
    public void TC100581_otboundconrtolfile_has_wrong_response_file_name() throws Exception {
        String invalidtime = "993";
        String invalidbatch = "1223";
        // logger = extent.startTest("TC100581_otboundconrtolfile_has_wrong_response_file_name");
        logger.log(LogStatus.INFO, "Creating unique parameters for claim file");
        fileUpdateValue = GenerateUniqueParam.ohioclaim_PipeDelimited();
        logger.log(LogStatus.INFO, "Creating request and outbound files");
        String fileName = FileContentReader.createPipeDelimFilefileohio(globalVariables.OhioGenericFile, fileUpdateValue, timeStamp);
        fileUpdateValueOutbound.put(fileName, "1");
        String outBoundFileName = FileContentReader.createOutboundFileOhio(fileUpdateValueOutbound, invalidtime, invalidbatch);
        logger.log(LogStatus.INFO, "put and get files from server");

        finalMapapdataByRow = FileContentReader.getFileDataOnMap(globalVariables.getOhioClaimFilePick + fileName);
        fileNames = FileContentReader.putGetFilefromServerOhio(fileName, outBoundFileName, null, timeStamp, fileUpdateValue.get(globalVariables.batchid));


        logger.log(LogStatus.INFO, "Veirfying the value in Db and control File dat");
        List<String> status = new ArrayList<String>();
        status.add("true");

        assertionDbVerifier.assertControlFileValidOhio(fileNames, finalMapapdataByRow, timeStamp, fileUpdateValue.get(globalVariables.batchid), status);


    }

    // File name outbound does not match with regex so will not have response file
    //    @Test(groups = {"All"})
    public void TC99751_otboundconrtolfile_has_invalid_filename_formate() throws Exception {
        String invalidTime = "993";
        // logger = extent.startTest("TC99751_outboundControlFile_has_invalid_filename_format");

        logger.log(LogStatus.INFO, "Creating request and outbound files");
        fileUpdateValue = GenerateUniqueParam.ohioclaim_PipeDelimited();
        fileUpdateValue.put(globalVariables.MatchingRule, "Greater");
        logger.log(LogStatus.INFO, "Creating request and outbound files");
        String fileName = FileContentReader.createPipeDelimFilefileohio(globalVariables.OhioGenericFile, fileUpdateValue, timeStamp);
        fileUpdateValueOutbound.put(fileName, "1");
        String outBoundFileName = FileContentReader.createOutboundFileOhio(fileUpdateValueOutbound, invalidTime, fileUpdateValue.get(invalidTime));
        logger.log(LogStatus.INFO, "get and put files from server");
        finalMapapdataByRow = FileContentReader.getFileDataOnMap(globalVariables.getOhioClaimFilePick + fileName);
        fileNames = FileContentReader.putGetFilefromServerOhio(fileName, outBoundFileName, null, timeStamp, fileUpdateValue.get(globalVariables.batchid));


        logger.log(LogStatus.INFO, "Veirfying the value in Db and control File dat");
        List<String> status = new ArrayList<String>();
        status.add(globalVariables.exactMathcRuleError);

        assertionDbVerifier.assertControlFileValidOhio(fileNames, finalMapapdataByRow, timeStamp, fileUpdateValue.get(globalVariables.batchid), status);


    }


    @Test(groups = {"All"})
    public void TC98525_Batch_Claim_should_get_error_if_mathcingrule_space() throws Exception {

        // logger = extent.startTest("TC98525_Batch_Claim_should_get_error_if_mathcingrule_space");


        fileUpdateValue = GenerateUniqueParam.ohioclaim_PipeDelimited();
        fileUpdateValue.put(globalVariables.MatchingRule, "");
        String fileName = FileContentReader.createPipeDelimFilefileohio(globalVariables.OhioGenericFile, fileUpdateValue, timeStamp);
        fileUpdateValueOutbound.put(fileName, "1");
        String outBoundFileName = FileContentReader.createOutboundFileOhio(fileUpdateValueOutbound, timeStamp, fileUpdateValue.get(globalVariables.batchid));
        finalMapapdataByRow = FileContentReader.getFileDataOnMap(globalVariables.getOhioClaimFilePick + fileName);
        fileNames = FileContentReader.putGetFilefromServerOhio(fileName, outBoundFileName, null, timeStamp, fileUpdateValue.get(globalVariables.batchid));


        logger.log(LogStatus.INFO, "Veirfying the value in Db and control File dat");
        List<String> status = new ArrayList<>();
        status.add(globalVariables.exactMathcRuleError);
        assertionDbVerifier.assertControlFileValidOhio_error(fileNames, finalMapapdataByRow, timeStamp, fileUpdateValue.get(globalVariables.batchid), status);
    }

}
