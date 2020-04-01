package com.sandata.models.molina.client;

import com.sandata.core.annotation.Column;
import com.sandata.core.annotation.CsvHeader;

import java.util.List;
import java.util.Objects;

public class ClientProgModel extends ClientProgMolinaModel {
    @CsvHeader("PayerID")
    @Column(value = "PayerID", index = 0)
    protected String payerID;

    @CsvHeader("ProviderID")
    @Column(value = "ProviderID", index = 1)
    protected String providerID;

    @CsvHeader("ClientID")
    @Column(value = "ClientID", index = 2)
    protected String clientID;

    @CsvHeader("Modifier1")
    @Column("Modifier1")
    private String modifier1;

    @CsvHeader("Modifier2")
    @Column("Modifier2")
    private String modifier2;

    @CsvHeader("Modifier3")
    @Column("Modifier3")
    private String modifier3;

    @CsvHeader("Modifier4")
    @Column("Modifier4")
    private String modifier4;

    public String getModifier1() {
        return modifier1;
    }

    public void setModifier1(String modifier1) {
        this.modifier1 = modifier1;
    }

    public String getModifier2() {
        return modifier2;
    }

    public void setModifier2(String modifier2) {
        this.modifier2 = modifier2;
    }

    public String getModifier3() {
        return modifier3;
    }

    public void setModifier3(String modifier3) {
        this.modifier3 = modifier3;
    }

    public String getModifier4() {
        return modifier4;
    }

    public void setModifier4(String modifier4) {
        this.modifier4 = modifier4;
    }

    @Override
    public String toString() {
        String toString = "ClientProgModel{" +
                "payerID='" + payerID + '\'' +
                "providerID='" + providerID + '\'' +
                "clientID='" + clientID + '\'' +
                "payerProgram='" + payerProgram + '\'' +
                "payerService='" + payerService + '\'' +
                "modifier1='" + modifier1 + '\'' +
                "modifier2='" + modifier2 + '\'' +
                "modifier3='" + modifier3 + '\'' +
                "modifier4='" + modifier4 + '\'' +
                "payerRegion='" + payerRegion + '\'' +
                '}';
        return toString.replace("null", "");
    }

    public boolean verifyFormatField(String fieldValue, String regex) {
        if(!fieldValue.equals("null"))
            return fieldValue.matches(regex);
        return true;
    }

    public boolean verifyFormatFields() {
        if(!this.verifyFormatField(this.payerID, "^\\w{0,64}$")) return false;
        if(!this.verifyFormatField(this.providerID, "^\\w{0,50}$")) return false;
        if(!this.verifyFormatField(this.clientID, "^\\w{0,10}$")) return false;
        if(!this.verifyFormatField(this.payerProgram, "^.{0,64}$")) return false;
        if(!this.verifyFormatField(this.payerService, "^.{0,5}$")) return false;
        if(!this.verifyFormatField(this.payerRegion, "^.{0,2}$")) return false;
        if(!this.verifyFormatField(this.modifier1, "^.{0,2}$")) return false;
        if(!this.verifyFormatField(this.modifier2, "^.{0,2}$")) return false;
        if(!this.verifyFormatField(this.modifier3, "^.{0,2}$")) return false;
        if(!this.verifyFormatField(this.modifier4, "^.{0,2}$")) return false;
        return true;
    }

    public static boolean verifyFormatFieldOfData(List<ClientProgModel> clientProgList) {
        for (ClientProgModel recordCsv: clientProgList){
            if (!recordCsv.verifyFormatFields())
                return false;
        }
        return true;
    }

    @Override
    public boolean verifyFieldValue(Object obj) {
        ClientProgModel modelObject = (ClientProgModel)obj;
//        if(!this.getPayerID().equalsIgnoreCase(modelObject.getPayerID())) {
//            return false;
//        }
        if(!this.getProviderID().equalsIgnoreCase(modelObject.getProviderID())) {
            return false;
        }
        if(!this.getClientID().equalsIgnoreCase(modelObject.getClientID())) {
            return false;
        }

        if(isNotNull(this.getPayerProgram(), modelObject.getPayerProgram())){
            if(!this.getPayerProgram().equalsIgnoreCase(modelObject.getPayerProgram())) {
                return false;
            }
        }

        if(isNotNull(this.getPayerService(), modelObject.getPayerService())) {
            if (!this.getPayerService().equalsIgnoreCase(modelObject.getPayerService())) {
                return false;
            }
        }

        if(isNotNull(this.getPayerRegion(), modelObject.getPayerRegion())) {
            if (!this.getPayerRegion().equalsIgnoreCase(modelObject.getPayerRegion())) {
                return false;
            }
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
