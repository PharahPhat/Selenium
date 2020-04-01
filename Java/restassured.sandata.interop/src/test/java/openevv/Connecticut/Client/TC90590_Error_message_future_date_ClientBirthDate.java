package openevv.Connecticut.Client;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.globalMethods.core.globalVariables.ClientID;
import static com.globalMethods.core.globalVariables.ClientMedicaidID;

public class TC90590_Error_message_future_date_ClientBirthDate extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC90590_OpenEVV_Client_Error_message_future_date_ClientBirthDate() throws IOException, ParseException
	{
		System.out.println("**************Started executing future clientBirthDate scenario*************");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		js.put(ClientID, CommonMethods.generateRandomNumberOfFixLength(5));
		js.put(ClientMedicaidID, CommonMethods.generateRandomNumberOfFixLength(12));
		js.put("ClientBirthDate", CommonMethods.generateFutureDate_MM_DD_YYYY());
		logger.log(LogStatus.INFO, "extracting request send body " + j.toJSONString());
		String bodyAsString = CommonMethods.capturePostResponse(j,
				CommonMethods.propertyfileReader(globalVariables.openevv_client_url));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientBirthDateformaterror);
	}
}
