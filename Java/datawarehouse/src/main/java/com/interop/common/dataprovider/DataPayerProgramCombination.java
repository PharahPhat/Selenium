package com.interop.common.dataprovider;

import com.sandata.core.annotation.CsvHeader;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DataPayerProgramCombination {
    @CsvHeader("PayerID")
    private String payer;
    @CsvHeader("PayerProgram")
    private String program;
    @CsvHeader("AuthorizationServiceID")
    private String service;
    @CsvHeader("RevCode")
    private String revCode;
    @CsvHeader("Account")
    private String account;
    @CsvHeader("Modifier1")
    private String modifier1;
    @CsvHeader("Modifier2")
    private String modifier2;
    @CsvHeader("Modifier3")
    private String modifier3;
    @CsvHeader("Modifier4")
    private String modifier4;
    @CsvHeader("Description")
    private String description;
    @CsvHeader("Status")
    private String expectedStatus;
    @CsvHeader("GetStatus")
    private String expectedGetStatus;
    @CsvHeader("ErrorMessage")
    private String expectedMessage;
    @CsvHeader("isCheckedDatabase")
    private String isCheckedDatabase;
}
