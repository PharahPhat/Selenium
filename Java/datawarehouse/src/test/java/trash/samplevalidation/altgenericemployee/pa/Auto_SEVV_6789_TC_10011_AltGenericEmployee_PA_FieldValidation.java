package samplevalidation.altgenericemployee.pa;

import com.interop.services.atlevv.AltEvvEmployeeService;
import com.interop.common.TestDataHelper;
import generic.rest.interfaces.InterfacesGenericTest;
import io.qameta.allure.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

public class Auto_SEVV_6789_TC_10011_AltGenericEmployee_PA_FieldValidation extends InterfacesGenericTest {

    private String filePath = System.getProperty("user.dir") + File.separator + "TestData/fileDataDriven/AltGenericEmployeeFieldValidation.csv";

    @DataProvider(name = "invalidFieldValidation")
    public Object[][] getDataDriven() {
        return TestDataHelper.getFieldValidationDataRows(state, filePath);
    }

    @Test(dataProvider = "invalidFieldValidation")
    @Description("Field Validation Test for OpenEVV Employee endpoint")
    public void Auto_SEVV_TC_10011_AltGeneric_FieldValidation(String propertyName,
                                                              String propertyType,
                                                              String propertyValue,
                                                              String expectedMessage,
                                                              String caseDescription) {
        AltEvvEmployeeService employeeAPI = AltEvvEmployeeService.init();

        employeeAPI.modifyPropertyValue(propertyName, propertyType, propertyValue);

        employeeAPI.post();

        employeeAPI.verifyMDWFailedWithMessageSummary("[1] Records uploaded, please check errors/warnings and try again.", expectedMessage);
    }
}
