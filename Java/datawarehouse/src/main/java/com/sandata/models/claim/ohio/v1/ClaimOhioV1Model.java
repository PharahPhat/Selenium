package com.sandata.models.claim.ohio.v1;

public class ClaimOhioV1Model {
    public String ProviderId = "";
    public String BatchId = "";
    public String TransactionId = "";
    public String PayerId = "";
    public String ICN = "";
    public String DLN = "";
    public String Qualifier1 = "";
    public String Identifier = "";
    public String Qualifier2 = "";
    public String MedicaidId = "";
    public String VisitStartDate = "";
    public String Service = "";
    public String Unit = "";

    public String toLine() {
        return ProviderId + "|" +
                BatchId + "|" +
                TransactionId + "|" +
                PayerId + "|" +
                ICN + "|" +
                DLN + "|" +
                Qualifier1 + "|" +
                Identifier + "|" +
                Qualifier2 + "|" +
                MedicaidId + "|" +
                VisitStartDate + "|" +
                Service + "|" +
                Unit;
    }
}
