package healthCheck;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

public class HealthCheckAssertionVerifier {
	
	public static void dwhExportAssertion(String bodyAsString) throws ParseException{
		
		final String STATUS = "status";  
		final String DETAILS = "details";  
		
		JSONParser parser = new JSONParser(); 
		JSONObject jsonObject = (JSONObject) parser.parse(bodyAsString);
		
		JSONObject JsonObjStatus = (JSONObject) jsonObject.get(STATUS);
		Assert.assertEquals(JsonObjStatus.get("code"), "UP");
		
		JSONObject JsonObjDetails = (JSONObject) jsonObject.get(DETAILS);
		
		JSONObject JsonObjaws = (JSONObject) JsonObjDetails.get("awsS3");
		JSONObject JsonObjawsStatus = (JSONObject) JsonObjaws.get(STATUS);
		Assert.assertEquals(JsonObjawsStatus.get("code"), "UP");
		
		JSONObject JsonObjhS = (JSONObject) JsonObjDetails.get("healthService");
		JSONObject JsonObjhSStatus = (JSONObject) JsonObjhS.get(STATUS);
		Assert.assertEquals(JsonObjhSStatus.get("code"), "UP");
		
		JSONObject JsonObjhSDetails = (JSONObject) JsonObjhS.get(DETAILS);
		Assert.assertEquals(JsonObjhSDetails.get("service-name"), "export-data-warehouse");
		
		JSONObject JsonObjRabbit = (JSONObject) JsonObjDetails.get("rabbit");
		JSONObject JsonObjRabbitStatus = (JSONObject) JsonObjRabbit.get(STATUS);
		Assert.assertEquals(JsonObjRabbitStatus.get("code"), "UP");
		
		JSONObject JsonObjhRabbitDetails = (JSONObject) JsonObjRabbit.get(DETAILS);
		Assert.assertEquals(JsonObjhRabbitDetails.get("version"), "3.7.9");
		
		JSONObject JsonObjRedis = (JSONObject) JsonObjDetails.get("redis");
		JSONObject JsonObjRedisStatus = (JSONObject) JsonObjRedis.get(STATUS);
		Assert.assertEquals(JsonObjRedisStatus.get("code"), "UP");
		
		JSONObject JsonObjRedisDetails = (JSONObject) JsonObjRedis.get(DETAILS);
		Assert.assertEquals(JsonObjRedisDetails.get("version"), "3.2.4");
		
		JSONObject JsonObjDB = (JSONObject) JsonObjDetails.get("db");
		JSONObject JsonObjDBStatus = (JSONObject) JsonObjDB.get(STATUS);
		Assert.assertEquals(JsonObjDBStatus.get("code"), "UP");
		
		JSONObject JsonObjDBDetails = (JSONObject) JsonObjDB.get(DETAILS);
		Assert.assertEquals(JsonObjDBDetails.get("database"), "Oracle");
		Assert.assertEquals(JsonObjDBDetails.get("hello"), "Hello");

		
	}

}
