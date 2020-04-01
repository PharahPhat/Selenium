package altevv.generic.employee;

import com.interop.common.StateAccount;
import com.interop.common.TestDataHelper;
import com.interop.common.dataprovider.DataValidationModel;
import com.interop.models.altevv.employee.AltEvvEmployee;
import com.interop.services.atlevv.AltEvvEmployeeService;
import com.interop.services.base.DataValidationTest;
import com.sandata.core.annotation.FieldValidation;
import com.sandata.qtest.QTest;
import generic.GenericTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static com.interop.models.altevv.employee.AltEvvEmployeeDataGenerator.getAltEvvEmployeeByState;


@SuppressWarnings({"rawtypes", "unchecked"})
public class Auto_SEVV_20161_TC_21299_AltEVV_Employee_Validation extends GenericTest {
    private static final String stringKey = StateAccount.loadStateAccount().getStateEnum().getStringKey();
    private static final String ALT_EMPLOYEE_VALIDATION_CSV = "AltEVV/Employee/AltEVVEmployee_"+ stringKey +"_Validation.csv";
    private AltEvvEmployeeService employeeService = new AltEvvEmployeeService();
    private DataValidationTest dataValidationTest;

    @DataProvider(name = "FieldValidation")
    public Object[][] getDataFieldValidation(Method method) {
        AltEvvEmployee model = getAltEvvEmployeeByState(StateAccount.loadStateAccount());
        dataValidationTest = new DataValidationTest(employeeService, model);
        FieldValidation annotation = method.getAnnotation(FieldValidation.class);
        String dataFilter = "";
        if (method.getAnnotationsByType(FieldValidation.class).length > 0) {
            method.getAnnotation(FieldValidation.class);
            dataFilter = annotation.propertyFilter();
        }
        return TestDataHelper.getFieldValidationDataRows(state, ALT_EMPLOYEE_VALIDATION_CSV, dataFilter);
    }

    @Test(dataProvider = "FieldValidation", groups = {"generic", "altEmployee", "smoke" , "high"})
    @QTest(keys = {"TC-21949", "TC-22672", "TC-21322", "TC-22630", "TC-22631", "TC-22632", "TC-22633", "TC-22634", "TC-22635"})
    public void Auto_SEVV_20161_Field_Validation(DataValidationModel dataTest) {
        dataValidationTest.validateDataValidationField(dataTest);
    }
}
