package com.sandata.models.interfaces.open_evv_connecticut.client;

import com.interop.common.StateAccount;
import com.sandata.models.GenericModel;
import com.sandata.models.generic.client.ProviderIdentification;
import com.sandata.models.interfaces.open_evv_generic.client.ClientAddress;
import com.sandata.models.interfaces.open_evv_generic.client.ClientDesignees_A;
import com.sandata.models.interfaces.open_evv_generic.client.ClientPayerInformation;
import com.sandata.models.interfaces.open_evv_generic.client.ClientPhone;
import org.apache.commons.lang.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;

public class OpenEVVClientModel extends GenericModel {
    public List<ClientAddress> ClientAddress = new ArrayList<>();
    public List<ClientPhone> ClientPhone = new ArrayList<>();
    public List<ClientDesignees_A> ClientDesignees = new ArrayList<>();
    public List<ClientPayerInformation> ClientPayerInformation = new ArrayList<>();
    private ProviderIdentification ProviderIdentification;
    private String Account;
    private String ClientID;
    private String ClientLastName;
    private String ClientFirstName;
    private String ClientMiddleName;
    private String ClientEmailAddress;
    private String ClientSSN;
    private String ClientMedicaidID;
    private String ClientQualifier;
    private String ClientIdentifier;
    private Boolean MissingMedicaidID;
    private String SequenceID;
    private String ClientCustomID;
    private String ClientOtherID;
    private String ErrorCode;
    private String ErrorMessage;
    private String PayerID;
    private String ClientTimeZone;
    private String ClientCity;
    private String ClientState;
    private String ClientZip;
    private String ClientAddressLine1;
    private String ClientAddressType;
    private String MemberEnrollmentDate;
    private String ContactPhoneNumber;
    private String MobileDevice;
    private String RecipientIDCustom1;
    private String RecipientIDCustom2;

    public static OpenEVVClientModel initModelByState(StateAccount state, String fName) {
        OpenEVVClientModel model = new OpenEVVClientModel();
        model = model.initOpenEVVClientData(state.getAccountID(), fName);

        model.setAccount(state.getAccountID());
        model.ProviderIdentification.ProviderID = state.getProviderID();
        model.ProviderIdentification.ProviderQualifier = state.getProviderQualifier();
        model.ClientQualifier = state.getClientQualifier();
        model.ClientPayerInformation.get(0).setPayerID(state.getDefaultPayerID());
        model.ClientPayerInformation.get(0).setPayerProgram(state.getDefaultPayerProgram());
        model.ClientPayerInformation.get(0).setProcedureCode(state.getDefaultProcedureCode());
        model.PayerID = state.getDefaultPayerID();
        model.ContactPhoneNumber = "2130951212";
        model.MobileDevice = "Y";

        String clientId;
        if (state.getStateName().equals("Vermont")) {
            clientId = "P" + RandomStringUtils.randomNumeric(6);

        } else {
            clientId = RandomStringUtils.randomNumeric(10);
        }
        model.setClientID(clientId);
        model.getClientAddress().get(0).setClientID(clientId);
        model.getClientPhone().get(0).setClientID(clientId);
        return model;
    }

    private static OpenEVVClientModel initModelByState(OpenEVVClientModel model, StateAccount state) {
        model = model.initOpenEVVClientData(state.getAccountID());
        model.setAccount(state.getAccountID());
        model.ProviderIdentification.ProviderID = state.getProviderID();
        model.ProviderIdentification.ProviderQualifier = state.getProviderQualifier();
        model.ClientQualifier = state.getClientQualifier();
        model.ClientPayerInformation.get(0).setPayerID(state.getDefaultPayerID());
        model.ClientPayerInformation.get(0).setPayerProgram(state.getDefaultPayerProgram());
        model.ClientPayerInformation.get(0).setProcedureCode(state.getDefaultProcedureCode());
        model.PayerID = state.getDefaultPayerID();

        String clientId = "";
        if (state.getStateName().equals("Vermont")) {
            clientId = "P" + RandomStringUtils.randomNumeric(6);
            model.setClientID(clientId);
        }

        if (state.getStateName().equalsIgnoreCase("Pennsylvania")) {
            clientId = RandomStringUtils.randomNumeric(9);
            model.setClientID(clientId);
        }
        model.getClientAddress().get(0).setClientID(clientId);
        model.getClientPhone().get(0).setClientID(clientId);
        return model;
    }

