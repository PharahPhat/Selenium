package com.interop.models.claim;

import com.google.gson.annotations.SerializedName;

public enum MatchingRule {
    @SerializedName("ExcludeUnits")
    EXCLUDE_UNITS("ExcludeUnits"),

    @SerializedName("ExactMatch")
    EXACT_MATCH("ExactMatch"),

    @SerializedName("EqualOrGreaterThan")
    EQUAL_OR_GREATER_THAN("EqualOrGreaterThan");

    private String value;

    MatchingRule(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }
}
