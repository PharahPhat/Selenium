package com.interop.models.openevv.client;

import com.google.gson.annotations.SerializedName;
import com.interop.common.StateAccount;
import com.interop.models.ProviderIdentification;
import com.sandata.common.Constant;
import com.sandata.common.Timezone;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.apache.commons.lang.RandomStringUtils;

import java.util.List;
import java.util.Random;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class OpenEvvClient extends OpenEvvClientBase {

    @SerializedName("ClientAddress")
    @Singular("address")
    public List<ClientAddress> clientAddress;
    @SerializedName("ClientPhone")
    @Singular("phone")
    public List<ClientPhone> clientPhone;
    @SerializedName("ClientDesignees")
    @Singular("designees")
    public List<ClientDesignees> clientDesignees;
    @SerializedName("ClientPayerInformation")
    @Singular("payerInformation")
    public List<ClientPayerInformation> clientPayerInformation;
    @SerializedName("ProviderIdentification")
    @Builder.Default
    private ProviderIdentification providerIdentification = ProviderIdentification.init();
}