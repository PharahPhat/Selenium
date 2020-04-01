package samplevalidation.openevv.pa;

import com.interop.services.openevv.OpenEvvEmployeeService;
import com.interop.common.TestDataHelper;
import generic.rest.interfaces.InterfacesGenericTest;
import io.qameta.allure.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

public class Auto_SEVV_6789_TC_10011_OpenEVV_PA_FieldValidation extends InterfacesGenericTest {

    private String filePath = System.getProperty("user.dir") + File.separator + "TestData/fileDataDriven/data_driven_sample.csv";

    @DataProvider(name = "invalidFieldValidation")
    public Object[][] getDataDriven() {
        return TestDataHelper.getFieldValidationDataRows(state, filePath);
    }

    @Test(dataProvider = "invalidFieldValidation")
    @Description("Field Validation Test for OpenEVV Employee endpoint")
    public void Auto_SEVV_6789_TC_10011_OPENVV_FieldValidation(String propertyName,
                                                               String propertyType,
                                                               String propertyValue,
                                                               String expectedMessage,
                                                               String caseDescription) {
        OpenEvvEmployeeService employeeAPI = OpenEvvEmployeeService.init();
        //baseObj.info("Step 1: Init pageLoad");
        employeeAPI.modifyPropertyValue(propertyName, propertyType, propertyValue);
        //baseObj.info("Step 2: Sending the Post request");
        employeeAPI.post();
        employeeAPI.verifyMDWFailedWithMessageSummary("abc",expectedMessage);
    }
}
