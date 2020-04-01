package com.sandata.entity.claim;

import java.util.List;

public class ClaimValidationV2 {
    public List<EVV_Request> EVV_Request;

    public List<com.sandata.entity.claim.EVV_Request> getEVV_Request() {
        return EVV_Request;
    }

    public void setEVV_Request(List<com.sandata.entity.claim.EVV_Request> EVV_Request) {
        this.EVV_Request = EVV_Request;
    }
}
