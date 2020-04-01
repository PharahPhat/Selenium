package com.sandata.models.importModel.Control;

import com.interop.common.constants.utils.PGPUtils;
import com.sandata.models.importModel.ImportGenericModel;
import com.sandata.utilities.sftp.utils.SftpConfig;
import com.sandata.utilities.sftp.utils.SftpUtils;
import org.apache.commons.io.FileUtils;
import org.bouncycastle.bcpg.SymmetricKeyAlgorithmTags;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import static com.sandata.common.Constant.*;

public class ImportOutboundControlModel extends ImportGenericModel {
    public String encrypted_filename_outbound;
    public String fileName_Outbound_Control;

    public void initData(Map<String, String> memberFields, Map<String, String> authFields) {
        fileName_Outbound_Control = "MEDHHS_EVV_" + commons.generateUniqueNumber() + "_Outbound_ControlFile_11111111.txt";

        OutboundControlModel outboundControlModel1 = new OutboundControlModel();
        outboundControlModel1.FileName = memberFields.get("fileName_Member").toString();
        outboundControlModel1.RecordCount = String.valueOf(memberFields.get("numRecords"));

        OutboundControlModel outboundControlModel2 = new OutboundControlModel();
        outboundControlModel2.FileName = authFields.get("fileName_Auth").toString();
        outboundControlModel2.RecordCount = String.valueOf(authFields.get("numRecords"));

        OutboundControlModel outboundControlModel3 = new OutboundControlModel();
        outboundControlModel3.FileName = fileName_Outbound_Control;
        outboundControlModel3.RecordCount = "4";

        outboundControlModels.add(outboundControlModel1);
        outboundControlModels.add(outboundControlModel2);
        outboundControlModels.add(outboundControlModel3);
    }

    public void initDataIndiana(Map<String, String> providerFields){
        fileName_Outbound_Control = "Indiana_EVV_" + commons.generateUniqueNumber() + "_Outbound_ControlFile_22222222.txt";


        OutboundControlModel outboundControlModel1 = new OutboundControlModel();
        outboundControlModel1.FileName = providerFields.get("fileName_Provider").toString();
        outboundControlModel1.RecordCount = String.valueOf(providerFields.get("numRecords"));

        OutboundControlModel outboundControlModel2 = new OutboundControlModel();
        outboundControlModel2.FileName = fileName_Outbound_Control;
        outboundControlModel2.RecordCount = "3";

        outboundControlModels.add(outboundControlModel1);
        outboundControlModels.add(outboundControlModel2);

    }

    public void initDataForIndiana(Map<String, String> memberFields) {

        fileName_Outbound_Control = "Indiana_EVV_" + commons.generateUniqueNumber() + "_Outbound_ControlFile_11111111.txt";

        OutboundControlModel outboundControlModel1 = new OutboundControlModel();
        outboundControlModel1.FileName = memberFields.get("fileName_Member").toString();
        outboundControlModel1.RecordCount = String.valueOf(memberFields.get("numRecords"));

        OutboundControlModel outboundControlModel2 = new OutboundControlModel();
        outboundControlModel2.FileName = fileName_Outbound_Control;
        outboundControlModel2.RecordCount = "3";

        outboundControlModels.add(outboundControlModel1);
        outboundControlModels.add(outboundControlModel2);
    }

    public void toFile() {
        super.toFile();
        logInfo("Going to write to: " + TO_ENCRYPT_PATH + fileName_Outbound_Control);

        Collection lines = new ArrayList<>();
        lines.add(createHeader());
        for (int i = 0; i<= outboundControlModels.size() - 1; i++) {
            lines.add(outboundControlModels.get(i).toLine());
        }
        lines.add("\"1/1/2010\" - \"12/18/2018 5:48:00 PM\"");

        File fileToWrite1 = FileUtils.getFile(TO_ENCRYPT_PATH + fileName_Outbound_Control);
        try {
            FileUtils.writeLines(fileToWrite1, lines);
        } catch (Exception e) {}
    }

    public String createHeader() {
        Class currentClass = OutboundControlModel.class;
        String header_line = "";
        Field[] fields = currentClass.getDeclaredFields();
        int last = fields.length - 1;
        String name = "";
        for (int i = 0; i <= fields.length - 1; i++) {
            if(i == last) {
                name = "\"" + fields[i].getName() + "\"";
            } else {
                name = "\"" + fields[i].getName() + "\"" + "|";
            }
            header_line += name;
        }
        return header_line;
    }

    List<OutboundControlModel> outboundControlModels = new ArrayList<>();

    @Override
    public void toGPG() throws IOException {
        encrypted_filename_outbound = ENCRYPTED_PATH + fileName_Outbound_Control + "." + EXTENSION.gpg;
        PGPUtils.encryptFile(encrypted_filename_outbound,
                TO_ENCRYPT_PATH + fileName_Outbound_Control,
                MOLINA_PUBLIC_KEY_PATH, false, false, SymmetricKeyAlgorithmTags.TRIPLE_DES);
    }

