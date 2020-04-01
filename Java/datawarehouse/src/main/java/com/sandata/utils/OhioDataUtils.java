package com.sandata.utils;

import com.interop.common.Commons;
import com.sandata.common.Constant;
import com.sandata.db.ClientDbService;
import com.sandata.db.EmployeeDbService;
import com.sandata.db.VisitDbService;
import com.sandata.entity.exportDWH.IndividualPayerInformationModel;
import com.sandata.entity.exportDWH.VisitExceptionAcknowledgement;
import com.sandata.entity.ohio.client.PatientAdressEntity;
import com.sandata.entity.ohio.client.PatientGeneralEntity;
import com.sandata.entity.ohio.client.PatientPhonesEntity;
import com.sandata.entity.ohio.client.ResponsiblePartyModel;
import com.sandata.entity.ohio.employee.WorkerGeneralEntity;
import com.sandata.models.claim.ohio.v2.ClaimOhioV2Model;
import com.sandata.ws.ClientWebService;
import com.sandata.ws.EmployeeWebService;
import com.sandata.ws.VisitWebService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.util.*;

@SuppressWarnings("squid:S1192")
public class OhioDataUtils {
    Commons commons = new Commons();

    ClientDbService clientDbService = new ClientDbService();
    EmployeeDbService employeeDbService = new EmployeeDbService();
    VisitDbService visitDbService = new VisitDbService();

    ClientWebService clientWebService = new ClientWebService();
    EmployeeWebService employeeWebService = new EmployeeWebService();
    VisitWebService visitWebService = new VisitWebService();

    public List<PatientGeneralEntity> patients;
    public PatientGeneralEntity patient;
    public List<String> clientIds;

    List<WorkerGeneralEntity> workers = new ArrayList<>();
    WorkerGeneralEntity worker = new WorkerGeneralEntity();

    List<com.sandata.entity.ohio.visit.VisitGeneralEntity> visits;
    com.sandata.entity.ohio.visit.VisitGeneralEntity visit;

    List<ClaimOhioV2Model> claims_v2 = new ArrayList<>();
    public String batchId;
    public String claimFileName;

    public Map lastNames;
    public Map firstNames;

    String accountId;
    String providerId;


