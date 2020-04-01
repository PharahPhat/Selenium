package com.interop.services.openevv.batch;

import com.google.gson.Gson;
import com.interop.models.openevv.poc.EtlPlanOfCare;
import com.interop.common.StateAccount;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import static com.interop.common.constants.Constant.DEFAULT_FOLDER;
import static java.io.File.separator;

public class ImportPoc extends ImportServices {

    public ImportPoc() throws IllegalAccessException, InstantiationException, InvocationTargetException {
        init(EtlPlanOfCare.class);
    }

    @Override
    protected String getTemplatePath() {
        String patch = "templateCSV/" + StateAccount.loadStateAccount().getStateEnum().getStringKey() + "/templatePOC.csv";
        if (!new File(DEFAULT_FOLDER + separator + patch).exists()) {
            baseObj.info("The folder contains template for this state is not existed, Will load the default template for PA. Maybe make failed when initialize test data");
            return "templateCSV/templatePOC.csv";
        } else {
            return patch;
        }
    }

    /**
     * This method to clone number records before generate CSV file
     * Notes: This must be run before prepare file import
     *
     * @param numberLine
     */
    @Override
    public void generateFileWithMultipleLine(int numberLine) {
        EtlPlanOfCare original = (EtlPlanOfCare) records.get(0);
        Gson gson = new Gson();
        for (int i = 1; i < numberLine; i++) {
            EtlPlanOfCare temp = gson.fromJson(gson.toJson(original), EtlPlanOfCare.class);
            records.add(temp);
        }
    }

    public void initFileImportPocAndOutboundWithCustomData(List<?> clazz) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        baseObj.info("Prepare file test data for Plan Of Care");
        this.prepareFilePoc(clazz);
        ImportOutboundService outboundService = new ImportOutboundService();
        outboundService.prepareFileOutbound(this.listFileCSV);
        this.listFileCSV.addAll(outboundService.getListFileCSV());
        try {
            zipGeneratedFile(listFileCSV);
        } catch (IOException e) {
            baseObj.error("Having exception when trying to zip the generated file", e);
        }
    }

    private void prepareFilePoc(List<?> clazz) {
        baseObj.info("Generate File valid import Authorization");
        this.modifyFieldPropertyOfRecords(clazz);
        generateFile(ImportType.POC, this.csvHeaders, this.records);
    }
}
