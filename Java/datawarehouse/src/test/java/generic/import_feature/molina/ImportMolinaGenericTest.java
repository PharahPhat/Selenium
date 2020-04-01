package generic.import_feature.molina;

import com.sandata.common.Constant;
import com.sandata.models.importModel.Auth.ImportPriorAuthModel;
import com.sandata.models.importModel.Control.ImportOutboundControlModel;
import com.sandata.models.importModel.Member.ImportMemberModel;
import com.sandata.models.splunk.SearchSummary;
import com.sandata.ws.SplunkWebService;
import generic.import_feature.ImportGenericTest;
import org.testng.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.sandata.common.Constant.ACCOUNT_TYPE.MOLINA;
import static com.sandata.common.Constant.EXTENSION.gpg;

public class ImportMolinaGenericTest extends ImportGenericTest {

    public void createAndImportMolinaMemberWithActiveAuth() throws IOException {

        importMemberModel.initMaineData();
        importMemberModel.toFile(MOLINA);
        importMemberModel.toGPG();

        importPriorAuthModel.initMaineData(importMemberModel.fields);
        importPriorAuthModel.toFile(MOLINA);
        importPriorAuthModel.toGPG();

        importOutboundControlModel.initData(importMemberModel.fields, importPriorAuthModel.fields);
        importOutboundControlModel.toFile();
        importOutboundControlModel.toGPG();

        importMemberModel.toSFTP(MOLINA, gpg);
        importPriorAuthModel.toSFTP(MOLINA, gpg);
        importOutboundControlModel.toSFTP(MOLINA, gpg);

        importMemberModels.add(importMemberModel);
    }

    public void createAndImportMolinaMemberWithInActiveAuth() throws IOException {

        importMemberModel.initMaineData();
        importMemberModel.toFile(MOLINA);
        importMemberModel.toGPG();

        importPriorAuthModel.initMaineDataWithInactiveAuth(importMemberModel.fields);
        importPriorAuthModel.toFile(MOLINA);
        importPriorAuthModel.toGPG();

        importOutboundControlModel.initData(importMemberModel.fields, importPriorAuthModel.fields);
        importOutboundControlModel.toFile();
        importOutboundControlModel.toGPG();

        importMemberModel.toSFTP(MOLINA, gpg);
        importPriorAuthModel.toSFTP(MOLINA, gpg);
        importOutboundControlModel.toSFTP(MOLINA, gpg);

        importMemberModels.add(importMemberModel);
    }

    public void createAndImportMolinaMemberWithActiveAndInActiveAuth() throws IOException {

        importMemberModel.initMaineData();
        importMemberModel.toFile(MOLINA);
        importMemberModel.toGPG();

        importPriorAuthModel.initMaineDataWithActiveAndInactiveAuth(importMemberModel.fields);
        importPriorAuthModel.toFile(MOLINA);
        importPriorAuthModel.toGPG();

        importOutboundControlModel.initData(importMemberModel.fields, importPriorAuthModel.fields);
        importOutboundControlModel.toFile();
        importOutboundControlModel.toGPG();

        importMemberModel.toSFTP(MOLINA, gpg);
        importPriorAuthModel.toSFTP(MOLINA, gpg);
        importOutboundControlModel.toSFTP(MOLINA, gpg);

        importMemberModels.add(importMemberModel);
    }

    public void createAndImportMolinaMemberWithMultipleMember(int count) throws IOException {

        importMemberModel.initMultipleMaineMembers(count);
        importMemberModel.toFile(MOLINA);
        importMemberModel.toGPG();

        importPriorAuthModel.initMultipleMaineAuth(importMemberModel.fields, count);
        importPriorAuthModel.toFile(MOLINA);
        importPriorAuthModel.toGPG();

        importOutboundControlModel.initData(importMemberModel.fields, importPriorAuthModel.fields);
        importOutboundControlModel.toFile();
        importOutboundControlModel.toGPG();

        importMemberModel.toSFTP(MOLINA, gpg);
        importPriorAuthModel.toSFTP(MOLINA, gpg);
        importOutboundControlModel.toSFTP(MOLINA, gpg);

        importMemberModels.add(importMemberModel);
    }

