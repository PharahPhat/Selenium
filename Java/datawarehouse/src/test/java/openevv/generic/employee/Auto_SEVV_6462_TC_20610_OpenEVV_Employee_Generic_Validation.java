package openevv.generic.employee;

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

import static com.interop.common.Commons.AccountType.AMP;
import static com.interop.common.Commons.AccountType.GENERIC;

/**
 * Author by: NhonNguyen
 * Run Script for HI, AZ, VT
 */

@SuppressWarnings({"unchecked", "rawtypes"})
public class Auto_SEVV_6462_TC_20610_OpenEVV_Employee_Generic_Validation extends GenericTest {
    private DataValidationTest dataValidationTest;
    private final String stringKey = this.stateAccount.getStateEnum().getStringKey();
    private OpenEvvEmployeeService openEvvEmployee = new OpenEvvEmployeeService();

    @DataProvider(name = "GenericFieldValidation")
    public Object[][] getInValidDataDriven(Method method) {
        String fileName;
        FieldValidation annotation = method.getAnnotation(FieldValidation.class);
        String dataFilter = "";
        if (method.getAnnotationsByType(FieldValidation.class).length > 0) {
            method.getAnnotation(FieldValidation.class);
            dataFilter = annotation.propertyFilter();
        }
        if (AMP.toString().equalsIgnoreCase(this.stateAccount.getAccountType())) {
            fileName = "OpenEVV/Employee/OpenEVVEmployee_Generic_ValidationFields.csv";
            this.openEvvEmployee.setAMPAccount(true);
            return TestDataHelper.getFieldValidationDataRows(GENERIC.toString(), fileName, dataFilter);
        } else {
            fileName = "OpenEVV/Employee/OpenEVVEmployee_" + this.stringKey + "_ValidationFields.csv";
            return TestDataHelper.getFieldValidationDataRows(this.state, fileName, dataFilter);
        }
    }

    @Test(dataProvider = "GenericFieldValidation", groups = {"openEVVEmployee"})
    public void Auto_SEVV_12596_TC_39298_OpenEVV_Employee_Generic_Validation(DataValidationModel dataTest) {
        OpenEvvEmployee employee = OpenEvvEmployeeDataGenerator.getOpenEvvEmployeeByState(this.stateAccount.getStateEnum());
        this.dataValidationTest = new DataValidationTest(this.openEvvEmployee, employee);
        this.dataValidationTest.validateDataValidationField(dataTest);
    }

    @Description("EmployeePIN = 9 digit string; REJECT if <> 9 char")
    @QTest(keys = {"TC-23066", "TC-22987"})
    @Test(dataProvider = "GenericFieldValidation", groups = {"EmployeePIN", "smoke", "high"}, testName = "EmployeePIN")
    @FieldValidation(propertyFilter = "EmployeePIN")
    public void Auto_SEVV_21371_TC_22987_OpenEVV_EmployeePIN_Validation(DataValidationModel dataTest) {
        OpenEvvEmployee employee = OpenEvvEmployeeDataGenerator.getOpenEvvEmployeeByState(this.stateAccount.getStateEnum());
        this.dataValidationTest = new DataValidationTest(this.openEvvEmployee, employee);
        this.dataValidationTest.validateDataValidationField(dataTest);
    }

    @Description("EmployeeID = 9 digit string; REJECT if <> 9 char")
    @QTest(keys = {"TC-22945"})
    @Test(dataProvider = "GenericFieldValidation", groups = {"EmployeeID", "smoke", "high"}, testName = "EmployeeID")
    @FieldValidation(propertyFilter = "EmployeeID")
    public void Auto_SEVV_21371_TC_22945_OpenEVV_EmployeeID_Validation(DataValidationModel dataTest) {
        OpenEvvEmployee employee = OpenEvvEmployeeDataGenerator.getOpenEvvEmployeeByState(this.stateAccount.getStateEnum());
        this.dataValidationTest = new DataValidationTest(this.openEvvEmployee, employee);
        this.dataValidationTest.validateDataValidationField(dataTest);
    }

    @Description("EmployeeSSN = 9 digit string; REJECT if <> 9 char")
    @QTest(keys = {"TC-22947"})
    @Test(dataProvider = "GenericFieldValidation", groups = {"EmployeeSSN"}, testName = "EmployeeSocialSecurity")
    @FieldValidation(propertyFilter = "EmployeeSocialSecurity")
    public void Auto_SEVV_21371_TC_22947_OpenEVV_EmployeeSSN_Validation(DataValidationModel dataTest) {
        OpenEvvEmployee employee = OpenEvvEmployeeDataGenerator.getOpenEvvEmployeeByState(this.stateAccount.getStateEnum());
        this.dataValidationTest = new DataValidationTest(this.openEvvEmployee, employee);
        this.dataValidationTest.validateDataValidationField(dataTest);
    }

    @Description("Account = Sandata Assigned")
    @QTest(keys = {"TC-22946"})
    @Test(dataProvider = "GenericFieldValidation", groups = {"Account"}, testName = "Account")
    @FieldValidation(propertyFilter = "Account")
    public void Auto_SEVV_21371_TC_22946_OpenEVV_Account_Validation(DataValidationModel dataTest) {
        OpenEvvEmployee employee = OpenEvvEmployeeDataGenerator.getOpenEvvEmployeeByState(this.stateAccount.getStateEnum());
        this.dataValidationTest = new DataValidationTest(this.openEvvEmployee, employee);
        this.dataValidationTest.validateDataValidationField(dataTest);
    }

    @Description("EmployeeIDCustom1 = 9 digit string; REJECT if <> 9 char")
    @Test(dataProvider = "GenericFieldValidation", groups = {"EmployeeIDCustom1"}, testName = "EmployeeIDCustom1")
    @FieldValidation(propertyFilter = "EmployeeIDCustom1")
    public void Auto_SEVV_21371_TC_22948_OpenEVV_Account_Validation(DataValidationModel dataTest) {
        OpenEvvEmployee employee = OpenEvvEmployeeDataGenerator.getOpenEvvEmployeeByState(this.stateAccount.getStateEnum());
        this.dataValidationTest = new DataValidationTest(this.openEvvEmployee, employee);
        this.dataValidationTest.validateDataValidationField(dataTest);
    }
}
