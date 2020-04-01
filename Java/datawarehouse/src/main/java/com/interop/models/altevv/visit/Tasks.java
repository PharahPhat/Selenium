package com.interop.models.altevv.visit;

import com.google.gson.annotations.SerializedName;
import com.interop.common.StateAccount;
import com.interop.models.altevv.AltBaseModel;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class Tasks extends AltBaseModel {
    @SerializedName("TaskID")
    @Builder.Default
    String taskID = "0030";
    @SerializedName("TaskReading")
    String taskReading;
    @SerializedName("TaskRefused")
    @Builder.Default
    String taskRefused = "false";
}
