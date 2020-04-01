package DSV.Ohio.provider;

import java.io.FileWriter;
import java.util.Map;

import org.testng.annotations.Test;

import com.globalMethods.core.FileContentReader;
import com.ohio.provider.Assertion_DbVerifier_ohio_provider;
import com.ohio.provider.CommonMethodsProvider;
import com.ohio.provider.DataGeneratorProvider;
import com.ohio.provider.GenerateUniqueparam_provider;
import com.ohio.provider.GlobalVariables_provider;
import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;

public class SEVV_10070_TC102355_Agency_providers_specific_scenario extends BaseTest{
	

	Assertion_DbVerifier_ohio_provider assertionDbVerifier =new Assertion_DbVerifier_ohio_provider();
	FileContentReader FileContentReader =new FileContentReader(); 
	GenerateUniqueparam_provider generateUniqueparam_provider=new GenerateUniqueparam_provider();
	CommonMethodsProvider CommonMethodsProvider =new CommonMethodsProvider();
	DataGeneratorProvider dg = new DataGeneratorProvider();
	
	
	@Test(groups = {"All", "Regression"})
	public  void SEVV_10070_TC102355_Agency_providers_specific_scenario_for_duplicate() throws InterruptedException, java.text.ParseException, Exception
	{
		
		// logger = extent.startTest("SEVV_10070_TC102355_Agency_providers_specific_scenario_for_duplicate");

		Map<String,String> fileNamesProvider	=CommonMethodsProvider.createProviderFilesName();
		
		Map<String,FileWriter> fileToWrite=CommonMethodsProvider.createProviderFiles(fileNamesProvider);		 	
	   
		Map<String,String> UniqueValues=generateUniqueparam_provider.generateUnigueParamProvider("16160");
	
		GlobalVariables_provider.contract3="09/21/201707/30/201912/31/2299WVATTAC15";
		CommonMethodsProvider.writeAllProviderFiles(fileToWrite,UniqueValues);
		
	    FileContentReader.OhioputFileonServer(fileNamesProvider.get("prov_PMF_Full_Extract")
	    		,fileNamesProvider.get("PROV_PMF_CONTRACT_EXTRACT"), fileNamesProvider.get("PROV_PMF_SPECIALTY_EXTRACT"));
	    
		logger.log(LogStatus.INFO, "verifying database");
		assertionDbVerifier.stxprovider_ohio_date(UniqueValues.get("ADR_EMAIL"),UniqueValues );
		
		
}

}
