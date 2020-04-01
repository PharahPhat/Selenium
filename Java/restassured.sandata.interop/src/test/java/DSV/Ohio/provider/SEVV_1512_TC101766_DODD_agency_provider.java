
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

//**Ravi Ranjan**
public class SEVV_1512_TC101766_DODD_agency_provider extends BaseTest{ 
	
	Assertion_DbVerifier_ohio_provider assertionDbVerifier =new Assertion_DbVerifier_ohio_provider();
	FileContentReader FileContentReader =new FileContentReader(); 
	GenerateUniqueparam_provider generateUniqueparam_provider=new GenerateUniqueparam_provider();
	CommonMethodsProvider CommonMethodsProvider =new CommonMethodsProvider();
	DataGeneratorProvider dg = new DataGeneratorProvider();
	
	
	@Test(groups = {"All", "Regression"})
	public  void SEVV_1512_TC101766_DODD_agency_provider_valid() throws InterruptedException, java.text.ParseException, Exception
	{
		
		// logger = extent.startTest("SEVV_1512_TC101766_DODD_agency_provider_valid");

		Map<String,String> fileNamesProvider	=CommonMethodsProvider.createProviderFilesName();
		
		Map<String,FileWriter> fileToWrite=CommonMethodsProvider.createProviderFiles(fileNamesProvider);		 	
	String specialType ="16490";
		Map<String,String> UniqueValues=generateUniqueparam_provider.generateUnigueParamProvider(specialType);
		System.out.println(UniqueValues.get("ProvTypeSpeciality"));
		CommonMethodsProvider.writeAllProviderFiles(fileToWrite,UniqueValues);
		
	    FileContentReader.OhioputFileonServer(fileNamesProvider.get("prov_PMF_Full_Extract")
	    		,fileNamesProvider.get("PROV_PMF_CONTRACT_EXTRACT"), fileNamesProvider.get("PROV_PMF_SPECIALTY_EXTRACT"));

		assertionDbVerifier.stxprovider_ohio_agency(UniqueValues.get("ID_PROVIDER_MCD"));
}
}



