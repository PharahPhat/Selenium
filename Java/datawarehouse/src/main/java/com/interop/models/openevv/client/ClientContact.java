package com.interop.models.openevv.client;

import com.google.gson.annotations.SerializedName;
import com.interop.models.altevv.AltBaseModel;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
@Builder
public class ClientContact extends AltBaseModel {
    @Builder.Default
    @SerializedName("ContactFirstName")
    String contactFirstName = commons.generateRandomStringOfFixLength(10);

    @Builder.Default
    @SerializedName("ContactLastName")
    String contactLastName = commons.generateRandomStringOfFixLength(10);

    @Builder.Default
    @SerializedName("ContactPhoneType")
    String contactPhoneType = "Home";

    @SerializedName("ContactRelationshipToClient")
    String contactRelationshipToClient;

    @Builder.Default
    @SerializedName("ContactPhoneNumber")
    String contactPhoneNumber = commons.generateRandomNumberOfFixLength(10);

    @Builder.Default
    @SerializedName("ContactEmail")
    String contactEmail = commons.generateEmailAddress(commons.generateRandomStringOfFixLength(5));

    @SerializedName("ContactAddressLine1")
    String contactAddressLine1;

    @SerializedName("ContactAddressLine2")
    String contactAddressLine2;

    @Builder.Default
    @SerializedName("ContactCity")
    String contactCity = "New York";

    @Builder.Default
    @SerializedName("ContactState")
    String contactState = "NY";

    @Builder.Default
    @SerializedName("ContactZip")
    String ClientContactZip = "10012";
}
