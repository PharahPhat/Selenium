package com.sandata.models.importModel.Member;

import com.interop.common.constants.utils.PGPUtils;
import com.sandata.models.importModel.ImportGenericModel;
import com.sandata.utilities.sftp.utils.SftpConfig;
import com.sandata.utilities.sftp.utils.SftpUtils;
import org.apache.commons.io.FileUtils;
import org.bouncycastle.bcpg.SymmetricKeyAlgorithmTags;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;

import static com.sandata.common.Constant.*;

public class ImportMemberModel extends ImportGenericModel {
    public Map<String, String> fields = new HashMap<>();
    public MemberModel memberModel = new MemberModel();

    public List<MemberIndianaModel> memberIndianaModels = new ArrayList<>();
    public List<MemberModel> memberModels = new ArrayList<>();

    public String fileName_Member;
    public String encrypted_filename_member;

    public void initMaineData() {
        String account = getEnvironment("molina_accountId");
        String providerId = getEnvironment("molina_providerId");
        memberModel.ClientID = "";
        memberModel.ClientFirstName = clientDbService.generateNewClientFName(account);
        memberModel.ClientMiddleInitial = "T";
        memberModel.ClientLastName = clientDbService.generateNewClientLName(account);
        memberModel.ClientSSN = " ";
        memberModel.ClientMedicalRecordNum = " ";
        memberModel.ClientCustomID = commons.generateUniqueNumber();
        memberModel.ClientOtherID = commons.generateUniqueNumber();
        memberModel.ClientSuffix = " ";
        memberModel.Action = "A";
        memberModel.PayerID2 = "MEDHHS";
        memberModel.PayerProgram2 = " ";
        memberModel.PayerService = " ";
        memberModel.PayerRegion = " ";
        memberModel.ProviderQualifier = " ";
        memberModel.ProviderID = providerId;
        memberModel.ClientAddressType = "Home";
        memberModel.ClientAddressLine1 = "45 Commerce Dr";
        memberModel.ClientAddressLine2 = "Suite 1";
        memberModel.ClientCounty = "Kennebec";
        memberModel.ClientCity = "Augusta";
        memberModel.ClientState = "ME";
        memberModel.ClientZip = "04330";
        memberModel.ClientPhoneType = "Home";
        memberModel.ClientPhone = "2078921864";
        memberModel.PayerID = "MEDHHS";
        memberModel.PayerProgram = " ";
        memberModel.ClientEligibilityDateBegin = "2009-01-01";
        memberModel.ClientEligibilityDateEnd = "2068-12-31";
        memberModel.ClientStartOfCareDate = " ";
        memberModel.ClientEndOfCareDate = " ";
        memberModel.ClientPrimaryDiagnosisCode = " ";
        memberModel.ClientSecondaryDiagnosisCode = " ";
        memberModel.ClientStatus = "02";
        memberModel.ClientStatusDate = " ";
        memberModels.add(memberModel);

        fields.put("memberModel.ClientOtherID", memberModel.ClientCustomID);
    }

    public void initMultipleMaineMembers(int count) {
        for (int i = 1; i <= count; i++ ) {
            MemberModel memberModel = initSingleMaineMember();
            memberModels.add(memberModel);
            fields.put("memberModel.ClientOtherID" + i, memberModel.ClientCustomID);
        }
    }

    public MemberModel initSingleMaineMember() {
        String account = getEnvironment("molina_accountId");
        String providerId = getEnvironment("molina_providerId");
        MemberModel memberModel = new MemberModel();

        memberModel.ClientID = "";
        memberModel.ClientFirstName = clientDbService.generateNewClientFName(account);
        memberModel.ClientMiddleInitial = "T";
        memberModel.ClientLastName = clientDbService.generateNewClientLName(account);
        memberModel.ClientSSN = " ";
        memberModel.ClientMedicalRecordNum = " ";
        memberModel.ClientCustomID = commons.generateUniqueNumber();
        memberModel.ClientOtherID = commons.generateUniqueNumber();
        memberModel.ClientSuffix = " ";
        memberModel.Action = "A";
        memberModel.PayerID2 = "MEDHHS";
        memberModel.PayerProgram2 = " ";
        memberModel.PayerService = " ";
        memberModel.PayerRegion = " ";
        memberModel.ProviderQualifier = " ";
        memberModel.ProviderID = providerId;
        memberModel.ClientAddressType = "Home";
        memberModel.ClientAddressLine1 = "45 Commerce Dr";
        memberModel.ClientAddressLine2 = "Suite 1";
        memberModel.ClientCounty = "Kennebec";
        memberModel.ClientCity = "Augusta";
        memberModel.ClientState = "ME";
        memberModel.ClientZip = "04330";
        memberModel.ClientPhoneType = "Home";
        memberModel.ClientPhone = "2078921864";
        memberModel.PayerID = "MEDHHS";
        memberModel.PayerProgram = " ";
        memberModel.ClientEligibilityDateBegin = "2009-01-01";
        memberModel.ClientEligibilityDateEnd = "2068-12-31";
        memberModel.ClientStartOfCareDate = " ";
        memberModel.ClientEndOfCareDate = " ";
        memberModel.ClientPrimaryDiagnosisCode = " ";
        memberModel.ClientSecondaryDiagnosisCode = " ";
        memberModel.ClientStatus = "02";
        memberModel.ClientStatusDate = " ";
        return memberModel;
    }

