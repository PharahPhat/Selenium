package com.interop.models.altevv.client;

import com.google.gson.annotations.SerializedName;
import com.interop.common.State;
import com.interop.common.StateAccount;
import com.interop.models.altevv.AltBaseModel;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang.RandomStringUtils;

import java.util.Random;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class ClientAddress extends AltBaseModel {
    @SerializedName("ClientAddressType")
    @Builder.Default
    private String clientAddressType = "Home";

    @SerializedName("ClientAddressLine1")
    @Builder.Default
    private String clientAddressLine1 = "36 West 5th Street";

    @SerializedName("ClientAddressLine2")
    @Builder.Default
    private String clientAddressLine2 = "2nd Floor";

    @SerializedName("ClientCounty")
    private String clientCounty;

    @SerializedName("ClientCity")
    @Builder.Default
    private String clientCity = "Manhattan";

    @SerializedName("ClientState")
    @Builder.Default
    private String clientState = "NY";

    @SerializedName("ClientZip")
    @Builder.Default
    private String clientZip = "100170000";

    private String errorCode;

    private String errorMessage;

    @SerializedName("ClientAddressIsPrimary")
    @Builder.Default
    String clientAddressIsPrimary = "true";

    @SerializedName("ClientAddressLongitude")
    @Builder.Default
    String clientAddressLongitude = "-73.4228741";

    @SerializedName("ClientAddressLatitude")
    @Builder.Default
    String clientAddressLatitude = "40.7431032";

    public static class ClientAddressBuilder {
        public ClientAddressBuilder withState(StateAccount stateAccount) {
            this.clientCounty = this.getValidCounty(stateAccount);
            if (stateAccount.getStateEnum() == State.WISCONSIN) {
                this.clientZip(RandomStringUtils.randomNumeric(9));
                this.clientAddressType("Other");
                this.clientAddressIsPrimary("false");
            }
            return this;
        }

        private String getValidCounty(StateAccount account) {
            String[] value;
            if (account.getStateEnum().equals(State.HAWAII)) {
                value = new String[]{"01 Oahu", "04 Kauai", "08 Molokai"};
                return value[new Random().nextInt(value.length)];
            } else return "King";
        }
    }
}
