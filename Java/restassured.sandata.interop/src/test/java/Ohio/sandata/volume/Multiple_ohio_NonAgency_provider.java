package Ohio.sandata.volume;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;

import com.globalMethods.core.FileContentReader;
import com.ohio.provider.Assertion_DbVerifier_ohio_provider;
import com.ohio.provider.CommonMethodsProvider;
import com.ohio.provider.DataGeneratorProvider;
import com.ohio.provider.FieldsProvider;
import com.ohio.provider.GlobalVariables_provider;
import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;



/**
 * @author Ravi
 
 */
public class Multiple_ohio_NonAgency_provider  extends BaseTest{
	
	Assertion_DbVerifier_ohio_provider assertionDbVerifier =new Assertion_DbVerifier_ohio_provider();
	FileContentReader FileContentReader =new FileContentReader(); 

	@Test
	public  void createData_Load_welcomekit() throws IOException, InterruptedException, Exception
	{

		// logger = extent.startTest("Welcome kit Load testing for ODM provider creation");
		String fname1;
		  String fname2;
		 String fname3;
		Date date = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_hhmm") ;
			  fname1="PROV_PMF_FULL_EXTRACT_"+dateFormat.format(date)+ ".txt";
			  fname2="PROV_PMF_CONTRACT_EXTRACT_"+dateFormat.format(date)+ ".txt";
			  fname3="PROV_PMF_SPECIALTY_EXTRACT_"+dateFormat.format(date)+ ".txt";
			  CommonMethodsProvider.writeProviderPropertiesFile("fullFileName", fname1,"contractFileName", fname2,"SpecialFileName",fname3);
			 
			 
			 
			
			 
		for(int i=0;i<200;i++){
			 FileWriter file1 =new FileWriter(GlobalVariables_provider.getOhioproviderlocation+"PROV_PMF_FULL_EXTRACT_"+dateFormat.format(date)+ ".txt",true);
			 FileWriter file2 =new FileWriter(GlobalVariables_provider.getOhioproviderlocation+"PROV_PMF_CONTRACT_EXTRACT_"+dateFormat.format(date)+ ".txt",true);
			 FileWriter file3 =new FileWriter(GlobalVariables_provider.getOhioproviderlocation+"PROV_PMF_SPECIALTY_EXTRACT_"+dateFormat.format(date)+ ".txt",true);
			 	
		DataGeneratorProvider dg = new DataGeneratorProvider();
		FieldsProvider.SAK_PROV= "10028";
		FieldsProvider.ID_PROVIDER_MCD= dg.generateProviderID();
		
		FieldsProvider.Prov_fname= dg.generateProviderFname();
		
		FieldsProvider.Prov_lname= dg.generateProviderLname();
	
		FieldsProvider.CDE_COUNTY ="23";
		
		FieldsProvider.DTE_CYCLE ="N10/14/201512/31/2299DEFAULT";
		
		FieldsProvider.NUM_TAX_ID =dg.generateTaxID();
	
		FieldsProvider.NUM_PROV_SSN = dg.generateSsn();
		
		FieldsProvider.ID_PROVIDER_NPI="1679765770NPIY";
		
		FieldsProvider.DERIVED ="0000001/01/0101";
		FieldsProvider.DERIVED1="01/01/010104/17/199412/31/2299YNI";
		FieldsProvider.DERIVED2="10/14/2015000";
		FieldsProvider.NA="000000000";
		FieldsProvider.NA1="000000000000000000000000000000000000";
		FieldsProvider.CDE_ORGANIZ="2099";
		FieldsProvider.NUM_PROV_LIC="35064190";
		FieldsProvider.DTE_EFF_MCD_AGREEMENT="04/17/199401/01/2021";
		FieldsProvider.DERIVED3="01/01/0101BS3488283000001/01/0101";
		FieldsProvider.DERIVED4="N N1";
		FieldsProvider.NUM_PHONE=dg.generatePhone();
		FieldsProvider.NUM_PHONE_INT="0000000000";
		FieldsProvider.DERIVED5="01/01/010112/31/2299PHYS";
		FieldsProvider.NUM_LONGITUDE="0000.0000000000.000000S010021601/01/0101000000000000000000000000000000000000000000000";
		FieldsProvider.NA2="00000000000000000000000000000000000000000000000000000000000000000000000000000000001/01/0101000000000000000000000000000";
		FieldsProvider.NA3="00000000000000000000000000000000000000000000000000000000000000000000000000000000004/17/199420901/01/0101";
		FieldsProvider.ADR_MAIL_STRT1=dg.generateStreet1();
		FieldsProvider.ADR_MAIL_STRT2=dg.generateStreet2();
		FieldsProvider.ADR_MAIL_CITY=dg.generateCity();
		FieldsProvider.ADR_MAIL_STATE=dg.generateState();
		FieldsProvider.ADR_MAIL_ZIP=dg.generateZip();
		
		FieldsProvider.ADR2_MAIL_STRT1=dg.generateStreet1();
		FieldsProvider.ADR2_MAIL_STRT2=dg.generateStreet2();
		FieldsProvider.ADR2_MAIL_CITY=dg.generateCity();
		FieldsProvider.ADR2_MAIL_STATE=dg.generateState();
		FieldsProvider.ADR2_MAIL_ZIP=dg.generateZip();
	
		FieldsProvider.ADR3_MAIL_STRT1=dg.generateStreet1();
		FieldsProvider.ADR3_MAIL_STRT2=dg.generateStreet2();
		FieldsProvider.ADR3_MAIL_CITY=dg.generateCity();
		FieldsProvider.ADR3_MAIL_STATE=dg.generateState();
		FieldsProvider.ADR3_MAIL_ZIP=dg.generateZip();
		
		FieldsProvider.DTE_EFFECTIVE="AC04/17/1994AC04/17/1994AC04/17/19940000000000000000000000000001A";
		FieldsProvider.NA4="000000000308300000000000000000008/16/200608/07/20060000000000000000000000000001A";
		FieldsProvider.NA5="000000031597700000000000000000005/13/200905/04/20090000000000000000000000000001A";
		FieldsProvider.NA6="000000002887600000000000000000005/13/200905/04/20090000000000000000000000000001A";
		FieldsProvider.NA7="000000002103400000000000000000005/13/200905/04/20090000000000000000000000000001A";
		FieldsProvider.NA8="000000002890600000000000000000005/13/200905/04/200901/01/010112/31/2299N";
		FieldsProvider.DTE_EFFECTIVE3="01/01/010112/31/2299";
		FieldsProvider.DTE_EFFECTIVE1="01/01/010112/31/22994939179";
		FieldsProvider.DTE_EFFECTIVE2="10/25/199512/31/2299000000000000000000000001/01/010101/01/010112/31/2299   18707";
		FieldsProvider.ADR_EMAIL="NAP"+dg.generateEmail(FieldsProvider.ID_PROVIDER_MCD)+"@svam.com";
		
		FieldsProvider.NUM_PHONE1=dg.generatePhone();
		FieldsProvider.NA9="0000000000OHWEB1891574068786360000000000OHWEB1891574068745050000000000OHWEB18915401 N EWING ST                                              LANCASTER";

		
	    
		FieldsProvider.CDE_PROV_PGM="         OH4313033727406874505          OHWEB18915PO BOX 948                                                  LANCASTER";
		
		FieldsProvider.Add5="         OH4313005860000000000          OHWEB18915401 N EWING ST                                              LANCASTER";
		FieldsProvider.Add6="         OH4313033727406874505          OHWEB18915                    01/01/010112/31/2299                     01/01/010101/01/0101";
		FieldsProvider.contract1="000046061";
		FieldsProvider.contract2="   1366523961";
	    FieldsProvider.contract3 = "09/21/201707/30/201912/31/2299PDN  AC15";
	    FieldsProvider.ProvTypeSpeciality ="16160";
		FieldsProvider.special1="    46061";
		FieldsProvider.special2="   13665239617138009/21/198212/31/2299";
	
		
				 
		
			try {
				
			
				file1.write(FieldsProvider.SAK_PROV
						+dg.space(4)
						+FieldsProvider.ID_PROVIDER_MCD
				         +dg.space(3)
				         +FieldsProvider.Prov_lname
				         +FieldsProvider.Prov_fname
				         +FieldsProvider.CDE_COUNTY
				         +dg.space(8)
				         +FieldsProvider.DTE_CYCLE
				         +dg.space(1)
				         +FieldsProvider.NUM_TAX_ID
				         +dg.space(1)
				         +FieldsProvider.NUM_PROV_SSN
				         +FieldsProvider.ID_PROVIDER_NPI
				         +dg.space(10)
				         +FieldsProvider.DERIVED
				         +dg.space(8)
				         +FieldsProvider.DERIVED1
				         +dg.space(13)
				         +FieldsProvider.DERIVED2
				         +dg.space(1)
				         +FieldsProvider.NA
				         +dg.space(15)
				         +FieldsProvider.NA1
				         +dg.space(20)
				         +FieldsProvider.CDE_ORGANIZ
				         +dg.space(1)
				         +FieldsProvider.NUM_PROV_LIC
				         +dg.space(48)
				         +FieldsProvider.DTE_EFF_MCD_AGREEMENT
				         +dg.space(37)
				         +FieldsProvider.DERIVED3
				         +dg.space(3)
				         +FieldsProvider.DERIVED4
				         +dg.space(6)
				         +FieldsProvider.NUM_PHONE
				         +FieldsProvider.NUM_PHONE_INT
				         +dg.space(2)
				         +FieldsProvider.DERIVED5
				         +dg.space(1)
				         +FieldsProvider.NUM_LONGITUDE
				         +dg.space(1)
				         +FieldsProvider.NA2
				         +dg.space(1)
				         +FieldsProvider.NA3
				         +dg.space(3)
				         +FieldsProvider.ADR_MAIL_STRT1
				         +FieldsProvider.ADR_MAIL_STRT2
				         +FieldsProvider.ADR_MAIL_CITY
				         +FieldsProvider.ADR_MAIL_STATE
				         +FieldsProvider.ADR_MAIL_ZIP
				         +FieldsProvider.ADR2_MAIL_STRT1
				         +FieldsProvider.ADR2_MAIL_STRT2
				         +FieldsProvider.ADR2_MAIL_CITY
				         +FieldsProvider.ADR2_MAIL_STATE
				         +FieldsProvider.ADR2_MAIL_ZIP
				         +FieldsProvider.ADR3_MAIL_STRT1
				         +FieldsProvider.ADR3_MAIL_STRT2
				         +FieldsProvider.ADR3_MAIL_CITY
				         +FieldsProvider.ADR3_MAIL_STATE
				         +FieldsProvider.ADR3_MAIL_ZIP
				         +FieldsProvider.DTE_EFFECTIVE
				         +dg.space(1)
				         +FieldsProvider.NA4
				         +dg.space(1)
				         +FieldsProvider.NA5
				         +dg.space(1)
				         +FieldsProvider.NA6
				         +dg.space(1)
				         +FieldsProvider.NA7
				         +dg.space(1)
				         +FieldsProvider.NA8
				         +dg.space(2)
				         +FieldsProvider.DTE_EFFECTIVE3
				         +dg.space(11)
				         +FieldsProvider.DTE_EFFECTIVE1
				         +dg.space(3)
				         +FieldsProvider.DTE_EFFECTIVE2
				         +FieldsProvider.ADR_EMAIL
				         +dg.space(26)
				         +FieldsProvider.NUM_PHONE1
				         +FieldsProvider.NA9
				         +FieldsProvider.CDE_PROV_PGM
				         +FieldsProvider.Add5			         
				         +FieldsProvider.Add6
				         );
				file1.write('\n');
				file1.close();
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
				try {
					
				
					file2.write(FieldsProvider.contract1
							+FieldsProvider.ID_PROVIDER_MCD
							+FieldsProvider.contract2+FieldsProvider.ProvTypeSpeciality+FieldsProvider.contract3);
					file2.write('\n');
					file2.close();
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					
				
					file3.write(FieldsProvider.special1+FieldsProvider.ID_PROVIDER_MCD+FieldsProvider.special2);
					file3.write('\n');	
					file3.close();
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		}
	
		logger.log(LogStatus.INFO,"Sending created file on sftp server.");
		FileContentReader.OhioputFileonServer(fname1, fname2, fname3);
		Thread.sleep(20000);
		logger.log(LogStatus.INFO,"Verifying db has been updated");
		assertionDbVerifier.stxprovider_ohio(FieldsProvider.Prov_lname);
	
	
	
	}
	
	

}



