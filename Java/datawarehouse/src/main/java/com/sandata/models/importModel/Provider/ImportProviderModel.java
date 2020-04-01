package com.sandata.models.importModel.Provider;

import com.interop.common.constants.utils.PGPUtils;
import com.sandata.models.importModel.ImportGenericModel;
import com.sandata.models.importModel.Member.MemberModel;
import com.sandata.utilities.sftp.utils.SftpConfig;
import com.sandata.utilities.sftp.utils.SftpUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.bouncycastle.bcpg.SymmetricKeyAlgorithmTags;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;

import static com.sandata.common.Constant.*;

public class ImportProviderModel extends ImportGenericModel {
    public Map<String, String> fields = new HashMap<>();
    public ProviderModel providerModel = new ProviderModel();
    List<ProviderModel> providerModels = new ArrayList<>();

    public String fileName_Provider;
    public String encrypted_filename_provider;

    public void initIndianaData(){

        providerModel.ProviderID = providerDbService.generateNewProviderId();
        providerModel.ProviderQualifier = "Other";
        providerModel.ProviderName = RandomStringUtils.randomAlphabetic(30);
        providerModel.PayerID ="INFSSA";
        providerModel.ProviderDoingBusinessAs= "";
        providerModel.AddressLine1= "123CHHCM";
        providerModel.AddressLine2= "";
        providerModel.AddressCity= "ROLLAG";
        providerModel.AddressState= "IN";
        providerModel.AddressZip= "012321347";
        providerModel.County= "";
        providerModel.AgencyPhone="1111111111";
        providerModel.AgencyEmail= providerModel.ProviderID + "@gmail.com";
        providerModel.PrimaryContactLastName = RandomStringUtils.randomAlphabetic(30);
        providerModel.PrimaryContactFirstName= RandomStringUtils.randomAlphabetic(30);
        providerModel.ProviderFax = "";
        providerModel.ProviderNPI= "";
        providerModel.ProviderAPI = "";
        providerModel.ProviderMedicaidID ="";
        providerModel.SSN= "";
        providerModel.TaxID="";
        providerModel.ProviderTaxonomy="";
        providerModel.ProviderRequireAuth="";
        providerModel.ProviderDateBegin ="";
        providerModel.ProviderDateEnd = "";

        providerModels.add(providerModel);
    }

    public void toFile(ACCOUNT_TYPE account_type) {
        super.toFile();
        if (account_type == ACCOUNT_TYPE.INDIANA) {
            fileName_Provider = INDIANA_IMPORT_PREFIX + commons.generateUniqueNumber()+ "_Provider_22222222.txt";
        } else if (account_type == ACCOUNT_TYPE.MOLINA) {
            fileName_Provider = MOLINA_IMPORT_PREFIX + commons.generateUniqueNumber()+ "_Provider_22222222.txt";
        }

        fields.put("fileName_Provider", fileName_Provider);
        fields.put("numRecords", String.valueOf(providerModels.size()));
        logInfo("Going to write to: " + TO_ENCRYPT_PATH + fileName_Provider);

        Collection lines = new ArrayList<>();
        lines.add(createHeader());
        for (int i = 0; i<= providerModels.size() - 1; i++) {
            lines.add(providerModels.get(i).toLine());
        }

        File fileToWrite = FileUtils.getFile(TO_ENCRYPT_PATH + fileName_Provider);
        try {
            FileUtils.writeLines(fileToWrite, lines);
        } catch (Exception e) {}
    }

