package samplevalidation.altgenericvisit.vermont;
import com.interop.common.TestDataHelper;
import generic.rest.interfaces.InterfacesGenericTest;
import io.qameta.allure.Description;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Auto_SEVV_TC_10011_AltGenericVisit_VM_FieldValidation extends InterfacesGenericTest {
    private String filePath = System.getProperty("user.dir") + File.separator + "TestData/fileDataDriven/AltGenericVisitFieldValidationByField.csv";

    @DataProvider(name = "invalidFieldValidation")
    public Object[][] getDataDriven() {
        String fileName = "AltGenericVisitFieldValidationByField.csv";
        return TestDataHelper.getFieldValidationDataRows(state, fileName);
    }

    @Test(dataProvider = "invalidFieldValidation")
    @Description("Field Validation Test for OpenEVV Employee endpoint")
    public void Auto_SEVV_TC_10011_AltGenericVisit_VM_FieldValidation(String description,
                                                              String propertyName,
                                                              String propertyType,
                                                              String propertyValue,
                                                              String postStatus,
                                                              String expectedMessage,
                                                              String uuidStatus,
                                                              String uuidExpectedError) throws IOException, ParseException {

    }
}
