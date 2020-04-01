package com.sandata.models.importModel.Auth;

import com.interop.common.constants.utils.PGPUtils;
import com.sandata.models.importModel.ImportGenericModel;
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

public class ImportPriorAuthModel extends ImportGenericModel {
    public Map<String, String> fields = new HashMap<>();
    public PriorAuthModel priorAuthModel = new PriorAuthModel();
    public String encrypted_filename_auth;
    public String fileName_Auth;

    public void initMaineData(Map<String, String> fields) {
        String providerId = getEnvironment("molina_providerId");
        priorAuthModel.PayerID =  "MEDHHS";
        priorAuthModel.PayerProgram =  "28-Rehabilitative and Community Support Services for Children wi";
        priorAuthModel.PayerRegion =  "";
        priorAuthModel.ClientQualifier =  "ClientOtherID";
        priorAuthModel.ClientIdentifier =  fields.get("memberModel.ClientOtherID");
        priorAuthModel.ProviderQualifier =  "Other";
        priorAuthModel.ProviderID =  providerId;
        priorAuthModel.AuthorizationReferenceNumber = RandomStringUtils.randomAlphanumeric(25);
        priorAuthModel.AuthorizationServiceID =  "H2021";
        priorAuthModel.AuthorizationBillingType =  "";
        priorAuthModel.Modifier1 =  "HI";
        priorAuthModel.Modifier2 =  "";
        priorAuthModel.Modifier3 =  "";
        priorAuthModel.Modifier4 =  "";
        priorAuthModel.AuthorizationAmountType =  "U";
        priorAuthModel.AuthorizationMaximum =  "500";
        priorAuthModel.AuthorizationStartDate =  commons.getDateString(-1, "yyyy-MM-dd");
        priorAuthModel.AuthorizationEndDate =  commons.getDateString(+10, "yyyy-MM-dd");;
        priorAuthModel.AuthorizationShared =  "N";
        priorAuthModel.AuthorizationComments =  "";
        priorAuthModel.AuthorizationLimitType =  "N";
        priorAuthModel.AuthorizationStatus =  "A";
        priorAuthModel.ClientDiagnosisCodeIsPrimary =  "";
        priorAuthModel.ClientDiagnosisCode =  "";
        priorAuthModel.ClientDiagnosisCodeBeginDate =  "";
        priorAuthModels.add(priorAuthModel);
    }

    // https://jira.sandata.com/browse/SEVV-9144
    public void initMaineDataWithInactiveAuth(Map<String, String> fields) {
        String providerId = getEnvironment("molina_providerId");
        priorAuthModel.PayerID =  "MEDHHS";
        priorAuthModel.PayerProgram =  "28-Rehabilitative and Community Support Services for Children wi";
        priorAuthModel.PayerRegion =  "";
        priorAuthModel.ClientQualifier =  "ClientOtherID";
        priorAuthModel.ClientIdentifier =  fields.get("memberModel.ClientOtherID");
        priorAuthModel.ProviderQualifier =  "Other";
        priorAuthModel.ProviderID =  providerId;
        priorAuthModel.AuthorizationReferenceNumber = RandomStringUtils.randomAlphanumeric(25);
        priorAuthModel.AuthorizationServiceID =  "H2021";
        priorAuthModel.AuthorizationBillingType =  "";
        priorAuthModel.Modifier1 =  "HI";
        priorAuthModel.Modifier2 =  "";
        priorAuthModel.Modifier3 =  "";
        priorAuthModel.Modifier4 =  "";
        priorAuthModel.AuthorizationAmountType =  "U";
        priorAuthModel.AuthorizationMaximum =  "500";
        priorAuthModel.AuthorizationStartDate =  commons.getDateString(-1, "yyyy-MM-dd");
        priorAuthModel.AuthorizationEndDate =  commons.getDateString(+10, "yyyy-MM-dd");;
        priorAuthModel.AuthorizationShared =  "N";
        priorAuthModel.AuthorizationComments =  "";
        priorAuthModel.AuthorizationLimitType =  "N";
        priorAuthModel.AuthorizationStatus =  "I";
        priorAuthModel.ClientDiagnosisCodeIsPrimary =  "";
        priorAuthModel.ClientDiagnosisCode =  "";
        priorAuthModel.ClientDiagnosisCodeBeginDate =  "";
        priorAuthModels.add(priorAuthModel);
    }

