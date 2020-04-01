package Production;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author MayankM
 */

public class Bug5660_TC95298_AltEVV_Lat_Long_same extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

@Test(groups = {"All"})
public void Bug5660_TC95298_AltEVV_Lat_Long_same_validation() throws InterruptedException, IOException, ParseException, SQLException, java.text.ParseException, ClassNotFoundException
{
	// logger = extent.startTest("Bug5660_TC95298_AltEVV_Lat_Long_same_validation");

	JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
	JSONObject jsonObject = (JSONObject) jsonArray.get(0);
	JSONArray jsonArrAdd = (JSONArray) jsonObject.get("ClientAddress");
	JSONObject jsonObjectAdd = (JSONObject) jsonArrAdd.get(0);

	jsonObjectAdd.put("ClientLatitude",CommonMethods.generateRandomNumberOfFixLength(2));
	jsonObjectAdd.put("ClientLongitude",CommonMethods.generateRandomNumberOfFixLength(2));

	CommonMethods.validateResponse(jsonArray,
			CommonMethods.propertyfileReader(globalVariables.altevv_clients));


	Thread.sleep(5000);
	//Sending request again after updating SequenceID
	
	jsonObject = (JSONObject) jsonArray.get(0);

	jsonObject.put("SequenceID", CommonMethods.generateRandomNumberOfFixLength(16));

	CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));
	}

}
