package com.sandata.common.resource;

public class Employee extends ResourceGeneric{
    public final static String INTAKE_CREATE_EMPLOYEE = "/interfaces/intake/employees/rest/api/v1";
    public final static String INTAKE_CREATE_OHIO_EMPLOYEE = "/interfaces/intake/staff/v1";

    public final static String INTAKE_CREATE_MOLINA_EMPLOYEE_STATUS = INTAKE_CREATE_EMPLOYEE + INTAKE_CHECK_STATUS;
    public final static String INTAKE_CREATE_OHIO_EMPLOYEE_STATUS = INTAKE_CREATE_OHIO_EMPLOYEE + INTAKE_CHECK_STATUS;


}
