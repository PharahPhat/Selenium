package com.sandata.common.resource;

public class Visit extends ResourceGeneric{
    public final static String INTAKE_CREATE_VISIT = "/interfaces/intake/visits/rest/api/v1";
    public final static String INTAKE_CREATE_OHIO_VISIT = "/interfaces/intake/visit/v2";
    public final static String EVV_UPDATE_VISIT_EXCEPTION = "/VM/VisitMaintenance/UpdateVisitException";

    public final static String INTAKE_CREATE_MOLINA_VISIT_STATUS = INTAKE_CREATE_VISIT + INTAKE_CHECK_STATUS;
    public final static String INTAKE_CREATE_OHIO_VISIT_STATUS = INTAKE_CREATE_OHIO_VISIT + INTAKE_CHECK_STATUS;
}
