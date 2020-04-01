package com.sandata.models.claim;

import com.interop.models.claim.ClaimModel;
import com.interop.models.claim.ModelVersion;
import com.interop.common.StateAccount;

import java.util.ArrayList;
import java.util.List;

public class ClaimModelBatch {

    public static List<ClaimModel> generateClaimsForSingleBatchId(StateAccount state, ModelVersion version, int numberOfClaims, String batchID) {
        List<ClaimModel> claims = new ArrayList<>();

        for (int i = 0; i < numberOfClaims; i++) {
            ClaimModel claim = ClaimModel.generateClaimModel(state, version);
            claim.setBatchID(batchID);
            claim.setTransactionID(batchID);
            claims.add(claim);
        }

        return claims;
    }
}
