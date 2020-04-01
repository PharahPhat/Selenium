package com.sandata.models.claim.ohio.v1;

import com.sandata.models.claim.BatchClaimGenericModel;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.sandata.common.Constant.EXTENSION.txt;

public class BatchClaimOhioV1 extends BatchClaimGenericModel {
    public String fileName_BatchClaimOhioV1;
    public List<ClaimOhioV1Model> claimOhioV1Models = new ArrayList<>();
    public String batchId;

    public void initMultipleLineOhioClaimV1(int count, String providerId, String medicaidId, String visitStartDate, String service) {
        batchId = commons.generateUniqueNumber();
        claimOhioV1Models = new ArrayList<>();
        for (int i = 1; i <= count; i++ ) {
            ClaimOhioV1Model claimOhioV1Model = initSingleLineOhioClaimV1(
                    providerId,
                    batchId,
                            i + batchId,
                    "ODM",
                    RandomStringUtils.randomNumeric(13),
                    "04",
                    medicaidId,
                    visitStartDate,
                    service,
                    "3"
            );
            claimOhioV1Models.add(claimOhioV1Model);
        }
    }

    public ClaimOhioV1Model initSingleLineOhioClaimV1(String providerId, String batchId, String transactionId,
                                                    String payerId, String ICN, String DLN, String medicaid, String visitStartDate,
                                                    String service, String unit) {
        ClaimOhioV1Model claimOhioV1Model = new ClaimOhioV1Model();
        claimOhioV1Model.ProviderId = providerId;
        claimOhioV1Model.BatchId = batchId;
        claimOhioV1Model.TransactionId = transactionId;
        claimOhioV1Model.PayerId = payerId;
        claimOhioV1Model.ICN = ICN;
        claimOhioV1Model.DLN = DLN;
        claimOhioV1Model.Qualifier1 = "MedicaidID";
        claimOhioV1Model.Identifier = providerId;
        claimOhioV1Model.Qualifier2 = "MedicaidID";
        claimOhioV1Model.MedicaidId = medicaid;
        claimOhioV1Model.VisitStartDate = visitStartDate;
        claimOhioV1Model.Service = service;
        claimOhioV1Model.Unit = unit;

        return claimOhioV1Model;
    }

    public void toFile() {
        super.toFile();
        fileName_BatchClaimOhioV1 = BATCH_CLAIM_FILE_PREFIX + commons.generateUniqueNumber() + "." + txt;
        logInfo("Going to write to: " + TO_BATCH_CLAIM_FOLDER_PATH + fileName_BatchClaimOhioV1);

        Collection lines = new ArrayList<>();

        for (int i = 0; i<= claimOhioV1Models.size() - 1; i++) {
            lines.add(claimOhioV1Models.get(i).toLine());
        }

        File fileToWrite1 = FileUtils.getFile(TO_BATCH_CLAIM_FOLDER_PATH + fileName_BatchClaimOhioV1);
        try {
            FileUtils.writeLines(fileToWrite1, lines);
        } catch (Exception e) {}
    }
}
