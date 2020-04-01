package com.interop.models.openevv.client;
import com.google.gson.annotations.SerializedName;
import com.interop.common.StateAccount;
import com.interop.models.altevv.AltBaseModel;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = false)
@Data
@Builder
public class ClientContactV1 extends AltBaseModel {
    @Builder.Default
    @SerializedName("Account")
    String account = StateAccount.loadStateAccount().getAccountID();

    @SerializedName("ClientID")
    String clientID ;

    @Builder.Default
    @SerializedName("ContactRelationshipToClient")
    String clientContactType = "Child";

    @Builder.Default
    @SerializedName("ContactFirstName")
    String clientContactFirstName = commons.generateRandomStringOfFixLength(10);

    @Builder.Default
    @SerializedName("ContactLastName")
    String clientContactLastName = commons.generateRandomStringOfFixLength(10);

    @Builder.Default
    @SerializedName("ClientContactPhoneType")
    String clientContactPhoneType = "Home";

    @Builder.Default
    @SerializedName("ContactPhoneNumber")
    String clientContactPhone = commons.generateRandomNumberOfFixLength(10);

    @Builder.Default
    @SerializedName("ContactAddressLine1")
    String clientContactAddressLine1 = commons.generateRandomStringOfFixLength(10);

    @Builder.Default
    @SerializedName("ContactAddressLine2")
    String clientContactAddressLine2 = commons.generateRandomStringOfFixLength(10);

    @Builder.Default
    @SerializedName("ContactCity")
    String clientContactCity = "New York";

    @Builder.Default
    @SerializedName("ContactState")
    String clientContactState = "NY";

    @Builder.Default
    @SerializedName("ContactZip")
    String clientContactZip = "10012";
}
