package generic.rest.interfaces.loadtest.alt_evv_molina.employee;

import generic.rest.interfaces.InterfacesGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_111111_TC_102177_ALT_EVV_MOLINA_EMPLOYEE_Insert_Maximum_New_Employees extends InterfacesGenericTest {
    @Test()
    public void Auto_SEVV_111111_TC_102177_ALT_EVV_MOLINA_EMPLOYEE_Insert_Maximum_New_Employees(){
        logStepInfo("Step 1: Post request to create new single valid molina employee");

        boolean result =  altEVV_molina_employee.createMulipleEmployees(1000);

        Assert.assertTrue(result, "Failed to create Maximum valid molina employees");
    }
}
