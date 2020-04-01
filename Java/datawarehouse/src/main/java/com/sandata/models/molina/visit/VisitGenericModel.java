package com.sandata.models.molina.visit;

import com.sandata.models.GenericModel;

public abstract class VisitGenericModel extends GenericModel {

    public abstract boolean verifyFieldValue(Object obj);
    public abstract boolean equals(String s1, String s2);
}