    public void initMaineDataWithActiveAndInactiveAuth(Map<String, String> fields) {
        String providerId = getEnvironment("molina_providerId");
        priorAuthModel.PayerID =  "MEDHHS";
        priorAuthModel.PayerProgram =  "28-Rehabilitative and Community Support Services for Children wi";
        priorAuthModel.PayerRegion =  "";
        priorAuthModel.ClientQualifier =  "ClientOtherID";
        priorAuthModel.ClientIdentifier =  fields.get("memberModel.ClientOtherID");
        priorAuthModel.ProviderQualifier =  "Other";
        priorAuthModel.ProviderID =  providerId;
        priorAuthModel.AuthorizationReferenceNumber = RandomStringUtils.randomAlphanumeric(25);
        priorAuthModel.AuthorizationServiceID =  "H2021";
        priorAuthModel.AuthorizationBillingType =  "";
        priorAuthModel.Modifier1 =  "HI";
        priorAuthModel.Modifier2 =  "";
        priorAuthModel.Modifier3 =  "";
        priorAuthModel.Modifier4 =  "";
        priorAuthModel.AuthorizationAmountType =  "U";
        priorAuthModel.AuthorizationMaximum =  "500";
        priorAuthModel.AuthorizationStartDate =  commons.getDateString(-1, "yyyy-MM-dd");
        priorAuthModel.AuthorizationEndDate =  commons.getDateString(+10, "yyyy-MM-dd");;
        priorAuthModel.AuthorizationShared =  "N";
        priorAuthModel.AuthorizationComments =  "";
        priorAuthModel.AuthorizationLimitType =  "N";
        priorAuthModel.AuthorizationStatus =  "A";
        priorAuthModel.ClientDiagnosisCodeIsPrimary =  "";
        priorAuthModel.ClientDiagnosisCode =  "";
        priorAuthModel.ClientDiagnosisCodeBeginDate =  "";

        PriorAuthModel priorAuthModel2 = new PriorAuthModel();

        priorAuthModel2.PayerID =  "MEDHHS";
        priorAuthModel2.PayerProgram =  "19-Home and Community Benefits for the Elderly and Adults with D";
        priorAuthModel2.PayerRegion =  "";
        priorAuthModel2.ClientQualifier =  "ClientOtherID";
        priorAuthModel2.ClientIdentifier =  fields.get("memberModel.ClientOtherID");
        priorAuthModel2.ProviderQualifier =  "Other";
        priorAuthModel2.ProviderID =  providerId;
        priorAuthModel2.AuthorizationReferenceNumber = RandomStringUtils.randomAlphanumeric(25);
        priorAuthModel2.AuthorizationServiceID =  "G0151";
        priorAuthModel2.AuthorizationBillingType =  "";
        priorAuthModel2.Modifier1 =  "HI";
        priorAuthModel2.Modifier2 =  "";
        priorAuthModel2.Modifier3 =  "";
        priorAuthModel2.Modifier4 =  "";
        priorAuthModel2.AuthorizationAmountType =  "U";
        priorAuthModel2.AuthorizationMaximum =  "500";
        priorAuthModel2.AuthorizationStartDate =  commons.getDateString(-1, "yyyy-MM-dd");
        priorAuthModel2.AuthorizationEndDate =  commons.getDateString(+20, "yyyy-MM-dd");;
        priorAuthModel2.AuthorizationShared =  "N";
        priorAuthModel2.AuthorizationComments =  "";
        priorAuthModel2.AuthorizationLimitType =  "N";
        priorAuthModel2.AuthorizationStatus =  "I";
        priorAuthModel2.ClientDiagnosisCodeIsPrimary =  "";
        priorAuthModel2.ClientDiagnosisCode =  "";
        priorAuthModel2.ClientDiagnosisCodeBeginDate =  "";

        priorAuthModels.add(priorAuthModel);
        priorAuthModels.add(priorAuthModel2);
    }

    public void initMultipleMaineAuth(Map<String, String> fields, int count) {
        for (int i = 1; i <= count; i++ ) {
            PriorAuthModel priorAuthModel = initSingleMaineAuth(fields, "memberModel.ClientOtherID" + i);
            priorAuthModels.add(priorAuthModel);
        }
    }

    public PriorAuthModel initSingleMaineAuth(Map<String, String> fields, String fieldName) {
        String providerId = getEnvironment("molina_providerId");
        PriorAuthModel priorAuthModel = new PriorAuthModel();
        priorAuthModel.PayerID =  "MEDHHS";
        priorAuthModel.PayerProgram =  "28-Rehabilitative and Community Support Services for Children wi";
        priorAuthModel.PayerRegion =  "";
        priorAuthModel.ClientQualifier =  "ClientOtherID";
        priorAuthModel.ClientIdentifier =  fields.get(fieldName);
        priorAuthModel.ProviderQualifier =  "Other";
        priorAuthModel.ProviderID =  providerId;
        priorAuthModel.AuthorizationReferenceNumber = RandomStringUtils.randomAlphanumeric(25);
        priorAuthModel.AuthorizationServiceID =  "H2021";
        priorAuthModel.AuthorizationBillingType =  "";
        priorAuthModel.Modifier1 =  "HI";
        priorAuthModel.Modifier2 =  "";
        priorAuthModel.Modifier3 =  "";
        priorAuthModel.Modifier4 =  "";
        priorAuthModel.AuthorizationAmountType =  "U";
        priorAuthModel.AuthorizationMaximum =  "500";
        priorAuthModel.AuthorizationStartDate =  commons.getDateString(-1, "yyyy-MM-dd");
        priorAuthModel.AuthorizationEndDate =  commons.getDateString(+10, "yyyy-MM-dd");;
        priorAuthModel.AuthorizationShared =  "N";
        priorAuthModel.AuthorizationComments =  "";
        priorAuthModel.AuthorizationLimitType =  "N";
        priorAuthModel.AuthorizationStatus =  "A";
        priorAuthModel.ClientDiagnosisCodeIsPrimary =  "";
        priorAuthModel.ClientDiagnosisCode =  "";
        priorAuthModel.ClientDiagnosisCodeBeginDate =  "";
        return priorAuthModel;
    }

