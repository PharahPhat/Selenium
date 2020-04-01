package com.sandata.models.generic.client;

import org.apache.commons.lang.builder.ToStringBuilder;

public class ProviderIdentification {
    public String ProviderID;
    public String ProviderQualifier;

    public String getProviderID() {
        return ProviderID;
    }

    public void setProviderID(String providerID) {
        ProviderID = providerID;
    }

    public String getProviderQualifier() {
        return ProviderQualifier;
    }

    public void setProviderQualifier(String providerQualifier) {
        ProviderQualifier = providerQualifier;
    }

    @Override
    public String toString () {
        return ToStringBuilder.reflectionToString(this);
    }
}
