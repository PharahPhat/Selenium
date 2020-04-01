package openevvbatch.member.pensylvania;

import com.interop.common.constants.utils.RabbitMQUtils;
import com.interop.common.constants.utils.TriggerUtils;
import com.interop.models.db.staging.StagingClientContact;
import com.interop.models.openevv.batch.MemberCSVModel;
import com.interop.services.base.ImportBaseTest;
import com.interop.services.db.ClientMySqlDBServices;
import com.interop.services.openevv.batch.ImportMemberService;
import com.interop.services.openevv.batch.ImportServices;
import com.sandata.batch.models.api.client.ClientModel;
import com.sandata.core.Wrapper;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Auto_SEVV_17844_TC_17849_import_Base_new_member_with_multi_Designees_segment extends ImportBaseTest {

    final String queueName = "QAAutomation";
    List<StagingClientContact> client_contacts = new ArrayList<>();
    ImportMemberService importMemberService;

    @Test(groups = {"non-regression"})
    public void TC_17849_import_new_member_with_multi_Designees_segment() throws Exception {

        importMemberService = new ImportMemberService();
        setDstPath(ImportServices.config.getEnvironment("Default_Upload_folder_SFTP"));
        setToInboxPath(ImportServices.config.getEnvironment("Default_folder_Get_Error_SFTP"));

        importMemberService.generateFileWithMultipleLine(2);
        List listMembers = importMemberService.getRecords();

        MemberCSVModel memberCSVModel1 = (MemberCSVModel) listMembers.get(0);
        MemberCSVModel memberCSVModel2 = (MemberCSVModel) listMembers.get(1);

        baseObj.info("Prepare data before starting");
        String clientOtherID = String.valueOf(baseObj.intRandom(9));

        List<MemberCSVModel> listClientInfo = new ArrayList<>();
        memberCSVModel1.setClientOtherID(clientOtherID);
        memberCSVModel1.setClientDesigneeLastName(Wrapper.generateRandomString(10));
        memberCSVModel1.setClientDesigneeFirstName(Wrapper.generateRandomString(10));

        memberCSVModel2.setClientOtherID(clientOtherID);
        memberCSVModel2.setSegmentName("ClientDesignee");
        memberCSVModel2.setClientDesigneeLastName(Wrapper.generateRandomString(10));
        memberCSVModel2.setClientDesigneeFirstName(Wrapper.generateRandomString(10));

        listClientInfo.add(memberCSVModel1);
        listClientInfo.add(memberCSVModel2);

        baseObj.info("Step 1: Prepare test data");
        importMemberService.initFileImportMemberAndOutboundWithCustomData(listClientInfo);

        baseObj.info("Step 2: Upload file to SFTP server");
        importMemberService.uploadFileToServer(importMemberService.getListFileUpload(), getDstPath());
        TriggerUtils.runTriggerForSpecificService(TriggerUtils.servicesNeedToTrigger.EVV_IMPORT_MEMBER);

        baseObj.info("Step 3: Check is the message store on RabbitMQ");
        RabbitMQUtils.purseMessage(queueName);
        List<String> listMessages = RabbitMQUtils.getMessagesFromQueue(queueName);

        baseObj.info("Step 4: Verify message on queue with import file");
        ClientModel bodyOnRabbitMQ = RabbitMQUtils.parseSpecificMessageOnQueueToModel(listMessages, ClientModel.class, clientOtherID);

        baseObj.info("Step 4.1: Verify number element of client designees on rabbitMQ");
        Assert.assertEquals(Objects.requireNonNull(bodyOnRabbitMQ).getClientDesignees().size(), 2);

        baseObj.info("Step 5: Verify records in MySQL staging");
        client_contacts = ClientMySqlDBServices.getClientContRecords(clientOtherID, "60130", "CD");
        Assert.assertEquals(client_contacts.size(), listMembers.size());
    }
}
