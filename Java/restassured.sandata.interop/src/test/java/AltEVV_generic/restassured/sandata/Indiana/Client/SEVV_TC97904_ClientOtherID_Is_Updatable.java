package AltEVV_generic.restassured.sandata.Indiana.Client;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

public class SEVV_TC97904_ClientOtherID_Is_Updatable extends BaseTest{

	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	@Test(groups = {"All"})
	public void Tc97904_ClientOtherID_Is_Updatable() throws InterruptedException, IOException, ParseException, ClassNotFoundException, SQLException, java.text.ParseException
	{
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject js = (JSONObject) j.get(0);

		CommonMethods.validateResponse(j,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		Thread.sleep(10000);
		js.put(globalVariables.ClientOtherID, CommonMethods.generateUniqueID());
		js.put(globalVariables.SequenceID, CommonMethods.generateUniqueID());

		CommonMethods.validateResponse(j,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));

	}
}
