package DSV.Ohio.provider;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.FileContentReader;
import com.ohio.provider.*;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.io.FileWriter;
import java.util.Map;

public class SEVV_1512_TC101769_TC101770_DODD_ODM_agency_nonagency_provider extends BaseTest {

    Assertion_DbVerifier_ohio_provider assertionDbVerifier = new Assertion_DbVerifier_ohio_provider();
    FileContentReader FileContentReader = new FileContentReader();
    GenerateUniqueparam_provider generateUniqueparam_provider = new GenerateUniqueparam_provider();
    CommonMethodsProvider CommonMethodsProvider = new CommonMethodsProvider();
    DataGeneratorProvider dg = new DataGeneratorProvider();


    @Test(groups = {"All", "Regression"})
    public void SEVV_1512_TC65183_Provider_Create_ODM_agency_provider_valid() throws InterruptedException, Exception {

        // logger = extent.startTest("SEVV_1512_TC65183_Provider_Create_ODM_agency_provider_valid");

        Map<String, String> fileNamesProvider = CommonMethodsProvider.createProviderFilesName();

        Map<String, FileWriter> fileToWrite = CommonMethodsProvider.createProviderFiles(fileNamesProvider);

        Map<String, String> UniqueValues = generateUniqueparam_provider.generateUnigueParamProvider("16160");

        CommonMethodsProvider.writeAllProviderFiles(fileToWrite, UniqueValues);

        FileContentReader.OhioputFileonServer(fileNamesProvider.get("prov_PMF_Full_Extract")
                , fileNamesProvider.get("PROV_PMF_CONTRACT_EXTRACT"), fileNamesProvider.get("PROV_PMF_SPECIALTY_EXTRACT"));


        assertionDbVerifier.stxprovider_ohio_agency(UniqueValues.get("ID_PROVIDER_MCD"));
    }


    @Test(groups = {"All", "Regression"})
    public void SEVV_1512_TC65183_Provider_Create_ODM_agency_provider_Waivered() throws InterruptedException, Exception {

        // logger = extent.startTest("SEVV_1512_TC65183_Provider_Create_ODM_agency_provider_Waivered");

        Map<String,String> fileNamesProvider	=CommonMethodsProvider.createProviderFilesName();

        Map<String,FileWriter> fileToWrite=CommonMethodsProvider.createProviderFiles(fileNamesProvider);

        Map<String,String> UniqueValues=generateUniqueparam_provider.generateUnigueParamProvider("60600");

        GlobalVariables_provider.contract3="09/21/201707/30/201912/31/2299MRDIOAC15";
        CommonMethodsProvider.writeAllProviderFiles(fileToWrite,UniqueValues);

        FileContentReader.OhioputFileonServer(fileNamesProvider.get("prov_PMF_Full_Extract")
                ,fileNamesProvider.get("PROV_PMF_CONTRACT_EXTRACT"), fileNamesProvider.get("PROV_PMF_SPECIALTY_EXTRACT"));

        logger.log(LogStatus.INFO, "verifying database");
        assertionDbVerifier.stxprovider_ohio_date(UniqueValues.get("ADR_EMAIL"),UniqueValues );
    }


    @Test(groups = {"All", "Regression"})
    public void SEVV_1512_TC65183_Provider_Create_ODM_nonagency_provider_valid() throws InterruptedException, Exception {

        // logger = extent.startTest("SEVV_1512_TC65183_Provider_Create_ODM_nonagency_provider_valid");

        Map<String, String> fileNamesProvider = CommonMethodsProvider.createProviderFilesName();

        Map<String, FileWriter> fileToWrite = CommonMethodsProvider.createProviderFiles(fileNamesProvider);

        Map<String, String> UniqueValues = generateUniqueparam_provider.generateUnigueParamProvider("25250");

        CommonMethodsProvider.writeAllProviderFiles(fileToWrite, UniqueValues);

        FileContentReader.OhioputFileonServer(fileNamesProvider.get("prov_PMF_Full_Extract")
                , fileNamesProvider.get("PROV_PMF_CONTRACT_EXTRACT"), fileNamesProvider.get("PROV_PMF_SPECIALTY_EXTRACT"));


        assertionDbVerifier.stxprovider_ohio(UniqueValues.get("ADR_EMAIL"));
    }

