package com.sandata.models.dwh.ohio;

import java.util.List;

public class HistoricalVisitChanges {
    public String VisitKey;
    public String ChangeID;
    public String ChangeType;
    public String SequenceID;
    public String VisitChangeExternalID;
    public String ChangeMadeByEmail;
    public String ChangeDateTime;
    public String RecordUpdateDateTime;
    public String ReasonCode;
    public String ChangeReasonMemo;
    public String ReasonCodeDescription;
    public String ResolutionCode;
    List<VisitChangeLogDetails> VisitChangeLogDetails;

    public boolean getDataIsNotNull(){
        return VisitKey != null && ChangeID != null;
    }
}
