package com.sandata.models.provider;

import com.sandata.core.annotation.CsvHeader;

public class ProviderLocationModel {
    @CsvHeader("PayerID")
    private String payerID;

    @CsvHeader("ProviderID")
    private String providerID;

    @CsvHeader("LocationName")
    private String locationName;

    @CsvHeader("LocationIdentifier")
    private String locationIdentifier;

    @CsvHeader("LocationAddressLine1")
    private String locationAddressLine1;

    @CsvHeader("LocationAddressLine2")
    private String locationAddressLine2;

    @CsvHeader("LocationCity")
    private String locationCity;

    @CsvHeader("LocationState")
    private String locationState;

    @CsvHeader("LocationZip")
    private String locationZip;

    @CsvHeader("LocationContactLastName")
    private String locationContactLastName;

    @CsvHeader("LocationContactFirstName")
    private String locationContactFirstName;

    @CsvHeader("LocationPhone")
    private String locationPhone;

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

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationIdentifier() {
        return locationIdentifier;
    }

    public void setLocationIdentifier(String locationIdentifier) {
        this.locationIdentifier = locationIdentifier;
    }

    public String getLocationAddressLine1() {
        return locationAddressLine1;
    }

    public void setLocationAddressLine1(String locationAddressLine1) {
        this.locationAddressLine1 = locationAddressLine1;
    }

    public String getLocationAddressLine2() {
        return locationAddressLine2;
    }

    public void setLocationAddressLine2(String locationAddressLine2) {
        this.locationAddressLine2 = locationAddressLine2;
    }

    public String getLocationCity() {
        return locationCity;
    }

    public void setLocationCity(String locationCity) {
        this.locationCity = locationCity;
    }

    public String getLocationState() {
        return locationState;
    }

    public void setLocationState(String locationState) {
        this.locationState = locationState;
    }

    public String getLocationZip() {
        return locationZip;
    }

    public void setLocationZip(String locationZip) {
        this.locationZip = locationZip;
    }

    public String getLocationContactLastName() {
        return locationContactLastName;
    }

    public void setLocationContactLastName(String locationContactLastName) {
        this.locationContactLastName = locationContactLastName;
    }

    public String getLocationContactFirstName() {
        return locationContactFirstName;
    }

    public void setLocationContactFirstName(String locationContactFirstName) {
        this.locationContactFirstName = locationContactFirstName;
    }

    public String getLocationPhone() {
        return locationPhone;
    }

    public void setLocationPhone(String locationPhone) {
        this.locationPhone = locationPhone;
    }

    @Override
    public String toString() {
        String toString = "ProviderLocationModel{" +
                "payerID='" + payerID + '\'' +
                "providerID='" + providerID + '\'' +
                "locationName='" + locationName + '\'' +
                "locationIdentifier='" + locationIdentifier + '\'' +
                "locationAddressLine1='" + locationAddressLine1 + '\'' +
                "locationAddressLine2='" + locationAddressLine2 + '\'' +
                "locationCity='" + locationCity + '\'' +
                "locationState='" + locationState + '\'' +
                "locationZip='" + locationZip + '\'' +
                "locationContactLastName='" + locationContactLastName + '\'' +
                "locationContactFirstName='" + locationContactFirstName + '\'' +
                "locationPhone='" + locationPhone + '\'' +
                '}';
        return toString.replace("null", "");
    }
}