    public static OpenEVVClientModel initModelByState(StateAccount state) {
        OpenEVVClientModel model = new OpenEVVClientModel();
        model = initModelByState(model, state);
        return model;
    }

    public static OpenEVVClientModel initModelByState(StateAccount state, int countClientDesignees) {
        OpenEVVClientModel model = initModelByState(state);
        return model.initOpenEVVClientWithMultiClientDesignees(model, countClientDesignees);
    }

    public String getContactPhoneNumber() {
        return ContactPhoneNumber;
    }

    public void setContactPhoneNumber(String contactPhoneNumber) {
        ContactPhoneNumber = contactPhoneNumber;
    }

    public String getMobileDevice() {
        return MobileDevice;
    }

    public void setMobileDevice(String mobileDevice) {
        MobileDevice = mobileDevice;
    }

    /*public void initData(int count) {
        if (count < 1) {
            return;
        }
        openevv_clientModels = new ArrayList<>();
        for (int i = 1; i <= count ; i++ ) {
            OpenEVVClientModel openevv_clientModel = initOpenEVVClientData(state);
            openevv_clientModels.add(openevv_clientModel);
        }
    }*/

    public String getRecipientIDCustom1() {
        return RecipientIDCustom1;
    }

    public void setRecipientIDCustom1(String recipientIDCustom1) {
        RecipientIDCustom1 = recipientIDCustom1;
    }

    public String getRecipientIDCustom2() {
        return RecipientIDCustom2;
    }

    public void setRecipientIDCustom2(String recipientIDCustom2) {
        RecipientIDCustom2 = recipientIDCustom2;
    }

    private OpenEVVClientModel initOpenEVVClientWithMultiClientDesignees(OpenEVVClientModel model, int count) {
        model.setClientDesignees(createClientDesignees(count));
        return model;
    }

    private OpenEVVClientModel initOpenEVVClientData(String stateAccount, String fName) {
        OpenEVVClientModel openEVVClientModel = initOpenEVVClientData(stateAccount);
        openEVVClientModel.setClientFirstName(fName);
        openEVVClientModel.setRecipientIDCustom1(commons.generateRandomNumberOfFixLength(9));
        openEVVClientModel.setRecipientIDCustom2(commons.generateRandomNumberOfFixLength(9));
        return openEVVClientModel;
    }

    private OpenEVVClientModel initOpenEVVClientData(String stateAccount) {
        OpenEVVClientModel openEVVClientModel = new OpenEVVClientModel();
        openEVVClientModel.ProviderIdentification = CreateProviderIdentification();
        openEVVClientModel.setClientFirstName("AutoClientFirstName" + RandomStringUtils.randomAlphabetic(11));
        openEVVClientModel.setClientMiddleName("H");
        openEVVClientModel.setClientLastName("AutoClientLastName" + RandomStringUtils.randomAlphabetic(12));
        openEVVClientModel.setClientQualifier("");
        openEVVClientModel.setClientMedicaidID(commons.generateRandomNumberOfFixLength(9));
        openEVVClientModel.setClientEmailAddress("OpenEVV_" + commons.generateUniqueNumber() + "@mailinator.com");
        openEVVClientModel.setClientIdentifier(commons.generateUniqueNumber());
        openEVVClientModel.setClientCustomID(commons.generateUniqueNumber());
        openEVVClientModel.setClientOtherID(commons.generateUniqueNumber());
        openEVVClientModel.setSequenceID(commons.generateSequenceID());
        openEVVClientModel.setClientSSN(RandomStringUtils.randomNumeric(9));
        openEVVClientModel.setClientTimeZone("US/Eastern");
        openEVVClientModel.setMissingMedicaidID(false);
        openEVVClientModel.setClientState("NY");
        openEVVClientModel.setClientCity("CA");
        openEVVClientModel.setContactPhoneNumber("2342346327");
        openEVVClientModel.setMobileDevice("Y");
        openEVVClientModel.setClientZip("00011");
        //openEVVClientModel.setAddressType("Home");
        openEVVClientModel.setClientAddressLine1("ABC");
        openEVVClientModel.setMemberEnrollmentDate("2018-01-01");
        openEVVClientModel.setClientAddressType("Home");
        openEVVClientModel.setRecipientIDCustom1("P" + RandomStringUtils.randomNumeric(6));
        openEVVClientModel.setRecipientIDCustom2("E" + RandomStringUtils.randomNumeric(6));
        openEVVClientModel.ClientAddress = createClientAddresses(1, stateAccount);
        openEVVClientModel.setClientID(RandomStringUtils.randomAlphanumeric(10));
        openEVVClientModel.ClientPhone = createClientPhone(1, stateAccount);
        openEVVClientModel.ClientDesignees = createClientDesignees(1);
        openEVVClientModel.ClientPayerInformation = CreateClientPayerInformation(1);
        return openEVVClientModel;
    }
    /* These methods are already in AltEVV_Generic_Client Model*/

