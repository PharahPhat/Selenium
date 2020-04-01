package com.interop.models.db.stx;
import com.sandata.core.annotation.DataTableColumn;
import lombok.Data;

@Data
public class Be_Setup {
    @DataTableColumn
    public Object BE_GUID;
    @DataTableColumn
    public Object WS_AUTHENTICATION_USERNAME;
    @DataTableColumn
    public Object WS_AUTHENTICATION_PWD_HASH;
    @Override
    public String toString() {
        return "Be_Setup{" +
                "BE_GUID=" + BE_GUID +
                ",WS_AUTHENTICATION_USERNAME=" + WS_AUTHENTICATION_USERNAME +
                ",WS_AUTHENTICATION_PWD_HASH=" + WS_AUTHENTICATION_PWD_HASH +
                '}';
    }
}
