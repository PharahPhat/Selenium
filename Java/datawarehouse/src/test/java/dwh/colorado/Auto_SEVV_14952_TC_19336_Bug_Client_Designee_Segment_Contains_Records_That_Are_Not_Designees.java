package dwh.colorado;

import generic.ClientDesigneesTest;
import org.testng.annotations.Test;

public class Auto_SEVV_14952_TC_19336_Bug_Client_Designee_Segment_Contains_Records_That_Are_Not_Designees extends ClientDesigneesTest {
    @Test
    public void Auto_SEVV_14952_TC_19336_Bug_Client_Designee_Segment_Contains_Records_That_Are_Not_Designees(){
        initStateInfo();
        GetPreconditionData("TC_0004");
        fileName  = preconditionData.get("CLIENTDESIGNEE");
        validateHeaderClientDesigneeAsExpectedResults();
        //validateAllRecordsClientDesigneesFileAreClientDesigneesInDB();
    }
}
