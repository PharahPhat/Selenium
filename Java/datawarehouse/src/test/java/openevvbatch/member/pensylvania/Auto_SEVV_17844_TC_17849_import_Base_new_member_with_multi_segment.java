package openevvbatch.member.pensylvania;

import com.interop.common.constants.utils.RabbitMQUtils;
import com.interop.common.constants.utils.TriggerUtils;
import com.interop.models.db.staging.StagingClientAddress;
import com.interop.models.db.staging.StagingClientContact;
import com.interop.models.db.staging.StagingClientEligibilities;
import com.interop.models.db.staging.StagingClientPhones;
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

public class Auto_SEVV_17844_TC_17849_import_Base_new_member_with_multi_segment extends ImportBaseTest {
    final String queueName = "QAAutomation";
    List<StagingClientContact> client_contacts = new ArrayList<>();
    List<StagingClientContact> client_designees = new ArrayList<>();
    List<StagingClientAddress> client_addresses = new ArrayList<>();
    List<StagingClientEligibilities> client_eligibilities = new ArrayList<>();
    List<StagingClientPhones> client_phones = new ArrayList<>();
    ImportMemberService importMemberService;

    @Test(groups = {"non-regression"})
    public void TC_17849_import_new_member_with_multi_segment() throws Exception {

        importMemberService = new ImportMemberService();
        setDstPath(ImportServices.config.getEnvironment("Default_Upload_folder_SFTP"));
        setToInboxPath(ImportServices.config.getEnvironment("Default_folder_Get_Error_SFTP"));

        importMemberService.generateFileWithMultipleLine(6);
        List listMembers = importMemberService.getRecords();

        MemberCSVModel memberCSVModel1 = (MemberCSVModel) listMembers.get(0);
        MemberCSVModel memberCSVModel2 = (MemberCSVModel) listMembers.get(1);
        MemberCSVModel memberCSVModel3 = (MemberCSVModel) listMembers.get(2);
        MemberCSVModel memberCSVModel4 = (MemberCSVModel) listMembers.get(3);
        MemberCSVModel memberCSVModel5 = (MemberCSVModel) listMembers.get(4);
        MemberCSVModel memberCSVModel6 = (MemberCSVModel) listMembers.get(5);

        baseObj.info("Prepare data before starting");
        String clientOtherID = String.valueOf(baseObj.intRandom(9));
        List<MemberCSVModel> listClientInfo = new ArrayList<>();

        memberCSVModel1.setClientOtherID(clientOtherID);

        memberCSVModel2.setClientOtherID(clientOtherID);
        memberCSVModel2.setSegmentName("ClientAddress");
        memberCSVModel2.setClientAddressLine1(Wrapper.generateRandomString(10));
        memberCSVModel2.setClientAddressLine2(Wrapper.generateRandomString(10));

        memberCSVModel3.setClientOtherID(clientOtherID);
        memberCSVModel3.setSegmentName("ClientContact");
        memberCSVModel3.setClientContactFirstName(Wrapper.generateRandomString(10));
        memberCSVModel3.setClientContactLastName(Wrapper.generateRandomString(10));

        memberCSVModel4.setClientOtherID(clientOtherID);
        memberCSVModel4.setSegmentName("ClientPhone");
        memberCSVModel4.setClientPhone(baseObj.generateRandomNumberObsolete(10));
        memberCSVModel4.setClientPhoneType("Home");

        memberCSVModel5.setClientOtherID(clientOtherID);
        memberCSVModel5.setSegmentName("ClientEligibility");
        memberCSVModel5.setClientEligibilityDateBegin("2018-01-01");
        memberCSVModel5.setClientEligibilityDateEnd("2019-01-01");

        memberCSVModel6.setClientOtherID(clientOtherID);
        memberCSVModel6.setSegmentName("ClientDesignee");
        memberCSVModel6.setClientDesigneeLastName(Wrapper.generateRandomString(10));
        memberCSVModel6.setClientDesigneeFirstName(Wrapper.generateRandomString(10));
        memberCSVModel6.setClientDesigneeEmail(Wrapper.generateRandomString(10) + "@email.com");

        listClientInfo.add(memberCSVModel1);
        listClientInfo.add(memberCSVModel2);
        listClientInfo.add(memberCSVModel3);
        listClientInfo.add(memberCSVModel4);
        listClientInfo.add(memberCSVModel5);
        listClientInfo.add(memberCSVModel6);

        baseObj.info("Step 1: Prepare test data");
        importMemberService.initFileImportMemberAndOutboundWithCustomData(listClientInfo);

        baseObj.info("Step 2: Upload file to SFTP server");
        RabbitMQUtils.purseMessage(queueName);
        importMemberService.uploadFileToServer(importMemberService.getListFileUpload(), getDstPath());
        TriggerUtils.runTriggerForSpecificService(TriggerUtils.servicesNeedToTrigger.EVV_IMPORT_MEMBER);

        baseObj.info("Step 3: Check is the message store on RabbitMQ");
        List<String> listMessages = RabbitMQUtils.getMessagesFromQueue(queueName);

        baseObj.info("Step 4: Verify message on queue with import file");
        ClientModel bodyOnRabbitMQ = RabbitMQUtils.parseSpecificMessageOnQueueToModel(listMessages, ClientModel.class, clientOtherID);

        baseObj.info("Step 4.1: Verify number element of client phone on rabbitMQ");
        Assert.assertEquals(Objects.requireNonNull(bodyOnRabbitMQ).getClientPhones().size(), 2);

        baseObj.info("Step 4.2: Verify number element of client address on rabbitMQ");
        Assert.assertEquals(Objects.requireNonNull(bodyOnRabbitMQ).getClientAddress().size(), 2);

        baseObj.info("Step 4.3: Verify number element of client elig on rabbitMQ");
        Assert.assertEquals(Objects.requireNonNull(bodyOnRabbitMQ).getClientElig().size(), 2);

        baseObj.info("Step 4.4: Verify number element of client designee on rabbitMQ");
        Assert.assertEquals(Objects.requireNonNull(bodyOnRabbitMQ).getClientDesignees().size(), 1);

        baseObj.info("Step 4.5: Verify number element of client conatct on rabbitMQ");
        Assert.assertEquals(Objects.requireNonNull(bodyOnRabbitMQ).getClientContact().size(), 2);


        baseObj.info("Step 5: Verify records in MySQL staging");
        client_addresses = ClientMySqlDBServices.getClientAddrRecords(clientOtherID, "60130");// Error record will be stored in each table
        Assert.assertEquals(client_addresses.size(), 3);

        client_phones = ClientMySqlDBServices.getClientPhoneRecords(clientOtherID, "60130"); // Error record will be stored in each table
        Assert.assertEquals(client_phones.size(), 3);

        client_eligibilities = ClientMySqlDBServices.getClientEligRecords(clientOtherID, "60130");// Error record will be stored in each table
        Assert.assertEquals(client_eligibilities.size(), 3);

        client_contacts = ClientMySqlDBServices.getClientContRecords(clientOtherID, "60130", "EC");// Error record will be stored in each table
        Assert.assertEquals(client_contacts.size(), 3);

        client_designees = ClientMySqlDBServices.getClientContRecords(clientOtherID, "60130", "CD");
        Assert.assertEquals(client_designees.size(), 2);

    }
}