    @Override
    public void toPGP() throws IOException {
        encrypted_filename_outbound = ENCRYPTED_PATH + fileName_Outbound_Control + "." + EXTENSION.pgp;
        PGPUtils.encryptFile(encrypted_filename_outbound,
                TO_ENCRYPT_PATH + fileName_Outbound_Control, MOLINA_PUBLIC_KEY_PATH,
                false, false, SymmetricKeyAlgorithmTags.TRIPLE_DES);
    }

    @Override
    public void toSFTP(String localFilePath, String sftpFolder) { }

    @Override
    public void toSFTP() {
        super.toSFTP();
        SftpConfig sftpConfig = new SftpConfig();
        sftpConfig.setHost(SFTP_HOST);
        sftpConfig.setPort(SFTP_PORT);
        sftpConfig.setUsername(SFTP_IMPORT_USERNAME);
        sftpConfig.setPassword(SFTP_IMPORT_MATKHAU);
        SftpUtils.sendFile(sftpConfig, sftp_import_indiana_folder, encrypted_filename_outbound);
    }

    @Override
    public boolean verifyFieldValue(Object obj) {
        return false;
    }

    @Override
    public boolean verifyFieldsNotNull() {
        return false;
    }



    @Override
    public void toSFTP(ACCOUNT_TYPE account_type, SftpUtils.FileType fileType){
        super.toSFTP(account_type, fileType);
        SftpConfig sftpConfig = new SftpConfig();
        switch (account_type) {
            case MOLINA:
                sftpConfig.setHost(SFTP_HOST);
                sftpConfig.setPort(SFTP_PORT);
                sftpConfig.setUsername(SFTP_IMPORT_USERNAME);
                sftpConfig.setPassword(SFTP_IMPORT_MATKHAU);
                if(fileType.equals(SftpUtils.FileType.TXT)){
                    SftpUtils.sendFile(sftpConfig, sftp_import_molina_folder, TO_ENCRYPT_PATH + fileName_Outbound_Control);
                }else
                    SftpUtils.sendFile(sftpConfig, sftp_import_molina_folder, encrypted_filename_outbound);
                break;
            case INDIANA:
                sftpConfig.setHost(SFTP_HOST);
                sftpConfig.setPort(SFTP_PORT);
                sftpConfig.setUsername(SFTP_IMPORT_USERNAME);
                sftpConfig.setPassword(SFTP_IMPORT_MATKHAU);
                if(fileType.equals(SftpUtils.FileType.TXT)){
                    SftpUtils.sendFile(sftpConfig, sftp_import_indiana_folder, TO_ENCRYPT_PATH + fileName_Outbound_Control);
                }else
                SftpUtils.sendFile(sftpConfig, sftp_import_indiana_folder, encrypted_filename_outbound);
                break;
        }
     }

    @Override
    public void toSFTP(ACCOUNT_TYPE account_type, EXTENSION fileType) {
        super.toSFTP(account_type, fileType);
        SftpConfig sftpConfig = new SftpConfig();
        switch (account_type){
            case MOLINA:
                sftpConfig.setHost(SFTP_HOST);
                sftpConfig.setPort(SFTP_PORT);
                sftpConfig.setUsername(SFTP_IMPORT_USERNAME);
                sftpConfig.setPassword(SFTP_IMPORT_MATKHAU);
                if(fileType.equals(EXTENSION.txt)){
                    SftpUtils.sendFile(sftpConfig, sftp_import_molina_folder, TO_ENCRYPT_PATH + fileName_Outbound_Control);
                } else {
                    SftpUtils.sendFile(sftpConfig, sftp_import_molina_folder, encrypted_filename_outbound);
                }
                logInfo(String.format("Account '%s', Uploaded file '%s' to sftp folder: %s", account_type, encrypted_filename_outbound, sftp_import_molina_folder));
                break;
            case INDIANA:
                sftpConfig.setHost(SFTP_HOST);
                sftpConfig.setPort(SFTP_PORT);
                sftpConfig.setUsername(SFTP_IMPORT_USERNAME);
                sftpConfig.setPassword(SFTP_IMPORT_MATKHAU);
                if(fileType.equals(EXTENSION.txt)){
                    SftpUtils.sendFile(sftpConfig, sftp_import_indiana_folder, TO_ENCRYPT_PATH + fileName_Outbound_Control);
                } else {
                    SftpUtils.sendFile(sftpConfig, sftp_import_indiana_folder, encrypted_filename_outbound);
                }
                logInfo(String.format("Account '%s', Uploaded file '%s' to sftp folder: %s", account_type, encrypted_filename_outbound, sftp_import_indiana_folder));
                break;
        }
    }
}
