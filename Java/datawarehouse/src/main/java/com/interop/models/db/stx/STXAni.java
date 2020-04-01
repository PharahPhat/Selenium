package com.interop.models.db.stx;

import com.sandata.core.annotation.DataTableColumn;
import lombok.Data;

@Data
public class STXAni {

    @DataTableColumn
    public Object ANIKEY;

    @DataTableColumn
    public Object ACCOUNT;

    @DataTableColumn
    public Object CLIENTKEY;

    @DataTableColumn
    public Object BEG_DATE;

    @DataTableColumn
    public Object END_DATE;

    @DataTableColumn
    public Object LOC;

    @DataTableColumn
    public Object CLIENT_ID;

    @DataTableColumn
    public Object ANI;

    @DataTableColumn
    public Object PHONE_PRI;

    @DataTableColumn
    public Object ACCEPTED;

    @DataTableColumn
    public Object DESCRIPTION;

}
