package openevvbatch.provider.pennsylvania;

import com.interop.common.constants.utils.RabbitMQUtils;
import com.interop.models.db.inbox.InboxProvider;
import com.interop.models.db.stx.STXProvider;
import com.interop.models.openevv.provider.OpenEvvProviderModel;
import com.interop.services.base.ImportBaseTest;
import com.interop.services.openevv.batch.ImportProviderService;
import com.interop.services.openevv.batch.ImportServices;
import org.apache.commons.lang.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static com.interop.common.constants.utils.TriggerUtils.runTriggerForSpecificService;
import static com.interop.common.constants.utils.TriggerUtils.servicesNeedToTrigger.EVV_IMPORT_PROVIDER;
import static com.interop.common.constants.utils.db.ProviderDBUtils.*;

public class Auto_SEVV_16936_TC_20772_Mix_duplicate_providerID_with_the_unique_provider extends ImportBaseTest {
    final String queueName = "QAAutomation";
    ImportProviderService importProviderService;
    int totalRecords = 4;

    @Test(groups = {"non-regression"})
    public void Mix_duplicate_provider_with_the_unique_provider() throws Exception {
        String first9Digits = baseObj.generateRandomNumberObsolete(9);
        importProviderService = new ImportProviderService();

        importProviderService.generateFileWithMultipleLine(totalRecords);
        List<OpenEvvProviderModel> listProviderInfo = new ArrayList<>();
        List<String> listProviderID = new ArrayList<>();
        for (int i = 0; i < importProviderService.getRecords().size(); i++) {
            OpenEvvProviderModel providerInfo = new OpenEvvProviderModel();
            String providerID = first9Digits + RandomStringUtils.randomNumeric(4);
            providerInfo.setProviderID(providerID);
            providerInfo.setAgencyEmail(RandomStringUtils.randomAlphabetic(13) + "@gmail.com");
            if (i == importProviderService.getRecords().size() - 1) {
                providerID = importProviderService.generateDistinct13CharsValue();
                providerInfo.setProviderID(providerID);
                providerInfo.setProviderName("UNIQUE PROVIDER MIXING");
            }
            listProviderInfo.add(providerInfo);
            listProviderID.add(providerID);
        }

        baseObj.info("Step 1: Prepare test data");
        importProviderService.initFileImportProviderAndOutboundWithCustomData(listProviderInfo);

        baseObj.info("Step 2: Upload file to SFTP server");
        //Clean up queue before upload file
        RabbitMQUtils.purseMessage("QAAutomation");
        importProviderService.uploadFileToServer(importProviderService.getListFileUpload(), ImportServices.config.getEnvironment("Default_Upload_folder_SFTP"));

        runTriggerForSpecificService(EVV_IMPORT_PROVIDER);//Run trigger to make the service import auth run first
        baseObj.info("Step 3: Verify is Provider Passed OPEN EVV DB table INBOX");
        isProviderStoredToINBOXWithoutError(first9Digits.substring(0, 9));

        String storedProviderID = listProviderID.get(0).substring(0, 9);
        List<InboxProvider> inboxProviderList = getRecordProviderInbox(storedProviderID);
        //Verify in INBOX
        baseObj.info("Verify Data of the provider having duplicate line in file inside DB");
        baseObj.validateActualAndExpectedText(inboxProviderList.get(0).getCOMPNAME().toString(), "KMSAUTO AMP INTEROP");
        Assert.assertNull(inboxProviderList.get(0).getPROVIDER_BEG_DATE());

        //Verify in STX
        List<STXProvider> providerStored = getRecordProviderSTX(storedProviderID);
        baseObj.info("Verify Provider name");
        baseObj.validateActualAndExpectedText(providerStored.get(0).getPROVIDER_NAME().toString(), "KMSAUTO AMP INTEROP");
        baseObj.info("Verify Provider ID");
        baseObj.validateActualAndExpectedText(providerStored.get(0).getPROVIDER_ID().toString(), storedProviderID);

        baseObj.info("Verify Data of the provider having unique line in file inside DB");
        //Verify in INBOX
        List<STXProvider> providerUnique = getRecordProviderSTX(listProviderID.get(3).substring(0, 9));
        List<InboxProvider> inboxProviderListOfUnique = getRecordProviderInbox((String) providerUnique.get(0).getPROVIDER_ID());
        baseObj.info("Verify Provider name of the Duplicate provider in INBOX table");
        baseObj.validateActualAndExpectedText(inboxProviderListOfUnique.get(0).getCOMPNAME().toString(), "UNIQUE PROVIDER MIXING");
        Assert.assertNull(inboxProviderListOfUnique.get(0).getPROVIDER_BEG_DATE());

        //Verify in STX
        baseObj.info("Verify Provider name of the Unique provider in STX table");
        baseObj.validateActualAndExpectedText(providerUnique.get(0).getPROVIDER_NAME().toString(), "UNIQUE PROVIDER MIXING");
        baseObj.info("Verify Provider ID of the Unique provider in STX table");
        baseObj.validateActualAndExpectedText(providerUnique.get(0).getPROVIDER_ID().toString(), listProviderID.get(3).substring(0, 9));

        baseObj.info("Step 4: Check is the message store on RabbitMQ");
        List<String> listMessages = RabbitMQUtils.getMessagesFromQueue(queueName);
        int totalMessageProviderOnQueue = 0;
        for (String message : listMessages) {
            for (String providerID : listProviderID) {
                if (message.contains(providerID))
                    totalMessageProviderOnQueue++;
            }
        }
        Assert.assertEquals(totalMessageProviderOnQueue, totalRecords);
    }
}


