package com.sandata.models.interfaces.open_evv_connecticut.xref;

public class OpenEVV_Connecticut_Xref {
    public String Account="";
    public String EmployeePIN="";
    public String ClientID="";
    public String Service="";
    public String XRefStartDate="";
    public String XRefEndDate="";
    public String ClientIDQualifier="";
    public String EmployeeQualifier="";

    public void setAccount(String account) {
        this.Account = account;
    }
    public String getAccount(){
        return Account;
    }

    public void setEmployeePIN(String employeePIN){this.EmployeePIN = employeePIN;}
    public String getEmployeePIN(){return EmployeePIN;}

    public void setClientID(String clientID){this.ClientID = clientID;}
    public String getClientID(){return ClientID;}

    public void setService(String service){this.Service = service;}
    public String getService(){return Service;}

    public void setXRefStartDate(String xRefStartDate){this.XRefStartDate= xRefStartDate;}
    public String getXRefStartDate(){return XRefStartDate;}

    public void setXRefEndDate(String xRefEndDate){this.XRefEndDate = xRefEndDate;}
    public String getXRefEndDate(){return XRefEndDate;}

    public void setClientIDQualifier (String clientIDQualifier){this.ClientIDQualifier = clientIDQualifier;}
    public String getClientIDQualifier(){return ClientIDQualifier;}

    public void setEmployeeQualifier(String employeeQualifier){this.EmployeeQualifier = employeeQualifier;}
    public String getEmployeeQualifier(){return EmployeeQualifier;}
}
