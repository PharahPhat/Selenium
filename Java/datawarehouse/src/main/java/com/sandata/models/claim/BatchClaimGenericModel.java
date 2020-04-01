package com.sandata.models.claim;

import com.sandata.models.GenericModel;

import java.io.File;

public class BatchClaimGenericModel extends GenericModel {
    public String TO_BATCH_CLAIM_FOLDER_PATH = System.getProperty("user.dir") + "/to_claim/";
    public String BATCH_CLAIM_FILE_PREFIX = "EVV_Batch_Req.20190220.220005.";

    public void toFile() {
        File to_claim_dir = new File(TO_BATCH_CLAIM_FOLDER_PATH);
        if (!to_claim_dir.exists()) {
            to_claim_dir.mkdirs();
        }
    }

    @Override
    public boolean verifyFieldValue(Object obj) {
        return false;
    }

    @Override
    public boolean verifyFieldsNotNull() {
        return false;
    }
}
