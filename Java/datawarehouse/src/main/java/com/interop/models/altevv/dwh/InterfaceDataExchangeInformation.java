package com.interop.models.altevv.dwh;

import com.google.gson.annotations.SerializedName;
import com.interop.common.StateAccount;
import com.interop.models.altevv.AltBaseModel;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder

public class InterfaceDataExchangeInformation extends AltBaseModel {

    @SerializedName("Delimiter")
    @Builder.Default
    public String delimiter = "|";

    @SerializedName("PayerId")
    @Builder.Default
    public String payerId = "DWH_AUTO";

    @SerializedName("SetHeader")
    @Builder.Default
    public String setHeader = "true";

    @SerializedName("FileExtension")
    @Builder.Default
    public String fileExtension = ".dsv";

    @SerializedName("ControlFileExtension")
    @Builder.Default
    public String controlFileExtension = ".dsv";

    @SerializedName("SpecVersion")
    @Builder.Default
    public String specVersion = "generic";

    @SerializedName("SpecVersion")
    @Builder.Default
    public String specNumber = "7.1";

    @SerializedName("WithLastFailedExport")
    @Builder.Default
    public boolean withLastFailedExport = false;

    @SerializedName("QuoteNullValue")
    @Builder.Default
    public boolean quoteNullValue = true;

    @SerializedName("MultiDesignees")
    @Builder.Default
    public boolean multiDesignees = true;

    public static InterfaceDataExchangeInformation init() {
        StateAccount stateAccount = StateAccount.loadStateDwhAccount();
        return InterfaceDataExchangeInformation.builder()
                .delimiter(stateAccount.getDelimiter())
                .payerId(stateAccount.getPayerId())
                .setHeader(stateAccount.getSetHeader())
                .fileExtension(stateAccount.getFileExtension())
                .controlFileExtension(stateAccount.getControlFileExtension())
                .specVersion(stateAccount.getSpecVersion())
                .specNumber(stateAccount.getSpecNumber())
                .build();
    }

}
