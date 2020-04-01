package com.interop.services.openevv.batch;

import com.google.gson.Gson;
import com.interop.common.constants.utils.db.AuthDBUtils;
import com.interop.models.DbAccountTransModel;
import com.interop.models.openevv.batch.BatchClaimCSVModel;
import com.interop.models.openevv.batch.ErrorAndRespCSVModel;
import com.interop.models.openevv.batch.InboundCSVModel;
import com.jcraft.jsch.SftpException;
import com.sandata.batch.OracleColumnMapper;
import com.sandata.core.Wrapper;
import com.sandata.core.config.TestConfiguration;
import com.sandata.core.config.TestContext;
import com.sandata.utilities.CSVReader;
import com.sandata.utilities.CsvAnnotationMapper;
import com.sandata.utilities.CsvUtil;
import org.apache.commons.collections4.BidiMap;
import org.apache.log4j.Logger;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static com.interop.common.constants.Constant.*;
import static com.interop.common.constants.FieldConstants.MAX_TIME_ATTEMPT;
import static com.interop.common.constants.utils.ZipFileUtils.unzip;
import static com.interop.common.constants.utils.ZipFileUtils.zip;
import static com.sandata.utilities.sftp.utils.SftpUtils.*;
import static java.io.File.separator;

public abstract class ImportServices {
    public static final Logger LOGGER = Logger.getLogger(ImportServices.class);
    public static final TestConfiguration config = TestContext.get();
    protected List records;
    protected List<File> listFileCSV = new ArrayList<>();
    protected List<File> listFileUpload = new ArrayList<>();
    protected Wrapper baseObj;
    protected List<String> csvHeaders;
    protected DateTimeFormatter dateTimeFormatter;
    private File fileTemplate;
    private LocalDateTime currentDate = LocalDateTime.now();
    private String informMsg = "System show exception";

    public static void verifyErrorMessageForTheSingleRecord(String errorMessage, String errorFileName) {
        CSVReader.setDefaultDelimiter("|");
        CSVReader.setDefaultQuote('"');
        CSVReader reader = CSVReader.readCSVFile(DOWNLOADED_FILES + errorFileName.subSequence(0, errorFileName.length() - 4));
        List rows = reader.getDataRows();
        for (Object row : rows) {
            LOGGER.info("Starting compare error message in file error");
            LOGGER.info(String.format("The expectation error message is %s", errorMessage));
            Assert.assertTrue(((ArrayList) row).get(reader.getHeaders().indexOf("Error Description")).toString().contains(errorMessage));
        }
    }

    public void verifyErrorMessageInFileErrorWithListMsgInBatchClaim(List<BatchClaimCSVModel> listExpectError, List<ErrorAndRespCSVModel> recordsFileError) {
        List<String> missLines = new ArrayList<>();
        for (BatchClaimCSVModel batchClaimCSVModel : listExpectError) {
            String key = batchClaimCSVModel.getModifier1();
            Optional<ErrorAndRespCSVModel> responseObject = recordsFileError.stream().filter(o -> o.getModifier1().equals(key)).findFirst();
            if (responseObject.isPresent()) {
                compareErrorMessage(Integer.parseInt(key), batchClaimCSVModel.getExpectedError(), responseObject.get().getDetailsReason());
            } else {
                missLines.add(key);
            }
        }
        if (!missLines.isEmpty()) {
            baseObj.fail("[*] Missing line : " + String.join(",", missLines) + ". So failed validation rule");
        }
    }

    private void compareErrorMessage(int lineIndex, String expectMessage, String messageInFile) {
        baseObj.info(String.format("Verify data in line %s", lineIndex));
        verifyResultCompareErrorMessage(expectMessage, messageInFile);
    }

    public int compareTextsWithSpecificIndex(int lineIndex, String expectMessage, String messageInFile) {
        baseObj.info(String.format("Verify data in line %s", lineIndex++ + 1));
        verifyResultCompareErrorMessage(expectMessage, messageInFile);
        return lineIndex;
    }

