package com.interop.models;

import com.google.gson.annotations.SerializedName;
import com.interop.models.altevv.AltBaseModel;
import com.interop.common.StateAccount;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class ProviderIdentification extends AltBaseModel {
    @SerializedName("ProviderID")
    String providerID;

    @SerializedName("ProviderQualifier")
    String providerQualifier;

    public static class ProviderIdentificationBuilder {
        public ProviderIdentificationBuilder withState(StateAccount account){
            this.providerID = account.getProviderID();
            this.providerQualifier = account.getProviderQualifier();
            return this;
        }
    }

    public static ProviderIdentification init(StateAccount stateAccount) {
        if(stateAccount == null){
            stateAccount = StateAccount.loadStateAccount();
        }
        return com.interop.models.ProviderIdentification.builder().providerID(stateAccount.getProviderID())
                .providerQualifier(stateAccount.getProviderQualifier()).build();
    }

    public static ProviderIdentification init() {
        StateAccount stateAccount = StateAccount.loadStateAccount();
        return com.interop.models.ProviderIdentification.builder().providerID(stateAccount.getProviderID())
                .providerQualifier(stateAccount.getProviderQualifier()).build();
    }

}
