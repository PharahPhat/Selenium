package com.interop.services.openevv.batch;

import com.google.gson.Gson;
import com.interop.common.Commons;
import com.interop.common.StateAccount;
import com.interop.common.TestDataHelper;
import com.interop.data.claim.ClaimDataRecord;
import com.interop.models.claim.ClaimModel;
import com.interop.models.claim.MatchingRule;
import com.interop.models.claim.ModelVersion;
import com.interop.models.claim.UnitsRule;
import com.interop.models.db.stx.STXVisit_Claim;
import com.interop.models.openevv.batch.BatchClaimCSVModel;
import com.sandata.utilities.ColumnAnnotationMapper;
import com.sandata.utilities.CsvAnnotationMapper;
import com.sandata.utilities.CsvUtil;
import com.sandata.utilities.DbUtilsCon;
import com.sandata.ws.pa.unitcalculation.UnitCalculationHelper;
import org.apache.commons.csv.CSVParser;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.interop.common.constants.Constant.RESOURCE_FILE_GENERATED;
import static com.interop.common.constants.FieldConstants.CLIENT_CUSTOM_ID1;
import static com.interop.common.constants.queries.InterOpMySQL.MY_SQL_GET_CONFIG_CLAIM_FOR_ACCOUNT_INTERFACE;
import static com.interop.common.constants.queries.InterOpOracle.*;
import static com.interop.sql.ClientSQL.sql_getClientCustom1ByLastName;

public class ImportClaimServices extends ImportServices {
    private String state = StateAccount.loadStateAccount().getStateName();
    protected Commons commons = new Commons();
    private String batchClaimFileData;
    private ModelVersion modelVersion;
    private String baseFolder = System.getProperty("user.dir") + File.separator + "TestData"
            + File.separator + this.state + File.separator;
    private String csvExt = ".csv";
    private String medicaidIDText ="MEDICAID_ID";

    public ImportClaimServices() throws IllegalAccessException, InstantiationException, InvocationTargetException {
        this.init(BatchClaimCSVModel.class);
    }

    public static List<STXVisit_Claim> getDistinctVisitWithSpecificStatusOnAccount(String account, String status) {
        ColumnAnnotationMapper<STXVisit_Claim> mapper = new ColumnAnnotationMapper<>(STXVisit_Claim.class);
        String getQuery = String.format(GET_UNIQUE_INDAY_VISIT_WITH_SPECIFIC_STATUS_ON_SPECIFIC_ACCOUNT, account, status);
        ResultSet rs = DbUtilsCon.getResultSetFromQuery(TestDataHelper.getOraConnection(), getQuery);
        return mapper.DataTableMapper(rs);
    }

    public static List<STXVisit_Claim> listProcessedVisitHavingSpecificServices(String account, String servicesID) {
        ColumnAnnotationMapper<STXVisit_Claim> mapper = new ColumnAnnotationMapper<>(STXVisit_Claim.class);
        String getQuery = String.format(GET_VISIT_WITH_SPECIFIC_SERVICE, account, servicesID);
        ResultSet rs = DbUtilsCon.getResultSetFromQuery(TestDataHelper.getOraConnection(), getQuery);
        return mapper.DataTableMapper(rs);
    }

    public static STXVisit_Claim getVisitByVisitKey(String visitKey) {
        ColumnAnnotationMapper<STXVisit_Claim> mapper = new ColumnAnnotationMapper<>(STXVisit_Claim.class);
        String getQuery = String.format(GET_VISIT_BASED_ON_VISIT_KEY, visitKey);
        ResultSet rs = DbUtilsCon.getResultSetFromQuery(TestDataHelper.getOraConnection(), getQuery);
        return mapper.DataTableMapper(rs).get(0);
    }

    public static List<STXVisit_Claim> listVisitOmitOrInComplete(String account) {
        ColumnAnnotationMapper<STXVisit_Claim> mapper = new ColumnAnnotationMapper<>(STXVisit_Claim.class);
        String getQuery = String.format(GET_OMIT_OR_INCOMPLETE_VISITS, account);
        ResultSet rs = DbUtilsCon.getResultSetFromQuery(TestDataHelper.getOraConnection(), getQuery);
        return mapper.DataTableMapper(rs);
    }

