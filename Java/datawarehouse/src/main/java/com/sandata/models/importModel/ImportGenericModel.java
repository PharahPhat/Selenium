package com.sandata.models.importModel;

import com.sandata.common.Constant;
import com.sandata.models.GenericModel;
import com.sandata.models.importModel.Member.MemberIndianaModel;
import com.sandata.utilities.sftp.utils.SftpUtils;

import java.io.File;
import java.io.IOException;

public abstract class ImportGenericModel extends GenericModel {

    public String TO_ENCRYPT_PATH = System.getProperty("user.dir") + "/to_encrypt/";
    public String ENCRYPTED_PATH = System.getProperty("user.dir") + "/encrypted_files/";
    public String MOLINA_PUBLIC_KEY_PATH = System.getProperty("user.dir") + "/lib/intf_molina_publickey.asc";
    public String MOLINA_IMPORT_PREFIX = "MEDHHS_EVV_";
    public String INDIANA_IMPORT_PREFIX = "Indiana_EVV_";
    public String sftp_import_indiana_folder = "";
    public String sftp_import_molina_folder = "";

    public MemberIndianaModel memberIndianaModel = new MemberIndianaModel();

    public ImportGenericModel() {
    }

    public void initConfig() {
        sftp_import_indiana_folder = getEnvironment("sftp_import_indiana_folder");
        sftp_import_molina_folder = getEnvironment("sftp_import_molina_folder");
    }

    public abstract void toGPG() throws IOException;

    public abstract void toPGP() throws IOException;

    public void toSFTP(String localFilePath, String sftpFolder) {
        this.initConfig();
    }

    public void toSFTP() {
        this.initConfig();
    }

    public void toSFTP(Constant.ACCOUNT_TYPE account_type, SftpUtils.FileType fileType) {
        this.initConfig();
    }

    public void toSFTP(Constant.ACCOUNT_TYPE account_type, Constant.EXTENSION fileType) {
        this.initConfig();
    }

    public void toFile() {
        File to_encrypt_dir = new File(TO_ENCRYPT_PATH);
        if (!to_encrypt_dir.exists()) {
            to_encrypt_dir.mkdirs();
        }
        File encrypted_dir = new File(ENCRYPTED_PATH);
        if (!encrypted_dir.exists()) {
            encrypted_dir.mkdirs();
        }
    }

    @Override
    public boolean verifyFieldValue(Object obj) {
        return false;
    }

    @Override
    public boolean verifyFieldsNotNull() {
        return false;
    }


}
