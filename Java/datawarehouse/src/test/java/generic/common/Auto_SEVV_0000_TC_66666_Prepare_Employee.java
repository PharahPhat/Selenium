package generic.common;

import com.sandata.utils.OhioDataUtils;
import generic.DWHGenericTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Auto_SEVV_0000_TC_66666_Prepare_Employee extends DWHGenericTest {
    @Test(enabled = true, groups = {"All"})
    public void Auto_SEVV_0000_TC_66666_Prepare_Employee() throws Exception {
        String accountId = "";
        String providerId = "";
        String env = System.getProperty("test.environment");
        if (env.equalsIgnoreCase("qa")) {
            accountId = "10026";
            providerId = "0210026";
        } else if (env.equalsIgnoreCase("dev")) {

        }
        OhioDataUtils ohioDataUtils = new OhioDataUtils();
//        for (int i = 1; i <= 78; i++) {
//            ohioDataUtils.createMultipleEmployees(1000);
//            System.out.println("Complete create employee time " + i + ". Waiting 20s for next request.");
//            ait(20);
//        }

        List<List<String>> workers = ohioDataUtils.loadWorkers();
//        List<String> workerLastNames = new ArrayList<>();
//        for (int i = 0; i <= workers.size() - 1; i++) {
//            workerLastNames.add(workers.get(i).get(6));
//        }
//        boolean result = employeeDbService.isEmployeesExistInDatabase("10026", workerLastNames);

        int limit = 1000;
        int count =  workers.size() / limit;
        int surplus = workers.size() % limit;
        for ( int i = 1; i <= count; i++ ) {
            List<List<String>> list = workers.subList(0, limit);
            List<String> stxIds = new ArrayList<>();
            for (int j = 0; j <= list.size() - 1; j++) {
                stxIds.add(list.get(j).get(4));
            }
            List<String> stxIdsNotInDb = new ArrayList<>();
            stxIdsNotInDb = employeeDbService.areWorkerStxIdsExistInDatabase(accountId, stxIds);
            if (stxIdsNotInDb.size() > 0) {
                for (int k = 0; k <= stxIdsNotInDb.size() - 1; k++ ) {
                    List<String> row = getRow(list, stxIdsNotInDb.get(k));
                    ohioDataUtils.createWorker(accountId, providerId, row.get(2), row.get(3), row.get(4), row.get(5), row.get(6), row.get(7));
                }
            }

            workers.subList(0, limit).clear();
        }
        List<List<String>> list = workers.subList(0, surplus);
        workers.subList(0, surplus).clear();
    }

    List<String> getRow(List<List<String>> list, String stxid) {
        List<String> row;
        for ( int i = 1; i <= list.size() - 1; i++ ) {
            row = list.get(i);
            if (row.get(4).equalsIgnoreCase(stxid)) {
                return row;
            }
        }
        return null;
    }
}
