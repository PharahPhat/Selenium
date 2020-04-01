package com.sandata.models.molina.visit;

import com.sandata.core.annotation.Column;
import com.sandata.core.annotation.CsvHeader;
import com.sandata.core.annotation.DataTableColumn;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;

import java.util.Objects;

public class VisitExceptionsModel extends VisitGenericModel {
    @CsvHeader("VisitKey")
    @Column(value = "VISITKEY", index = 0)
    @DataTableColumn("VISITKEY")
    private Object visitKey;

    @CsvHeader("ExceptionID")
    @Column(value = "EXCPKEY", index = 1)
    @DataTableColumn("EXCPKEY")
    private Object exceptionID;

    @CsvHeader("ExceptionAcknowledged")
    @Column(value = "ExceptionAcknowledged", index = 2)
    private String exceptionAcknowledged;

    public String getVisitKey() {
        return String.valueOf(visitKey);
    }

    public void setVisitKey(String visitKey) {
        this.visitKey = visitKey;
    }

    public String getExceptionID() {
        return String.valueOf(exceptionID);
    }

    public void setExceptionID(String exceptionID) {
        this.exceptionID = exceptionID;
    }

    public String getExceptionAcknowledged() {
        return exceptionAcknowledged;
    }

    public void setExceptionAcknowledged(String exceptionAcknowledged) {
        this.exceptionAcknowledged = exceptionAcknowledged;
    }

    @Override
    public String toString() {
        String toString = "VisitExceptionsModel{" +
                "visitKey='" + visitKey + '\'' +
                "callKey='" + exceptionID + '\'' +
                "callDateTime='" + exceptionAcknowledged + '\'' +
                '}';
        return toString.replace("null", "");
    }

    @Override
    public boolean verifyFieldValue(Object obj) {
        VisitExceptionsModel modelObject = (VisitExceptionsModel)obj;
        if(!this.getVisitKey().equalsIgnoreCase(modelObject.getVisitKey())) {
            return false;
        }
        if(!this.getExceptionID().equalsIgnoreCase(modelObject.getExceptionID())) {
            return false;
        }
        return true;
    }

    @Override
    public boolean equals(String fileValue, String dbValue) {
        return StringUtils.equalsIgnoreCase(fileValue, dbValue);
    }

    public void verifyFormatFields(){
        Assert.assertTrue(String.valueOf(this.visitKey).matches("^\\w{0,50}$"),"Format of field visitKey is not correctly");
        Assert.assertTrue(String.valueOf(this.exceptionID).matches("^\\w{0,2}$"),"Format of field exceptionID is not correctly");
        Assert.assertTrue(this.exceptionAcknowledged.matches("^(true|false)$"),"Format of field exceptionAcknowledged is not correctly");
    }

    @Override
    public boolean verifyFieldsNotNull() {
        if (Objects.isNull(visitKey)) {
            return false;
        }
        if (Objects.isNull(exceptionID)) {
            return false;
        }
        return true;
    }
}
