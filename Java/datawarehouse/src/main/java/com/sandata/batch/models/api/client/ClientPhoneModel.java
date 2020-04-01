package com.sandata.batch.models.api.client;

import com.google.gson.annotations.SerializedName;

public class ClientPhoneModel {

    @SerializedName("ClientPhoneType")
    private String ClientPhoneType;

    @SerializedName("ClientPhone")
    private String ClientPhone;

    public String getClientPhoneType() {
        return ClientPhoneType;
    }

    public void setClientPhoneType(String clientPhoneType) {
        ClientPhoneType = clientPhoneType;
    }

    public String getClientPhone() {
        return ClientPhone;
    }

    public void setClientPhone(String clientPhone) {
        ClientPhone = clientPhone;
    }
}
