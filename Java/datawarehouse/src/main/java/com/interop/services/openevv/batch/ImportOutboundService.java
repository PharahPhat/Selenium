package com.interop.services.openevv.batch;

import com.google.gson.Gson;
import com.interop.models.openevv.batch.OutboundCSVModel;
import com.sandata.utilities.CsvUtil;
import org.apache.log4j.Logger;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import static com.interop.common.constants.Constant.RESOURCE_FILE_GENERATED;

public class ImportOutboundService extends ImportServices {
    public static final Logger LOGGER = Logger.getLogger(ImportOutboundService.class);

    private int totalFileProcess;

    public ImportOutboundService() throws IllegalAccessException, InstantiationException, InvocationTargetException {
        this.init(OutboundCSVModel.class);
    }

    @Override
    protected String getTemplatePath() {
        return "templateCSV/templateOutBound.csv";
    }

    @Override
    public void generateFileWithMultipleLine(int numberLine) {
        OutboundCSVModel original = (OutboundCSVModel) this.records.get(0);
        Gson gson = new Gson();
        for (int i = 1; i < numberLine; i++) {
            OutboundCSVModel temp = gson.fromJson(gson.toJson(original), OutboundCSVModel.class);
            this.records.add(temp);
        }
    }

    public void prepareFileOutbound(List<File> csvFiles) {
        for (File file : csvFiles) {
            this.declareFilesToImport(this.records, file);
        }
        this.generateFile(ImportType.OUTBOUND, this.csvHeaders, this.records);
        this.addOutboundFileAndImportDateToLastLines(this.listFileCSV.get(0));
    }

    private void declareFilesToImport(List<OutboundCSVModel> outboundRecords, File... files) {
        this.totalFileProcess = files.length;
        int lineIndexInOutboundFile = 0;
        for (File file : files) {
            try (FileReader readerFile = new FileReader(file);
                 LineNumberReader lineReader = new LineNumberReader(readerFile)) {
                int numberRecordCount = this.getNumberRecordCountInFileImport(lineReader) - 1;
                LOGGER.info(String.format("Total record count in file import/request: %d", numberRecordCount));
                outboundRecords.get(lineIndexInOutboundFile).setFilename(file.getName());
                outboundRecords.get(lineIndexInOutboundFile).setRecordCount((String.valueOf(numberRecordCount)));
                lineIndexInOutboundFile++;
            } catch (IOException e) {
                LOGGER.error(String.format("File %s does not existed", file.getName()));
            }
        }
    }

    private int getNumberRecordCountInFileImport(LineNumberReader lineReader) throws IOException {
        this.baseObj.info("Count the total record count in file import");
        int numberRecordCount = 0;
        String line = null;
        while ((line = lineReader.readLine()) != null) {
            this.baseObj.info(line);
            numberRecordCount++;
        }
        return numberRecordCount;
    }

    public void prepareFileOutboundClaim(List<File> csvFiles, String batchID) {
        for (File file : csvFiles) {
            this.declareFilesToImport(this.getRecords(), file);
        }
        this.generateFileOutboundClaim(this.csvHeaders, this.records, batchID);
    }

    void generateFileOutboundClaim(List<String> csvHeaders, List records, String batchID) {
        String filePath = RESOURCE_FILE_GENERATED + this.generateFileNameOutboundForClaim(batchID);
        LOGGER.info("Starting generated file import for Claim");
        try {
            File file = CsvUtil.writeCsvFromListModel(records, csvHeaders, filePath);
            this.listFileCSV.add(file);
        } catch (IOException e) {
            LOGGER.error("File is not existed" + e);
        } catch (IllegalAccessException e) {
            LOGGER.error(String.format("Do not find any line records in template with exception %s", e));
        }
    }

    private String generateFileNameOutboundForClaim(String batchID) {
        String fileNameTemplate = ImportServices.config.getEnvironment("Template_File_Outbound_Claim");
        this.setDateTimeFormatter("yyyyMMdd_hhmmss.SSS");
        return String.format(fileNameTemplate, batchID, this.generateCurrentDateTimeWithGenericPattern());
    }

    private void addOutboundFileAndImportDateToLastLines(File outboundFile) {
        this.setDateTimeFormatter("yyyy-MM-dd");
        String currentDate = this.generateCurrentDateTimeWithGenericPattern();
        try (FileWriter writer = new FileWriter(outboundFile, true)) {
            writer.write(String.format("\"%s\"|\"%s\"%n", outboundFile.getName(), this.totalFileProcess + 2));
            writer.write(String.format("\"%s\" \"%s\"%n", currentDate, currentDate));
            writer.flush();
        } catch (IOException e) {
            LOGGER.error("No file found", e);
        }
    }
}
