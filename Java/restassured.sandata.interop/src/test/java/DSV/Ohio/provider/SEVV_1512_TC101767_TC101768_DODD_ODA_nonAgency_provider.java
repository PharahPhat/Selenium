package DSV.Ohio.provider;

import java.io.FileWriter;
import java.util.Map;

import org.testng.annotations.Test;

import com.globalMethods.core.FileContentReader;
import com.ohio.provider.Assertion_DbVerifier_ohio_provider;
import com.ohio.provider.CommonMethodsProvider;
import com.ohio.provider.DataGeneratorProvider;
import com.ohio.provider.GenerateUniqueparam_provider;

import Utills_ExtentReport_Log4j.BaseTest;

public class SEVV_1512_TC101767_TC101768_DODD_ODA_nonAgency_provider extends BaseTest{
	

	Assertion_DbVerifier_ohio_provider assertionDbVerifier =new Assertion_DbVerifier_ohio_provider();
	FileContentReader FileContentReader =new FileContentReader(); 
	GenerateUniqueparam_provider generateUniqueparam_provider=new GenerateUniqueparam_provider();
	CommonMethodsProvider CommonMethodsProvider =new CommonMethodsProvider();
	DataGeneratorProvider dg = new DataGeneratorProvider();
	
	
	@Test(groups = {"All", "Regression"})
	public  void SEVV_1512_TC101767_TC101768_DODD_nonAgency_personal_care_provider_validation() throws InterruptedException, Exception
	{
		
		// logger = extent.startTest("SEVV_1512_TC101767_TC101768_DODD_nonAgency_personal_care_provider_validation");

		Map<String,String> fileNamesProvider	=CommonMethodsProvider.createProviderFilesName();
		
		Map<String,FileWriter> fileToWrite=CommonMethodsProvider.createProviderFiles(fileNamesProvider);		 	
	
		Map<String,String> UniqueValues=generateUniqueparam_provider.generateUnigueParamProvider("25250");
		                                
		CommonMethodsProvider.writeAllProviderFiles(fileToWrite,UniqueValues);
		
	    FileContentReader.OhioputFileonServer(fileNamesProvider.get("prov_PMF_Full_Extract")
	    		,fileNamesProvider.get("PROV_PMF_CONTRACT_EXTRACT"), fileNamesProvider.get("PROV_PMF_SPECIALTY_EXTRACT"));
	    
		
		
	    assertionDbVerifier.stxprovider_ohio(UniqueValues.get("ADR_EMAIL"));
}
	
	@Test(groups = {"All", "Regression"})
	public  void SEVV_1512_TC101767_TC101768_DODD_nonAgency_home_care_provider_validation() throws InterruptedException, Exception
	{
		
		// logger = extent.startTest("SEVV_1512_TC65183_Provider_Create_ODM_agency_provider");

		Map<String,String> fileNamesProvider	=CommonMethodsProvider.createProviderFilesName();
		
		Map<String,FileWriter> fileToWrite=CommonMethodsProvider.createProviderFiles(fileNamesProvider);		 	
	
		Map<String,String> UniqueValues=generateUniqueparam_provider.generateUnigueParamProvider("26490");
	
		CommonMethodsProvider.writeAllProviderFiles(fileToWrite,UniqueValues);
		
	    FileContentReader.OhioputFileonServer(fileNamesProvider.get("prov_PMF_Full_Extract")
	    		,fileNamesProvider.get("PROV_PMF_CONTRACT_EXTRACT"), fileNamesProvider.get("PROV_PMF_SPECIALTY_EXTRACT"));
	    
	
		
	    assertionDbVerifier.stxprovider_ohio(UniqueValues.get("ADR_EMAIL"));
}
	
	@Test(groups = {"All", "Regression"})
	public  void SEVV_1512_TC101767_TC101768_DODD_nonAgency_RL_LPN_provider_validation() throws InterruptedException, Exception
	{
		
		// logger = extent.startTest("SEVV_1512_TC65183_Provider_Create_ODM_agency_provider");

		Map<String,String> fileNamesProvider	=CommonMethodsProvider.createProviderFilesName();
		
		Map<String,FileWriter> fileToWrite=CommonMethodsProvider.createProviderFiles(fileNamesProvider);		 	
	
		Map<String,String> UniqueValues=generateUniqueparam_provider.generateUnigueParamProvider("38490");
	
		CommonMethodsProvider.writeAllProviderFiles(fileToWrite,UniqueValues);
		
	    FileContentReader.OhioputFileonServer(fileNamesProvider.get("prov_PMF_Full_Extract")
	    		,fileNamesProvider.get("PROV_PMF_CONTRACT_EXTRACT"), fileNamesProvider.get("PROV_PMF_SPECIALTY_EXTRACT"));
	    
	
		
	    assertionDbVerifier.stxprovider_ohio(UniqueValues.get("ADR_EMAIL"));
}
	
