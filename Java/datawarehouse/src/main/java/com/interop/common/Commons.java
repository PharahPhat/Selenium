package com.interop.common;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.sandata.core.config.Environment;
import com.sandata.core.config.TestConfiguration;
import com.sandata.core.config.TestContext;
import com.sandata.core.report.ExtentTestManager;
import com.sandata.utilities.sftp.utils.SftpConfig;
import com.sandata.utilities.sftp.utils.SftpUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.testng.Assert;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static com.sandata.common.Constant.DOWNLOAD_FOLDER;

public class Commons {
    private static final Logger LOGGER = Logger.getLogger(Commons.class);
    private static final String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";
    private static final String DATE_TIME_24H_FORMAT = "yyyyMMddHHmmss";
    private static final String DATE_TIME_24H_FORMAT2 = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    private static final String DATE_TIME_24H_FORMAT3 = "yyMMddHHmmssSSS";
    private static final String TIMEZONE = "US/Eastern";
    private static final String BASE_FOLDER = System.getProperty("user.dir");
    private static final String JMETER_EXPORT_FILE = "parametersLoadOpenEVVTeamplate.csv";
    private static final String PREFIX = "_PREFIX";
    private Random rand = new Random();

    public String getFileNameContain(List<String> fileNames, String containText) {
        String result = "";
        for (String fileName : fileNames) {
            if (fileName.contains(containText)){
                result =  fileName;
            }
        }
        if(result.isEmpty()){
            result = fileNames.get(0).replace("PROVIDER_GENERAL",containText);
        }
        return result;
    }

    public String getDefaultTimezone() {
        return TIMEZONE;
    }

    public void deleteSftpFiles(String hostname, int port,
                                String username, String password,
                                String folderPath, List<String> fileNames, int limit) {
        SftpConfig sftpConfig = new SftpConfig();
        sftpConfig.setHost(hostname);
        sftpConfig.setPort(port);
        sftpConfig.setUsername(username);
        sftpConfig.setPassword(password);
        this.deleteSftpFiles(sftpConfig, folderPath, fileNames, limit);
    }

    public void deleteSftpFiles(String hostname, int port,
                                String username, String password,
                                String folderPath, String extension, int limit) {
        SftpConfig sftpConfig = new SftpConfig();
        sftpConfig.setHost(hostname);
        sftpConfig.setPort(port);
        sftpConfig.setUsername(username);
        sftpConfig.setPassword(password);
        List<String> fileNames = SftpUtils.getAllFileNames(sftpConfig, folderPath, extension);
        this.deleteSftpFiles(sftpConfig, fileNames, limit);
    }

    public void deleteSftpFiles(SftpConfig sftpConfig, List<String> fileNames, int limit) {
        if (fileNames.size() < limit) {
            SftpUtils.deleteFiles(sftpConfig, fileNames);
        } else {
            int count = fileNames.size() / limit;
            int surplus = fileNames.size() % limit;
            for (int i = 1; i <= count; i++) {
                List<String> list = fileNames.subList(0, limit);
                SftpUtils.deleteFiles(sftpConfig, list);
                fileNames.subList(0, limit).clear();
            }
            List<String> list = fileNames.subList(0, surplus);
            SftpUtils.deleteFiles(sftpConfig, list);
            fileNames.subList(0, surplus).clear();
        }
    }

    public void deleteSftpFiles(SftpConfig sftpConfig, String folderPath, List<String> fileNames, int limit) {
        if (fileNames.size() < limit) {
            SftpUtils.deleteFiles(sftpConfig, folderPath, fileNames);
        } else {
            int count = fileNames.size() / limit;
            int surplus = fileNames.size() % limit;
            for (int i = 1; i <= count; i++) {
                List<String> list = fileNames.subList(0, limit);
                SftpUtils.deleteFiles(sftpConfig, folderPath, list);
                fileNames.subList(0, limit).clear();
            }
            List<String> list = fileNames.subList(0, surplus);
            SftpUtils.deleteFiles(sftpConfig, folderPath, list);
            fileNames.subList(0, surplus).clear();
        }
    }