    public void toFile(ACCOUNT_TYPE account_type) {
        super.toFile();
        if (account_type == ACCOUNT_TYPE.INDIANA) {
            fileName_Member = INDIANA_IMPORT_PREFIX + commons.generateUniqueNumber() + "_Member_11111111.txt";
            fields.put("fileName_Member", fileName_Member);
            fields.put("numRecords", String.valueOf(memberIndianaModels.size()));
        } else if (account_type == ACCOUNT_TYPE.MOLINA) {
            fileName_Member = MOLINA_IMPORT_PREFIX + commons.generateUniqueNumber() + "_Member_11111111.txt";
            fields.put("fileName_Member", fileName_Member);
            fields.put("numRecords", String.valueOf(memberModels.size()));
        }
        logInfo("Going to write to: " + TO_ENCRYPT_PATH + fileName_Member);

        Collection lines = new ArrayList<>();
        if (account_type == ACCOUNT_TYPE.MOLINA) {
            lines.add(createHeaderForMaine());
            for (int i = 0; i <= memberModels.size() - 1; i++) {
                lines.add(memberModels.get(i).toLine());
            }
        } else {
            lines.add(createHeaderForIndiana());
            for (int i = 0; i <= memberIndianaModels.size() - 1; i++) {
                lines.add(memberIndianaModels.get(i).toLine());
            }
        }

        File fileToWrite = FileUtils.getFile(TO_ENCRYPT_PATH + fileName_Member);
        try {
            FileUtils.writeLines(fileToWrite, lines);
        } catch (Exception e) {
        }
    }

    public void initIndianaData() {
        String account = "29017";
        memberIndianaModel.ClientID = "";
        memberIndianaModel.ClientFirstName = clientDbService.generateNewClientFName(account);
        memberIndianaModel.ClientMiddleInitial = "T";
        memberIndianaModel.ClientLastName = clientDbService.generateNewClientLName(account);
        memberIndianaModel.ClientSSN = "";
        memberIndianaModel.ClientMedicalRecordNum = " ";
        memberIndianaModel.MissingMedicaidID = " ";
        memberIndianaModel.ClientCustomID = commons.generateUniqueNumber();
        memberIndianaModel.ClientOtherID = commons.generateUniqueNumber();
        memberIndianaModel.ClientSuffix = " ";
        memberIndianaModel.Action = "A";
        memberIndianaModel.PayerID = "INFSSA";
        memberIndianaModel.PayerProgram = "Indiana";
        memberIndianaModel.PayerService = "S5125";
        memberIndianaModel.PayerRegion = " ";
        memberIndianaModel.ProviderQualifier = "NPI";
        memberIndianaModel.ProviderID = "CN00111A001";
        memberIndianaModel.CaseManager = "";
        memberIndianaModel.ClientCaseManager = "";
        memberIndianaModel.clientCoordinatorEmail = "";
        memberIndianaModel.ClientLanguage = "English";
        memberIndianaModel.ClientGender = "M";
        memberIndianaModel.ClientMaritalStatus = "";
        memberIndianaModel.ClientBirthDate = "";
        memberIndianaModel.ClientEmail = "";
        memberIndianaModel.ClientPriority = "";
        memberIndianaModel.ClientContactType = "";
        memberIndianaModel.ClientAddressType = "Home";
        memberIndianaModel.ClientAddressLine1 = "45 Commerce Dr";
        memberIndianaModel.ClientAddressLine2 = "Suite 1";
        memberIndianaModel.ClientCounty = "Kennebec";
        memberIndianaModel.ClientCity = "Augusta";
        memberIndianaModel.ClientState = "ME";
        memberIndianaModel.ClientZip = "04330";
        memberIndianaModel.ClientPhoneType = "Home";
        memberIndianaModel.ClientPhone = "2078921864";
        memberIndianaModel.EligibilityPayerID = "INFSSA";
        memberIndianaModel.EligibilityPayerProgram = "Indiana";
        memberIndianaModel.ClientEligibilityDateBegin = "2009-01-01";
        memberIndianaModel.ClientEligibilityDateEnd = "2068-12-31";
        memberIndianaModel.ClientStartOfCareDate = " ";
        memberIndianaModel.ClientEndOfCareDate = " ";
        memberIndianaModel.ClientPrimaryDiagnosisCode = " ";
        memberIndianaModel.ClientSecondaryDiagnosisCode = " ";
        memberIndianaModel.ClientStatus = "02";
        memberIndianaModel.ClientStatusDate = " ";
        memberIndianaModels.add(memberIndianaModel);

        fields.put("memberModel.ClientOtherID", memberIndianaModel.ClientCustomID);
    }

