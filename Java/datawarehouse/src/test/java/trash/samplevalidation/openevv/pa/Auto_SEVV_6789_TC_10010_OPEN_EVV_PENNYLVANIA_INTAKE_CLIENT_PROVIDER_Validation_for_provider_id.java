package samplevalidation.openevv.pa;

import com.sandata.utilities.CSVReader;
import com.sandata.ws.ProviderRestfulService;
import generic.rest.interfaces.InterfacesGenericTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

import static com.sandata.utilities.CSVReader.readCSVFile;

public class Auto_SEVV_6789_TC_10010_OPEN_EVV_PENNYLVANIA_INTAKE_CLIENT_PROVIDER_Validation_for_provider_id extends InterfacesGenericTest {

    private String filePath = System.getProperty("user.dir") + File.separator + "TestData/fileDataDriven/data_driven_sample.csv";
    private CSVReader fileTestDataDriven = readCSVFile(filePath);

    @DataProvider(name = "invalidFieldValidation")
    public Object[][] getDataDriven() {
//        return getFieldValidationDataRows(fileTestDataDriven);
        return null;
    }

    @Test(dataProvider = "invalidFieldValidation")
    public void Auto_SEVV_6789_TC_10010_OPEN_EVV_PENNYLVANIA_INTAKE_CLIENT_PROVIDER_Validation_for_provider_id(String[] fieldNameAndValue,
                                                                                                               String testType,
                                                                                                               String expectedMessage) {
        ProviderRestfulService providerService = new ProviderRestfulService();

        baseObj.info(String.format("Testing for field %s this is %s data", fieldNameAndValue,testType));
        baseObj.info("Step 2: Sending the Post request");
        providerService.post();

        baseObj.info("Step 3: verify MDW Validation Pass");
        if (testType.trim().equalsIgnoreCase("valid")) {
            providerService.verifyMDWPass();
        } else {
            providerService.verifyMDWFailedWithMessageSummary(expectedMessage);
        }
    }

}
