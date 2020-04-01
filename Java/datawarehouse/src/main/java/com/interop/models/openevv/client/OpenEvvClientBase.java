package com.interop.models.openevv.client;

import com.google.gson.annotations.SerializedName;
import com.interop.common.StateAccount;
import com.interop.models.altevv.AltBaseModel;
import com.sandata.common.Constant;
import com.sandata.common.Timezone;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang.RandomStringUtils;

import java.util.Random;

@EqualsAndHashCode(callSuper = true)
@Data
public class OpenEvvClientBase extends AltBaseModel {
    @SerializedName("Account")
    public String account = StateAccount.loadStateAccount().getAccountID();
    @SerializedName("ClientID")
    public String clientID = commons.generateRandomNumberOfFixLength(10) ;
    @SerializedName("ClientLastName")
    public String clientLastName = "OpenClientLName" + RandomStringUtils.randomAlphabetic(10);
    @SerializedName("ClientFirstName")
    public String clientFirstName = "OpenClientFName" + RandomStringUtils.randomAlphabetic(10);
    @SerializedName("ClientMiddleName")
    public String clientMiddleName = RandomStringUtils.randomAlphabetic(1);
    @SerializedName("ClientEmailAddress")
    public String clientEmailAddress = "OpenEVV_" + commons.generateUniqueNumber() + "@mailinator.com";
    @SerializedName("ClientSSN")
    public String clientSSN = RandomStringUtils.randomNumeric(9);
    @SerializedName("ClientMedicaidID")
    public String clientMedicaidID = "9" + RandomStringUtils.randomNumeric(8);
    @SerializedName("ClientQualifier")
    public String clientQualifier = StateAccount.loadStateAccount().getClientQualifier();
    @SerializedName("ClientIdentifier")
    public String clientIdentifier = commons.generateUniqueNumber();
    @SerializedName("MissingMedicaidID")
    public String missingMedicaidID = "false";
    @SerializedName("SequenceID")
    public String sequenceID = commons.generateSequenceID();
    @SerializedName("ClientCustomID")
    public String clientCustomID = commons.generateUniqueNumber();
    @SerializedName("ClientOtherID")
    public String clientOtherID = commons.generateUniqueNumber();
    @SerializedName("PayerID")
    public String payerID = StateAccount.loadStateAccount().getDefaultPayerID();
    @SerializedName("ClientTimeZone")
    public String clientTimeZone = Timezone.EASTERN.toString();
    @SerializedName("ClientCity")
    public String clientCity = "CA";
    @SerializedName("ClientState")
    public String clientState = Constant.CLIENTSTATE[new Random().nextInt(Constant.CLIENTSTATE.length)];
    @SerializedName("ClientZip")
    public String clientZip = "00011";
    @SerializedName("ClientAddressLine1")
    public String clientAddressLine1 = "KMS Address";
    @SerializedName("ClientAddressType")
    public String clientAddressType = "Home";
    @SerializedName("MemberEnrollmentDate")
    public String memberEnrollmentDate = "2018-01-01";
    @SerializedName("ContactPhoneNumber")
    public String contactPhoneNumber = "2130951212";
    @SerializedName("MobileDevice")
    public String mobileDevice = "Y";
    @SerializedName("RecipientIDCustom1")
    public String recipientIDCustom1;
    @SerializedName("RecipientIDCustom2")
    public String recipientIDCustom2;
    @SerializedName("CaseManager")
    private String caseManager;
    @SerializedName("Coordinator")
    private String coordinator;
    @SerializedName("ClientBirthDate")
    private String clientBirthDate;
    @SerializedName("ClientLanguage")
    private String clientLanguage;
    @SerializedName("ClientGender")
    
    private String clientGender = "O";
    @SerializedName("ClientAddressLine2")
    
    private String clientAddressLine2 = "KMS Address Line 2";
    @SerializedName("ClientSuffix")
    public String clientSuffix;
    @SerializedName("ClientPrimaryDiagnosisCode")
    public String clientPrimaryDiagnosisCode;
    
    @SerializedName("ContactFirstName")
    String contactFirstName = commons.generateRandomStringOfFixLength(10);

    
    @SerializedName("ContactLastName")
    String contactLastName = commons.generateRandomStringOfFixLength(10);

    
    @SerializedName("ContactPhoneType")
    String contactPhoneType = "Home";

    @SerializedName("ContactRelationshipToClient")
    String contactRelationshipToClient;

    
    @SerializedName("ContactEmail")
    String contactEmail = commons.generateEmailAddress(commons.generateRandomStringOfFixLength(5));

    @SerializedName("ContactAddressLine1")
    String contactAddressLine1;

    @SerializedName("ContactAddressLine2")
    String contactAddressLine2;

    
    @SerializedName("ContactCity")
    String contactCity = "New York";

    
    @SerializedName("ContactState")
    String contactState = "NY";

    
    @SerializedName("ContactZip")
    String contactZip = "10012";
 
    @SerializedName("ProviderAssentContPlan")
    
    private String providerAssentContPlan = "No";
}
