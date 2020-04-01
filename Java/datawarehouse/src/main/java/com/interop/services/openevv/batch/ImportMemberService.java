package com.interop.services.openevv.batch;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.interop.common.StateAccount;
import com.interop.models.openevv.batch.MemberCSVModel;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import static com.interop.common.constants.Constant.DEFAULT_FOLDER;
import static java.io.File.separator;

public class ImportMemberService extends ImportServices {

    public ImportMemberService() throws IllegalAccessException, InstantiationException, InvocationTargetException {
        init(MemberCSVModel.class);
    }

    @Override
    protected String getTemplatePath() {
        String path = "templateCSV/" + StateAccount.loadStateAccount().getStateName() + "/templateMember.csv";
        if (!new File(DEFAULT_FOLDER + separator + path).exists()) {
            baseObj.info("The folder contains template for this state is not existed, Will load the default template for PA. Maybe make failed when initialize test data");
            return "templateCSV/templateMember.csv";
        } else {
            return path;
        }
    }

    @Override
    public void generateFileWithMultipleLine(int numberLine) {
        MemberCSVModel original = (MemberCSVModel) this.getRecords().get(0);
        Gson gson = new GsonBuilder().create();
        for (int i = 1; i < numberLine; i++) {
            MemberCSVModel temp = gson.fromJson(gson.toJson(original), MemberCSVModel.class);
            this.getRecords().add(temp);
        }
    }

    public void initFileImportMemberAndOutboundWithCustomData(List<MemberCSVModel> dataMemberInfo) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        baseObj.info("Prepare file test data for import Authorization");
        this.prepareFileMember(dataMemberInfo);
        ImportOutboundService outboundService = new ImportOutboundService();
        outboundService.prepareFileOutbound(this.listFileCSV);
        this.listFileCSV.addAll(outboundService.getListFileCSV());
        try {
            zipGeneratedFile(listFileCSV);
        } catch (IOException e) {
            baseObj.error("Having exception when trying to zip the generated file", e);
        }
    }

    private void prepareFileMember(List<MemberCSVModel> dataMemberInfo) {
        baseObj.info("Generate File valid import Authorization");
        this.modifyFieldPropertyOfRecords(dataMemberInfo);
        generateFile(ImportType.MEMBER, this.csvHeaders, this.records);
    }
}
