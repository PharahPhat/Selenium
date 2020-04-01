package generic.dsv.business.indiana;

import generic.import_feature.indiana.ImportIndianaProviderGenericTest;
import org.testng.annotations.Test;

public class Auto_SEVV_8606_TC_100898_Indiana_Import_using_unencrypted_files extends ImportIndianaProviderGenericTest {

    @Test
    public void Auto_SEVV_8606_TC_100898_Indiana_Import_using_unencrypted_files(){
        logStepInfo("Create and import provider file with .txt extension");
        createAndImportIndianaUnencryptedProvider();

        logStepInfo("Verify Provider is not imported to EVV DB");
        verifyProviderNotExistInDB();

    }
}
