package com.sandata.models.provider;

import com.sandata.core.annotation.Column;

public class ProviderAccountModel {
    @Column("ProviderID")
    private String ProviderID;

    public String getProviderID() {
        return ProviderID;
    }

    public void setProviderID(String providerID) {
        ProviderID = providerID;
    }
}
