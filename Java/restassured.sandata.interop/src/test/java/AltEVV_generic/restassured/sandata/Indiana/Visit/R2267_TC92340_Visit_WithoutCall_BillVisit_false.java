/**
 * 
 */
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

/**
 * @author Neeraj
 */

public class R2267_TC92340_Visit_WithoutCall_BillVisit_false extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	
	//To validate Visit_AdjustOut_greater_than_CallIn_Otherwise_record_rejected
	
		@Test(groups = {"All"})
		public void R2267_TC92340_Visit_WithoutCall_BillVisit_false_valid() throws InterruptedException, IOException,
				ParseException, SQLException, ClassNotFoundException, java.text.ParseException
		{
			JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
			JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

			jsonObjectVisit.put(globalVariables.BillVisitjson,false);
			jsonObjectVisit.remove("Calls");
			
			CommonMethods.validateResponse(jsonArrayVisit,
					CommonMethods.propertyfileReader(globalVariables.altevv_visit));

		}
}
