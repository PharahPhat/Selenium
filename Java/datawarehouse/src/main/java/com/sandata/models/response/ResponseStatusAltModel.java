package com.sandata.models.response;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class ResponseStatusAltModel {
    public String id;
    public String status;
    public String messageSummary;
    public String messageDetail;
    public int failedCount;
    public int succeededCount;
    //public DataAlt data;
}
