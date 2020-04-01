package com.interop.models.openevv.member.segments;

import com.google.gson.annotations.SerializedName;
import com.interop.models.altevv.AltBaseModel;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
@Builder
public class ClientDesign extends AltBaseModel {

    @SerializedName("ClientID")
    String clientId;

    @Builder.Default
    @SerializedName("ClientDesigneeFirstName")
    String clientDesigneeFirstName = commons.generateRandomStringOfFixLength(25);

    @Builder.Default
    @SerializedName("ClientDesigneeLastName")
    String clientDesigneeLastName = commons.generateRandomStringOfFixLength(25);

    @Builder.Default
    @SerializedName("ClientDesigneeEmail")
    String clientDesigneeEmail = commons.generateEmailAddress(commons.generateRandomStringOfFixLength(5));

    @Builder.Default
    @SerializedName("ClientDesigneeStatus")
    String clientDesigneeStatus = "02";

    @Builder.Default
    @SerializedName("ClientDesigneeStartDate")
    String clientDesigneeStartDate = commons.getDateUTCFormat(-30, "yyyy-MM-dd");

    @Builder.Default
    @SerializedName("ClientDesigneeEndDate")
    String clientDesigneeEndDate = commons.getDateUTCFormat(0, "yyyy-MM-dd"); //The ClientDesigneeEndDate must be today.

    @SerializedName("ClientDesigneeRelationship")
    String clientDesigneeRelationship;

    String errorCode;

    String errorMessage;

    public static class ClientDesignBuilder {
        public ClientDesignBuilder addClientId(String clientId) {
            this.clientId(clientId);
            return this;
        }
    }
}