    private List<ClientPayerInformation> CreateClientPayerInformation(int count) {
        List<ClientPayerInformation> clientPayerInformations = new ArrayList<>();
        for (int i = 0; i <= count - 1; i++) {
            ClientPayerInformation clientPayerInformation = new ClientPayerInformation();
            clientPayerInformation.setClientPayerID(RandomStringUtils.randomAlphabetic(20));
            clientPayerInformation.setClientEligibilityDateBegin("2019-01-02");
            clientPayerInformation.setClientEligibilityDateEnd("2029-12-31");
            clientPayerInformation.setClientStatus("02");
            clientPayerInformation.setEffectiveStartDate("2019-01-02");
            clientPayerInformation.setEffectiveEndDate("2029-12-31");
            clientPayerInformations.add(clientPayerInformation);
        }
        return clientPayerInformations;
    }

    private ProviderIdentification CreateProviderIdentification() {
        ProviderIdentification info = new ProviderIdentification();
        info.ProviderID = provider_id;
        info.ProviderQualifier = "Other";

        return info;
    }

    public List<ClientDesignees_A> createClientDesignees(int count) {
        List<ClientDesignees_A> clientDesignees = new ArrayList<>();
        for (int i = 0; i <= count - 1; i++) {
            ClientDesignees_A clientDesignee = new ClientDesignees_A();
            clientDesignee.setClientDesigneeEmail(RandomStringUtils.randomAlphanumeric(5) + "_" +
                    commons.generateUniqueNumber() + "@mailinator.com");
            clientDesignee.setClientDesigneeFirstName("ClientD" + (RandomStringUtils.randomAlphabetic(10)));
            clientDesignee.setClientDesigneeLastName("TestDesignee" + RandomStringUtils.randomAlphabetic(10));
            clientDesignee.setClientDesigneeStartDate("2019-01-01");
            clientDesignee.setClientDesigneeEndDate(commons.getDateString(0, "yyyy-MM-dd"));
            clientDesignee.setClientDesigneeStatus("02");
            clientDesignees.add(clientDesignee);

        }
        return clientDesignees;
    }

    private List<ClientPhone> createClientPhone(int count, String account) {
        List<ClientPhone> clientPhones = new ArrayList<>();
        for (int i = 0; i <= count - 1; i++) {
            ClientPhone clientPhone = new ClientPhone();
            clientPhone.setAccount(account);
            clientPhone.setClientPhoneType("Home");
            clientPhone.setClientPhone(RandomStringUtils.randomNumeric(10));
            clientPhones.add(clientPhone);
        }
        return clientPhones;
    }

