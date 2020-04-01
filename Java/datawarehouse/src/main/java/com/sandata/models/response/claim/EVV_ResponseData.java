package com.sandata.models.response.claim;

import java.util.List;

public class EVV_ResponseData {
    public List<EVV_Response> EVV_Response;

    public List<com.sandata.models.response.claim.EVV_Response> getEVV_Response() {
        return EVV_Response;
    }

    public void setEVV_Response(List<com.sandata.models.response.claim.EVV_Response> EVV_Response) {
        this.EVV_Response = EVV_Response;
    }
}