	@Test(groups = {"All", "Regression"})
	public  void SEVV_1512_TC101767_TC101768_ODA_nonAgency_HOMECAREATTENDANTprovider_validation() throws InterruptedException, Exception
	{
		
		// logger = extent.startTest("SEVV_1512_TC101767_TC101768_ODA_nonAgency_HOMECAREATTENDANTprovider_validation");

		Map<String,String> fileNamesProvider	=CommonMethodsProvider.createProviderFilesName();
		
		Map<String,FileWriter> fileToWrite=CommonMethodsProvider.createProviderFiles(fileNamesProvider);		 	
	
		Map<String,String> UniqueValues=generateUniqueparam_provider.generateUnigueParamProvider("26480");
		
		
		CommonMethodsProvider.writeAllProviderFiles(fileToWrite,UniqueValues);
		
	    FileContentReader.OhioputFileonServer(fileNamesProvider.get("prov_PMF_Full_Extract")
	    		,fileNamesProvider.get("PROV_PMF_CONTRACT_EXTRACT"), fileNamesProvider.get("PROV_PMF_SPECIALTY_EXTRACT"));
	    
		
		
	    assertionDbVerifier.stxprovider_ohio(UniqueValues.get("ADR_EMAIL"));
}
	
	@Test(groups = {"All", "Regression"})
	public  void SEVV_1512_TC101767_TC101768_ODA_nonAgency_PERSONALCARE_provider_validation() throws InterruptedException, Exception
	{
		
		// logger = extent.startTest("SEVV_1512_TC101767_TC101768_ODA_nonAgency_PERSONALCARE_provider_validation");

		Map<String,String> fileNamesProvider	=CommonMethodsProvider.createProviderFilesName();
		
		Map<String,FileWriter> fileToWrite=CommonMethodsProvider.createProviderFiles(fileNamesProvider);		 	
	
		Map<String,String> UniqueValues=generateUniqueparam_provider.generateUnigueParamProvider("25480");
		UniqueValues.put("special2","   13665239612548009/21/198212/31/2299");
		
		CommonMethodsProvider.writeAllProviderFiles(fileToWrite,UniqueValues);
		
	    FileContentReader.OhioputFileonServer(fileNamesProvider.get("prov_PMF_Full_Extract")
	    		,fileNamesProvider.get("PROV_PMF_CONTRACT_EXTRACT"), fileNamesProvider.get("PROV_PMF_SPECIALTY_EXTRACT"));
	    
	
		
	    assertionDbVerifier.stxprovider_ohio(UniqueValues.get("ADR_EMAIL"));
}
	
	@Test(groups = {"All", "Regression"})
	public  void SEVV_1512_TC101767_TC101768_ODA_nonAgency_RN_LPNprovider_validation() throws InterruptedException, Exception
	{
		
		// logger = extent.startTest("SEVV_1512_TC101767_TC101768_ODA_nonAgency_RN_LPNprovider_validation");

		Map<String,String> fileNamesProvider	=CommonMethodsProvider.createProviderFilesName();
		
		Map<String,FileWriter> fileToWrite=CommonMethodsProvider.createProviderFiles(fileNamesProvider);		 	
	
		Map<String,String> UniqueValues=generateUniqueparam_provider.generateUnigueParamProvider("38480");
		UniqueValues.put("special2","   13665239613848009/21/198212/31/2299");
		
		CommonMethodsProvider.writeAllProviderFiles(fileToWrite,UniqueValues);
		
	    FileContentReader.OhioputFileonServer(fileNamesProvider.get("prov_PMF_Full_Extract")
	    		,fileNamesProvider.get("PROV_PMF_CONTRACT_EXTRACT"), fileNamesProvider.get("PROV_PMF_SPECIALTY_EXTRACT"));
	 
		
	    assertionDbVerifier.stxprovider_ohio(UniqueValues.get("ADR_EMAIL"));
}

}
