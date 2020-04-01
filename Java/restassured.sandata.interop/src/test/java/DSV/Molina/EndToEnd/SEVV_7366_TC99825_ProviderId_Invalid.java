package DSV.Molina.EndToEnd;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.Constant_SQL;
import com.globalMethods.core.DataBaseVerifier;
import com.globalMethods.core.FileContentReader;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.MYSQL_Database_Verifier;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;

public class SEVV_7366_TC99825_ProviderId_Invalid extends BaseTest

{
	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	Assertion_DbVerifier Assertion_DbVerifier=new Assertion_DbVerifier();
	DataBaseVerifier DataBaseVerfier=new DataBaseVerifier();
	Constant_SQL Constant_SQL=new Constant_SQL();
	
	Map<String ,String> fileUpdateValue = new HashMap<>();
	String fileName;
	//////////////Variable declaration ///////////////////
	Map<String ,String> memberUpdateFileData = new HashMap<>();
	Map<String ,String> authUpdateFileData = new HashMap<>();
	Map<String ,String> providerUpdateFileData = new HashMap<>();
	Map<String ,String> finalMapapdataByRow = new HashMap<>();
	Map<String ,String> mapOutboundData = new HashMap<>();
	Map<String ,String> mapOutboundDataNew = new HashMap<>();
	
	String FileName_provider,FileName_auth, FileName_member;
	List<String> fileNames;

	String timeStamp;  FileContentReader FileContentReader =new FileContentReader(); 
	@BeforeMethod(alwaysRun = true)
	public void tearDown()
	{
		this.timeStamp =CommonMethods.getTimeStamp();	
		
	}

	@Test(enabled = true, groups = {"All"})
	public void SEVV_7366_TC99825_ProviderId_Invalid() throws Exception
	{

		String Clientidentifer=CommonMethods.generateRandomNumberOfFixLength(10);
	
		// logger = extent.startTest("SEVV_7366_TC99825_ProviderId_Invalid");
		
		authUpdateFileData=GenerateUniqueParam.AuthParams_PipeDelimited_MaxValue();
		authUpdateFileData.put("clientQualifier", "ClientOtherID");
		authUpdateFileData.put("clientIdentifier",Clientidentifer );
		authUpdateFileData.put("providerId",CommonMethods.generateRandomAlphaNumeric(9));
		
		
	
		logger.log(LogStatus.INFO,"create the PipeDeliminated File for Auth and Encrypt to GPG");
		FileName_auth =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.molinaAuthGenericFile, authUpdateFileData,globalVariables.memberAuthFileName,globalVariables.auth,timeStamp);
	
		memberUpdateFileData=GenerateUniqueParam.MemberParams_PipeDelimited_RequiredFieldMax();
		
		memberUpdateFileData.put("ClientOtherID", Clientidentifer);

		logger.log(LogStatus.INFO,"create the PipeDeliminated File for member and Encrypt to GPG");
		FileName_member =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.molinaGenericFile, memberUpdateFileData,globalVariables.memberGenericFileName,globalVariables.member,timeStamp);

		logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
	
		mapOutboundData.put(FileName_auth, "1");
		mapOutboundData.put(FileName_member, "1");

		String outboundFileName= FileContentReader.createOutboundFileAndEncrypt(mapOutboundData,timeStamp);

		logger.log(LogStatus.INFO,"process the Files and get the control file ");
		fileNames=FileContentReader.putGetFilefromServer_Control(mapOutboundData,outboundFileName,null,timeStamp);

		finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName_member);
		
		if(MYSQL_Database_Verifier.executeQueryMySql(String.format(Constant_SQL.StatusCodeAuth, Clientidentifer)).equalsIgnoreCase("1"))
		{
			System.out.println("Data is not processed without ProviderId and ProviderQualifier");	
			
			}
		
		else{
			Assert.fail("Data is  processed without ProviderId and ProviderQualifier");
		}
		
	}

}
