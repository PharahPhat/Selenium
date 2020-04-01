package generic;

import com.sandata.entity.molina.employee.EmployeeGeneralEntity;
import com.sandata.entity.molina.visit.VisitGeneralEntity;
import com.sandata.models.provider.ProviderAccountModel;
import com.sandata.models.molina.client.ClientAccountModel;
import com.sandata.common.Constant;
import com.sandata.entity.exportDWH.ClientMolinaModel;
import com.sandata.entity.exportDWH.ProviderMolinaWithConfigurationModel;
import com.sandata.ws.ClientWebService;
import com.sandata.ws.EmployeeWebService;
import com.sandata.ws.ProviderWebService;
import com.sandata.ws.VisitWebService;

import java.io.IOException;
import java.util.List;
import static com.interop.sql.ClientSQL.SQL_GET_CLIENT_ACCOUNT;
import static com.interop.sql.EmployeeSQL.SQL_GET_WORKERS_ACCOUNT;
import static com.interop.sql.VisitSQL.SQL_GET_VISIST_ACCOUNT;
import static com.interop.sql.ProviderSQL.SQL_GET_PROVIDER_BY_PROVIDER_ID;

public class DWHCreateDataTest extends DWHGenericTest{

    public ProviderWebService providerServices = new ProviderWebService();
    public ClientWebService clientServices = new ClientWebService();
    public EmployeeWebService employeeServices = new EmployeeWebService();
    public VisitWebService visitServices = new VisitWebService();

    ProviderMolinaWithConfigurationModel providerMolinaWithConfigurationModel;

    public String usernameApi, passwordApi, accountApi;
    public String accountTypeName;

    /**
     * Get the DWH information from the account type input (Molina, Ohio...).
     * @param accountType account name.
     * @throws IOException throw exception when have any issues.
     */
    public void GetInfoDWH(Constant.ACCOUNT_TYPE accountType) throws IOException {

        switch (accountType) {
            case MOLINA:
                //Load provider body json model
                ProviderMolinaWithConfigurationModel[] providerMolinaWithConfigurationModels = webServicesBase
                        .toJsonModel(Constant.MOLINA_PROVIDER_BODY_JSON, ProviderMolinaWithConfigurationModel[].class);
                //Get first provider (just for auto testing)
                providerMolinaWithConfigurationModel = providerMolinaWithConfigurationModels[0];
                accountTypeName = String.valueOf(Constant.ACCOUNT_TYPE.MOLINA);
                accountApi = baseObj.getEnvironment("molina_accountId");
                usernameApi = baseObj.getEnvironment("molina_UserName");
                passwordApi = baseObj.getEnvironment("molina_Password");
                break;
            case OHIO:
                providerId = baseObj.getEnvironment("ohio_accountId");
                break;
            case CONNECTICUT:
                providerId = baseObj.getEnvironment("connecticut_accountId");
                break;
            default:
                break;
        }
    }



    public List<VisitWebService> mapVisitAccountModel(String fName, String account) {
        String sql = String.format(SQL_GET_VISIST_ACCOUNT, fName, account);
        return mapDataTableToModel(sql, VisitWebService.class);
    }

    public boolean IsVisitIsCreatedInDbByEmployeeFNameAccount() {
        String memo = baseObj.readDataValue("Memo");

        List<VisitWebService> mapVisitAccountModel = mapVisitAccountModel(memo,accountApi);
        if(mapVisitAccountModel.size() > 0) {
            return true;
        }
        return false;
    }

    public List<EmployeeWebService> mapEmployeeAccountModel(String fName, String account) {
        String sql = String.format(SQL_GET_WORKERS_ACCOUNT, fName, account);
        return mapDataTableToModel(sql, EmployeeWebService.class);
    }

    public boolean IsEmployeeIsCreatedInDbByEmployeeFNameAccount() {
        String clientFName = baseObj.readDataValue("EmployeeFirstName28000");
        List<EmployeeWebService> employeeAccountModelList = mapEmployeeAccountModel(clientFName,accountApi);
        if(employeeAccountModelList.size() > 0) {
            return true;
        }
        return false;
    }

    public List<ClientAccountModel> mapClientAccountModel(String fName, String account) {
        String sql = String.format(SQL_GET_CLIENT_ACCOUNT, fName, account);
        return mapDataTableToModel(sql, ClientAccountModel.class);
    }

