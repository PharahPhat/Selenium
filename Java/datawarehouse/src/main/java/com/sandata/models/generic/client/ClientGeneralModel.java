package com.sandata.models.generic.client;

import com.sandata.core.annotation.Column;
import com.sandata.core.annotation.CsvHeader;
import com.sandata.models.molina.client.ClientGenericModel;
import com.sandata.utilities.CompareUtil;
import org.testng.Assert;

import java.util.List;
import java.util.Objects;

public class ClientGeneralModel extends ClientGenericModel {
    @CsvHeader("ProviderID")
    @Column(value = "ProviderID", index = 0)
    private String providerID;

    @CsvHeader("ClientID")
    @Column(value = "ClientID", index = 1)
    private String clientID;

    @CsvHeader("ClientFirstName")
    @Column(value = "ClientFirstName", index = 2)
    private String clientFirstName;

    @CsvHeader("ClientMiddleInitial")
    @Column(value = "ClientMiddleInitial", index = 3)
    private String clientMiddleName;

    @CsvHeader("ClientLastName")
    @Column(value = "ClientLastName", index = 4)
    private String clientLastName;

    @CsvHeader("MissingMedicaidID")
    @Column(value = "MissingMedicaidID", index = 5)
    private String missingMedicaidID;

    @CsvHeader("ClientSSN")
    @Column(value = "ClientSSN", index = 6)
    private String clientSSN;

    @CsvHeader("ClientMedicalRecordNum")
    @Column(value = "ClientMedicalRecordNum", index = 7)
    private String clientMedicalRecordNum;

    @CsvHeader("ClientMedicaidID")
    @Column(value = "ClientMedicaidID", index = 8)
    private String clientMedicaidID;

    @CsvHeader("ClientCustomID")
    @Column(value = "ClientCustomID", index = 9)
    private String clientCustomID;

    @CsvHeader("ClientOtherID")
    @Column(value = "ClientOtherID", index = 10)
    private String clientOtherID;

    @CsvHeader("ClientSuffix")
    @Column(value = "ClientSuffix", index = 11)
    private String clientSuffix;

    @CsvHeader("Coordinator")
    @Column(value = "Coordinator", index = 12)
    private String coordinator;

    @CsvHeader("ClientCoordinatorEmail")
    @Column(value = "ClientCoordinatorEmail", index = 13)
    private String clientCoordinatorEmail;

    @CsvHeader("ClientLanguage")
    @Column(value = "ClientLanguage", index = 14)
    private String clientLanguage;

    @CsvHeader("ClientGender")
    @Column(value = "ClientGender", index = 15)
    private String clientGender;

    @CsvHeader("ClientMaritalStatus")
    @Column(value = "ClientMaritalStatus", index = 16)
    private String clientMaritalStatus;

    @CsvHeader("ClientBirthDate")
    @Column(value = "ClientBirthDate", index = 17)
    private String clientBirthDate;

    @CsvHeader("ClientEmail")
    @Column(value = "ClientEmail", index = 18)
    private String clientEmail;

    @CsvHeader("ClientPriority")
    @Column(value = "ClientPriority", index = 19)
    private String clientPriority;

    @CsvHeader("ClientTimeZone")
    @Column(value = "ClientTimeZone", index = 20)
    private String clientTimeZone;

    @CsvHeader("ClientContactType")
    @Column(value = "ClientContactType", index = 21)
    private String clientContactType;

    @CsvHeader("ClientContactFirstName")
    @Column(value = "ClientContactFirstName", index = 22)
    private String clientContactFirstName;

    @CsvHeader("ClientContactLastName")
    @Column(value = "ClientContactLastName", index = 23)
    private String clientContactLastName;

    @CsvHeader("ClientContactPhoneType")
    @Column(value = "ClientContactPhoneType", index = 24)
    private String clientContactPhoneType;

    @CsvHeader("ClientContactPhone")
    @Column(value = "ClientContactPhone", index = 25)
    private String clientContactPhone;

    @CsvHeader("ClientContactEmailAddress")
    @Column(value = "ClientContactEmailAddress", index = 26)
    private String clientContactEmailAddress;

    @CsvHeader("ClientContactAddressLine1")
    @Column(value = "ClientContactAddressLine1", index = 27)
    private String clientContactAddressLine1;

    @CsvHeader("ClientContactAddressLine2")
    @Column(value = "ClientContactAddressLine2", index = 28)
    private String clientContactAddressLine2;

