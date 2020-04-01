package AltEVV_Molina.restassured.sandata.Visit;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

public class SEVV2858_TC96058_AltEVV_Visit_SeqID_greater_PrevSeqID_Scenario2 extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
		public void SEVV2858_TC96058_AltEVV_Visit_SeqID_greater_PrevSeqID_Valid() throws InterruptedException, IOException, ParseException {

		// logger = extent.startTest("SEVV2858_TC96058_AltEVV_Visit_SeqID_greater_PrevSeqID");

		String sequenceid=CommonMethods.generateRandomNumberOfFixLength(6);
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.SequenceIDjson,sequenceid);
		
		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.SequenceIDjson, sequenceid);
		
		CommonMethods.validateResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));

		Thread.sleep(10000);

		int sequenceid2=Integer.parseInt(sequenceid)+1;
		String sequenceidfinal=String.valueOf(sequenceid2);
		jsonObjectVisit.put(globalVariables.SequenceIDjson,sequenceidfinal);
		JSONArray jsonArrayVisitChangesre = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChangesre =  (JSONObject) jsonArrayVisitChangesre.get(0);
		jsonObjectVisitChangesre.put(globalVariables.SequenceIDjson, sequenceid);
		CommonMethods.verifyPostResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit),
				CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit_get));
	}


}