    private List<ClientAddress> createClientAddresses(int count, String account) {

        List<ClientAddress> clientAddresses = new ArrayList<>();

        for (int i = 0; i <= count - 1; i++) {
            ClientAddress clientAddress = new ClientAddress();
            clientAddress.setAccount(account);
            clientAddress.setAddressType("Home");
            clientAddress.setClientAddressLine1("36 West 5th Street");
            clientAddress.setClientAddressLine2("10th Floor");
            clientAddress.setClientCounty("Kings");
            clientAddress.setClientCity("Manhattan");
            clientAddress.setClientState("NY");
            clientAddress.setClientZip("10017");
            clientAddresses.add(clientAddress);
        }

        return clientAddresses;
    }

    /* ------------------------------*/

    public String getAccount() {
        return Account;
    }

    public void setAccount(String account) {
        Account = account;
    }

    public String getClientID() {
        return ClientID;
    }

    public void setClientID(String clientID) {
        ClientID = clientID;
    }

    public String getClientLastName() {
        return ClientLastName;
    }

    public void setClientLastName(String clientLastName) {
        ClientLastName = clientLastName;
    }

    public String getClientFirstName() {
        return ClientFirstName;
    }

    public void setClientFirstName(String clientFirstName) {
        ClientFirstName = clientFirstName;
    }

    public String getClientMiddleName() {
        return ClientMiddleName;
    }

    public void setClientMiddleName(String clientMiddleName) {
        ClientMiddleName = clientMiddleName;
    }

    public String getClientQualifier() {
        return ClientQualifier;
    }

    public void setClientQualifier(String clientQualifier) {
        ClientQualifier = clientQualifier;
    }

    public String getClientSSN() {
        return ClientSSN;
    }

    public void setClientSSN(String clientSSN) {
        ClientSSN = clientSSN;
    }

    public String getClientMedicaidID() {
        return ClientMedicaidID;
    }

    public void setClientMedicaidID(String clientMedicaidID) {
        ClientMedicaidID = clientMedicaidID;
    }

    public String getClientIdentifier() {
        return ClientIdentifier;
    }

    public void setClientIdentifier(String clientIdentifier) {
        ClientIdentifier = clientIdentifier;
    }

    public String getClientCustomID() {
        return ClientCustomID;
    }

    public void setClientCustomID(String clientCustomID) {
        ClientCustomID = clientCustomID;
    }

    public String getSequenceID() {
        return SequenceID;
    }

    public void setSequenceID(String sequenceID) {
        SequenceID = sequenceID;
    }

    public Boolean getMissingMedicaidID() {
        return MissingMedicaidID;
    }

    public void setMissingMedicaidID(Boolean missingMedicaidID) {
        MissingMedicaidID = missingMedicaidID;
    }


    public String getClientOtherID() {
        return ClientOtherID;
    }

    public void setClientOtherID(String clientOtherID) {
        ClientOtherID = clientOtherID;
    }

    public String getClientTimeZone() {
        return ClientTimeZone;
    }

    public void setClientTimeZone(String clientTimeZone) {
        ClientTimeZone = clientTimeZone;
    }

    public String getPayerID() {
        return PayerID;
    }

    public void setPayerID(String payerID) {
        PayerID = payerID;
    }

    public List<com.sandata.models.interfaces.open_evv_generic.client.ClientAddress> getClientAddress() {
        return ClientAddress;
    }

    public void setClientAddress(List<com.sandata.models.interfaces.open_evv_generic.client.ClientAddress> clientAddress) {
        ClientAddress = clientAddress;
    }

    public List<com.sandata.models.interfaces.open_evv_generic.client.ClientPhone> getClientPhone() {
        return ClientPhone;
    }

    public void setClientPhone(List<com.sandata.models.interfaces.open_evv_generic.client.ClientPhone> clientPhone) {
        ClientPhone = clientPhone;
    }

    public String getClientCity() {
        return ClientCity;
    }

    public void setClientCity(String clientCity) {
        ClientCity = clientCity;
    }

    public String getClientState() {
        return ClientState;
    }

    public void setClientState(String clientState) {
        ClientState = clientState;
    }

    public String getClientZip() {
        return ClientZip;
    }

    public void setClientZip(String clientZip) {
        ClientZip = clientZip;
    }

    public String getClientAddressLine1() {
        return ClientAddressLine1;
    }

