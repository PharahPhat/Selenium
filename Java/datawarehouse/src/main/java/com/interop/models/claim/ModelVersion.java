package com.interop.models.claim;

import com.google.gson.annotations.SerializedName;

public enum ModelVersion {
    @SerializedName("Model1")
    MODEL1 ("Model1"),
    @SerializedName("Model2")
    MODEL2 ("Model2"),
    @SerializedName("Model3")
    MODEL3 ("Model3");

    ModelVersion(String value) {
        this.value = value;
    }
    private String value;

    public String getValue(){
        return this.value;
    }
}
