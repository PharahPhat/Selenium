package com.interop.models.db.stx;

import com.sandata.core.annotation.DataTableColumn;

public class STXEmployee {
    @DataTableColumn public String PROVIDERID;
    @DataTableColumn public String EMPLOYEEID;
    @DataTableColumn public String EMPLOYEELASTNAME;
    @DataTableColumn public String EMPLOYEEFIRSTNAME;
    @DataTableColumn public String DEPARTMENT;
    @DataTableColumn public String EMPLOYEETYPE;
    @DataTableColumn public String EMPLOYEEEMAIL;
    @DataTableColumn public String EMPLOYEEADDRESS1;
    @DataTableColumn public String EMPLOYEEADDRESS2;
    @DataTableColumn public String EMPLOYEECITY;
    @DataTableColumn public String EMPLOYEESTATE;
    @DataTableColumn public String EMPlOYEEZIPCODE;
    @DataTableColumn public String EMPLOYEEPHONE;
    @DataTableColumn public String PAYRATE;
    @DataTableColumn public String EMPLOYEEIDCUSTOM1;
    @DataTableColumn public String EMPLOYEEIDCUSTOM2;
    @DataTableColumn public String SOCIALSECURITY;
    @DataTableColumn public String EMPLOYEEAPI;
    @DataTableColumn public String EMPLOYEEHIREDATE;
    @DataTableColumn public String EMPLOYEEBIRTHDATE;
    @DataTableColumn public String EMPLOYEELOCATIONNAME;

    public String getEMPLOYEEFIRSTNAME() {
        return EMPLOYEEFIRSTNAME;
    }

    public void setEMPLOYEEFIRSTNAME(String EMPLOYEEFIRSTNAME) {
        this.EMPLOYEEFIRSTNAME = EMPLOYEEFIRSTNAME;
    }

    @Override
    public String toString() {
        return "STXEmployee{" +
                "PROVIDERID='" + PROVIDERID + '\'' +
                ", EMPLOYEEID='" + EMPLOYEEID + '\'' +
                ", EMPLOYEELASTNAME='" + EMPLOYEELASTNAME + '\'' +
                ", EMPLOYEEFIRSTNAME='" + EMPLOYEEFIRSTNAME + '\'' +
                ", DEPARTMENT='" + DEPARTMENT + '\'' +
                ", EMPLOYEETYPE='" + EMPLOYEETYPE + '\'' +
                ", EMPLOYEEEMAIL='" + EMPLOYEEEMAIL + '\'' +
                ", EMPLOYEEADDRESS1='" + EMPLOYEEADDRESS1 + '\'' +
                ", EMPLOYEEADDRESS2='" + EMPLOYEEADDRESS2 + '\'' +
                ", EMPLOYEECITY='" + EMPLOYEECITY + '\'' +
                ", EMPLOYEESTATE='" + EMPLOYEESTATE + '\'' +
                ", EMPlOYEEZIPCODE='" + EMPlOYEEZIPCODE + '\'' +
                ", EMPLOYEEPHONE='" + EMPLOYEEPHONE + '\'' +
                ", PAYRATE='" + PAYRATE + '\'' +
                ", EMPLOYEEIDCUSTOM1='" + EMPLOYEEIDCUSTOM1 + '\'' +
                ", EMPLOYEEIDCUSTOM2='" + EMPLOYEEIDCUSTOM2 + '\'' +
                ", SOCIALSECURITY='" + SOCIALSECURITY + '\'' +
                ", EMPLOYEEAPI='" + EMPLOYEEAPI + '\'' +
                ", EMPLOYEEHIREDATE='" + EMPLOYEEHIREDATE + '\'' +
                ", EMPLOYEEBIRTHDATE='" + EMPLOYEEBIRTHDATE + '\'' +
                ", EMPLOYEELOCATIONNAME='" + EMPLOYEELOCATIONNAME + '\'' +
                '}';
    }
}