    @CsvHeader("ClientContactCity")
    @Column(value = "ClientContactCity", index = 29)
    private String clientContactCity;

    @CsvHeader("ClientContactState")
    @Column(value = "ClientContactState", index = 30)
    private String clientContactState;

    @CsvHeader("ClientContactZip")
    @Column(value = "ClientContactZip", index = 31)
    private String clientContactZip;

    public String getProviderID() {
        return providerID;
    }

    public void setProviderID(String providerID) {
        this.providerID = providerID;
    }

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public String getClientFirstName() {
        return clientFirstName;
    }

    public void setClientFirstName(String clientFirstName) {
        this.clientFirstName = clientFirstName;
    }

    public String getClientMiddleName() {
        return clientMiddleName;
    }

    public void setClientMiddleName(String clientMiddleName) {
        this.clientMiddleName = clientMiddleName;
    }

    public String getClientLastName() {
        return clientLastName;
    }

    public void setClientLastName(String clientLastName) {
        this.clientLastName = clientLastName;
    }

    public String getMissingMedicaidID() {
        return missingMedicaidID;
    }

    public void setMissingMedicaidID(String missingMedicaidID) {
        this.missingMedicaidID = missingMedicaidID;
    }

    public String getClientSSN() {
        return clientSSN;
    }

    public void setClientSSN(String clientSSN) {
        this.clientSSN = clientSSN;
    }

    public String getClientMedicalRecordNum() {
        return clientMedicalRecordNum;
    }

    public void setClientMedicalRecordNum(String clientMedicalRecordNum) {
        this.clientMedicalRecordNum = clientMedicalRecordNum;
    }

    public String getClientMedicaidID() {
        return clientMedicaidID;
    }

    public void setClientMedicaidID(String clientMedicaidID) {
        this.clientMedicaidID = clientMedicaidID;
    }

    public String getClientCustomID() {
        return clientCustomID;
    }

    public void setClientCustomID(String clientCustomID) {
        this.clientCustomID = clientCustomID;
    }

    public String getClientOtherID() {
        return clientOtherID;
    }

    public void setClientOtherID(String clientOtherID) {
        this.clientOtherID = clientOtherID;
    }

    public String getClientSuffix() {
        return clientSuffix;
    }

    public void setClientSuffix(String clientSuffix) {
        this.clientSuffix = clientSuffix;
    }

    public String getCoordinator() {
        return coordinator;
    }

    public void setCoordinator(String coordinator) {
        this.coordinator = coordinator;
    }

    public String getClientCoordinatorEmail() {
        return clientCoordinatorEmail;
    }

    public void setClientCoordinatorEmail(String clientCoordinatorEmail) {
        this.clientCoordinatorEmail = clientCoordinatorEmail;
    }

    public String getClientLanguage() {
        return clientLanguage;
    }

    public void setClientLanguage(String clientLanguage) {
        this.clientLanguage = clientLanguage;
    }

    public String getClientGender() {
        return clientGender;
    }

    public void setClientGender(String clientGender) {
        this.clientGender = clientGender;
    }

    public String getClientMaritalStatus() {
        return clientMaritalStatus;
    }

    public void setClientMaritalStatus(String clientMaritalStatus) {
        this.clientMaritalStatus = clientMaritalStatus;
    }

    public String getClientBirthDate() {
        return clientBirthDate;
    }

