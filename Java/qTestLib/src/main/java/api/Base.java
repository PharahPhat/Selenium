package api;

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.config.SSLConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import static io.restassured.RestAssured.given;

class Base {
    private String accessToken;
    private String tokenType;
    private static final String AUTHORIZATION = "Authorization";
    private static final String CONTENT_TYPE = "Content-Type";

    Base() {
        RestAssured.useRelaxedHTTPSValidation();
    }

    void loginToqTest(String username, String password, String url) {
        URL convertURL = null;
        try {
            convertURL = new URL(url);
        } catch (MalformedURLException e) {
            Assert.fail("FAILED when get URL of QTest Manager", e.fillInStackTrace());
        }
        String siteName = convertURL.getHost() + ":";
        String enBaseCode64 = Base64.getEncoder().encodeToString(siteName.getBytes());
        Response resp = RestAssured.given().config(RestAssured.config().encoderConfig(EncoderConfig.encoderConfig().
                encodeContentTypeAs("x-www-form-urlencoded", ContentType.URLENC))).
                contentType(ContentType.URLENC.withCharset("UTF-8")).
                header(AUTHORIZATION, "Basic " + enBaseCode64).
                formParam("grant_type", "password").
                formParam("username", username).
                formParam("password", password).
                log().all().
                when().post(url).
                then().assertThat().statusCode(200).and().extract().response();

        String bodyAsString = resp.asString();
        JSONObject jsonObject;
        try {
            jsonObject = new JSONObject(bodyAsString);
            Assert.assertNotNull(jsonObject.getString("access_token"));
            Assert.assertNotNull(jsonObject.getString("token_type"));
            setAccessToken(jsonObject.getString("access_token"));
            setTokenType(jsonObject.getString("token_type"));
        } catch (JSONException e) {
            Assert.fail("FAILED when Create Access Token on QTest", e.fillInStackTrace());
        }
    }

    private String getAccessToken() {
        return accessToken;
    }

    private void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    private String getTokenType() {
        return tokenType;
    }

    private void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    String getResponse(String url) {
        Response getResp = given().config(RestAssured.config().sslConfig(
                new SSLConfig().relaxedHTTPSValidation())).header(CONTENT_TYPE,ContentType.JSON).
                contentType(ContentType.JSON).
                header(AUTHORIZATION, getTokenType() + " " + getAccessToken()).log().all().
                when().get(url).
                then().assertThat().statusCode(200).and().extract().response();

        return getResp.asString();
    }

    String getResponseIgnoreStatus(String url) {
        Response getResp = given().config(RestAssured.config().sslConfig(
                new SSLConfig().relaxedHTTPSValidation())).header(CONTENT_TYPE,ContentType.JSON).
                contentType(ContentType.JSON).
                header(AUTHORIZATION, getTokenType() + " " + getAccessToken()).log().all().
                when().get(url).
                then().assertThat().and().extract().response();

        return getResp.asString();
    }

    String postResponse(String url, String body) {
        Response getResp = given().config(RestAssured.config().sslConfig(
                new SSLConfig().relaxedHTTPSValidation())).header(CONTENT_TYPE,ContentType.JSON).
                contentType(ContentType.JSON).
                header(AUTHORIZATION, getTokenType() + " " + getAccessToken()).log().all().
                body(body).
                when().post(url).
                then().assertThat().and().extract().response();

        return getResp.asString();
    }

    String putResponse(String url, String body) {
        Response getResp = given().config(RestAssured.config().sslConfig(
                new SSLConfig().relaxedHTTPSValidation())).header(CONTENT_TYPE,ContentType.JSON).
                contentType(ContentType.JSON).
                header(AUTHORIZATION, getTokenType() + " " + getAccessToken()).log().all().
                body(body).
                when().put(url).
                then().assertThat().statusCode(200).and().extract().response();

        return getResp.asString();
    }

    String getId(String json, String name) {
        JSONArray jsonArray;
        String id;
        try {
            jsonArray = new JSONArray(json);
            Assert.assertNotNull(jsonArray);
            for (int i=0;i<jsonArray.length();i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String name1 = jsonObject.getString("name");
                if (name1.equalsIgnoreCase(name)) {
                    id = jsonObject.getString("id");
                    return id;
                }
            }
        } catch (JSONException e) {
            Assert.fail("Get Id failed with name: " + name, e.fillInStackTrace());
        }
        return null;
    }

    List<String> getListId(String json) {
        JSONArray jsonArray;
        List<String> list = new ArrayList<>();
        try {
            jsonArray = new JSONArray(json);
            for (int i=0;i<jsonArray.length();i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                list.add(jsonObject.getString("id"));
            }
        } catch (JSONException e) {
            Assert.fail("Get ID ERROR" + json);
        }
        Assert.assertFalse(list.isEmpty());
        return list;
    }

    String getId(String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            return jsonObject.getString("id");
        } catch (JSONException e) {
            Assert.fail("Get ID ERROR" + json);
        }
        Assert.fail("Get ID ERROR" + json);
        return null;
    }

    List<String> getValues(String json, String fieldName) {
        JSONArray jsonArray;
        List<String> list = new ArrayList<>();
        try {
            jsonArray = new JSONArray(json);
            Assert.assertNotNull(jsonArray);
            for (int i=0;i<jsonArray.length();i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                list.add(jsonObject.getString(fieldName));
            }
        } catch (JSONException e) {
            Assert.fail("Get Values from " + fieldName + " ERROR" + json, e.fillInStackTrace());
        }
        Assert.assertFalse(list.isEmpty());
        return list;
    }
}
