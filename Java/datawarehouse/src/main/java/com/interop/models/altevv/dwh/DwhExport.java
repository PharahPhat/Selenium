package com.interop.models.altevv.dwh;

import com.google.gson.annotations.SerializedName;
import com.interop.models.altevv.AltBaseModel;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Builder(toBuilder = true)
@Data
@AllArgsConstructor

public class DwhExport extends AltBaseModel{

    @SerializedName("InterfaceDataExchangeInformation")
    @Builder.Default
    public InterfaceDataExchangeInformation interfaceDataExchangeInformation = InterfaceDataExchangeInformation.init();

    @SerializedName("AccountInterfaceEndpointInformation")
    @Builder.Default
    public AccountInterfaceEndpointInformation accountInterfaceEndpointInformation = AccountInterfaceEndpointInformation.init();

    @SerializedName("AccountInterfaceParamInformation")
    @Builder.Default
    public AccountInterfaceParamInformation accountInterfaceParamInformation = AccountInterfaceParamInformation.init();

    public DwhExport(){
        interfaceDataExchangeInformation = InterfaceDataExchangeInformation.init();
        accountInterfaceEndpointInformation = AccountInterfaceEndpointInformation.init();
        accountInterfaceParamInformation = AccountInterfaceParamInformation.init();
    }
}
