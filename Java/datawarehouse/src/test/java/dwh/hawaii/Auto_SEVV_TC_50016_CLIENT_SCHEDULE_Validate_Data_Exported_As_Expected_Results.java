package dwh.hawaii;

import com.sandata.qtest.QTest;
import generic.ClientScheduleGenericTest;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_50016_CLIENT_SCHEDULE_Validate_Data_Exported_As_Expected_Results extends ClientScheduleGenericTest {

    @Test
    @QTest(keys = {"TC-18745"})
    public void Auto_SEVV_TC_50016_CLIENT_SCHEDULE_Validate_Data_Exported_As_Expected_Results(){
        initStateInfo();
        GetPreconditionData("TC_0012");
        fileName  = preconditionData.get("CLIENT_SCHEDULE");
        validateHeaderAsExpectedResults("headerClientSchedule");
    }
}
