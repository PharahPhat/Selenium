package com.sandata.entity.exportDWH;

public abstract class VisitOhioModel extends GenericVisitModel {
    public abstract boolean verifyFieldValue(Object obj);
    public abstract boolean verifyFieldsNotNull();
}
