package AltEVV_generic.restassured.sandata.Indiana.Employee;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.globalMethods.core.globalVariables.SequenceID;

/**
 * @author RRohiteshwar
 */
//Test Case 91511:Open EVV -Alt EVV - Worker -SequenceID - Prior Values, previously received-With Same or Different Data Set

public class R2267_TC91511_AltEVV_Emp_SequenceID_Duplicate_Or_Lower extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	//Validating valid employee SequenceID_json_DB_Positive_case lower sequence id and greater sequence id
	@Test(groups = {"All", "fixing"})
	public void R2267_TC91511_AltEVV_Emp_SequenceID() throws InterruptedException, IOException, ParseException
	{
		JSONArray altEVVJsonArray = GenerateUniqueParam.EmpParams_AltEVV(globalVariables.Staff_intake);
		JSONObject jsonobject = (JSONObject) altEVVJsonArray.get(0);
		String sequenceId =jsonobject.get(SequenceID).toString();

		CommonMethods.validateResponse(altEVVJsonArray,CommonMethods.propertyfileReader(globalVariables.altevv_emp));

		Thread.sleep(30000);

		String bodyAsString = CommonMethods.captureGetResponse(altEVVJsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_emp),
				CommonMethods.propertyfileReader(globalVariables.altevv_emp_get));
		CommonMethods.verifyErrorMessage(bodyAsString, globalVariables.SequenceIDDuplicateError);

		jsonobject.put(SequenceID, String.valueOf((Long.parseLong(sequenceId)-1)));
		bodyAsString = CommonMethods.captureGetResponse(altEVVJsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_emp),
				CommonMethods.propertyfileReader(globalVariables.altevv_emp_get));
		CommonMethods.verifyErrorMessage(bodyAsString, globalVariables.SequenceIDDuplicateError);

		jsonobject.put(SequenceID, String.valueOf((Long.parseLong(sequenceId)+1)));
		CommonMethods.verifyPostResponse(altEVVJsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_emp),
				CommonMethods.propertyfileReader(globalVariables.altevv_emp_get));
	}

}