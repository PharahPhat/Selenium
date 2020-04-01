package generic.import_feature;

import generic.GenericTest;
import com.sandata.models.importModel.Auth.ImportPriorAuthModel;
import com.sandata.models.importModel.Control.ImportOutboundControlModel;
import com.sandata.models.importModel.Member.ImportMemberModel;
import com.sandata.models.importModel.Provider.ImportProviderModel;

import java.util.ArrayList;
import java.util.List;

public class ImportGenericTest extends GenericTest {
    public String state;
    public String account;
    public String providerId;
    public String groupkey;

    public List<ImportMemberModel> importMemberModels = new ArrayList<>();
    public List<ImportPriorAuthModel> importPriorAuthModels = new ArrayList<>();
    public List<ImportOutboundControlModel> importOutboundControlModels = new ArrayList<>();

    public ImportMemberModel importMemberModel = new ImportMemberModel();
    public ImportPriorAuthModel importPriorAuthModel = new ImportPriorAuthModel();
    public ImportOutboundControlModel importOutboundControlModel = new ImportOutboundControlModel();
    public ImportProviderModel importProviderModel = new ImportProviderModel();

    public List<String> firstNames = new ArrayList<>();

    public void initStateInfo() {
        state = baseObj.readDataValue("AccountType");
        switch (state) {
            case "MOLINA":
                account = baseObj.getEnvironment("molina_accountId");
                groupkey = baseObj.getEnvironment("molina_groupkey");
                providerId = baseObj.getEnvironment("molina_providerId");
                break;
            case "OHIO":
                account = baseObj.getEnvironment("ohio_accountId");
                groupkey = baseObj.getEnvironment("ohio_groupkey");
                providerId = baseObj.getEnvironment("ohio_providerId");
                break;
            case "CONNECTICUT":
                account = baseObj.getEnvironment("connecticut_accountId");
                groupkey = baseObj.getEnvironment("connecticut_groupkey");
                providerId = baseObj.getEnvironment("connecticut_providerId");
                break;
        }
        logStepInfo(String.format("State: %s", state));
        logStepInfo(String.format("Account: %s", account));
        logStepInfo(String.format("Provider Id: %s", providerId));
    }
}
