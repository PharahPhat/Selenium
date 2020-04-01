package com.sandata.models.generic.client;

import com.sandata.core.annotation.Column;
import com.sandata.core.annotation.CsvHeader;
import com.sandata.models.molina.client.ClientGenericModel;

import java.util.Objects;

public class ClientPhone extends ClientGenericModel {

    public String ClientPhone;

    public String ClientPhoneType;

    public String ErrorCode;

    public String ErrorMessage;

    @Override
    public boolean verifyFieldsNotNull() {
        if (Objects.isNull(ClientPhoneType)) {
            return false;
        }
        if (Objects.isNull(ClientPhone)) {
            return false;
        }
        return true;
    }

    @Override
    public boolean verifyFieldValue(Object obj) {
        return true;
    }


}
