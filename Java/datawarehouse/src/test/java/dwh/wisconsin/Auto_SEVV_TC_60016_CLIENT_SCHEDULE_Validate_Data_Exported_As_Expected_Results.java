package dwh.wisconsin;

import generic.ClientScheduleGenericTest;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_60016_CLIENT_SCHEDULE_Validate_Data_Exported_As_Expected_Results extends ClientScheduleGenericTest {

    @Test
    public void Auto_SEVV_TC_38683_CLIENT_SCHEDULE_Validate_Data_Exported_As_Expected_Results() {
        initStateInfo();
        GetPreconditionData("TC_0013");
        fileName = preconditionData.get("CLIENT_SCHEDULE");
        validateHeaderAsExpectedResults("headerClientSchedule");
    }
}
