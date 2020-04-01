package com.sandata.entity.connecticut.visit;

public class VisitChanges {
    public String SequenceID;
    public String ChangeMadeBy;
    public String ChangeDateTime;
    public String GroupCode;
    public String ReasonCode;
    public String ChangeReasonMemo;
    public String ResolutionCode;

    public String getSequenceID() {
        return SequenceID;
    }

    public void setSequenceID(String sequenceID) {
        SequenceID = sequenceID;
    }

    public String getChangeMadeBy() {
        return ChangeMadeBy;
    }

    public void setChangeMadeBy(String changeMadeBy) {
        ChangeMadeBy = changeMadeBy;
    }

    public String getChangeDateTime() {
        return ChangeDateTime;
    }

    public void setChangeDateTime(String changeDateTime) {
        ChangeDateTime = changeDateTime;
    }

    public String getGroupCode() {
        return GroupCode;
    }

    public void setGroupCode(String groupCode) {
        GroupCode = groupCode;
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
