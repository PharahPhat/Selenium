package com.interop.models.openevv;

import com.google.gson.annotations.Expose;
import com.interop.common.Commons;
import com.interop.common.StateAccount;
import com.sandata.core.annotation.CsvHeader;
import lombok.Data;

@Data
public class OpenEvvBaseModel {
    protected static Commons commons = new Commons();
    protected static StateAccount getStateAccount(){
        return StateAccount.loadStateAccount();
    }

    @Expose(serialize = false, deserialize = false)
    @CsvHeader("Error Description")
    public String errorDescription;
}
