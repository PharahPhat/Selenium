package com.interop.models.claim;

import com.google.gson.annotations.SerializedName;

public enum UnitsRule {
    @SerializedName("AddUnits")
    ADD_UNITS ("AddUnits"),
    @SerializedName("AddTime")
    ADD_TIME("AddTime");

    private String value;

    UnitsRule(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }
}
