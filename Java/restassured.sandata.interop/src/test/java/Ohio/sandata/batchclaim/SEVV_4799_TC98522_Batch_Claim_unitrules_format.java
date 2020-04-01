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

public class SEVV_4799_TC98522_Batch_Claim_unitrules_format extends BaseTest {
    GenerateUniqueParam GenerateUniqueParam = new GenerateUniqueParam();
    Assertion_DbVerifier Assertion_DbVerifier = new Assertion_DbVerifier();

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

    @Test(groups = {"All", "Regression"})
    public void TC98522_Batch_Claim_unitrules_format_blank() throws Exception {
        // logger = extent.startTest("TC98522_Batch_Claim_unitrules_format_blank");

        logger.log(LogStatus.INFO, "Generating unique parameters for claim file");
        fileUpdateValue = GenerateUniqueParam.ohioclaim_PipeDelimited();
        fileUpdateValue.put(globalVariables.UnitsRule, "");

        logger.log(LogStatus.INFO, "Creating unique reqest and outbound files for claim.");
        String fileName = FileContentReader.createPipeDelimFilefileohio(globalVariables.OhioGenericFile, fileUpdateValue, timeStamp);
        fileUpdateValueOutbound.put(fileName, "1");
        String outBoundFileName = FileContentReader.createOutboundFileOhio(fileUpdateValueOutbound, timeStamp, fileUpdateValue.get(globalVariables.batchid));
        finalMapapdataByRow = FileContentReader.getFileDataOnMap(globalVariables.getOhioClaimFilePick + fileName);
        fileNames = FileContentReader.putGetFilefromServerOhio(fileName, outBoundFileName, null, timeStamp, fileUpdateValue.get(globalVariables.batchid));


        logger.log(LogStatus.INFO, "Veirfying the value in Db and control File dat");
        List<String> status = new ArrayList<String>();
        status.add(globalVariables.invalidunit);
        Assertion_DbVerifier.assertControlFileValidOhio_error(fileNames, finalMapapdataByRow, timeStamp, fileUpdateValue.get(globalVariables.batchid), status);


    }

    @Test(groups = {"All"})
    public void TC98522_Batch_Claim_unitrules_format_invalid() throws Exception {
        // logger = extent.startTest("TC98522_Batch_Claim_unitrules_format_invalid");

        fileUpdateValue = GenerateUniqueParam.ohioclaim_PipeDelimited();
        fileUpdateValue.put(globalVariables.UnitsRule, CommonMethods.generateRandomStringOfFixLength(7));
        String fileName = FileContentReader.createPipeDelimFilefileohio(globalVariables.OhioGenericFile, fileUpdateValue, timeStamp);
        fileUpdateValueOutbound.put(fileName, "1");
        String outBoundFileName = FileContentReader.createOutboundFileOhio(fileUpdateValueOutbound, timeStamp, fileUpdateValue.get(globalVariables.batchid));
        finalMapapdataByRow = FileContentReader.getFileDataOnMap(globalVariables.getOhioClaimFilePick + fileName);
        fileNames = FileContentReader.putGetFilefromServerOhio(fileName, outBoundFileName, null, timeStamp, fileUpdateValue.get(globalVariables.batchid));

        logger.log(LogStatus.INFO, "Veirfying the value in Db and control File dat");
        List<String> status = new ArrayList<String>();
        status.add("Units is NULL");
        Assertion_DbVerifier.assertControlFileValidOhio_fail(fileNames, finalMapapdataByRow, timeStamp, fileUpdateValue.get(globalVariables.batchid), status);


    }

    @Test(groups = {"All"})
    public void TC98522_Batch_Claim_unitrules_format_valid_addtime() throws Exception {
        // logger = extent.startTest("TC98522_Batch_Claim_unitrules_format_valid_addtime");


        fileUpdateValue = GenerateUniqueParam.ohioclaim_PipeDelimited();
        fileUpdateValue.put(globalVariables.UnitsRule, "AddTime");
        String fileName = FileContentReader.createPipeDelimFilefileohio(globalVariables.OhioGenericFile, fileUpdateValue, timeStamp);
        fileUpdateValueOutbound.put(fileName, "1");
        String outBoundFileName = FileContentReader.createOutboundFileOhio(fileUpdateValueOutbound, timeStamp, fileUpdateValue.get(globalVariables.batchid));
        finalMapapdataByRow = FileContentReader.getFileDataOnMap(globalVariables.getOhioClaimFilePick + fileName);
        fileNames = FileContentReader.putGetFilefromServerOhio(fileName, outBoundFileName, null, timeStamp, fileUpdateValue.get(globalVariables.batchid));


        logger.log(LogStatus.INFO, "Veirfying the value in Db and control File dat");
        List<String> status = new ArrayList<String>();
        status.add(globalVariables.truResponse);
        Assertion_DbVerifier.assertControlFileValidOhio(fileNames, finalMapapdataByRow, timeStamp, fileUpdateValue.get(globalVariables.batchid), status);
    }


}
