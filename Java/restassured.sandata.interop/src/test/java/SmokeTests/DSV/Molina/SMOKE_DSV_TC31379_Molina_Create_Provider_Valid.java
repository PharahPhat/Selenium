package SmokeTests.DSV.Molina;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SMOKE_DSV_TC31379_Molina_Create_Provider_Valid extends BaseTest {
    private GenerateUniqueParam generateUniqueParam = new GenerateUniqueParam();
    private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
    private String timeStamp = CommonMethods.getTimeStamp();
    private FileContentReader FileContentReader =new FileContentReader();
    @Test(groups = {"DSV_Molina_Provider", "Smoke"}, enabled = false)
    public void Smoke_DSV_TC31379_Molina_Create_Provider_Valid() throws Exception {
        Map<String, String> mapOutboundData = new HashMap<>();
        String FileName;
        List<String> fileNames;

        logger.log(LogStatus.INFO,"Creating map for required Field map");
        Map<String, String> fileUpdateValue=generateUniqueParam.providerParams_PipeDelimited();
        fileUpdateValue.put(globalVariables.ProviderMedicaidID,CommonMethods.generateRandomStringOfFixLength(7));

        logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
        FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.molinaProviderGenericFile,
                fileUpdateValue,globalVariables.memberProviderFileName, globalVariables.provider,timeStamp);

        logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
        mapOutboundData.put(FileName, "1");
        String outboundFileName= FileContentReader.createOutboundFileAndEncrypt(mapOutboundData,timeStamp);

        logger.log(LogStatus.INFO,"process the Files and get the control file ");
        Map<String, String> finalMapDataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
        fileNames=FileContentReader.putGetFilefromServer(FileName,outboundFileName,null,timeStamp);

        logger.log(LogStatus.INFO,"Verifying the value in Db and control File dat");
        assertionDbVerifier.assertControlFileValid(fileNames,FileName,finalMapDataByRow,outboundFileName,globalVariables.provider,timeStamp);
    }
}
