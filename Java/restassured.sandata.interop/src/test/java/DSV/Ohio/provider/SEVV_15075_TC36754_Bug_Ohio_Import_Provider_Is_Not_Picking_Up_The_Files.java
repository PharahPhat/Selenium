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

public class SEVV_15075_TC36754_Bug_Ohio_Import_Provider_Is_Not_Picking_Up_The_Files extends BaseTest {

    Assertion_DbVerifier_ohio_provider assertionDbVerifier =new Assertion_DbVerifier_ohio_provider();
    com.globalMethods.core.FileContentReader FileContentReader =new FileContentReader();
    GenerateUniqueparam_provider generateUniqueparam_provider=new GenerateUniqueparam_provider();
    com.ohio.provider.CommonMethodsProvider CommonMethodsProvider =new CommonMethodsProvider();
    DataGeneratorProvider dg = new DataGeneratorProvider();

    @Test(enabled = true, groups = {"All", "Regression"})
    public  void SEVV_15075_TC36754_Bug_Ohio_Import_Provider_Is_Not_Picking_Up_The_Files() throws Exception
    {
        Map<String,String> fileNamesProvider = CommonMethodsProvider.createProvider4FilesName(-1);
        Map<String, FileWriter> fileToWrite=CommonMethodsProvider.createProvider4Files(fileNamesProvider);
        Map<String,String> UniqueValues=generateUniqueparam_provider.generateUnigueParamProvider("16480");
        CommonMethodsProvider.writeAllProvider4Files(fileToWrite,UniqueValues);
        FileContentReader.OhioputFileonServer4Files(fileNamesProvider.get("prov_PMF_Full_Extract")
                ,fileNamesProvider.get("PROV_PMF_CONTRACT_EXTRACT"), fileNamesProvider.get("PROV_PMF_SPECIALTY_EXTRACT"),
                fileNamesProvider.get("PROV_PMF_SUPPLEMENTAL"));
        Thread.sleep(20000);
        assertionDbVerifier.stxprovider_ohio_agency(UniqueValues.get("ID_PROVIDER_MCD"));
    }
}
