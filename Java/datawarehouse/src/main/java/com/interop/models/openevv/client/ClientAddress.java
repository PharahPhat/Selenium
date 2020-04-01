package com.interop.models.openevv.client;

import com.google.gson.annotations.SerializedName;
import com.interop.models.altevv.AltBaseModel;
import com.sandata.common.Constant;
import com.interop.common.StateAccount;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Random;

@EqualsAndHashCode(callSuper = false)
@Data
@Builder
public class ClientAddress extends AltBaseModel {
    @SerializedName("Account")
    @Builder.Default
    private String account = StateAccount.loadStateAccount().getAccountID();
    @SerializedName("ClientID")
    private String clientID;
    @SerializedName("AddressType")
    @Builder.Default
    private String addressType = "Home";
    @SerializedName("ClientAddressLine1")
    @Builder.Default
    private String clientAddressLine1 = "KMS AddressLine1";
    @SerializedName("ClientAddressLine2")
    @Builder.Default
    private String clientAddressLine2 = "KMS AddressLine2";
    @SerializedName("ClientCounty")
    @Builder.Default
    private String clientCounty = "Kings";
    @SerializedName("ClientCity")
    @Builder.Default
    private String clientCity = "Manhattan";
    @SerializedName("ClientState")
    @Builder.Default
    private String clientState = Constant.CLIENTSTATE[new Random().nextInt(Constant.CLIENTSTATE.length)];
    @SerializedName("ClientZip")
    @Builder.Default
    private String clientZip = "10017";
}