    public static String getIDServiceBatchClaimValidationV2() {
        String mySQLQuery = String.format(MY_SQL_GET_CONFIG_CLAIM_FOR_ACCOUNT_INTERFACE, StateAccount.loadStateAccount().getAccountTemplate(), ImportServices.config.getEnvironment("accountInterfaceName"));
        try (ResultSet rs = DbUtilsCon.getResultSetFromQuery(TestDataHelper.getMySQLConnection(), mySQLQuery)) {
            while (rs.next()) {
                return rs.getString("account_intf_conf_sk");
            }
        } catch (SQLException e) {
            LOGGER.info("Cannot get record", e);
        }
        return null;
    }

    public String getBatchClaimFileData() {
        return this.batchClaimFileData;
    }

    public void setBatchClaimFileData(String batchClaimFileData) {
        this.batchClaimFileData = batchClaimFileData;
    }

    public ModelVersion getModelVersion() {
        return this.modelVersion;
    }

    public void setModelVersion(ModelVersion modelVersion) {
        this.modelVersion = modelVersion;
    }

    private List<ClaimDataRecord> readVisitInfoFromCsvFile(String batchClaimFileData) throws IOException {
        String pathName = this.baseFolder + batchClaimFileData + this.csvExt;
        return this.filterToGetValidInfoVisitToClaim(this.convertDataVisitFromCsvToObject(pathName));
    }

    private List<ClaimDataRecord> filterToGetValidInfoVisitToClaim(List<ClaimDataRecord> claimRecords) {
        List<ClaimDataRecord> recordsFilter = new ArrayList<>();
        Field[] fields = ClaimDataRecord.class.getDeclaredFields();
        for (ClaimDataRecord claimRecord : claimRecords) {
            for (Field field : fields) {
                try {
                    field.setAccessible(true);
                    Object value = field.get(claimRecord);
                    if (value instanceof String) {
                        String trimmed = (String) value;
                        field.set(claimRecord, trimmed.trim());
                    }
                } catch (Exception e) {
                    this.baseObj.info("Cannot convert CSV to object");
                }
            }
            String duration = claimRecord.getDuration().trim();
            if (!duration.isEmpty()) { // claim record
                recordsFilter.add(claimRecord);
            }
        }
        return recordsFilter;
    }

    private List<ClaimDataRecord> convertDataVisitFromCsvToObject(String pathName) throws IOException {
        List<ClaimDataRecord> claimRecords;
        CSVParser recordParser = CsvUtil.readCSVRecords(new File(pathName), ',', false);
        CsvAnnotationMapper<ClaimDataRecord> clientMapper = new CsvAnnotationMapper<>(ClaimDataRecord.class);
        claimRecords = clientMapper.map(recordParser);
        recordParser.close();
        return claimRecords;
    }

    public List <ClaimModel> getVisitDataFromTestData(ModelVersion modelVersion, String pathFile) throws IOException {
        List <ClaimModel> listClaimVisitInFileData = new ArrayList<>();
        for (ClaimDataRecord record : this.readVisitInfoFromCsvFile(pathFile)) {
            listClaimVisitInFileData.add(this.convertCsvObjectToClaimModel(modelVersion,record));
        }
        return listClaimVisitInFileData;
    }

    private ClaimModel convertCsvObjectToClaimModel(ModelVersion modelVersion, ClaimDataRecord record) {
        ClaimModel claim = ClaimModel.generateClaimModel(StateAccount.loadStateAccount(), modelVersion);
        Map<String, String> clientInfo = this.getClientInfo(StateAccount.loadStateAccount().getAccountID(), record.getClientFirstName());
        String clientMedicaidId = clientInfo.get(this.medicaidIDText);
        claim.setPatientID(clientMedicaidId);
        claim.setServiceStartDate(record.getServiceStartDate());
        claim.setServiceEndDate(record.getServiceEndDate());
        claim.setProcedureCode(record.getProcedureCode());
        claim.setUnits(UnitCalculationHelper.calculateUnit(record.getProcedureCode(), Integer.parseInt(record.getDuration())));
        claim.setMatchingRule(MatchingRule.valueOf(record.getMatchingRule().toUpperCase()));
        claim.setUnitsRule(UnitsRule.valueOf(record.getUnitsRule().toUpperCase()));
        return claim;
    }

