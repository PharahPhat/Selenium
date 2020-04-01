package samplevalidation.openevv.ct;

import com.sandata.ws.EmployeeRestfulService;
import generic.rest.interfaces.InterfacesGenericTest;
import org.testng.annotations.Test;

public class Auto_SEVV_12596_TC_14410_OPEN_EVV_CDS_INTAKE_CLIENT_MEMBER_Validation_for_Employee extends InterfacesGenericTest {

    @Test()
    public void Auto_SEVV_12596_TC_14410_OPEN_EVV_CDS_INTAKE_CLIENT_MEMBER_Validation_for_Employee() {
        EmployeeRestfulService providerService = new EmployeeRestfulService();

        baseObj.info("Step 1: Init pageLoad");
        //providerService.modifyPropertyValue("EmployeePIN","56321");

        baseObj.info("Step 2: Sending the Post request");
        providerService.post();

        baseObj.info("Step 3: verify MDW Validation Pass");
        if (testType.trim().equalsIgnoreCase("valid")) {
            providerService.verifyMDWPass();
        }
    }

}
