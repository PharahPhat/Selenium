package com.interop.models.openevv.client;

import com.google.gson.annotations.SerializedName;
import com.interop.models.altevv.AltBaseModel;
import com.interop.common.StateAccount;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang.RandomStringUtils;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class ClientPhone extends AltBaseModel {
    @SerializedName("Account")
    @Builder.Default
    private String account = StateAccount.loadStateAccount().getAccountID();
    @SerializedName("ClientID")
    private String clientID;
    @SerializedName("ClientPhone")
    @Builder.Default
    private String clientPhoneNumber = RandomStringUtils.randomNumeric(10);
    @SerializedName("ClientPhoneType")
    @Builder.Default
    private String clientPhoneType = "Home";
}
