package dwh.ohio;

import generic.ClientScheduleGenericTest;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_18779_CLIENT_SCHEDULE_Validate_Provider_Data_Exported_As_Expected_Results extends ClientScheduleGenericTest {

    @Test
    public void Auto_SEVV_TC_18762_CLIENT_SCHEDULE_Validate_Provider_Data_Exported_As_Expected_Results(){
        initStateInfo();
        GetPreconditionData("TC_0002");
        fileName  = preconditionData.get("CLIENTSCHEDULE");
        //validateProviderGeneralIsGeneratedAsExpectedResults();
    }
}
