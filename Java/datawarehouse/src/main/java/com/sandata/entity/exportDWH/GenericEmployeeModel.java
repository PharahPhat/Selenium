package com.sandata.entity.exportDWH;

import com.sandata.models.GenericModel;

public abstract class GenericEmployeeModel extends GenericModel {
    public abstract boolean verifyFieldValue(Object obj);
    public abstract boolean verifyFieldsNotNull();
}
