package com.sandata.ws;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.sandata.common.resource.Splunk;
import com.sandata.models.splunk.SearchSummary;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class SplunkWebService extends GenericWebService{
    public Map<String, String> loginCookies;
    Response accessSplunk;
    Response loginResponse;
    Response searchResponse;
    Response searchResult;
    public String sid;

    public Response login(String username, String password) {
        String url = getSplunkEndpoint() + Splunk.LOGIN;
        accessSplunk = sendGETRequest(url);
        String cval = accessSplunk.getCookie("cval");

        Map<String, String> formData = new HashMap<>();
        formData.put("username",username);
        formData.put("password",password);
        formData.put("cval", cval);

        loginResponse = sendPOSTWithFormData(url, formData, accessSplunk.getCookies());
        return loginResponse;
    }

    private String getSplunkEndpoint() {
        return getEnvironment("splunk_endpoint");
    }

    public String getSID(String text) {
        String url = getSplunkEndpoint() + Splunk.SEARCH;
        Map<String, String> headers = new HashMap<>();
        headers.put("X-Splunk-Form-Key", loginResponse.getCookie("splunkweb_csrf_token_8000"));
        headers.put("X-Requested-With", "XMLHttpRequest");

        Map<String, String> formData = new HashMap<>();
        formData.put("rf", "*");
        formData.put("auto_cancel", "30");
        formData.put("status_buckets", "300");
        formData.put("output_mode", "json");
        formData.put("custom.search", text);
        formData.put("search", "search " + text);
        formData.put("earliest_time", "");
        formData.put("latest_time", "");
        formData.put("ui_dispatch_app", "search");
        formData.put("preview", "1");
        formData.put("adhoc_search_level", "smart");
        formData.put("indexedRealtime", "");
        formData.put("sample_ratio", "1");
        formData.put("check_risky_command", "false");
        formData.put("provenance", "UI:Search");

        searchResponse = sendPOSTWithFormData(url, headers, formData, loginResponse.getCookies());
        String response = searchResponse.body().asString();
        JsonObject obj = new Gson().fromJson(response, JsonObject.class);
        sid = obj.get("sid").toString().replaceAll("\"", "");
        logInfo("SID generated after create search job: " + sid);
        return sid;
    }

    public SearchSummary getSearchResult(String sid) {
        String url = getSplunkEndpoint() + String.format(Splunk.SUMMARY, sid);
        logInfo("Search URL with SID: " + url);
        searchResult = sendGETRequest(url, loginResponse.getCookies());

        Gson gson = new Gson();
        SearchSummary searchSummary = gson.fromJson(searchResult.body().asString(), SearchSummary.class);

        return searchSummary;
    }

    public SearchSummary search(String query) {
        login("Splunk", "splunk4splunk");
        String sid = getSID(query);
        return getSearchResult(sid);
    }
}
