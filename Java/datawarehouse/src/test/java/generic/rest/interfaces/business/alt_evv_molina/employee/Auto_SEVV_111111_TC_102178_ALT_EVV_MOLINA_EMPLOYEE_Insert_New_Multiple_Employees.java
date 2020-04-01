package generic.rest.interfaces.business.alt_evv_molina.employee;

import generic.rest.interfaces.InterfacesGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_111111_TC_102178_ALT_EVV_MOLINA_EMPLOYEE_Insert_New_Multiple_Employees extends InterfacesGenericTest {
    @Test()
    public void Auto_SEVV_111111_TC_102178_ALT_EVV_MOLINA_EMPLOYEE_Insert_New_Multiple_Employees(){
        logStepInfo("Step 1: Post request to create new single valid molina employee");

        boolean result =  altEVV_molina_employee.createMulipleEmployees(5);

        Assert.assertTrue(result, "Failed to create multiple valid molina employees");
    }
}
