package com.interop.models.openevv.client;

import com.google.gson.annotations.SerializedName;
import com.interop.models.ProviderIdentification;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
public class OpenEvvClientV1 extends OpenEvvClientBase {

    @Singular("clientContact")
    @SerializedName("ClientContacts")
    List<ClientContactV1> clientContact;
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
    public ProviderIdentification providerIdentification;
}
