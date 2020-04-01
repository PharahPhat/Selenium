package dwh.vermont;

import com.sandata.qtest.QTest;
import generic.ClientScheduleGenericTest;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_38683_CLIENT_SCHEDULE_Validate_Data_Exported_As_Expected_Results extends ClientScheduleGenericTest {

    @Test
    @QTest(keys = {"TC-18745"})
    public void Auto_SEVV_TC_38683_CLIENT_SCHEDULE_Validate_Data_Exported_As_Expected_Results(){
        initStateInfo();
        GetPreconditionData("TC_0010");
        fileName  = preconditionData.get("CLIENTSCHEDULE");
        validateHeaderAsExpectedResults("headerClientSchedule");
    }
}
