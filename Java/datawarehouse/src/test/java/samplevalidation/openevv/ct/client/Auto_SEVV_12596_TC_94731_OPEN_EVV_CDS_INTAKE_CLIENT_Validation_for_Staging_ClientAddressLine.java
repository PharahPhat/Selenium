package samplevalidation.openevv.ct.client;

import com.interop.common.TestDataHelper;
import generic.GenericTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Auto_SEVV_12596_TC_94731_OPEN_EVV_CDS_INTAKE_CLIENT_Validation_for_Staging_ClientAddressLine extends GenericTest {

    @DataProvider(name = "validFieldValidation")
    public Object[][] getDataDriven() {
        String fileName = "OpenEvvGenericClient_ClientAddressSegmentValidation.csv";
        return TestDataHelper.getFieldValidationDataRows(state, fileName);
    }

    @Test(dataProvider = "validFieldValidation")
    public void Auto_SEVV_12596_TC_94731_OPEN_EVV_CDS_INTAKE_CLIENT_Validation_for_ClientAddressLine(String description,
                                                                                                     String propertyName,
                                                                                                     String propertyType,
                                                                                                     String propertyValue,
                                                                                                     String postStatus,
                                                                                                     String expectedMessage,
                                                                                                     String uuidStatus){



    }


}
