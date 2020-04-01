package generic.import_feature.indiana;

import com.sandata.common.Constant;
import com.sandata.utilities.sftp.utils.SftpUtils;
import generic.import_feature.ImportGenericTest;
import org.testng.Assert;

import java.io.IOException;

import static com.sandata.common.Constant.ACCOUNT_TYPE.INDIANA;

public class ImportIndianaGenericTest extends ImportGenericTest {

    public void createAndImportIndianaProviderGPG() throws IOException {
        importProviderModel.initIndianaData();
        importProviderModel.toFile(INDIANA);
        importProviderModel.toGPG();

        importOutboundControlModel.initDataIndiana(importProviderModel.fields);
        importOutboundControlModel.toFile();
        importOutboundControlModel.toGPG();

        importOutboundControlModel.toSFTP(INDIANA, SftpUtils.FileType.ZIP);
        importProviderModel.toSFTP(INDIANA, SftpUtils.FileType.ZIP);

    }

    public void createAndImportIndianaProviderPGP() throws IOException {
        importProviderModel.initIndianaData();
        importProviderModel.toFile(INDIANA);
        importProviderModel.toPGP();

        importOutboundControlModel.initDataIndiana(importProviderModel.fields);
        importOutboundControlModel.toFile();
        importOutboundControlModel.toPGP();

        importOutboundControlModel.toSFTP(INDIANA, SftpUtils.FileType.ZIP);
        importProviderModel.toSFTP(INDIANA, SftpUtils.FileType.ZIP);
    }

    public void createAndImportIndianaUnencryptedProvider() {
        importProviderModel.initIndianaData();
        importProviderModel.toFile(INDIANA);

        importOutboundControlModel.initDataIndiana(importProviderModel.fields);
        importOutboundControlModel.toFile();

        importOutboundControlModel.toSFTP(INDIANA, SftpUtils.FileType.TXT);
        importProviderModel.toSFTP(INDIANA, SftpUtils.FileType.TXT);

    }

    public void verifyProviderExistInDB() {
        waitETLJobToProcess(3);
        boolean result = false;
        if (providerDbService.isProviderIdExistedInDb(importProviderModel.providerModel.ProviderID)) {
            logPass(String.format("Provider '%s' exists in DB", importProviderModel.providerModel.ProviderID));
            result = true;
        } else {
            logError(String.format("Provider '%s' not exists in DB", importProviderModel.providerModel.ProviderID));
            result = false;
        }
        Assert.assertTrue(result);
    }

    public void verifyProviderNotExistInDB() {
        waitETLJobToProcess(3);
        boolean result = false;
        if (!providerDbService.isProviderIdExistedInDb(importProviderModel.providerModel.ProviderID)) {
            logPass(String.format("Provider '%s' not exists in DB", importProviderModel.providerModel.ProviderID));
            result = true;
        } else {
            logError(String.format("Provider '%s' exists in DB", importProviderModel.providerModel.ProviderID));
            result = false;
        }
        Assert.assertTrue(result);
    }

    public void createAndImportMemberWithActiveAuth(Constant.EXTENSION extension) throws IOException {

        importMemberModel.initIndianaData();
        importMemberModel.toFile(INDIANA);

        importOutboundControlModel.initDataForIndiana(importMemberModel.fields);
        importOutboundControlModel.toFile();
        if (extension == Constant.EXTENSION.gpg) {
            importMemberModel.toGPG();
            importOutboundControlModel.toGPG();
        } else {
            importMemberModel.toPGP();
            importOutboundControlModel.toPGP();
        }
        importMemberModel.toSFTP();
        importOutboundControlModel.toSFTP();
    }

    public void createAndImportMemberWithInActiveAuth() throws IOException {

        importMemberModel.initIndianaData();
        importMemberModel.toFile();
        importMemberModel.toGPG();

        importPriorAuthModel.initMaineDataWithInactiveAuth(importMemberModel.fields);
        importPriorAuthModel.toFile();
        importPriorAuthModel.toGPG();

        importOutboundControlModel.initData(importMemberModel.fields, importPriorAuthModel.fields);
        importOutboundControlModel.toFile();
        importOutboundControlModel.toGPG();

        importMemberModel.toSFTP();
        importPriorAuthModel.toSFTP();
        importOutboundControlModel.toSFTP();
    }

    public void createAndImportMemberWithActiveAndInActiveAuth() throws IOException {

        importMemberModel.initIndianaData();
        importMemberModel.toFile();
        importMemberModel.toGPG();

        importPriorAuthModel.initMaineDataWithActiveAndInactiveAuth(importMemberModel.fields);
        importPriorAuthModel.toFile();
        importPriorAuthModel.toGPG();

        importOutboundControlModel.initData(importMemberModel.fields, importPriorAuthModel.fields);
        importOutboundControlModel.toFile();
        importOutboundControlModel.toGPG();

        importMemberModel.toSFTP();
        importPriorAuthModel.toSFTP();
        importOutboundControlModel.toSFTP();
    }

    public void waitETLJobToProcess(int minutes) {
        int duration = 1000 * 60 * minutes;
        int minute = 1000 * 60;
        int tenSeconds = 1000 * 10;
        int timePassed = 0;
        while (timePassed < duration) {
            baseObj.sleep(tenSeconds);
            timePassed += tenSeconds;
            logStepInfo("Time passed: " + (timePassed / 1000) + " seconds.");
        }

    }

    public void verifyClientExistInDBForMaine() {
        waitETLJobToProcess(3);
        boolean result = false;
        if (clientDbService.isClientFNameExistingInDB("28000", importMemberModel.memberModel.ClientFirstName)) {
            logPass(String.format("Client '%s' of account '%s' exists in DB", "28000", importMemberModel.memberModel.ClientFirstName));
            result = true;
        } else {
            logError(String.format("Client '%s' of account '%s' not exists in DB", "28000", importMemberModel.memberModel.ClientFirstName));
        }
        Assert.assertTrue(result);
    }

    public void verifyClientExistInDBForIndiana() {
        waitETLJobToProcess(3);
        boolean result = false;
        if (clientDbService.isClientFNameExistingInDB("29017", importMemberModel.memberIndianaModel.ClientFirstName)) {
            logPass(String.format("Client '%s' of account '%s' exists in DB", "29017", importMemberModel.memberIndianaModel.ClientFirstName));
            result = true;
        } else {
            logError(String.format("Client '%s' of account '%s' not exists in DB", "29017", importMemberModel.memberIndianaModel.ClientFirstName));
            result = false;
        }
        Assert.assertTrue(result);
    }

    public void verifyClientNotExistInDB() {
        waitETLJobToProcess(3);
        boolean result = true;
        if (clientDbService.isClientFNameExistingInDB("28000", importMemberModel.memberModel.ClientFirstName)) {
            logError(String.format("Client '%s' of account '%s' exists in DB", "28000", importMemberModel.memberModel.ClientFirstName));
            result = false;
        } else {
            logPass(String.format("Client '%s' of account '%s' not exists in DB", "28000", importMemberModel.memberModel.ClientFirstName));
            result = true;
        }
        Assert.assertTrue(result);
    }
}
