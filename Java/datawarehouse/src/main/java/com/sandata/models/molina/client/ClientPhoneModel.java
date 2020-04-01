package com.sandata.models.molina.client;

import com.sandata.core.annotation.Column;
import com.sandata.core.annotation.CsvHeader;

import java.util.Objects;

public class ClientPhoneModel extends ClientGenericModel {
//    @CsvHeader("PayerID")
    @Column(value = "CONTRACT", index = 0)
    private String payerID;

    @CsvHeader("ProviderID")
    @Column(value = "PROVIDER_ID", index = 1)
    private String providerID;

    @CsvHeader("ClientID")
    @Column(value = "LOC", index = 2)
    private String clientID;

    @CsvHeader("ClientPhoneType")
    @Column("DESCRIPTION")
    private String clientPhoneType;

    @CsvHeader("ClientPhone")
    @Column("ANI")
    private String clientPhone;

    public String getPayerID() {
        return payerID;
    }

    public void setPayerID(String payerID) {
        this.payerID = payerID;
    }

    public String getProviderID() {
        return providerID;
    }

    public void setProviderID(String providerID) {
        this.providerID = providerID;
    }

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public String getClientPhoneType() {
        return clientPhoneType;
    }

    public void setClientPhoneType(String clientPhoneType) {
        this.clientPhoneType = clientPhoneType;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    public ClientPhoneModel() {}

    @Override
    public String toString() {
        String toString = "ClientPhoneModel{" +
//                "payerID='" + payerID + '\'' +
                "providerID='" + providerID + '\'' +
                "clientID='" + clientID + '\'' +
                "clientPhoneType='" + clientPhoneType + '\'' +
                "clientPhone='" + clientPhone + '\'' +
                '}';
        return toString.replace("null", "");
    }

    @Override
    public boolean verifyFieldValue(Object obj) {
        ClientPhoneModel modelObject = (ClientPhoneModel)obj;
        if(modelObject.getProviderID().startsWith("00")){
            if (!modelObject.getProviderID().contains(this.getProviderID())) {
                return false;
            }
        }else {
            if (!this.getProviderID().equalsIgnoreCase(modelObject.getProviderID())) {
                return false;
            }
        }
        if(!this.getClientID().equalsIgnoreCase(modelObject.getClientID())) {
            return false;
        }
        if(this.clientPhoneType != null && !this.clientPhoneType.isEmpty())
        if(!this.getClientPhoneType().equalsIgnoreCase(modelObject.getClientPhoneType())) {
            return false;
        }
        if(!this.getClientPhone().equalsIgnoreCase(modelObject.getClientPhone())) {
            return false;
        }
        return true;
    }

    @Override
    public boolean verifyFieldsNotNull() {
        if (Objects.isNull(payerID)) {
            return false;
        }
        if (Objects.isNull(providerID)) {
            return false;
        }
        if (Objects.isNull(clientID)) {
            return false;
        }
        return true;
    }
}