    /***
     * Init data for 1 clients with 1 segment
     * @return
     */
    private void initPatientData(int count) {
        String env = System.getProperty("test.environment");
        if (env.equalsIgnoreCase("qa")) {
            accountId = "10026";
            providerId = "0210026";
        }
        if (count < 1) {
            return;
        }
        patients = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            PatientGeneralEntity patientEntity = initPatient(accountId, providerId);
            patients.add(patientEntity);
        }
    }

    private void initWorkerData(int count) {
        String env = System.getProperty("test.environment");
        if (env.equalsIgnoreCase("qa")) {
            accountId = "10026";
            providerId = "0210026";
        }
        if (count < 1) {
            return;
        }
        workers = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            WorkerGeneralEntity workerEntity = initWorker(accountId, providerId);
            workers.add(workerEntity);
        }
    }

    private void initVisitData(int count, String payer, String payorId,
                               String payerProgram, String procedureCode,
                               List<String> adjInDateTimes, List<String> callInDateTimes, List<String> callOutDateTime) throws IOException {
        String env = System.getProperty("test.environment");
        if (env.equalsIgnoreCase("qa")) {
            accountId = "10026";
            providerId = "0210026";
        }
        if (count < 1) {
            return;
        }
        visits = new ArrayList<>();
        List<List<String>> workers = loadWorkers();
        List<List<String>> clients = loadClients();

        for (int j = 0; j <= 4; j++) {
            for (int i = 0; i <= 19999; i++) {
                com.sandata.entity.ohio.visit.VisitGeneralEntity visit =
                        initOhioVerifiedVisit(accountId, providerId,
                                workers.get(i).get(2), clients.get(i).get(5), clients.get(i).get(4),
                                payer, payorId, payerProgram, procedureCode,
                                adjInDateTimes.get(j), callInDateTimes.get(j), callOutDateTime.get(j));
                visits.add(visit);
            }
        }
    }


    public void initClaims(String visitFileName, String startDate, String endDate) throws Exception {
        List<List<String>> visits = loadVisis(visitFileName);
        for (int i = 0; i <= visits.size() - 1; i++) {
            ClaimOhioV2Model claim = initSingleLineOhioClaimV2(visits.get(i).get(1),
                    "Model2", batchId, String.valueOf(i),
                    visits.get(i).get(7), "2019087144867", "40",
                    "MedicaidID", visits.get(i).get(1),
                    "MedicaidID", visits.get(i).get(5),
                    startDate, endDate, visits.get(i).get(10), "4", "AddUnits",
                    "","", "", "", "ExcludeUnits");
            claims_v2.add(claim);
        }
    }

    public ClaimOhioV2Model initSingleLineOhioClaimV2(String BusinessEntityMedicaidIdentifier,
                                                      String RequestType, String BatchID, String TransactionID,
                                                      String Payer, String ICN, String DLN,
                                                      String ProviderQualifier, String ProviderID,
                                                      String PatientQualifier, String PatientID,
                                                      String ServiceStartDate, String ServiceEndDate,
                                                      String ProcedureCode,
                                                      String Units, String UnitsRule,
                                                      String Modifier1, String Modifier2, String Modifier3, String Modifier4,
                                                      String MatchingRule) {


        ClaimOhioV2Model claimOhioV2Model = new ClaimOhioV2Model();
        claimOhioV2Model.BusinessEntityMedicaidIdentifier = BusinessEntityMedicaidIdentifier;
        claimOhioV2Model.RequestType = RequestType;
        claimOhioV2Model.BatchID = BatchID;
        claimOhioV2Model.TransactionID = TransactionID;
        claimOhioV2Model.Payer = Payer;
        claimOhioV2Model.ICN = ICN;
        claimOhioV2Model.DLN = DLN;
        claimOhioV2Model.ProviderQualifier = ProviderQualifier;

        claimOhioV2Model.ProviderID = ProviderID;
        claimOhioV2Model.PatientQualifier = PatientQualifier;

        claimOhioV2Model.PatientID = PatientID;
        claimOhioV2Model.ServiceStartDate = ServiceStartDate;
        claimOhioV2Model.ServiceEndDate = ServiceEndDate;
        claimOhioV2Model.ProcedureCode = ProcedureCode;
        claimOhioV2Model.Units = Units;

        claimOhioV2Model.UnitsRule = UnitsRule;
        claimOhioV2Model.Modifier1 = Modifier1;
        claimOhioV2Model.Modifier2 = Modifier2;
        claimOhioV2Model.Modifier3 = Modifier3;
        claimOhioV2Model.Modifier4 = Modifier4;
        claimOhioV2Model.MatchingRule = MatchingRule;
        return claimOhioV2Model;
    }

    public PatientGeneralEntity initPatient(String accountId, String providerId) {
        PatientGeneralEntity patientGeneralEntity = new PatientGeneralEntity();

        patientGeneralEntity.BusinessEntityID = accountId;
        patientGeneralEntity.BusinessEntityMedicaidIdentifier = providerId;
        patientGeneralEntity.IsPatientNewborn = false;
        patientGeneralEntity.PatientAlternateID = "1114314";
        patientGeneralEntity.PatientFirstName = RandomStringUtils.randomAlphabetic(30);//clientDbService.generateNewClientFName(accountId);
        patientGeneralEntity.PatientLastName = RandomStringUtils.randomAlphabetic(30);//clientDbService.generateNewClientLName(accountId);
        patientGeneralEntity.PatientMedicaidID = RandomStringUtils.randomNumeric(12);//clientDbService.generateNewPatientMedicaidID(accountId);
        patientGeneralEntity.PatientOtherID = RandomStringUtils.randomAlphanumeric(64);//clientDbService.generateNewPatientOtherID(accountId);
        patientGeneralEntity.PatientTimezone = "US/Eastern";
        patientGeneralEntity.SequenceID = RandomStringUtils.randomNumeric(16);//clientDbService.generateNewClientLSequenceNumber(accountId);

        List<ResponsiblePartyModel> responsibleParties = new ArrayList<>();
        ResponsiblePartyModel responsiblePartyModel = new ResponsiblePartyModel();
        responsiblePartyModel.PatientResponsiblePartyFirstName = "JStevee";
        responsiblePartyModel.PatientResponsiblePartyLastName = "KJobss";
        responsibleParties.add(responsiblePartyModel);
        patientGeneralEntity.ResponsibleParty = responsibleParties;

        List<IndividualPayerInformationModel> individualPayerInformationModels = new ArrayList<>();
        IndividualPayerInformationModel individualPayerInformationModel = new IndividualPayerInformationModel();
        individualPayerInformationModel.Payer = "ODM";
        individualPayerInformationModel.PayerProgram = "SP";
        individualPayerInformationModel.ProcedureCode = "G0156";
        individualPayerInformationModels.add(individualPayerInformationModel);
        patientGeneralEntity.IndividualPayerInformation = individualPayerInformationModels;

        List<PatientPhonesEntity> phones = new ArrayList<>();
        PatientPhonesEntity phone = new PatientPhonesEntity();
        phone.PatientPhoneNumber = "9431650001";
        phone.PatientPhoneType = "Home";
        phones.add(phone);
        patientGeneralEntity.Phones = phones;

        List<PatientAdressEntity> addresses = new ArrayList<>();
        PatientAdressEntity address1 = new PatientAdressEntity();
        address1.PatientAddressIsPrimary = true;
        address1.PatientAddressLine1 = "201 Harbour Drive Rd";
        address1.PatientAddressLine2 = "1nd Floor";
        address1.PatientAddressType = "School";
        address1.PatientCity = "Port Washington";
        address1.PatientLatitude = 88.1155122001;
        address1.PatientLongitude = 85.1155122001;
        address1.PatientState = "OH"; //  set PatientState = "OH"
        address1.PatientTimezone = null; // set PatientTimezone = null
        address1.PatientZip = "55556";

        PatientAdressEntity address2 = new PatientAdressEntity();
        address2.PatientAddressIsPrimary = false;
        address2.PatientAddressLine1 = "123456789012345678901234567890";
        address2.PatientAddressLine2 = "2nd Floor";
        address2.PatientAddressType = "School";
        address2.PatientCity = "Port Washington";
        address2.PatientLatitude = 88.1155122001;
        address2.PatientLongitude = 85.1155122001;
        address2.PatientState = "OH";
        address2.PatientTimezone = null;
        address2.PatientZip = "12345-6789";

        addresses.add(address1);
        addresses.add(address2);
        patientGeneralEntity.Address = addresses;

        return patientGeneralEntity;
    }

    public PatientGeneralEntity initPatient(String accountId, String providerId, String PatientFirstName, String PatientLastName, String PatientMedicaidID, String PatientOtherID) {
        PatientGeneralEntity patientGeneralEntity = new PatientGeneralEntity();

        patientGeneralEntity.BusinessEntityID = accountId;
        patientGeneralEntity.BusinessEntityMedicaidIdentifier = providerId;
        patientGeneralEntity.IsPatientNewborn = false;
        patientGeneralEntity.PatientAlternateID = "1114314";
        patientGeneralEntity.PatientFirstName = PatientFirstName;
        patientGeneralEntity.PatientLastName = PatientLastName;
        patientGeneralEntity.PatientMedicaidID = PatientMedicaidID;
        patientGeneralEntity.PatientOtherID = PatientOtherID;
        patientGeneralEntity.PatientTimezone = "US/Eastern";
        patientGeneralEntity.SequenceID = clientDbService.generateNewClientLSequenceNumber(accountId);

        List<ResponsiblePartyModel> responsibleParties = new ArrayList<>();
        ResponsiblePartyModel responsiblePartyModel = new ResponsiblePartyModel();
        responsiblePartyModel.PatientResponsiblePartyFirstName = "JStevee";
        responsiblePartyModel.PatientResponsiblePartyLastName = "KJobss";
        responsibleParties.add(responsiblePartyModel);
        patientGeneralEntity.ResponsibleParty = responsibleParties;

        List<IndividualPayerInformationModel> individualPayerInformationModels = new ArrayList<>();
        IndividualPayerInformationModel individualPayerInformationModel = new IndividualPayerInformationModel();
        individualPayerInformationModel.Payer = "ODM";
        individualPayerInformationModel.PayerProgram = "SP";
        individualPayerInformationModel.ProcedureCode = "G0156";
        individualPayerInformationModels.add(individualPayerInformationModel);
        patientGeneralEntity.IndividualPayerInformation = individualPayerInformationModels;

        List<PatientPhonesEntity> phones = new ArrayList<>();
        PatientPhonesEntity phone = new PatientPhonesEntity();
        phone.PatientPhoneNumber = "9431650001";
        phone.PatientPhoneType = "Home";
        phones.add(phone);
        patientGeneralEntity.Phones = phones;

        List<PatientAdressEntity> addresses = new ArrayList<>();
        PatientAdressEntity address1 = new PatientAdressEntity();
        address1.PatientAddressIsPrimary = true;
        address1.PatientAddressLine1 = "201 Harbour Drive Rd";
        address1.PatientAddressLine2 = "1nd Floor";
        address1.PatientAddressType = "School";
        address1.PatientCity = "Port Washington";
        address1.PatientLatitude = 88.1155122001;
        address1.PatientLongitude = 85.1155122001;
        address1.PatientState = "OH"; //  set PatientState = "OH"
        address1.PatientTimezone = null; // set PatientTimezone = null
        address1.PatientZip = "55556";

        PatientAdressEntity address2 = new PatientAdressEntity();
        address2.PatientAddressIsPrimary = false;
        address2.PatientAddressLine1 = "123456789012345678901234567890";
        address2.PatientAddressLine2 = "2nd Floor";
        address2.PatientAddressType = "School";
        address2.PatientCity = "Port Washington";
        address2.PatientLatitude = 88.1155122001;
        address2.PatientLongitude = 85.1155122001;
        address2.PatientState = "OH";
        address2.PatientTimezone = null;
        address2.PatientZip = "12345-6789";

        addresses.add(address1);
        addresses.add(address2);
        patientGeneralEntity.Address = addresses;

        return patientGeneralEntity;
    }

    public WorkerGeneralEntity initWorker(String accountId, String providerId) {
        String uniqueNum = commons.generateUniqueNumber();

        List<WorkerGeneralEntity> workerGeneralEntities = new ArrayList<>();
        WorkerGeneralEntity workerGeneralEntity = new WorkerGeneralEntity();
        workerGeneralEntity.BusinessEntityID = accountId;
        workerGeneralEntity.BusinessEntityMedicaidIdentifier = providerId;
        workerGeneralEntity.StaffOtherID = RandomStringUtils.randomAlphanumeric(64);//employeeDbService.generateNewEmployeeIdCustom1(accountId);
        workerGeneralEntity.SequenceID = RandomStringUtils.randomNumeric(16);//employeeDbService.generateNewEmployeeSequenceNumber(accountId);
        workerGeneralEntity.StaffID = RandomStringUtils.randomNumeric(9);//employeeDbService.generateNewEmployeeStxId(accountId);
        workerGeneralEntity.StaffSSN = RandomStringUtils.randomNumeric(9); //employeeDbService.generateNewEmployeeSsn(accountId);
        workerGeneralEntity.StaffLastName = RandomStringUtils.randomAlphabetic(30);//employeeDbService.generateNewEmployeeLName(accountId);
        workerGeneralEntity.StaffFirstName = RandomStringUtils.randomAlphabetic(30); //employeeDbService.generateNewEmployeeFName(accountId);
        workerGeneralEntity.StaffEmail = "stx" + workerGeneralEntity.SequenceID + "@sandata.com";
        workerGeneralEntity.StaffPosition = "LPN";

        return workerGeneralEntity;
    }

    public WorkerGeneralEntity initWorker(String accountId, String providerId, String StaffOtherID, String SequenceID, String StaffID, String StaffSSN, String StaffLastName, String StaffFirstName) {
        String uniqueNum = commons.generateUniqueNumber();

        List<WorkerGeneralEntity> workerGeneralEntities = new ArrayList<>();
        WorkerGeneralEntity workerGeneralEntity = new WorkerGeneralEntity();
        workerGeneralEntity.BusinessEntityID = accountId;
        workerGeneralEntity.BusinessEntityMedicaidIdentifier = providerId;
        workerGeneralEntity.StaffOtherID = StaffOtherID;
        workerGeneralEntity.SequenceID = SequenceID;
        workerGeneralEntity.StaffID = StaffID;
        workerGeneralEntity.StaffSSN = StaffSSN;
        workerGeneralEntity.StaffLastName = StaffLastName;
        workerGeneralEntity.StaffFirstName = StaffFirstName;
        workerGeneralEntity.StaffEmail = "stx" + workerGeneralEntity.SequenceID + "@sandata.com";
        workerGeneralEntity.StaffPosition = "LPN";

        return workerGeneralEntity;
    }

    public com.sandata.entity.ohio.visit.VisitGeneralEntity initOhioVerifiedVisit(String accountId, String
            providerId,
                                                                                  String StaffOtherID, String PatientOtherID, String PatientMedicaidID,
                                                                                  String payer, String payorId,
                                                                                  String payerProgram, String procedureCode,
                                                                                  String adjInDateTime, String callInDateTime, String callOutDateTime) {

        com.sandata.entity.ohio.visit.VisitGeneralEntity visitGeneralEntity = new com.sandata.entity.ohio.visit.VisitGeneralEntity();

        visitGeneralEntity.BusinessEntityID = accountId;
        visitGeneralEntity.BusinessEntityMedicaidIdentifier = providerId;
        visitGeneralEntity.VisitOtherID = RandomStringUtils.randomAlphanumeric(50);//visitDbService.generateNewVisitOtherId(accountId);
        visitGeneralEntity.SequenceID = RandomStringUtils.randomNumeric(16);//visitDbService.generateNewVisitSequenceNumber(accountId);

        visitGeneralEntity.StaffOtherID = StaffOtherID;
        visitGeneralEntity.PatientOtherID = PatientOtherID;
        visitGeneralEntity.PatientMedicaidID = PatientMedicaidID;
        visitGeneralEntity.VisitCancelledIndicator = false;
        visitGeneralEntity.Payer = payer;
        visitGeneralEntity.PayerID = payorId;
        //TODO: {Payer: "ODM", PayerProgram: "OHC", ProcedureCode: "MR816"}, {Payer: "ODM", PayerProgram: "SP", ProcedureCode: "MR816"}
        visitGeneralEntity.PayerProgram = payerProgram;
        visitGeneralEntity.ProcedureCode = procedureCode;
        visitGeneralEntity.GroupVisitIndicator = "true";
        visitGeneralEntity.GroupVisitCode = "123456";
        visitGeneralEntity.TimeZone = "US/Eastern";
        visitGeneralEntity.AdjInDateTime = adjInDateTime;


        visitGeneralEntity.BillVisit = true;
        visitGeneralEntity.HoursToBill = 120;
        visitGeneralEntity.VisitMemo = "TestMemo" + visitGeneralEntity.SequenceID;
        visitGeneralEntity.MemberVerifiedTimes = true;
        visitGeneralEntity.MemberVerifiedService = true;
        visitGeneralEntity.MemberSignatureAvailable = true;
        visitGeneralEntity.MemberVoiceRecording = true;

        List<com.sandata.entity.ohio.visit.Call> calls = new ArrayList<>();
        com.sandata.entity.ohio.visit.Call callIn = new com.sandata.entity.ohio.visit.Call();
        callIn.CallExternalID = commons.generateUniqueNumber();
        callIn.CallDateTime = callInDateTime;
        callIn.CallAssignment = Constant.CallAssignment.CallIn.toString();
        callIn.CallType = Constant.CallType.Other.toString();
        callIn.GroupVisitCode = "12978";
        callIn.ProcedureCode = procedureCode;
        callIn.PatientIdentifierOnCall = "02225";
        callIn.MobileLogin = "qweqewq";
        callIn.CallLatitude = "86.2";
        callIn.CallLongitude = "160.2";
        callIn.TelephonyPIN = 2252;
        callIn.OriginatingPhoneNumber = "1234567890";

        com.sandata.entity.ohio.visit.Call callOut = new com.sandata.entity.ohio.visit.Call();
        callOut.CallExternalID = commons.generateUniqueNumber();
        callOut.CallDateTime = callOutDateTime;
        callOut.CallAssignment = Constant.CallAssignment.CallOut.toString();
        callOut.CallType = Constant.CallType.Other.toString();
        callOut.GroupVisitCode = "12978";
        callOut.ProcedureCode = procedureCode;
        callOut.PatientIdentifierOnCall = "02225";
        callOut.MobileLogin = "qweqewq";
        callOut.CallLatitude = "86.2";
        callOut.CallLongitude = "160.2";
        callOut.TelephonyPIN = 2252;
        callOut.OriginatingPhoneNumber = "1234567890";


        calls.add(callIn);
        calls.add(callOut);
        visitGeneralEntity.Calls = calls;

        List<VisitExceptionAcknowledgement> visitExceptionAcknowledgements = new ArrayList<>();
        VisitExceptionAcknowledgement visitExceptionAcknowledgement1 = new VisitExceptionAcknowledgement();
        visitExceptionAcknowledgement1.ExceptionID = "25";
        visitExceptionAcknowledgement1.ExceptionAcknowledged = true;
        visitExceptionAcknowledgements.add(visitExceptionAcknowledgement1);

        visitGeneralEntity.VisitException = visitExceptionAcknowledgements;

        List<com.sandata.entity.ohio.visit.VisitChange> visitChanges = new ArrayList<>();
        com.sandata.entity.ohio.visit.VisitChange visitChange = new com.sandata.entity.ohio.visit.VisitChange();
        visitChange.SequenceID = visitGeneralEntity.SequenceID;
        visitChange.ChangeMadeByEmail = "yesterday2010@test.com";
        visitChange.ChangeDateTime = "2019-01-17T00:00:00Z";
        visitChange.ReasonCode = "1235";
        visitChange.ChangeReasonMemo = "1111135437";
        visitChange.ResolutionCode = "A";

        visitChanges.add(visitChange);
        visitGeneralEntity.VisitChanges = visitChanges;

        return visitGeneralEntity;
    }

    public void createWorker(String accountId, String providerId, String StaffOtherID, String SequenceID, String StaffID, String StaffSSN, String StaffLastName, String StaffFirstName) {
        String env = System.getProperty("test.environment");
        if (env.equalsIgnoreCase("qa")) {
            accountId = "10026";
            providerId = "0210026";
        } else if (env.equalsIgnoreCase("dev")) {

        }
        workers = new ArrayList<>();
        WorkerGeneralEntity worker = initWorker(accountId, providerId, StaffOtherID, SequenceID, StaffID, StaffSSN, StaffLastName, StaffFirstName);
        workers.add(worker);
        List<WorkerGeneralEntity> _workers = employeeWebService.createOhioWorkers(workers);
        if (_workers != null) {
            System.out.println("Create worker " + StaffFirstName + " with STX_ID: " + StaffID +  "Successfully.");
        }
    }

    public void createClient(String accountId, String providerId, String PatientFirstName, String PatientLastName, String PatientMedicaidID, String PatientOtherID) {
        String env = System.getProperty("test.environment");
        if (env.equalsIgnoreCase("qa")) {
            accountId = "10026";
            providerId = "0210026";
        } else if (env.equalsIgnoreCase("dev")) {

        }
        patients = new ArrayList<>();
        PatientGeneralEntity patient = initPatient(accountId, providerId, PatientFirstName, PatientLastName, PatientMedicaidID, PatientOtherID);
        patients.add(patient);
        List<PatientGeneralEntity> _patients = clientWebService.createOhioClients(patients, 3, 3);
        if (_patients != null) {
            System.out.println("Create client " + PatientFirstName + " with medicaid " + PatientMedicaidID +  "Successfully.");
        }
    }

    public void createMultipleClients(int count) {
        initPatientData(count);
        List<PatientGeneralEntity> _patients = clientWebService.createOhioClients(patients, 3, 3);
        if (_patients != null) {
            // write to file
            toClientFile(_patients);
        }
    }

    public void createMultipleEmployees(int count) {
        initWorkerData(count);
        List<WorkerGeneralEntity> _workers = employeeWebService.createOhioWorkers(workers);
        if (workers != null) {
            // write to file
            toEmployeeFile(workers);
        }
    }

    public void createMultipleVisits(int count, String payer, String payorId,
                                     String payerProgram, String procedureCode,
                                     List<String> adjInDateTimes, List<String> callInDateTimes, List<String> callOutDateTimes) throws IOException {

        initVisitData(count, payer, payorId, payerProgram, procedureCode,
                adjInDateTimes, callInDateTimes, callOutDateTimes);

        int limit = 500;
        int iterator =  visits.size() / limit;

        for ( int i = 1; i <= iterator; i++ ) {
            List<com.sandata.entity.ohio.visit.VisitGeneralEntity> list = visits.subList(0, limit);
            list = visitWebService.createOhioVisits(list);
            if (list != null) {
                // write to file
                toVisitFile(list);
            }
            System.out.println("Done Create Visit: " + i);
            commons.wait(10);
            visits.subList(0, limit).clear();
        }
    }

    public String QA_OHIO_CLIENT_FOLDER_PATH = System.getProperty("user.dir") + "/qa_ohio_client/";
    public String DEV_OHIO_CLIENT_FOLDER_PATH = System.getProperty("user.dir") + "/dev_ohio_client/";

    public String QA_OHIO_EMPLOYEE_FOLDER_PATH = System.getProperty("user.dir") + "/qa_ohio_employee/";
    public String DEV_OHIO_EMPLOYEE_FOLDER_PATH = System.getProperty("user.dir") + "/dev_ohio_employee/";

    public String QA_OHIO_VISIT_FOLDER_PATH = System.getProperty("user.dir") + "/qa_ohio_visit/";
    public String DEV_OHIO_VISIT_FOLDER_PATH = System.getProperty("user.dir") + "/dev_ohio_visit/";

    public String QA_OHIO_CLAIM_FOLDER_PATH = System.getProperty("user.dir") + "/qa_ohio_claim/";
    public String DEV_OHIO_CLAIM_FOLDER_PATH = System.getProperty("user.dir") + "/dev_ohio_claim/";

    String QA_OHIO_CLIENT_FILENAME = QA_OHIO_CLIENT_FOLDER_PATH + "qa_ohio_clients.txt";
    String DEV_OHIO_CLIENT_FILENAME = DEV_OHIO_CLIENT_FOLDER_PATH + "dev_ohio_clients.txt";

    String QA_OHIO_EMPLOYEE_FILENAME = QA_OHIO_EMPLOYEE_FOLDER_PATH + "qa_ohio_employees.txt";
    String DEV_OHIO_EMPLOYEE_FILENAME = DEV_OHIO_EMPLOYEE_FOLDER_PATH + "dev_ohio_employees.txt";

    public void toClientFile(List<PatientGeneralEntity> patients) {
        File client_dir = null;
        String fileName = "";
        String env = System.getProperty("test.environment");

        if (env.equalsIgnoreCase("qa")) {
            client_dir = new File(QA_OHIO_CLIENT_FOLDER_PATH);
            fileName = QA_OHIO_CLIENT_FILENAME;
        } else if (env.equalsIgnoreCase("dev")) {
            client_dir = new File(DEV_OHIO_CLIENT_FOLDER_PATH);
            fileName = DEV_OHIO_CLIENT_FILENAME;
        }

        if (!client_dir.exists()) {
            client_dir.mkdirs();
        }

        System.out.println("Going to write to: " + fileName);

        Collection lines = new ArrayList<>();

        for (int i = 0; i <= patients.size() - 1; i++) {
            lines.add(patients.get(i).BusinessEntityID + "," +
                    patients.get(i).BusinessEntityMedicaidIdentifier + "," +
                    patients.get(i).PatientFirstName + "," +
                    patients.get(i).PatientLastName + "," +
                    patients.get(i).PatientMedicaidID + "," +
                    patients.get(i).PatientOtherID);
        }

        File fileToWrite1 = FileUtils.getFile(fileName);
        try {
            FileUtils.writeLines(fileToWrite1, lines, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void toEmployeeFile(List<WorkerGeneralEntity> workers) {
        File empl_dir = null;
        String fileName = "";
        String env = System.getProperty("test.environment");

        if (env.equalsIgnoreCase("qa")) {
            empl_dir = new File(QA_OHIO_EMPLOYEE_FOLDER_PATH);
            fileName = QA_OHIO_EMPLOYEE_FILENAME;
        } else if (env.equalsIgnoreCase("dev")) {
            empl_dir = new File(DEV_OHIO_EMPLOYEE_FOLDER_PATH);
            fileName = DEV_OHIO_EMPLOYEE_FILENAME;
        }

        if (!empl_dir.exists()) {
            empl_dir.mkdirs();
        }

        System.out.println("Going to write to: " + fileName);

        Collection lines = new ArrayList<>();

        for (int i = 0; i <= workers.size() - 1; i++) {
            lines.add(
                    workers.get(i).BusinessEntityID + "," +
                            workers.get(i).BusinessEntityMedicaidIdentifier + "," +
                            workers.get(i).StaffOtherID + "," +
                            workers.get(i).SequenceID + "," +
                            workers.get(i).StaffID + "," +
                            workers.get(i).StaffSSN + "," +
                            workers.get(i).StaffLastName + "," +
                            workers.get(i).StaffFirstName + "," +
                            workers.get(i).StaffEmail);
        }

        File fileToWrite1 = FileUtils.getFile(fileName);
        try {
            FileUtils.writeLines(fileToWrite1, lines, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void toVisitFile(List<com.sandata.entity.ohio.visit.VisitGeneralEntity> visits) {
        File visit_dir = null;
        String fileName = "";
        String env = System.getProperty("test.environment");

        String date = visits.get(0).AdjInDateTime.split("T")[0];
        List<String> dateInfo = Arrays.asList(date.split("-"));

        if (env.equalsIgnoreCase("qa")) {
            visit_dir = new File(QA_OHIO_VISIT_FOLDER_PATH);
            fileName = "qa_" + "visit_" + visits.get(0).Payer + "_" + visits.get(0).PayerProgram + "_" + visits.get(0).ProcedureCode + "_" +
                    dateInfo.get(0) + "_" + dateInfo.get(1) + "_" + dateInfo.get(2) + ".txt";
        } else if (env.equalsIgnoreCase("dev")) {
            visit_dir = new File(DEV_OHIO_VISIT_FOLDER_PATH);
            fileName = "dev_" + "visit_" + visits.get(0).Payer + "_" + visits.get(0).PayerProgram + "_" + visits.get(0).ProcedureCode + "_" +
                    dateInfo.get(0) + "_" + dateInfo.get(1) + "_" + dateInfo.get(2) + ".txt";
        }

        if (!visit_dir.exists()) {
            visit_dir.mkdirs();
        }

        System.out.println("Going to write to: " + fileName);

        Collection lines = new ArrayList<>();

        for (int i = 0; i <= visits.size() - 1; i++) {
            lines.add(
                    visits.get(i).BusinessEntityID + "," +
                            visits.get(i).BusinessEntityMedicaidIdentifier + "," +
                            visits.get(i).VisitOtherID + "," +
                            visits.get(i).SequenceID + "," +
                            visits.get(i).StaffOtherID + "," +
                            visits.get(i).PatientMedicaidID + "," +
                            visits.get(i).PatientOtherID + "," +
                            visits.get(i).Payer + "," +
                            visits.get(i).PayerID + "," +
                            visits.get(i).PayerProgram + "," +
                            visits.get(i).ProcedureCode + "," +
                            visits.get(i).AdjInDateTime + "," +
                            visits.get(i).VisitMemo + "," +
                            visits.get(i).Calls.get(0).CallAssignment + "," +
                            visits.get(i).Calls.get(0).CallDateTime + "," +
                            visits.get(i).Calls.get(1).CallAssignment + "," +
                            visits.get(i).Calls.get(1).CallDateTime);
        }

        File fileToWrite1 = FileUtils.getFile(visit_dir + "/" + fileName);
        try {
            FileUtils.writeLines(fileToWrite1, lines, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void toBatchClaimFile() {
        File claim_dir = null;
        String env = System.getProperty("test.environment");

        if (env.equalsIgnoreCase("qa")) {
            claim_dir = new File(QA_OHIO_CLAIM_FOLDER_PATH);

        } else if (env.equalsIgnoreCase("dev")) {
            claim_dir = new File(DEV_OHIO_CLAIM_FOLDER_PATH);
        }

        claimFileName = "ODM_Req_EVVBatch_20190327_141703.571_" + batchId + "_Incremental.dsv";

        if (!claim_dir.exists()) {
            claim_dir.mkdirs();
        }

        System.out.println("Going to write to: " + claimFileName);

        Collection lines = new ArrayList<>();

        String headers = createHeader();
        lines.add(headers);

        for (int i = 0; i <= claims_v2.size() - 1; i++) {
            lines.add(claims_v2.get(i).toLine());
        }

        File fileToWrite1 = FileUtils.getFile(claim_dir + "/" + claimFileName);
        try {
            FileUtils.writeLines(fileToWrite1, lines, true);
            System.out.println("Wroted " + (lines.size() - 1) + "lines." );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<List<String>> loadClients() throws IOException {
        List<String> rawRows = new ArrayList();
        List<List<String>> rows = new ArrayList<>();
        List<String> row = new ArrayList<>();

        String env = System.getProperty("test.environment");
        if (env.equalsIgnoreCase("qa")) {
            rawRows = FileUtils.readLines(new File(QA_OHIO_CLIENT_FILENAME), Charset.defaultCharset());
        } else if (env.equalsIgnoreCase("dev")) {
            rawRows = FileUtils.readLines(new File(DEV_OHIO_CLIENT_FILENAME), Charset.defaultCharset());
        }

        for (int i = 0; i <= rawRows.size() - 1; i++) {
            row = Arrays.asList(rawRows.get(i).split(","));
            rows.add(row);
        }
        return rows;
    }

    public List<List<String>> loadWorkers() throws IOException {
        List<String> rawRows = new ArrayList();
        List<List<String>> rows = new ArrayList<>();
        List<String> row = new ArrayList<>();

        String env = System.getProperty("test.environment");
        if (env.equalsIgnoreCase("qa")) {
            rawRows = FileUtils.readLines(new File(QA_OHIO_EMPLOYEE_FILENAME), Charset.defaultCharset());
        } else if (env.equalsIgnoreCase("dev")) {
            rawRows = FileUtils.readLines(new File(DEV_OHIO_EMPLOYEE_FILENAME), Charset.defaultCharset());
        }

        for (int i = 0; i <= rawRows.size() - 1; i++) {
            row = Arrays.asList(rawRows.get(i).split(","));
            rows.add(row);
        }
        return rows;
    }

    public List<List<String>> loadVisis(String filename) throws IOException {
        File claim_dir = null;
        String env = System.getProperty("test.environment");
        if (env.equalsIgnoreCase("qa")) {
            claim_dir = new File(QA_OHIO_VISIT_FOLDER_PATH);
        } else if (env.equalsIgnoreCase("dev")) {
            claim_dir = new File(DEV_OHIO_VISIT_FOLDER_PATH);
        }

        List<String> rawRows = new ArrayList();
        List<List<String>> rows = new ArrayList<>();
        List<String> row = new ArrayList<>();

        rawRows = FileUtils.readLines(new File(claim_dir + "/" + filename), Charset.defaultCharset());

        for (int i = 0; i <= rawRows.size() - 1; i++) {
            row = Arrays.asList(rawRows.get(i).split(","));
            rows.add(row);
        }
        return rows;
    }

    public String createHeader() {
        Class currentClass = ClaimOhioV2Model.class;
        String header_line = "";
        Field[] fields = currentClass.getDeclaredFields();
        int last = fields.length - 1;
        String name = "";
        for (int i = 0; i <= fields.length - 1; i++) {
            if(i == last) {
                name = "\"" + fields[i].getName() + "\"";
            } else {
                name = "\"" + fields[i].getName() + "\"" + "|";
            }
            header_line += name;
        }
        return header_line;
    }

    public void generateClientLastNames(int count) {
        int currentCount = count;
        lastNames = new HashMap();
        boolean continueGenerate = true;
        while (continueGenerate) {
            for (int i = 1; i <= currentCount; i++) {
                String name = RandomStringUtils.randomAlphabetic(30);
                lastNames.put(name, "");
            }
            if (lastNames.size() == count) {
                System.out.println(count + " unique last names are generated.");
                continueGenerate = false;
            } else {
                System.out.println("Just " + lastNames.size() + " unique last names are generated.");
                currentCount = count - lastNames.size();
            }
        }
    }
}
