package DSV.Ohio.provider;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.FileContentReader;
import com.ohio.provider.Assertion_DbVerifier_ohio_provider;
import com.ohio.provider.CommonMethodsProvider;
import com.ohio.provider.DataGeneratorProvider;
import com.ohio.provider.GenerateUniqueparam_provider;
import org.testng.annotations.Test;

import java.io.FileWriter;
import java.util.Map;

public class SEVV_13714_TC15968_Validate_File_Next_1_Day_Process_InValid extends BaseTest {

    Assertion_DbVerifier_ohio_provider assertionDbVerifier =new Assertion_DbVerifier_ohio_provider();
    com.globalMethods.core.FileContentReader FileContentReader =new FileContentReader();
    GenerateUniqueparam_provider generateUniqueparam_provider=new GenerateUniqueparam_provider();
    com.ohio.provider.CommonMethodsProvider CommonMethodsProvider =new CommonMethodsProvider();
    DataGeneratorProvider dg = new DataGeneratorProvider();


    @Test(enabled = true, groups = {"All", "Regression"})
    public  void SEVV_13714_TC15968_Validate_File_Next_1_Day_Process_InValid() throws Exception
    {

        Map<String,String> fileNamesProvider = CommonMethodsProvider.createProviderFilesName(1);
        Map<String, FileWriter> fileToWrite=CommonMethodsProvider.createProviderFiles(fileNamesProvider);
        Map<String,String> UniqueValues=generateUniqueparam_provider.generateUnigueParamProvider("16480");

        CommonMethodsProvider.writeAllProviderFiles(fileToWrite,UniqueValues);

        FileContentReader.OhioputFileonServer(fileNamesProvider.get("prov_PMF_Full_Extract")
                ,fileNamesProvider.get("PROV_PMF_CONTRACT_EXTRACT"), fileNamesProvider.get("PROV_PMF_SPECIALTY_EXTRACT"));

        Thread.sleep(20000);

        assertionDbVerifier.stxprovider_ohio_agency_invalid(UniqueValues.get("ID_PROVIDER_MCD"));
    }
}