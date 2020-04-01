package generic.common;

import com.sandata.utils.OhioDataUtils;
import generic.DWHGenericTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Auto_SEVV_0000_TC_22222_Prepare_Visit extends DWHGenericTest {
    @Test(enabled = true, groups = {"All"})
    public void Auto_SEVV_0000_TC_22222_Prepare_Visit() throws IOException {
        OhioDataUtils ohioDataUtils = new OhioDataUtils();

        String DateTimeIn1 = "2019-05-10T08:10:00Z";
        String DateTimeOut1 = "2019-05-10T11:10:00Z";

        String DateTimeIn2 = "2019-05-11T08:10:00Z";
        String DateTimeOut2 = "2019-05-11T11:10:00Z";

        String DateTimeIn3 = "2019-05-12T08:10:00Z";
        String DateTimeOut3 = "2019-05-12T11:10:00Z";

        String DateTimeIn4 = "2019-05-13T08:10:00Z";
        String DateTimeOut4 = "2019-05-13T11:10:00Z";

        String DateTimeIn5 = "2019-05-14T08:10:00Z";
        String DateTimeOut5 = "2019-05-14T11:10:00Z";

        List<String> adjInDateTimes = Arrays.asList(DateTimeIn1, DateTimeIn2, DateTimeIn3, DateTimeIn4, DateTimeIn5);
        List<String> callInDateTimes = Arrays.asList(DateTimeIn1, DateTimeIn2, DateTimeIn3, DateTimeIn4, DateTimeIn5);
        List<String> callOutDateTimes = Arrays.asList(DateTimeOut1, DateTimeOut2, DateTimeOut3, DateTimeOut4, DateTimeOut5);

            ohioDataUtils.createMultipleVisits(100000, "ODM", "ODM", "SP", "T1001",
                    adjInDateTimes, callInDateTimes, callOutDateTimes);

//        ohioDataUtils.createMultipleVisits(1, "DODD", "DODD", "DD", "T1003",
//                "2019-05-25T08:10:00Z", "2019-05-25T08:10:00Z", "2019-05-25T11:5:00Z");
//        ohioDataUtils.createMultipleVisits(1, "Aetna", "Aetna", "MyC", "T1002",
//                "2019-05-25T08:10:00Z", "2019-05-25T08:10:00Z", "2019-05-25T11:5:00Z");
//        ohioDataUtils.createMultipleVisits(1, "Buckeye", "Buckeye", "SP", "G0156",
//                "2019-05-25T08:10:00Z", "2019-05-25T08:10:00Z", "2019-05-25T11:5:00Z");
//        ohioDataUtils.createMultipleVisits(1, "UHC", "UHC", "SP", "G0156",
//                "2019-05-25T08:10:00Z", "2019-05-25T08:10:00Z", "2019-05-25T11:5:00Z");
    }
}
