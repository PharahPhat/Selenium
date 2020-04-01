package performance;

import com.interop.services.atlevv.AltEvvVisitService;
import generic.GenericTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Auto_SEVV_18119_TC_19193_AltGeneric_Generate_Json_Visit_Data extends GenericTest {
    private AltEvvVisitService visitAPI = null;
    private static final int numberVisit = 10; //the count of visit want to import
    private static final int numberGenerateFiles = 5;

    @Test
    public void Auto_SEVV_18119_TC_19193_AltGeneric_Generate_Json_Visit_Data_Jmeter() throws IOException {
        List<String> memoList = new ArrayList<>();
        for(int i = 0; i< numberGenerateFiles; i++) {
            String memo = "ViPer" + commons.generateRandomAlphaNumeric(10);
            LOGGER.info("memo -------------- " + memo);
            visitAPI = AltEvvVisitService.init(numberVisit, memo);
            String body = visitAPI.generateJsonData();
            commons.generateJsonBody(body, memo + ".txt");
            memoList.add(memo);
        }
        //commons.GenerateToJemterFilePerformanceTestingVisit(memoList);
    }

    @Test()
    public void Auto_SEVV_6462_TC_19193_AltGeneric_Visit_Performance(){
        String expectedStatus = "SUCCESS";
        //String expectedMessage = "";
        String memo = "ViPer" + commons.generateRandomAlphaNumeric(50);
        visitAPI = AltEvvVisitService.init(5000, memo);
        //String body = visitAPI.GenerateJsonData();
        //commons.generateJsonBody(body,"PerformanceVisit.txt");
        visitAPI.post();
        visitAPI.verifyPostStatus(expectedStatus);
        visitAPI.requestUUIDStatus();
        //visitAPI.verifyErrorCode(expectedMessage);
    }
}
