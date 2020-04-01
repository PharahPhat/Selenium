package com.sandata.common.resource;

public class Client extends ResourceGeneric {
    public final static String INTAKE_CREATE_CLIENT = "/interfaces/intake/clients/rest/api/v1";
    public final static String INTAKE_CREATE_OHIO_CLIENT = "/interfaces/intake/patient/v2";

    public final static String INTAKE_CREATE_MOLINA_CLIENT_STATUS = INTAKE_CREATE_CLIENT + INTAKE_CHECK_STATUS;
    public final static String INTAKE_CREATE_OHIO_CLIENT_STATUS = INTAKE_CREATE_OHIO_CLIENT + INTAKE_CHECK_STATUS;
}
