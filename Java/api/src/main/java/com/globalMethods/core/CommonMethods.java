package com.globalMethods.core;

import Utills_ExtentReport_Log4j.BaseTest;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.relevantcodes.extentreports.LogStatus;
import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static com.globalMethods.core.globalVariables.*;
import static io.restassured.RestAssured.given;

public class CommonMethods extends BaseTest {
    public static Map<String, String> parameters;
    public static String[] RandomProviderQualifier = {"Other", "Taxonomy"};
    public static String[] AuthWeekStart = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
    public static String[] Authaccounttype = {"H", "V", "U", "M"};
    public static String[] Payerprogramlist = {"OHC", "DD", "SP", "SPHH", "MyC", "PP"};
    public static String[] ProcedureCodelist = {"G0156", "G0299", "G0300", "HPC", "S5125", "T1000", "T1001", "T1002", "T1003", "T1019"};
    public static String[] Payerlist = {"Aetna", "Buckeye", "CareSource", "DODD", "Molina", "ODA", "ODM", "Paramount", "UHC"};
    public static File file;
    public static Connection connection;
    private static String userDir = "user.dir";
    private static boolean isEntityGuid = System.getProperty("entity.enable") != null && System.getProperty("entity.enable").equalsIgnoreCase("true");

    public static boolean isEntityGuid() {
        return isEntityGuid;
    }

    public static void setEntityGuid(boolean entityGuid) {
        isEntityGuid = entityGuid;
    }

    public static float subDateTimeReturnMillisecond(String outtime, String Intime) throws java.text.ParseException {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd'T'HH:mm:ss");
        Date dateIn = format.parse(Intime);
        Date dateOut = format.parse(outtime);

        Calendar calendarOut = Calendar.getInstance();
        calendarOut.setTime(dateOut);
        Calendar calendarIn = Calendar.getInstance();
        calendarIn.setTime(dateIn);

        int HoursToBillsecondOut = calendarOut.get(Calendar.SECOND);

        int HoursToBillsecondsIn = calendarIn.get(Calendar.SECOND);
        int SecondFDiff = HoursToBillsecondOut - HoursToBillsecondsIn;


        float HoursToBill = dateOut.getTime() - dateIn.getTime();


        return ((HoursToBill) - SecondFDiff / 1000);
    }

    public static String AuthWeekStartType() {
        String Authweekstarttype = AuthWeekStart[CommonMethods.getRandomInt(0, (AuthWeekStart.length) - 1)];
        return Authweekstarttype;

    }

    public static String Authaccounttype_array() {
        String Authaccounttypevalue = Authaccounttype[CommonMethods.getRandomInt(0, (Authaccounttype.length) - 1)];
        return Authaccounttypevalue;

    }

    public static String lastCharDelete(String str, int len) {
        if (str != null && str.length() > len) {
            str = str.substring(0, len - 1);
        }
        return str;
    }

    public static String generatepayerprogram() {
        String Payerprogram = Payerprogramlist[CommonMethods.getRandomInt(0, (Payerprogramlist.length) - 1)];
        return Payerprogram;
    }

    public static String generateProcedurecode() {
        String Payerprogram = ProcedureCodelist[CommonMethods.getRandomInt(0, (ProcedureCodelist.length) - 1)];
        return Payerprogram;
    }

    public static String generatepayer() {
        String Payerprogram = Payerlist[CommonMethods.getRandomInt(0, (Payerlist.length) - 1)];
        return Payerprogram;
    }

    public static String AuthAccountType(String authaccounttypevalue) {
        return authaccounttypevalue;

    }

    public static Connection CreateConnection() throws InterruptedException, ClassNotFoundException, SQLException {


        if (connection == null) {
            System.out.println("Connection");
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                connection = DriverManager.getConnection(CommonMethods.propertyfileReader("DbConnectionurl"), CommonMethods.propertyfileReader("db_username"), CommonMethods.propertyfileReader("db_password"));
            } catch (ClassNotFoundException | SQLException e) {
                // Java 7+
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static JSONObject subarrayAssertionVerifier(JSONObject jsonobject_map, String jsonSubArray) {
        JSONArray jsonArrayProg = (JSONArray) jsonobject_map.get(jsonSubArray);
        JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);

        return jsonObjectProg;
    }


    public static void ZipadditionfourZero(JSONObject jsonobject_map, String jsonObject) {
        String ClientContactZip = jsonobject_map.get(jsonObject).toString();
        int zipCount = jsonobject_map.get(jsonObject).toString().length();

        if (zipCount == 5) {
            jsonobject_map.put(jsonObject, ClientContactZip + "0000");
        } else {
            System.out.println(ClientContactZip.replace("-", ""));
            jsonobject_map.put(jsonObject, ClientContactZip.replace("-", ""));
        }

    }
    // ******************************************* File Reader ************************************//


    public static String propertyfileReader(String propertyname) {
        //String environment ="QA";
        //String environment ="DEV";
        String pathConfig = System.getProperty(userDir) + File.separator + "config";

        switch (environment) {
            case "DEV":
                file = new File(pathConfig + File.separator + "configDEV.properties");
                break;

            case "QA":
                file = new File(pathConfig + File.separator + "configQA.properties");
                break;

            case "PROD":
                file = new File(pathConfig + File.separator + "ConfigPRO.properties");
                break;

            case "CO_DEV":
                file = new File(pathConfig + File.separator + "configCO_DEV.properties");
                break;

            default:
                file = new File(pathConfig + File.separator + "configQA.properties");
                break;
        }

        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Properties prop = new Properties();

        // load properties file
        try {
            prop.load(fileInput);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty(propertyname);
    }

    public static void writePropertiesFile(String key, String value, String key1, String value1) {
        Properties prop = new Properties();
        OutputStream output = null;

        try {

            output = new FileOutputStream("claimFiles.properties");
            prop.setProperty(key, value);
            prop.setProperty(key1, value1);
            // save properties to project root folder
            prop.store(output, null);

        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    public static void writeProviderPropertiesFile(String key, String value, String key1, String value1, String key2, String value2) {
        Properties prop = new Properties();
        OutputStream output = null;

        try {


            prop.setProperty(key, value);
            prop.setProperty(key1, value1);
            prop.setProperty(key2, value2);
            // save properties to project root folder
            output = new FileOutputStream("claimFiles.properties");
            prop.store(output, "jmeter file");

        } catch (IOException io) {
            io.printStackTrace();
        }

    }

    // ******************************************* Load JSON ************************************//
    public static List readCSVFile(String filePath) {
        List<String> rowdata = new ArrayList<String>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String row;


            while ((row = reader.readLine()) != null) {
                rowdata.add(row.split(",")[0]);
            }
        } catch (Exception e) {

        }

        return rowdata;
    }

    public static List<String> getFileNameInFolder(String folderPath) {
        File folder = new File(folderPath);
        File[] listOfFiles = folder.listFiles();
        List<String> fileNames = new ArrayList<String>();
        for (File file : listOfFiles) {
            if (file.isFile()) {
                fileNames.add(file.getName());
            }
        }
        return fileNames;
    }

    public static JSONArray LoadVisitJSON(String jsonnamevisit) throws IOException, ParseException {
        return CommonMethods.LoadJSON_AltEVV(jsonnamevisit);
    }

    public static JSONArray LoadVisitJSON_3P(String jsonnamevisit) throws IOException, ParseException {

        JSONArray jsonArr = CommonMethods.LoadJSON_ThreeP(jsonnamevisit);

        @SuppressWarnings("unused")
        JSONObject jsonObject = (JSONObject) jsonArr.get(0);

        return jsonArr;

    }

    public static JSONArray LoadJSON_OpenEVV(String jsonname) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONArray jsonarr;

        jsonarr = (JSONArray) parser.parse(new FileReader(System.getProperty(userDir) + File.separator + "src" + File.separator + "main" + File.separator
                + "java" + File.separator + "Resources" + File.separator + "OpenEVV" + File.separator + jsonname + ".json"));

        return jsonarr;

    }

    public static JSONArray Schedule_OpenEVV(String jsonname) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONArray jsonarr = null;

        jsonarr = (JSONArray) parser.parse(new FileReader(System.getProperty(userDir) + File.separator + "src" + File.separator + "main" + File.separator
                + "java" + File.separator + "Resources" + File.separator + "OpenEVV" + File.separator + jsonname + ".json"));

        return jsonarr;

    }

    public static JSONArray LoadJSON_AltEVV(String jsonname) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONArray jsonarr;

        jsonarr = (JSONArray) parser.parse(new FileReader(System.getProperty(userDir) + File.separator + "src" + File.separator + "main" + File.separator
                + "java" + File.separator + "Resources" + File.separator + "AltEVV_Generic" + File.separator + jsonname + ".json"));

        return jsonarr;
    }

    public static JSONArray LoadJSON_ThreeP(String jsonname) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONArray jsonarr = null;

        jsonarr = (JSONArray) parser.parse(new FileReader(System.getProperty(userDir) + File.separator + "src" + File.separator + "main" + File.separator
                + "java" + File.separator + "Resources" + File.separator + "ThreeP" + File.separator + jsonname + ".json"));