    @Test(groups = {"All", "Regression"})
    public void SEVV_1512_TC65183_Provider_Create_DODD_agency_waivered_provider_valid() throws InterruptedException, Exception {

        // logger = extent.startTest("SEVV_1512_TC65183_Provider_Create_DODD_agency_waivered_provider_valid");

        Map<String, String> fileNamesProvider = CommonMethodsProvider.createProviderFilesName();

        Map<String, FileWriter> fileToWrite = CommonMethodsProvider.createProviderFiles(fileNamesProvider);

        Map<String, String> UniqueValues = generateUniqueparam_provider.generateUnigueParamProvider("45490");

        CommonMethodsProvider.writeAllProviderFiles(fileToWrite, UniqueValues);

        FileContentReader.OhioputFileonServer(fileNamesProvider.get("prov_PMF_Full_Extract")
                , fileNamesProvider.get("PROV_PMF_CONTRACT_EXTRACT"), fileNamesProvider.get("PROV_PMF_SPECIALTY_EXTRACT"));


        assertionDbVerifier.stxprovider_ohio_agency(UniqueValues.get("ID_PROVIDER_MCD"));
    }

    @Test(groups = {"All", "Regression"})
    public void SEVV_1512_TC65183_Provider_Create_ODM_nonagency_clinicalprovider_valid() throws InterruptedException, Exception {

        // logger = extent.startTest("SEVV_1512_TC65183_Provider_Create_ODM_nonagency_clinicalprovider_valid");

        Map<String, String> fileNamesProvider = CommonMethodsProvider.createProviderFilesName();

        Map<String, FileWriter> fileToWrite = CommonMethodsProvider.createProviderFiles(fileNamesProvider);

        Map<String, String> UniqueValues = generateUniqueparam_provider.generateUnigueParamProvider("65380");

        CommonMethodsProvider.writeAllProviderFiles(fileToWrite, UniqueValues);

        FileContentReader.OhioputFileonServer(fileNamesProvider.get("prov_PMF_Full_Extract")
                , fileNamesProvider.get("PROV_PMF_CONTRACT_EXTRACT"), fileNamesProvider.get("PROV_PMF_SPECIALTY_EXTRACT"));


        assertionDbVerifier.stxprovider_ohio(UniqueValues.get("ADR_EMAIL"));
    }

    @Test(groups = {"All", "Regression"})
    public void SEVV_1512_TC65183_Provider_Create_ODM_nonagency_midwife_valid() throws InterruptedException, Exception {

        // logger = extent.startTest("SEVV_1512_TC65183_Provider_Create_ODM_nonagency_midwife_valid");

        Map<String, String> fileNamesProvider = CommonMethodsProvider.createProviderFilesName();

        Map<String, FileWriter> fileToWrite = CommonMethodsProvider.createProviderFiles(fileNamesProvider);

        Map<String, String> UniqueValues = generateUniqueparam_provider.generateUnigueParamProvider("71380");

        CommonMethodsProvider.writeAllProviderFiles(fileToWrite, UniqueValues);

        FileContentReader.OhioputFileonServer(fileNamesProvider.get("prov_PMF_Full_Extract")
                , fileNamesProvider.get("PROV_PMF_CONTRACT_EXTRACT"), fileNamesProvider.get("PROV_PMF_SPECIALTY_EXTRACT"));


        assertionDbVerifier.stxprovider_ohio(UniqueValues.get("ADR_EMAIL"));
    }

    @Test(groups = {"All", "Regression"})
    public void SEVV_1512_TC65183_Provider_Create_ODM_nonagency_nurse_valid() throws InterruptedException, Exception {

        // logger = extent.startTest("SEVV_1512_TC65183_Provider_Create_ODM_nonagency_nurse_valid");

        Map<String, String> fileNamesProvider = CommonMethodsProvider.createProviderFilesName();

        Map<String, FileWriter> fileToWrite = CommonMethodsProvider.createProviderFiles(fileNamesProvider);

        Map<String, String> UniqueValues = generateUniqueparam_provider.generateUnigueParamProvider("72380");

        CommonMethodsProvider.writeAllProviderFiles(fileToWrite, UniqueValues);

        FileContentReader.OhioputFileonServer(fileNamesProvider.get("prov_PMF_Full_Extract")
                , fileNamesProvider.get("PROV_PMF_CONTRACT_EXTRACT"), fileNamesProvider.get("PROV_PMF_SPECIALTY_EXTRACT"));


        assertionDbVerifier.stxprovider_ohio(UniqueValues.get("ADR_EMAIL"));
    }
}
