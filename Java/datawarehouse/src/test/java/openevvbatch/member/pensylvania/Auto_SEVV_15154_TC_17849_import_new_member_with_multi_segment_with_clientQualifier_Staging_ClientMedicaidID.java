package openevvbatch.member.pensylvania;

import com.interop.common.constants.utils.RabbitMQUtils;
import com.interop.models.db.staging.StagingClient;
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

public class Auto_SEVV_15154_TC_17849_import_new_member_with_multi_segment_with_clientQualifier_Staging_ClientMedicaidID extends ImportBaseTest {
    final String queueName = "QAAutomation";
    ImportMemberService importMemberService;

    @Test(groups = {"non-regression"})
    public void TC_17849_import_new_member_with_multi_segment() throws Exception {

        importMemberService = new ImportMemberService();
        importMemberService.addColumn("ClientMedicaidID");

        importMemberService.generateFileWithMultipleLine(6);
        List listMembers = importMemberService.getRecords();

        MemberCSVModel memberCSVModel1 = (MemberCSVModel) listMembers.get(0);
        MemberCSVModel memberCSVModel2 = (MemberCSVModel) listMembers.get(1);
        MemberCSVModel memberCSVModel3 = (MemberCSVModel) listMembers.get(2);
        MemberCSVModel memberCSVModel4 = (MemberCSVModel) listMembers.get(3);
        MemberCSVModel memberCSVModel5 = (MemberCSVModel) listMembers.get(4);
        MemberCSVModel memberCSVModel6 = (MemberCSVModel) listMembers.get(5);

        baseObj.info("Prepare data before starting");
        String clientMedicaidID = importMemberService.generateDistinct13CharsValue();
        List<MemberCSVModel> listClientInfo = new ArrayList<>();

        memberCSVModel1.setClientMedicaidID(clientMedicaidID);
        memberCSVModel1.setClientOtherID(clientMedicaidID);
        memberCSVModel1.setClientCustomID(clientMedicaidID);

        memberCSVModel2.setClientMedicaidID(clientMedicaidID);
        memberCSVModel2.setSegmentName("ClientAddress");
        memberCSVModel2.setClientAddressLine1(Wrapper.generateRandomString(10));
        memberCSVModel2.setClientAddressLine2(Wrapper.generateRandomString(10));
        memberCSVModel2.setClientOtherID(clientMedicaidID);


        memberCSVModel3.setClientMedicaidID(clientMedicaidID);
        memberCSVModel3.setSegmentName("ClientContact");
        memberCSVModel3.setClientContactFirstName(Wrapper.generateRandomString(10));
        memberCSVModel3.setClientContactLastName(Wrapper.generateRandomString(10));
        memberCSVModel3.setClientOtherID(clientMedicaidID);

        memberCSVModel4.setClientMedicaidID(clientMedicaidID);
        memberCSVModel4.setSegmentName("ClientPhone");
        memberCSVModel4.setClientPhone(baseObj.generateRandomNumberObsolete(10));
        memberCSVModel4.setClientPhoneType("Home");
        memberCSVModel4.setClientOtherID(clientMedicaidID);

        memberCSVModel5.setClientMedicaidID(clientMedicaidID);
        memberCSVModel5.setSegmentName("ClientEligibility");
        memberCSVModel5.setClientEligibilityDateBegin("2018-01-01");
        memberCSVModel5.setClientEligibilityDateEnd("2019-01-01");
        memberCSVModel5.setClientOtherID(clientMedicaidID);


        memberCSVModel6.setClientMedicaidID(clientMedicaidID);
        memberCSVModel6.setSegmentName("ClientDesignee");
        memberCSVModel6.setClientDesigneeLastName(Wrapper.generateRandomString(10));
        memberCSVModel6.setClientDesigneeFirstName(Wrapper.generateRandomString(10));
        memberCSVModel6.setClientDesigneeEmail("TestData@email.com");
        memberCSVModel6.setClientOtherID(clientMedicaidID);

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
        importMemberService.uploadFileToServer(importMemberService.getListFileUpload(), ImportServices.config.getEnvironment("Default_Upload_folder_SFTP"));

        baseObj.info("Step 3: Check is the message store on RabbitMQ");
        List<String> listMessages = RabbitMQUtils.getMessagesFromQueue(queueName);

        baseObj.info("Step 4: Verify message on queue with import file");
        ClientModel bodyOnRabbitMQ = RabbitMQUtils.parseSpecificMessageOnQueueToModel(listMessages, ClientModel.class, clientMedicaidID);

        baseObj.info("Step 4.1: Verify number element of client phone on rabbitMQ");
        Assert.assertEquals(Objects.requireNonNull(bodyOnRabbitMQ).getClientPhones().size(), 2);

        baseObj.info("Step 4.2: Verify number element of client address on rabbitMQ");
        Assert.assertEquals(Objects.requireNonNull(bodyOnRabbitMQ).getClientAddress().size(), 2);

        baseObj.info("Step 4.3: Verify number element of client elig on rabbitMQ");
        Assert.assertEquals(Objects.requireNonNull(bodyOnRabbitMQ).getClientElig().size(), 2);

        baseObj.info("Step 4.4: Verify number element of client designee on rabbitMQ");
        Assert.assertEquals(Objects.requireNonNull(bodyOnRabbitMQ).getClientDesignees().size(), 2);

        baseObj.info("Step 4.5: Verify number element of client conatct on rabbitMQ");
        Assert.assertEquals(Objects.requireNonNull(bodyOnRabbitMQ).getClientContact().size(), 2);

        baseObj.info("Step 5: Verify records in MySQL staging");
        List<StagingClient> recordStaging = ClientMySqlDBServices.getClientBasicInformation(clientMedicaidID, "60130");
        Assert.assertEquals(recordStaging.size(), 1);
        Assert.assertEquals(recordStaging.get(0).getClient_medicaid_id(), clientMedicaidID);
    }
}
