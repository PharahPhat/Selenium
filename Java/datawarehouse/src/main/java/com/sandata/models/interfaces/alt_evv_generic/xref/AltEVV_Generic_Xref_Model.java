package com.sandata.models.interfaces.alt_evv_generic.xref;

import com.google.gson.annotations.Expose;
import com.interop.common.StateAccount;
import com.sandata.models.GenericModel;
import org.apache.commons.lang.RandomStringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class AltEVV_Generic_Xref_Model extends GenericModel {
    private String Account;
    private String EmployeeID;
    private String ClientID;
    private String Service;
    private String XRefStartDate;
    private String XRefEndDate;
    private String ClientIDQualifier;
    private String EmployeeQualifier;
    private String ClientStatus;
    private String EmployeePIN;

    @Expose
    public transient List<AltEVV_Generic_Xref_Model> altevv_generic_xref;

    public static AltEVV_Generic_Xref_Model initModelByState(StateAccount state) {
        AltEVV_Generic_Xref_Model model = new AltEVV_Generic_Xref_Model();
        model = model.initAltEVVGenericXref();
        model.setAccount(state.getAccountID());
        return model;
    }

    public String getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(String employeeID) {
        EmployeeID = employeeID;
    }

    public String getClientID() {
        return ClientID;
    }

    public void setClientID(String clientID) {
        ClientID = clientID;
    }

    public String getService() {
        return Service;
    }

    public void setService(String service) {
        Service = service;
    }

    public String getXRefStartDate() {
        return XRefStartDate;
    }

    public void setXRefStartDate(String XRefStartDate) {
        this.XRefStartDate = XRefStartDate;
    }

    public String getXRefEndDate() {
        return XRefEndDate;
    }

    public void setXRefEndDate(String XRefEndDate) {
        this.XRefEndDate = XRefEndDate;
    }

    public String getClientIDQualifier() {
        return ClientIDQualifier;
    }

    public void setClientIDQualifier(String clientIDQualifier) {
        ClientIDQualifier = clientIDQualifier;
    }

    public String getEmployeeQualifier() {
        return EmployeeQualifier;
    }

    public void setEmployeeQualifier(String employeeQualifier) {
        EmployeeQualifier = employeeQualifier;
    }

    public String getClientStatus() {
        return ClientStatus;
    }

    public void setClientStatus(String clientStatus) {
        ClientStatus = clientStatus;
    }

    public String getEmployeePIN() {
        return EmployeePIN;
    }

    public void setEmployeePIN(String employeePIN) {
        EmployeePIN = employeePIN;
    }

    public String getAccount() {
        return Account;
    }

    public void setAccount(String account) {
        Account = account;
    }

    public void initnaldoData(int count) {
        if (count < 1) {
            return;
        }
        altevv_generic_xref = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            AltEVV_Generic_Xref_Model altEVVGenericXref = initAltEVVGenericXref();
            altevv_generic_xref.add(altEVVGenericXref);
        }
    }

    private String getRandomValidService(){
        Random random = new Random();
        List<String> listValidService = new ArrayList<>(Arrays.asList("T1020", "S9125", "S5125", "FCS71", "MNS71", "GFAS",
                "PCS81", "RCC75", "RCS80", "PCC77", "HM95", "RC73",
                "RC72", "CC73", "MN71", "T12017", "GDAC89"));
        return listValidService.get(random.nextInt(listValidService.size()));
    }

    public AltEVV_Generic_Xref_Model initAltEVVGenericXref() {
        AltEVV_Generic_Xref_Model xrefModel = new AltEVV_Generic_Xref_Model();
        xrefModel.setEmployeeID("D" + RandomStringUtils.randomNumeric(6));
        xrefModel.setClientID("P" + RandomStringUtils.randomNumeric(6));
        xrefModel.setService(getRandomValidService());
        xrefModel.setXRefStartDate("2010-02-22");
        xrefModel.setXRefEndDate("2030-02-22");
        xrefModel.setClientIDQualifier("ClientCustomID");
        xrefModel.setEmployeeQualifier("EmployeeCustomID");
        xrefModel.setClientStatus("02");
        xrefModel.setAccount("80008");
        return xrefModel;
    }

    @Override
    public boolean verifyFieldValue(Object obj) {
        return false;
    }

    @Override
    public boolean verifyFieldsNotNull() {
        return false;
    }
}
