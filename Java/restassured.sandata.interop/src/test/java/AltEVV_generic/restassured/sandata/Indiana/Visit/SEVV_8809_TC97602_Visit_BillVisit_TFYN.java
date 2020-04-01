/**
 * 
 */
package AltEVV_generic.restassured.sandata.Indiana.Visit;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @author Priyank
 *
 */
public class SEVV_8809_TC97602_Visit_BillVisit_TFYN extends BaseTest{
		
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	
		@Test(groups = {"All"})
		public void SEVV_8809_TC97602_Visit_BillVisit_false() throws InterruptedException, IOException, ParseException
		{
			// logger = extent.startTest("SEVV_8809_TC97602_Visit_BillVisit_false");
			logger.log(LogStatus.INFO, "Validating Value of BillVisit as false");

			JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
			JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
			jsonObjectVisit.put(globalVariables.BillVisitjson,false);
			
			CommonMethods.validateResponse(jsonArrayVisit,
					CommonMethods.propertyfileReader(globalVariables.altevv_visit));
}
		@Test(groups = {"All"})
		public void SEVV_8809_TC97602_Visit_BillVisit_True() throws InterruptedException, IOException, ParseException

		{
			// logger = extent.startTest("SEVV_8809_TC97602_Visit_BillVisit_True");
			logger.log(LogStatus.INFO, "Validating Value of BillVisit as true");
			 

			JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
			JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
			jsonObjectVisit.put(globalVariables.BillVisitjson,true);
			
			CommonMethods.validateResponse(jsonArrayVisit,
					CommonMethods.propertyfileReader(globalVariables.altevv_visit));

}
		@Test(groups = {"All"})
		public void SEVV_8809_TC97602_Visit_BillVisit_Y() throws InterruptedException, IOException, ParseException

		{
			// logger = extent.startTest("SEVV_8809_TC97602_Visit_BillVisit_Y");
			logger.log(LogStatus.INFO, "Validating Value of BillVisit as Y");  
			 

			JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
			JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
			jsonObjectVisit.put(globalVariables.BillVisitjson,"Y");
			
			CommonMethods.validateResponse(jsonArrayVisit,
					CommonMethods.propertyfileReader(globalVariables.altevv_visit));


}
		@Test(groups = {"All"})
		public void SEVV_8809_TC97602_Visit_BillVisit_N() throws InterruptedException, IOException, ParseException

		{
			// logger = extent.startTest("SEVV_8809_TC97602_Visit_BillVisit_N");
			logger.log(LogStatus.INFO, "Validating Value of BillVisit as N");  
			 

			JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
			JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
			jsonObjectVisit.put(globalVariables.BillVisitjson,"N");
			
			CommonMethods.validateResponse(jsonArrayVisit,
					CommonMethods.propertyfileReader(globalVariables.altevv_visit));
		}
}
