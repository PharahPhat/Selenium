/**
 * 
 */
package AltEVV_generic.restassured.sandata.Indiana.Visit;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Anupam
 */

public class R2267_TC91393_AltEVV_Visit_Required_fields_All_Segment extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	//Case1:visit-Load Json with required fields Only (All Segments), Record should be created
	@Test(groups = {"All"})
	public void R2267_TC91393_AltEVV_VisitCreation_LoadJson_with_required_fields() throws InterruptedException, IOException, ParseException, SQLException, java.text.ParseException, ClassNotFoundException{
		// logger = extent.startTest("R2267_TC91393_AltEVV_VisitCreation_LoadJson_with_required_fields");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();


		CommonMethods.validateResponse(jsonArrayVisit,
					CommonMethods.propertyfileReader(globalVariables.altevv_visit));
	}
}
