package com.interop.models.openevv.xref;

import com.google.gson.annotations.SerializedName;
import com.interop.common.StateAccount;
import com.interop.models.altevv.AltBaseModel;
import com.sandata.core.config.TestContext;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Builder
@Data
public class OpenEvvXref extends AltBaseModel {

    @Builder.Default
    @SerializedName("Account")
    String account = StateAccount.loadStateAccount().getAccountID();

    @SerializedName("EmployeeID")
    String employeeID;

    @SerializedName("ClientID")
    String clientID;

    @Builder.Default
    @SerializedName("Service")
    String service = TestContext.get().getEnvironment("serviceID");

    @Builder.Default
    @SerializedName("XRefStartDate")
    String xRefStartDate = "2010-02-22";

    @Builder.Default
    @SerializedName("XRefEndDate")
    String xRefEndDate = "2030-02-22";

    @Builder.Default
    @SerializedName("ClientIDQualifier")
    String clientIDQualifier = StateAccount.loadStateAccount().getClientQualifier();

    @Builder.Default
    @SerializedName("EmployeeQualifier")
    String employeeQualifier = StateAccount.loadStateAccount().getEmployeeQualifier();

    @Builder.Default
    @SerializedName("ClientStatus")
    String clientStatus = "02";

    @SerializedName("EmployeePIN")
    String employeePIN;
}
