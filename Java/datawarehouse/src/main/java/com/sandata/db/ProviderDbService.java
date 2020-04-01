package com.sandata.db;

import com.interop.sql.ProviderSQL;
import com.sandata.utilities.DbUtilsCon;
import org.apache.commons.lang.RandomStringUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.interop.sql.ProviderSQL.SQL_GET_PROVIDER_BY_PROVIDER_IDS;

public class ProviderDbService extends BaseDbService {

    public boolean isProviderIdExistedInDb(String providerID) {
        String sql = String.format(ProviderSQL.SQL_GET_PROVIDER_BY_PROVIDER_ID, providerID);
        int count = DbUtilsCon.getDataTable(getTestEnvironment().getOracleUrl(), getTestEnvironment(), sql).size();
        return (count > 0);
    }

    public boolean areProviderIdExistedInDb(List<String> providerIds, boolean expected) {
        boolean result;
        String providerIDsStr = providerIds.stream().collect(Collectors.joining("','", "'", "'"));

        String sql = String.format(SQL_GET_PROVIDER_BY_PROVIDER_IDS, providerIDsStr);

        logInfo("Execute sql: " + sql);
        int expectedRows = expected ? providerIds.size() : 0;
        List<Map<String, Object>> dataTable = getDataTable(sql, expectedRows);

        verifyProviderIdExistInDB(providerIds, dataTable);

        if (expected) {
            if (dataTable.size() == providerIds.size()) {
                logInfo(String.format("All '%s' providers are added in EVV DB.", providerIds.size()));
                result = true;
            } else {
                logInfo(String.format("All '%s' providers are not added in EVV DB.", providerIds.size()));
                result = false;
            }
        } else {
            if (dataTable.size() == 0) {
                logInfo(String.format("All '%s' providers are not added in EVV DB as expected.", providerIds.size()));
                result = true;
            } else {
                logInfo(String.format("All '%s' providers are added in EVV DB unexpected.", providerIds.size()));
                result = false;
            }
        }
        return result;
    }

    private void verifyProviderIdExistInDB(List<String> providerIds, List<Map<String, Object>> dataTable) {
        for (int i = 0; i <= providerIds.size() - 1; i++) {
            String providerId = providerIds.get(i);
            boolean isProviderIDFound = dataTable.stream()
                    .anyMatch(record -> record.get("PROVIDER_ID").toString().equalsIgnoreCase(providerId));
            if (!isProviderIDFound) {
                logFail(String.format("Provider with provider id '%s' is not added in EVV DB.", providerId));
            }
        }
    }

    public String generateNewProviderId() {
        String providerId = RandomStringUtils.randomNumeric(13);
        while (isProviderIdExistedInDb(providerId)) {
            logInfo("Provider ID: " + providerId + " is existing already in database.");
            providerId = RandomStringUtils.randomNumeric(13);
        }
        return providerId;
    }
}