    public String createHeaderForMaine() {
        Class currentClass = MemberModel.class;
        String header_line = "";
        Field[] fields = currentClass.getDeclaredFields();
        int last = fields.length - 1;
        String name = "";
        for (int i = 0; i <= fields.length - 1; i++) {
            if (i == last) {
                name = "\"" + fields[i].getName() + "\"";
            } else {
                name = "\"" + fields[i].getName() + "\"" + "|";
            }
            header_line += name;
        }
        return header_line;
    }

    public String createHeaderForIndiana() {
        Class currentClass = MemberIndianaModel.class;
        String header_line = "";
        Field[] fields = currentClass.getDeclaredFields();
        int last = fields.length - 1;
        String name = "";
        for (int i = 0; i <= fields.length - 1; i++) {
            if (i == last) {
                name = "\"" + fields[i].getName() + "\"";
            } else {
                name = "\"" + fields[i].getName() + "\"" + "|";
            }
            header_line += name;
        }
        return header_line;
    }

    public List<MemberModel> getMemberModels() {
        return memberModels;
    }

    public void setMemberModels(List<MemberModel> memberModels) {
        this.memberModels = memberModels;
    }

    @Override
    public void toGPG() throws IOException {
        encrypted_filename_member = ENCRYPTED_PATH + fileName_Member + "." + EXTENSION.gpg;
        PGPUtils.encryptFile(encrypted_filename_member,
                TO_ENCRYPT_PATH + fileName_Member, MOLINA_PUBLIC_KEY_PATH,
                false, false, SymmetricKeyAlgorithmTags.TRIPLE_DES);
    }

    @Override
    public void toPGP() throws IOException {
        encrypted_filename_member = ENCRYPTED_PATH + fileName_Member + "." + EXTENSION.pgp;
        PGPUtils.encryptFile(encrypted_filename_member,
                TO_ENCRYPT_PATH + fileName_Member, MOLINA_PUBLIC_KEY_PATH,
                false, false, SymmetricKeyAlgorithmTags.TRIPLE_DES);
    }

    @Override
    public void toSFTP(String localFilePath, String sftpFolder) {
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
        SftpUtils.sendFile(sftpConfig, sftp_import_indiana_folder, encrypted_filename_member);
    }

    @Override
    public void toSFTP(ACCOUNT_TYPE account_type, SftpUtils.FileType fileType){
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
                    SftpUtils.sendFile(sftpConfig, sftp_import_molina_folder, TO_ENCRYPT_PATH + fileName_Member);
                } else {
                    SftpUtils.sendFile(sftpConfig, sftp_import_molina_folder, encrypted_filename_member);
                }
                logInfo(String.format("Account '%s', Uploaded file '%s' to sftp folder: %s", account_type, encrypted_filename_member, sftp_import_molina_folder));
                break;
            case INDIANA:
                sftpConfig.setHost(SFTP_HOST);
                sftpConfig.setPort(SFTP_PORT);
                sftpConfig.setUsername(SFTP_IMPORT_USERNAME);
                sftpConfig.setPassword(SFTP_IMPORT_MATKHAU);
                if(fileType.equals(EXTENSION.txt)){
                    SftpUtils.sendFile(sftpConfig, sftp_import_indiana_folder, TO_ENCRYPT_PATH + fileName_Member);
                } else {
                    SftpUtils.sendFile(sftpConfig, sftp_import_indiana_folder, encrypted_filename_member);
                }
                logInfo(String.format("Account '%s', Uploaded file '%s' to sftp folder: %s", account_type, encrypted_filename_member, sftp_import_indiana_folder));
                break;
        }
    }
}
