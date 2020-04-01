package AltEVV_generic.restassured.sandata.Indiana.Visit;

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

public class SEVV7959_TC100226_AltEVV_Visit_BillHours_using_Call_Provider_validation extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	@Test(groups = {"All"})
	public void TC100226_AltEVV_Visit_BillHours_using_Call_Provider() throws InterruptedException, IOException,
			ParseException, SQLException, ClassNotFoundException, java.text.ParseException{

		// logger = extent.startTest("TC100226_AltEVV_Visit_billhours_using_callprovider");
		double Hourstobill= CommonMethods.getRandomDouble_Two_Decimal(0, 99.99);
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.HoursToBilljson, Hourstobill);
		
		CommonMethods.validateResponse(jsonArrayVisit,
					CommonMethods.propertyfileReader(globalVariables.altevv_visit));
	}
}
