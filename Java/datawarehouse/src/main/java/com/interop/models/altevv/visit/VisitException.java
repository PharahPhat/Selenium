package com.interop.models.altevv.visit;

import com.google.gson.annotations.SerializedName;
import com.interop.models.altevv.AltBaseModel;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class VisitException extends AltBaseModel {
    @SerializedName("ExceptionID")
    @Builder.Default
    String exceptionID = "01";
    @SerializedName("ExceptionAcknowledged")
    @Builder.Default
    String exceptionAcknowledged = "true";
}


