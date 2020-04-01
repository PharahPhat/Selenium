package com.sandata.models.molina.employee;

import com.sandata.models.GenericModel;

public abstract class EmployeeGenericModel extends GenericModel {
    public abstract boolean verifyFieldValue(Object obj);
    public abstract boolean verifyFieldsNotNull();
}