    public void setClientAddressLine1(String clientAddressLine1) {
        ClientAddressLine1 = clientAddressLine1;
    }

    public String getClientAddressType() {
        return ClientAddressType;
    }

    public void setClientAddressType(String clientAddressType) {
        ClientAddressType = clientAddressType;
    }


    public String getClientEmailAddress() {
        return ClientEmailAddress;
    }

    public void setClientEmailAddress(String clientEmailAddress) {
        ClientEmailAddress = clientEmailAddress;
    }

    public String getMemberEnrollmentDate() {
        return MemberEnrollmentDate;
    }

    public void setMemberEnrollmentDate(String memberEnrollmentDate) {
        MemberEnrollmentDate = memberEnrollmentDate;
    }

    public List<com.sandata.models.interfaces.open_evv_generic.client.ClientDesignees_A> getClientDesignees() {
        return ClientDesignees;
    }

    public void setClientDesignees(List<com.sandata.models.interfaces.open_evv_generic.client.ClientDesignees_A> clientDesignees) {
        ClientDesignees = clientDesignees;
    }

    public List<com.sandata.models.interfaces.open_evv_generic.client.ClientPayerInformation> getClientPayerInformation() {
        return ClientPayerInformation;
    }

    public void setClientPayerInformation(List<com.sandata.models.interfaces.open_evv_generic.client.ClientPayerInformation> clientPayerInformation) {
        ClientPayerInformation = clientPayerInformation;
    }

    public String getErrorCode() {
        return ErrorCode;
    }

    public void setErrorCode(String errorCode) {
        ErrorCode = errorCode;
    }

    public String getErrorMessage() {
        return ErrorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        ErrorMessage = errorMessage;
    }

    @Override
    public boolean verifyFieldValue(Object obj) {
        return false;
    }

    @Override
    public boolean verifyFieldsNotNull() {
        return false;
    }

    @Override
    public String toString() {
        return "OpenEVVClientModel{" +
                "ProviderIdentification=" + ProviderIdentification +
                ", Account='" + Account + '\'' +
                ", ClientID='" + ClientID + '\'' +
                ", ClientLastName='" + ClientLastName + '\'' +
                ", ClientFirstName='" + ClientFirstName + '\'' +
                ", ClientMiddleName='" + ClientMiddleName + '\'' +
                ", ClientEmailAddress='" + ClientEmailAddress + '\'' +
                ", ClientSSN='" + ClientSSN + '\'' +
                ", ClientMedicaidID='" + ClientMedicaidID + '\'' +
                ", ClientQualifier='" + ClientQualifier + '\'' +
                ", ClientIdentifier='" + ClientIdentifier + '\'' +
                ", MissingMedicaidID=" + MissingMedicaidID +
                ", SequenceID='" + SequenceID + '\'' +
                ", ClientCustomID='" + ClientCustomID + '\'' +
                ", ClientOtherID='" + ClientOtherID + '\'' +
                ", ErrorCode='" + ErrorCode + '\'' +
                ", ErrorMessage='" + ErrorMessage + '\'' +
                ", PayerID='" + PayerID + '\'' +
                ", ClientTimeZone='" + ClientTimeZone + '\'' +
                ", ClientCity='" + ClientCity + '\'' +
                ", ClientState='" + ClientState + '\'' +
                ", ClientZip='" + ClientZip + '\'' +
                ", ClientAddressLine1='" + ClientAddressLine1 + '\'' +
                ", ClientAddressType='" + ClientAddressType + '\'' +
                ", MemberEnrollmentDate='" + MemberEnrollmentDate + '\'' +
                ", ContactPhoneNumber='" + ContactPhoneNumber + '\'' +
                ", MobileDevice='" + MobileDevice + '\'' +
                ", RecipientIDCustom1='" + RecipientIDCustom1 + '\'' +
                ", RecipientIDCustom2='" + RecipientIDCustom2 + '\'' +
                ", ClientAddress=" + ClientAddress +
                ", ClientPhone=" + ClientPhone +
                ", ClientDesignees=" + ClientDesignees +
                ", ClientPayerInformation=" + ClientPayerInformation +
                '}';
    }
}