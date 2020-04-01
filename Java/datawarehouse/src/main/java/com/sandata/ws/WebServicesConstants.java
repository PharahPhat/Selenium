package com.sandata.ws;

public class WebServicesConstants {
    private WebServicesConstants(){}
    public static final String DWH_EXPORT_WITH_CONFIG_URL = "/interfaces/internal/evv/dwh/export/provider/exportWithConfiguration";
    public static final String DWH_EXPORT_WITH_OHIO_CONFIG_URL = "/interfaces/internal/export-data-warehouse/provider/exportWithConfiguration";
    public static final String DWH_EXPORT_ALL_URL = "/interfaces/internal/evv/dwh/export/provider/fullExportWithDateRange";
    public static final String IMPORT_MOLINA_EMPLOYEE = "/interfaces/intake/employees/rest/api/v1";
    public static final String IMPORT_PROVIDER = "/interfaces/intake/providers/rest/api/v1/evv";
    public static final String CREATE_CLIENT_MOLINA_URL = "interfaces/intake/clients/rest/api/v1";
    public static final String CREATE_EMPLOYEE_MOLINA_URL = "interfaces/intake/employees/rest/api/v1";
    public static final String CREATE_PROVIDER_MOLINA_URL = "interfaces/intake/providers/rest/api/v1/evv";
    public static final String CREATE_VISIT_MOLINA_URL = "interfaces/intake/visits/rest/api/v1";
    public static final String CREATE_CLIENT_CONNECTICUT_URL = "interfaces/intake/clients/rest/api/v1/evv";
    public static final String CREATE_EMPLOYEE_CONNECTICUT_URL = "interfaces/intake/employees/rest/api/v1/evv";
    public static final String CREATE_VISIT_GENERIC_URL = "interfaces/intake/visits/rest/api/v1.1";
    public static final String CREATE_CLIENT_AUTHORIZATION = "interfaces/intake/auths/rest/api/v1/evv";
    public static final String CREATE_SCHEDULES = "interfaces/intake/schedules/rest/api/v1/evv";

}
