package DSV.PA.Auth;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SEVV8618_TC103001_AuthorizationReferenceNumber extends BaseTest {
    private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
    private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
    String timeStamp;  com.globalMethods.core.FileContentReader FileContentReader =new FileContentReader();
    @BeforeMethod(alwaysRun = true)
    public void tearDown()
    {
        this.timeStamp = CommonMethods.getTimeStamp();

    }

    @Test(enabled = true, groups = {"All"})
    public void SEVV8618_TC103001_AuthorizationReferenceNumber_Valid() throws InterruptedException, java.text.ParseException,  Exception{

        // logger = extent.startTest("SEVV8618_TC103001_AuthorizationReferenceNumber_Valid");
        Map<String ,String> fileUpdateValue = new HashMap<>();
        String fileName;
        //////////////Variable declaration ///////////////////
        Map<String ,String> mapUpdateFileData = new HashMap<>();
        Map<String ,String> finalMapapdataByRow = new HashMap<>();
        Map<String ,String> mapOutboundData = new HashMap<>();
        String FileName;
        List<String> fileNames;
        List<String> Errormessage = new ArrayList<String>();
        fileUpdateValue=GenerateUniqueParam.AuthParams_PipeDelimited_PositveValue_Pensyl();
        fileUpdateValue.put(globalVariables.Authrefnumber, CommonMethods.generateRandomNumberOfFixLength(30));

        logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
        FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.molinaAuthGenericFileSegment, fileUpdateValue,globalVariables.memberAuthFileName,globalVariables.auth,timeStamp);

        logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
        mapOutboundData.put(FileName, "1");
        String outboundFileName= FileContentReader.createOutboundFileAndEncrypt(mapOutboundData,timeStamp);

        logger.log(LogStatus.INFO,"process the Files and get the control file ");
        finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
        System.out.println(finalMapapdataByRow);
        fileNames=FileContentReader.putGetFilefromServerSegmentField(FileName,outboundFileName,null,timeStamp);

        //logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
        assertionDbVerifier.assertControlFileValid(fileNames,FileName,finalMapapdataByRow,outboundFileName,globalVariables.auth,timeStamp);

    }

    @Test(enabled = true, groups = {"All"})
    public void SEVV8618_TC103001_AuthorizationReferenceNumber_InValid_Length() throws InterruptedException, java.text.ParseException,  Exception{

        // logger = extent.startTest("SEVV8618_TC103001_AuthorizationReferenceNumber_InValid_Length");
        Map<String ,String> fileUpdateValue = new HashMap<>();
        String fileName;
        //////////////Variable declaration ///////////////////
        Map<String ,String> mapUpdateFileData = new HashMap<>();
        Map<String ,String> finalMapapdataByRow = new HashMap<>();
        Map<String ,String> mapOutboundData = new HashMap<>();
        String FileName;
        List<String> fileNames;
        List<String> Errormessage = new ArrayList<String>();
        fileUpdateValue=GenerateUniqueParam.AuthParams_PipeDelimited_PositveValue_Pensyl();
        fileUpdateValue.put(globalVariables.Authrefnumber, CommonMethods.generateRandomNumberOfFixLength(31));


        logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
        FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.molinaAuthGenericFileSegment, fileUpdateValue,globalVariables.memberAuthFileName,globalVariables.auth,timeStamp);

        logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
        mapOutboundData.put(FileName, "1");
        String outboundFileName= FileContentReader.createOutboundFileAndEncrypt(mapOutboundData,timeStamp);

        logger.log(LogStatus.INFO,"process the Files and get the control file ");
        finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
        System.out.println(finalMapapdataByRow);
        fileNames=FileContentReader.putGetFilefromServerSegmentField(FileName,outboundFileName,globalVariables.auth,timeStamp);
        logger.log(LogStatus.INFO,"Veirfying the ErrorFile generated ");
        Errormessage.add(globalVariables.AuthorizationReferenceNumberLength);

        assertionDbVerifier.assertControlFileInValid(fileNames,FileName,Errormessage,globalVariables.auth,timeStamp );

    }
    @Test(enabled = true, groups = {"All"})
    public void SEVV8618_TC103001_AuthorizationReferenceNumber_InValid_Blank() throws InterruptedException, java.text.ParseException,  Exception{

        // logger = extent.startTest("SEVV8618_TC103001_AuthorizationReferenceNumber_InValid_Blank");
        Map<String ,String> fileUpdateValue = new HashMap<>();
        String fileName;
        //////////////Variable declaration ///////////////////
        Map<String ,String> mapUpdateFileData = new HashMap<>();
        Map<String ,String> finalMapapdataByRow = new HashMap<>();
        Map<String ,String> mapOutboundData = new HashMap<>();
        String FileName;
        List<String> fileNames;
        List<String> Errormessage = new ArrayList<String>();
        fileUpdateValue=GenerateUniqueParam.AuthParams_PipeDelimited_PositveValue_Pensyl();
        fileUpdateValue.put(globalVariables.Authrefnumber, "");


        logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
        FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.molinaAuthGenericFileSegment, fileUpdateValue,globalVariables.memberAuthFileName,globalVariables.auth,timeStamp);

        logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
        mapOutboundData.put(FileName, "1");
        String outboundFileName= FileContentReader.createOutboundFileAndEncrypt(mapOutboundData,timeStamp);

        logger.log(LogStatus.INFO,"process the Files and get the control file ");
        finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
        System.out.println(finalMapapdataByRow);
        fileNames=FileContentReader.putGetFilefromServerSegmentField(FileName,outboundFileName,globalVariables.auth,timeStamp);
        logger.log(LogStatus.INFO,"Veirfying the ErrorFile generated ");
        Errormessage.add(globalVariables.AuthorizationReferenceNumberLength);
        Errormessage.add(globalVariables.AuthorizationReferenceNumbenullrerror);


        assertionDbVerifier.assertControlFileInValid(fileNames,FileName,Errormessage,globalVariables.auth,timeStamp );

    }
}
