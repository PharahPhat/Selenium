package DSV.Molina.Member;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.FileContentReader;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;

import com.globalMethods.core.Assertion_DbVerifier; 
public class SEVV8612_TC101706_TC101711_101713_Member_Only_Mandatory_Field extends BaseTest {
	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); 
	Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	String timeStamp;  FileContentReader FileContentReader =new FileContentReader(); 
	
	
	@BeforeMethod(alwaysRun = true)
	public void tearDown()
	{
		 this.timeStamp =CommonMethods.getTimeStamp();	
	 
	}
	//Inter-Op - Molina - Member: Missing Required Fields
	@Test(enabled = true, groups = {"All"})
	public void SEVV8612_TC101706_TC101711_101713_Member_Only_Mandatory_Field() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("SEVV8612_TC101706_TC101711_Member_Only_Mandatory_Field");

		//////////////Variable declaration ///////////////////
		Map<String ,String> mapOutboundData = new HashMap<>();
		String FileName;
		Map<String ,String> finalMapapdataByRow = new HashMap<>();
		List<String> fileNames;
		List<String> mapdataByValue = new ArrayList<String>();
		List<String> mapdataByValueNonMandatory = new ArrayList<String>();
		
		
		
		logger.log(LogStatus.INFO,"Creating map for removing the required  Field map");
		mapdataByValue=GenerateUniqueParam.MemberParams_PipeDelimited_Missing_RequiredField();
		finalMapapdataByRow=FileContentReader.readFileDataAddToMapWithRowNo(globalVariables.molinaGenericFile,3);
		for( String value : finalMapapdataByRow.keySet() ){
		mapdataByValueNonMandatory.add(value.replaceAll("^[\"']+|[\"']+$", "").toLowerCase());
	}
		
		for(int i=0 ;i<mapdataByValue.size();i++){
		mapdataByValueNonMandatory.remove(mapdataByValue.get(i).toLowerCase());
		}

		logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
		FileName =FileContentReader.createPipeDelimFileAndConvertToGPGWithRemovalField(globalVariables.molinaGenericFile,mapdataByValueNonMandatory,globalVariables.member, timeStamp);

		logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
		mapOutboundData.put(FileName, "1");
		String outboundFileName= FileContentReader.createOutboundFileAndEncrypt(mapOutboundData,timeStamp);

		logger.log(LogStatus.INFO,"process the Files and get the control file ");
		finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
		fileNames=FileContentReader.putGetFilefromServer(FileName,outboundFileName,null,timeStamp);

		logger.log(LogStatus.INFO,"Veirfying the value in Db and control File dat");
		assertionDbVerifier.verifyInboundFile(fileNames,mapOutboundData,timeStamp);
		

	}


}
