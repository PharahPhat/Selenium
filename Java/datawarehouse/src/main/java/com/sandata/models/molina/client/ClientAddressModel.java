package com.sandata.models.molina.client;

import com.sandata.core.annotation.Column;
import com.sandata.core.annotation.CsvHeader;
import com.sandata.utilities.CompareUtil;
import org.testng.Assert;

import java.util.List;
import java.util.Objects;

public class ClientAddressModel extends ClientGenericModel{
//    @CsvHeader("PayerID")
    @Column(value = "PayerID", index = 0)
    private String payerID;

    @CsvHeader("ProviderID")
    @Column(value = "ProviderID", index = 1)
    private String providerID;

    @CsvHeader("ClientID")
    @Column(value = "ClientID", index = 2)
    private String clientID;

    @CsvHeader("ClientAddressType")
    @Column("ClientAddressType")
    private String clientAddressType;

    @CsvHeader("ClientAddressLine1")
    @Column("ClientAddressLine1")
    private String clientAddressLine1;

    @CsvHeader("ClientAddressLine2")
    @Column("ClientAddressLine2")
    private String clientAddressLine2;

    @CsvHeader("ClientCounty")
    @Column("ClientCounty")
    private String clientCounty;

    @CsvHeader("ClientCity")
    @Column("ClientCity")
    private String clientCity;

    @CsvHeader("ClientState")
    @Column("ClientState")
    private String clientState;

    @CsvHeader("ClientZip")
    @Column("ClientZip")
    private String clientZip;

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

    public String getClientAddressType() {
        return clientAddressType;
    }

    public void setClientAddressType(String clientAddressType) {
        this.clientAddressType = clientAddressType;
    }

    public String getClientAddressLine1() {
        return clientAddressLine1;
    }

    public void setClientAddressLine1(String clientAddressLine1) {
        this.clientAddressLine1 = clientAddressLine1;
    }

    public String getClientAddressLine2() {
        return clientAddressLine2;
    }

    public void setClientAddressLine2(String clientAddressLine2) {
        this.clientAddressLine2 = clientAddressLine2;
    }

    public String getClientCounty() {
        return clientCounty;
    }

    public void setClientCounty(String clientCounty) {
        this.clientCounty = clientCounty;
    }

    public String getClientCity() {
        return clientCity;
    }

    public void setClientCity(String clientCity) {
        this.clientCity = clientCity;
    }

    public String getClientState() {
        return clientState;
    }

    public void setClientState(String clientState) {
        this.clientState = clientState;
    }

    public String getClientZip() {
        return clientZip;
    }

    public void setClientZip(String clientZip) {
        this.clientZip = clientZip;
    }

    @Override
    public String toString() {
        String toString = "ClientAddressModel{" +
//                "payerID='" + payerID + '\'' +
                "providerID='" + providerID + '\'' +
                "clientID='" + clientID + '\'' +
                "clientAddressType='" + clientAddressType + '\'' +
                "clientAddressLine1='" + clientAddressLine1 + '\'' +
                "clientAddressLine2='" + clientAddressLine2 + '\'' +
                "clientCounty='" + clientCounty + '\'' +
                "clientCity='" + clientCity + '\'' +
                "clientState='" + clientState + '\'' +
                "clientZip='" + clientZip + '\'' +
                '}';
        return toString.replace("null", "");
    }

    public boolean verifyFormatField(String fieldValue, String regex) {
        if(!fieldValue.equals(null) && !fieldValue.equals(""))
            if(!fieldValue.matches(regex))
                return false;
        return true;
    }

    public boolean verifyFormatFields() {
//        if(!this.verifyFormatField(this.payerID, "^\\w{0,64}$")) return false;
        if(!this.verifyFormatField(this.providerID, "^\\w{0,50}$")) return false;
        if(!this.verifyFormatField(this.clientID, "^\\w{0,10}$")) return false;
        if(!this.verifyFormatField(this.clientAddressType, "^(?:Business|Home|Other)$")) return false;
        if(!this.verifyFormatField(this.clientAddressLine1, "^.{0,30}$")) return false;
        if(!this.verifyFormatField(this.clientAddressLine2, "^.{0,30}$")) return false;
        if(!this.verifyFormatField(this.clientCounty, "^\\w{0,25}$")) return false;
        if(!this.verifyFormatField(this.clientCity, "^\\w{0,30}$")) return false;
        if(!this.verifyFormatField(this.clientState, "^\\w{0,2}$")) return false;
        if(!this.verifyFormatField(this.clientZip, "^\\w{0,9}$")) return false;
        return true;
    }

    public static boolean verifyDataInDbAndCsvCorrectly(List<ClientAddressModel> recordsCsv){
        for (ClientAddressModel recordCsv: recordsCsv){
            if(!recordCsv.verifyFormatFields()) return false;
        }
        return true;
    }

    public static void verifyRandomRecordsFieldNotNull(List<ClientAddressModel> dataList, List<String> definedField) throws InterruptedException,  IllegalAccessException {
        if(dataList.size() > 5){
            for(int i = 0; i < 5; i++) {
                Assert.assertFalse(CompareUtil.isSpecificFieldsNull(dataList.get(i), definedField));
            }
        }else{
            for(int i = 0; i < dataList.size(); i++) {
                Assert.assertFalse(CompareUtil.isSpecificFieldsNull(dataList.get(i), definedField));
            }
        }
    }

    public boolean isNotNull(String fileValue, String dbValue) {
        if(dbValue != null && !fileValue.isEmpty()){
            return true;
        }
        return false;
    }

    public boolean isDataCorrect(String fileValue, String dbValue) {
        if(isNotNull(fileValue, dbValue)) {
            if(!fileValue.equalsIgnoreCase(dbValue)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean verifyFieldValue(Object obj) {
        ClientAddressModel modelObject = (ClientAddressModel) obj;
//        if(!this.getPayerID().equalsIgnoreCase(modelObject.getPayerID())) {
//            return false;
//        }

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

        if(!isDataCorrect(this.getClientAddressType(), modelObject.getClientAddressType())){
            return false;
        }

        if(!isDataCorrect(this.getClientAddressLine1(), modelObject.getClientAddressLine1())){
            return false;
        }

        if(!isDataCorrect(this.getClientAddressLine2(), modelObject.getClientAddressLine2())){
            return false;
        }

        if(!isDataCorrect(this.getClientCounty(), modelObject.getClientCounty())){
            return false;
        }

        if(!isDataCorrect(this.getClientCity(), modelObject.getClientCity())){
            return false;
        }

        if(!isDataCorrect(this.getClientState(), modelObject.getClientState())){
            return false;
        }

        if(!isDataCorrect(this.getClientZip(), modelObject.getClientZip())){
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
