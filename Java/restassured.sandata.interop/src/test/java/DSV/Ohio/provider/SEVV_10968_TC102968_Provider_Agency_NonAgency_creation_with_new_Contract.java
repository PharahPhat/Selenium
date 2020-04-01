package DSV.Ohio.provider;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.FileContentReader;
import com.ohio.provider.*;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.io.FileWriter;
import java.util.Map;

public class SEVV_10968_TC102968_Provider_Agency_NonAgency_creation_with_new_Contract extends BaseTest {

    Assertion_DbVerifier_ohio_provider assertionDbVerifier = new Assertion_DbVerifier_ohio_provider();
    FileContentReader FileContentReader = new FileContentReader();
    GenerateUniqueparam_provider generateUniqueparam_provider = new GenerateUniqueparam_provider();
    CommonMethodsProvider CommonMethodsProvider = new CommonMethodsProvider();
    DataGeneratorProvider dg = new DataGeneratorProvider();


    @Test(groups = {"All", "Regression"})
    public void SEVV_10968_TC102968_Provider_Agency_creation_with_new_Contract_validation() throws InterruptedException, java.text.ParseException, Exception {

        // logger = extent.startTest("SEVV_10968_TC102968_Provider_Agency_NonAgency_creation_with_new_Contract_validation");

        Map<String, String> fileNamesProvider = CommonMethodsProvider.createProviderFilesName();

        Map<String, FileWriter> fileToWrite = CommonMethodsProvider.createProviderFiles(fileNamesProvider);

        Map<String, String> UniqueValues = generateUniqueparam_provider.generateUnigueParamProvider("16160");

        GlobalVariables_provider.contract3 = "09/21/201707/30/201912/31/2299WVATTAC15";
        CommonMethodsProvider.writeAllProviderFiles(fileToWrite, UniqueValues);

        FileContentReader.OhioputFileonServer(fileNamesProvider.get("prov_PMF_Full_Extract")
                , fileNamesProvider.get("PROV_PMF_CONTRACT_EXTRACT"), fileNamesProvider.get("PROV_PMF_SPECIALTY_EXTRACT"));

        logger.log(LogStatus.INFO, "verifying database");
        assertionDbVerifier.stxprovider_ohio_date(UniqueValues.get("ADR_EMAIL"), UniqueValues);


    }

    @Test(groups = {"All", "Regression"})
    public void SEVV_10968_TC102968_Provider_Agency_NonAgency_creation_with_PASSP_Contract_validation() throws InterruptedException, java.text.ParseException, Exception {

        // logger = extent.startTest("SEVV_10968_TC102968_Provider_Agency_NonAgency_creation_with_new_Contract_validation");

        Map<String, String> fileNamesProvider = CommonMethodsProvider.createProviderFilesName();

        Map<String, FileWriter> fileToWrite = CommonMethodsProvider.createProviderFiles(fileNamesProvider);

        Map<String, String> UniqueValues = generateUniqueparam_provider.generateUnigueParamProvider("38382");
        GlobalVariables_provider.contract3 = "09/21/201707/30/201912/31/2299PASSPAC15";
        CommonMethodsProvider.writeAllProviderFiles(fileToWrite, UniqueValues);

        FileContentReader.OhioputFileonServer(fileNamesProvider.get("prov_PMF_Full_Extract")
                , fileNamesProvider.get("PROV_PMF_CONTRACT_EXTRACT"), fileNamesProvider.get("PROV_PMF_SPECIALTY_EXTRACT"));

        logger.log(LogStatus.INFO, "verifying database");
        assertionDbVerifier.stxprovider_ohio(UniqueValues.get("ADR_EMAIL"));

    }

    @Test(groups = {"All", "Regression"})
    public void SEVV_10968_TC102968_Provider_Agency_NonAgency_creation_with_DDNUR_Contract_validation() throws InterruptedException, java.text.ParseException, Exception {

        // logger = extent.startTest("SEVV_10968_TC102968_Provider_Agency_NonAgency_creation_with_new_Contract_validation");

        Map<String, String> fileNamesProvider = CommonMethodsProvider.createProviderFilesName();

        Map<String, FileWriter> fileToWrite = CommonMethodsProvider.createProviderFiles(fileNamesProvider);

        Map<String, String> UniqueValues = generateUniqueparam_provider.generateUnigueParamProvider("38382");

        GlobalVariables_provider.contract3 = "09/21/201707/30/201912/31/2299DDNURAC15";
        CommonMethodsProvider.writeAllProviderFiles(fileToWrite, UniqueValues);

        FileContentReader.OhioputFileonServer(fileNamesProvider.get("prov_PMF_Full_Extract")
                , fileNamesProvider.get("PROV_PMF_CONTRACT_EXTRACT"), fileNamesProvider.get("PROV_PMF_SPECIALTY_EXTRACT"));

        logger.log(LogStatus.INFO, "verifying database");
        assertionDbVerifier.stxprovider_ohio(UniqueValues.get("ADR_EMAIL"));

    }

