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

import static com.interop.common.constants.utils.db.ProviderDBUtils.*;

public class Auto_SEVV_16936_TC_20771_Duplicate_ProviderID_And_Same_StartDate extends ImportBaseTest {
    final String queueName = "QAAutomation";
    ImportProviderService importProviderService;
    int totalRecords = 10;

    @Test(groups = {"non-regression"})
    public void Import_the_file_having_multiple_lines_duplicate_the_first_9_digits_characters_in_provider_ID_AND_the_same_start_date() throws Exception {
        String first9Digits = baseObj.generateRandomNumberObsolete(9);
        importProviderService = new ImportProviderService();

        importProviderService.generateFileWithMultipleLine(totalRecords);
        List<OpenEvvProviderModel> listProviderInfo = new ArrayList<>();
        List<String> listProviderID = new ArrayList<>();
        for (int i = 0; i < importProviderService.getRecords().size(); i++) {
            OpenEvvProviderModel providerInfo = new OpenEvvProviderModel();
            String providerID = first9Digits + RandomStringUtils.randomAlphabetic(4);
            providerInfo.setProviderID(providerID);
            providerInfo.setAgencyEmail(RandomStringUtils.randomAlphabetic(13) + "@gmail.com");
            providerInfo.setProviderDateBegin("2010-12-12");
            if (i == 0) {
                providerInfo.setProviderName("SEVV_16936");
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

        baseObj.info("Step 3: Verify is Provider Passed OPEN EVV DB table INBOX");
        isProviderStoredToINBOXWithoutError(first9Digits.substring(0, 9));

        String storedProviderID = listProviderID.get(0).substring(0, 9);
        List<InboxProvider> inboxProviderList = getRecordProviderInbox(storedProviderID);
        //Verify in INBOX
        baseObj.info("Compare name and provider begin date between file import and the stored data in INBOX");
        baseObj.info("Verify Provider name in INBOX table");
        baseObj.validateActualAndExpectedText(inboxProviderList.get(0).getCOMPNAME().toString(), listProviderInfo.get(0).getProviderName());
        baseObj.info("Verify Provider start date in INBOX table");
        baseObj.validateActualAndExpectedText(inboxProviderList.get(0).getPROVIDER_BEG_DATE().toString().trim(), "2010-12-12 00:00:00.0");

        //Verify in STX
        baseObj.info("Compare name and provider begin date between file import and the stored data in STX");
        List<STXProvider> providerStored = getRecordProviderSTX(storedProviderID);
        baseObj.info("Verify Provider name in STX table");
        baseObj.validateActualAndExpectedText(providerStored.get(0).getPROVIDER_NAME().toString(), listProviderInfo.get(0).getProviderName());
        baseObj.info("Verify Provider start date in STX table");
        baseObj.validateActualAndExpectedText(providerStored.get(0).getPROVIDER_ID().toString(), storedProviderID);

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


