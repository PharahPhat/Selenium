package dwh.indiana;

import com.sandata.qtest.QTest;
import generic.ClientScheduleGenericTest;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_40686_CLIENT_SCHEDULE_Validate_Provider_Data_Exported_As_Expected_Results extends ClientScheduleGenericTest {

    @Test
    @QTest(keys = {"TC-18745"})
    public void Auto_SEVV_TC_40686_CLIENT_SCHEDULE_Validate_Provider_Data_Exported_As_Expected_Results(){
        initStateInfo();
        GetPreconditionData("TC_0007");
        fileName  = preconditionData.get("CLIENT_SCHEDULE");
        validateHeaderAsExpectedResults("headerClientSchedule");
    }
}