    public void toFile(ACCOUNT_TYPE account_type) {
        super.toFile();
        if (account_type == ACCOUNT_TYPE.INDIANA) {
            fileName_Auth = INDIANA_IMPORT_PREFIX + commons.generateUniqueNumber()+ "_PriorAuth_11111111.txt";
        } else if (account_type == ACCOUNT_TYPE.MOLINA) {
            fileName_Auth = MOLINA_IMPORT_PREFIX + commons.generateUniqueNumber()+ "_PriorAuth_11111111.txt";
        }

        fields.put("fileName_Auth", fileName_Auth);
        fields.put("numRecords", String.valueOf(priorAuthModels.size()));
        logInfo("Going to write to: " + TO_ENCRYPT_PATH + fileName_Auth);

        Collection lines = new ArrayList<>();
        lines.add(createHeader());
        for (int i = 0; i<= priorAuthModels.size() - 1; i++) {
            lines.add(priorAuthModels.get(i).toLine());
        }

        File fileToWrite1 = FileUtils.getFile(TO_ENCRYPT_PATH + fileName_Auth);
        try {
            FileUtils.writeLines(fileToWrite1, lines);
        } catch (Exception e) {}
    }

    public String createHeader() {
        Class currentClass = PriorAuthModel.class;
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

    public List<PriorAuthModel> priorAuthModels = new ArrayList<>();

    @Override
    public void toGPG() throws IOException {
        encrypted_filename_auth = ENCRYPTED_PATH + fileName_Auth + "." + EXTENSION.gpg;
        PGPUtils.encryptFile(encrypted_filename_auth,
                TO_ENCRYPT_PATH + fileName_Auth, MOLINA_PUBLIC_KEY_PATH,
                false, false, SymmetricKeyAlgorithmTags.TRIPLE_DES);
    }

    @Override
    public void toPGP() throws IOException {
        encrypted_filename_auth = ENCRYPTED_PATH + fileName_Auth + "." + EXTENSION.pgp;
        PGPUtils.encryptFile(encrypted_filename_auth,
                TO_ENCRYPT_PATH + fileName_Auth, MOLINA_PUBLIC_KEY_PATH,
                false, false, SymmetricKeyAlgorithmTags.TRIPLE_DES);
    }

    @Override
    public void toSFTP(String localFilePath, String sftpFolder) {

    }

    @Override
    public void toSFTP() {
        super.toSFTP();
        SftpConfig sftpConfig = new SftpConfig();
        sftpConfig.setHost(SFTP_HOST);
        sftpConfig.setPort(SFTP_PORT);
        sftpConfig.setUsername(SFTP_IMPORT_USERNAME);
        sftpConfig.setPassword(SFTP_IMPORT_MATKHAU);
        SftpUtils.sendFile(sftpConfig, sftp_import_molina_folder, encrypted_filename_auth);
    }


    @Override
    public void toSFTP(ACCOUNT_TYPE account_type, SftpUtils.FileType fileType) {
        super.toSFTP(account_type, fileType);
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
                    SftpUtils.sendFile(sftpConfig, sftp_import_molina_folder, TO_ENCRYPT_PATH + fileName_Auth);
                } else {
                    SftpUtils.sendFile(sftpConfig, sftp_import_molina_folder, encrypted_filename_auth);
                }
                logInfo(String.format("Account '%s', Uploaded file '%s' to sftp folder: %s", account_type, encrypted_filename_auth, sftp_import_molina_folder));
                break;
            case INDIANA:
                sftpConfig.setHost(SFTP_HOST);
                sftpConfig.setPort(SFTP_PORT);
                sftpConfig.setUsername(SFTP_IMPORT_USERNAME);
                sftpConfig.setPassword(SFTP_IMPORT_MATKHAU);
                if(fileType.equals(EXTENSION.txt)){
                    SftpUtils.sendFile(sftpConfig, sftp_import_indiana_folder, TO_ENCRYPT_PATH + fileName_Auth);
                } else {
                    SftpUtils.sendFile(sftpConfig, sftp_import_indiana_folder, encrypted_filename_auth);
                }
                logInfo(String.format("Account '%s', Uploaded file '%s' to sftp folder: %s", account_type, encrypted_filename_auth, sftp_import_indiana_folder));
                break;
        }
    }
}
