package openevv.PA.Member;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.globalMethods.core.globalVariables.*;


public class R2223_TC94619_OpenEVV_Member_ClientBirthDate extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();


	@DataProvider(name = "dataProvider")
	public static Object[][] dataProvider() {
		return new Object[][]
				{
						{true, "1990-12-31", ""},
						{true, null, ""},
						{true, "", ""},
						{false, "12-31-1990", ClientBirthDateerror},
						{false, "12/31/1990", ClientBirthDateerror},
						{false, "19901213", ClientBirthDateerror},
						{false, "19903112", ClientBirthDateerror},
						{false, "31121990", ClientBirthDateerror},

				};
	}

	@Test(dataProvider = "dataProvider")
	public void R2223_TC94619_OpenEVV_Member_ClientBirthDate (boolean isValid, String value, String errorMessage) throws
			IOException, ParseException{
		JSONArray altEVVJsonArray = GenerateUniqueParam.MemberParams_OpenEVV(openevv_member_json);
		JSONObject jsonobject = (JSONObject) altEVVJsonArray.get(0);
		jsonobject.put(ClientBirthDate,value);


		if (isValid) {
			CommonMethods.validateResponse(altEVVJsonArray, CommonMethods.propertyfileReader(member_post_url));
		}
		else {
			String body = CommonMethods.capturePostResponse(altEVVJsonArray, CommonMethods.propertyfileReader(member_post_url));
			CommonMethods.verifyjsonassertFailcase(body, errorMessage);
		}
	}

}