        return jsonarr;

    }

    public static JSONArray LoadJSON_auth(String jsonname) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONArray jsonarr = null;

        jsonarr = (JSONArray) parser.parse(new FileReader(System.getProperty(userDir) + File.separator + "src" + File.separator + "main" + File.separator
                + "java" + File.separator + "Resources" + File.separator + "ThreeP" + File.separator + jsonname + ".json"));

        return jsonarr;

    }

    public static JSONArray LoadJSON_AltEVV_Ohio(String jsonname) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONArray jsonarr;

        jsonarr = (JSONArray) parser.parse(new FileReader(System.getProperty(userDir) + File.separator + "src" + File.separator + "main" + File.separator
                + "java" + File.separator + "Resources" + File.separator + "AltEVV_Ohio" + File.separator + jsonname + ".json"));

        return jsonarr;
    }

    public static JSONArray LoadJSON_AltEVV_Colorado(String jsonname) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONArray jsonarr;

        jsonarr = (JSONArray) parser.parse(new FileReader(System.getProperty(userDir) + File.separator + "src" + File.separator + "main" + File.separator
                + "java" + File.separator + "Resources" + File.separator + "AltEVV_Colorado" + File.separator + jsonname + ".json"));

        return jsonarr;
    }

    public static JSONArray LoadJSON_AltEVV_PA(String jsonname) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONArray jsonarr;

        jsonarr = (JSONArray) parser.parse(new FileReader(System.getProperty(userDir) + File.separator + "src" + File.separator + "main" + File.separator
                + "java" + File.separator + "Resources" + File.separator + "AltEVV_PA" + File.separator + jsonname + ".json"));

        return jsonarr;
    }

    public static JSONArray LoadJSON_Ohio(String jsonname) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONArray jsonarr = null;

        jsonarr = (JSONArray) parser.parse(new FileReader(System.getProperty(userDir) + File.separator + "src" + File.separator + "main" + File.separator
                + "java" + File.separator + "Resources" + File.separator + "Ohio" + File.separator + jsonname + ".json"));
        return jsonarr;

    }

    public static JSONArray LoadJSON_AltEVV_Molina(String jsonname) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONArray jsonarr = null;

        jsonarr = (JSONArray) parser.parse(new FileReader(System.getProperty(userDir) + File.separator + "src" + File.separator + "main" + File.separator
                + "java" + File.separator + "Resources" + File.separator + "AltEVV_Molina" + File.separator + jsonname + ".json"));
        return jsonarr;

    }

    public static JSONArray LoadJSON_Indiana(String jsonname) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONArray jsonarr = null;

        jsonarr = (JSONArray) parser.parse(new FileReader(System.getProperty(userDir) + File.separator + "src" + File.separator + "main" + File.separator
                + "java" + File.separator + "Resources" + File.separator + "Indiana" + File.separator + "ETL" + File.separator + jsonname + ".json"));
        return jsonarr;

    }

    public static String getSaltString(int max) {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < max) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }

    // ******************************************* Common Method ************************************//

    public static long getRandomLong(long min, long max) {

        try {
            Random random = new Random();

            long result = min + (long) (random.nextDouble() * (max - min));
            return result;
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return 0L;
    }

    public static int getRandomInt(int min, int max) {
        try {
            int result = min + (int) (Math.random() * max);
            return result;
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return 0;
    }

    public static String jsonObject(int digCount) {
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(digCount);
        for (int i = 0; i < digCount; i++)
            sb.append((char) ('1' + rnd.nextInt(8)));
        return sb.toString();
    }

    public static String generateRandomAlphaNumeric(int count) {
        return RandomStringUtils.randomAlphanumeric(count);
    }

    public static String generateRandomStringOfFixLength(int diCount) {
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < diCount; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        String RandomString = sb.toString();
        return RandomString;

    }

    public static String generateRandomNumberOfFixLength(int digCount) {
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(digCount);
        for (int i = 0; i < digCount; i++)
            sb.append((char) ('1' + rnd.nextInt(8)));
        return sb.toString();
    }

    public static int generateunitclaim(int billhours) {
        int units = billhours / 15;
        return units;
    }

    public static String generateSpecialChar(int i) {
        String characters = "~`!@#$%^&*()_=+[{]}\\|;:'\",<.>/?";
        String spclChar = RandomStringUtils.random(i, characters);
        return spclChar;
    }

    public static String DateGenerator(String pattern) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    public static double getRandomDoubleBetweenRange(double min, double max) {
        double x = (Math.random() * ((max - min) + 1)) + min;
        x = Double.parseDouble(new DecimalFormat("#.##").format(x));
        return x;
    }

    public static double getRandomDouble_Two_Decimal(double min, double max) {
        double x = (Math.random() * ((max - min) + 1)) + min;
        x = Double.parseDouble(new DecimalFormat("##.##").format(x));
        return x;
    }

    public static List<String> getMemberErrorMessageForMissingRequiredField() {
        List<String> Errormessage = new ArrayList<String>();
        Errormessage.add(globalVariables.memberActionNullError);
        Errormessage.add(globalVariables.memberClientCityNullError);
        Errormessage.add(globalVariables.memberClientEligibilityDateBeginNullError);
        Errormessage.add(globalVariables.memberClientStateNullError);
        Errormessage.add(globalVariables.memberClientZipNullError);
        Errormessage.add(globalVariables.memberClientCustomIDNullError);
//		Errormessage.add(globalVariables.memberClientOtherIDNullError);
        Errormessage.add(globalVariables.memberClientSSNNullError);
        Errormessage.add(globalVariables.memberClientFirstNameNullError);
        Errormessage.add(globalVariables.memberClientLastNameNullError);
        Errormessage.add(globalVariables.memberClientEligibilityDateBeginFormatError);
        return Errormessage;
    }

    public static List<String> getOhioRequiredFieldErrorMessage() {
        List<String> Errormessage = new ArrayList<String>();
        Errormessage.add("The ClientPayerInformation cannot not be empty");
        Errormessage.add("The ClientLastName cannot be null.");
        Errormessage.add("The ClientTimeZone value is invalid.");
        Errormessage.add("The Provider cannot be null.");
        Errormessage.add("The ClientIdentifier cannot be null.");
        Errormessage.add("The ClientAddress value is incorrect.");
        Errormessage.add("The ClientFirstName cannot be null");
        return Errormessage;

    }

    public static List<String> getAuthErrorMessageForMissingRequiredField() {
        List<String> Errormessage = new ArrayList<String>();
        Errormessage.add(globalVariables.AuthorizationReferenceNumbenullrerror);
        Errormessage.add(globalVariables.PayerIDnullError);
        Errormessage.add(globalVariables.payerprogramerror_altevv);
        Errormessage.add(globalVariables.provideridformatnullerror);
        Errormessage.add(globalVariables.ClientQualifierNullError);
        Errormessage.add(globalVariables.AuthAuthorizationAmountTypeNullError);
        Errormessage.add(globalVariables.ProviderQualifierNull_Error);
        Errormessage.add(globalVariables.AuthorizationlimittypeerrorNull);
        Errormessage.add(globalVariables.AuthorizationStartDateformateerrornull);
        Errormessage.add(globalVariables.AuthorizationStatusnullerror);

        return Errormessage;
    }

    public static List<String> getjsonMemberErrorMessageForMissingRequiredField() {
        List<String> Errormessage = new ArrayList<String>();
        Errormessage.add(globalVariables.memberClientLastNameNullError);
        Errormessage.add(globalVariables.memberClientSSNNullError);
        Errormessage.add(globalVariables.memberClientZipNullError);
        Errormessage.add(globalVariables.memberClientFirstNameNullError);
        Errormessage.add(globalVariables.memberClientCustomIDNullError);
        return Errormessage;
    }

    @SuppressWarnings("unchecked")
    public static void putNullValuesInOptionalFieldsInProvider(JSONObject jsonObject) {

        jsonObject.put("County", null);
        jsonObject.put("AddressLine2", null);
        jsonObject.put("ProviderDoingBusinessAs", null);
        jsonObject.put("ProviderFax", null);
        jsonObject.put("ProviderNPI", null);
        jsonObject.put("ProviderAPI", null);
        jsonObject.put("TaxID", null);
        jsonObject.put("ProviderTaxonomy", null);
        jsonObject.put("SuspensionDate", null);
        jsonObject.put("TerminationDate", null);
        jsonObject.put("ProviderRequireAuth", null);
        jsonObject.put("ProviderDateBegin", null);
    }

    @SuppressWarnings("unchecked")
    public static void putValidValuesInOptionalFieldsInProvider(JSONObject jsonObject) {

        jsonObject.put("County", CommonMethods.generateRandomStringOfFixLength(30));
        jsonObject.put("AddressLine2", CommonMethods.generateRandomStringOfFixLength(50));
        jsonObject.put("ProviderDoingBusinessAs", CommonMethods.generateRandomStringOfFixLength(50));
        jsonObject.put("ProviderFax", CommonMethods.generateRandomNumberOfFixLength(10));
        jsonObject.put("ProviderNPI", CommonMethods.generateRandomNumberOfFixLength(10));
        jsonObject.put("ProviderAPI", CommonMethods.generateRandomNumberOfFixLength(10));
        jsonObject.put("TaxID", "00" + CommonMethods.generateRandomNumberOfFixLength(7));
        jsonObject.put("ProviderTaxonomy", CommonMethods.generateRandomNumberOfFixLength(9));
        jsonObject.put("SuspensionDate", CommonMethods.genFutureDate_YYYY_MM_dd(350));
        jsonObject.put("TerminationDate", CommonMethods.genFutureDate_YYYY_MM_dd(360));
        jsonObject.put("ProviderRequireAuth", 0);
        jsonObject.put("ProviderDateBegin", CommonMethods.generatecurrentDate_YYYY_MM_dd());
    }

    public static String dateToDateTimeFormat(String dateToFormat) throws InterruptedException, ParseException, java.text.ParseException {
        try {
            Date dateConverted = new SimpleDateFormat("MMddyyyy").parse(dateToFormat);
            String pattern = "yyyy-MM-dd HH:mm:ss";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String dt = simpleDateFormat.format(dateConverted);
            return (dt);
//db verification fails due to dt+".0"), removed
        } catch (Exception e) {
            return null;
        }

    }

    public static String dateToDateTimeFormatyyyy_mm_dd(String dateToFormat) throws InterruptedException, ParseException, java.text.ParseException {
        try {
            Date dateConverted = new SimpleDateFormat("yyyy-MM-dd").parse(dateToFormat);
            String pattern = "yyyy-MM-dd HH:mm:ss";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String dt = simpleDateFormat.format(dateConverted);
            return (dt);

        } catch (Exception e) {
            return null;
        }

    }

    public static String dateToDateTimeFormat_z(String object) throws InterruptedException, ParseException, java.text.ParseException {
        try {
            Date dateConverted = new SimpleDateFormat("YYYY-MM-DDThh:mm:ssZ").parse(object);
            String pattern = "yyyy-MM-dd HH:mm:ss";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String dt = simpleDateFormat.format(dateConverted);
            return (dt);

        } catch (Exception e) {
            return null;
        }

    }

    public static String getPastDateTime(int day) {
        return ZonedDateTime.now(ZoneId.of("America/New_York")).minusDays(day).format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'"));
    }

    public static String getPastTime(int minutes) {
        return ZonedDateTime.now(ZoneId.of("America/New_York")).minusMinutes(minutes).format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'"));
    }

    public static String getCurrentTime() {
        return ZonedDateTime.now(ZoneId.of("America/New_York")).format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'"));
    }

    public static String getPastZoneDateTime(String zoneDateTime, int day) {
        return ZonedDateTime.parse(zoneDateTime).minusDays(day).format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'"));
    }

    public static String getFutureDateTime(int day) {
        return ZonedDateTime.now(ZoneId.of("America/New_York")).plusDays(day).format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'"));
    }

    public static String dateToDateTimeFormat_yyyy_mm_dd(String dateToFormat) throws InterruptedException, ParseException, java.text.ParseException {

        Date dateConverted = new SimpleDateFormat("yyyy-MM-dd").parse(dateToFormat);

        String pattern = "yyyy-MM-dd HH:mm:ss.S";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String dt = simpleDateFormat.format(dateConverted);
        return (dt);
    }

    public static String generateEmailAddress_string(int i) {
        String domain = "@mailinator.com";
        String ClientEmailAddress = CommonMethods.generateRandomStringOfFixLength(i);
        return ClientEmailAddress.concat(domain);
    }

    public static String generateEmailAddress_alpha(int i) {
        String domain = "@mailinator.com";
        String ClientDesigneeEmail = CommonMethods.generateRandomAlphaNumeric(i);
        return ClientDesigneeEmail.concat(domain);
    }

    public static String generateEmailAddress_num(int i) {
        String domain = "@mailinator.com";
        String ClientEmailAddress = CommonMethods.generateRandomNumberOfFixLength(i);
        return ClientEmailAddress.concat(domain);
    }

    public static String generateTodayDate_YYYY_MM_dd() {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String empenddate = dateFormat.format(date);
        return empenddate;
    }

    public static String generateTodayDate_MMddyyyy() {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
        String empenddate = dateFormat.format(date);
        return empenddate;
    }

    public static String generateFutureDate_YYYY_MM_dd() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date tomorrow = calendar.getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String empfuturedate = dateFormat.format(tomorrow);
        return empfuturedate;
    }

    public static String genFutureDate_YYYY_MM_dd(int noOfDays) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, noOfDays);
        Date tomorrow = calendar.getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String empfuturedate = dateFormat.format(tomorrow);
        return empfuturedate;
    }

    public static String generatecurrentDate_YYYY_MM_dd() {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String empfuturedate = dateFormat.format(date);
        return empfuturedate;
    }

    public static String generatecurrentDate_YYYYMMdd() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String strDate = formatter.format(date);
        System.out.println("Date Format with dd MMMM yyyy : " + strDate);
        return strDate;
    }

    public static String generatecurrentTime_HHMMSS() {
        SimpleDateFormat sdfTime = new SimpleDateFormat("HHmmss");
        Date now = new Date();
        String strTime = sdfTime.format(now);
        System.out.println("Time: " + strTime);
        return strTime;
    }

    public static String generateFutureDate_YYYY_MM_dd_Time() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date tomorrow = calendar.getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh.mm.ss aa");
        String empfuturedate = dateFormat.format(tomorrow);
        return empfuturedate;
    }

    public static Map<String, Integer> generateUTCTime_HH_MM() {

        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        cal.add(Calendar.MINUTE, 2);
        Map<String, Integer> timeMap = new HashMap<String, Integer>();
        timeMap.put("Hour", cal.get(Calendar.HOUR_OF_DAY));
        timeMap.put("Minute", cal.get(Calendar.MINUTE));

        System.out.println("Hour: " + cal.get(Calendar.HOUR_OF_DAY) + " Minute: " + cal.get(Calendar.MINUTE));
        return timeMap;
    }

    public static String generatecurrentDate_YYYY_MM_dd_Time() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh.mm.ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone("EST"));
        String time1 = dateFormat.format(date);
        return time1;
    }

    public static String generatecurrentDate_YYYY_MM_dd_Time1() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone("EST"));
        String time1 = dateFormat.format(date);
        return time1;
    }

    public static String getTimeStampYYMMDDHHMMSS() {

        return generatecurrentDate_YYYYMMdd() + "." + generatecurrentTime_HHMMSS();
    }

    public static String getTimeStampPastYYMMDDHHMMSS() {

        return generatePastDate_MMddYYYY() + "." + generatecurrentTime_HHMMSS();
    }

    public static String generateFutureDate_MMddyyyy() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date tomorrow = calendar.getTime();
        DateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
        String empfuturedate = dateFormat.format(tomorrow);
        return empfuturedate;
    }

    public static String generateFutureDate_MM_DD_YYYY() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date tomorrow = calendar.getTime();
        DateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
        String empfuturedate = dateFormat.format(tomorrow);
        return empfuturedate;
    }

    public static String generatePastDate_YYYY_MM_dd() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -5);
        Date yesterday = calendar.getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String emppastdate = dateFormat.format(yesterday);
        return emppastdate;
    }

    public static String generatePastDate_YYYY_MM_dd_1day() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -1);
        Date yesterday = calendar.getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String emppastdate = dateFormat.format(yesterday);
        return emppastdate;
    }

    public static String generatePastDate_YYYY_MM_dd_nday(int NoDays) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -NoDays);
        Date yesterday = calendar.getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String emppastdate = dateFormat.format(yesterday);
        return emppastdate;
    }

    public static String generatePastDate_YYYY_MM_dd_Time() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -5);
        Date yesterday = calendar.getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String emppastdate = dateFormat.format(yesterday);
        return emppastdate;
    }

    public static String generatePastDate_MMddYYYY() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -5);
        Date yesterday = calendar.getTime();
        DateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
        String empdischargedate = dateFormat.format(yesterday);
        return empdischargedate;
    }

    public static String generatePastDate_MMddYYYYNo(int NoDays) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -NoDays);
        Date yesterday = calendar.getTime();
        DateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
        String empdischargedate = dateFormat.format(yesterday);
        return empdischargedate;
    }

    public static String generatePastDate_MMddYYYY_slash() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -5);
        Date yesterday = calendar.getTime();
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String empdischargedate = dateFormat.format(yesterday);
        return empdischargedate;
    }

    public static String generateTodayDate_MMddYYYY_slash() {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String empenddate = dateFormat.format(date);
        return empenddate;
    }

    public static String generateTodayDate(String format) {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat(format);
        String empenddate = dateFormat.format(date);
        return empenddate;
    }

    public static String generatePastDate_UTCformat() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -5);
        Date yesterday = calendar.getTime();
        String isoDatePattern = "yyyy-MM-dd'T'HH:mm:dd'Z'";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(isoDatePattern);
        String dateString = simpleDateFormat.format(yesterday);
        return dateString;

    }

    public static String generateWeekendDateNearest_UTCFormat() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
        Date date = calendar.getTime();
        String isoDatePattern = "yyyy-MM-dd'T'HH:mm:dd'Z'";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(isoDatePattern);
        return simpleDateFormat.format(date);
    }

    public static String generateUniqueID() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        dateFormat.setTimeZone(TimeZone.getTimeZone("EST"));
        return dateFormat.format(date) + RandomStringUtils.randomNumeric(2);
    }

    public static String getTimeStamp() {

        return new SimpleDateFormat("yyyyMMdd_HHmmss.SSS").format(System.currentTimeMillis());
    }

    public static String captureResponseAltEVVGetWithUID(String bodyAsString, String Url) throws InterruptedException {

        JsonPath jsonPath = new JsonPath(bodyAsString);
        String UID = jsonPath.get("id");
        System.out.println(UID);

        RestAssured.useRelaxedHTTPSValidation();
        Thread.sleep(3000);
        Response getResp = given().config(RestAssured.config().sslConfig(
                new SSLConfig().relaxedHTTPSValidation())).header("Content-Type", "application/json").
                header("Content-Type", "application/json").
                auth().preemptive().
                basic(CommonMethods.propertyfileReader("altevv_user"), CommonMethods.propertyfileReader("altevv_pass")).
                header(globalVariables.Account, CommonMethods.propertyfileReader("altevv_accId")).log().all().
                when().get(Url + '?' + "uuid" + '=' + UID).
                then().log().all().and().extract().response();

        String resstring = getResp.asString();

        System.out.println(resstring);

        logger.log(LogStatus.INFO, "response body extracted is " + resstring);

        return resstring;

    }

    public static boolean captureResponseAltEVVGetWithIsNotExistUID(String Url, String username, String pass, String account, String accId) throws InterruptedException {

        RestAssured.useRelaxedHTTPSValidation();
        Thread.sleep(3000);
        Response getResp = given().config(RestAssured.config().sslConfig(
                new SSLConfig().relaxedHTTPSValidation())).header("Content-Type", "application/json").
                header("Content-Type", "application/json").
                auth().preemptive().
                basic(username, pass).
                header(account, accId).log().all().
                when().get(Url + '?' + "uuid" + '=' + "ccccccccccccccccccccccccccccc").
                then().log().all().and().extract().response();

        return getResp.getStatusCode() == 200;

    }

    // ******************************************* Capture response GET ************************************//

    public static String captureResponseIndiana_Provider_get(String bodyAsString, String Url) {


        JsonPath jsonPath = new JsonPath(bodyAsString);
        String UID = jsonPath.get("id");
        System.out.println(UID);

        RestAssured.useRelaxedHTTPSValidation();

        Response getResp = RestAssured.given().config(RestAssured.config().sslConfig(
                new SSLConfig().relaxedHTTPSValidation())).header("Content-Type", "application/json").
                auth().preemptive().
                basic(stateInfo.get(globalVariables.user), stateInfo.get(globalVariables.pass)).
                header(globalVariables.Account, stateInfo.get(ACCID)).log().all().
                when().get(Url + '?' + "uuid" + '=' + UID).
                then().log().all().and().extract().response();

        String resstring = getResp.asString();

        System.out.println(resstring);

        logger.log(LogStatus.INFO, "response body extracted is " + resstring);


        return resstring;

    }

    public static String captureResponseOpenEVV_ProviderPA_get(String bodyAsString, String Url) {


        JsonPath jsonPath = new JsonPath(bodyAsString);
        String UID = jsonPath.get("id");
        System.out.println(UID);

        RestAssured.useRelaxedHTTPSValidation();

        Response getResp = RestAssured.given().config(RestAssured.config().sslConfig(
                new SSLConfig().relaxedHTTPSValidation())).header("Content-Type", "application/json").
                auth().preemptive().
                basic(stateInfo.get(globalVariables.user), stateInfo.get(globalVariables.pass)).
                header(globalVariables.Account, stateInfo.get(ACCID)).log().all().
                when().get(Url + '?' + "uuid" + '=' + UID).
                then().log().all().and().extract().response();

        String resstring = getResp.asString();

        System.out.println(resstring);

        logger.log(LogStatus.INFO, "response body extracted is " + resstring);


        return resstring;

    }

    public static String captureResponseAltEVV_MolinaGetWithUID(String bodyAsString, String Url) throws InterruptedException {

        JsonPath jsonPath = new JsonPath(bodyAsString);
        String UID = jsonPath.get("id");
        System.out.println(UID);

        RestAssured.useRelaxedHTTPSValidation();

        Response getResp = given().config(RestAssured.config().sslConfig(
                new SSLConfig().relaxedHTTPSValidation())).header("Content-Type", "application/json").
                header("Content-Type", "application/json").
                auth().preemptive().
                basic(CommonMethods.propertyfileReader("altevv_user_molina"), CommonMethods.propertyfileReader("altevv_pass_molina")).
                header(globalVariables.Account, CommonMethods.propertyfileReader("altevv_accId_molina")).log().all().
                when().get(Url + '?' + "uuid" + '=' + UID).
                then().log().all().and().extract().response();

        String resstring = getResp.asString();

        System.out.println(resstring);

        logger.log(LogStatus.INFO, "response body extracted is " + resstring);


        return resstring;

    }

    public static String captureResponseOpenEVVGetWithUID(String bodyAsString, String Url) {

        JsonPath jsonPath = new JsonPath(bodyAsString);
        String UID = jsonPath.get("id");
        System.out.println(UID);
        RestAssured.useRelaxedHTTPSValidation();

        Response getResp = given().config(RestAssured.config().sslConfig(
                new SSLConfig().relaxedHTTPSValidation())).header("Content-Type", "application/json").
                header("Content-Type", "application/json").
                auth().preemptive().
                basic(stateInfo.get(globalVariables.user), stateInfo.get(globalVariables.pass)).
                header(globalVariables.Account, stateInfo.get(ACCID)).log().all().
                when().get(Url + '?' + "uuid" + '=' + UID).
                then().log().all().and().extract().response();

        String resAsString = getResp.asString();

        System.out.println("Response Body is: " + resAsString);

        logger.log(LogStatus.INFO, "response body extracted is " + resAsString);

        return resAsString;

    }

    public static String capturegetIDonly(String bodyAsString) {
        JsonPath jp = new JsonPath(bodyAsString);
        String UID = jp.get("id");
        return UID;

    }

    public static String captureGetResponseOhioGetWithUID_v2(String bodyAsString, String URL) throws InterruptedException {
        JsonPath jp = new JsonPath(bodyAsString);
        String id = jp.get("id");
        Thread.sleep(3000);
        String body;
        Response getResp;
        do {
            getResp = sentGetRespOhio(URL, id);
            Thread.sleep(10000);
            body = getResp.asString();
        } while (getResp.getStatusCode() == 404 || body.contains("The result for the input UUID is not ready yet"));
        return getResp.asString();
    }

    private static Response sentGetRespOhio(String url, String uid) {
        RestAssured.useRelaxedHTTPSValidation();
        return given().config(RestAssured.config().sslConfig(
                new SSLConfig().relaxedHTTPSValidation())).
                contentType(ContentType.JSON).
                auth().preemptive().
                basic(stateInfo.get(globalVariables.user), stateInfo.get(globalVariables.pass)).
                header(globalVariables.Account, stateInfo.get(ACCID)).log().all().
                when().get(url + '?' + "uuid" + '=' + uid);
    }

    public static String captureGetResponseOhioGetWithUID_v1(String bodyAsString, String URL) throws InterruptedException {
        Thread.sleep(3000);
        JsonPath jp = new JsonPath(bodyAsString);
        String UID = jp.get("id");
        RestAssured.useRelaxedHTTPSValidation();
        String body;
        Response getResp;
        do {
            getResp = sentGetRespOhio(URL, UID);
            body = getResp.asString();
            Thread.sleep(15000);
        } while (getResp.getStatusCode() == 404 || body.contains("The result for the input UUID is not ready yet"));
        return body;
    }

    public static String captureResponseAuthrizationGetWithUID(String bodyAsString, String Url) {
        JsonPath jsonPath = new JsonPath(bodyAsString);
        String UID = jsonPath.get("id");
        System.out.println(UID);

        RestAssured.useRelaxedHTTPSValidation();

        Response getResp = given().config(RestAssured.config().sslConfig(
                new SSLConfig().relaxedHTTPSValidation())).header("Content-Type", "application/json").
                header("Content-Type", "application/json").
                auth().preemptive().
                basic(stateInfo.get(globalVariables.user), stateInfo.get(globalVariables.pass)).
                header(globalVariables.Account, stateInfo.get(ACCID)).log().all().
                when().get(Url + '?' + "uuid" + '=' + UID).
                then().log().all().and().extract().response();

        String resstring = getResp.asString();

        System.out.println(resstring);

        logger.log(LogStatus.INFO, "response body extracted is " + resstring);

        return resstring;

    }

    // ******************************************* Capture response POST ************************************//

    public static String capturePostResponse_400(JSONArray altEVVJsonArray, String Url) throws InterruptedException {

        logger.log(LogStatus.INFO, "request body generated is " + altEVVJsonArray.toJSONString());

        RestAssured.useRelaxedHTTPSValidation();

        Response resp = RestAssured.given().body(altEVVJsonArray.toJSONString()).config(RestAssured.config().sslConfig(
                new SSLConfig().relaxedHTTPSValidation())).header("Content-Type", "application/json").
                auth().preemptive().
                basic(stateInfo.get(globalVariables.user), stateInfo.get(globalVariables.pass)).
                header(globalVariables.Account, stateInfo.get(ACCID)).log().all().
                when().post(Url).
                then().assertThat().statusCode(400).extract().response();

        Thread.sleep(3000);
        String bodyAsString = resp.asString();
        System.out.println("Response Body is: " + bodyAsString);

        logger.log(LogStatus.INFO, "response body extracted is " + bodyAsString);

        return bodyAsString;


    }

    public static String capturePostResponse_500(JSONArray altEVVJsonArray, String Url) throws InterruptedException {

        logger.log(LogStatus.INFO, "request body generated is " + altEVVJsonArray.toJSONString());
        RestAssured.useRelaxedHTTPSValidation();

        Response resp = RestAssured.given().body(altEVVJsonArray.toJSONString()).config(RestAssured.config().sslConfig(
                new SSLConfig().relaxedHTTPSValidation())).header("Content-Type", "application/json").
                auth().preemptive().
                basic(stateInfo.get(globalVariables.user), stateInfo.get(globalVariables.pass)).
                header(globalVariables.Account, stateInfo.get(ACCID)).log().all().
                when().post(Url).
                then().assertThat().statusCode(500).and().extract().response();

        String bodyAsString = resp.asString();
        System.out.println("Response Body is: " + bodyAsString);

        logger.log(LogStatus.INFO, "response body extracted is " + bodyAsString);

        return bodyAsString;


    }

    public static String captureResponseOPENEVV(JSONArray OpenEVVJsonArray, String Url, String urlGet) throws InterruptedException {


        logger.log(LogStatus.INFO, "request body generated is " + OpenEVVJsonArray.toJSONString());

        RestAssured.useRelaxedHTTPSValidation();

        Response resp = RestAssured.given().body(OpenEVVJsonArray.toJSONString()).config(RestAssured.config().sslConfig(
                new SSLConfig().relaxedHTTPSValidation())).header("Content-Type", "application/json").
                auth().preemptive().
                basic(stateInfo.get(globalVariables.user), stateInfo.get(globalVariables.pass)).
                header(globalVariables.Account, stateInfo.get(ACCID)).log().all().
                when().post(Url).
                then().assertThat().statusCode(200).and().extract().response();

        Thread.sleep(3000);
        String bodyAsString = resp.asString();
        System.out.println("Response Body is: " + bodyAsString);

        logger.log(LogStatus.INFO, "response body extracted is " + bodyAsString);
        return bodyAsString;

    }

    public static String captureResponseOPENEVV(JSONArray OpenEVVJsonArray, String Url) throws InterruptedException {


        logger.log(LogStatus.INFO, "request body generated is " + OpenEVVJsonArray.toJSONString());

        RestAssured.useRelaxedHTTPSValidation();

        Response resp = RestAssured.given().body(OpenEVVJsonArray.toJSONString()).config(RestAssured.config().sslConfig(
                new SSLConfig().relaxedHTTPSValidation())).header("Content-Type", "application/json").
                auth().preemptive().
                basic(stateInfo.get(globalVariables.user), stateInfo.get(globalVariables.pass)).
                header(globalVariables.Account, stateInfo.get(ACCID)).log().all().
                when().post(Url).
                then().assertThat().statusCode(200).and().extract().response();

        String bodyAsString = resp.asString();
        System.out.println("Response Body is: " + bodyAsString);

        logger.log(LogStatus.INFO, "response body extracted is " + bodyAsString);
        return bodyAsString;

    }

    public static String verifyPostResponseOPENEVV(JSONArray OpenEVVJsonArray, String Url, String urlGet) throws InterruptedException {


        logger.log(LogStatus.INFO, "request body generated is " + OpenEVVJsonArray.toJSONString());

        RestAssured.useRelaxedHTTPSValidation();

        Response resp = RestAssured.given().body(OpenEVVJsonArray.toJSONString()).config(RestAssured.config().sslConfig(
                new SSLConfig().relaxedHTTPSValidation())).header("Content-Type", "application/json").
                auth().preemptive().
                basic(CommonMethods.propertyfileReader("OpenEvv_user"), CommonMethods.propertyfileReader("OpenEvv_pass")).
                header(globalVariables.Account, CommonMethods.propertyfileReader("OpenEvv_AccId")).log().all().
                when().post(Url).
                then().assertThat().statusCode(200).and().extract().response();

        String bodyAsString = resp.asString();
        System.out.println("Response Body is: " + bodyAsString);

        if (!bodyAsString.contains("\"status\": \"SUCCESS\",")) {
            Assert.fail("Post Unsuccessfully");
        }

        logger.log(LogStatus.INFO, "response body extracted is " + bodyAsString);
        return bodyAsString;

    }

    public static String captureResponseOpenEVVGetWithUID_Smoke(String bodyAsString, String Url) {

        JsonPath jsonPath = new JsonPath(bodyAsString);
        String UID = jsonPath.get("id");
        System.out.println(UID);
        RestAssured.useRelaxedHTTPSValidation();

        Response getResp = given().config(RestAssured.config().sslConfig(
                new SSLConfig().relaxedHTTPSValidation())).header("Content-Type", "application/json").
                header("Content-Type", "application/json").
                auth().preemptive().
                basic(CommonMethods.propertyfileReader("OpenEvv_user"), CommonMethods.propertyfileReader("OpenEvv_pass")).
                header(globalVariables.Account, CommonMethods.propertyfileReader("OpenEvv_AccId")).log().all().
                when().get(Url + '?' + "uuid" + '=' + UID).
                then().log().all().and().extract().response();

        String resAsString = getResp.asString();

        System.out.println("Response Body is: " + resAsString);

        logger.log(LogStatus.INFO, "response body extracted is " + resAsString);

        return resAsString;

    }

    public static String captureResponseOPENEVV_getError(JSONArray OpenEVVJsonArray, String Url, String urlGet) throws InterruptedException {


        logger.log(LogStatus.INFO, "request body generated is " + OpenEVVJsonArray.toJSONString());

        RestAssured.useRelaxedHTTPSValidation();

        Response resp = RestAssured.given().body(OpenEVVJsonArray.toJSONString()).config(RestAssured.config().sslConfig(
                new SSLConfig().relaxedHTTPSValidation())).header("Content-Type", "application/json").
                auth().preemptive().
                basic(stateInfo.get(globalVariables.user), stateInfo.get(globalVariables.pass)).
                header(globalVariables.Account, stateInfo.get(ACCID)).log().all().
                when().post(Url).
                then().assertThat().statusCode(200).and().extract().response();

        Thread.sleep(3000);
        String bodyAsString = resp.asString();
        System.out.println("Response Body is: " + bodyAsString);

        logger.log(LogStatus.INFO, "response body extracted is " + bodyAsString);

        String bodyAsStringget = CommonMethods.captureResponseOpenEVVGetWithUID(bodyAsString, urlGet);

        return bodyAsStringget;
    }

    public static String Gethealthresponse(String url) {

        RestAssured.useRelaxedHTTPSValidation();
        // Specify the base URL to the RESTful web service
        RestAssured.baseURI = url;

        // to the server. The server is specified by the BaseURI that we have
        // specified in the above step.

        RequestSpecification httpRequest = RestAssured.given();


        // This will return the Response from the server. Store the response in a variable.
        Response response = httpRequest.request(Method.GET);


        // we have recieved from the server
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is =>  " + responseBody);
        return responseBody;

    }

    public static String captureResponseOhio_v2(JSONArray ohioV2JsonArray, String url) throws InterruptedException {
        Response resp;
        do {
            resp = sentPostForOhio(ohioV2JsonArray, url);
            Thread.sleep(10000);
        } while (resp.getStatusCode() == 404);
        return resp.asString();
    }

    public static String verifyPostResponseOhio(JSONArray Ohiov1JsonArray, String url, String urlGet) throws InterruptedException {
        RestAssured.useRelaxedHTTPSValidation();

        Response resp = RestAssured.given().body(Ohiov1JsonArray.toJSONString()).config(RestAssured.config().sslConfig(
                new SSLConfig().relaxedHTTPSValidation())).header("Content-Type", "application/json").
                auth().preemptive().
                basic(stateInfo.get(globalVariables.user), stateInfo.get(globalVariables.pass)).
                header(globalVariables.Account, stateInfo.get(ACCID)).log().all().
                when().post(url).
                then().assertThat().statusCode(200).and().extract().response();

        String bodyAsString = resp.asString();
        System.out.println("Response Body is: " + bodyAsString);

        Assert.assertFalse(bodyAsString.contains("BAD_REQUEST"));

        CommonMethods.jsonAssert_Smoke_Ohio_Success(CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, urlGet));


        logger.log(LogStatus.INFO, "response body extracted is " + bodyAsString);

        return bodyAsString;

    }

    public static String captureResponseOhio_v2_Errormessage(JSONArray Ohiov2JsonArray, String Url, String GetURL) throws InterruptedException {


        logger.log(LogStatus.INFO, "request body generated is " + Ohiov2JsonArray.toJSONString());

        RestAssured.useRelaxedHTTPSValidation();

        Response resp = RestAssured.given().body(Ohiov2JsonArray.toJSONString()).config(RestAssured.config().sslConfig(
                new SSLConfig().relaxedHTTPSValidation())).header("Content-Type", "application/json").
                auth().preemptive().
                basic(stateInfo.get(globalVariables.user), stateInfo.get(globalVariables.pass)).
                header(globalVariables.Account, stateInfo.get(ACCID)).log().all().
                when().post(Url).
                then().assertThat().statusCode(200).and().extract().response();

        String bodyAsString = resp.asString();
        System.out.println("Response Body is: " + bodyAsString);

        logger.log(LogStatus.INFO, "response body extracted is " + bodyAsString);

        String BodyStringGet = CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, GetURL);

        return BodyStringGet;

    }

    public static String captureResponseOhio_v1(JSONArray Ohiov1JsonArray, String Url) throws InterruptedException {
        logger.log(LogStatus.INFO, "request body generated is " + Ohiov1JsonArray.toJSONString());
        RestAssured.useRelaxedHTTPSValidation();

        JsonObject jsonObject;
        Response resp;
        do {
            resp = sentPostForOhio(Ohiov1JsonArray, Url);
            Thread.sleep(10000);
        } while (resp.getStatusCode() == 404);
        jsonObject = new JsonParser().parse(resp.body().prettyPrint()).getAsJsonObject();
        Assert.assertTrue(jsonObject.get("messageSummary").getAsString().contains("Transaction Received"));
        return resp.asString();
    }

    private static Response sentPostForOhio(JSONArray ohioV1JsonArray, String url) {
        RestAssured.useRelaxedHTTPSValidation();
        return RestAssured.given().body(ohioV1JsonArray.toJSONString()).config(RestAssured.config().sslConfig(
                new SSLConfig().relaxedHTTPSValidation())).contentType(ContentType.JSON).
                auth().preemptive().
                basic(stateInfo.get(globalVariables.user), stateInfo.get(globalVariables.pass)).
                header(globalVariables.Account, stateInfo.get(ACCID)).log().all().
                when().post(url);
    }

    public static String captureResponseIndiana_Provider(JSONArray OpenEVVJsonArray, String Url) {
        logger.log(LogStatus.INFO, "request body generated is " + OpenEVVJsonArray.toJSONString());
        RestAssured.useRelaxedHTTPSValidation();
        Response resp = RestAssured.given().body(OpenEVVJsonArray.toJSONString()).config(RestAssured.config().sslConfig(
                new SSLConfig().relaxedHTTPSValidation())).header("Content-Type", "application/json").
                auth().preemptive().
                basic(stateInfo.get(globalVariables.user), stateInfo.get(globalVariables.pass)).
                header(globalVariables.Account, stateInfo.get(ACCID)).log().all().
                when().post(Url).
                then().assertThat().statusCode(200).and().extract().response();
        String bodyAsString = resp.asString();
        System.out.println("Response Body is: " + bodyAsString);
        logger.log(LogStatus.INFO, "response body extracted is " + bodyAsString);
        return bodyAsString;
    }

    public static String verifyPostResponseIndiana_Provider(JSONArray OpenEVVJsonArray, String Url, String urlGet) {


        logger.log(LogStatus.INFO, "request body generated is " + OpenEVVJsonArray.toJSONString());
        RestAssured.useRelaxedHTTPSValidation();

        Response resp = RestAssured.given().body(OpenEVVJsonArray.toJSONString()).config(RestAssured.config().sslConfig(
                new SSLConfig().relaxedHTTPSValidation())).header("Content-Type", "application/json").
                auth().preemptive().
                basic(stateInfo.get(globalVariables.user), stateInfo.get(globalVariables.pass)).
                header(globalVariables.Account, stateInfo.get(ACCID)).log().all().
                when().post(Url).
                then().assertThat().statusCode(200).and().extract().response();

        String bodyAsString = resp.asString();
        System.out.println("Response Body is: " + bodyAsString);

        if (bodyAsString.contains("\"status\": \"SUCCESS\",")) {
            CommonMethods.verifyjsonassertpasscase(CommonMethods.captureResponseIndiana_Provider_get(bodyAsString, urlGet));
        } else {
            Assert.fail("Post Unsuccessfully");
        }

        logger.log(LogStatus.INFO, "response body extracted is " + bodyAsString);

        return bodyAsString;

    }

    public static String captureResponsePensolvania_Provider(JSONArray OpenEVVJsonArray, String Url) {


        logger.log(LogStatus.INFO, "request body generated is " + OpenEVVJsonArray.toJSONString());
        RestAssured.useRelaxedHTTPSValidation();

        Response resp = RestAssured.given().body(OpenEVVJsonArray.toJSONString()).config(RestAssured.config().sslConfig(
                new SSLConfig().relaxedHTTPSValidation())).header("Content-Type", "application/json").
                auth().preemptive().
                basic(stateInfo.get(globalVariables.user), stateInfo.get(globalVariables.pass)).
                header(globalVariables.Account, stateInfo.get(ACCID)).log().all().
                when().post(Url).
                then().assertThat().statusCode(200).and().extract().response();

        String bodyAsString = resp.asString();
        System.out.println("Response Body is: " + bodyAsString);

        logger.log(LogStatus.INFO, "response body extracted is " + bodyAsString);

        CommonMethods.captureResponseOpenEVV_ProviderPA_get(bodyAsString, CommonMethods.propertyfileReader(globalVariables.provider_get_url));

        return bodyAsString;

    }

    public static JSONArray createJsonArrayWithRequiredField(List<String> requiredField, JSONObject jsonObject) {
        JSONArray jsonArrayrequiredField = new JSONArray();
        JSONObject jsonObjrequiredField = new JSONObject();

        for (String field : requiredField) {
            Iterator<String> iter = jsonObject.keySet().iterator();
            while (iter.hasNext()) {
                String key = iter.next();
                if (key.equalsIgnoreCase(field)) {
                    jsonObjrequiredField.put(key, jsonObject.get(key));
                    break;
                }
            }
        }

        jsonArrayrequiredField.add(jsonObjrequiredField);
        return jsonArrayrequiredField;
    }

    public static JSONObject removeFieldFromJsonObject(List<String> requiredField, JSONObject jsonObject) {


        for (String field : requiredField) {
            Iterator<String> iter = jsonObject.keySet().iterator();
            while (iter.hasNext()) {
                String key1 = iter.next();
                if (key1.equalsIgnoreCase(field)) {
                    jsonObject.remove(key1);
                    break;
                }
            }
        }
        return jsonObject;
    }

    public static String captureResponseOpenEVV_Member(JSONArray OpenEVVJsonArray, String Url) {


        logger.log(LogStatus.INFO, "request body generated is " + OpenEVVJsonArray.toJSONString());
        RestAssured.useRelaxedHTTPSValidation();

        Response resp = RestAssured.given().body(OpenEVVJsonArray.toJSONString()).config(RestAssured.config().sslConfig(
                new SSLConfig().relaxedHTTPSValidation())).header("Content-Type", "application/json").
                auth().preemptive().
                basic(CommonMethods.propertyfileReader("OpenEvv_user"), CommonMethods.propertyfileReader("OpenEvv_pass")).
                header(globalVariables.Account, CommonMethods.propertyfileReader("OpenEvv_AccId")).log().all().
                when().post(Url).
                then().assertThat().statusCode(200).and().extract().response();

        String bodyAsString = resp.asString();
        System.out.println("Response Body is: " + bodyAsString);

        logger.log(LogStatus.INFO, "response body extracted is " + bodyAsString);

        return bodyAsString;

    }

    public static void jsonAssert_Smoke_Ohio_Success(String bodyAsString) {
        Assert.assertTrue(bodyAsString.contains("All records uploaded successfully.") || bodyAsString.contains("The result for the input UUID is not ready yet"));
    }

    public static void verifyjsonassertFailcase(String bodyAsString) {
        logger.log(LogStatus.INFO, "Validating JSON response failed case");
        Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
        Assert.assertTrue(bodyAsString.contains("ErrorCode"));
    }

    // ******************************************* Capture json assert FAIL ************************************//

    public static void verifyjsonassertFailcaseForClaim(String bodyAsString) {
        logger.log(LogStatus.INFO, "Validating JSON response failed case");
        Assert.assertTrue(bodyAsString.contains("401"));
    }

    public static void verifyjsonassertFailcase(String bodyAsString, String Errormesssage) {
        logger.log(LogStatus.INFO, "Validating JSON response failed case");

        Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","), "Status is not Failed");
        Assert.assertTrue(bodyAsString.toLowerCase().contains(Errormesssage.toLowerCase()), "Not found error message: "
                + Errormesssage.toLowerCase());
    }

    public static void verifyjsonassertFailcaseList(String bodyAsString, List<String> Errormesssage) {
        logger.log(LogStatus.INFO, "Validating JSON response failed case");

        for (String body : Errormesssage) {
            if (bodyAsString.contains(body)) {
                System.out.println(body + " is present");
            } else {

                Assert.fail(body + "is not  present");
            }
        }
    }

    public static void verifyjsonassertpasscase(String bodyAsString) {
        logger.log(LogStatus.INFO, "Validating JSON response");
        Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","), "STATUS IS NOT SUCCESS");

        if (bodyAsString.contains("\"reason\"")) {
            Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\""), "reason is not received");
        }
        Assert.assertFalse(bodyAsString.contains("ErrorCode"), "RESPONSE APPEARS ERROR CODE");
    }

    public static void verifyJsonPassCase(String bodyAsString) {
        logger.log(LogStatus.INFO, "Validating JSON response");
        Assert.assertTrue(bodyAsString.contains("All records uploaded successfully.")
                || !bodyAsString.contains("BAD_REQUEST"), "RESPONSE IS NOT SUCCESSFULLY");
    }

    public static void verifyJsonPassCaseForClaim(String bodyAsString) {
        logger.log(LogStatus.INFO, "Validating JSON response");
        Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\""));
    }

    public static void jsonBodyPassVerification_AltEVVGenric(String bodyAsString) {
        logger.log(LogStatus.INFO, "Validating JSON response failed case");
        Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
        Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));

        logger.log(LogStatus.INFO, "Validating DB response ");
    }

    public static void verifyjsonassertFailcase_statusbadrequest(String bodyAsString, String Errormesssage) {
        logger.log(LogStatus.INFO, "Validating JSON response failed case");

        Assert.assertTrue(bodyAsString.contains("BAD_REQUEST"));

        Assert.assertTrue(bodyAsString.contains(Errormesssage));
    }

    public static void verifyjsonassertFailcaseinget(String bodyAsString, String Errormesssage) {
        logger.log(LogStatus.INFO, "Validating JSON response failed case");

        Assert.assertTrue(bodyAsString.contains("\"status\": null,"));

        Assert.assertTrue(bodyAsString.contains(Errormesssage));
    }

    public static void Assert_Visit_FailCase(String bodyAsString, String Errormesssage) {
        logger.log(LogStatus.INFO, "Validating JSON response failed case");
//		V2 not have status when having error
//		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));

        Assert.assertTrue(bodyAsString.contains(Errormesssage));
    }

    public static void Assert_Visit_FailCase_errorcode(String bodyAsStringget, String Errormesssage) {
        logger.log(LogStatus.INFO, "Validating JSON response failed case");

        Assert.assertTrue(bodyAsStringget.contains("\"status\": \"SUCCESS\","));
        String Subreponse = bodyAsStringget;
        Assert.assertTrue(Subreponse.contains("\"ErrorCode\": \"-785\","));

        Assert.assertTrue(Subreponse.contains(Errormesssage));
    }

    public static void Assert_Visit_FailCase_withError(String bodyAsStringget, String Errormesssage) {
        logger.log(LogStatus.INFO, "Validating JSON response failed case");

        Assert.assertTrue(bodyAsStringget.contains("\"status\": \"SUCCESS\","));
        String Subreponse = bodyAsStringget;
        Assert.assertTrue(Subreponse.contains("\"ErrorCode\": \"-709\","));

        Assert.assertTrue(Subreponse.contains(Errormesssage));
    }

    public static void verifyErrorMessage(String body, String errorMessage) {
        Assert.assertTrue(body.contains(errorMessage));
    }

    public static void Assert_Provider_FailCase(String bodyAsString) {
        logger.log(LogStatus.INFO, "Validating JSON response failed case");

        Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));

        Assert.assertTrue(bodyAsString.contains("\"messageSummary\": null,"));

        Assert.assertTrue(bodyAsString.contains("\"messageDetail\": null,"));


    }

    public static void Assert_nullstatus_FailCase(String bodyAsString, String Errormesssage) {
        logger.log(LogStatus.INFO, "Validating JSON response failed case");

        Assert.assertTrue(bodyAsString.contains("\"status\": null,"));

        Assert.assertTrue(bodyAsString.contains(Errormesssage));
    }

    public static void verifyjsonassertFailcase_400(String bodyAsString, String Errormesssage) {
        logger.log(LogStatus.INFO, "Validating JSON response failed case");

        Assert.assertTrue(bodyAsString.contains("\"status\": 400"));
        Assert.assertTrue(bodyAsString.contains("\"error\": \"Bad Request\""));

        Assert.assertTrue(bodyAsString.contains(Errormesssage));
    }

    public static void verifylistassertion(String bodyAsString, ArrayList<String> arraylistverify) {
        logger.log(LogStatus.INFO, "Validating  response body type");

        JsonPath jp = new JsonPath(bodyAsString);
        ArrayList<String> arraylist = new ArrayList<String>();
        arraylist.add(jp.get("id"));
        arraylist.add(jp.get("AgencyIdentifier"));
        arraylist.add(jp.get("ProviderID"));
        arraylist.add(jp.get("RecordType"));
        arraylist.add(jp.get("RecordOtherID"));
        arraylist.add(jp.get("reason"));

        System.out.println(arraylist);

        for (String list : arraylistverify) {
            Assert.assertTrue(bodyAsString.contains(list));
        }
    }

    public static String verifyPostAltEVVSuccessfully(JSONArray altEVVJsonArray, String url, String urlGet) throws InterruptedException {

        RestAssured.useRelaxedHTTPSValidation();
        Response resp = RestAssured.given().body(altEVVJsonArray.toJSONString()).config(RestAssured.config().sslConfig(
                new SSLConfig().relaxedHTTPSValidation())).header("Content-Type", "application/json").
                auth().preemptive().
                basic(CommonMethods.propertyfileReader("altevv_user"), CommonMethods.propertyfileReader("altevv_pass")).
                header(globalVariables.Account, CommonMethods.propertyfileReader("altevv_accId")).log().all().
                when().post(url).
                then().assertThat().statusCode(200).and().extract().response();

        Thread.sleep(3000);
        String bodyAsString = resp.asString();
        System.out.println("Response Body is: " + bodyAsString);

        if (bodyAsString.contains("\"status\": \"SUCCESS\",")) {
            CommonMethods.verifyjsonassertpasscase(CommonMethods.captureResponseAltEVVGetWithUID(bodyAsString, urlGet));
        } else {
            try {
                org.json.JSONObject jsonObject = new org.json.JSONObject(bodyAsString);
                org.json.JSONArray data = jsonObject.getJSONArray("data");
                org.json.JSONObject dataJson = data.getJSONObject(0);
                Assert.fail("ErrorMessage: " + dataJson.getString("ErrorMessage"));
            } catch (JSONException e) {
                Assert.fail("Status IS NOT SUCCESS but Not find Error Message:\n" + bodyAsString);
            }
        }
        return bodyAsString;
    }

    public static void AssertEqualsAndPrintValuesString(String Expected, String Actual, String VerifyText) {
        System.out.println("Verifying :" + VerifyText + " Expected: " + Expected + " Actual: " + Actual);
        Assert.assertEquals(Actual, Expected);
    }

    public static void deleteAllFilesInDirectory(String directoryPath) {
        File directory = new File(directoryPath);
        if (directory.exists()) {
            for (File file : directory.listFiles()) {
                if (!file.isDirectory()) {
                    file.delete();
                }
            }
        }
    }

    // ******************************************* Assert and print value ************************************//

    public static String captureResponseOhio_500(JSONArray threePJsonArray, String Url) {


        logger.log(LogStatus.INFO, "request body generated is " + threePJsonArray.toJSONString());

        RestAssured.useRelaxedHTTPSValidation();

        Response resp = RestAssured.given().body(threePJsonArray.toJSONString()).config(RestAssured.config().sslConfig(
                new SSLConfig().relaxedHTTPSValidation())).header("Content-Type", "application/json").
                auth().preemptive().
                basic(CommonMethods.propertyfileReader("ohio_user_v2"), CommonMethods.propertyfileReader("ohio_pass_v2")).
                header(globalVariables.Account, CommonMethods.propertyfileReader("ohio_AccId_v2")).log().all().
                when().post(Url).
                then().assertThat().log().all().and().extract().response();

        String bodyAsString = resp.asString();
        System.out.println("Response Body is: " + bodyAsString);

        logger.log(LogStatus.INFO, "response body extracted is " + bodyAsString);

        return bodyAsString;

    }

    public static String generateInboundControlFile(String timeStamp, String filename) {
        String[] tcname = Thread.currentThread().getStackTrace()[4].getMethodName().split("_");
        return filename + tcname[2] + "_Inbound_ControlFile_" + timeStamp + ".csv.gpg";
    }

    public static String callgenerateInboundControlFile(String timeStamp, String filename) {
        return generateInboundControlFile(timeStamp, filename);
    }

    public static List<String> getProviderErrorMessageForMissingRequiredField() {
        List<String> Errormessage = new ArrayList<String>();
        Errormessage.add(globalVariables.providerSSNError);
        Errormessage.add(globalVariables.memberClientCityNullError);
        Errormessage.add(globalVariables.memberClientEligibilityDateBeginNullError);
        Errormessage.add(globalVariables.memberClientStateNullError);
        Errormessage.add(globalVariables.memberClientZipNullError);
        Errormessage.add(globalVariables.memberClientCustomIDNullError);
        Errormessage.add(globalVariables.memberClientOtherIDNullError);
        Errormessage.add(globalVariables.memberClientSSNNullError);
        Errormessage.add(globalVariables.memberClientFirstNameNullError);
        Errormessage.add(globalVariables.memberClientLastNameNullError);
        Errormessage.add(globalVariables.memberClientEligibilityDateBeginFormatError);
        return Errormessage;
    }

    public static JSONArray LoadJSON_ThreeP_Rest(String jsonname) throws InterruptedException, IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONArray jsonarr = null;

        Object obj = parser.parse(new FileReader(System.getProperty(userDir) + File.separator + "src" + File.separator + "main" + File.separator
                + "java" + File.separator + "Resources" + File.separator + "ThreeP" + File.separator + jsonname + ".json"));


        jsonarr = new JSONArray();
        jsonarr.add(obj);
        return jsonarr;

    }

    public static String captureResponseClaim(JSONObject Claimsonobject, String Url) {


        logger.log(LogStatus.INFO, "request body generated is " + Claimsonobject.toJSONString());

        System.out.println(Claimsonobject.toJSONString());
        RestAssured.useRelaxedHTTPSValidation();

        Response resp = RestAssured.given().body(Claimsonobject.toJSONString()).config(RestAssured.config().sslConfig(
                new SSLConfig().relaxedHTTPSValidation())).
                auth().preemptive().
                basic(stateInfo.get(globalVariables.userClaim), stateInfo.get(globalVariables.passClaim)).
                header("Content-Type", "application/json").
                header("EntityGuid", stateInfo.get(globalVariables.EntityGuid)).log().all().
                when().post(Url).
                then().assertThat().and().extract().response();

        String bodyAsString = resp.asString();
        System.out.println("Response Body is: " + bodyAsString);

        logger.log(LogStatus.INFO, "response body extracted is " + bodyAsString);


        return bodyAsString;
    }


    // --------------------------method added after parallel***************************//

    public static String CapterrestclaimResponse(String bodyString, String Urlresponse) {

        logger.log(LogStatus.INFO, "Veirfying the value of response");
        Assert.assertTrue(bodyString.contains(Urlresponse));
        return Urlresponse;


    }

    public static String CapterrestclaimResponse_invalid(String bodyString, String Urlresponse) {

        logger.log(LogStatus.INFO, "Veirfying the value of response");
        Assert.assertTrue(bodyString.contains(Urlresponse));
        return Urlresponse;


    }

    public static void errorCodeValidationJsonDB(JSONObject jsonObject_Map, Map<String, String> DbMap) {
        if (DbMap.get("ERROR_CODE") == null) {
            jsonObject_Map.put("ERROR_CODE", null);

        } else if (DbMap.get("ERROR_CODE").equals("0")) {
            jsonObject_Map.put("ERROR_CODE", "0");
        }
    }

    public static void updateCsvFile(String fileName, String valueToUpdate) throws IOException {
        FileWriter pw = new FileWriter(fileName, true);
        StringBuilder builder = new StringBuilder();

        // No need give the headers Like: id, Name on builder.append


        builder.append(valueToUpdate);
        builder.append('\n');
        pw.write(builder.toString());
        pw.close();

    }

    public static JSONObject CapterrestclaimResponse_value(JSONObject claimSubobject, JSONObject object, JSONObject objectdata) throws ParseException {

        logger.log(LogStatus.INFO, "Veirfying the value of response");


        Assert.assertEquals(claimSubobject.get("BatchID"), object.get("BatchID"));
        Assert.assertEquals(claimSubobject.get("TransactionID"), object.get("TransactionID"));
        Assert.assertEquals(claimSubobject.get("ICN"), object.get("ICN"));
        Assert.assertEquals(claimSubobject.get("DLN"), object.get("DLN"));
        Assert.assertEquals(claimSubobject.get("ProviderID"), object.get("ProviderID"));
        Assert.assertEquals(claimSubobject.get("PatientID"), object.get("PatientID"));
        Assert.assertEquals(object.get("DateofService"), null);
        Assert.assertEquals(object.get("RecordsFound"), null);
        Assert.assertEquals(object.get("VisitTimeZone"), null);
        Assert.assertEquals(object.get("VisitFound"), null);
        Assert.assertEquals(object.get("AdjOutDateTime"), null);
        Assert.assertEquals(object.get("AdjInDateTime"), null);
        Assert.assertEquals(object.get("ServiceStartDate"), null);
        Assert.assertEquals(object.get("ServiceEndDate"), null);
        Assert.assertNotEquals(objectdata.get("succeededCount"), "0");
        Assert.assertEquals(objectdata.get("failedCount").toString(), "0");


        return object;

    }

    public static JSONObject CapterrestclaimResponse_value_pass(JSONObject claimSubobject, JSONObject object) throws ParseException {

        logger.log(LogStatus.INFO, "Veirfying the value of response");


        Assert.assertEquals(claimSubobject.get("BatchID"), object.get("BatchID"));
        Assert.assertEquals(claimSubobject.get("TransactionID"), object.get("TransactionID"));
        Assert.assertEquals(claimSubobject.get("ICN"), object.get("ICN"));
        Assert.assertEquals(claimSubobject.get("DLN"), object.get("DLN"));
        Assert.assertEquals(claimSubobject.get("ProviderID"), object.get("ProviderID"));
        Assert.assertEquals(claimSubobject.get("PatientID"), object.get("PatientID"));
        Assert.assertEquals(claimSubobject.get("DateofService"), object.get("DateofService"));
        Assert.assertEquals(object.get("RecordsFound"), "1");
        Assert.assertEquals(object.get("VisitTimeZone"), "US/Eastern");
        Assert.assertEquals(object.get("VisitFound"), true);


        return object;

    }

    public static JSONObject CapterrestclaimResponse_inOut_time(JSONObject claimSubobject, JSONObject object, JSONObject objectdata) throws ParseException {

        logger.log(LogStatus.INFO, "Veirfying the value of response");


        Assert.assertEquals(claimSubobject.get("BatchID"), object.get("BatchID"));
        Assert.assertEquals(claimSubobject.get("TransactionID"), object.get("TransactionID"));
        Assert.assertEquals(claimSubobject.get("ICN"), object.get("ICN"));
        Assert.assertEquals(claimSubobject.get("DLN"), object.get("DLN"));
        Assert.assertEquals(claimSubobject.get("ProviderID"), object.get("ProviderID"));
        Assert.assertEquals(claimSubobject.get("PatientID"), object.get("PatientID"));
        Assert.assertEquals(claimSubobject.get("DateofService"), object.get("DateofService"));
        Assert.assertEquals(object.get("RecordsFound"), "1");
        Assert.assertEquals(object.get("VisitTimeZone"), "US/Eastern");
        Assert.assertEquals(object.get("VisitFound"), true);
        Assert.assertEquals(claimSubobject.get("Units").toString(), object.get("Units"));
        Assert.assertNotEquals(object.get("AdjOutDateTime"), null);
        Assert.assertNotEquals(object.get("AdjInDateTime"), null);
        Assert.assertNotEquals(objectdata.get("succeededCount"), "0");
        Assert.assertEquals(objectdata.get("failedCount").toString(), "0");


        return object;

    }

    public static String RandomProviderQualifier() {
        String Generate_RandomProviderQualifier = RandomProviderQualifier[CommonMethods.getRandomInt(0, (RandomProviderQualifier.length) - 1)];
        return Generate_RandomProviderQualifier;

    }

    public static String ConvertDateFromDBToJsonFormat(String dateFromDB) {
        String[] dateTime = dateFromDB.split(" ");
        Date onlyDate = null;
        try {
            onlyDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateTime[0]);
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        String isoDatePattern = "yyyy-MM-dd'T'HH:mm:dd'Z'";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(isoDatePattern);
        return simpleDateFormat.format(onlyDate);
    }

    public static String ConvertDateAsOneDayBefore(String dateFromDB) {
        System.out.println(dateFromDB);
        String[] dateTime = dateFromDB.split(" ");
        Date onlyDate = null;
        try {
            onlyDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateTime[0]);
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        String isoDatePattern = "yyyy-MM-dd'T'HH:mm:dd'Z'";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(isoDatePattern);
        return simpleDateFormat.format(DateUtils.addDays(onlyDate, -1));
    }

    public static String ConvertDateAsOneDayAfter(String dateFromDB) {
        System.out.println(dateFromDB);
        String[] dateTime = dateFromDB.split(" ");
        Date onlyDate = null;
        try {
            onlyDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateTime[0]);
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        String isoDatePattern = "yyyy-MM-dd'T'HH:mm:dd'Z'";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(isoDatePattern);
        return simpleDateFormat.format(DateUtils.addDays(onlyDate, +1));
    }

    public static String ConvertDate(String dateFromDB) {
        System.out.println(dateFromDB);
        String[] dateTime = dateFromDB.split(" ");
        Date onlyDate = null;
        try {
            onlyDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateTime[0]);
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        String isoDatePattern = "yyyy-MM-dd'T'HH:mm:dd'Z'";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(isoDatePattern);
        return simpleDateFormat.format(onlyDate);
    }

    public static String generateInboundControlFileSegment(String timeStamp, String filename) {
        String[] tcname = Thread.currentThread().getStackTrace()[4].getMethodName().split("_");
        return filename + tcname[2] + "_Inbound_ControlFile_" + timeStamp + ".csv.gpg";
    }

    public static String dateToDateTimeForma_HHMM(String dateToFormat) throws InterruptedException, ParseException, java.text.ParseException {

        Date dateConverted = new SimpleDateFormat("HHmm").parse(dateToFormat);

        String pattern = "HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String dt = simpleDateFormat.format(dateConverted);
        return (dt + ".0");
    }

    public static void dayOfWeekNoFromDayOfWeek(Map<String, String> objectMap, String fieldToPut) {
        String dayOfWeek = String.valueOf(objectMap.get(fieldToPut));

        switch (dayOfWeek) {
            case "null":
                objectMap.put(fieldToPut, "0");
                break;
            case "Mon":
                objectMap.put(fieldToPut, "1");
                break;
            case "Tue":
                objectMap.put(fieldToPut, "2");
                break;
            case "Wed":
                objectMap.put(fieldToPut, "3");
                break;
            case "Thu":
                objectMap.put(fieldToPut, "4");
                break;
            case "Fri":
                objectMap.put(fieldToPut, "5");
                break;
            case "Sat":
                objectMap.put(fieldToPut, "6");
                break;
            case "Sun":
                objectMap.put(fieldToPut, "7");
                break;
        }

    }

    public static String callgenerateInboundControlFileSegment(String timeStamp, String filename) {
        return generateInboundControlFileSegment(timeStamp, filename);
    }

    public static String verifyPostResponse(JSONArray jsonArray, String url, String urlGet) throws InterruptedException {
        logger.log(LogStatus.INFO, "request body generated is " + jsonArray.toJSONString());

        Response resp = getRequestSpecification().body(jsonArray.toJSONString()).
                when().post(url).
                then().assertThat().statusCode(200).and().extract().response();

        String bodyAsString = resp.asString();
        System.out.println("Response Body is: " + bodyAsString);

        Thread.sleep(5000);
        if (bodyAsString.contains("\"status\": \"SUCCESS\",")) {
            CommonMethods.verifyjsonassertpasscase(CommonMethods.captureGetResponseWithUID(bodyAsString, urlGet));
        } else {
            Assert.fail("Post Unsuccessfully");
        }

        logger.log(LogStatus.INFO, "response body extracted is " + bodyAsString);
        return bodyAsString;

    }

    public static String captureGetResponseWithUID(String bodyAsString, String url) {
        JsonPath jsonPath = new JsonPath(bodyAsString);
        String uID = jsonPath.get("id");
        Response getResp = getRequestSpecification().
                param("uuid", uID).
                when().get(url).
                then().log().all().and().extract().response();

        return getResp.asString();
    }

    public static RequestSpecification getRequestSpecification() {
        RequestSpecification requestSpecification = given().relaxedHTTPSValidation()
                .auth().preemptive()
                .basic(getBasicUserName(), getBasicPassword())
                .header(CONTENTTYPE, APPLICATIONJSON)
                .log().all();
        if (!isEntityGuid) {
            requestSpecification.header(globalVariables.Account, stateInfo.get(ACCID));
        }
        else
            requestSpecification.header(globalVariables.ENTITYGUID, stateInfo.get(globalVariables.ENTITYGUID));
        return requestSpecification;
    }

    private static String getBasicPassword() {
        if (!isEntityGuid) {
            return stateInfo.get(globalVariables.pass);
        }else
            return stateInfo.get(globalVariables.entityPass);

    }

    private static String getBasicUserName() {
        if(!isEntityGuid){
            return stateInfo.get(globalVariables.user);
        }else
            return stateInfo.get(globalVariables.entityUser);
    }

    public static String capturePostResponse(JSONArray altEVVJsonArray, String url) {
        Response resp = getRequestSpecification().
                body(altEVVJsonArray.toJSONString()).
                when().post(url).
                then().and().extract().response();
        return resp.prettyPrint();
    }

    public static String validateResponse(JSONArray jsonArray, String url) {
        String bodyAsString = capturePostResponse(jsonArray, url);
        verifyjsonassertpasscase(bodyAsString);
        return bodyAsString;
    }

    public static String captureGetResponse(JSONArray jsonArray, String url, String urlGet) throws InterruptedException {
        String bodyAsString = capturePostResponse(jsonArray, url);
        Thread.sleep(5000);
        return captureGetResponseWithUID(bodyAsString, urlGet);
    }

    public static String validateResponse_Ohio(JSONArray OpenEVVJsonArray, String Url) {
        RestAssured.useRelaxedHTTPSValidation();

        Response resp = RestAssured.given().body(OpenEVVJsonArray.toJSONString()).config(RestAssured.config().sslConfig(
                new SSLConfig().relaxedHTTPSValidation())).header("Content-Type", "application/json").
                auth().preemptive().
                basic(stateInfo.get(globalVariables.user), stateInfo.get(globalVariables.pass)).
                header(globalVariables.Account, stateInfo.get(ACCID)).log().all().
                when().post(Url).
                then().assertThat().statusCode(200).and().extract().response();

        String bodyAsString = resp.asString();
        System.out.println("Response Body is: " + bodyAsString);

        Assert.assertTrue(bodyAsString.contains("Transaction Received"), "POST UNSUCCESSFULLY");

        logger.log(LogStatus.INFO, "response body extracted is " + bodyAsString);
        return bodyAsString;

    }

    public static String validateResponse_Ohio(JSONArray OpenEVVJsonArray, String Url, String getURL) throws InterruptedException {
        RestAssured.useRelaxedHTTPSValidation();

        Response resp = RestAssured.given().body(OpenEVVJsonArray.toJSONString()).config(RestAssured.config().sslConfig(
                new SSLConfig().relaxedHTTPSValidation())).header("Content-Type", "application/json").
                auth().preemptive().
                basic(stateInfo.get(globalVariables.user), stateInfo.get(globalVariables.pass)).
                header(globalVariables.Account, stateInfo.get(ACCID)).log().all().
                when().post(Url).
                then().assertThat().statusCode(200).and().extract().response();

        String bodyAsString = resp.asString();
        System.out.println("Response Body is: " + bodyAsString);

        Assert.assertTrue(bodyAsString.contains("Transaction Received"), "POST UNSUCCESSFULLY");

        String bodyGet = captureGetResponseOhioGetWithUID_v1(bodyAsString, getURL);

        Assert.assertTrue(bodyGet.contains("All records uploaded successfully."), "GET UNSUCCESSFULLY");

        logger.log(LogStatus.INFO, "response body extracted is " + bodyAsString);
        return bodyAsString;
    }

    public static String getResponse_Ohio_get_V1(JSONArray OpenEVVJsonArray) throws InterruptedException {
        RestAssured.useRelaxedHTTPSValidation();

        Response resp = RestAssured.given().body(OpenEVVJsonArray.toJSONString()).config(RestAssured.config().sslConfig(
                new SSLConfig().relaxedHTTPSValidation())).header("Content-Type", "application/json").
                auth().preemptive().
                basic(stateInfo.get(globalVariables.user), stateInfo.get(globalVariables.pass)).
                header(globalVariables.Account, stateInfo.get(ACCID)).log().all().
                when().post(CommonMethods.propertyfileReader(globalVariables.ohio_patient_v1)).
                then().assertThat().statusCode(200).and().extract().response();

        String bodyAsString = resp.asString();
        System.out.println("Response Body is: " + bodyAsString);

        String bodyGet = captureGetResponseOhioGetWithUID_v1(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v1));

        logger.log(LogStatus.INFO, "response body extracted is " + bodyAsString);
        return bodyGet;
    }

    public static String captureResponseClaimDependencyApiSetingV2(JSONObject Claimsonobject, String Url,
                                                                   String entityId, String username, String password, boolean response) {
        System.out.println(Claimsonobject.toJSONString());
        RestAssured.useRelaxedHTTPSValidation();

        if (entityId.equals("invalid")) {
            entityId += "abc";
        } else if (entityId.equals("valid")) {
            entityId = stateInfo.get(globalVariables.EntityGuid);
        }

        if (username != null && username.equals("invalid")) {
            username += "abc";
        } else if (username.equals("share")) {
            username = "admin";
        } else if (username.equals("valid")) {
            username = stateInfo.get(globalVariables.userClaim);
        }

        if (password != null && password.equals("invalid")) {
            password += "abc";
        } else if (password.equals("share")) {
            password = "admin";
        } else if (password.equals("valid")) {
            password = stateInfo.get(globalVariables.passClaim);
        }

        Response resp = null;

        if (entityId.equals("none")) {
            resp = RestAssured.given().body(Claimsonobject.toJSONString()).config(RestAssured.config().sslConfig(
                    new SSLConfig().relaxedHTTPSValidation())).
                    auth().preemptive().
                    basic(username, password).
                    header("Content-Type", "application/json").
                    log().all().
                    when().post(Url).
                    then().assertThat().and().extract().response();
        } else {
            resp = RestAssured.given().body(Claimsonobject.toJSONString()).config(RestAssured.config().sslConfig(
                    new SSLConfig().relaxedHTTPSValidation())).
                    auth().preemptive().
                    basic(username, password).
                    header("Content-Type", "application/json").
                    header("EntityGuid", entityId).log().all().
                    when().post(Url).
                    then().assertThat().and().extract().response();
        }

        if (response)
            return resp.getBody().asString();

        return String.valueOf(resp.getStatusCode());
    }

    public static JSONArray captureMultiResponseClaim_V2(JSONObject Claimsonobject, String Url) throws ParseException {
        JSONArray responses = new JSONArray();
        JSONParser parser = new JSONParser();

        System.out.println(Claimsonobject.toJSONString());
        RestAssured.useRelaxedHTTPSValidation();

        Response resp = RestAssured.given().body(Claimsonobject.toJSONString()).config(RestAssured.config().sslConfig(

                new SSLConfig().relaxedHTTPSValidation())).
                auth().preemptive().
                basic(stateInfo.get(globalVariables.userClaim), stateInfo.get(globalVariables.passClaim)).
                header("Content-Type", "application/json").
                header("EntityGuid", stateInfo.get(globalVariables.EntityGuid)).log().all().
                when().post(Url).
                then().assertThat().and().extract().response();

        String bodyAsString = resp.getBody().asString();
        System.out.println("Response Body is: " + bodyAsString);

        logger.log(LogStatus.INFO, "response body extracted is " + bodyAsString);

        JSONObject response = (JSONObject) parser.parse(bodyAsString);
        JSONObject data = (JSONObject) response.get("data");
        responses = (JSONArray) data.get("EVV_Response");

        return responses;
    }

    public static void verifyStatusSUCCESS(String bodyAsString) {
        Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
    }

    public static void verifyStatusFAILED(String bodyAsString) {
        Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
    }
}