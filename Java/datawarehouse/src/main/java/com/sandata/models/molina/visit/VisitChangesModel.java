package com.sandata.models.molina.visit;

import com.sandata.core.annotation.Column;
import com.sandata.core.annotation.CsvHeader;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Objects;

public class VisitChangesModel extends VisitGenericModel{
    @CsvHeader("VisitKey")
    @Column(value = "VisitKey", index = 0)
    private String visitKey;

    @CsvHeader("ChangeID")
    @Column(value = "ChangeID", index = 1)
    private String changeID;

    @CsvHeader("ChangeType")
    @Column(value = "ChangeType", index = 2)
    private String changeType;

    @CsvHeader("SequenceID")
    @Column(value = "SequenceID", index = 3)
    private String sequenceID;

    @CsvHeader("VisitChangeExternalID")
    @Column(value = "VisitChangeExternalID", index = 4)
    private String visitChangeExternalID;

    @CsvHeader("ChangeMadeBy")
    @Column(value = "ChangeMadeBy", index = 5)
    private String changeMadeBy;

    @CsvHeader("ChangeDateTime")
    @Column(value = "ChangeDateTime", index = 6)
    private String changeDateTime;

    @CsvHeader("RecordUpdateDateTime")
    @Column(value = "RecordUpdateDateTime", index = 7)
    private String recordUpdateDateTime;

    @CsvHeader("ReasonCode")
    @Column(value = "ReasonCode", index = 8)
    private String reasonCode;

    @CsvHeader("ChangeReasonMemo")
    @Column(value = "ChangeReasonMemo", index = 9)
    private String changeReasonMemo;

    @CsvHeader("ResolutionCode")
    @Column(value = "ResolutionCode", index = 10)
    private String resolutionCode;

    @CsvHeader("VisitChangeLogDetails")
    @Column(value = "VisitChangeLogDetails", index = 11)
    private String visitChangeLogDetails;

    public String getVisitKey() {
        return visitKey;
    }

    public void setVisitKey(String visitKey) {
        this.visitKey = visitKey;
    }

    public String getChangeID() {
        return changeID;
    }

    public void setChangeID(String changeID) {
        this.changeID = changeID;
    }

    public String getChangeType() {
        return changeType;
    }

    public void setChangeType(String changeType) {
        this.changeType = changeType;
    }

    public String getSequenceID() {
        return sequenceID;
    }

    public void setSequenceID(String sequenceID) {
        this.sequenceID = sequenceID;
    }

    public String getVisitChangeExternalID() {
        return visitChangeExternalID;
    }

    public void setVisitChangeExternalID(String visitChangeExternalID) {
        this.visitChangeExternalID = visitChangeExternalID;
    }

    public String getChangeDateTime() {
        return changeDateTime;
    }

    public void setChangeDateTime(String changeDateTime) {
        this.changeDateTime = changeDateTime;
    }

    public String getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(String reasonCode) {
        this.reasonCode = reasonCode;
    }

    public String getChangeReasonMemo() {
        return changeReasonMemo;
    }

    public void setChangeReasonMemo(String changeReasonMemo) {
        this.changeReasonMemo = changeReasonMemo;
    }

    public String getResolutionCode() {
        return resolutionCode;
    }

    public void setResolutionCode(String resolutionCode) {
        this.resolutionCode = resolutionCode;
    }

    public String getVisitChangeLogDetails() {
        return visitChangeLogDetails;
    }

    public void setVisitChangeLogDetails(String visitChangeLogDetails) {
        this.visitChangeLogDetails = visitChangeLogDetails;
    }

    @Override
    public String toString() {
        String toString = "VisitChangesModel{" +
                "visitKey='" + visitKey + '\'' +
                "changeID='" + changeID + '\'' +
                "changeType='" + changeType + '\'' +
                "sequenceID='" + sequenceID + '\'' +
                "visitChangeExternalID='" + visitChangeExternalID + '\'' +
                "changeDateTime='" + changeDateTime + '\'' +
                "reasonCode='" + reasonCode + '\'' +
                "changeReasonMemo='" + changeReasonMemo + '\'' +
                "resolutionCode='" + resolutionCode + '\'' +
                "visitChangeLogDetails='" + visitChangeLogDetails + '\'' +
                '}';
        return toString.replace("null", "");
    }

    @Override
    public boolean equals(String fileValue, String dbValue) {
        return StringUtils.equalsIgnoreCase(fileValue, dbValue);
    }

    @Override
    public boolean verifyFieldValue(Object obj) {
        if (Objects.isNull(obj)) return false;
        VisitChangesModel modelObject = (VisitChangesModel) obj;
        return equals(modelObject.visitKey, this.visitKey)
                && equals(modelObject.sequenceID, this.sequenceID)
                && equals(modelObject.changeID, this.changeID);
    }

    private boolean verifyFormatField(String fieldValue, String regex) {
        return Objects.nonNull(fieldValue) && fieldValue.matches(regex);
    }

    public boolean verifyFormatFields(VisitChangesModel model) {
        return this.verifyFormatField(model.visitChangeLogDetails, "s?\\w{1,100}=(.){0,900}$");
    }

    public static boolean verifyDataInCsvCorrectly(List<VisitChangesModel> models){
        for (VisitChangesModel model: models){
            if(!model.verifyFormatFields(model)) return false;
        }
        return true;
    }

    public static boolean verifyDataInDbAndCsvCorrectly(List<VisitChangesModel> models){
        for (VisitChangesModel model: models){
            if(!model.verifyFormatFields(model)) return false;
        }
        return true;
    }

    @Override
    public boolean verifyFieldsNotNull() {
        if (Objects.isNull(visitKey)) {
            return false;
        }
        if (Objects.isNull(changeID)) {
            return false;
        }
        return true;
    }
}
