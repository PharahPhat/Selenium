package performance;

import com.interop.common.constants.utils.PGPUtils;
import com.interop.common.constants.utils.TriggerUtils;
import com.interop.models.openevv.batch.AuthorizationCSVModel;
import com.interop.models.openevv.batch.MemberCSVModel;
import com.interop.services.base.ImportBaseTest;
import com.interop.services.openevv.batch.ImportCustomFiles;
import com.interop.services.openevv.batch.ImportProviderService;
import com.interop.services.openevv.batch.ImportServices;
import com.jcraft.jsch.SftpException;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import static com.interop.common.constants.Constant.PATH_PUBLIC_KEY;

public class Auto_SEVV_21921_TC_18125_OpenEvv_Import_Auth_Member_Performance_Matching extends ImportBaseTest {
    private String templateFileMember = "PerformanceDataImportFile/MEDHHS_EVV_Member_20200131.csv";
    private String templateFileAuth = "PerformanceDataImportFile/MEDHHS_EVV_PriorAuth_20200131.csv";
    private List<File> listFileUpload = new ArrayList<>();

    /**
     * This test method to perform performance testing for matching member auth with 2 matching service was being
     * run at the same time
     * All Data must be prepared manually
     *
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws InstantiationException
     * @throws InterruptedException
     * @throws IOException
     * @throws SftpException
     */
    @Test(invocationCount = 1)
    public void uploadSingleFileWithMultipleTime() throws IllegalAccessException, InvocationTargetException, InstantiationException, InterruptedException, IOException, SftpException {
        String accountTwo = "28000";
        int numberFile = 10;
        listFileUpload.addAll(uploadFileMember(numberFile));
        listFileUpload.addAll(uploadFileAuth(numberFile));
        new ImportProviderService().uploadFileToServer(listFileUpload, String.format("/QA_4_QA/Molina_Interfaces/%s", accountTwo));
        TriggerUtils.runTriggerForSpecificService(TriggerUtils.servicesNeedToTrigger.EVV_IMPORT_MEMBER, accountTwo);
        TriggerUtils.runTriggerForSpecificService(TriggerUtils.servicesNeedToTrigger.EVV_IMPORT_AUTH, accountTwo);
    }


    private List<File> uploadFileMember(int numberFile) throws IllegalAccessException, InstantiationException, InvocationTargetException, InterruptedException, SftpException, IOException {
        List<MemberCSVModel> list = new ArrayList<>();
        List<File> uploadFile = new ArrayList<>();
        for (int i = 0; i < numberFile; i++) {
            ImportCustomFiles importMember = new ImportCustomFiles(MemberCSVModel.class, templateFileMember);
            importMember.prepareFileImportCustomAndOutboundFile(list, ImportServices.ImportType.MEMBER);
            for (File file : importMember.getListFileCSV()) {
                PGPUtils.encryptFile(file.getPath() + ".gpg", file.getPath(), PATH_PUBLIC_KEY, false, false, 2);
                uploadFile.add(new File(file.getPath() + ".gpg"));
            }
        }
        return uploadFile;
    }

    private List<File> uploadFileAuth(int numberFile) throws IllegalAccessException, InstantiationException, InvocationTargetException, InterruptedException, SftpException, IOException {
        List<AuthorizationCSVModel> list = new ArrayList<>();
        List<File> uploadFile = new ArrayList<>();
        for (int i = 0; i < numberFile; i++) {
            ImportCustomFiles importAuth = new ImportCustomFiles(AuthorizationCSVModel.class, templateFileAuth);
            importAuth.prepareFileImportCustomAndOutboundFile(list, ImportServices.ImportType.AUTHORIZATION);
            for (File file : importAuth.getListFileCSV()) {
                PGPUtils.encryptFile(file.getPath() + ".gpg", file.getPath(), PATH_PUBLIC_KEY, false, false, 2);
                uploadFile.add(new File(file.getPath() + ".gpg"));
            }
        }
        return uploadFile;
    }
}
