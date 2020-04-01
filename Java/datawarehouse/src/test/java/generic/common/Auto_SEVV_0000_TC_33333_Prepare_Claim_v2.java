package generic.common;

import com.sandata.utils.OhioDataUtils;
import generic.DWHGenericTest;
import org.testng.annotations.Test;

public class Auto_SEVV_0000_TC_33333_Prepare_Claim_v2 extends DWHGenericTest {
    @Test(enabled = true, groups = {"All"})
    public void Auto_SEVV_0000_TC_33333_Prepare_Claim_v2() throws Exception {
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

        ohioDataUtils.batchId = commons.generateUniqueNumber();
        ohioDataUtils.initClaims("qa_visit_ODM_SP_T1001_2019_05_10.txt", "2019-05-10", "2019-05-14" );
//        ohioDataUtils.initClaims("qa_visit_ODM_SP_T1001_2019_05_11.txt", "2019-05-10", "2019-05-14" );
//        ohioDataUtils.initClaims("qa_visit_ODM_SP_T1001_2019_05_12.txt", "2019-05-10", "2019-05-14" );
        ohioDataUtils.toBatchClaimFile();
    }
}
