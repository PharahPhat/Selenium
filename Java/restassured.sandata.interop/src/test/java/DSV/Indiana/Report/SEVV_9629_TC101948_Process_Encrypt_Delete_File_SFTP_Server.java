package DSV.Indiana.Report;

import java.util.List;
import java.util.Map;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import com.globalMethods.core.FileContentReader;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import Resources.Indiana.ETL.DataGenerator_Indiana_ETL;
import Utills_ExtentReport_Log4j.BaseTest;

public class SEVV_9629_TC101948_Process_Encrypt_Delete_File_SFTP_Server extends BaseTest {
	
	FileContentReader FileContentReader =new FileContentReader(); 
	DataGenerator_Indiana_ETL dataGen = new DataGenerator_Indiana_ETL();
	
	@Test(enabled = true, groups = {"All", "Regression",})
	public void TC101893_Validate_Extension_Of_Files() throws InterruptedException, java.text.ParseException, Exception{
		
		// logger = extent.startTest("TC101893_Validate_Extension_Of_Files");
		
		logger.log(LogStatus.INFO,"Upload files to download folder on SFTP server");
		List<String> FileNames = FileContentReader.getFileNamesInDirectory(globalVariables.indianaReports);
		FileContentReader.putReportFileIndiana(FileNames);
		
		logger.log(LogStatus.INFO,"Run Cron job");
		@SuppressWarnings("unused")
		Map<String, JSONObject> returnObject=dataGen.processIndiana_ETL();
		
		logger.log(LogStatus.INFO,"Validate files got processed and encrypted in upload folder");
		FileContentReader.isFileExist_Encrypted_Indiana(FileNames);
		
		logger.log(LogStatus.INFO,"Validate processed files got deleted in download folder");
		FileContentReader.isFileDeleted_Indiana(FileNames);
		
	}

}
