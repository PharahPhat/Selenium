package generic.dsv.business.indiana;

import generic.import_feature.indiana.ImportIndianaProviderGenericTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class Auto_SEVV_8606_TC_100896_Indiana_Import_Provider_Using_GPG_Extension extends ImportIndianaProviderGenericTest {
    @Test()
    public void Auto_SEVV_8606_TC_100896_Indiana_Import_Provider_Using_GPG_Extension() throws IOException {
        logStepInfo("Step 1: Create provider with GPG extension and import to EVV ");
        createAndImportIndianaProviderGPG();

        logStepInfo("Step 2: Verify provider is imported into DB successfully");
        verifyProviderExistInDB();
    }
}