    @Test(groups = {"All", "Regression"})
    public void SEVV_10968_TC102968_Provider_Agency_creation_with_MRDIO_Contract_validation() throws InterruptedException, java.text.ParseException, Exception {

        // logger = extent.startTest("SEVV_10968_TC102968_Provider_Agency_NonAgency_creation_with_new_Contract_validation");

        Map<String, String> fileNamesProvider = CommonMethodsProvider.createProviderFilesName();

        Map<String, FileWriter> fileToWrite = CommonMethodsProvider.createProviderFiles(fileNamesProvider);

        Map<String, String> UniqueValues = generateUniqueparam_provider.generateUnigueParamProvider("60600");

        GlobalVariables_provider.contract3 = "09/21/201707/30/201912/31/2299MRDIOAC15";
        CommonMethodsProvider.writeAllProviderFiles(fileToWrite, UniqueValues);

        FileContentReader.OhioputFileonServer(fileNamesProvider.get("prov_PMF_Full_Extract")
                , fileNamesProvider.get("PROV_PMF_CONTRACT_EXTRACT"), fileNamesProvider.get("PROV_PMF_SPECIALTY_EXTRACT"));

        logger.log(LogStatus.INFO, "verifying database");
        assertionDbVerifier.stxprovider_ohio_date(UniqueValues.get("ADR_EMAIL"), UniqueValues);


    }

    @Test(groups = {"All", "Regression"})
    public void SEVV_10968_TC102968_Provider_Agency_creation_with_SPHH_Contract_validation() throws InterruptedException, java.text.ParseException, Exception {

        // logger = extent.startTest("SEVV_10968_TC102968_Provider_Agency_NonAgency_creation_with_new_Contract_validation");

        Map<String, String> fileNamesProvider = CommonMethodsProvider.createProviderFilesName();

        Map<String, FileWriter> fileToWrite = CommonMethodsProvider.createProviderFiles(fileNamesProvider);

        Map<String, String> UniqueValues = generateUniqueparam_provider.generateUnigueParamProvider("45250");

        GlobalVariables_provider.contract3 = "09/21/201707/30/201912/31/2299SPHH AC15";
        CommonMethodsProvider.writeAllProviderFiles(fileToWrite, UniqueValues);

        FileContentReader.OhioputFileonServer(fileNamesProvider.get("prov_PMF_Full_Extract")
                , fileNamesProvider.get("PROV_PMF_CONTRACT_EXTRACT"), fileNamesProvider.get("PROV_PMF_SPECIALTY_EXTRACT"));

        logger.log(LogStatus.INFO, "verifying database");
        assertionDbVerifier.stxprovider_ohio_date(UniqueValues.get("ADR_EMAIL"), UniqueValues);


    }

    @Test(groups = {"All", "Regression"})
    public void SEVV_10968_TC102968_Provider_NOnAgency_creation_with_WVNUR_Contract_validation() throws InterruptedException, java.text.ParseException, Exception {

        // logger = extent.startTest("SEVV_10968_TC102968_Provider_Agency_NonAgency_creation_with_new_Contract_validation");

        Map<String, String> fileNamesProvider = CommonMethodsProvider.createProviderFilesName();

        Map<String, FileWriter> fileToWrite = CommonMethodsProvider.createProviderFiles(fileNamesProvider);

        Map<String, String> UniqueValues = generateUniqueparam_provider.generateUnigueParamProvider("25250");

        GlobalVariables_provider.contract3 = "09/21/201707/30/201912/31/2299WVNURAC15";
        CommonMethodsProvider.writeAllProviderFiles(fileToWrite, UniqueValues);

        FileContentReader.OhioputFileonServer(fileNamesProvider.get("prov_PMF_Full_Extract")
                , fileNamesProvider.get("PROV_PMF_CONTRACT_EXTRACT"), fileNamesProvider.get("PROV_PMF_SPECIALTY_EXTRACT"));

        logger.log(LogStatus.INFO, "verifying database");
        assertionDbVerifier.stxprovider_ohio(UniqueValues.get("ADR_EMAIL"));

    }

