package SmokeTests.DSV.Molina;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SMOKE_DSV_TC30931_Molina_Create_Client_Valid extends BaseTest {
    private GenerateUniqueParam generateUniqueParam = new GenerateUniqueParam();
    private Map<String ,String> mapOutboundData = new HashMap<>();
    private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
    private String timeStamp = CommonMethods.getTimeStamp();
    @Test(groups = {"DSV_Molina_Client", "Smoke"})
    public void Smoke_DSV_TC30931_Molina_Create_Client_Valid() throws Exception {
        String FileName;
        List<String> fileNames;
        FileContentReader FileContentReader = new FileContentReader();

        logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
        Map<String ,String> mapUpdateFileData=generateUniqueParam.MemberParams_PipeDelimited();
        mapUpdateFileData.put(globalVariables.PayerID2, CommonMethods.generateRandomNumberOfFixLength(64));
        FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.molinaGenericFile,
                mapUpdateFileData,globalVariables.memberGenericFileName,globalVariables.member,timeStamp);

        logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
        mapOutboundData.put(FileName, "1");
        String outboundFileName= FileContentReader.createOutboundFileAndEncrypt(mapOutboundData,timeStamp);

        logger.log(LogStatus.INFO,"process the Files and get the control file ");
        Map<String ,String> finalMapDataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
        fileNames=FileContentReader.putGetFilefromServer(FileName,outboundFileName,null,timeStamp);

        logger.log(LogStatus.INFO,"Verifying the value in Db and control File dat");
        assertionDbVerifier.assertControlFileValid(fileNames,FileName,finalMapDataByRow,outboundFileName,globalVariables.member,timeStamp);
    }
}
