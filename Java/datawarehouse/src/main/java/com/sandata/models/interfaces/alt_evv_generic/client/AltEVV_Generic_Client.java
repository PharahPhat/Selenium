package com.sandata.models.interfaces.alt_evv_generic.client;

import com.google.gson.annotations.Expose;
import com.interop.common.Commons;
import com.sandata.common.Constant;
import com.interop.common.StateAccount;
import com.sandata.common.resource.ResourceGeneric;
import com.sandata.models.GenericModel;
import com.sandata.models.generic.client.*;
import org.apache.commons.lang.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AltEVV_Generic_Client extends GenericModel {

    public ProviderIdentification ProviderIdentification;
    public String ClientID;
    public String ClientFirstName;
    public String ClientMiddleInitial;
    public String ClientLastName;
    public String PayerName;
    public String ClientQualifier;
    public String ClientMedicaidID;
    public String ClientIdentifier;
    public String SequenceID;
    public String ClientCustomID;
    public String ClientOtherID;
    public String ErrorCode;
    public String ErrorMessage;
    public String ClientSSN;
    public String ClientTimezone;
    public Boolean MissingMedicaidID;
    public List<ClientAddress> ClientAddress = new ArrayList<ClientAddress>();
    public List<ClientPhone> ClientPhone = new ArrayList<ClientPhone>();
    public List<ClientResponsibleParty> ClientResponsibleParty = new ArrayList<>();
    public List<ClientPayerInformation> ClientPayerInformation = new ArrayList<>();
    //public List<AltEVVClientDesignee> ClientDesignees = new ArrayList<>();

    @Expose
    public transient List<AltEVV_Generic_Client> altevv_generic_clients;

    @Expose
    public transient List<String> clientIds;

    @Expose
    public transient List<String> fnames;

    @Override
    public boolean verifyFieldValue(Object obj) {
        return false;
    }

    @Override
    public boolean verifyFieldsNotNull() {
        return false;
    }

    public List<String> getClientID() {
        clientIds = new ArrayList<>();
        for (int i = 0; i <= altevv_generic_clients.size() - 1; i++) {
            clientIds.add(altevv_generic_clients.get(i).ClientID);
        }
        return clientIds;
    }

    public List<String> getFirstName() {
        fnames = new ArrayList<>();
        for (int i = 0; i <= altevv_generic_clients.size() - 1; i++) {
            fnames.add(altevv_generic_clients.get(i).ClientFirstName);
        }
        return fnames;
    }

    public void initData(int count) {
        if (count < 1) {
            return;
        }
        altevv_generic_clients = new ArrayList<>();
        for (int i = 1; i <= count ; i++ ) {
            AltEVV_Generic_Client altevv_generic_client = initAltEVVGenericClientData();
            altevv_generic_clients.add(altevv_generic_client);
        }
    }

    public AltEVV_Generic_Client initAltEVVGenericClientData(String fName) {
        super.initData();

        String clientId = RandomStringUtils.randomAlphanumeric(10);
        AltEVV_Generic_Client altEVV_generic_client = new AltEVV_Generic_Client();
        altEVV_generic_client.ProviderIdentification = CreateProviderIdentification();
        altEVV_generic_client.ClientID = clientId;
        altEVV_generic_client.ClientFirstName =  fName + RandomStringUtils.randomAlphabetic(11);
        altEVV_generic_client.ClientMiddleInitial = "T";
        altEVV_generic_client.ClientLastName = "AutoClientLastName"+RandomStringUtils.randomAlphabetic(12);
        altEVV_generic_client.PayerName = "PADHS";
        altEVV_generic_client.ClientQualifier = "ClientCustomID";
        altEVV_generic_client.ClientMedicaidID = commons.generateUniqueNumber();
        altEVV_generic_client.ClientIdentifier = commons.generateUniqueNumber();
        altEVV_generic_client.ClientCustomID = commons.generateUniqueNumber();
        altEVV_generic_client.ClientOtherID =  commons.generateUniqueNumber();

        altEVV_generic_client.SequenceID = commons.generateSequenceID();

        altEVV_generic_client.ClientSSN = clientDbService.generateNewClientSsn(account_id,clientId);
        altEVV_generic_client.ClientTimezone = "US/Eastern";
        altEVV_generic_client.MissingMedicaidID = false;
        altEVV_generic_client.ClientAddress = createClientAddresses(1);
        altEVV_generic_client.ClientPhone = createClientPhone(1);
        altEVV_generic_client.ClientResponsibleParty = CreateClientResponsibleParty(1);
        altEVV_generic_client.ClientPayerInformation =  CreateClientPayerInformation(1);
        altEVV_generic_client.ErrorCode = null;
        altEVV_generic_client.ErrorMessage = null;
        return altEVV_generic_client;
    }

    public AltEVV_Generic_Client initAltEVVGenericClientData() {
        super.initData();

        String clientId = RandomStringUtils.randomAlphanumeric(10);
//        String clientCustomId = commons.generateUniqueNumber();

        AltEVV_Generic_Client altEVV_generic_client = new AltEVV_Generic_Client();
        altEVV_generic_client.ProviderIdentification = CreateProviderIdentification();
        altEVV_generic_client.ClientID = clientId;
        altEVV_generic_client.ClientFirstName =  "AutoClientFirstName"+RandomStringUtils.randomAlphabetic(11);
        altEVV_generic_client.ClientMiddleInitial = "T";
        altEVV_generic_client.ClientLastName = "AutoClientLastName"+RandomStringUtils.randomAlphabetic(12);
        altEVV_generic_client.PayerName = "PADHS";
        altEVV_generic_client.ClientQualifier = "ClientCustomID";
        altEVV_generic_client.ClientMedicaidID = commons.generateUniqueNumber();
        altEVV_generic_client.ClientIdentifier = commons.generateUniqueNumber();
        altEVV_generic_client.ClientCustomID = commons.generateUniqueNumber();
        altEVV_generic_client.ClientOtherID =  commons.generateUniqueNumber();

        altEVV_generic_client.SequenceID = commons.generateSequenceID();

        altEVV_generic_client.ClientSSN = clientDbService.generateNewClientSsn(account_id,clientId);
        altEVV_generic_client.ClientTimezone = "US/Eastern";
        altEVV_generic_client.MissingMedicaidID = false;
        altEVV_generic_client.ClientAddress = createClientAddresses(1);
        altEVV_generic_client.ClientPhone = createClientPhone(1);
        altEVV_generic_client.ClientResponsibleParty = CreateClientResponsibleParty(1);
        altEVV_generic_client.ClientPayerInformation =  CreateClientPayerInformation(1);
        //altEVV_generic_client.AltEVVClientDesignee = createClientDesignees(1);
        altEVV_generic_client.ErrorCode = null;
        altEVV_generic_client.ErrorMessage = null;
        return altEVV_generic_client;
    }

    /*public static AltEVV_Generic_Client initModelByState(StateAccount state, String propertyName, String propertyType, String propertyValue){
        AltEVV_Generic_Client model = new AltEVV_Generic_Client();
        model = model.initAltEVVGenericClientData();
        String uniqueIdentifier = new SimpleDateFormat("MMddhhmmss").format(new Date());
        model.PayerName = state.defaultPayerID;
        model.ProviderIdentification.ProviderID = state.providerID;
        model.ProviderIdentification.ProviderQualifier = state.providerQualifier;
        model.ClientPayerInformation.get(0).ClientPayerID = state.defaultPayerID;
        model.ClientPayerInformation.get(0).PayerProgram = state.defaultPayerProgram;
        model.ClientPayerInformation.get(0).ProcedureCode = state.defaultProcedureCode;
        model.ClientMedicaidID = uniqueIdentifier;
        model.ClientIdentifier = uniqueIdentifier;
        model.PayerName = state.defaultPayerID;
        model.ClientPayerInformation.get(0).PayerID = state.defaultPayerID;
        if(propertyName != null && propertyName.equalsIgnoreCase("$.ClientFirstName")){
            model.ClientFirstName = propertyValue;
        }else if (propertyName != null && propertyName.equalsIgnoreCase("$.ClientLastName")){
            model.ClientLastName = propertyValue;
        }
        return model;
    }*/

    public static AltEVV_Generic_Client initModelByState(StateAccount state, String fName){
        AltEVV_Generic_Client model = new AltEVV_Generic_Client();
        model = model.initAltEVVGenericClientData(fName);

        model.PayerName = state.getDefaultPayerID();
        model.ProviderIdentification.ProviderID = state.getProviderID();
        model.ProviderIdentification.ProviderQualifier = state.getProviderQualifier();
        model.ClientQualifier = state.getClientQualifier();
        model.ClientPayerInformation.get(0).ClientPayerID = state.getDefaultPayerID();
        model.ClientPayerInformation.get(0).PayerProgram = state.getDefaultPayerProgram();
        model.ClientPayerInformation.get(0).ProcedureCode = state.getDefaultProcedureCode();
        model.PayerName = state.getDefaultPayerID();
        model.ClientPayerInformation.get(0).PayerID = state.getDefaultPayerID();

        return model;
    }

    /*
    @author: vu.vo. Generate default ALtEVVGeneric Client Model with account state information
     */
    public static AltEVV_Generic_Client initModelByState(StateAccount state){
        AltEVV_Generic_Client model = new AltEVV_Generic_Client();
        model = model.initAltEVVGenericClientData();

        model.PayerName = state.getDefaultPayerID();
        model.ProviderIdentification.ProviderID = state.getProviderID();
        model.ProviderIdentification.ProviderQualifier = state.getProviderQualifier();
        model.ClientQualifier = state.getClientQualifier();
        model.ClientPayerInformation.get(0).ClientPayerID = state.getDefaultPayerID();
        model.ClientPayerInformation.get(0).PayerProgram = state.getDefaultPayerProgram();
        model.ClientPayerInformation.get(0).ProcedureCode = state.getDefaultProcedureCode();
        model.PayerName = state.getDefaultPayerID();
        model.ClientPayerInformation.get(0).PayerID = state.getDefaultPayerID();

        String stateName = state.getStateName();
        if (!stateName.equalsIgnoreCase("Vermont")) {
            model.ClientMedicaidID = RandomStringUtils.randomNumeric(10);
            model.ClientIdentifier = RandomStringUtils.randomNumeric(10);
        }

        if (stateName.equalsIgnoreCase("RhodeIsland")) {
            Commons commons = new Commons();
            for (int i=0;i<model.ClientPayerInformation.size();i++) {
                ClientPayerInformation payerInformation = model.ClientPayerInformation.get(i);
                payerInformation.setEffectiveStartDate(commons.getDateString(0, "yyyy-MM-dd"));
                payerInformation.setEffectiveStartDate(commons.getDateString(5, "yyyy-MM-dd"));
            }
            model.ClientCustomID = commons.generateRandomNumberOfFixLength(10);
            model.ClientOtherID = commons.generateRandomNumberOfFixLength(10);
            model.SequenceID = commons.generateSequenceID();
        }

        return model;
    }

    public List<ClientPayerInformation> CreateClientPayerInformation(int count){
        List<ClientPayerInformation> clientPayerInformations = new ArrayList<>();
        for (int i = 0; i <= count - 1; i++) {
            ClientPayerInformation clientPayerInformation = new ClientPayerInformation();
            clientPayerInformation.PayerID = "PADHS";
            clientPayerInformation.PayerProgram = "TC95824";
            clientPayerInformation.ProcedureCode = "HHA";
            clientPayerInformation.ClientPayerID = RandomStringUtils.randomAlphabetic(20);
            clientPayerInformation.ClientEligibilityDateBegin = "2018-01-30";
            clientPayerInformation.ClientEligibilityDateEnd = "2020-12-31";
            clientPayerInformation.ClientStatus = "02";
            clientPayerInformations.add(clientPayerInformation);
        }
        return clientPayerInformations;
    }

    public ProviderIdentification CreateProviderIdentification()
    {
        ProviderIdentification info = new ProviderIdentification();
        info.ProviderID = provider_id;
        info.ProviderQualifier = "Other";

        return info;
    }

    public List<ClientResponsibleParty> CreateClientResponsibleParty(int count){
        List<ClientResponsibleParty> clientResponsibleParties = new ArrayList<>();
        for (int i = 0; i <= count - 1; i++) {
            ClientResponsibleParty clientResponsibleParty = new ClientResponsibleParty();
            clientResponsibleParty.ClientContactType = "Friend";
            clientResponsibleParty.ClientContactFirstName = "David";
            clientResponsibleParty.ClientContactLastName = "Rutgos";
            clientResponsibleParty.ClientContactPhoneType = "Mobile";
            clientResponsibleParty.ClientContactPhone = "3478788467";
            clientResponsibleParty.ClientContactEmailAddress = "altevv_client_ri@mailinator.com";
            clientResponsibleParty.ClientContactAddressLine1 = "2727 East 29th Street";
            clientResponsibleParty.ClientContactAddressLine2 = "Apt 8I";
            clientResponsibleParty.ClientContactCity = "Brooklyn";
            clientResponsibleParty.ClientContactState = Constant.CLIENTSTATE[new Random().nextInt(Constant.CLIENTSTATE.length)];
            clientResponsibleParty.ClientContactZip = "11229";
            clientResponsibleParty.ErrorCode = null;
            clientResponsibleParty.ErrorMessage = null;
            clientResponsibleParties.add(clientResponsibleParty);
        }
        return clientResponsibleParties;
    }

    public List<ClientPhone> createClientPhone(int count){
        List<ClientPhone> clientPhones = new ArrayList<ClientPhone>();
        for (int i = 0; i <= count - 1; i++) {
            ClientPhone clientPhone = new ClientPhone();
            clientPhone.ClientPhoneType = "Home";
            clientPhone.ClientPhone = "2125551212";
            clientPhone.ErrorCode = null;
            clientPhone.ErrorMessage = null;
            clientPhones.add(clientPhone);
        }
        return clientPhones;
    }

    public List<ClientAddress> createClientAddresses(int count) {

        List<ClientAddress> clientAddresses = new ArrayList<ClientAddress>();

        for (int i = 0; i <= count - 1; i++) {
            ClientAddress clientAddress = new ClientAddress();
            clientAddress.ClientAddressType = "Home";
            clientAddress.ClientAddressIsPrimary = "true";
            clientAddress.ClientAddressLine1 = "36 West 5th Street";
            clientAddress.ClientAddressLine2 = "10th Floor";
            clientAddress.ClientCounty = "Kings";
            clientAddress.ClientCity = "Manhattan";
            clientAddress.ClientState = Constant.CLIENTSTATE[new Random().nextInt(Constant.CLIENTSTATE.length)];
            clientAddress.ClientZip = "10017";
            clientAddress.ClientAddressLongitude = "-73.4228741";
            clientAddress.ClientAddressLatitude = "40.7431032";
            clientAddress.ErrorCode = null;
            clientAddress.ErrorMessage = null;
            clientAddresses.add(clientAddress);
        }

        return clientAddresses;
    }

/*    private List<AltEVVClientDesignee> createClientDesignees(int count){
        List<AltEVVClientDesignee> altEVVClientDesignees = new ArrayList<>();
        for (int i = 0; i <= count - 1; i++) {
            ClientDesignees altclientDesignee = new ClientDesignees();
            altclientDesignee.setClientDesigneeEmail(RandomStringUtils.randomAlphabetic(10) + "@mailinator.com");
            altclientDesignee.setClientDesigneeFirstName(RandomStringUtils.randomAlphabetic(10));
            altclientDesignee.setClientDesigneeLastName("TestDesignee" + RandomStringUtils.randomAlphabetic(10));
            altclientDesignee.setClientDesigneeStartDate("2019-03-02");
            altclientDesignee.setClientDesigneeEndDate("2019-12-31");
            altclientDesignee.setClientDesigneeStatus("02");
            altEVVClientDesignees.add(altclientDesignee);

        }
        return altEVVClientDesignees;
    }*/

    public boolean post() {
        request_url = getTestEnvironment().get("intake_endpoint") + ResourceGeneric.INTAKE_ALT_EVV_GENERIC_IMPORT_CLIENT;
        boolean result = post_alt_evv(altevv_generic_clients, request_url);
        return result;
    }

    public boolean getFinalStatus() {
        boolean result = getFinalStatusAlt(ResourceGeneric.INTAKE_CHECK_STATUS);
        return result;
    }

    public boolean validateResponseStatus(boolean isResponseSuccess, boolean finalStatus, boolean expected) {

        if (isResponseSuccess == expected
                && finalStatus == expected) {
            logInfo(String.format("Request to create Employee successfully"));
            logPass(String.format("Passed. Response status is '%s' matched with Expected Result is '%s'", isResponseSuccess, expected));
            return true;
        } else {
            logInfo(String.format("Failed to create Employee"));
        }
        return false;
    }

    public boolean CheckDataAsExpectedResultByFName(boolean expected)
    {
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        if(expected == false){
            if(isResponseSuccess == expected || finalStatus == expected){
                logPass("PASSED. Record(s) as expected result " + expected);
                return true;
            }
            else
            {
                logError("FAILED. Record(s) as expected result " + expected);
                return false;
            }

        }

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, expected);

        boolean result2 = validateClientRecordsExistInDatabaseByFname(expected);

        return (result1 && result2);
    }

    public boolean CheckDataAsExpectedResult(boolean expected)
    {
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        if(expected == false){
            if(isResponseSuccess == expected || finalStatus == expected){
                logPass("PASSED. Record(s) as expected result " + expected);
                return true;
            }
            else
            {
                logError("FAILED. Record(s) as expected result " + expected);
                return false;
            }

        }

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, expected);

        boolean result2 = validateClientRecordsExistInDatabase(expected);

        return (result1 && result2);
    }

    public boolean validateClientRecordsExistInDatabase(boolean expected) {
        List<String> clientIds = getClientID();

        boolean result = clientDbService.areClientsExistInDatabase(account_id, clientIds);

        if (result) {
            if (expected) {
                logPass("PASSED. Record(s) inserted into DB because expected is " + expected);
            } else {
                logPass("PASSED. Record(s) not inserted into DB because expected is " + expected);
            }
        } else {
            if (expected) {
                logError("FAILED. Record(s) not inserted into DB when expected is " + expected);
            } else {
                logError("FAILED. Record(s) inserted into DB when expected is " + expected);
            }
        }
        return result;
    }

    public boolean validateClientRecordsExistInDatabaseByFname(boolean expected) {
        List<String> firstnames = getFirstName();

        boolean result = clientDbService.areClientsExistInDatabaseByFName(account_id, firstnames);

        if (result) {
            if (expected) {
                logPass("PASSED. Record(s) inserted into DB because expected is " + expected);
            } else {
                logPass("PASSED. Record(s) not inserted into DB because expected is " + expected);
            }
        } else {
            if (expected) {
                logError("FAILED. Record(s) not inserted into DB when expected is " + expected);
            } else {
                logError("FAILED. Record(s) inserted into DB when expected is " + expected);
            }
        }
        return result;
    }

    public boolean ClientStatus(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        altevv_generic_clients.get(0).ClientPayerInformation.get(0).ClientStatus = value;

        logInfo(String.format("Request to create client with ClientStatus with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

    public boolean ClientID(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        altevv_generic_clients.get(0).ClientID = value;

        logInfo(String.format("Request to create provider with ClientID with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResultByFName(expected);
    }

    public boolean ClientFirstName(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        altevv_generic_clients.get(0).ClientFirstName = value;

        logInfo(String.format("Request to create provider with ClientFirstName with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

    public boolean ClientMiddleInitial(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        altevv_generic_clients.get(0).ClientMiddleInitial = value;

        logInfo(String.format("Request to create provider with ClientMiddleInitial with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

    public boolean ClientLastName(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        altevv_generic_clients.get(0).ClientLastName = value;

        logInfo(String.format("Request to create provider with ClientLastName with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

    public boolean PayerName(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        altevv_generic_clients.get(0).PayerName = value;

        logInfo(String.format("Request to create provider with PayerName with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

    public boolean ClientQualifier(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        altevv_generic_clients.get(0).ClientQualifier = value;

        logInfo(String.format("Request to create provider with ClientQualifier with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

    public boolean ClientMedicaidID(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        altevv_generic_clients.get(0).ClientMedicaidID = value;

        logInfo(String.format("Request to create provider with ClientMedicaidID with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

    public boolean ClientIdentifier(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        altevv_generic_clients.get(0).ClientIdentifier = value;

        logInfo(String.format("Request to create provider with ClientIdentifier with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

    public boolean SequenceID(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        altevv_generic_clients.get(0).SequenceID = value;

        logInfo(String.format("Request to create provider with SequenceID with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

    public boolean ClientCustomID(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        altevv_generic_clients.get(0).ClientCustomID = value;

        logInfo(String.format("Request to create provider with ClientCustomID with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

    public boolean ClientOtherID(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        altevv_generic_clients.get(0).ClientOtherID = value;

        logInfo(String.format("Request to create provider with ClientOtherID with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

    public boolean ClientSSN(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        altevv_generic_clients.get(0).ClientSSN = value;

        logInfo(String.format("Request to create provider with ClientSSN with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

    public boolean ClientAddressType(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        altevv_generic_clients.get(0).ClientAddress.get(0).ClientAddressType = value;

        logInfo(String.format("Request to create provider with ClientAddressType with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

    public boolean ClientAddressLine1(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        altevv_generic_clients.get(0).ClientAddress.get(0).ClientAddressLine1 = value;

        logInfo(String.format("Request to create provider with ClientAddressLine1 with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

    public boolean ClientAddressLine2(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        altevv_generic_clients.get(0).ClientAddress.get(0).ClientAddressLine2 = value;

        logInfo(String.format("Request to create provider with ClientAddressLine2 with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

    public boolean ClientAddressIsPrimary(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);

        altevv_generic_clients.get(0).ClientAddress.get(0).ClientAddressIsPrimary = value;

        logInfo(String.format("Request to create provider with ClientAddressLine2 with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

    public boolean ClientLongitude(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);

        altevv_generic_clients.get(0).ClientAddress.get(0).ClientAddressLongitude = value;

        logInfo(String.format("Request to create provider with ClientAddressLine2 with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

    public boolean ClientLatitude(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);

        altevv_generic_clients.get(0).ClientAddress.get(0).ClientAddressLatitude = value;

        logInfo(String.format("Request to create provider with ClientAddressLine2 with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

    public boolean ClientTimezone(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);

        altevv_generic_clients.get(0).ClientTimezone = value;

        logInfo(String.format("Request to create provider with ClientTimezone with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

    public boolean ClientCounty(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        altevv_generic_clients.get(0).ClientAddress.get(0).ClientCounty = value;

        logInfo(String.format("Request to create provider with ClientCounty with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

    public boolean ClientCity(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        altevv_generic_clients.get(0).ClientAddress.get(0).ClientCity = value;

        logInfo(String.format("Request to create provider with ClientCity with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

    public boolean ClientState(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        altevv_generic_clients.get(0).ClientAddress.get(0).ClientState = value;

        logInfo(String.format("Request to create provider with ClientState with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

    public boolean ClientZip(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        altevv_generic_clients.get(0).ClientAddress.get(0).ClientZip = value;

        logInfo(String.format("Request to create provider with ClientZip with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

    public boolean ClientPhoneType(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        altevv_generic_clients.get(0).ClientPhone.get(0).ClientPhoneType = value;

        logInfo(String.format("Request to create provider with ClientPhoneType with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

    public boolean ClientPhoneNumber(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        altevv_generic_clients.get(0).ClientPhone.get(0).ClientPhone = value;

        logInfo(String.format("Request to create provider with ClientPhoneNumber with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

    public boolean ClientContactType(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        altevv_generic_clients.get(0).ClientResponsibleParty.get(0).ClientContactType = value;

        logInfo(String.format("Request to create provider with ClientContactType with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

    public boolean ClientContactFirstName(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        altevv_generic_clients.get(0).ClientResponsibleParty.get(0).ClientContactFirstName = value;

        logInfo(String.format("Request to create provider with ClientContractFirstName with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

    public boolean ClientContactLastName(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        altevv_generic_clients.get(0).ClientResponsibleParty.get(0).ClientContactLastName = value;

        logInfo(String.format("Request to create provider with ClientContactLastName with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

    public boolean ClientContactPhone(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        altevv_generic_clients.get(0).ClientResponsibleParty.get(0).ClientContactPhone = value;

        logInfo(String.format("Request to create provider with ClientContactPhone with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

    public boolean ClientContactEmailAddress(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        altevv_generic_clients.get(0).ClientResponsibleParty.get(0).ClientContactEmailAddress = value;

        logInfo(String.format("Request to create provider with ClientContactEmailAddress with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

    public boolean ClientContactAddressLine1(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        altevv_generic_clients.get(0).ClientResponsibleParty.get(0).ClientContactAddressLine1 = value;

        logInfo(String.format("Request to create provider with ClientContactAddressLine1 with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

    public boolean ClientContactAddressLine2(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        altevv_generic_clients.get(0).ClientResponsibleParty.get(0).ClientContactAddressLine2 = value;

        logInfo(String.format("Request to create provider with ClientContactAddressLine2 with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

    public boolean ClientContactCity(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        altevv_generic_clients.get(0).ClientResponsibleParty.get(0).ClientContactCity = value;

        logInfo(String.format("Request to create provider with ClientContactCity with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

    public boolean ClientContactState(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        altevv_generic_clients.get(0).ClientResponsibleParty.get(0).ClientContactState = value;

        logInfo(String.format("Request to create provider with ClientContactState with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

    public boolean ClientContactZip(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        altevv_generic_clients.get(0).ClientResponsibleParty.get(0).ClientContactZip = value;

        logInfo(String.format("Request to create provider with ClientContactZip with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

    public boolean PayerID(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        altevv_generic_clients.get(0).ClientPayerInformation.get(0).PayerID = value;

        logInfo(String.format("Request to create provider with PayerID with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

    public boolean PayerProgram(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        altevv_generic_clients.get(0).ClientPayerInformation.get(0).PayerProgram = value;

        logInfo(String.format("Request to create provider with PayerProgram with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

    public boolean ProcedureCode(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        altevv_generic_clients.get(0).ClientPayerInformation.get(0).ProcedureCode = value;

        logInfo(String.format("Request to create provider with ProcedureCode with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

    public boolean ClientPayerID(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        altevv_generic_clients.get(0).ClientPayerInformation.get(0).ClientPayerID = value;

        logInfo(String.format("Request to create provider with ClientPayerID with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

    public boolean ClientEligibilityDateBegin(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        altevv_generic_clients.get(0).ClientPayerInformation.get(0).ClientEligibilityDateBegin = value;

        logInfo(String.format("Request to create provider with ClientEligibilityDateBegin with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

    public boolean ClientEligibilityDateEnd(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        altevv_generic_clients.get(0).ClientPayerInformation.get(0).ClientEligibilityDateEnd = value;

        logInfo(String.format("Request to create provider with ClientEligibilityDateBegin with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

}
