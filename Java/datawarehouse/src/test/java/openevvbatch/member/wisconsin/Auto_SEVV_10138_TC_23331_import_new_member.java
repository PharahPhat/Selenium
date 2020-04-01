package openevvbatch.member.wisconsin;

import com.interop.common.constants.utils.RabbitMQUtils;
import com.interop.models.db.staging.StagingClient;
import com.interop.models.openevv.batch.MemberCSVModel;
import com.interop.services.base.ImportBaseTest;
import com.interop.services.db.ClientMySqlDBServices;
import com.interop.services.openevv.batch.ImportMemberService;
import com.interop.services.openevv.batch.ImportServices;
import com.sandata.core.Wrapper;
import com.sandata.qtest.QTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Auto_SEVV_10138_TC_23331_import_new_member extends ImportBaseTest{
    final String queueName = "QAAutomation";
    ImportMemberService importMemberService;

    @Test()
    @QTest(keys = {"TC-23331"})
    public void SEVV_10138_TC_23331_import_new_member()  throws Exception{
        importMemberService = new ImportMemberService();

        importMemberService.generateFileWithMultipleLine(1);
        List listMembers = importMemberService.getRecords();

        MemberCSVModel memberCSVModel = (MemberCSVModel) listMembers.get(0);

        baseObj.info("Prepare data before starting");
        String clientCustomID = Wrapper.GenerateRandomNumber(10);
        List<MemberCSVModel> listClientInfo = new ArrayList<>();

        memberCSVModel.setClientOtherID(clientCustomID);
        memberCSVModel.setClientCustomID(clientCustomID);
        memberCSVModel.setClientFirstName("Auto"+Wrapper.generateRandomString(10));
        memberCSVModel.setClientTimeZone("US/Eastern");
        memberCSVModel.setClientLanguage("French");
        memberCSVModel.setClientCounty("01 Wisconsin");
        listClientInfo.add(memberCSVModel);

        baseObj.info("Step 1: Prepare test data");
        importMemberService.initFileImportMemberAndOutboundWithCustomData(listClientInfo);

        baseObj.info("Step 2: Upload file to SFTP server");
        RabbitMQUtils.purseMessage(queueName);
        importMemberService.uploadFileToServer(importMemberService.getListFileUpload(), ImportServices.config.getEnvironment("Default_Upload_folder_SFTP"));

        baseObj.info("Step 5: Verify records in MySQL staging");
        baseObj.sleep(60000);
        List<StagingClient> recordStaging = ClientMySqlDBServices.getClientBasicInformationByClientID(clientCustomID, stateAccount.getAccountTemplate());
        Assert.assertEquals(recordStaging.size(), 1);
        Assert.assertEquals(recordStaging.get(0).getClient_id(), clientCustomID);
    }

}