    private void verifyResultCompareErrorMessage(String expectMessage, String messageInFile){
        Assert.assertTrue(messageInFile.contains(expectMessage), "actual text: [" + messageInFile + "]  " +
                "\n AND  expected: [" + expectMessage + "]");
        baseObj.pass("Text Validation Passed.  " +
                "actual text: [" + messageInFile + "] \n AND expected: [" + expectMessage + "]");
    }

    public void verifyErrorMessageInFileErrorWithListMsgInFleError(List<String> listExpectError, String errorFileName) {
        CSVReader.setDefaultDelimiter("|");
        CSVReader.setDefaultQuote('"');
        CSVReader reader = CSVReader.readCSVFile(DOWNLOADED_FILES + errorFileName.subSequence(0, errorFileName.length() - 4));
        List rows = reader.getDataRows();
        int lineIndex = 0;
        for (int i = 0, listRecord = listExpectError.size(); i < listRecord; i++) {
            String expectMessage = listExpectError.get(i);
            String messageInFile = String.valueOf(((ArrayList) rows.get(i)).get(reader.getHeaders().indexOf("Error Description")));
            lineIndex = compareTextsWithSpecificIndex(lineIndex, expectMessage, messageInFile);
        }
    }

    public void uploadFileToServer(List<File> listFileUpload, String dstPATH) throws InterruptedException, SftpException, IOException {
        baseObj.info(" Upload file to SFTP server");
        for (File file : listFileUpload) {
            sftpSendFile(file.getPath(), dstPATH);
        }
    }

    public List<ErrorAndRespCSVModel> parseLineFileErrorOrRespToModel(String fileName) throws InvocationTargetException, InstantiationException, IllegalAccessException, IOException {
        CSVReader.setDefaultDelimiter("|");
        CSVReader.setDefaultQuote('"');
        LOGGER.info("Starting parse all line in CSV error file to object model");
        return CsvAnnotationMapper.mapDataToModel(ErrorAndRespCSVModel.class, new File(DOWNLOADED_FILES + fileName), DEFAULT_DELIMITER);
    }

    public List<InboundCSVModel> parseLineFileInboundToModel(String inboundFileName) throws InvocationTargetException, InstantiationException, IllegalAccessException, IOException {
        CSVReader.setDefaultDelimiter("|");
        CSVReader.setDefaultQuote('"');
        LOGGER.info("Starting parse all line in CSV error file to object model");
        return CsvAnnotationMapper.mapDataToModel(InboundCSVModel.class, new File(DOWNLOADED_FILES + inboundFileName), DEFAULT_DELIMITER);
    }

    public void verifyRecordCountInboundFile(String successCount, String failedCount, String inboundFileName) throws IOException, InstantiationException, IllegalAccessException, InvocationTargetException {
        CSVReader.setDefaultDelimiter("|");
        CSVReader.setDefaultQuote('"');
        List<InboundCSVModel> listRecord = parseLineFileInboundToModel(inboundFileName);
        Assert.assertEquals(listRecord.get(0).getSuccessCount(), successCount, "Success Count is not correct");
        Assert.assertEquals(listRecord.get(0).getFailedCount(), failedCount, "Fail Count is not correct");
    }

    public DateTimeFormatter getDateTimeFormatter() {
        return dateTimeFormatter;
    }

    void setDateTimeFormatter(String patternFormat) {
        this.dateTimeFormatter = DateTimeFormatter.ofPattern(patternFormat);
    }

    public List getRecords() {
        return records;
    }

    public void setRecords(List records) {
        this.records = records;
    }

    public List<File> getListFileCSV() {
        return listFileCSV;
    }

    public List<File> getListFileUpload() {
        return listFileUpload;
    }

    public void setListFileUpload(List<File> listFileUpload) {
        this.listFileUpload = listFileUpload;
    }

