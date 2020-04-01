package com.sandata.db;

import com.interop.sql.ClaimSQL;
import com.sandata.utilities.DbUtilsCon;
import org.apache.commons.lang.RandomStringUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ClaimDbService extends BaseDbService {

    public boolean isClaimExistedInDb(String ICN) {
        String sql = String.format(ClaimSQL.SQL_GET_CLAIM_BY_ICN, ICN);
        int count = DbUtilsCon.getDataTable(getTestEnvironment().getOracleUrl(), getTestEnvironment(), sql).size();
        return (count > 0);
    }

    public String generateBusinessEntityMedicaidIdentifierNew() {
        return RandomStringUtils.randomNumeric(13);
    }

    public boolean areClaimExistedInDb(List<String> icns, boolean expected) {
        String aggIcns = icns.stream().collect(Collectors.joining("','","'","'"));
        String sql = String.format(ClaimSQL.SQL_GET_CLAIM_BY_IC_NS, aggIcns);

        logInfo("Execute sql: " + sql);
        List<Map<String, Object>> dataTable;
        int expectedNoRows =  expected ? icns.size(): 0;
        dataTable = getDataTable(sql, expectedNoRows);

        verifyIcnsReturnedFromDB(icns, dataTable, expected);
        if (expected) {
            if (dataTable.size() == icns.size()) {
                logInfo(String.format("All '%s' ICNs are added in EVV DB.", icns.size()));
                return true;
            } else {
                logInfo(String.format("All '%s' ICNs are not added in EVV DB.", icns.size()));
                return false;
            }
        } else {
            if (dataTable.size() == 0) {
                logInfo(String.format("All '%s' ICNs are not added in EVV DB as expected.", icns.size()));
                return true;
            } else {
                logInfo(String.format("All '%s' ICNs are added in EVV DB unexpected.", icns.size()));
                return false;
            }
        }
    }

    private boolean verifyIcnsReturnedFromDB(List<String> icns, List<Map<String, Object>> dataTable, boolean expected) { ;
        for (int i = 0; i <= icns.size() - 1; i++) {
            String icn = icns.get(i);
            boolean isICNfound = dataTable.stream()
                    .anyMatch(record -> record.get("ICN").toString().equalsIgnoreCase(icn));
            if (!isICNfound) {
                logFail(String.format("ICN '%s' is not added in EVV DB.", icn));
                return false;
            }
        }
        return true;
    }
}
