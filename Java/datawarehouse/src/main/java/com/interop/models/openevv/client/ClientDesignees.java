package com.interop.models.openevv.client;

import com.google.gson.annotations.SerializedName;
import com.interop.models.altevv.AltBaseModel;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang.RandomStringUtils;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class ClientDesignees extends AltBaseModel {
    @SerializedName("ClientDesigneeFirstName")
    @Builder.Default
    String clientDesigneeFirstName = "DesigneeF" + (RandomStringUtils.randomAlphabetic(10));

    @SerializedName("ClientDesigneeLastName")
    @Builder.Default
    String clientDesigneeLastName = "DesigneeL" + (RandomStringUtils.randomAlphabetic(10));

    @SerializedName("ClientDesigneeEmail")
    @Builder.Default
    String clientDesigneeEmail = RandomStringUtils.randomAlphanumeric(5) + "_" +
            commons.generateUniqueNumber() + "@mailinator.com";
    @SerializedName("ClientDesigneeStatus")
    @Builder.Default
    String clientDesigneeStatus = "02";

    @SerializedName("ClientDesigneeStartDate")
    @Builder.Default
    String clientDesigneeStartDate = "2019-01-01";

    @Builder.Default
    @SerializedName("ClientDesigneeEndDate")
    String clientDesigneeEndDate = commons.getDateString(0, "yyyy-MM-dd");

    @Builder.Default
    @SerializedName("ClientDesigneeRelationship")
    String clientDesigneeRelationship = "Mother";
}