    public <T> void init(Class<T> clazz) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        baseObj = new Wrapper();
        this.loadFileTemplate();
        try {
            csvHeaders = this.getCsvHeaders();
            records = this.getRecordsFromCSV(clazz);
        } catch (IOException e) {
            LOGGER.error(String.format("Cannot found the file template: %s", e));
        }
    }

    String generateCurrentDateTimeWithGenericPattern() {
        return dateTimeFormatter.format(currentDate);
    }

    protected abstract String getTemplatePath();

    private void loadFileTemplate() {
        this.fileTemplate = new File(DEFAULT_FOLDER + separator + getTemplatePath());
    }

    protected void zipGeneratedFile(List<File> files) throws IOException {
        for (File file : files) {
            //File outbound does not need to zip before upload
            if (!file.getName().contains("EVV_Outbound_ControlFile")) {
                String targetPath = file.getPath() + ZIP_EXTENSION;
                zip(targetPath, file);
                listFileUpload.add(new File(targetPath));
            } else {
                listFileUpload.add(file);
            }
        }
    }

    public List<String> getCsvHeaders() throws IOException {
        return CsvUtil.getCsvHeader(fileTemplate);
    }

    public void setCsvHeaders(List<String> csvHeaders) {
        this.csvHeaders = csvHeaders;
    }

    private <T> List getRecordsFromCSV(Class<T> clazz) throws IOException, IllegalAccessException, InstantiationException, InvocationTargetException {
        return CsvAnnotationMapper.mapDataToModel(clazz, fileTemplate, DEFAULT_DELIMITER);
    }

    private String generateFileName(ImportType importType) {
        setDateTimeFormatter(GENERIC_PATTERN);
        return String.format(importType.getFileNameTemplate(), generateCurrentDateTimeWithGenericPattern());
    }

    void generateFile(ImportType importType, List<String> csvHeaders, List records) {
        String filePath = RESOURCE_FILE_GENERATED + this.generateFileName(importType);
        LOGGER.info(String.format("Starting generated file import for %s", importType));
        try {
            File file = CsvUtil.writeCsvFromListModel(records, csvHeaders, filePath);
            listFileCSV.add(file);
        } catch (IOException e) {
            LOGGER.error("File is not existed" + e);
        } catch (IllegalAccessException e) {
            LOGGER.error(String.format("Do not find any line records in template with exception %s", e));
        }
    }

    protected void modifyFieldPropertyOfRecords(List<?> objectList) {
        if (!objectList.isEmpty() && objectList.size() == getRecords().size()) {
            for (int i = 0; i < getRecords().size(); i++) {
                Object o = objectList.get(i);
                Object lineRecord = getRecords().get(i);
                for (Field f : o.getClass().getDeclaredFields()) {
                    Object value = null;
                    try {
                        value = f.get(o);
                    } catch (IllegalAccessException e) {
                        baseObj.error(informMsg, e);
                    }
                    setValueToObject(lineRecord, f, value);
                }
            }
        } else {
            baseObj.info("Number of line info does not match with number of line records");
        }
    }

    private void setValueToObject(Object lineRecord, Field f, Object value) {
        if (value != null) {
            try {
                OracleColumnMapper.setFieldValue(lineRecord, f, (String) value);
            } catch (IllegalAccessException | InvocationTargetException e) {
                baseObj.error(informMsg, e);
            }
        }
    }

    public String generateErrorFileName(String type, List<File> files) {
        int tempIndex = 0;
        for (File file : files) {
            String fileName = file.getName();
            if (fileName.contains(type)) {
                StringBuilder buffer = new StringBuilder(fileName);
                int x = 0;
                for (int i = 0; i <= fileName.length(); i++) {
                    char ch = fileName.charAt(i);
                    if (ch == '_') {
                        x++;
                    }
                    if (x == 3) {
                        tempIndex = i;
                        StringBuilder errorFile = buffer.insert(tempIndex + 1, "Error_");
                        return errorFile.toString();
                    }
                }
            }
        }
        return null;
    }

    public String generateInboundFileName(String type, List<File> files) {
        for (File file : files) {
            String fileName = file.getName();
            if (fileName.contains(type)) {
                StringBuilder buffer = new StringBuilder(fileName);
                int x = 0;
                for (int i = 0; i <= fileName.length(); i++) {
                    char ch = fileName.charAt(i);
                    if (ch == '_') {
                        x++;
                    }
                    if (x == 3) {
                        StringBuilder errorFile = buffer.replace(10, 18, "Inbound");
                        return errorFile.toString();
                    }
                }
            }
        }
        return null;
    }

    public List<String> generateAllResponseFilesForClaim(List<File> files) {
        List<String> listResponseFiles = new ArrayList<>();
        for (File file : files) {
            String fileName = file.getName();
            if (fileName.contains("Req")) {
                String fileResp = fileName.replace("Req", "Resp");
                String fileError = fileName.replace("Req", "Error");
                listResponseFiles.add(fileError);
                listResponseFiles.add(fileResp);
            }
            String outbound = "Outbound";
            if (fileName.contains(outbound)) {
                String fileInbound = fileName.replace(outbound, "Inbound");
                listResponseFiles.add(fileInbound);
            }
        }
        return listResponseFiles;
    }

    public abstract void generateFileWithMultipleLine(int numberLine);

    public String generateDistinct13CharsValue() throws InterruptedException {
        Thread.sleep(1000);//Make sure to generate distinct value
        setDateTimeFormatter("MMddHHSSSmmyy");
        LocalDateTime currentDateTime = LocalDateTime.now();
        return this.getDateTimeFormatter().format(currentDateTime);
    }

    public boolean isTheFileImportProcessed(String filename) {
        baseObj.info(String.format("Check is the file %s processed on System", filename));
        BidiMap<String, String> dataTransfer = AuthDBUtils.getListFilesProcessed();
        Set<String> listDescription = dataTransfer.values();
        boolean isFileProcessedSuccess = false;
        for (String descriptionDetail : listDescription) {
            DbAccountTransModel model = new Gson().fromJson(descriptionDetail, DbAccountTransModel.class);
            if (filename.equalsIgnoreCase(model.getFileName()) && model.getStatus().equalsIgnoreCase("Reading file to the end and no exceptions happen in the middle")) {
                isFileProcessedSuccess = true;
            }
        }
        return isFileProcessedSuccess;
    }

    public void downloadSpecificFileFromSFTPForOpenEVV(String fileName, FileType type) throws InterruptedException {
        String patchDownloadFileResponseOpenEVV = config.getEnvironment("Default_folder_Get_Error_SFTP");
        boolean isTheFileExistedOnSFTP = isSftpFileExisted(patchDownloadFileResponseOpenEVV + fileName, MAX_TIME_ATTEMPT);
        if (isTheFileExistedOnSFTP) {
            try {
                if (type.equals(FileType.ZIP)) {
                    getFile(patchDownloadFileResponseOpenEVV, FileType.ZIP, fileName, DOWNLOADED_FILES);
                    unzip(new File(DOWNLOADED_FILES + fileName), DOWNLOADED_FILES);
                } else {
                    getFile(patchDownloadFileResponseOpenEVV, FileType.CSV, fileName, DOWNLOADED_FILES);
                }
            } catch (Exception e) {
                LOGGER.error("File is not existed" + e);
            }
        } else {
            Assert.fail(String.format("The file %s is not existed on SFTP server", fileName));
        }
    }

    public void removeColumn(String columnName) throws java.io.IOException {
        List<String> modifiedHeader = this.getCsvHeaders();
        modifiedHeader.remove(columnName);
        this.csvHeaders = modifiedHeader;
    }

    public void addColumn(String columnName) throws java.io.IOException {
        List<String> modifiedHeader = this.getCsvHeaders();
        modifiedHeader.add(columnName);
        this.csvHeaders = modifiedHeader;
    }

    public enum ImportType {
        PROVIDER("Provider", config.getEnvironment("Template_FileName_Provider")),
        OUTBOUND("Outbound", config.getEnvironment("Template_FileName_outbound")),
        MEMBER("Member", config.getEnvironment("Template_FileName_member")),
        CLAIM_VALIDATION("Claim", config.getEnvironment("Template_File_Claim_Request")),
        AUTHORIZATION("Auth", config.getEnvironment("Template_FileName_auth")),
        POC("POC", config.getEnvironment("Template_FileName_planOfCare"));
        private String fileType;
        private String fileNameTemplate;

        ImportType(String fileType, String fileNameTemplate) {
            this.fileType = fileType;
            this.fileNameTemplate = fileNameTemplate;
        }

        public String getFileType() {
            return fileType;
        }

        public String getFileNameTemplate() {
            return fileNameTemplate;
        }
    }
}
