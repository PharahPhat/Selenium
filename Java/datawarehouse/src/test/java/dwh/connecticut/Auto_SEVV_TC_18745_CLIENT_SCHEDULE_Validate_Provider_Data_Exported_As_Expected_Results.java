package dwh.connecticut;

import com.sandata.qtest.QTest;
import generic.ClientScheduleGenericTest;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_18745_CLIENT_SCHEDULE_Validate_Provider_Data_Exported_As_Expected_Results extends ClientScheduleGenericTest {

    @Test
    @QTest(keys = {"TC-18745"})
    public void Auto_SEVV_TC_18745_CLIENT_SCHEDULE_Validate_Provider_Data_Exported_As_Expected_Results(){
        initStateInfo();
        GetPreconditionData("TC_0003");
        fileName  = preconditionData.get("CLIENT_SCHEDULE");
        validateHeaderAsExpectedResults("headerClientSchedule");
    }
}
