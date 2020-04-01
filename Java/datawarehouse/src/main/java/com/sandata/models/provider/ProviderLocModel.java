package com.sandata.models.provider;

import com.sandata.core.annotation.Column;
import com.sandata.core.annotation.CsvHeader;
import com.sandata.core.annotation.DataTableColumn;

public class ProviderLocModel{
    @CsvHeader("PayerID")
    @Column("PayerID")
    @DataTableColumn
    private String payerID;

    @CsvHeader("ProviderID")
    @Column("ProviderID")
    @DataTableColumn
    private String providerID;

    @CsvHeader("LocationName")
    @Column("LocationName")
    @DataTableColumn
    private String locationName;

    @CsvHeader("LocationIdentifier")
    @Column("LocationIdentifier")
    @DataTableColumn
    private String locationIdentifier;

    @CsvHeader("LocationAddressLine1")
    @Column("LocationAddressLine1")
    @DataTableColumn
    private String locationAddressLine1;

    @CsvHeader("LocationAddressLine2")
    @Column("LocationAddressLine2")
    @DataTableColumn
    private String locationAddressLine2;

    @CsvHeader("LocationCity")
    @Column("LocationCity")
    @DataTableColumn
    private String locationCity;

    @CsvHeader("LocationState")
    @Column("LocationState")
    @DataTableColumn
    private String locationState;

    @CsvHeader("LocationZip")
    @Column("LocationZip")
    @DataTableColumn
    private String locationZip;

    @CsvHeader("LocationContactLastName")
    @Column("LocationContactLastName")
    @DataTableColumn
    private String locationContactLastName;

    @CsvHeader("LocationContactFirstName")
    @Column("LocationContactFirstName")
    @DataTableColumn
    private String locationContactFirstName;

    @CsvHeader("LocationPhone")
    @Column("LocationPhone")
    @DataTableColumn
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
}

