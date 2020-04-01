package com.interop.common;

import com.sandata.core.config.Environment;
import com.sandata.core.config.TestContext;
import com.sandata.utilities.JsonReader;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StateAccount {
    private String accountTemplate;
    private String wsUserName;
    private String wsPassword;
    private String accountID;
    private String providerID;
    private String providerQualifier;
    private String clientQualifier;
    private String employeeQualifier;
    private String defaultPayerID;
    private String defaultProcedureCode;
    private String defaultPayerProgram;
    private String stateName;
    private String accountType;
    private State stateEnum;


    private String delimiter;
    private String payerId;
    private String setHeader;
    private String fileExtension;
    private String controlFileExtension;
    private String specVersion;
    private String specNumber;
    private String resolveVaultPathMaineSftp;
    private String folderPath;
    private String pgpPublicKey;
    private String startDate;
    private String endDate;
    private String exportMode;
    private String backDays;
    private String groupKey;
    private String account;
    private String providerMode;
    private String payerMode;
    private String clientMode;
    private String scheduleMode;
    private String employeeMode;

    public static StateAccount loadStateAccount() {
        String stateConfig = System.getProperty("DefaultENVID", "PA");
        return loadStateAccount(TestContext.get().getEnvStage(), stateConfig);
    }

    public static StateAccount loadStateAccount(String stage, String envID) {
        StateAccount account = new StateAccount();
        Environment environment = JsonReader.loadEnvironment(stage, envID);
        account.accountTemplate = environment.get("accountTemplate");
        account.wsUserName = environment.get("wsUserName");
        account.wsPassword = environment.get("wsPassword");
        account.accountID = environment.get("accountID");
        account.providerID = environment.get("providerID");
        account.providerQualifier = environment.get("providerQualifier");
        account.clientQualifier = environment.get("clientQualifier");
        account.employeeQualifier = environment.get("employeeQualifier");
        account.accountType = environment.get("accountType");
        account.defaultProcedureCode = environment.get("defaultProcedureCode");
        account.defaultPayerProgram = environment.get("defaultPayerProgram");
        account.defaultPayerID = environment.get("defaultPayerID");
        account.stateName = environment.get("stateName");
        account.stateEnum = State.valueOf(account.getStateName().toUpperCase());
        return account;
    }

    public static StateAccount loadStateDwhAccount() {
        String stateConfig = System.getProperty("DefaultENVID", "PA");
        return loadStateDwhAccount(TestContext.get().getEnvStage(), stateConfig);
    }

    private static StateAccount loadStateDwhAccount(String stage, String envID){
        StateAccount account = new StateAccount();
        Environment environment = JsonReader.loadEnvironment(stage, envID);
        account.delimiter = environment.get("delimiter");
        account.payerId = environment.get("payerId");
        account.setHeader = environment.get("setHeader");
        account.fileExtension = environment.get("fileExtension");
        account.controlFileExtension = environment.get("controlFileExtension");
        account.specVersion = environment.get("specVersion");
        account.specNumber = environment.get("specNumber");
        account.resolveVaultPathMaineSftp = environment.get("resolve_vault_path_maine_sftp");
        account.folderPath = environment.get("folder_path");
        account.pgpPublicKey = environment.get("pgp_public_key");
        account.startDate = environment.get("startDate");
        account.endDate = environment.get("endDate");
        account.exportMode = environment.get("exportMode");
        account.backDays = environment.get("backDays");
        account.groupKey = environment.get("groupKey");
        account.account = environment.get("account");
        account.providerMode = environment.get("providerMode");
        account.payerMode = environment.get("payerMode");
        account.clientMode = environment.get("clientMode");
        account.scheduleMode = environment.get("scheduleMode");
        account.employeeMode = environment.get("employeeMode");
        return account;
    }
}
