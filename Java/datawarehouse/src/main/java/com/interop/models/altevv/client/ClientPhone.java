package com.interop.models.altevv.client;

import com.google.gson.annotations.SerializedName;
import com.interop.common.StateAccount;
import com.interop.models.altevv.AltBaseModel;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class ClientPhone extends AltBaseModel {
    @SerializedName("ClientPhone")
    @Builder.Default
    String clientPhone = "2125551212";
    @SerializedName("ClientPhoneType")
    @Builder.Default
    String clientPhoneType = "Home";

    public static class ClientPhoneBuilder {
        public ClientPhoneBuilder withState(StateAccount stateAccount) {
            switch (stateAccount.getStateEnum()) {
                case WISCONSIN:
                    this.clientPhoneType("Other");
                    break;
                case ARIZONA:
                    //TODO SOMETHING STILL NOT BEING IMPLEMENTED
                default:
                    break;
            }
            return this;
        }
    }
}
