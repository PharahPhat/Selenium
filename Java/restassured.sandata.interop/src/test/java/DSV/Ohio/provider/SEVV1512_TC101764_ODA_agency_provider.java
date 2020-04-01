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

public class SEVV1512_TC101764_ODA_agency_provider extends BaseTest {
	Assertion_DbVerifier_ohio_provider assertionDbVerifier =new Assertion_DbVerifier_ohio_provider();
	FileContentReader FileContentReader =new FileContentReader(); 
	GenerateUniqueparam_provider generateUniqueparam_provider=new GenerateUniqueparam_provider();
	CommonMethodsProvider CommonMethodsProvider =new CommonMethodsProvider();
	
	
	@Test(groups = {"All", "Regression"})
    public  void SEVV1512_TC101764_ODA_agency_provider_valid() throws Exception

	{
		
		// logger = extent.startTest("SEVV_1512_TC65183_Provider_Create_ODM_agency_provider");

		Map<String,String> fileNamesProvider	=CommonMethodsProvider.createProviderFilesName();
		
		Map<String,FileWriter> fileToWrite=CommonMethodsProvider.createProviderFiles(fileNamesProvider);		 	
	
		Map<String,String> UniqueValues=generateUniqueparam_provider.generateUnigueParamProvider("16480");
		//UniqueValues.put("special2","   13665239611649009/21/198212/31/2299");
		                                
		CommonMethodsProvider.writeAllProviderFiles(fileToWrite,UniqueValues);
		
	    FileContentReader.OhioputFileonServer(fileNamesProvider.get("prov_PMF_Full_Extract")
	    		,fileNamesProvider.get("PROV_PMF_CONTRACT_EXTRACT"), fileNamesProvider.get("PROV_PMF_SPECIALTY_EXTRACT"));
	    
		Thread.sleep(20000);
		
		assertionDbVerifier.stxprovider_ohio_agency(UniqueValues.get("ID_PROVIDER_MCD"));
}
}
