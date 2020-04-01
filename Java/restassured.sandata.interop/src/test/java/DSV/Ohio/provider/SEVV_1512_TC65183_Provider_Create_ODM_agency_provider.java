package DSV.Ohio.provider;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.globalMethods.core.FileContentReader;
import com.ohio.provider.Assertion_DbVerifier_ohio_provider;
import com.ohio.provider.CommonMethodsProvider;
import com.ohio.provider.DataGeneratorProvider;
import com.ohio.provider.FieldsProvider;
import com.ohio.provider.GenerateUniqueparam_provider;
import com.ohio.provider.GlobalVariables_provider;
import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;

//**Ravi Ranjan**
public class SEVV_1512_TC65183_Provider_Create_ODM_agency_provider extends BaseTest{ 
	
	Assertion_DbVerifier_ohio_provider assertionDbVerifier =new Assertion_DbVerifier_ohio_provider();
	FileContentReader FileContentReader =new FileContentReader(); 
	GenerateUniqueparam_provider generateUniqueparam_provider=new GenerateUniqueparam_provider();
	CommonMethodsProvider CommonMethodsProvider =new CommonMethodsProvider();
	DataGeneratorProvider dg = new DataGeneratorProvider();

	// This cases was covered by Test suite 10968
//	@Test(groups = {"All", "Regression"})
    public  void SEVV_1512_TC65183_Provider_Create_ODM_agency_provider_medicare() throws InterruptedException, Exception
	
	{
		
		// logger = extent.startTest("SEVV_1512_TC65183_Provider_Create_ODM_agency_provider_medicare");

		Map<String,String> fileNamesProvider	=CommonMethodsProvider.createProviderFilesName();
		
		Map<String,FileWriter> fileToWrite=CommonMethodsProvider.createProviderFiles(fileNamesProvider);		 	
	
		Map<String,String> UniqueValues=generateUniqueparam_provider.generateUnigueParamProvider("60600");
		
		CommonMethodsProvider.writeAllProviderFiles(fileToWrite,UniqueValues);
		
	    FileContentReader.OhioputFileonServer(fileNamesProvider.get("prov_PMF_Full_Extract")
	    		,fileNamesProvider.get("PROV_PMF_CONTRACT_EXTRACT"), fileNamesProvider.get("PROV_PMF_CONTRACT_EXTRACT"));
	    
	
		
		assertionDbVerifier.stxprovider_ohio_agency(UniqueValues.get("ID_PROVIDER_MCD"));
}
}



