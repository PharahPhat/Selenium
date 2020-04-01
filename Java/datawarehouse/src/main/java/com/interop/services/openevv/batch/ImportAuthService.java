package com.interop.services.openevv.batch;


import com.google.gson.Gson;
import com.interop.models.openevv.batch.AuthorizationCSVModel;
import com.interop.common.StateAccount;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import static com.interop.common.constants.Constant.DEFAULT_FOLDER;
import static java.io.File.separator;

public class ImportAuthService extends ImportServices {

    public ImportAuthService() throws IllegalAccessException, InstantiationException, InvocationTargetException {
        init(AuthorizationCSVModel.class);
    }

    /**
     * This method to clone number records before generate CSV file
     * Notes: This must be run before prepare file import
     *
     * @param numberLine
     */
    @Override
    public void generateFileWithMultipleLine(int numberLine) {
        AuthorizationCSVModel original = (AuthorizationCSVModel) records.get(0);
        Gson gson = new Gson();
        for (int i = 1; i < numberLine; i++) {
            AuthorizationCSVModel temp = gson.fromJson(gson.toJson(original), AuthorizationCSVModel.class);
            records.add(temp);
        }
    }

    public String generateAuthRefNumber() {
        setDateTimeFormatter("MMddYYYYhhmmssSSS");
        return "Auto" + generateCurrentDateTimeWithGenericPattern();
    }

    @Override
    protected String getTemplatePath() {
        String path = "templateCSV/" + StateAccount.loadStateAccount().getStateName() + "/templateAuthorization.csv";
        if (!new File(DEFAULT_FOLDER + separator + path).exists()) {
            baseObj.info("The folder contains template for this state is not existed, Will load the default template for PA. Maybe make failed when initialize test data");
            return "templateCSV/templateAuthorization.csv";
        } else {
            return path;
        }
    }

    public void initFileImportAuthAndOutboundWithCustomData(List<?> clazz) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        baseObj.info("Prepare file test data for import Authorization");
        this.prepareFileAuth(clazz);
        ImportOutboundService outboundService = new ImportOutboundService();
        outboundService.prepareFileOutbound(this.listFileCSV);
        this.listFileCSV.addAll(outboundService.getListFileCSV());
        try {
            zipGeneratedFile(listFileCSV);
        } catch (IOException e) {
            baseObj.error("Having exception when trying to zip the generated file", e);
        }
    }

    private void prepareFileAuth(List<?> clazz) {
        baseObj.info("Generate File valid import Authorization");
        this.modifyFieldPropertyOfRecords(clazz);
        generateFile(ImportType.AUTHORIZATION, this.csvHeaders, this.records);
    }

    public String convertInputtedDXCodeToICD10Standard(String origDXCode, int position) {
        return origDXCode.substring(0, position) + '.' + origDXCode.substring(position);
    }
}