    public String createHeader() {
        Class currentClass = ProviderModel.class;
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

    public List<ProviderModel> getProviderModels() {
        return providerModels;
    }

    public void setMemberModels(List<MemberModel> memberModels) {
        this.providerModels = providerModels;
    }

    @Override
    public void toGPG() throws IOException {
        encrypted_filename_provider = ENCRYPTED_PATH + fileName_Provider + "." + EXTENSION.gpg;
        PGPUtils.encryptFile(encrypted_filename_provider,
                TO_ENCRYPT_PATH + fileName_Provider, MOLINA_PUBLIC_KEY_PATH,
                false, false, SymmetricKeyAlgorithmTags.TRIPLE_DES);
    }

    @Override
    public void toPGP() throws IOException {
        encrypted_filename_provider = ENCRYPTED_PATH + fileName_Provider + "." + EXTENSION.pgp;
        PGPUtils.encryptFile(encrypted_filename_provider,
                TO_ENCRYPT_PATH + fileName_Provider, MOLINA_PUBLIC_KEY_PATH,
                false, false, SymmetricKeyAlgorithmTags.TRIPLE_DES);
    }

    @Override
    public void toSFTP(String localFilePath, String sftpFolder) {
        super.toSFTP(localFilePath, sftpFolder);
        SftpConfig sftpConfig = new SftpConfig();
        sftpConfig.setHost(SFTP_HOST);
        sftpConfig.setPort(SFTP_PORT);
        sftpConfig.setUsername(SFTP_IMPORT_USERNAME);
        sftpConfig.setPassword(SFTP_IMPORT_MATKHAU);
        SftpUtils.sendFile(sftpConfig, sftpFolder,
                localFilePath);
    }

    @Override
    public void toSFTP() {
        super.toSFTP();
        SftpConfig sftpConfig = new SftpConfig();
        sftpConfig.setHost(SFTP_HOST);
        sftpConfig.setPort(SFTP_PORT);
        sftpConfig.setUsername(SFTP_IMPORT_USERNAME);
        sftpConfig.setPassword(SFTP_IMPORT_MATKHAU);
        SftpUtils.sendFile(sftpConfig, sftp_import_indiana_folder, encrypted_filename_provider);
    }

    @Override
    public void toSFTP(ACCOUNT_TYPE account_type, SftpUtils.FileType fileType){
        super.toSFTP(account_type, fileType);
        SftpConfig sftpConfig = new SftpConfig();
        switch (account_type){
            case MOLINA:
                sftpConfig.setHost(SFTP_HOST);
                sftpConfig.setPort(SFTP_PORT);
                sftpConfig.setUsername(SFTP_IMPORT_USERNAME);
                sftpConfig.setPassword(SFTP_IMPORT_MATKHAU);
                if(fileType.equals(SftpUtils.FileType.TXT)){
                    SftpUtils.sendFile(sftpConfig, sftp_import_molina_folder, TO_ENCRYPT_PATH + fileName_Provider);
                }else
                    SftpUtils.sendFile(sftpConfig, sftp_import_molina_folder, encrypted_filename_provider);
                logInfo(String.format("Account '%s', Uploaded file '%s' to sftp folder: %s", account_type, encrypted_filename_provider, sftp_import_molina_folder));
                break;
            case INDIANA:
                sftpConfig.setHost(SFTP_HOST);
                sftpConfig.setPort(SFTP_PORT);
                sftpConfig.setUsername(SFTP_IMPORT_USERNAME);
                sftpConfig.setPassword(SFTP_IMPORT_MATKHAU);
                if(fileType.equals(SftpUtils.FileType.TXT)){
                    SftpUtils.sendFile(sftpConfig, sftp_import_indiana_folder, TO_ENCRYPT_PATH + fileName_Provider);
                } else
                    SftpUtils.sendFile(sftpConfig, sftp_import_indiana_folder, encrypted_filename_provider);
                logInfo(String.format("Account '%s', Uploaded file '%s' to sftp folder: %s", account_type, encrypted_filename_provider, sftp_import_indiana_folder));
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
                    SftpUtils.sendFile(sftpConfig, sftp_import_molina_folder, TO_ENCRYPT_PATH + fileName_Provider);
                } else {
                    SftpUtils.sendFile(sftpConfig, sftp_import_molina_folder, encrypted_filename_provider);
                }
                logInfo(String.format("Account '%s', Uploaded file '%s' to sftp folder: %s", account_type, encrypted_filename_provider, sftp_import_molina_folder));
                break;
            case INDIANA:
                sftpConfig.setHost(SFTP_HOST);
                sftpConfig.setPort(SFTP_PORT);
                sftpConfig.setUsername(SFTP_IMPORT_USERNAME);
                sftpConfig.setPassword(SFTP_IMPORT_MATKHAU);
                if(fileType.equals(EXTENSION.txt)){
                    SftpUtils.sendFile(sftpConfig, sftp_import_indiana_folder, TO_ENCRYPT_PATH + fileName_Provider);
                } else {
                    SftpUtils.sendFile(sftpConfig, sftp_import_indiana_folder, encrypted_filename_provider);
                }
                logInfo(String.format("Account '%s', Uploaded file '%s' to sftp folder: %s", account_type, encrypted_filename_provider, sftp_import_indiana_folder));
                break;
        }
    }
}
