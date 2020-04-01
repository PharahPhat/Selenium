package com.sandata.models.molina.client;

import com.sandata.models.GenericModel;

public abstract class ClientGenericModel extends GenericModel {
    public abstract boolean verifyFieldValue(Object obj);
    public abstract boolean verifyFieldsNotNull();
}