    /**
     * Check client is existed in db base on the input from:
     * 1. The client first name (is is unit)
     * 2. The account of molina (28000)
     * @return
     */
    public boolean IsClientIsCreatedInDbByClientFNameAccount() {
        String clientFName = baseObj.readDataValue("ClientFirstName28000");
        String account = baseObj.readDataValue("Account28000");
        List<ClientAccountModel> clientAccountModelList = mapClientAccountModel(clientFName,account);
        if(clientAccountModelList.size() > 0) {
            return true;
        }
        return false;
    }

    public List<ProviderAccountModel> mapProviderAccountModel(String providerId) {
        String sql = String.format(SQL_GET_PROVIDER_BY_PROVIDER_ID, providerId);
        return mapDataTableToModel(sql, ProviderAccountModel.class);
    }

    /**
     * Check provider id is existed on database.
     * @return true is existed, false if is not existed
     */
    public boolean IsProviderIsCreatedInDbByProviderID() {
        String provider_id = providerMolinaWithConfigurationModel.getProviderID();
        List<ProviderAccountModel> providerAccountModelList = mapProviderAccountModel(provider_id);
        if(providerAccountModelList.size() > 0) {
            return true;
        }
        return false;
    }

    /**
     * Author: @liem.chau
     * Execute a api create a client
     */
    public String CallCreateClientByApi()
    {
        String accountType = baseObj.readDataValue("AccountType");
        String clientFirstName = baseObj.readDataValue("ClientFirstName28000");
        String clientLastName = baseObj.readDataValue("ClientLastName28000");
        ClientMolinaModel ClientMolinaModel = new ClientMolinaModel();
        ClientMolinaModel.setClientFirstName(clientFirstName);
        ClientMolinaModel.setClientLastName(clientLastName);
        return clientServices.callCreateClient(accountType, usernameApi,
                passwordApi, accountApi,ClientMolinaModel,

                baseObj.getTestEnvironment());
    }

    /**
     * Author: @liem.chau
     * Execute a api create a provider
     */
    public String CallProviderByApi()
    {
        return providerServices.callCreateProvider(accountTypeName, usernameApi,
                passwordApi, accountApi, null,baseObj.getTestEnvironment());
    }

    /**
     * Author: @liem.chau
     * Execute a api create a employee
     */
    public String CallEmployeeByApi() {

        String accountType = baseObj.readDataValue("AccountType");
        String employeeFirstName = baseObj.readDataValue("EmployeeFirstName28000");
        String employeeLastName = baseObj.readDataValue("EmployeeLastName28000");

        //TODO: if you want to change, will update these fields
        /*String providerQualifier = baseObj.readDataValue("ProviderQualifier");
        String providerId = baseObj.readDataValue("ProviderID");

        String employeeIdentifier = baseObj.readDataValue("EmployeeIdentifier");
        String employeeOtherID = baseObj.readDataValue("EmployeeOtherID");
        String sequenceID = baseObj.readDataValue("SequenceID");
        String employeeQualifier = baseObj.readDataValue("EmployeeQualifier");
        String employeeSSN = baseObj.readDataValue("EmployeeSSN");
        String employeeLastName = baseObj.readDataValue("EmployeeLastName");
        String employeeFirstName = baseObj.readDataValue("EmployeeFirstName");*/

        EmployeeGeneralEntity EmployeeMolinaModel = new EmployeeGeneralEntity();
        EmployeeMolinaModel.setEmployeeFirstName(employeeFirstName);
        EmployeeMolinaModel.setEmployeeLastName(employeeLastName);



        return employeeServices.callCreateEmployee(accountType, usernameApi,

                passwordApi, accountApi, EmployeeMolinaModel,

                baseObj.getTestEnvironment());
    }


    /**
     * Author: @liem.chau
     * Execute create a api visit
     */
    public String CallCreateVisitByApi()
    {
        String accountType = baseObj.readDataValue("AccountType");

        VisitGeneralEntity visitMolinaWithConfigurationModel = new VisitGeneralEntity();


        String memo = baseObj.readDataValue("Memo");
        visitMolinaWithConfigurationModel.setMemo(memo);



        return visitServices.callCreateVisit(accountType, usernameApi,
                passwordApi, accountApi,visitMolinaWithConfigurationModel,
                baseObj.getTestEnvironment());
    }
}
