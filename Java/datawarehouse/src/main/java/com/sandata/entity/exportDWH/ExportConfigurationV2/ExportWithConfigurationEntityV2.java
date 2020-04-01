package com.sandata.entity.exportDWH.ExportConfigurationV2;

import com.sandata.entity.exportDWH.ExportConfigurationV2.AccountInterfaceEndpointInformation;
import com.sandata.entity.exportDWH.ExportConfigurationV1.MessageQueueInformation;

public class ExportWithConfigurationEntityV2 {

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

    public InterfaceDataExchangeInformationEntityV2 getInterfaceDataExchangeInformation() {
        return interfaceDataExchangeInformation;
    }

    public void setInterfaceDataExchangeInformation(InterfaceDataExchangeInformationEntityV2 interfaceDataExchangeInformation) {
        this.interfaceDataExchangeInformation = interfaceDataExchangeInformation;
    }

    public String getInterfaceDataExchangeType() {
        return interfaceDataExchangeType;
    }

    public void setInterfaceDataExchangeType(String interfaceDataExchangeType) {
        this.interfaceDataExchangeType = interfaceDataExchangeType;
    }

    public AccountInterfaceEndpointInformation getAccountInterfaceEndpointInformation() {
        return accountInterfaceEndpointInformation;
    }

    public void setAccountInterfaceEndpointInformation(AccountInterfaceEndpointInformation accountInterfaceEndpointInformation) {
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

    public AccountInterfaceParamInformationEntityV2 getAccountInterfaceParamInformation() {
        return accountInterfaceParamInformation;
    }

    public void setAccountInterfaceParamInformation(AccountInterfaceParamInformationEntityV2 accountInterfaceParamInformation) {
        this.accountInterfaceParamInformation = accountInterfaceParamInformation;
    }

    public String interfaceDirectionQualifier;
    public String accountInterfaceName;
    public String accountInterfaceConfigurationSchedule;
    public String messageQueueTypeCode;
    public MessageQueueInformation messageQueueInformation;
    public String interfaceDataExchangeFormat;
    public InterfaceDataExchangeInformationEntityV2 interfaceDataExchangeInformation;
    public String interfaceDataExchangeType;
    public AccountInterfaceEndpointInformation accountInterfaceEndpointInformation;
    public String recordCreatedBy;
    public String recordUpdatedBy;
    public boolean accountInterfaceActiveFlag;
    public String accountInterfaceDirectory;
    public AccountInterfaceParamInformationEntityV2 accountInterfaceParamInformation;
}
