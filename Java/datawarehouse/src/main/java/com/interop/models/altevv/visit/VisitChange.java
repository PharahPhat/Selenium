package com.interop.models.altevv.visit;

import com.google.gson.annotations.SerializedName;
import com.interop.models.altevv.AltBaseModel;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class VisitChange extends AltBaseModel {
    @SerializedName("SequenceID")
    @Builder.Default
    String sequenceID = commons.generateUniqueNumber();
    @SerializedName("ChangeMadeBy")
    @Builder.Default
    String changeMadeBy = "KMSAutomationTest@test.com";
    @SerializedName("ChangeDateTime")
    @Builder.Default
    String changeDateTime = commons.getPastTime(5);
    @SerializedName("GroupCode")
    @Builder.Default
    String groupCode = "94567";
    @SerializedName("ReasonCode")
    @Builder.Default
    String reasonCode = "10";
    @SerializedName("ChangeReasonMemo")
    @Builder.Default
    String changeReasonMemo = "KMS Def Reason Note";
    @SerializedName("ResolutionCode")
    @Builder.Default
    String resolutionCode = "A";
}
