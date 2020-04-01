package generic.rest.interfaces.validation.alt_evv_molina.employee;

import generic.rest.interfaces.InterfacesGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_111111_TC_101111_ALT_EVV_MOLINA_EMPLOYEE_Validate_Fields extends InterfacesGenericTest {
    @Test()
    public void Auto_SEVV_111111_TC_101111_ALT_EVV_MOLINA_EMPLOYEE_Validate_Fields(){
        logStepInfo("Step 1: Validate EmployeeSSN with max length 10");

        boolean result1 =  altEVV_molina_employee.EmployeeSSN(10, false);

        logStepInfo("Step 2: Validate EmployeeLastName with max length 31");

        boolean result2 =  altEVV_molina_employee.EmployeeLastName(31, false);

        Assert.assertTrue((result1 && result2), "Failed Test Case.");
    }
}
