package com.sandata.models.response.claim;

public class ClaimStatus {
    public String id;
    public String status;
    public EVV_ResponseData data;

    public EVV_ResponseData getData() {
        return data;
    }

    public void setData(EVV_ResponseData data) {
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
