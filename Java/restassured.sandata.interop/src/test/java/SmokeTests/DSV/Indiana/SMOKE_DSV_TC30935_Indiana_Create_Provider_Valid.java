package SmokeTests.DSV.Indiana;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SMOKE_DSV_TC30935_Indiana_Create_Provider_Valid extends BaseTest {
    private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
    private Assertion_DbVerifier Assertion_DbVerifier= new Assertion_DbVerifier();
    private FileContentReader FileContentReader =new FileContentReader();

    @Test(groups = {"DSV_Indiana_Provider", "Smoke"}, enabled = false)
    public void Smoke_DSV_TC30935_Indiana_Create_Provider_Valid() throws Exception{
        String timeStamp = CommonMethods.getTimeStamp();
        Map<String ,String> finalMapDataByRow;
        Map<String ,String> fileUpdateValue;
        Map<String ,String> mapOutboundData = new HashMap<>();
        String FileName;
        List<String> fileNames;

        logger.log(LogStatus.INFO,"Creating map for required Field map");
        fileUpdateValue=GenerateUniqueParam.providerParams_PipeDelimited();

        logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
        FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.indianaProviderGenericFile, fileUpdateValue,globalVariables.indianaGenericFileFormat, globalVariables.provider,timeStamp);

        logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
        mapOutboundData.put(FileName, "1");
        String outboundFileName= FileContentReader.createOutboundFileAndEncryptGeneric(mapOutboundData,timeStamp,globalVariables.indianaGenericFileFormat);

        logger.log(LogStatus.INFO,"process the Files and get the control file ");
        finalMapDataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
        fileNames=FileContentReader.putGetFilefromServerIndiana(FileName,outboundFileName,null,timeStamp);

        logger.log(LogStatus.INFO,"Verifying the value in Db and control File dat");
        Assertion_DbVerifier.assertControlFileValidindiana(fileNames,FileName,finalMapDataByRow,outboundFileName,globalVariables.provider,timeStamp);
    }
}
