package com.interop.models.altevv.employee;

import com.google.gson.annotations.SerializedName;
import com.interop.common.StateAccount;
import com.interop.models.ProviderIdentification;
import com.interop.models.altevv.AltBaseModel;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.RandomStringUtils;

@Builder
@Data
@EqualsAndHashCode(callSuper = true)
public class AltEvvEmployee extends AltBaseModel {

    private static String uniqueEmployeeIdentifier = commons.generateSequenceID();

    @SerializedName("ProviderIdentification")
    @Builder.Default
    ProviderIdentification providerIdentification = ProviderIdentification.init();

    @SerializedName("EmployeeIdentifier")
    @Builder.Default
    String employeeIdentifier = commons.generateRandomNumberOfFixLength(9); //Max length employeeIdentifier = 9

    @SerializedName("EmployeeOtherID")
    @Builder.Default
    String employeeOtherID = commons.generateRandomSsn(); //Max length employeeOtherID = 64

    @SerializedName("SequenceID")
    @Builder.Default
    String sequenceID = commons.generateSequenceID();

    @SerializedName("EmployeeQualifier")
    @Builder.Default
    String employeeQualifier = StateAccount.loadStateAccount().getEmployeeQualifier();

    @SerializedName("EmployeeSSN")
    @Builder.Default
    String employeeSSN = commons.generateRandomSsn();

    @SerializedName("EmployeeLastName")
    @Builder.Default
    String employeeLastName = "AltEmployeeLName" + RandomStringUtils.randomAlphabetic(10);

    @SerializedName("EmployeeFirstName")
    @Builder.Default
    String employeeFirstName = "AltEmployeeFName" + RandomStringUtils.randomAlphabetic(10);

    @SerializedName("EmployeeEmail")
    @Builder.Default
    String employeeEmail = "AltEmployeeEmail" + RandomStringUtils.randomAlphabetic(10) + "@mailinator.com";

    @SerializedName("EmployeeManagerEmail")
    @Builder.Default
    String employeeManagerEmail = "AltEmployeeEmail" + RandomStringUtils.randomAlphabetic(10) + "@mailinator.com";

    @SerializedName("EmployeePosition")
    @Builder.Default
    String employeePosition = "RN";

    @SerializedName("EmployeeAPI")
    @Builder.Default
    String employeeAPI = "UserEmployeeAPI";

    @SerializedName("EmployeeHireDate")
    @Builder.Default
    String employeeHireDate = "2019-01-01";

    @SerializedName("EmployeeEndDate")
    @Builder.Default
    String employeeEndDate = "2030-01-30";

    @SerializedName("ErrorCode")
    String errorCode;

    @SerializedName("ErrorMessage")
    String errorMessage;
}
