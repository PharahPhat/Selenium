package com.interop.models.openevv.member.segments;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientWorkerXref {
    @SerializedName("Account")
    String account;

    @SerializedName("VendorCode")
    String vendorCode;

    @SerializedName("EmployeePIN")
    String employeePIN;

    @SerializedName("Service")
    String service;

    @SerializedName("XRefStartDate")
    String xRefStartDate;

    @SerializedName("XRefEndDate")
    String xRefEndDate;
}