    public List<String> getAllFileNamesInSftpFolder(String hostname, int port,
                                                    String username, String password,
                                                    String folderPath, String extension) {
        SftpConfig sftpConfig = new SftpConfig();
        sftpConfig.setHost(hostname);
        sftpConfig.setPort(port);
        sftpConfig.setUsername(username);
        sftpConfig.setPassword(password);
        return SftpUtils.getAllFileNames(sftpConfig, folderPath, extension);
    }

    public String generateUniqueNumber() {
        return new SimpleDateFormat(DATE_TIME_24H_FORMAT3).format(new Date()) + RandomStringUtils.randomNumeric(1);
    }

    public String generateUniqueNumber17Digits() {
        return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()).substring(0,16);
    }

    public String generateUniqueNumberEx() {
        return new SimpleDateFormat(DATE_TIME_24H_FORMAT).format(new Date()) + RandomStringUtils.randomNumeric(20);
    }

    public String generateSequenceID() {
        return new SimpleDateFormat(DATE_TIME_24H_FORMAT).format(new Date());
    }

    public String getDateString(int numOfDays) {
        return this.getDateString(numOfDays, DATE_TIME_24H_FORMAT2);
    }

    public String getDateUTCFormat(int numOfDays, String dateFormat) {
        SimpleDateFormat dateFormater = new SimpleDateFormat(dateFormat);
        dateFormater.setTimeZone(TimeZone.getTimeZone("GMT"));
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, numOfDays);
        Date todate = cal.getTime();
        return dateFormater.format(todate);
    }

    public String getDateString(int numOfDays, String timeZone, String dateFormat) {
        SimpleDateFormat dateFormater = new SimpleDateFormat(dateFormat);
        dateFormater.setTimeZone(TimeZone.getTimeZone(timeZone));
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, numOfDays);
        Date todate = cal.getTime();
        return dateFormater.format(todate);
    }

    public String convertDateTimeToTime(String date, String fromFormat, String toFormat) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern(fromFormat);
        LocalDateTime localDateTime = LocalDateTime.parse(date, format);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(toFormat);
        return localDateTime.format(dateTimeFormatter);
    }

    public String convertDateTimeFormatFrom2FormatTo(String date, String formatFrom, String formatTo, int numberOfDay){
        DateFormat df = new SimpleDateFormat(formatFrom);
        SimpleDateFormat format = new SimpleDateFormat(formatTo);
        String result = "";
        try {
            Date dateFormantForm = df.parse(date);
            Date dateSubDay = DateUtils.addDays(dateFormantForm,numberOfDay);
            result = format.format(dateSubDay);
        } catch (ParseException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return result;
    }

    // SEVV-10395 fixed
    public String generateClientDesigneeEndDate(int numOfDays, String dateFormat, String timeZone) {
        this.logInfo("Going to generate ClientDesigneeEndDate...");
        SimpleDateFormat dateFormatter = new SimpleDateFormat(dateFormat);
        dateFormatter.setTimeZone(TimeZone.getTimeZone(timeZone));

        Calendar sourceCalendar = Calendar.getInstance();
        sourceCalendar.add(Calendar.DATE, numOfDays);
        Date toDate = sourceCalendar.getTime();

        this.logInfo("Local Time:" + toDate);
        this.logInfo("US/Eastern Time:" + dateFormatter.format(sourceCalendar.getTime()));
        String usEst = dateFormatter.format(sourceCalendar.getTime());
        dateFormatter.setTimeZone(TimeZone.getTimeZone("GMT"));
        this.logInfo("UTC: " + dateFormatter.format(sourceCalendar.getTime()));
        return usEst;
    }

    public String shiftTimeZone(int numOfDays, TimeZone sourceTimeZone, TimeZone targetTimeZone, String dateFormat) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat(dateFormat);
        Calendar sourceCalendar = Calendar.getInstance();
        sourceCalendar.setTimeZone(sourceTimeZone);
        sourceCalendar.add(Calendar.DATE, numOfDays);

        Calendar targetCalendar = Calendar.getInstance();
        for (int field : new int[]{Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH, Calendar.HOUR, Calendar.MINUTE, Calendar.MILLISECOND}) {
            targetCalendar.set(field, sourceCalendar.get(field));
        }
        targetCalendar.setTimeZone(targetTimeZone);
        return dateFormatter.format(targetCalendar.getTime());
    }

    public static String addMinutesToDate(Date date, Integer mins) {
        DateFormat dateFormat = new SimpleDateFormat(DATE_TIME_24H_FORMAT2);
        dateFormat.setTimeZone(TimeZone.getTimeZone(TIMEZONE));
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE, mins);
        return dateFormat.format(cal.getTime());
    }

    public String getDateUTC(int numOfDays) {
        return this.getDateUTCFormat(numOfDays, "yyyy/MM/dd");
    }

    public String getDateString(int numOfDays, int numOfHours, int numOfMinutes, int numOfSeconds, String dateFormat) {
        DateFormat dateFormatter = new SimpleDateFormat(dateFormat);
        dateFormatter.setTimeZone(TimeZone.getTimeZone(TIMEZONE));
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DATE, numOfDays);
        cal.add(Calendar.HOUR_OF_DAY, numOfHours);
        cal.add(Calendar.MINUTE, numOfMinutes);
        cal.add(Calendar.SECOND, numOfSeconds);
        Date toDate = cal.getTime();
        return dateFormatter.format(toDate);
    }

    public String getDateString(int numOfDays, String dateFormat) {
        DateFormat dateFormatter = new SimpleDateFormat(dateFormat);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, numOfDays);
        Date toDate = cal.getTime();
        return dateFormatter.format(toDate);
    }

    public String getUTCDateString(int numOfHours) {
        SimpleDateFormat sdfmad = new SimpleDateFormat(DATE_FORMAT_NOW);
        sdfmad.setTimeZone(TimeZone.getTimeZone(TIMEZONE));

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.HOUR, numOfHours);

        String convertTime = sdfmad.format(cal.getTime());

        String[] rs = convertTime.split(" ");
        return String.format("%sT%sZ", rs[0], rs[1]);
    }

    public Date getDateWithDaysOffset(int numOfDays) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, numOfDays);
        return cal.getTime();
    }

    public String getDateString(Date date, String dateFormat) {
        DateFormat dateFormatter = new SimpleDateFormat(dateFormat);
        return dateFormatter.format(date);
    }

    /**
     * Generate random social security number
     *
     * @return Return the new random SSN with 9 digits
     */
    public String generateRandomSsn() {
        StringBuilder ssn = new StringBuilder();
        for (int i = 1; i <= 9; i++) {
            ssn.append(this.rand.nextInt(9));
        }
        return ssn.toString();
    }

    /**
     * Generate random string with fix length
     *
     * @return Return the new random SSN with given digits number
     */
    public String generateRandomStringOfFixLength(int diCount) {
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < diCount; i++) {
            char c = chars[this.rand.nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString();
    }

    /**
     * Generate random number with fix length
     *
     * @return generateRandomNumberOfFixLength
     */
    public String generateRandomNumberOfFixLength(int digCount) {
        StringBuilder sb = new StringBuilder(digCount);
        for (int i = 0; i < digCount; i++)
            sb.append((char) ('1' + this.rand.nextInt(8)));
        return sb.toString();
    }

    public static boolean isValidUTCFormatDate(String value) {

        Pattern p = Pattern.compile("\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}Z");
        Matcher m = p.matcher(value);
        return m.find();
    }

    /**
     * Generate random Alpha Number with fix length
     *
     * @param count integer
     * @return Retrieves String
     */
    public String generateRandomAlphaNumeric(int count) {
        return RandomStringUtils.randomAlphanumeric(count);
    }

    public String generateEmailAddressInString(int i) {
        String domain = "@mailinator.com";
        String empemail = RandomStringUtils.randomAlphanumeric(i) + "_" + this.generateUniqueNumber();
        return empemail.concat(domain);
    }

    /**
     * Generate random email with prefix
     *
     * @return String
     */
    public String generateEmailAddress(String name) {
        String domain = "@mailinator.com";
        String empemail = name + RandomStringUtils.randomAlphanumeric(3) + "_" + this.generateUniqueNumber();
        return empemail.concat(domain);
    }

    public String getMinuteTimeDuration(String startTime, String endTime, String formatDate) {
        SimpleDateFormat format = new SimpleDateFormat(formatDate);
        try {
            Date d1 = format.parse(startTime);
            Date d2 = format.parse(endTime);
            long diff = d2.getTime() - d1.getTime();
            long diffMinutes = TimeUnit.MILLISECONDS.toMinutes(diff);
            ExtentTestManager.logTestStep("Time in minutes: " + diffMinutes + " minutes.");
            return String.valueOf(diffMinutes);
        } catch (ParseException e) {
            LOGGER.error(e.getMessage());
            return "";
        }
    }

    public void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    public String getEnvironment(String envName) {
        return this.getTestEnvironment().get(envName);
    }

    public Environment getTestEnvironment() {
        return this.getTestConfig().getEnvironment();
    }

    private ExtentTest getExtentTest() {
        return ExtentTestManager.getTest();
    }

    public void logInfo(String message) {
        this.getExtentTest().info(message);
        LOGGER.info(message);
    }

    public synchronized void logPass(String message) {
        this.getExtentTest().pass("<b style='color:green;'>" + message + "");
        LOGGER.info(message);
    }

    public synchronized void logError(String message) {
        this.getExtentTest().log(Status.ERROR, message);
        LOGGER.error(message);
    }

    public TestConfiguration getTestConfig() {
        return TestContext.get();
    }

    public String readDataValue(String variableName) {
        try {
            return this.getTestConfig().getTestData().getValue(variableName);
        } catch (NullPointerException exp) {
            return null;
        }
    }

    public List<String> plusStringArray(List<String> original, List<String> newArray) {
        for (int i = 0; i <= newArray.size() - 1; i++) {
            original.add(newArray.get(i));
        }
        return original;
    }

    public boolean data1To9DigitsAndNoPaddedZero(String value) {
        char[] stringToCharArray = value.toCharArray();

        for (char output : stringToCharArray) {
            if (!Character.isDigit(output) || output == '0') {
                return false;
            }
        }
        return true;
    }

    //Example: ClientCustomID = 7 char "P" + 6 numeric P######
    public boolean dataCorrectFormat(char pre, String value, int expectedLength) {
        if (value.length() != expectedLength)
            return false;

        char[] stringToCharArray = value.toCharArray();
        int i = 0;
        for (char output : stringToCharArray) {
            if (i == 0) {
                if (output != pre)
                    return false;
                else {
                    i++;
                    continue;
                }
            }

            if (!Character.isDigit(output)) {
                return false;
            }
            i++;
        }
        return true;
    }

    public String getPastTime(int minutes) {
        return ZonedDateTime.now(ZoneId.of("America/New_York")).minusMinutes(minutes).format(DateTimeFormatter.ofPattern(DATE_TIME_24H_FORMAT2));
    }

    public int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        return this.rand.nextInt((max - min) + 1) + min;
    }

    public void generateJsonBody(String body, String name) throws IOException {
        try (FileWriter file = new FileWriter(name)) {
            file.write(body);
        }
    }

    public int getColDataOfFile(String fileName) {
        String lineInfo = "";
        try (BufferedReader br = new BufferedReader(new FileReader(DOWNLOAD_FOLDER + "/" + fileName))) {
            for (String line; (line = br.readLine()) != null; ) {
                lineInfo = line;
                break;
            }
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
        lineInfo = lineInfo.replace("\"", "");
        int cols = StringUtils.countMatches(lineInfo, "|");
        return cols + 1;
    }

    public void generateClaimValidationFile(String clientName,
                                            String clientId, String fileTemplate, String generatedFile) throws IOException {

        String content;
        if (new File(generatedFile).exists())
            content = this.readLineByLineJava8(generatedFile);
        else
            content = this.readLineByLineJava8(fileTemplate); // Reading the file template at the first time

        content = content.replace(clientName, clientId);
        try (FileWriter file = new FileWriter(generatedFile)) {
            file.write(content);
        }
    }

    public void generateToJemterFilePerformanceTestingVisit(List<String> visits) throws IOException {
        String content = this.readLineByLineJava8(BASE_FOLDER + File.separator + "PerformanceOpenEvvVisitTeamplate.jmx");

        for (int i = 0; i < visits.size(); i++) {
            content = content.replace("VISIT_FILE_" + (i + 1), visits.get(i));
        }

        DateFormat df = new SimpleDateFormat(DATE_TIME_24H_FORMAT);
        String data = df.format(new Date());
        this.generateJsonBody(content, BASE_FOLDER + File.separator + "PerformanceOpenEvvVisit" + data + ".jmx");
    }

    public void generateToJmeterFilePerformanceTestingSchedule(List<String> clientIds, List<String> fileList, List<String> accountList) throws IOException {
        String content = this.readLineByLineJava8(BASE_FOLDER + File.separator + JMETER_EXPORT_FILE);

        for (int i = 0; i < accountList.size(); i++) {
            content = content.replace(accountList.get(i) + ".txt", fileList.get(i));
            content = content.replace(accountList.get(i) + PREFIX, clientIds.get(i));
        }

        this.generateJsonBody(content, BASE_FOLDER + File.separator + "parametersLoadOpenEVVSchedule.csv");
    }

    public void generateToJmeterFilePerformanceTestingClient(List<String> prefix, List<String> fileList, List<String> accountList) throws IOException {
        String content = this.readLineByLineJava8(BASE_FOLDER + File.separator + JMETER_EXPORT_FILE);

        for (int i = 0; i < accountList.size(); i++) {
            content = content.replace(accountList.get(i) + ".txt", fileList.get(i));
            content = content.replace(accountList.get(i) + PREFIX, prefix.get(i));
        }

        this.generateJsonBody(content, BASE_FOLDER + File.separator + "parametersLoadOpenEVVClient.csv");
    }

    public void generateToJmeterFilePerformanceTestingEmployee(List<String> prefix, List<String> fileList, List<String> accountList) throws IOException {
        String content = this.readLineByLineJava8(BASE_FOLDER + File.separator + JMETER_EXPORT_FILE);

        for (int i = 0; i < accountList.size(); i++) {
            content = content.replace(accountList.get(i) + ".txt", fileList.get(i));
            content = content.replace(accountList.get(i) + PREFIX, prefix.get(i));
        }

        this.generateJsonBody(content, BASE_FOLDER + File.separator + "parametersLoadOpenEVVEmp.csv");
    }

    public String readLineByLineJava8(String filePath) {
        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines( Paths.get(filePath), StandardCharsets.UTF_8))
        {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }

    public String readLineByLineJava8ForFullPath(String filePath) {
        return this.readLineByLineJava8(BASE_FOLDER + File.separator + filePath);
    }

    public void loggerConsole(String mess) {
        LOGGER.debug(mess);
    }

    public String getDateFormatNow (){return DATE_FORMAT_NOW;}

    public String getDateFormat24h (){return DATE_TIME_24H_FORMAT2;}

    public boolean validateActualAndExpectedText(String actual, String expected, String field) {
        ExtentTestManager.getTest().info("Verify value of field: " + field);
        String responseMessage = this.returnResponseMessage(actual, expected);
        if (actual == null || expected == null) {
            Assert.assertTrue(StringUtils.equals(actual, expected), "actual text: [" + actual + "]  " +
                    "AND  expected: [" + expected + "]");
            ExtentTestManager.getTest().pass("Text Validation Passed.  " + responseMessage);
        } else {
            if (expected.trim().equalsIgnoreCase(actual.trim())) {
                ExtentTestManager.getTest().pass("Text Validation Passed.  " + responseMessage);
            } else {
                ExtentTestManager.getTest().fail("Text Validation Failed .  " + responseMessage);
            }
        }
        return true;
    }

    public String returnResponseMessage(String actual, String expected) {
        return "actual text: [" + actual + "]  AND  expected: [" + expected + "]";
    }

    public enum AccountType {
        CDS("CDS"),
        AMP("AMP"),
        AMP_WS("AMP_WS"),
        ALT("ALT"),
        GENERIC("Generic");
        private final String value;

        AccountType(String value) {
            this.value = value;
        }
        @Override
        public String toString() {
            return this.value;
        }
    }
}

