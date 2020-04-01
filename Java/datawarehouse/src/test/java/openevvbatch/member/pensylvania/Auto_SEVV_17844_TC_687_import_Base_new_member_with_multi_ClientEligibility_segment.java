package openevvbatch.member.pensylvania;

import com.interop.common.constants.utils.RabbitMQUtils;
import com.interop.common.constants.utils.TriggerUtils;
import com.interop.models.db.staging.StagingClientEligibilities;
import com.interop.models.openevv.batch.MemberCSVModel;
import com.interop.services.base.ImportBaseTest;
import com.interop.services.db.ClientMySqlDBServices;
import com.interop.services.openevv.batch.ImportMemberService;
import com.interop.services.openevv.batch.ImportServices;
import com.sandata.batch.models.api.client.ClientModel;
import com.sandata.qtest.QTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Auto_SEVV_17844_TC_687_import_Base_new_member_with_multi_ClientEligibility_segment extends ImportBaseTest {

    final String queueName = "QAAutomation";
    List<StagingClientEligibilities> client_eligibilities = new ArrayList<>();
    ImportMemberService importMemberService;

    @Test(groups = {"regression"})
    @QTest(keys = {"TC-687"})
    public void TC_687_import_new_member_with_multi_ClientEligibility_segment() throws Exception {

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
        memberCSVModel1.setClientEligibilityDateBegin("2019-01-01");
        memberCSVModel1.setClientEligibilityDateEnd("2019-12-01");

        memberCSVModel2.setClientOtherID(clientOtherID);
        memberCSVModel2.setSegmentName("ClientEligibility");
        memberCSVModel2.setClientEligibilityDateBegin("2018-01-01");
        memberCSVModel2.setClientEligibilityDateEnd("2018-12-01");
        listClientInfo.add(memberCSVModel1);
        listClientInfo.add(memberCSVModel2);

        baseObj.info("Step 1: Prepare test data");
        RabbitMQUtils.purseMessage(queueName);
        importMemberService.initFileImportMemberAndOutboundWithCustomData(listClientInfo);

        baseObj.info("Step 2: Upload file to SFTP server");
        importMemberService.uploadFileToServer(importMemberService.getListFileUpload(), getDstPath());
        TriggerUtils.runTriggerForSpecificService(TriggerUtils.servicesNeedToTrigger.EVV_IMPORT_MEMBER);

        baseObj.info("Step 3: Check is the message store on RabbitMQ");
        List<String> listMessages = RabbitMQUtils.getMessagesFromQueue(queueName);

        baseObj.info("Step 4: Verify message on queue with import file");
        ClientModel bodyOnRabbitMQ = RabbitMQUtils.parseSpecificMessageOnQueueToModel(listMessages, ClientModel.class, clientOtherID);

        baseObj.info("Step 4.1: Verify number element of client eligibility on rabbitMQ");
        Assert.assertEquals(Objects.requireNonNull(bodyOnRabbitMQ).getClientElig().size(), 2);

        baseObj.info("Step 5: Verify records in MySQL staging");
        client_eligibilities = ClientMySqlDBServices.getClientEligRecords(clientOtherID, "60130");
        Assert.assertEquals(client_eligibilities.size(), listMembers.size());
    }
}
