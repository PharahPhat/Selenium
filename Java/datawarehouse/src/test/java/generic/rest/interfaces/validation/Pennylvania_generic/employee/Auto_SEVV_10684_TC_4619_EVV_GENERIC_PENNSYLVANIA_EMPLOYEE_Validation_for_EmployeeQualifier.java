package generic.rest.interfaces.validation.Pennylvania_generic.employee;

import com.sandata.common.Constant;
import generic.rest.interfaces.InterfacesGenericTest;
import org.testng.annotations.Test;


public class Auto_SEVV_10684_TC_4619_EVV_GENERIC_PENNSYLVANIA_EMPLOYEE_Validation_for_EmployeeQualifier extends InterfacesGenericTest {

    @Test
    public void Auto_SEVV_10684_TC_4619_EVV_GENERIC_PENNSYLVANIA_EMPLOYEE_Validation_for_EmployeeQualifier() {
        boolean result1 = altEVV_pa_employee.EmployeeQualifier(Constant.DataType.userInput, 0, "EmployeeSSN", true);
    }
}

