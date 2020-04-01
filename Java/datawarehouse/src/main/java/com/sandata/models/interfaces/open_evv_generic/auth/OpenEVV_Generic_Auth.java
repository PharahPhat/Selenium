package com.sandata.models.interfaces.open_evv_generic.auth;

import com.google.gson.annotations.Expose;
import com.sandata.models.GenericModel;


import java.util.List;

public class OpenEVV_Generic_Auth extends GenericModel {

    public String PayerID;
    public String PayerProgram;
    public String ClientQualifier;
    public String ClientIdentifier;
    public String EmployeeID;
    public String EmployeePINQualifier;
    public String ProviderQualifier;
    public String ProviderID;
    public String AuthorizationReferenceNumber;
    public String AuthorizationServiceID;
    public String AuthorizationBillingType;
    public String Modifier1;
    public String Modifier2;
    public String Modifier3;
    public String Modifier4;
    public String AuthorizationAmountType;
    public String AuthorizationMaximum;
    public String Units;
    public String AuthorizationStartDate;
    public String AuthorizationEndDate;
    public String AuthorizationShared;
    public String AuthorizationComments;
    public String AuthorizationLimitType;
    public String AuthorizationStatus;
    public String ClientDiagnosisCode;
    public AuthorizationLimit AuthorizationLimits;

    @Expose
    public transient List<OpenEVV_Generic_Auth> openEVV_Generic_Auths;

    @Override
    public boolean verifyFieldValue(Object obj) {
        return false;
    }

    @Override
    public boolean verifyFieldsNotNull() {
        return false;
    }




}
