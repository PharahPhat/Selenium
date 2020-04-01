package com.sandata.entity.exportDWH.OhioExportConfigurationV1;

import com.sandata.entity.exportDWH.ExportConfigurationV1.AccountInterfaceEndpointInformationV1;

import com.sandata.entity.generic.GenericEntity;

import java.util.ArrayList;
import java.util.List;

public class ExportWithConfigurationModel extends GenericEntity {
    public InterfaceDataExchangeInformation interfaceDataExchangeInformation;
    public List<AccountInterfaceEndpointInformationV1> accountInterfaceEndpointsInformation = new ArrayList<>();
    public AccountInterfaceParamInformation accountInterfaceParamInformation;
}
