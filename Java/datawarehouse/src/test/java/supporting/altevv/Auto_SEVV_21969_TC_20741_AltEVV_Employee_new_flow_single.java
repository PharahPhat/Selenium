package supporting.altevv;

import com.interop.models.altevv.employee.AltEvvEmployee;
import com.interop.services.atlevv.AltEvvEmployeeService;
import com.sandata.qtest.QTest;
import generic.GenericTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Auto_SEVV_21969_TC_20741_AltEVV_Employee_new_flow_single extends GenericTest {

    private String employeeIdentifier;

    @Test()
    @QTest()
    public void Auto_SEVV_TC_20741_AltEVV_Employee_new_flow() {
        AltEvvEmployeeService altEVVGenericEmp = new AltEvvEmployeeService();
        altEVVGenericEmp.setEntityGuid(true);

        baseObj.info("generate multi records");
        List<AltEvvEmployee> altEvvEmployees = new ArrayList<>();

        employeeIdentifier = "0000" + baseObj.generateRandomNumberObsolete(5);
        AltEvvEmployee altEvvEmployee = AltEvvEmployee.builder()
                .employeeIdentifier(employeeIdentifier)
                .build();
        altEvvEmployees.add(altEvvEmployee);
        altEVVGenericEmp.loadPayload(altEvvEmployees);

        baseObj.info("Step 1: Send request");
        altEVVGenericEmp.post();

        baseObj.info("Step 2: Send get request");
        altEVVGenericEmp.requestUUIDStatus();

        baseObj.info("Step 3: Verify get message");
        altEVVGenericEmp.validateUuidResponse();
    }
}
