package performance.batchclaim;

import com.interop.common.StateAccount;
import com.interop.common.constants.utils.PGPUtils;
import com.interop.common.constants.utils.TriggerUtils;
import com.interop.models.db.stx.STXAppUser;
import com.interop.models.db.stx.STXClient;
import com.interop.models.openevv.batch.AuthorizationCSVModel;
import com.interop.models.openevv.batch.MemberCSVModel;
import com.interop.services.base.ImportBaseTest;
import com.interop.services.openevv.batch.ImportAuthService;
import com.interop.services.openevv.batch.ImportMemberService;
import com.interop.services.openevv.batch.ImportServices;
import com.jcraft.jsch.SftpException;
import com.sandata.qtest.QTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.interop.common.constants.Constant.PATH_PUBLIC_KEY;
import static com.interop.common.constants.utils.db.ClientDBUtils.getClientInSTX;

public class Auto_SEVV_18923_TC_22398_Import_Member_And_Auth_Matching_For_PA extends ImportBaseTest {
    ImportMemberService memberService = new ImportMemberService();
    ImportAuthService authService;

    private String uniqueId = memberService.generateDistinct13CharsValue();
    private String clientFName = commons.generateRandomStringOfFixLength(13);
    private String clientLName = commons.generateRandomStringOfFixLength(13);
    private String email = clientFName + "@yahoo.com";

    public Auto_SEVV_18923_TC_22398_Import_Member_And_Auth_Matching_For_PA() throws IllegalAccessException, InvocationTargetException, InstantiationException, InterruptedException {
    }


    @Test
    public void TC_22398_Import_Member_when_auto_assigned_LOC_On_And_Provide_Email() throws IllegalAccessException, InvocationTargetException, InstantiationException, InterruptedException, IOException, SftpException, SQLException {
        baseObj.info("Import File Member");
        MemberCSVModel memberRecord = prepareAndUploadFileMember();
        TriggerUtils.runTriggerForSpecificService(TriggerUtils.servicesNeedToTrigger.EVV_IMPORT_MEMBER);

        baseObj.info("Import File Auth");
        AuthorizationCSVModel authRecord = prepareAndUploadFileAuth();
        TriggerUtils.runTriggerForSpecificService(TriggerUtils.servicesNeedToTrigger.EVV_IMPORT_AUTH);

        baseObj.info("Verify Staging Db");
        TriggerUtils.runTriggerForSpecificService(TriggerUtils.servicesNeedToTrigger.MATCHING_SERVICE);

    }

    private MemberCSVModel prepareAndUploadFileMember() throws IllegalAccessException, InstantiationException, InvocationTargetException, InterruptedException, IOException, SftpException {
        baseObj.info("Prepare data before starting");
        List<MemberCSVModel> listMember = new ArrayList<>();
        MemberCSVModel line = new MemberCSVModel();
        line.setClientOtherID(uniqueId);
        line.setClientCustomID(uniqueId);
        line.setClientMedicaidID(uniqueId);
        line.setClientFirstName(clientFName);
        line.setClientLastName(clientLName);
        line.setClientEmail(email);
        line.setClientSSN(commons.generateRandomSsn());
        listMember.add(line);

        baseObj.info("Upload file member");
        memberService.initFileImportMemberAndOutboundWithCustomData(listMember);
        memberService.uploadFileToServer(memberService.getListFileUpload(), ImportServices.config.getEnvironment("Default_Upload_folder_SFTP"));
        return line;
    }

    private AuthorizationCSVModel prepareAndUploadFileAuth() throws IllegalAccessException, InstantiationException, InvocationTargetException, InterruptedException, IOException, SftpException {
        authService = new ImportAuthService();
        StateAccount account = StateAccount.loadStateAccount();
        baseObj.info("Prepare data before starting");

        List<AuthorizationCSVModel> listAuth = new ArrayList<>();
        AuthorizationCSVModel line = new AuthorizationCSVModel();
        line.setClientIdentifier(uniqueId);
        line.setAuthorizationReferenceNumber(authService.generateAuthRefNumber());
        line.setPayerID(account.getDefaultPayerID());
        line.setPayerProgram(account.getDefaultPayerProgram());
        line.setAuthorizationServiceID(account.getDefaultProcedureCode());
        line.setProviderID(account.getProviderID());
        listAuth.add(line);

        baseObj.info("Upload file Auth");
        authService.initFileImportAuthAndOutboundWithCustomData(listAuth);
        authService.uploadFileToServer(authService.getListFileUpload(), ImportServices.config.getEnvironment("Default_Upload_folder_SFTP"));
        return line;
    }
}