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

import static com.globalMethods.core.globalVariables.SequenceID;

//TestCase 91106 OpenEVV-altEVV- Client: Validate If the Sequence ID is equal to a value previously received

public class R2858_TC91106_AltEVV_SequenceID_Duplicate_Or_Lower extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

		@Test(groups = {"All", "fixing"})
		public void R2858_TC91106_AltEVV_SequenceID_Duplicate() throws InterruptedException, IOException, ParseException
		{
			JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
			JSONObject jsonobject = (JSONObject) altEVVJsonArray.get(0);
			String sequenceId =jsonobject.get(SequenceID).toString();

			CommonMethods.validateResponse(altEVVJsonArray,CommonMethods.propertyfileReader(globalVariables.altevv_clients));

			Thread.sleep(30000);

			String bodyAsString = CommonMethods.captureGetResponse(altEVVJsonArray,
					CommonMethods.propertyfileReader(globalVariables.altevv_clients),
					CommonMethods.propertyfileReader(globalVariables.altevv_client_get));
			CommonMethods.verifyErrorMessage(bodyAsString, globalVariables.SequenceIDDuplicateError);

			jsonobject.put(SequenceID, String.valueOf((Long.parseLong(sequenceId)-1)));
			bodyAsString = CommonMethods.captureGetResponse(altEVVJsonArray,
					CommonMethods.propertyfileReader(globalVariables.altevv_clients),
					CommonMethods.propertyfileReader(globalVariables.altevv_client_get));
			CommonMethods.verifyErrorMessage(bodyAsString, globalVariables.SequenceIDDuplicateError);

			jsonobject.put(SequenceID, String.valueOf((Long.parseLong(sequenceId)+1)));
			CommonMethods.verifyPostResponse(altEVVJsonArray,
					CommonMethods.propertyfileReader(globalVariables.altevv_clients),
					CommonMethods.propertyfileReader(globalVariables.altevv_client_get));
		}
	}



