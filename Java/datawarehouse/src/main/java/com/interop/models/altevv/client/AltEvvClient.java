package com.interop.models.altevv.client;

import com.google.gson.annotations.SerializedName;
import com.interop.common.State;
import com.interop.common.StateAccount;
import com.interop.models.ProviderIdentification;
import com.interop.models.altevv.AltBaseModel;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Singular;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = false)
@Builder(toBuilder = true)
@Data
public class AltEvvClient extends AltBaseModel {

    @SerializedName("ProviderIdentification")
    @Builder.Default
    ProviderIdentification providerIdentification = ProviderIdentification.init();
    @SerializedName("ClientID")
    String clientID;
    @SerializedName("ClientFirstName")
    @Builder.Default
    String clientFirstName = "AltClientFName" + RandomStringUtils.randomAlphabetic(10);
    @SerializedName("ClientMiddleInitial")
    @Builder.Default
    String clientMiddleInitial = "M";
    @SerializedName("ClientLastName")
    @Builder.Default
    String clientLastName = "AltClientLName" + RandomStringUtils.randomAlphabetic(10);
    @SerializedName("PayerName")
    @Builder.Default
    String payerName = StateAccount.loadStateAccount().getDefaultPayerID();
    @SerializedName("ClientQualifier")
    @Builder.Default
    String clientQualifier = StateAccount.loadStateAccount().getClientQualifier();
    @SerializedName("ClientMedicaidID")
    String clientMedicaidID;
    @SerializedName("ClientIdentifier")
    String clientIdentifier;
    @SerializedName("SequenceID")
    @Builder.Default
    String sequenceID = commons.generateUniqueNumber();
    @SerializedName("ClientCustomID")
    String clientCustomID;
    @SerializedName("ClientOtherID")
    String clientOtherID;
    @SerializedName("ErrorCode")
    String errorCode;
    @SerializedName("ErrorMessage")
    String errorMessage;
    @SerializedName("ClientSSN")
    String clientSSN;
    @SerializedName("ClientTimezone")
    String clientTimezone;
    @SerializedName("MissingMedicaidID")
    @Builder.Default
    String missingMedicaidID = "false";
    @SerializedName("ClientAddress")
    @Singular("address")
    List<ClientAddress> clientAddress;
    @SerializedName("ClientPhone")
    @Singular("phone")
    List<ClientPhone> clientPhone;
    @SerializedName("ClientResponsibleParty")
    @Singular("party")
    List<ClientResponsibleParty> clientResponsibleParty;
    @SerializedName("ClientPayerInformation")
    @Singular("clientPayer")
    List<ClientPayerInformation> clientPayerInformation;
    @SerializedName("ProviderAssentContPlan")
    @Builder.Default
    String providerAssentContPlan = "No";

    public static class AltEvvClientBuilder {
        public AltEvvClientBuilder withState(StateAccount account) {
            String uniqueClientIdentifier = commons.generateUniqueNumber();
            String clientUniqueId10Digits = uniqueClientIdentifier.substring(6);
            String uniqueMedicaidId = 9 + uniqueClientIdentifier.substring(5, 14);
            String unique9DigitsSSN = 9 + uniqueClientIdentifier.substring(6, 14);
            this.clientTimezone = "US/Eastern";
            this.clientIdentifier = clientUniqueId10Digits;
            this.clientOtherID = clientUniqueId10Digits;
            this.clientCustomID = clientUniqueId10Digits;
            this.clientMedicaidID = clientUniqueId10Digits;
            this.clientSSN = unique9DigitsSSN;

            switch (account.getStateEnum()) {
                case ARIZONA:
                    String azUniqueId9Digits = "D" + uniqueClientIdentifier.substring(8);
                    this.clientIdentifier = azUniqueId9Digits;
                    this.clientMedicaidID = azUniqueId9Digits;
                    this.clientOtherID = azUniqueId9Digits;
                    this.clientCustomID = azUniqueId9Digits;
                    break;
                case COLORADO:
                    String coUniqueId6Digits = "D" + uniqueClientIdentifier.substring(10);
                    this.clientIdentifier = coUniqueId6Digits;
                case INDIANA:
                case WISCONSIN:
                    this.clientTimezone = "US/Central";
                    break;
                case RHODEISLAND:
                    this.clientSSN = "0" + unique9DigitsSSN.substring(1);
                case HAWAII:
                default:
                    break;
            }
            if (account.getStateEnum() == State.WISCONSIN || account.getStateEnum() == State.ARIZONA || account.getStateEnum() == State.RHODEISLAND || account.getStateEnum() == State.VERMONT || account.getStateEnum() == State.HAWAII ) {
                this.clientPayerInformation = new ArrayList<>();
                this.clientPayerInformation.add(ClientPayerInformation.builder().build());
                this.clientResponsibleParty = new ArrayList<>();
                this.clientResponsibleParty.add(ClientResponsibleParty.builder().build());
            }
            this.clientAddress = new ArrayList<>();
            this.clientAddress.add(ClientAddress.builder().withState(account).build());
            this.clientPhone = new ArrayList<>();
            this.clientPhone.add(ClientPhone.builder().withState(account).build());
            return this;
        }
    }
}