    public void setClientBirthDate(String clientBirthDate) {
        this.clientBirthDate = clientBirthDate;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public String getClientPriority() {
        return clientPriority;
    }

    public void setClientPriority(String clientPriority) {
        this.clientPriority = clientPriority;
    }

    public String getClientTimeZone() {
        return clientTimeZone;
    }

    public void setClientTimeZone(String clientTimeZone) {
        this.clientTimeZone = clientTimeZone;
    }

    public String getClientContactType() {
        return clientContactType;
    }

    public void setClientContactType(String clientContactType) {
        this.clientContactType = clientContactType;
    }

    public String getClientContactFirstName() {
        return clientContactFirstName;
    }

    public void setClientContactFirstName(String clientContactFirstName) {
        this.clientContactFirstName = clientContactFirstName;
    }

    public String getClientContactLastName() {
        return clientContactLastName;
    }

    public void setClientContactLastName(String clientContactLastName) {
        this.clientContactLastName = clientContactLastName;
    }

    public String getClientContactPhoneType() {
        return clientContactPhoneType;
    }

    public void setClientContactPhoneType(String clientContactPhoneType) {
        this.clientContactPhoneType = clientContactPhoneType;
    }

    public String getClientContactPhone() {
        return clientContactPhone;
    }

    public void setClientContactPhone(String clientContactPhone) {
        this.clientContactPhone = clientContactPhone;
    }

    public String getClientContactEmailAddress() {
        return clientContactEmailAddress;
    }

    public void setClientContactEmailAddress(String clientContactEmailAddress) {
        this.clientContactEmailAddress = clientContactEmailAddress;
    }

    public String getClientContactAddressLine1() {
        return clientContactAddressLine1;
    }

    public void setClientContactAddressLine1(String clientContactAddressLine1) {
        this.clientContactAddressLine1 = clientContactAddressLine1;
    }

    public String getClientContactAddressLine2() {
        return clientContactAddressLine2;
    }

    public void setClientContactAddressLine2(String clientContactAddressLine2) {
        this.clientContactAddressLine2 = clientContactAddressLine2;
    }

    public String getClientContactCity() {
        return clientContactCity;
    }

    public void setClientContactCity(String clientContactCity) {
        this.clientContactCity = clientContactCity;
    }

    public String getClientContactState() {
        return clientContactState;
    }

    public void setClientContactState(String clientContactState) {
        this.clientContactState = clientContactState;
    }

    public String getClientContactZip() {
        return clientContactZip;
    }

    public void setClientContactZip(String clientContactZip) {
        this.clientContactZip = clientContactZip;
    }

    @Override
    public String toString() {
        String toString = "ClientGeneralModel{" +
//                "payerID='" + payerID + '\'' +
                "providerID='" + providerID + '\'' +
                "clientID='" + clientID + '\'' +
//                "clientPayerID='" + clientPayerID + '\'' +
                "clientFirstName='" + clientFirstName + '\'' +
                "clientMiddleName='" + clientMiddleName + '\'' +
                "clientLastName='" + clientLastName + '\'' +
//                "missingMedicaidID='" + missingMedicaidID + '\'' +
                "clientSSN='" + clientSSN + '\'' +
                "clientMedicalRecordNum='" + clientMedicalRecordNum + '\'' +
                "clientMedicaidID='" + clientMedicaidID + '\'' +
                "clientCustomID='" + clientCustomID + '\'' +
                "clientOtherID='" + clientOtherID + '\'' +
                "clientSuffix='" + clientSuffix + '\'' +
//                "caseManager='" + caseManager + '\'' +
                "coordinator='" + coordinator + '\'' +
                "clientCoordinatorEmail='" + clientCoordinatorEmail + '\'' +
                "clientLanguage='" + clientLanguage + '\'' +
                "clientGender='" + clientGender + '\'' +
                "clientMaritalStatus='" + clientMaritalStatus + '\'' +
                "clientBirthDate='" + clientBirthDate + '\'' +
                "clientEmail='" + clientEmail + '\'' +
                "clientPriority='" + clientPriority + '\'' +
                "clientTimeZone='" + clientTimeZone + '\'' +
//                "clientDesigneeFirstName='" + clientDesigneeFirstName + '\'' +
//                "clientDesigneeLastName='" + clientDesigneeLastName + '\'' +
//                "clientDesigneeEmail='" + clientDesigneeEmail + '\'' +
//                "clientDesigneeStatus='" + clientDesigneeStatus + '\'' +
//                "clientDesigneeStartDate='" + clientDesigneeStartDate + '\'' +
//                "clientDesigneeEndDate='" + clientDesigneeEndDate + '\'' +
                "clientContactType='" + clientContactType + '\'' +
                "clientContactFirstName='" + clientContactFirstName + '\'' +
                "clientContactLastName='" + clientContactLastName + '\'' +
                "clientContactPhoneType='" + clientContactPhoneType + '\'' +
                "clientContactPhone='" + clientContactPhone + '\'' +
                "clientContactEmailAddress='" + clientContactEmailAddress + '\'' +
                "clientContactAddressLine1='" + clientContactAddressLine1 + '\'' +
                "clientContactAddressLine2='" + clientContactAddressLine2 + '\'' +
                "clientContactCity='" + clientContactCity + '\'' +
                "clientContactState='" + clientContactState + '\'' +
                "clientContactZip='" + clientContactZip + '\'' +
                '}';
        return toString.replace("null", "");
    }

    public boolean verifyFormatField(String fieldValue, String regex) {
        if(!fieldValue.equals(null) && !fieldValue.equals(""))
            return fieldValue.matches(regex);
        return true;
    }

    public boolean verifyFormatFields() {
        if(!this.verifyFormatField(this.clientFirstName, "^\\w{0,30}$"))return false;
        if(!this.verifyFormatField(this.clientMiddleName, "^\\w{0,1}$"))return false;
        if(!this.verifyFormatField(this.clientLastName, "^\\w{0,30}$"))return false;
        if(this.missingMedicaidID != null)
            if(!this.verifyFormatField(this.missingMedicaidID, "^S|^[True|False]$"))return false;
        if(!this.verifyFormatField(this.clientSSN, "^\\w{0,9}"))return false;
        if(!this.verifyFormatField(this.clientMedicalRecordNum, "^\\w{0,12}$"))return false;
        if(!this.verifyFormatField(this.clientMedicaidID, "^.{0,64}$"))return false;
        if(!this.verifyFormatField(this.clientCustomID, "^\\w{0,24}$"))return false;
        if(!this.verifyFormatField(this.coordinator, "^\\w{0,25}$"))return false;
        if(!this.verifyFormatField(this.clientCoordinatorEmail, "^\\w{0,64}$"))return false;
        if(!this.verifyFormatField(this.clientLanguage, "^\\w{0,32}$"))return false;
        if(!this.verifyFormatField(this.clientGender, "^[O|M|F]$|^$"))return false;
        if(!this.verifyFormatField(this.clientMaritalStatus, "^[M|S|W|O]$|^$"))return false;
        if(!this.verifyFormatField(this.clientBirthDate, "^\\w{0,10}$"))return false;
        if(!this.verifyFormatField(this.clientEmail, "^.{0,64}$"))return false;
        if(!this.verifyFormatField(this.clientPriority, "^\\w{0,2}$"))return false;
        if(!this.verifyFormatField(this.clientTimeZone, "^.{0,64}$"))return false;
        if(!this.verifyFormatField(this.clientContactType, "^\\w{0,12}$"))return false;
        if(!this.verifyFormatField(this.clientContactFirstName, "^\\w{0,30}$"))return false;
        if(!this.verifyFormatField(this.clientContactLastName, "^\\w{0,64}$"))return false;
        if(!this.verifyFormatField(this.clientContactPhoneType, "^(?:Business|Home|Mobile|Other)$"))return false;
        if(!this.verifyFormatField(this.clientContactPhone, "^\\w{0,10}$"))return false;
        if(!this.verifyFormatField(this.clientContactEmailAddress, "^.{0,64}$"))return false;
        if(!this.verifyFormatField(this.clientContactAddressLine1, "^.{0,30}$"))return false;
        if(!this.verifyFormatField(this.clientContactAddressLine2, "^.{0,30}$"))return false;
        if(!this.verifyFormatField(this.clientContactCity, "^.{0,30}$"))return false;
        if(!this.verifyFormatField(this.clientContactState, "^\\w{0,2}$"))return false;
        if(!this.verifyFormatField(this.clientContactZip, "^\\w{0,9}$"))return false;
        return true;
    }

    public static boolean verifyDataInDbAndCsvCorrectly(List<ClientGeneralModel> recordsCsv){
        for (ClientGeneralModel recordCsv: recordsCsv){
            if(!recordCsv.verifyFormatFields()) return false;
        }
        return true;
    }

    public static void verifyRandomRecordsFieldNotNull(List<ClientGeneralModel> dataList, List<String> definedField) throws InterruptedException,  IllegalAccessException {
        if(dataList.size() > 5){
            for(int i = 0; i < 5; i++) {
                Assert.assertFalse(CompareUtil.isSpecificFieldsNull(dataList.get(i), definedField));
            }
        }else{
            for(int i = 0; i < dataList.size(); i++) {
                Assert.assertFalse(CompareUtil.isSpecificFieldsNull(dataList.get(i), definedField));
            }
        }
    }

    @Override
    public boolean verifyFieldValue(Object obj) {
        return true;
    }

    @Override
    public boolean verifyFieldsNotNull() {
        if (Objects.isNull(providerID)) {
            return false;
        }
        if (Objects.isNull(clientID)) {
            return false;
        }
        if (Objects.isNull(clientFirstName)) {
            return false;
        }
        return true;
    }
}
