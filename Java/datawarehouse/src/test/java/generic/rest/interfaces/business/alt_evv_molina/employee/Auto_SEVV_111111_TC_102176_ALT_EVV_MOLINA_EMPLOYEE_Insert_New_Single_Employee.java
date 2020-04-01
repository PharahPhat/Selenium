package generic.rest.interfaces.business.alt_evv_molina.employee;

import generic.rest.interfaces.InterfacesGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_111111_TC_102176_ALT_EVV_MOLINA_EMPLOYEE_Insert_New_Single_Employee extends InterfacesGenericTest {
    @Test()
    public void Auto_SEVV_111111_TC_102176_ALT_EVV_MOLINA_EMPLOYEE_Insert_New_Single_Employee(){
        logStepInfo("Step 1: Post request to create new single valid molina employee");

        boolean result =  altEVV_molina_employee.createSingleEmployee();

        Assert.assertTrue((result), "Failed to create single valid molina employee");
    }
}
