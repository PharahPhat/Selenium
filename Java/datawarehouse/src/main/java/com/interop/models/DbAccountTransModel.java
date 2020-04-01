package com.interop.models;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class DbAccountTransModel {

    @SerializedName("fileName")
    private String fileName;

    @SerializedName("fileSize")
    private String fileSize;

    @SerializedName("status")
    private String status;
}