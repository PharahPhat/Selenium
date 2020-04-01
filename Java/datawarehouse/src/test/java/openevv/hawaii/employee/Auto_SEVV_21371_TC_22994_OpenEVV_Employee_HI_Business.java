package openevv.hawaii.employee;

import com.interop.common.StateAccount;
import com.interop.common.TestDataHelper;
import com.interop.common.dataprovider.DataValidationModel;
import com.interop.models.openevv.employee.OpenEvvEmployee;
import com.interop.models.openevv.employee.OpenEvvEmployeeDataGenerator;
import com.interop.services.base.DataValidationTest;
import com.interop.services.openevv.OpenEvvEmployeeService;
import com.sandata.core.annotation.FieldValidation;
import com.sandata.qtest.QTest;
import generic.GenericTest;
import io.qameta.allure.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@SuppressWarnings({"unchecked", "rawtypes"})
public class Auto_SEVV_21371_TC_22994_OpenEVV_Employee_HI_Business extends GenericTest {
    private static final String stringKey = StateAccount.loadStateAccount().getStateEnum().getStringKey();
    private static final String OPEN_EVV_EMP_VALIDATION_CSV = "OpenEVV/Employee/OpenEVVEmployee_" + stringKey + "_Business.csv";
    private DataValidationTest dataValidationTest;
    private OpenEvvEmployeeService openEvvEmployee = new OpenEvvEmployeeService();
    private OpenEvvEmployee employee = OpenEvvEmployeeDataGenerator.getOpenEvvEmployeeByState(stateAccount.getStateEnum());
    @DataProvider(name = "GenericFieldValidation")
    public Object[][] getInValidDataDriven(Method method) {
        dataValidationTest = new DataValidationTest(openEvvEmployee, employee);
        FieldValidation annotation = method.getAnnotation(FieldValidation.class);
        String dataFilter = "";
        if (method.getAnnotationsByType(FieldValidation.class).length > 0) {
            dataFilter = annotation.propertyFilter();
        }
        return TestDataHelper.getFieldValidationDataRows(state, OPEN_EVV_EMP_VALIDATION_CSV, dataFilter);
    }

    @Description("OpenEVV-Employee: Verify Employee is updated after sending the same EmployeePIN")
    @QTest(keys = {"TC-22993"})
    @Test(dataProvider = "GenericFieldValidation", groups = {"EmployeePIN"}, testName = "EmployeePIN")
    @FieldValidation(propertyFilter = "EmployeePIN")
    public void Auto_SEVV_21371_TC_22994_OpenEVV_EmployeePIN_Updated_Data(DataValidationModel dataTest) {
        dataValidationTest.validateDataValidationField(dataTest);
        employee = OpenEvvEmployeeDataGenerator.getOpenEvvEmployeeByState(stateAccount.getStateEnum());
        employee.setEmployeePIN(dataTest.getPropertyValue());
        dataValidationTest = new DataValidationTest(openEvvEmployee, employee);
        dataValidationTest.validateDataUpdateField(dataTest, "EmployeePIN");
    }

    @Description("OpenEVV-Employee: Verify Employee is updated after sending the same EmployeeID")
    @QTest(keys = {"TC-22994"})
    @Test(dataProvider = "GenericFieldValidation", groups = {"EmployeeID"}, testName = "EmployeeID")
    @FieldValidation(propertyFilter = "EmployeeID")
    public void Auto_SEVV_21371_TC_22994_OpenEVV_EmployeeID_Updated_Data(DataValidationModel dataTest) {
        dataValidationTest.validateDataValidationField(dataTest);
        employee = OpenEvvEmployeeDataGenerator.getOpenEvvEmployeeByState(stateAccount.getStateEnum());
        employee.setEmployeeID(dataTest.getPropertyValue());
        dataValidationTest = new DataValidationTest(openEvvEmployee, employee);
        dataValidationTest.validateDataUpdateField(dataTest, "EmployeeID");
    }
}