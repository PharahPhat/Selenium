package com.interop.models.altevv;

import com.interop.common.Commons;
import com.interop.common.StateAccount;

public class AltBaseModel {
    protected static Commons commons = new Commons();
    protected StateAccount getStateAccount(){
        return StateAccount.loadStateAccount();
    }
}
