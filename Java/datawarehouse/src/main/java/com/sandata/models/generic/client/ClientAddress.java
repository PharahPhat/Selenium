package com.sandata.models.generic.client;

import com.sandata.models.molina.client.ClientGenericModel;
import com.sandata.utilities.CompareUtil;
import org.testng.Assert;

import java.util.List;
import java.util.Objects;

public class ClientAddress extends ClientGenericModel{
    public String PayerID;
    public String ProviderID;
    public String ClientID;
    public String ClientAddressType;
    public String ClientAddressLine1;
    public String ClientAddressLine2;
    public String ClientCounty;
    public String ClientCity;
    public String ClientState;
    public String ClientZip;
    public String ClientAddressIsPrimary;
    public String ClientAddressLongitude;
    public String ClientAddressLatitude;
    public String ErrorCode;
    public String ErrorMessage;

    public String getClientAddressIsPrimary() {
        return ClientAddressIsPrimary;
    }

    public void setClientAddressIsPrimary(String clientAddressIsPrimary) {
        clientAddressIsPrimary = clientAddressIsPrimary;
    }

    public String getClientLongitude() {
        return ClientAddressLongitude;
    }

    public void setClientLongitude(String clientLongitude) {
        clientLongitude = clientLongitude;
    }

    public String getClientLatitude() {
        return ClientAddressLatitude;
    }

    public void setClientLatitude(String clientLatitude) {
        ClientAddressLatitude = clientLatitude;
    }

    public String getErrorCode() {
        return ErrorCode;
    }

    public void setErrorCode(String errorCode) {
        ErrorCode = errorCode;
    }

    public String getErrorMessage() {
        return ErrorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        ErrorMessage = errorMessage;
    }

    public String getPayerID() {
        return PayerID;
    }

    public void setPayerID(String payerID) {
        this.PayerID = payerID;
    }

    public String getProviderID() {
        return ProviderID;
    }

    public void setProviderID(String providerID) {
        this.ProviderID = providerID;
    }

    public String getClientID() {
        return ClientID;
    }

    public void setClientID(String clientID) {
        this.ClientID = clientID;
    }

    public String getClientAddressType() {
        return ClientAddressType;
    }

    public void setClientAddressType(String clientAddressType) {
        this.ClientAddressType = clientAddressType;
    }

    public String getClientAddressLine1() {
        return ClientAddressLine1;
    }

    public void setClientAddressLine1(String clientAddressLine1) {
        this.ClientAddressLine1 = clientAddressLine1;
    }

    public String getClientAddressLine2() {
        return ClientAddressLine2;
    }

    public void setClientAddressLine2(String clientAddressLine2) {
        this.ClientAddressLine2 = clientAddressLine2;
    }

    public String getClientCounty() {
        return ClientCounty;
    }

    public void setClientCounty(String clientCounty) {
        this.ClientCounty = clientCounty;
    }

    public String getClientCity() {
        return ClientCity;
    }

    public void setClientCity(String clientCity) {
        this.ClientCity = clientCity;
    }

    public String getClientState() {
        return ClientState;
    }

    public void setClientState(String clientState) {
        this.ClientState = clientState;
    }

    public String getClientZip() {
        return ClientZip;
    }

    public void setClientZip(String clientZip) {
        this.ClientZip = clientZip;
    }

    @Override
    public String toString() {
        String toString = "ClientAddressModel{" +
//                "payerID='" + payerID + '\'' +
                "providerID='" + ProviderID + '\'' +
                "clientID='" + ClientID + '\'' +
                "clientAddressType='" + ClientAddressType + '\'' +
                "clientAddressLine1='" + ClientAddressLine1 + '\'' +
                "clientAddressLine2='" + ClientAddressLine2 + '\'' +
                "clientCounty='" + ClientCounty + '\'' +
                "clientCity='" + ClientCity + '\'' +
                "clientState='" + ClientState + '\'' +
                "clientZip='" + ClientZip + '\'' +
                '}';
        return toString.replace("null", "");
    }

    public boolean verifyFormatField(String fieldValue, String regex) {
        if(!fieldValue.equals(null) && !fieldValue.equals(""))
            return fieldValue.matches(regex);
        return true;
    }

    public boolean verifyFormatFields() {
//        if(!this.verifyFormatField(this.payerID, "^\\w{0,64}$")) return false;
        if(!this.verifyFormatField(this.ProviderID, "^\\w{0,50}$")) return false;
        if(!this.verifyFormatField(this.ClientID, "^\\w{0,10}$")) return false;
        if(!this.verifyFormatField(this.ClientAddressType, "^(?:Business|Home|Other)$")) return false;
        if(!this.verifyFormatField(this.ClientAddressLine1, "^.{0,30}$")) return false;
        if(!this.verifyFormatField(this.ClientAddressLine2, "^.{0,30}$")) return false;
        if(!this.verifyFormatField(this.ClientCounty, "^\\w{0,25}$")) return false;
        if(!this.verifyFormatField(this.ClientCity, "^\\w{0,30}$")) return false;
        if(!this.verifyFormatField(this.ClientState, "^\\w{0,2}$")) return false;
        return this.verifyFormatField(this.ClientZip, "^\\w{0,9}$");
    }

    public static boolean verifyDataInDbAndCsvCorrectly(List<ClientAddress> recordsCsv){
        for (ClientAddress recordCsv: recordsCsv){
            if(!recordCsv.verifyFormatFields()) return false;
        }
        return true;
    }

    public static void verifyRandomRecordsFieldNotNull(List<ClientAddress> dataList, List<String> definedField) throws InterruptedException,  IllegalAccessException {
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
        return dbValue != null && !fileValue.isEmpty();
    }

    public boolean isDataCorrect(String fileValue, String dbValue) {
        if(isNotNull(fileValue, dbValue)) {
            return fileValue.equalsIgnoreCase(dbValue);
        }
        return true;
    }

    @Override
    public boolean verifyFieldValue(Object obj) {
        ClientAddress modelObject = (ClientAddress) obj;
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

        return isDataCorrect(this.getClientZip(), modelObject.getClientZip());
    }

    @Override
    public boolean verifyFieldsNotNull() {
        if (Objects.isNull(PayerID)) {
            return false;
        }
        if (Objects.isNull(ProviderID)) {
            return false;
        }
        return !Objects.isNull(ClientID);
    }
}
