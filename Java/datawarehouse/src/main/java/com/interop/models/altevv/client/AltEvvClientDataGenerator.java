package com.interop.models.altevv.client;

import com.interop.common.Commons;
import com.interop.common.StateAccount;

public class AltEvvClientDataGenerator {
    protected static Commons commons = new Commons();

    private AltEvvClientDataGenerator() {
    }

    public static AltEvvClient.AltEvvClientBuilder getDefaultAltEvvClientBuilder(StateAccount stateAccount) {
        return AltEvvClient.builder().withState(stateAccount);
    }

    public static AltEvvClient getDefaultAltEvvClientWithUniqueValue(StateAccount account) {
        return AltEvvClient.builder().withState(account).build();
    }

    public static AltEvvClient getDefaultAltEvvClientWithUniqueValue() {
        return AltEvvClient.builder().withState(StateAccount.loadStateAccount()).build();
    }
}