    public void createAndImportMolinaMemberWithMultipleFileAndMultipleMember(int count) throws IOException {

        for (int i = 1; i <= count; i++) {
            ImportMemberModel importMemberModel = new ImportMemberModel();
            importMemberModel.initMultipleMaineMembers(count);
            importMemberModel.toFile(MOLINA);
            importMemberModel.toGPG();

            ImportPriorAuthModel importPriorAuthModel = new ImportPriorAuthModel();
            importPriorAuthModel.initMultipleMaineAuth(importMemberModel.fields, count);
            importPriorAuthModel.toFile(MOLINA);
            importPriorAuthModel.toGPG();

            ImportOutboundControlModel importOutboundControlModel = new ImportOutboundControlModel();
            importOutboundControlModel.initData(importMemberModel.fields, importPriorAuthModel.fields);
            importOutboundControlModel.toFile();
            importOutboundControlModel.toGPG();

            importMemberModels.add(importMemberModel);
            importPriorAuthModels.add(importPriorAuthModel);
            importOutboundControlModels.add(importOutboundControlModel);
        }

        // -- we need to upload multiple files of member and auth into SFTP first
        for (int i = 0; i <= count - 1; i++) {
            importMemberModels.get(i).toSFTP(MOLINA, gpg);
            importPriorAuthModels.get(i).toSFTP(MOLINA, gpg);
        }

        // -- then upload multiple control files later, because we need ETL starts to process all files at the same time.
        for (int i = 0; i <= count - 1; i++) {
            importOutboundControlModels.get(i).toSFTP(MOLINA, gpg);
        }
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

    public boolean checkSplunkLogForImport(String fileName, int record) {
        int count = 1;
        int each = 5;
        SplunkWebService splunkWebService = new SplunkWebService();
        String message = String.format("'%s' is valid to import with record number '%s'", fileName, record);
        while (count <= 20) {
            SearchSummary searchSummary = splunkWebService.search(fileName);
            if (searchSummary != null && searchSummary.checkMessage(message)) {
                logStepInfo(String.format("Found message in '%s' time(s): %s", count, message));
                return true;
            }
            logStepInfo(String.format("Not found message in '%s' time(s): %s", count, message));
            count++;
            commons.wait(each);
            logStepInfo(String.format("Wait for '%s' seconds", each));
        }
        return false;
    }

    public void checkSplunkLogForImportingNumberOfMember(Constant.EXTENSION extension, int records) {
        checkSplunkLogForImport(importMemberModel.fileName_Member + "." + extension, records);
    }

    public void verifyClientExistInDB() {

        boolean result = false;
        int count = 1;
        int each = 5;

        while (count <= 24) {
            if (clientDbService.isClientFNameExistingInDB(account, importMemberModel.memberModel.ClientFirstName)) {
                logPass(String.format("Client '%s' of account '%s' exists in DB", importMemberModel.memberModel.ClientFirstName, account));
                result = true;
                break;
            }
            commons.wait(each);
            count++;
        }
        Assert.assertTrue(result, String.format("Client '%s' of account '%s' not exists in DB", importMemberModel.memberModel.ClientFirstName, account));
    }

    public void verifyClientNotExistInDB() {
        boolean result = true;
        if (clientDbService.isClientFNameExistingInDB(account, importMemberModel.memberModel.ClientFirstName)) {
            logError(String.format("Client '%s' of account '%s' exists in DB", importMemberModel.memberModel.ClientFirstName, account));
            result = false;
        } else {
            logPass(String.format("Client '%s' of account '%s' not exists in DB", importMemberModel.memberModel.ClientFirstName, account));
            result = true;
        }
        Assert.assertTrue(result);
    }

    public void verifyAllClientsExistInDB() {

        boolean result = false;
        int count = 1;
        int each = 5;

        firstNames = getFirstNames();
        while (count <= 24) {
            if (clientDbService.areClientsExistingInDB(account, firstNames)) {
                logAllMembers();
                result = true;
                break;
            }
            commons.wait(each);
            count++;
        }
        Assert.assertTrue(result, String.format("Client '%s' of account '%s' not exists in DB", importMemberModel.memberModel.ClientFirstName, account));
    }

    public List<String> getFirstNames() {
        firstNames = new ArrayList<>();
        for (int i = 0; i <= importMemberModels.size() - 1; i++) {

            for (int k = 0; k <= importMemberModels.get(i).memberModels.size() - 1; k++) {
                String fname = importMemberModels.get(i).memberModels.get(k).ClientFirstName;
                firstNames.add(fname);
            }
        }
        return firstNames;
    }

    public void logAllMembers() {
        for (int i = 0; i <= firstNames.size() - 1; i++) {
            logStepInfo(String.format("Client '%s' of account '%s' exists in DB", firstNames.get(i), account));
        }
    }
}
