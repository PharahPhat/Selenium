package samplevalidation.openevv.ohio;

import com.sandata.ws.ClaimRestfulService;
import generic.rest.interfaces.InterfacesGenericTest;
import org.testng.annotations.Test;

public class Auto_SEVV_12596_TC_10020_OPEN_EVV_OHIO_INTAKE_CLAIM_Validation_for_Claim extends InterfacesGenericTest {
    @Test()
    public void Auto_SEVV_12596_TC_10020_OPEN_EVV_OHIO_INTAKE_CLAIM_Validation_for_Claim() {
        ClaimRestfulService claimService = new ClaimRestfulService();

        baseObj.info("Step 1: Init pageLoad");
        claimService.modifyPropertyValue("BatchID","56321");

        baseObj.info("Step 2: Sending the Post request");
        claimService.post();

        baseObj.info("Step 3: verify MDW Validation Pass");
        if (testType.trim().equalsIgnoreCase("valid")) {
            claimService.verifyMDWPass();
        }
    }
}
