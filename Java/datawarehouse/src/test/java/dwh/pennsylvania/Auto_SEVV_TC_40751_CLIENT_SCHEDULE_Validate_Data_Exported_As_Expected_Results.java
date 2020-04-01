package dwh.pennsylvania;

import com.sandata.qtest.QTest;
import generic.ClientScheduleGenericTest;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_40751_CLIENT_SCHEDULE_Validate_Data_Exported_As_Expected_Results extends ClientScheduleGenericTest {

    @Test
    @QTest(keys = {"TC-18745"})
    public void Auto_SEVV_TC_18796_CLIENT_SCHEDULE_Validate_Data_Exported_As_Expected_Header_Results(){
        initStateInfo();
        GetPreconditionData("TC_0006");
        fileName  = preconditionData.get("CLIENT_SCHEDULE");
        validateHeaderAsExpectedResults("headerClientSchedule");
    }
}
