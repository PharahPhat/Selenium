package com.interop.models.altevv.dwh;

import com.google.gson.annotations.SerializedName;
import com.interop.common.StateAccount;
import com.interop.models.altevv.AltBaseModel;

import lombok.Builder;

@Builder

public class AccountInterfaceEndpointInformation extends AltBaseModel {

    @SerializedName("resolve_vault_path_maine_sftp")
    @Builder.Default
    public String resolve_vault_path_maine_sftp = "sftp-kv/maine_exp_dwh";

    @SerializedName("folder_path")
    @Builder.Default
    public String folder_path = "/DevOhioInterfaces/DevSwarmExportDataWarehouse";

    @SerializedName("pgp_public_key")
    @Builder.Default
    public String pgp_public_key = "";

    public static AccountInterfaceEndpointInformation init() {
        StateAccount stateAccount = StateAccount.loadStateDwhAccount();
        return AccountInterfaceEndpointInformation.builder()
                .resolve_vault_path_maine_sftp(stateAccount.getSpecNumber())
                .resolve_vault_path_maine_sftp(stateAccount.getResolveVaultPathMaineSftp())
                .folder_path(stateAccount.getFolderPath())
                .pgp_public_key(stateAccount.getPgpPublicKey())
                .build();
    }
}
