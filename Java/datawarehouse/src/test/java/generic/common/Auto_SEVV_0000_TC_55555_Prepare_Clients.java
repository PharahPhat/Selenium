package generic.common;

import com.sandata.utils.OhioDataUtils;
import generic.DWHGenericTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Auto_SEVV_0000_TC_55555_Prepare_Clients extends DWHGenericTest {
    @Test(enabled = true, groups = {"All"})
    public void Auto_SEVV_0000_TC_55555_Prepare_Clients() throws Exception{
        String accountId = "";
        String providerId = "";
        String env = System.getProperty("test.environment");
        if (env.equalsIgnoreCase("qa")) {
            accountId = "10026";
            providerId = "0210026";
        } else if (env.equalsIgnoreCase("dev")) {

        }

        OhioDataUtils ohioDataUtils = new OhioDataUtils();
//        for (int i = 1; i <= 100; i++) {
//            ohioDataUtils.createMultipleClients(1000);
//        }
        List<List<String>> clients = ohioDataUtils.loadClients();
//        List<String> clientLastNames = new ArrayList<>();
//        for (int i = 0; i <= clients.size() - 1; i++) {
//            clientLastNames.add(clients.get(i).get(3));
//        }


        int limit = 1000;
        int count =  clients.size() / limit;
        int surplus = clients.size() % limit;
        for ( int i = 1; i <= count; i++ ) {
            List<List<String>> list = clients.subList(0, limit);
            List<String> clientMedicaids = new ArrayList<>();
            for (int j = 0; j <= list.size() - 1; j++) {
                clientMedicaids.add(list.get(j).get(4));
            }
            List<String> medicaidsNotInDd = clientDbService.areClientMedicaidsExistInDatabase(accountId, clientMedicaids);

            if (medicaidsNotInDd.size() > 0) {
                for (int k = 0; k <= medicaidsNotInDd.size() - 1; k++ ) {
                    List<String> row = getRow(list, medicaidsNotInDd.get(k));
                    ohioDataUtils.createClient(accountId, providerId, row.get(2), row.get(3), row.get(4), row.get(5));
                }
            }

            clients.subList(0, limit).clear();
        }
        List<List<String>> list = clients.subList(0, surplus);
        clients.subList(0, surplus).clear();
//        boolean result = clientDbService.areClientLastNameExistInDatabase("10026", clientLastNames);
    }

    List<String> getRow(List<List<String>> list, String medicaid) {
        List<String> row;
        for ( int i = 1; i <= list.size() - 1; i++ ) {
            row = list.get(i);
            if (row.get(4).equalsIgnoreCase(medicaid)) {
                return row;
            }
        }
        return null;
    }
}
