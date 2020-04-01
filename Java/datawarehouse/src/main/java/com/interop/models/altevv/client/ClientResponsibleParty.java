package com.interop.models.altevv.client;

import com.google.gson.annotations.SerializedName;
import com.interop.models.altevv.AltBaseModel;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class ClientResponsibleParty extends AltBaseModel {
    @SerializedName("ClientContactType")
    @Builder.Default
    String clientContactType = "Friend";
    @SerializedName("ClientContactFirstName")
    @Builder.Default
    String clientContactFirstName = "David";
    @SerializedName("ClientContactLastName")
    @Builder.Default
    String clientContactLastName = "Rutgos";
    @SerializedName("ClientContactPhoneType")
    @Builder.Default
    String clientContactPhoneType =  "Mobile";
    @SerializedName("ClientContactPhone")
    @Builder.Default
    String clientContactPhone = "3478788467";
    @SerializedName("ClientContactEmailAddress")
    @Builder.Default
    String clientContactEmailAddress = "altevv_client_ri@mailinator.com";
    @SerializedName("ClientContactAddressLine1")
    @Builder.Default
    String clientContactAddressLine1 = "2727 East 29th Street";
    @SerializedName("ClientContactAddressLine2")
    @Builder.Default
    String clientContactAddressLine2 = "Apt 8I";
    @SerializedName("ClientContactCity")
    @Builder.Default
    String clientContactCity = "Brooklyn";
    @SerializedName("ClientContactState")
    @Builder.Default
    String clientContactState = "NY";
    @SerializedName("ClientContactZip")
    @Builder.Default
    String clientContactZip = "11229";
}
