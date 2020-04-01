package com.interop.services.openevv.batch;

import com.google.gson.Gson;
import com.interop.common.StateAccount;
import com.interop.models.openevv.provider.OpenEvvProviderModel;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import static com.interop.common.constants.Constant.DEFAULT_FOLDER;
import static java.io.File.separator;

public class ImportProviderService extends ImportServices {

    public ImportProviderService() throws IllegalAccessException, InstantiationException, InvocationTargetException {
        init(OpenEvvProviderModel.class);
    }

    public void initFileImportProviderAndOutboundWithCustomData(List<OpenEvvProviderModel> clazz) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        baseObj.info("Prepare file test data for import Authorization");
        this.prepareDataImportProvider(clazz);
        ImportOutboundService outboundService = new ImportOutboundService();
        outboundService.prepareFileOutbound(this.listFileCSV);
        this.listFileCSV.addAll(outboundService.getListFileCSV());
        try {
            zipGeneratedFile(listFileCSV);
        } catch (IOException e) {
            baseObj.error("Having exception when trying to zip the generated file", e);
        }
    }

    private void prepareDataImportProvider(List<OpenEvvProviderModel> providerInfo) {
        baseObj.info("Generate File import provider with custom field and value");
        this.modifyFieldPropertyOfRecords(providerInfo);
        generateFile(ImportType.PROVIDER, this.csvHeaders, this.records);
    }

    @Override
    protected String getTemplatePath() {
        String path = "templateCSV/" + StateAccount.loadStateAccount().getStateName() + "/templateProvider.csv";
        if (!new File(DEFAULT_FOLDER + separator + path).exists()) {
            baseObj.info("The folder contains template for this state is not existed, Will load the default template for PA. Maybe make failed when initialize test data");
            return "templateCSV/templateProvider.csv";
        } else {
            return path;
        }
    }

    @Override
    public void generateFileWithMultipleLine(int numberLine) {
        OpenEvvProviderModel original = (OpenEvvProviderModel) records.get(0);
        Gson gson = new Gson();
        for (int i = 1; i < numberLine; i++) {
            OpenEvvProviderModel temp = gson.fromJson(gson.toJson(original), OpenEvvProviderModel.class);
            records.add(temp);
        }
    }

    public String generateProviderID() {
        setDateTimeFormatter("MMddhhSSSmmyy");
        return generateCurrentDateTimeWithGenericPattern();
    }

    public void validationFieldForImportProvider(List<OpenEvvProviderModel> listObject, List<OpenEvvProviderModel> fileErrorObject) {
        boolean isTheLineDisplayed = false;
        for (OpenEvvProviderModel lineImportFile : listObject) {
            for (OpenEvvProviderModel lineErrorFile : fileErrorObject) {
                if (lineImportFile.taxID.equalsIgnoreCase(lineErrorFile.taxID)) {
                    baseObj.info(String.format("Compare data lineImportFile record having taxID is %s", lineImportFile.taxID));
                    baseObj.info("Line in file import" + lineImportFile);
                    baseObj.info("Line in file error" + lineErrorFile);
                    baseObj.validateActualAndExpectedTextContains(lineErrorFile.getErrorDescription(), lineImportFile.getErrorDescription());
                    isTheLineDisplayed = true;
                }
            }
            if (!isTheLineDisplayed) {
                baseObj.fail(String.format("Failed in line %s ", lineImportFile));
                baseObj.info("The expected error message is " + lineImportFile.getErrorDescription());
            }
        }
    }
}
