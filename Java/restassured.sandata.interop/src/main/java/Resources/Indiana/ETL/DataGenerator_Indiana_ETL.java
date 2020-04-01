package Resources.Indiana.ETL;

import static io.restassured.RestAssured.given;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;
import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.response.Response;

public class DataGenerator_Indiana_ETL extends BaseTest{
	
	public Map<String, JSONObject> processIndiana_ETL() throws FileNotFoundException, ClassNotFoundException, InterruptedException, IOException, ParseException, SQLException, java.text.ParseException
	{
		Map<String, JSONObject> retunObject=new HashMap<String, JSONObject>();

		Map<String, Integer> timeUTC = CommonMethods.generateUTCTime_HH_MM();
		
		JSONArray jsonArray= CommonMethods.LoadJSON_Indiana(globalVariables.indiana_Etl);
	
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put(globalVariables.scheduleUTCTime, "0+"+timeUTC.get("Minute")+"+"+timeUTC.get("Hour")+"+?+*+*");

		JSONParser parser = new JSONParser();

		JSONObject bodyAsStringget = (JSONObject) parser.parse(captureResponsePostIndianaConfig(jsonArray));

		retunObject.put( "bodyAsStringget", bodyAsStringget);
		retunObject .put("jsonObject", jsonObject);	

		return  retunObject;

	}
	
	public String captureResponsePostIndianaConfig(JSONArray JsonArray) throws InterruptedException, java.text.ParseException, ParseException{

		logger.log(LogStatus.INFO, "request body generated is " +JsonArray.toJSONString()); 

		RestAssured.useRelaxedHTTPSValidation();

		Response resp = RestAssured.given().body(JsonArray.toJSONString()).config(RestAssured.config().sslConfig(
				new SSLConfig().relaxedHTTPSValidation())).header("Content-Type","application/json").
				auth().preemptive().
				basic(CommonMethods.propertyfileReader("Indiana_etl_user"),CommonMethods.propertyfileReader("Indiana_etl_pass")).log().all().
				when().post(CommonMethods.propertyfileReader("Indiana_config_post_url")).
				then().assertThat().statusCode(200).and().extract().response();

		String bodyAsString = resp.asString();
		System.out.println("Response Body is: " + bodyAsString);

		logger.log(LogStatus.INFO, "response body extracted is " +bodyAsString);
		String bodyAsStringGet=captureResponseGetIndianaSchedule(bodyAsString);
		return bodyAsStringGet;

	}
	
	public String captureResponseGetIndianaSchedule(String bodyAsString) throws InterruptedException, java.text.ParseException, ParseException{
		
		JSONParser jsonParser=new JSONParser();
		JSONObject object=(JSONObject) jsonParser.parse(bodyAsString);
		
		JSONArray jsonArr = (JSONArray) object.get("data");
		JSONObject jsonObj = (JSONObject) jsonArr.get(0);
		
		String UID = jsonObj.get("accountInterfaceConfigurationSK").toString();
		System.out.println("UID" + " " + UID);
		
		RestAssured.useRelaxedHTTPSValidation();

		Response getResp = given().config(RestAssured.config().sslConfig(
				new SSLConfig().relaxedHTTPSValidation())).header("Content-Type","application/json").
				auth().preemptive().
				basic(CommonMethods.propertyfileReader("Indiana_etl_user"),CommonMethods.propertyfileReader("Indiana_etl_pass")).
				when().get(CommonMethods.propertyfileReader("Indiana_schedule_get_url")+  '/' + UID).
				then().assertThat().statusCode(200).and().extract().response();

		System.out.println(CommonMethods.propertyfileReader("Indiana_schedule_get_url")+  '/' +UID);
		String getresponse = getResp.asString();
		System.out.println("Response Body is: " + getresponse);
		return getresponse;

	}

}
