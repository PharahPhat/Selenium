package com.sandata.models.response;

import com.fasterxml.jackson.annotation.*;
import com.google.gson.JsonElement;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "status",
        "token",
        "messageSummary",
        "messageDetail",
        "errorMessage",
        "failedCount",
        "succeededCount",
        "cached",
        "cachedDate",
        "totalRows",
        "page",
        "pageSize",
        "orderByColumn",
        "orderByDirection",
        "data"
})
@JsonIgnoreProperties(ignoreUnknown=true)
public class ResponseStatusModel {
    @JsonProperty("id")
    public String id;
    @JsonProperty("status")
    public String status;
    @JsonProperty("token")
    public String token;
    @JsonProperty("messageSummary")
    public String messageSummary;
    @JsonProperty("messageDetail")
    public String messageDetail;
    @JsonProperty("errorMessage")
    public String errorMessage;
    @JsonProperty("failedCount")
    public int failedCount;
    @JsonProperty("succeededCount")
    public int succeededCount;
    @JsonProperty("cached")
    public boolean cached;
    @JsonProperty("cachedDate")
    public String cachedDate;
    @JsonProperty("totalRows")
    public int totalRows;
    @JsonProperty("page")
    public int page;
    @JsonProperty("pageSize")
    public int pageSize;
    @JsonProperty("orderByColumn")
    public String orderByColumn;
    @JsonProperty("orderByDirection")
    public String orderByDirection;

    public JsonElement getData() {
        return data;
    }

    public void setData(JsonElement data) {
        this.data = data;
    }

    public transient JsonElement data;

    @JsonIgnore
    public Map<String, Object> additionalProperties = new HashMap<>();

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}