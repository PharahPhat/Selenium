package com.sandata.entity.ohio.visit;

public class VisitChange {
    public String SequenceID;
    public String ChangeMadeByEmail;
    public String ChangeDateTime;
    public String ReasonCode;
    public String ChangeReasonMemo;
    public String ResolutionCode;

    public String getSequenceID() {
        return SequenceID;
    }

    public void setSequenceID(String sequenceID) {
        SequenceID = sequenceID;
    }

    public String getChangeMadeByEmail() {
        return ChangeMadeByEmail;
    }

    public void setChangeMadeByEmail(String changeMadeByEmail) {
        ChangeMadeByEmail = changeMadeByEmail;
    }

    public String getChangeDateTime() {
        return ChangeDateTime;
    }

    public void setChangeDateTime(String changeDateTime) {
        ChangeDateTime = changeDateTime;
    }

    public String getReasonCode() {
        return ReasonCode;
    }

    public void setReasonCode(String reasonCode) {
        ReasonCode = reasonCode;
    }

    public String getChangeReasonMemo() {
        return ChangeReasonMemo;
    }

    public void setChangeReasonMemo(String changeReasonMemo) {
        ChangeReasonMemo = changeReasonMemo;
    }

    public String getResolutionCode() {
        return ResolutionCode;
    }

    public void setResolutionCode(String resolutionCode) {
        ResolutionCode = resolutionCode;
    }
}
