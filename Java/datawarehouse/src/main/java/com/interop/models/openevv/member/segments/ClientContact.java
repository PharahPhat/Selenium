package com.interop.models.openevv.member.segments;

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
    @SerializedName("ClientContactType")
    String clientContactType = "Family";

    @Builder.Default
    @SerializedName("ClientContactFirstName")
    String clientContactFirstName = commons.generateRandomStringOfFixLength(10);

    @Builder.Default
    @SerializedName("ClientContactLastName")
    String clientContactLastName = commons.generateRandomStringOfFixLength(10);

    @Builder.Default
    @SerializedName("ClientContactPhoneType")
    String clientContactPhoneType = "Home";

    @Builder.Default
    @SerializedName("ClientContactPhone")
    String clientContactPhone = commons.generateRandomNumberOfFixLength(10);

    @Builder.Default
    @SerializedName("ClientContactEmailAddress")
    String clientContactEmailAddress = commons.generateEmailAddress(commons.generateRandomStringOfFixLength(5));

    @Builder.Default
    @SerializedName("ClientContactAddressLine1")
    String clientContactAddressLine1 = commons.generateRandomStringOfFixLength(10);

    @Builder.Default
    @SerializedName("ClientContactAddressLine2")
    String clientContactAddressLine2 = commons.generateRandomStringOfFixLength(10);

    @Builder.Default
    @SerializedName("ClientContactCity")
    String clientContactCity = "New York";

    @Builder.Default
    @SerializedName("ClientContactState")
    String clientContactState = "NY";

    @Builder.Default
    @SerializedName("ClientContactZip")
    String clientContactZip = "10012";
}
