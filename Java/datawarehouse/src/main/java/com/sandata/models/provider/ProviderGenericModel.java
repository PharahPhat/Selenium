package com.sandata.models.provider;

import com.sandata.models.GenericModel;

public abstract class ProviderGenericModel extends GenericModel {
    public abstract boolean verifyFieldValue(Object obj);
    public abstract boolean verifyFieldsNotNull();
}
