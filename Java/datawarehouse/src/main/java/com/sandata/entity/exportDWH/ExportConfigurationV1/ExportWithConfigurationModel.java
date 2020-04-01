package com.sandata.entity.exportDWH.ExportConfigurationV1;

public class ExportWithConfigurationModel {

    public String getAccountInterfaceConfigurationSK() {
        return accountInterfaceConfigurationSK;
    }

    public void setAccountInterfaceConfigurationSK(String accountInterfaceConfigurationSK) {
        this.accountInterfaceConfigurationSK = accountInterfaceConfigurationSK;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getInterfaceId() {
        return interfaceId;
    }

    public void setInterfaceId(String interfaceId) {
        this.interfaceId = interfaceId;
    }

    public String getInterfaceDirectionQualifier() {
        return interfaceDirectionQualifier;
    }

    public void setInterfaceDirectionQualifier(String interfaceDirectionQualifier) {
        this.interfaceDirectionQualifier = interfaceDirectionQualifier;
    }

    public String getAccountInterfaceName() {
        return accountInterfaceName;
    }

    public void setAccountInterfaceName(String accountInterfaceName) {
        this.accountInterfaceName = accountInterfaceName;
    }

    public String getAccountInterfaceConfigurationSchedule() {
        return accountInterfaceConfigurationSchedule;
    }

    public void setAccountInterfaceConfigurationSchedule(String accountInterfaceConfigurationSchedule) {
        this.accountInterfaceConfigurationSchedule = accountInterfaceConfigurationSchedule;
    }

    public String getMessageQueueTypeCode() {
        return messageQueueTypeCode;
    }

    public void setMessageQueueTypeCode(String messageQueueTypeCode) {
        this.messageQueueTypeCode = messageQueueTypeCode;
    }

    public MessageQueueInformation getMessageQueueInformation() {
        return messageQueueInformation;
    }

    public void setMessageQueueInformation(MessageQueueInformation messageQueueInformation) {
        this.messageQueueInformation = messageQueueInformation;
    }

    public String getInterfaceDataExchangeFormat() {
        return interfaceDataExchangeFormat;
    }

    public void setInterfaceDataExchangeFormat(String interfaceDataExchangeFormat) {
        this.interfaceDataExchangeFormat = interfaceDataExchangeFormat;
    }

    public InterfaceDataExchangeInformation getInterfaceDataExchangeInformation() {
        return interfaceDataExchangeInformation;
    }

    public void setInterfaceDataExchangeInformation(InterfaceDataExchangeInformation interfaceDataExchangeInformation) {
        this.interfaceDataExchangeInformation = interfaceDataExchangeInformation;
    }

    public String getInterfaceDataExchangeType() {
        return interfaceDataExchangeType;
    }

    public void setInterfaceDataExchangeType(String interfaceDataExchangeType) {
        this.interfaceDataExchangeType = interfaceDataExchangeType;
    }

    public AccountInterfaceEndpointInformationV1 getAccountInterfaceEndpointInformation() {
        return accountInterfaceEndpointInformation;
    }

    public void setAccountInterfaceEndpointInformation(AccountInterfaceEndpointInformationV1 accountInterfaceEndpointInformation) {
        this.accountInterfaceEndpointInformation = accountInterfaceEndpointInformation;
    }

    public String getRecordCreatedBy() {
        return recordCreatedBy;
    }

    public void setRecordCreatedBy(String recordCreatedBy) {
        this.recordCreatedBy = recordCreatedBy;
    }

    public String getRecordUpdatedBy() {
        return recordUpdatedBy;
    }

    public void setRecordUpdatedBy(String recordUpdatedBy) {
        this.recordUpdatedBy = recordUpdatedBy;
    }

    public boolean isAccountInterfaceActiveFlag() {
        return accountInterfaceActiveFlag;
    }

    public void setAccountInterfaceActiveFlag(boolean accountInterfaceActiveFlag) {
        this.accountInterfaceActiveFlag = accountInterfaceActiveFlag;
    }

    public String getAccountInterfaceDirectory() {
        return accountInterfaceDirectory;
    }

    public void setAccountInterfaceDirectory(String accountInterfaceDirectory) {
        this.accountInterfaceDirectory = accountInterfaceDirectory;
    }

    public AccountInterfaceParamInformation getAccountInterfaceParamInformation() {
        return accountInterfaceParamInformation;
    }

    public void setAccountInterfaceParamInformation(AccountInterfaceParamInformation accountInterfaceParamInformation) {
        this.accountInterfaceParamInformation = accountInterfaceParamInformation;
    }

    public String accountInterfaceConfigurationSK;
    public String account;
    public String interfaceId;
    public String interfaceDirectionQualifier;
    public String accountInterfaceName;
    public String accountInterfaceConfigurationSchedule;
    public String messageQueueTypeCode;
    public MessageQueueInformation messageQueueInformation;
    public String interfaceDataExchangeFormat;
    public InterfaceDataExchangeInformation interfaceDataExchangeInformation;
    public String interfaceDataExchangeType;
    public AccountInterfaceEndpointInformationV1 accountInterfaceEndpointInformation;
    public String recordCreatedBy;
    public String recordUpdatedBy;
    public boolean accountInterfaceActiveFlag;
    public String accountInterfaceDirectory;
    public AccountInterfaceParamInformation accountInterfaceParamInformation;
}
