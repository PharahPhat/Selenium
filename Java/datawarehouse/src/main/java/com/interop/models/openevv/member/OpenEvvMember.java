package com.interop.models.openevv.member;

import com.google.gson.annotations.SerializedName;
import com.interop.models.altevv.AltBaseModel;
import com.interop.models.altevv.client.ClientAddress;
import com.interop.models.altevv.client.ClientPhone;
import com.interop.models.openevv.member.segments.ClientContact;
import com.interop.models.openevv.member.segments.ClientDesign;
import com.interop.models.openevv.member.segments.ClientEligibility;
import com.interop.models.openevv.member.segments.ClientWorkerXref;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Singular;

import java.util.List;

@EqualsAndHashCode(callSuper = false)
@Builder
@Data
public class OpenEvvMember extends AltBaseModel {

    @Builder.Default
    @SerializedName("ClientID")
    String clientId = commons.generateUniqueNumber();

    @Builder.Default
    @SerializedName("ClientFirstName")
    String clientFirstName = commons.generateRandomStringOfFixLength(25);

    @Builder.Default
    @SerializedName("ClientMiddleInitial")
    String clientMiddleInitial = "T";

    @Builder.Default
    @SerializedName("ClientLastName")
    String clientLastName = commons.generateRandomStringOfFixLength(25);

    @Builder.Default
    @SerializedName("ClientSsn")
    String clientSsn = commons.generateRandomSsn();

    @Builder.Default
    @SerializedName("ClientMedicalRecordNumber")
    String clientMedicalRecordNumber = commons.generateRandomNumberOfFixLength(9);

    @SerializedName("ClientCustomID")
    String clientCustomId;

    @SerializedName("ClientOtherID")
    String clientOtherId;

    @SerializedName("ClientSuffix")
    String clientSuffix;

    @Builder.Default
    @SerializedName("Action")
    String action = "A";

    @SerializedName("CaseManager")
    String caseManager;

    @SerializedName("ClientCaseManagerEmail")
    String clientCaseManagerEmail;

    @SerializedName("ClientCoordinatorEmail")
    String clientCoordinatorEmail;

    @Builder.Default
    @SerializedName("ClientLanguage")
    String clientLanguage = "English (US)";

    @Builder.Default
    @SerializedName("ClientGender")
    String clientGender = "M";

    @Builder.Default
    @SerializedName("ClientBirthDate")
    String clientBirthDate = "1990-01-01";

    @Builder.Default
    @SerializedName("ClientMaritalStatus")
    String clientMaritalStatus = "S";

    @Builder.Default
    @SerializedName("ClientEmail")
    String clientEmail = commons.generateEmailAddress(commons.generateRandomStringOfFixLength(5));

    @SerializedName("ClientPriority")
    String clientPriority;

    @Builder.Default
    @SerializedName("ClientTimezone")
    String clientTimezone = "US/Eastern";

    @SerializedName("ClientEnrollmentDate")
    String clientEnrollmentDate;

    @Singular("clientEligibility")
    @SerializedName("ClientEligibility")
    List<ClientEligibility> clientEligibility;

    @Singular("clientContact")
    @SerializedName("ClientContact")
    List<ClientContact> clientContact;

    @Singular("clientAddress")
    @SerializedName("ClientAddress")
    List<ClientAddress> clientAddress;

    @Singular("clientPhone")
    @SerializedName("ClientPhone")
    List<ClientPhone> clientPhone;

    @Singular("clientWorkerXref")
    @SerializedName("ClientWorkerXref")
    List<ClientWorkerXref> clientWorkerXref;

    @Singular("clientDesignee")
    @SerializedName("ClientDesignee")
    List<ClientDesign> clientDesignee;

    public static class OpenEvvMemberBuilder {
        public OpenEvvMemberBuilder addMultiDesign(int count) {
            for (int i = 1; i <= count; i++) {
                this.clientDesignee(ClientDesign.builder().build());
            }
            return this;
        }

        public OpenEvvMemberBuilder addMultiAddress(int count) {
            for (int i = 1; i <= count; i++) {
                this.clientAddress(ClientAddress.builder().build());
            }
            return this;
        }

        public OpenEvvMemberBuilder addMultiContact(int count) {
            for (int i = 1; i <= count; i++) {
                this.clientContact(ClientContact.builder().build());
            }
            return this;
        }

        public OpenEvvMemberBuilder addMultiPhone(int count) {
            for (int i = 1; i <= count; i++) {
                this.clientPhone(ClientPhone.builder().build());
            }
            return this;
        }

        public OpenEvvMemberBuilder addClientId(String clientId) {
            this.clientId(clientId);
            return this;
        }
    }
}
