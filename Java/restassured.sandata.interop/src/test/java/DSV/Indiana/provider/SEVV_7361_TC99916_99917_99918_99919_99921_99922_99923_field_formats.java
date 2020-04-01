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

public class SEVV_7361_TC99916_99917_99918_99919_99921_99922_99923_field_formats extends BaseTest{

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

	public void SEVV_7361_TC99916_AddressLine2_lenghth_morethan_allowed() throws InterruptedException,  Exception{
		// logger = extent.startTest("SEVV_7361_TC99916_AddressLine2_lenghth_morethan_allowed");

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

		fileUpdateValue.put(globalVariables.AddressLine2,CommonMethods.generateRandomStringOfFixLength(51));



		logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
		FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.indianaProviderGenericFile, fileUpdateValue,globalVariables.indianaGenericFileFormat, globalVariables.provider,timeStamp);

		logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
		mapOutboundData.put(FileName, "1");
		String outboundFileName= FileContentReader.createOutboundFileAndEncryptGeneric(mapOutboundData,timeStamp,globalVariables.indianaGenericFileFormat);

		logger.log(LogStatus.INFO,"process the Files and get the control file ");
		finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
		fileNames=FileContentReader.putGetFilefromServerIndiana(FileName,outboundFileName,globalVariables.provider,timeStamp);

		logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
		Errormessage.add(globalVariables.AddressLine2lengthError);
		Assertion_DbVerifier.assertControlFileInValidindiana(fileNames,FileName,Errormessage,globalVariables.provider,timeStamp);

	}


	
	@Test(enabled = true, groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")

	public void SEVV_7361_TC99917_Addresscity_lenghth_morethan_allowed() throws InterruptedException,  Exception{
		// logger = extent.startTest("SEVV_7361_TC99916_AddressLine2_lenghth_morethan_allowed");

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

		fileUpdateValue.put(globalVariables.AddressCity,CommonMethods.generateRandomStringOfFixLength(51));

		logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
		FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.indianaProviderGenericFile, fileUpdateValue,globalVariables.indianaGenericFileFormat, globalVariables.provider,timeStamp);

		logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
		mapOutboundData.put(FileName, "1");
		String outboundFileName= FileContentReader.createOutboundFileAndEncryptGeneric(mapOutboundData,timeStamp,globalVariables.indianaGenericFileFormat);

		logger.log(LogStatus.INFO,"process the Files and get the control file ");
		finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
		fileNames=FileContentReader.putGetFilefromServerIndiana(FileName,outboundFileName,globalVariables.provider,timeStamp);

		logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
		Errormessage.add(globalVariables.AddresscitylengthError);
		Assertion_DbVerifier.assertControlFileInValidindiana(fileNames,FileName,Errormessage,globalVariables.provider,timeStamp);

	}

	@Test(enabled = true, groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void SEVV_7361_TC99917_Addresscity_lenghth_blank() throws InterruptedException,  Exception{
		// logger = extent.startTest("SEVV_7361_TC99917_Addresscity_lenghth_blank");


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

		fileUpdateValue.put(globalVariables.AddressCity,"");


		logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
		FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.indianaProviderGenericFile, fileUpdateValue,globalVariables.indianaGenericFileFormat, globalVariables.provider,timeStamp);

		logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
		mapOutboundData.put(FileName, "1");
		String outboundFileName= FileContentReader.createOutboundFileAndEncryptGeneric(mapOutboundData,timeStamp,globalVariables.indianaGenericFileFormat);

		logger.log(LogStatus.INFO,"process the Files and get the control file ");
		finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
		fileNames=FileContentReader.putGetFilefromServerIndiana(FileName,outboundFileName,globalVariables.provider,timeStamp);

		logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
		Errormessage.add(globalVariables.AddressCityNullError);
		Errormessage.add(globalVariables.AddresscitylengthError);
		Assertion_DbVerifier.assertControlFileInValidindiana(fileNames,FileName,Errormessage,globalVariables.provider,timeStamp);


	}

	@Test(enabled = true, groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void SEVV_7361_TC99917_Addresscity_special_character() throws InterruptedException,  Exception{
		// logger = extent.startTest("SEVV_7361_TC99917_Addresscity_special_character");


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

		fileUpdateValue.put(globalVariables.AddressCity,CommonMethods.generateSpecialChar(10));


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
	public void SEVV_7361_TC99917_Addresscity_lenghth_null() throws InterruptedException,  Exception{
		// logger = extent.startTest("SEVV_7361_TC99917_Addresscity_lenghth_null");


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

		fileUpdateValue.put(globalVariables.AddressCity,null);




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

	public void SEVV_7361_TC99918_AddressState_lenghth_morethan_allowed() throws InterruptedException,  Exception{
		// logger = extent.startTest("SEVV_7361_TC99918_AddressState_lenghth_morethan_allowed");

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

		fileUpdateValue.put(globalVariables.AddressState,CommonMethods.generateRandomStringOfFixLength(3));

		logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
		FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.indianaProviderGenericFile, fileUpdateValue,globalVariables.indianaGenericFileFormat, globalVariables.provider,timeStamp);

		logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
		mapOutboundData.put(FileName, "1");
		String outboundFileName= FileContentReader.createOutboundFileAndEncryptGeneric(mapOutboundData,timeStamp,globalVariables.indianaGenericFileFormat);

		logger.log(LogStatus.INFO,"process the Files and get the control file ");
		finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
		fileNames=FileContentReader.putGetFilefromServerIndiana(FileName,outboundFileName,globalVariables.provider,timeStamp);

		logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
		Errormessage.add(globalVariables.AddressStateLengtherror);
		Assertion_DbVerifier.assertControlFileInValidindiana(fileNames,FileName,Errormessage,globalVariables.provider,timeStamp);

	}




	@Test(enabled = true, groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void SEVV_7361_TC99918_AddressState_lenghth_null() throws InterruptedException,  Exception{
		// logger = extent.startTest("SEVV_7361_TC99918_AddressState_lenghth_null");

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

		fileUpdateValue.put(globalVariables.AddressState,null);




		logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
		FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.indianaProviderGenericFile, fileUpdateValue,globalVariables.indianaGenericFileFormat, globalVariables.provider,timeStamp);

		logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
		mapOutboundData.put(FileName, "1");
		String outboundFileName= FileContentReader.createOutboundFileAndEncryptGeneric(mapOutboundData,timeStamp,globalVariables.indianaGenericFileFormat);

		logger.log(LogStatus.INFO,"process the Files and get the control file ");
		finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
		fileNames=FileContentReader.putGetFilefromServerIndiana(FileName,outboundFileName,globalVariables.provider,timeStamp);

		logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
		Errormessage.add(globalVariables.AddressStateLengtherror);
		Assertion_DbVerifier.assertControlFileInValidindiana(fileNames,FileName,Errormessage,globalVariables.provider,timeStamp);

	}






	@Test(enabled = true, groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")

	public void SEVV_7361_TC99919_AddressZip_lenghth_morethan_allowed() throws InterruptedException,  Exception{
		// logger = extent.startTest("SEVV_7361_TC99919_AddressZip_lenghth_morethan_allowed");


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

		fileUpdateValue.put(globalVariables.AddressZip,CommonMethods.generateRandomNumberOfFixLength(10));

		logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
		FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.indianaProviderGenericFile, fileUpdateValue,globalVariables.indianaGenericFileFormat, globalVariables.provider,timeStamp);

		logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
		mapOutboundData.put(FileName, "1");
		String outboundFileName= FileContentReader.createOutboundFileAndEncryptGeneric(mapOutboundData,timeStamp,globalVariables.indianaGenericFileFormat);

		logger.log(LogStatus.INFO,"process the Files and get the control file ");
		finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
		fileNames=FileContentReader.putGetFilefromServerIndiana(FileName,outboundFileName,globalVariables.provider,timeStamp);

		logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
		Errormessage.add(globalVariables.AddressZipformaterror);
		Assertion_DbVerifier.assertControlFileInValidindiana(fileNames,FileName,Errormessage,globalVariables.provider,timeStamp);

	}

	@Test(enabled = true, groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void SEVV_7361_TC99919_AddressZip_lenghth_blank() throws InterruptedException,  Exception{
		// logger = extent.startTest("SEVV_7361_TC99919_AddressZip_lenghth_blank");

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

		fileUpdateValue.put(globalVariables.AddressZip,"");


		logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
		FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.indianaProviderGenericFile, fileUpdateValue,globalVariables.indianaGenericFileFormat, globalVariables.provider,timeStamp);

		logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
		mapOutboundData.put(FileName, "1");
		String outboundFileName= FileContentReader.createOutboundFileAndEncryptGeneric(mapOutboundData,timeStamp,globalVariables.indianaGenericFileFormat);

		logger.log(LogStatus.INFO,"process the Files and get the control file ");
		finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
		fileNames=FileContentReader.putGetFilefromServerIndiana(FileName,outboundFileName,null,timeStamp);

		logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
		Errormessage.add(globalVariables.AddressZipNullError);
		Assertion_DbVerifier.assertControlFileInValidindiana(fileNames,FileName,Errormessage,globalVariables.provider,timeStamp);


	}

	@Test(enabled = true, groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void SEVV_7361_TC99919_AddressZip_special_character() throws InterruptedException,  Exception{
		// logger = extent.startTest("SEVV_7361_TC99919_AddressZip_special_character");

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

		fileUpdateValue.put(globalVariables.AddressZip,CommonMethods.generateSpecialChar(9));


		logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
		FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.indianaProviderGenericFile, fileUpdateValue,globalVariables.indianaGenericFileFormat, globalVariables.provider,timeStamp);

		logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
		mapOutboundData.put(FileName, "1");
		String outboundFileName= FileContentReader.createOutboundFileAndEncryptGeneric(mapOutboundData,timeStamp,globalVariables.indianaGenericFileFormat);

		logger.log(LogStatus.INFO,"process the Files and get the control file ");
		finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
		fileNames=FileContentReader.putGetFilefromServerIndiana(FileName,outboundFileName,globalVariables.provider,timeStamp);

		logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
		Errormessage.add(globalVariables.AddressZipformaterror);
		Assertion_DbVerifier.assertControlFileInValidindiana(fileNames,FileName,Errormessage,globalVariables.provider,timeStamp);

	}
	@Test(enabled = true, groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void SEVV_7361_TC99919_AddressZip_lenghth_null() throws InterruptedException,  Exception{
		// logger = extent.startTest("SEVV_7361_TC99919_AddressZip_lenghth_null");


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

		fileUpdateValue.put(globalVariables.AddressZip,null);


		logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
		FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.indianaProviderGenericFile, fileUpdateValue,globalVariables.indianaGenericFileFormat, globalVariables.provider,timeStamp);

		logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
		mapOutboundData.put(FileName, "1");
		String outboundFileName= FileContentReader.createOutboundFileAndEncryptGeneric(mapOutboundData,timeStamp,globalVariables.indianaGenericFileFormat);

		logger.log(LogStatus.INFO,"process the Files and get the control file ");
		finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
		fileNames=FileContentReader.putGetFilefromServerIndiana(FileName,outboundFileName,globalVariables.provider,timeStamp);

		logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
		Errormessage.add(globalVariables.AddressZipformaterror);
		Assertion_DbVerifier.assertControlFileInValidindiana(fileNames,FileName,Errormessage,globalVariables.provider,timeStamp);


	}

	@Test(enabled = true, groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")

	public void SEVV_7361_TC99921_AddressCounty_lenghth_morethan_allowed() throws InterruptedException,  Exception{
		// logger = extent.startTest("SEVV_7361_TC99921_AddressCounty_lenghth_morethan_allowed");

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

		fileUpdateValue.put(globalVariables.County,CommonMethods.generateRandomNumberOfFixLength(31));

		logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
		FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.indianaProviderGenericFile, fileUpdateValue,globalVariables.indianaGenericFileFormat, globalVariables.provider,timeStamp);

		logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
		mapOutboundData.put(FileName, "1");
		String outboundFileName= FileContentReader.createOutboundFileAndEncryptGeneric(mapOutboundData,timeStamp,globalVariables.indianaGenericFileFormat);

		logger.log(LogStatus.INFO,"process the Files and get the control file ");
		finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
		fileNames=FileContentReader.putGetFilefromServerIndiana(FileName,outboundFileName,globalVariables.provider,timeStamp);

		logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
		Errormessage.add(globalVariables.CountylengthError);
		Assertion_DbVerifier.assertControlFileInValidindiana(fileNames,FileName,Errormessage,globalVariables.provider,timeStamp);

	}

	@Test(enabled = true, groups = {"All", "Regression" })
	@AdditionalInfo(module = "OpenEVV")
	public void SEVV_7361_TC99922_County_lenghth_blank() throws InterruptedException,  Exception{
		// logger = extent.startTest("SEVV_7361_TC99921_County_lenghth_blank");


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

		fileUpdateValue.put(globalVariables.County,"");


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
	public void SEVV_7361_TC99922_County_special_character() throws InterruptedException,  Exception{
		// logger = extent.startTest("SEVV_7361_TC99922_AgencyPhone_special_character");

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

		fileUpdateValue.put(globalVariables.County,CommonMethods.generateSpecialChar(9));


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

	public void SEVV_7361_TC99921_AgencyPhone_lenghth_morethan_allowed() throws InterruptedException,  Exception{
		// logger = extent.startTest("SEVV_7361_TC99921_AddressCounty_lenghth_morethan_allowed");

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

		fileUpdateValue.put(globalVariables.AgencyPhone,CommonMethods.generateRandomNumberOfFixLength(11));

		logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
		FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.indianaProviderGenericFile, fileUpdateValue,globalVariables.indianaGenericFileFormat, globalVariables.provider,timeStamp);

		logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
		mapOutboundData.put(FileName, "1");
		String outboundFileName= FileContentReader.createOutboundFileAndEncryptGeneric(mapOutboundData,timeStamp,globalVariables.indianaGenericFileFormat);

		logger.log(LogStatus.INFO,"process the Files and get the control file ");
		finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
		fileNames=FileContentReader.putGetFilefromServerIndiana(FileName,outboundFileName,globalVariables.provider,timeStamp);

		logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
		Errormessage.add(globalVariables.memberAgencyPhone);
		Assertion_DbVerifier.assertControlFileInValidindiana(fileNames,FileName,Errormessage,globalVariables.provider,timeStamp);

	}

	@Test(enabled = true, groups = {"All", "Regression" })
	@AdditionalInfo(module = "OpenEVV")
	public void SEVV_7361_TC99921_AgencyPhone_lenghth_blank() throws InterruptedException,  Exception{
		// logger = extent.startTest("SEVV_7361_TC99921_County_lenghth_blank");


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

		fileUpdateValue.put(globalVariables.AgencyPhone,"");


		logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
		FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.indianaProviderGenericFile, fileUpdateValue,globalVariables.indianaGenericFileFormat, globalVariables.provider,timeStamp);

		logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
		mapOutboundData.put(FileName, "1");
		String outboundFileName= FileContentReader.createOutboundFileAndEncryptGeneric(mapOutboundData,timeStamp,globalVariables.indianaGenericFileFormat);

		logger.log(LogStatus.INFO,"process the Files and get the control file ");
		finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
		fileNames=FileContentReader.putGetFilefromServerIndiana(FileName,outboundFileName,globalVariables.provider,timeStamp);

		logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
		Errormessage.add(globalVariables.memberAgencyphoneNull);
		Errormessage.add(globalVariables.memberAgencyPhone);
		Assertion_DbVerifier.assertControlFileInValidindiana(fileNames,FileName,Errormessage,globalVariables.provider,timeStamp);


	}

	@Test(enabled = true, groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void SEVV_7361_TC99921_AgencyPhone_special_character() throws InterruptedException,  Exception{
		// logger = extent.startTest("SEVV_7361_TC99922_AgencyPhone_special_character");

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

		fileUpdateValue.put(globalVariables.AgencyPhone,CommonMethods.generateRandomNumberOfFixLength(7)+ CommonMethods.generateSpecialChar(1)+ CommonMethods.generateRandomNumberOfFixLength(2));


		logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
		FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.indianaProviderGenericFile, fileUpdateValue,globalVariables.indianaGenericFileFormat, globalVariables.provider,timeStamp);

		logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
		mapOutboundData.put(FileName, "1");
		String outboundFileName= FileContentReader.createOutboundFileAndEncryptGeneric(mapOutboundData,timeStamp,globalVariables.indianaGenericFileFormat);

		logger.log(LogStatus.INFO,"process the Files and get the control file ");
		finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
		fileNames=FileContentReader.putGetFilefromServerIndiana(FileName,outboundFileName,globalVariables.provider,timeStamp);

		logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
		Errormessage.add(globalVariables.memberAgencyPhone);
		Assertion_DbVerifier.assertControlFileInValidindiana(fileNames,FileName,Errormessage,globalVariables.provider,timeStamp);

	}

	@Test(enabled = true, groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")

	public void SEVV_7361_TC99923_PrimaryContactLastName_lenghth_morethan_allowed() throws InterruptedException,  Exception{
		// logger = extent.startTest("SEVV_7361_TC99921_AddressCounty_lenghth_morethan_allowed");


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

		fileUpdateValue.put(globalVariables.PrimaryContactLastName,CommonMethods.generateRandomNumberOfFixLength(31));

		logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
		FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.indianaProviderGenericFile, fileUpdateValue,globalVariables.indianaGenericFileFormat, globalVariables.provider,timeStamp);

		logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
		mapOutboundData.put(FileName, "1");
		String outboundFileName= FileContentReader.createOutboundFileAndEncryptGeneric(mapOutboundData,timeStamp,globalVariables.indianaGenericFileFormat);

		logger.log(LogStatus.INFO,"process the Files and get the control file ");
		finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
		fileNames=FileContentReader.putGetFilefromServerIndiana(FileName,outboundFileName,globalVariables.provider,timeStamp);

		logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
		Errormessage.add(globalVariables.PrimaryContactLastNameLengthError);
		Assertion_DbVerifier.assertControlFileInValidindiana(fileNames,FileName,Errormessage,globalVariables.provider,timeStamp);

	}

	@Test(enabled = true, groups = {"All", "Regression" })
	@AdditionalInfo(module = "OpenEVV")
	public void SEVV_7361_TC99922_PrimaryContactLastName_lenghth_blank() throws InterruptedException,  Exception{
		// logger = extent.startTest("SEVV_7361_TC99921_County_lenghth_blank");

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

		fileUpdateValue.put(globalVariables.PrimaryContactLastName,"");


		logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
		FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.indianaProviderGenericFile, fileUpdateValue,globalVariables.indianaGenericFileFormat, globalVariables.provider,timeStamp);

		logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
		mapOutboundData.put(FileName, "1");
		String outboundFileName= FileContentReader.createOutboundFileAndEncryptGeneric(mapOutboundData,timeStamp,globalVariables.indianaGenericFileFormat);

		logger.log(LogStatus.INFO,"process the Files and get the control file ");
		finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
		fileNames=FileContentReader.putGetFilefromServerIndiana(FileName,outboundFileName,globalVariables.provider,timeStamp);

		logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
		Errormessage.add(globalVariables.PrimaryContactLastNameNullError);
		Assertion_DbVerifier.assertControlFileInValidindiana(fileNames,FileName,Errormessage,globalVariables.provider,timeStamp);


	}



	@Test(enabled = true, groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void SEVV_7361_TC99923_PrimaryContactLastName_null() throws InterruptedException,  Exception{
		// logger = extent.startTest("SEVV_7361_TC99923_PrimaryContactLastName_special_character");


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

		fileUpdateValue.put(globalVariables.PrimaryContactLastName,null);


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