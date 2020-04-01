package com.interop.services.openevv.batch;

import com.google.inject.internal.util.$Nullable;
import com.interop.models.openevv.batch.AuthorizationCSVModel;
import com.interop.models.openevv.batch.BatchClaimCSVModel;
import com.sandata.utilities.CSVReader;
import com.sandata.utilities.CsvUtil;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import static com.interop.common.constants.Constant.DOWNLOADED_FILES;
import static com.interop.common.constants.Constant.RESOURCE_FILE_GENERATED;

public class ImportCustomFiles<T> extends ImportServices {
    private String pathFile;

    public ImportCustomFiles(Class<T> clazz, String pathFile) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        setPathFile(pathFile);
        init(clazz);
    }

    public String getPathFile() {
        return pathFile;
    }

    public void setPathFile(String pathFile) {
        this.pathFile = pathFile;
    }

    @Override
    protected String getTemplatePath() {
        return getPathFile();
    }

    @Override
    public void generateFileWithMultipleLine(int numberLine) {
        throw new UnsupportedOperationException();
    }

    private void prepareFileImport(List<?> fileInfo, ImportType typeImport) {
        baseObj.info("Generate File valid import with specific template");
        if (!fileInfo.isEmpty()) {
            this.modifyFieldPropertyOfRecords(fileInfo);
        }
        generateFile(typeImport, this.csvHeaders, this.records);
    }

    public void prepareFileImportCustomAndOutboundFile(List<?> fileInfo, ImportType typeImport) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        baseObj.info("Prepare file test data for import custom");
        this.prepareFileImport(fileInfo, typeImport);
        ImportOutboundService outboundService = new ImportOutboundService();
        outboundService.prepareFileOutbound(this.listFileCSV);
        this.listFileCSV.addAll(outboundService.getListFileCSV());
        try {
            zipGeneratedFile(listFileCSV);
        } catch (IOException e) {
            baseObj.error("Having exception when trying to zip the generated file", e);
        }
    }

    public void initTestDataImportClaim(@$Nullable List<BatchClaimCSVModel> claimRequests, String batchID) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        baseObj.info("Prepare file test data for import Batch Claim");
        this.prepareFileRequest(claimRequests, batchID);
        ImportOutboundService outboundService = new ImportOutboundService();
        outboundService.prepareFileOutboundClaim(this.listFileCSV, claimRequests.get(0).getBatchID());
        this.listFileCSV.addAll(outboundService.getListFileCSV());
    }

    public void prepareFileRequest(List<?> requestList, String batchID) {
        String filePath = RESOURCE_FILE_GENERATED + this.generateFileNameClaimRequest(batchID);
        LOGGER.info(String.format("Starting generated file import for %s", filePath));
        try {
            if (!requestList.isEmpty()) {
                modifyFieldPropertyOfRecords(requestList);
            }
            File file = CsvUtil.writeCsvFromListModel(this.records, this.csvHeaders, filePath);

            listFileCSV.add(file);
        } catch (IOException e) {
            LOGGER.error("File is not existed" + e);
        } catch (IllegalAccessException e) {
            LOGGER.error(String.format("Do not find any line records in template with exception %s", e));
        }
    }

    private String generateFileNameClaimRequest(String batchID) {
        setDateTimeFormatter("yyyyMMdd_hhmmss.SSS");
        return String.format(ImportType.CLAIM_VALIDATION.getFileNameTemplate(), generateCurrentDateTimeWithGenericPattern(), batchID);
    }

    public void verifyErrorMessageAuthFile(List<AuthorizationCSVModel> importFileRecords, String errorFileName) {
        CSVReader.setDefaultDelimiter("|");
        CSVReader.setDefaultQuote('"');
        CSVReader reader = CSVReader.readCSVFile(DOWNLOADED_FILES + errorFileName.subSequence(0, errorFileName.length() - 4));
        List rows = reader.getDataRows();
        int lineIndex = 0;
        String cmt;
        if(importFileRecords.size()==rows.size()){
            for(AuthorizationCSVModel importRecord : importFileRecords){
                for(int i = 0; i<rows.size(); i++){
                    cmt = String.valueOf(((ArrayList) rows.get(i)).get(reader.getHeaders().indexOf("AuthorizationComments")));
                    if(!importRecord.getAuthorizationComments().equalsIgnoreCase(cmt)){
                        continue;
                    }else{
                        baseObj.info("going to validate record with Authorization comment is :" + importRecord.getAuthorizationComments());
                        lineIndex = compareTextsWithSpecificIndex(lineIndex, importRecord.getErrorDescription(),String.valueOf(((ArrayList) rows.get(i)).get(reader.getHeaders().indexOf("Error Description"))));
                    }
                }
            }
        }else baseObj.fail("Number of records in error file NOT equal to imported file");
    }
}