    private Map<String, String> getClientInfo(String account, String clientFName) {
        Map<String, String> clientInfo = new HashMap<>();
        String sqlQuery = String.format(sql_getClientCustom1ByLastName, account, clientFName);
        ResultSet rs = DbUtilsCon.getResultSetFromQuery(TestDataHelper.getOraConnection(), sqlQuery);
        try {
            if (rs.next()) {
                String clientIdCustom1 = rs.getString(CLIENT_CUSTOM_ID1);
                String clientMedicaidID = rs.getString(this.medicaidIDText);
                clientInfo.put(this.medicaidIDText, clientMedicaidID);
                clientInfo.put(CLIENT_CUSTOM_ID1, clientIdCustom1);
            }
        } catch (SQLException e) {
            this.baseObj.error("SQL Exception when get client info", e);
        }
        return clientInfo;
    }

    @Override
    protected String getTemplatePath() {
        return "templateCSV/templateBatchClaim.csv";
    }

    @Override
    public void generateFileWithMultipleLine(int numberLine) {
        BatchClaimCSVModel original = (BatchClaimCSVModel) this.records.get(0);
        Gson gson = new Gson();
        for (int i = 1; i < numberLine; i++) {
            BatchClaimCSVModel temp = gson.fromJson(gson.toJson(original), BatchClaimCSVModel.class);
            this.records.add(temp);
        }
    }

    public void prepareFileRequest(String batchID, List<BatchClaimCSVModel> claimRequests) {
        String filePath = RESOURCE_FILE_GENERATED + this.generateFileNameClaimRequest(batchID);
        this.modifyFieldPropertyOfRecords(claimRequests);
        LOGGER.info(String.format("Starting generated file import for %s", filePath));
        try {
            File file = CsvUtil.writeCsvFromListModel(this.records, this.csvHeaders, filePath);
            this.listFileCSV.add(file);
        } catch (IOException e) {
            LOGGER.error("File is not existed" + e);
        } catch (IllegalAccessException e) {
            LOGGER.error(String.format("Do not find any line records in template with exception %s", e));
        }
    }

    private String generateFileNameClaimRequest(String batchID) {
        this.setDateTimeFormatter("yyyyMMdd_hhmmss.SSS");
        return String.format(ImportType.CLAIM_VALIDATION.getFileNameTemplate(), this.generateCurrentDateTimeWithGenericPattern(), batchID);
    }

    public void initTestDataImportClaim(List<BatchClaimCSVModel> claimRequests) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        this.baseObj.info("Prepare file test data for import Batch Claim");
        String batchIDGetFromFile = claimRequests.get(0).getBatchID();
        this.prepareFileRequest(batchIDGetFromFile, claimRequests);
        ImportOutboundService outboundService = new ImportOutboundService();
        outboundService.prepareFileOutboundClaim(this.listFileCSV, batchIDGetFromFile);
        this.listFileCSV.addAll(outboundService.getListFileCSV());
    }

    public String generateBatchID() throws InterruptedException {
        Thread.sleep(1000);//Make sure to generate distinct value
        this.setDateTimeFormatter("yyyyMMddhhmmssSSS");
        LocalDateTime currentDateTime = LocalDateTime.now();
        return this.getDateTimeFormatter().format(currentDateTime);
    }

    public enum indexFileInListFileGenerated {
        ERROR(0),
        REQUEST(3),
        RESPONSE(1),
        INBOUND(2);

        private int index;

        indexFileInListFileGenerated(int index) {
            this.index = index;
        }

        public int getIndex() {
            return this.index;
        }
    }
}
