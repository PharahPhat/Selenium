package com.globalMethods.core;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public class GetStateConfig {
    public static Map<String, String> getStateInfo(String environment, String state) {
        JSONParser parser = new JSONParser();
        String pathConfig = System.getProperty("user.dir") + File.separator + "config" + File.separator + "stateConfig.json";
        Map<String, String> map = new HashMap<>();
        try (Reader reader = new FileReader(pathConfig)) {
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            JSONObject stateJson = (JSONObject) jsonObject.get(state);
            map = (Map<String, String>) stateJson.get(environment);
        } catch (IOException | ParseException e) {
            Assert.fail("Could NOT Find config", e.fillInStackTrace());
        }
        return map;
    }
}
