package DSV.Indiana.provider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.FileContentReader;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;

public class SEVV_7361_TC99930_TC99931_TC99933_TC99934_taxid_taxonomy_DateBegin_field_formate extends BaseTest{
	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	Assertion_DbVerifier Assertion_DbVerifier=new Assertion_DbVerifier();


	
	String timeStamp;  FileContentReader FileContentReader =new FileContentReader(); 
	@BeforeMethod(alwaysRun = true)
	public void tearDown()
	{
		 this.timeStamp =CommonMethods.getTimeStamp();	
	  
	}
	
	 @Test(enabled = true, groups = {"All", "Regression"})
		@AdditionalInfo(module = "OpenEVV")
		
		 public void SEVV_7631_TC99930_Taxid_lenghth_morethan_allowed() throws InterruptedException, java.text.ParseException,  Exception{
			// logger = extent.startTest("SEVV_7631_TC99930_Taxid_lenghth_morethan_allowed");

			//////////////Variable declaration ///////////////////
			Map<String ,String> mapUpdateFileData = new HashMap<>();
			Map<String ,String> finalMapapdataByRow = new HashMap<>();
			Map<String ,String> mapOutboundData = new HashMap<>();
			List<String> Errormessage = new ArrayList<String>();
			Map<String ,String> fileUpdateValue = new HashMap<>();
			String FileName;
			List<String> fileNames;		

		logger.log(LogStatus.INFO,"Creating map for required Field map");
		fileUpdateValue=GenerateUniqueParam.providerParams_PipeDelimited();
		
		fileUpdateValue.put(globalVariables.TaxID,CommonMethods.generateRandomStringOfFixLength(10));
		

		logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
		FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.indianaProviderGenericFile, fileUpdateValue,globalVariables.indianaGenericFileFormat, globalVariables.provider,timeStamp);

		logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
		mapOutboundData.put(FileName, "1");
		String outboundFileName= FileContentReader.createOutboundFileAndEncryptGeneric(mapOutboundData,timeStamp,globalVariables.indianaGenericFileFormat);

		logger.log(LogStatus.INFO,"process the Files and get the control file ");
		finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
		fileNames=FileContentReader.putGetFilefromServerIndiana(FileName,outboundFileName,globalVariables.provider,timeStamp);
		
		logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
		Errormessage=CommonMethods.getProviderErrorMessageForMissingRequiredField();
		Assertion_DbVerifier.assertControlFileInValidindiana(fileNames,FileName,Errormessage,globalVariables.provider,timeStamp);
		
		}
		
		@Test(enabled = true, groups = {"All"})
		@AdditionalInfo(module = "OpenEVV")
		 public void SEVV_7631_TC99930_Taxid_lenghth_blank() throws InterruptedException, java.text.ParseException,  Exception{
				// logger = extent.startTest("SEVV_7631_TC99930_Taxid_lenghth_blank");
					

				//////////////Variable declaration ///////////////////
				Map<String ,String> mapUpdateFileData = new HashMap<>();
				Map<String ,String> finalMapapdataByRow = new HashMap<>();
				Map<String ,String> mapOutboundData = new HashMap<>();
				List<String> Errormessage = new ArrayList<String>();
				Map<String ,String> fileUpdateValue = new HashMap<>();
				String FileName;
				List<String> fileNames;
			logger.log(LogStatus.INFO,"Creating map for required Field map");
			fileUpdateValue=GenerateUniqueParam.providerParams_PipeDelimited();
			
			fileUpdateValue.put(globalVariables.TaxID,"");
			

			logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
			FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.indianaProviderGenericFile, fileUpdateValue,globalVariables.indianaGenericFileFormat, globalVariables.provider,timeStamp);

			logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
			mapOutboundData.put(FileName, "1");
			String outboundFileName= FileContentReader.createOutboundFileAndEncryptGeneric(mapOutboundData,timeStamp,globalVariables.indianaGenericFileFormat);

			logger.log(LogStatus.INFO,"process the Files and get the control file ");
			finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
			fileNames=FileContentReader.putGetFilefromServerIndiana(FileName,outboundFileName,null,timeStamp);
			
			logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
			Assertion_DbVerifier.assertControlFileValidindiana(fileNames,FileName,finalMapapdataByRow,outboundFileName,globalVariables.provider,timeStamp);
			

		}
		 
		 @Test(enabled = true, groups = {"All"})
		 @AdditionalInfo(module = "OpenEVV")
		 public void SEVV_7631_TC99930_Taxid_special_alphanumeric() throws InterruptedException, java.text.ParseException,  Exception{
				// logger = extent.startTest("SEVV_7631_TC99930_Taxid_special_alphanumeric");
					

				//////////////Variable declaration ///////////////////
				Map<String ,String> mapUpdateFileData = new HashMap<>();
				Map<String ,String> finalMapapdataByRow = new HashMap<>();
				Map<String ,String> mapOutboundData = new HashMap<>();
				List<String> Errormessage = new ArrayList<String>();
				Map<String ,String> fileUpdateValue = new HashMap<>();
				String FileName;
				List<String> fileNames;
			logger.log(LogStatus.INFO,"Creating map for required Field map");
			fileUpdateValue=GenerateUniqueParam.providerParams_PipeDelimited();
			
			fileUpdateValue.put(globalVariables.TaxID,CommonMethods.generateRandomAlphaNumeric(9));
		

			logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
			FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.indianaProviderGenericFile, fileUpdateValue,globalVariables.indianaGenericFileFormat, globalVariables.provider,timeStamp);

			logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
			mapOutboundData.put(FileName, "1");
			String outboundFileName= FileContentReader.createOutboundFileAndEncryptGeneric(mapOutboundData,timeStamp,globalVariables.indianaGenericFileFormat);

			logger.log(LogStatus.INFO,"process the Files and get the control file ");
			finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
			fileNames=FileContentReader.putGetFilefromServerIndiana(FileName,outboundFileName,null,timeStamp);
			
			logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
			Errormessage=CommonMethods.getProviderErrorMessageForMissingRequiredField();
			Assertion_DbVerifier.assertControlFileInValidindiana(fileNames,FileName,Errormessage,globalVariables.provider,timeStamp);

		}
		 
		 @Test(enabled = true, groups = {"All"})
		 @AdditionalInfo(module = "OpenEVV")
		 public void SEVV_7631_TC99930_Taxid_null() throws InterruptedException, java.text.ParseException,  Exception{
				// logger = extent.startTest("SEVV_7631_TC99930_Taxid_special_alphanumeric");
				

				//////////////Variable declaration ///////////////////
				Map<String ,String> mapUpdateFileData = new HashMap<>();
				Map<String ,String> finalMapapdataByRow = new HashMap<>();
				Map<String ,String> mapOutboundData = new HashMap<>();
				List<String> Errormessage = new ArrayList<String>();
				Map<String ,String> fileUpdateValue = new HashMap<>();
				String FileName;
				List<String> fileNames;

			logger.log(LogStatus.INFO,"Creating map for required Field map");
			fileUpdateValue=GenerateUniqueParam.providerParams_PipeDelimited();
			
			fileUpdateValue.put(globalVariables.TaxID,null);
		

			logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
			FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.indianaProviderGenericFile, fileUpdateValue,globalVariables.indianaGenericFileFormat, globalVariables.provider,timeStamp);

			logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
			mapOutboundData.put(FileName, "1");
			String outboundFileName= FileContentReader.createOutboundFileAndEncryptGeneric(mapOutboundData,timeStamp,globalVariables.indianaGenericFileFormat);

			logger.log(LogStatus.INFO,"process the Files and get the control file ");
			finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
			fileNames=FileContentReader.putGetFilefromServerIndiana(FileName,outboundFileName,null,timeStamp);
			
			logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
			Assertion_DbVerifier.assertControlFileValidindiana(fileNames,FileName,finalMapapdataByRow,outboundFileName,globalVariables.provider,timeStamp);
		}
		 
		 @Test(enabled = true, groups = {"All", "Regression"})
			@AdditionalInfo(module = "OpenEVV")
			
			 public void SEVV_7631_TC99931_ProviderTaxonomy_lenghth_morethan_allowed() throws InterruptedException, java.text.ParseException,  Exception{
				// logger = extent.startTest("SEVV_7631_TC99930_Taxid_lenghth_morethan_allowed");
					

				//////////////Variable declaration ///////////////////
				Map<String ,String> mapUpdateFileData = new HashMap<>();
				Map<String ,String> finalMapapdataByRow = new HashMap<>();
				Map<String ,String> mapOutboundData = new HashMap<>();
				List<String> Errormessage = new ArrayList<String>();
				Map<String ,String> fileUpdateValue = new HashMap<>();
				String FileName;
				List<String> fileNames;
			logger.log(LogStatus.INFO,"Creating map for required Field map");
			fileUpdateValue=GenerateUniqueParam.providerParams_PipeDelimited();
			
			fileUpdateValue.put(globalVariables.providertaxonomy,CommonMethods.generateRandomStringOfFixLength(10));
			

			logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
			FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.indianaProviderGenericFile, fileUpdateValue,globalVariables.indianaGenericFileFormat, globalVariables.provider,timeStamp);

			logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
			mapOutboundData.put(FileName, "1");
			String outboundFileName= FileContentReader.createOutboundFileAndEncryptGeneric(mapOutboundData,timeStamp,globalVariables.indianaGenericFileFormat);

			logger.log(LogStatus.INFO,"process the Files and get the control file ");
			finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
			fileNames=FileContentReader.putGetFilefromServerIndiana(FileName,outboundFileName,null,timeStamp);
			
			logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
			Errormessage=CommonMethods.getProviderErrorMessageForMissingRequiredField();
			Assertion_DbVerifier.assertControlFileInValidindiana(fileNames,FileName,Errormessage,globalVariables.provider,timeStamp);
			
			}
			
			@Test(enabled = true, groups = {"All"})
			@AdditionalInfo(module = "OpenEVV")
			 public void SEVV_7631_TC99931_providertaxonomy_lenghth_blank() throws InterruptedException, java.text.ParseException,  Exception{
					// logger = extent.startTest("SEVV_7631_TC99930_Taxid_lenghth_blank");

					//////////////Variable declaration ///////////////////
					Map<String ,String> mapUpdateFileData = new HashMap<>();
					Map<String ,String> finalMapapdataByRow = new HashMap<>();
					Map<String ,String> mapOutboundData = new HashMap<>();
					List<String> Errormessage = new ArrayList<String>();
					Map<String ,String> fileUpdateValue = new HashMap<>();
					String FileName;
					List<String> fileNames;		

				logger.log(LogStatus.INFO,"Creating map for required Field map");
				fileUpdateValue=GenerateUniqueParam.providerParams_PipeDelimited();
				
				fileUpdateValue.put(globalVariables.providertaxonomy,"");
				

				logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
				FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.indianaProviderGenericFile, fileUpdateValue,globalVariables.indianaGenericFileFormat, globalVariables.provider,timeStamp);

				logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
				mapOutboundData.put(FileName, "1");
				String outboundFileName= FileContentReader.createOutboundFileAndEncryptGeneric(mapOutboundData,timeStamp,globalVariables.indianaGenericFileFormat);

				logger.log(LogStatus.INFO,"process the Files and get the control file ");
				finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
				fileNames=FileContentReader.putGetFilefromServerIndiana(FileName,outboundFileName,null,timeStamp);
				
				logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
				Errormessage=CommonMethods.getProviderErrorMessageForMissingRequiredField();
				Assertion_DbVerifier.assertControlFileInValidindiana(fileNames,FileName,Errormessage,globalVariables.provider,timeStamp);
				

			}
			 
			 @Test(enabled = true, groups = {"All"})
			 @AdditionalInfo(module = "OpenEVV")
			 public void SEVV_7631_TC99931_providertaxonomy_alphanumeric() throws InterruptedException, java.text.ParseException,  Exception{
					// logger = extent.startTest("SEVV_7631_TC99930_Taxid_special_alphanumeric");
						

					//////////////Variable declaration ///////////////////
					Map<String ,String> mapUpdateFileData = new HashMap<>();
					Map<String ,String> finalMapapdataByRow = new HashMap<>();
					Map<String ,String> mapOutboundData = new HashMap<>();
					List<String> Errormessage = new ArrayList<String>();
					Map<String ,String> fileUpdateValue = new HashMap<>();
					String FileName;
					List<String> fileNames;
				logger.log(LogStatus.INFO,"Creating map for required Field map");
				fileUpdateValue=GenerateUniqueParam.providerParams_PipeDelimited();
				
				fileUpdateValue.put(globalVariables.providertaxonomy,CommonMethods.generateRandomAlphaNumeric(9));
			

				logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
				FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.indianaProviderGenericFile, fileUpdateValue,globalVariables.indianaGenericFileFormat, globalVariables.provider,timeStamp);

				logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
				mapOutboundData.put(FileName, "1");
				String outboundFileName= FileContentReader.createOutboundFileAndEncryptGeneric(mapOutboundData,timeStamp,globalVariables.indianaGenericFileFormat);

				logger.log(LogStatus.INFO,"process the Files and get the control file ");
				finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
				fileNames=FileContentReader.putGetFilefromServerIndiana(FileName,outboundFileName,null,timeStamp);
				
				logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
				Errormessage=CommonMethods.getProviderErrorMessageForMissingRequiredField();
				Assertion_DbVerifier.assertControlFileInValidindiana(fileNames,FileName,Errormessage,globalVariables.provider,timeStamp);

			}
			 
			 @Test(enabled = true, groups = {"All"})
			 @AdditionalInfo(module = "OpenEVV")
			 public void SEVV_7631_TC99931_providertaxonomy_null() throws InterruptedException, java.text.ParseException,  Exception{
					// logger = extent.startTest("SEVV_7631_TC99930_Taxid_special_alphanumeric");
						

					//////////////Variable declaration ///////////////////
					Map<String ,String> mapUpdateFileData = new HashMap<>();
					Map<String ,String> finalMapapdataByRow = new HashMap<>();
					Map<String ,String> mapOutboundData = new HashMap<>();
					List<String> Errormessage = new ArrayList<String>();
					Map<String ,String> fileUpdateValue = new HashMap<>();
					String FileName;
					List<String> fileNames;
				logger.log(LogStatus.INFO,"Creating map for required Field map");
				fileUpdateValue=GenerateUniqueParam.providerParams_PipeDelimited();
				
				fileUpdateValue.put(globalVariables.providertaxonomy,null);
			

				logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
				FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.indianaProviderGenericFile, fileUpdateValue,globalVariables.indianaGenericFileFormat, globalVariables.provider,timeStamp);

				logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
				mapOutboundData.put(FileName, "1");
				String outboundFileName= FileContentReader.createOutboundFileAndEncryptGeneric(mapOutboundData,timeStamp,globalVariables.indianaGenericFileFormat);

				logger.log(LogStatus.INFO,"process the Files and get the control file ");
				finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
				fileNames=FileContentReader.putGetFilefromServerIndiana(FileName,outboundFileName,null,timeStamp);
				
				logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
				Assertion_DbVerifier.assertControlFileValidindiana(fileNames,FileName,finalMapapdataByRow,outboundFileName,globalVariables.provider,timeStamp);
			}


		 @Test(enabled = true, groups = {"All", "Regression"})
			@AdditionalInfo(module = "OpenEVV")
			
			 public void SEVV_7361_TC99933_ProviderDateBegin_invalid_formate() throws InterruptedException, java.text.ParseException,  Exception{
				// logger = extent.startTest("SEVV_7361_TC99933_ProviderDateBegin_invalid_formate");

				//////////////Variable declaration ///////////////////
				Map<String ,String> mapUpdateFileData = new HashMap<>();
				Map<String ,String> finalMapapdataByRow = new HashMap<>();
				Map<String ,String> mapOutboundData = new HashMap<>();
				List<String> Errormessage = new ArrayList<String>();
				Map<String ,String> fileUpdateValue = new HashMap<>();
				String FileName;
				List<String> fileNames;		

			logger.log(LogStatus.INFO,"Creating map for required Field map");
			fileUpdateValue=GenerateUniqueParam.providerParams_PipeDelimited();
			
			fileUpdateValue.put(globalVariables.ProviderDateBegin,CommonMethods.generatecurrentDate_YYYYMMdd());
			
			logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
			FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.indianaProviderGenericFile, fileUpdateValue,globalVariables.indianaGenericFileFormat, globalVariables.provider,timeStamp);

			logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
			mapOutboundData.put(FileName, "1");
			String outboundFileName= FileContentReader.createOutboundFileAndEncryptGeneric(mapOutboundData,timeStamp,globalVariables.indianaGenericFileFormat);

			logger.log(LogStatus.INFO,"process the Files and get the control file ");
			finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
			fileNames=FileContentReader.putGetFilefromServerIndiana(FileName,outboundFileName,null,timeStamp);
			
			logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
			Errormessage=CommonMethods.getProviderErrorMessageForMissingRequiredField();
			Assertion_DbVerifier.assertControlFileInValidindiana(fileNames,FileName,Errormessage,globalVariables.provider,timeStamp);
			
			}
			
			@Test(enabled = true, groups = {"All"})
			@AdditionalInfo(module = "OpenEVV")
			 public void SEVV_7361_TC99933_ProviderDateBegin_lenghth_blank() throws InterruptedException, java.text.ParseException,  Exception{
					// logger = extent.startTest("SEVV_7361_TC99933_ProviderDateBegin_lenghth_blank");

					//////////////Variable declaration ///////////////////
					Map<String ,String> mapUpdateFileData = new HashMap<>();
					Map<String ,String> finalMapapdataByRow = new HashMap<>();
					Map<String ,String> mapOutboundData = new HashMap<>();
					List<String> Errormessage = new ArrayList<String>();
					Map<String ,String> fileUpdateValue = new HashMap<>();
					String FileName;
					List<String> fileNames;			

				logger.log(LogStatus.INFO,"Creating map for required Field map");
				fileUpdateValue=GenerateUniqueParam.providerParams_PipeDelimited();
				
				fileUpdateValue.put(globalVariables.ProviderDateBegin,"");
				

				logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
				FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.indianaProviderGenericFile, fileUpdateValue,globalVariables.indianaGenericFileFormat, globalVariables.provider,timeStamp);

				logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
				mapOutboundData.put(FileName, "1");
				String outboundFileName= FileContentReader.createOutboundFileAndEncryptGeneric(mapOutboundData,timeStamp,globalVariables.indianaGenericFileFormat);

				logger.log(LogStatus.INFO,"process the Files and get the control file ");
				finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
				fileNames=FileContentReader.putGetFilefromServerIndiana(FileName,outboundFileName,null,timeStamp);
				
				logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
				Errormessage=CommonMethods.getProviderErrorMessageForMissingRequiredField();
				Assertion_DbVerifier.assertControlFileInValidindiana(fileNames,FileName,Errormessage,globalVariables.provider,timeStamp);
				

			}
			 
			@Test(enabled = true, groups = {"All", "Regression"})
			@AdditionalInfo(module = "OpenEVV")
			
			 public void SEVV_7361_TC99934_ProviderDateBegin_invalid_formate() throws InterruptedException, java.text.ParseException,  Exception{
				// logger = extent.startTest("SEVV_7361_TC99933_ProviderDateBegin_invalid_formate");

				//////////////Variable declaration ///////////////////
				Map<String ,String> mapUpdateFileData = new HashMap<>();
				Map<String ,String> finalMapapdataByRow = new HashMap<>();
				Map<String ,String> mapOutboundData = new HashMap<>();
				List<String> Errormessage = new ArrayList<String>();
				Map<String ,String> fileUpdateValue = new HashMap<>();
				String FileName;
				List<String> fileNames;	

			logger.log(LogStatus.INFO,"Creating map for required Field map");
			fileUpdateValue=GenerateUniqueParam.providerParams_PipeDelimited();
			
			fileUpdateValue.put(globalVariables.ProviderDateEnd,CommonMethods.generatecurrentDate_YYYYMMdd());
			
			logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
			FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.indianaProviderGenericFile, fileUpdateValue,globalVariables.indianaGenericFileFormat, globalVariables.provider,timeStamp);

			logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
			mapOutboundData.put(FileName, "1");
			String outboundFileName= FileContentReader.createOutboundFileAndEncryptGeneric(mapOutboundData,timeStamp,globalVariables.indianaGenericFileFormat);

			logger.log(LogStatus.INFO,"process the Files and get the control file ");
			finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
			fileNames=FileContentReader.putGetFilefromServerIndiana(FileName,outboundFileName,null,timeStamp);
			
			logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
			Errormessage=CommonMethods.getProviderErrorMessageForMissingRequiredField();
			Assertion_DbVerifier.assertControlFileInValidindiana(fileNames,FileName,Errormessage,globalVariables.provider,timeStamp);
			
			}
			
			@Test(enabled = true, groups = {"All"})
			@AdditionalInfo(module = "OpenEVV")
			 public void SEVV_7361_TC99934_ProviderDateBegin_lenghth_blank() throws InterruptedException, java.text.ParseException,  Exception{
					// logger = extent.startTest("SEVV_7361_TC99933_ProviderDateBegin_lenghth_blank");
			

					//////////////Variable declaration ///////////////////
					Map<String ,String> mapUpdateFileData = new HashMap<>();
					Map<String ,String> finalMapapdataByRow = new HashMap<>();
					Map<String ,String> mapOutboundData = new HashMap<>();
					List<String> Errormessage = new ArrayList<String>();
					Map<String ,String> fileUpdateValue = new HashMap<>();
					String FileName;
					List<String> fileNames;

				logger.log(LogStatus.INFO,"Creating map for required Field map");
				fileUpdateValue=GenerateUniqueParam.providerParams_PipeDelimited();
				
				fileUpdateValue.put(globalVariables.ProviderDateEnd,"");
				

				logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
				FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.indianaProviderGenericFile, fileUpdateValue,globalVariables.indianaGenericFileFormat, globalVariables.provider,timeStamp);

				logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
				mapOutboundData.put(FileName, "1");
				String outboundFileName= FileContentReader.createOutboundFileAndEncryptGeneric(mapOutboundData,timeStamp,globalVariables.indianaGenericFileFormat);

				logger.log(LogStatus.INFO,"process the Files and get the control file ");
				finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
				fileNames=FileContentReader.putGetFilefromServerIndiana(FileName,outboundFileName,null,timeStamp);
				
				logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
				Errormessage=CommonMethods.getProviderErrorMessageForMissingRequiredField();
				Assertion_DbVerifier.assertControlFileInValidindiana(fileNames,FileName,Errormessage,globalVariables.provider,timeStamp);
				

			}
			 
			@Test(enabled = true, groups = {"All", "Regression"})
			@AdditionalInfo(module = "OpenEVV")
			
			 public void SEVV_7361_TC99934_ProviderDateBegin_null() throws InterruptedException, java.text.ParseException,  Exception{
				// logger = extent.startTest("SEVV_7361_TC99933_ProviderDateBegin_invalid_formate");
					

				//////////////Variable declaration ///////////////////
				Map<String ,String> mapUpdateFileData = new HashMap<>();
				Map<String ,String> finalMapapdataByRow = new HashMap<>();
				Map<String ,String> mapOutboundData = new HashMap<>();
				List<String> Errormessage = new ArrayList<String>();
				Map<String ,String> fileUpdateValue = new HashMap<>();
				String FileName;
				List<String> fileNames; 
			logger.log(LogStatus.INFO,"Creating map for required Field map");
			fileUpdateValue=GenerateUniqueParam.providerParams_PipeDelimited();
			
			fileUpdateValue.put(globalVariables.ProviderDateEnd,null);
			
			logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
			FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.indianaProviderGenericFile, fileUpdateValue,globalVariables.indianaGenericFileFormat, globalVariables.provider,timeStamp);

			logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
			mapOutboundData.put(FileName, "1");
			String outboundFileName= FileContentReader.createOutboundFileAndEncryptGeneric(mapOutboundData,timeStamp,globalVariables.indianaGenericFileFormat);

			logger.log(LogStatus.INFO,"process the Files and get the control file ");
			finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
			fileNames=FileContentReader.putGetFilefromServerIndiana(FileName,outboundFileName,null,timeStamp);
			
			logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
			Assertion_DbVerifier.assertControlFileValidindiana(fileNames,FileName,finalMapapdataByRow,outboundFileName,globalVariables.provider,timeStamp);
			
			}
					 
}
