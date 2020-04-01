package com.sandata.utils;

import com.google.gson.*;
import com.sandata.core.config.Configuration;
import com.sandata.core.config.Environment;
import com.sandata.core.config.ObjectRepository;
import com.sandata.core.config.TestData;
import org.apache.log4j.Logger;
import org.testng.Assert;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Map;

public class JsonUtils {

    private static String defaultFolder = System.getProperty("user.dir");
    private static String testDataFolder = "TestData";
    private static final String JSONEXT = ".json";
    private static final Logger LOGGER = Logger.getLogger(JsonUtils.class);

    Gson gson = new Gson();
    GsonBuilder gsonBuilder;

    public String toJson(boolean includeNullValue, boolean setPrettyPrinting, Object object) {
        gsonBuilder = new GsonBuilder();
        if (includeNullValue) {
            gsonBuilder = gsonBuilder.serializeNulls();
        }
        if (setPrettyPrinting) {
            gsonBuilder = gsonBuilder.setPrettyPrinting();
        }
        if (object != null) {
            gson = gsonBuilder.create();
        }
        return gson.toJson(object);
    }

    public Object toObject(String json, Type typeOfT) {
        gson = new Gson();
        return gson.fromJson(json, typeOfT);
    }

    public static synchronized ObjectRepository loadObjectRepositories() {
        File testcaseFolder = new File(defaultFolder + File.separator + testDataFolder + File.separator + "Locators");
        ObjectRepository repository = new ObjectRepository();
        for (String filePath : testcaseFolder.list()) {
            JsonObject locators = loadJsonFile(testDataFolder + File.separator + "Locators" +
                    File.separator + filePath);
            repository = new ObjectRepository();
            repository.setLocators(locators);
        }
        return repository;
    }

    public static synchronized Configuration loadConfiguration() {
        try {
            String filePath = testDataFolder + File.separator + "Environment.json";
            JsonObject configuration = loadJsonFile(filePath);

            Gson gson = new Gson();
            JsonElement configuration1 = configuration.get("Configuration");
            return gson.fromJson(configuration1, Configuration.class);
        } catch (NullPointerException exp) {
            LOGGER.error(exp.getMessage());
            return null;
        }
    }

    public static synchronized Environment loadEnvironment(String envType, String envID) {
        try {
            String filePath = testDataFolder + File.separator + envType + JSONEXT;
            JsonObject configuration = loadJsonFile(filePath);
            Gson gson = new Gson();
            JsonElement environment1 = configuration.getAsJsonObject("Environment").get(envID);
            if (environment1 == null) {
                LOGGER.error(String.format("There is no definition for ENVID=%s", envID));
                return null;
            } else {
                Environment environment = gson.fromJson(environment1, Environment.class);
                environment.setEnvironments(gson.fromJson(environment1, Map.class));
                return environment;
            }
        } catch (Exception exp) {
            LOGGER.error(String.format("Error on loading environment %s", envID));
            return null;
        }
    }

    public static synchronized TestData loadTestCaseData(String projectName, String testcaseID) {
        String dataJsonPath = "TestData";
        return loadTestCaseData(dataJsonPath, projectName, testcaseID);
    }

    public static synchronized TestData loadTestCaseData(String dataFile, String projectName, String testcaseID) {
        String folderPath = defaultFolder + File.separator + testDataFolder + File.separator + projectName;
        String tcJsonPath = folderPath + File.separator + testcaseID + JSONEXT;
        String dataJsonPath = testDataFolder + File.separator + projectName + File.separator + dataFile + JSONEXT;

        TestData testData = new TestData();

        // Loading Default Variables
        try {
            JsonObject defaultData = loadJsonFile(dataJsonPath);
            testData.setDefaultVariables(defaultData);
            // Loading Test Case Variables
            if (new File(tcJsonPath).exists()) {
                JsonObject data;
                data = loadJsonFile(testcaseID + JSONEXT);
                testData.setVariables(data);
            } else {
                JsonObject data;
                data = loadJsonFile(dataJsonPath).getAsJsonObject(testDataFolder).getAsJsonObject(testcaseID);
                testData.setVariables(data);
            }
        } catch (NullPointerException exp) {
            LOGGER.error("Error: Cannot read TestData file");
        }
        return testData;
    }

    public static synchronized JsonObject loadJsonFile(String filePath) {
        JsonParser parser = new JsonParser();
        JsonObject jsonObject;
        String file = defaultFolder + File.separator + filePath;
        try {
            jsonObject = parser.parse(new FileReader(file)).getAsJsonObject();
        } catch (FileNotFoundException e) {
            logErrorOnLoadingJsonFile(filePath);
            return null;
        }

        return jsonObject;
    }

    public static synchronized JsonElement loadJSonElementFromFile(String filePath) {
        JsonParser parser = new JsonParser();
        String file = defaultFolder + File.separator + filePath;
        try {
            return parser.parse(new FileReader(file));
        } catch (FileNotFoundException e) {
            logErrorOnLoadingJsonFile(filePath);
            return null;
        }
    }

    private static synchronized void logErrorOnLoadingJsonFile(String filePath) {
        LOGGER.error(String.format("Cannot load Json File at %s", filePath));
        Assert.fail(String.format("Cannot load Json File at %s", filePath));
    }
}
