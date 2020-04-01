package com.interop.models.db.inbox;

import com.sandata.core.annotation.DataTableColumn;

public class InboxAuthorization {
    @DataTableColumn
    private Object ERROR_CODE;

    public Object getERROR_CODE() {
        return ERROR_CODE;
    }

    public void setERROR_CODE(Object ERROR_CODE) {
        this.ERROR_CODE = ERROR_CODE;
    }

    @Override
    public String toString() {
        return "InboxAuthorization{" +
                "ERROR_CODE=" + ERROR_CODE +
                '}';
    }
}