    @Test(groups = {"All", "Regression"})
    public void SEVV_10968_TC102968_Provider_NonAgency_creation_with_MRDL1_Contract_validation() throws InterruptedException, java.text.ParseException, Exception {

        // logger = extent.startTest("SEVV_10968_TC102968_Provider_Agency_NonAgency_creation_with_new_Contract_validation");

        Map<String, String> fileNamesProvider = CommonMethodsProvider.createProviderFilesName();

        Map<String, FileWriter> fileToWrite = CommonMethodsProvider.createProviderFiles(fileNamesProvider);

        Map<String, String> UniqueValues = generateUniqueparam_provider.generateUnigueParamProvider("38382");
        GlobalVariables_provider.contract3 = "09/21/201707/30/201912/31/2299MRDL1AC15";
        CommonMethodsProvider.writeAllProviderFiles(fileToWrite, UniqueValues);

        FileContentReader.OhioputFileonServer(fileNamesProvider.get("prov_PMF_Full_Extract")
                , fileNamesProvider.get("PROV_PMF_CONTRACT_EXTRACT"), fileNamesProvider.get("PROV_PMF_SPECIALTY_EXTRACT"));

        logger.log(LogStatus.INFO, "verifying database");
        assertionDbVerifier.stxprovider_ohio(UniqueValues.get("ADR_EMAIL"));

    }

    @Test(groups = {"All", "Regression"})
    public void SEVV_10968_TC102968_Provider_NonAgency_creation_with_WVPCS_Contract_validation() throws InterruptedException, java.text.ParseException, Exception {

        // logger = extent.startTest("SEVV_10968_TC102968_Provider_Agency_NonAgency_creation_with_new_Contract_validation");

        Map<String, String> fileNamesProvider = CommonMethodsProvider.createProviderFilesName();

        Map<String, FileWriter> fileToWrite = CommonMethodsProvider.createProviderFiles(fileNamesProvider);
        Map<String, String> UniqueValues = generateUniqueparam_provider.generateUnigueParamProvider("38380");
        GlobalVariables_provider.contract3 = "09/21/201707/30/201912/31/2299WVPCSAC15";
        CommonMethodsProvider.writeAllProviderFiles(fileToWrite, UniqueValues);

        FileContentReader.OhioputFileonServer(fileNamesProvider.get("prov_PMF_Full_Extract")
                , fileNamesProvider.get("PROV_PMF_CONTRACT_EXTRACT"), fileNamesProvider.get("PROV_PMF_SPECIALTY_EXTRACT"));

        logger.log(LogStatus.INFO, "verifying database");
        assertionDbVerifier.stxprovider_ohio(UniqueValues.get("ADR_EMAIL"));

    }


    //This cases must ask DEV
    @Test(groups = {"All", "Regression"})
    public void SEVV_1512_TC101679_ODA_non_agency_provider() throws InterruptedException, java.text.ParseException, Exception {

        Map<String, String> fileNamesProvider = CommonMethodsProvider.createProviderFilesName();

        Map<String, FileWriter> fileToWrite = CommonMethodsProvider.createProviderFiles(fileNamesProvider);

        Map<String, String> UniqueValues = generateUniqueparam_provider.generateUnigueParamProvider("38480");
        Logger.getLogger(this.getClass()).info(UniqueValues);
        GlobalVariables_provider.contract3 = "09/21/201707/30/201912/31/2299PASSPAC15";
        CommonMethodsProvider.writeAllProviderFiles(fileToWrite, UniqueValues);

        FileContentReader.OhioputFileonServer(fileNamesProvider.get("prov_PMF_Full_Extract")
                , fileNamesProvider.get("PROV_PMF_CONTRACT_EXTRACT"), fileNamesProvider.get("PROV_PMF_SPECIALTY_EXTRACT"));

        logger.log(LogStatus.INFO, "verifying database");
        assertionDbVerifier.stxprovider_ohio(UniqueValues.get("ADR_EMAIL"));


    }

}
