package com.globalMethods.core;

public class Constant_SQL {

	public static String random_Worker_AltEVVGeneric_PA_Not_Contain =
			"select wo.STX_ID as EmployeeIdentifier, " +
					"su.WORKER_ID_CUSTOM1 as StaffOtherId " +
					"FROM STX.WORKERS wo, stx.WORKERS_SUPP su  " +
					"WHERE wo.ACCOUNT = '%s' AND wo.WORKERKEY = su.WORKERKEY " +
					"AND wo.STX_ID IS NOT NULL AND su.WORKER_SSN IS NOT NULL " +
					"AND LENGTH(su.WORKER_ID_CUSTOM1) < 7" +
					"AND su.WORKER_ID_CUSTOM1 <> '%s'" +
					"AND wo.end_date > sysdate  " +
					"AND ROWNUM <= 100";
	public static String random_Client_AltEVVGeneric_Not_Contain = "select LOC as ClientID, " +
			"su.MEDICAID_ID AS PATIENTMEDICAIDID, su.CLIENT_ID_CUSTOM1 AS PATIENTOTHERID " +
			"FROM STX.CLIENTS cl, STX.CLIENTS_SUPP su \n" +
			"WHERE cl.ACCOUNT = '%s' AND cl.CLIENTKEY = su.CLIENTKEY\n" +
			"AND su.MEDICAID_ID IS NOT NULL \n" +
			"AND su.CLIENT_ID_CUSTOM1 <> '%s'" +
			"AND cl.end_date > sysdate " +
			"AND ROWNUM <= 100";
	public String getAccountCreationDateSQL = "select created from stx.accounts_info where account='%s'";
	public String rowofprovider =
			"select * from stx.accounts where provider_id='%s'";
	public String getAccountFromProvider =
			"select account from stx.accounts where provider_id='%s'";
	public String StatusCodeAuth =
			"select distinct  au.status_code from intfstagedb.auth au where client_id='%s'";
	public String StatusCodeClient =
			"select distinct  cl.status_code from intfstagedb.client cl where client_id='%s'";
	public String selectStatusCodeInbox =
			"select ERROR_CODE from inbox.clients where client_id_custom1 ='%s'";
	public String selectxref_serivices =
			"select Error_code, LOC,SID from inbox.xref_services where LOC='%s'";
	public String claimValidationSqlAdj =
			"select payer_name as Payer, provider_id as ProviderID, provider_id_typ_qlfr as ProviderQualifier," +
					"visitkey as VisitKey,visit_beg_adj_dtime as AdjInDateTime,visit_end_adj_dtime as AdjOutDateTime,"
					+ "visit_tz_name as VisitTimeZone,visit_found_ind as VisitFound"
					+ ",client_id as PatientID,dln as DLN , icn as ICN,bill_unit_count as Units ,modifier1 as Modifier1,"
					+ "modifier2 as Modifier2,modifier3 as Modifier3,modifier4 as Modifier4 from iodata.intf_rsp_txn_claim_stack where INTF_REQ_TXN_ID='%s'";
	public String stxClientAddressSql_AltEVVMolina =
			"select addr1 as ClientAddressLine1,addr2 as ClientAddressLine2, state as ClientState, city as ClientCity" +
					", zip_code as ClientZip, county as ClientCounty, addr_type_qlfr as ClientAddressType"
					+ " from stx.clients_address where LOC = '%s' and addr1='%s'";
	public String clientAddressSql_Ohio3P =
			"select Error_code, addr1 as PatientAddressLine1,addr2 as PatientAddressLine2, state as PatientState, city as PatientCity," +
					" zip_code as PatientZip, addr_type_qlfr as PatientAddressType"
					+ " from inbox.clients_address where addr2 ='%s' and addr1='%s'";
	public String stxClientSql_Ohio =
			"select clientkey as CLIENTKEY, ACCOUNT as BusinessEntityID, F_NAME as PatientFirstName,"
					+ "L_Name as PatientLastName, client_version_number as SequenceID from stx.clients where client_version_number ='%s' and ACCOUNT='%s'";
	public String stxClientSuppSql_Ohio =
			"select  ADDR1 as PatientAddressLine1, ADDR2 as PatientAddressLine2, "
					+ "CITY as PatientCity, STATE as PatientState, ZIP_CODE as PatientZip "
					+ "from stx.clients_supp  where clientkey='%s'";
	public String inboxClientsql_Ohio =
			"select Error_code, LOC as ClientID, ACCOUNT as BusinessEntityID, F_NAME as PatientFirstName, "
					+ "L_Name as PatientLastName, MEDICAID_ID as PatientMedicaidID, CLIENT_ID_CUSTOM1 as PatientOtherID, "
					+ "client_version_number as SequenceID"
					+ " from inbox.clients where F_NAME = '%s' and client_version_number='%s'";
	public String stxClientSql_OpenEvv =
			"select ACCOUNT as Account, LOC as ClientID, SPV as Coordinator, F_NAME as ClientFirstName,"
					+ "L_Name as ClientLastName from stx.clients c, stx.CLIENTS_SUPP su where LOC ='%s' " +
					"AND SPV IS NOT null AND c.CLIENTKEY = su.CLIENTKEY AND su.MEDICAID_ID='%s'";
	public String stxClientSql_Member =
			"select  LOC as ClientID, F_NAME as ClientFirstName,"
					+ "L_Name as ClientLastName from stx.clients where LOC ='%s' and L_Name='%s'";
	public String inboxAuth_Ohio = "select Error_code, SID as SID from inbox.authorizations where LOC ='%s' and ACCOUNT='%s'";
	public String stxAuthorization_payerClientIdentifier =
			"select CLIENT_ID_CUSTOM as PayerClientIdentifier"
					+ " from stx.authorizations where loc='%s'";
	public String inboxWorker_3P =
			"select account as BusinessEntityID,  l_name as StaffLastName, F_NAME as StaffFirstName, att_id as StaffID, Error_Code as error_code, "
					+ "worker_ssn as StaffSSN from inbox.workers where worker_ssn='%s' and Account='%s'";
	public String StxWorker_3P =
			"select account as BusinessEntityID,  l_name as StaffLastName, F_NAME as StaffFirstName, att_id as StaffID, "
					+ "stx_id as StaffID from stx.workers where worker_version_number='%s' and Account='%s'";
	public String inboxCall =
			"select Call_username as from inbox.calls where ";
	public String stxWorkerSupp_openevv =
			"select WORKER_SSN as EmployeeSSN, ADDR2 as EmployeeAddress2, ADDR1 as EmployeeAddress1, WORKER_API as EmployeeAPI,"
					+ " worker_beg_date as EmployeeHireDate, worker_end_date as EmployeeEndDate  from stx.workers_supp where WORKER_SSN='%s'";
	public String stxWorkerSupp_3p =
			"select WORKER_SSN as StaffSSN, account as BusinessEntityID from stx.workers_supp where WORKER_SSN='%s'";
	public String stxAccount =
			"select Account, PROVIDER_ID from stx.accounts_interfaces where account='%s'";
	public String stxAccounts_services =
			"Select account as Account, SERVICE as ProcedureCode from stx.accounts_services where ProcedureCode='%s' and account='%s'";
	public String stxAccountInfoSql =
			"select Account as Account, compname as ProviderName"
					+ " addr2 as AddressLine2, ADDR1 as AddressLine1, CITY as AddressCity, ZIP_CODE as AddressZip, county as County, STATE as AddressState, "
					+ "phone as AgencyPhone, e_mail as AgencyEmail, CONTACT_L_NAME as PrimaryContactLastName, CONTACT_F_NAME as PrimaryContactFirstName, "
					+ "fax as ProviderFax, npi as NPI, api as Provider"
					+ " from stx.accounts_info where compname ='%s'";
	public String inboxVisitOhio_11604 =
			"select  PAYOR_NAME as Payer, PAYOR_PROGRAM as PayerProgram, PAYOR_ID as PayerID, SERVICE as ProcedureCode, error_code as error_code, VISITKEY as VISITKEY, visit_id as VisitOtherID, visit_version_number as SequenceID"
					+ " from inbox.visits where visit_id='%s' and visit_version_number='%s'";
	public String stxVisitOhio_11604 =
			"select  PAYOR_ID as Payer, PROGRAM as PayerProgram, SERVICE as ProcedureCode, VISITKEY as VISITKEY, visit_id as VisitOtherID, visit_version_number as SequenceID"
					+ " from stx.visits where visit_id='%s' and visit_version_number='%s'";
	public String inboxVisitCallsOhio =
			"select  Ani as OriginatingPhoneNumber, call_id as CallExternalID, Service as ProcedureCode,"
					+ "call_username as MobileLogin,"
					+ " stx_id as TelephonyPIN,CALL_TYPE_QLFR as CallType from inbox.calls where visit_id='%s' and call_assignment_qlfr='%s'";
	public String visitStatus =
			"select lib.getvisitstatus_custom('%s')from dual";
	public String payerCodeValidation_Openevv = "SELECT SERVICE as ProcedureCode FROM stx.payor_data_validation where Program='%s' and payor_ID='%s'";

	public String random_ClientAltEVVMolina_Sql = "select LOC as ClientID, " +
			"su.MEDICAID_ID AS PATIENTMEDICAIDID, su.CLIENT_ID_CUSTOM1 AS PATIENTOTHERID " +
			"FROM STX.CLIENTS cl, STX.CLIENTS_SUPP su \n" +
			"WHERE cl.ACCOUNT = '%s' AND cl.CLIENTKEY = su.CLIENTKEY\n" +
			"AND su.MEDICAID_ID IS NOT NULL \n" +
			"AND su.CLIENT_ID_CUSTOM1 IS NOT NULL " +
			"AND cl.end_date > sysdate " +
			"AND ROWNUM <= 100";

	public String random_ClientAltEVVGenericSql = "select LOC as ClientID, " +
			"su.MEDICAID_ID AS PATIENTMEDICAIDID, su.CLIENT_ID_CUSTOM1 AS PATIENTOTHERID " +
			"FROM STX.CLIENTS cl, STX.CLIENTS_SUPP su \n" +
			"WHERE cl.ACCOUNT = '%s' AND cl.CLIENTKEY = su.CLIENTKEY\n" +
			"AND su.CLIENT_ID_CUSTOM1 IS NOT NULL " +
			"AND cl.end_date > sysdate " +
			"AND ROWNUM <= 100";
	public String ClientsOnlyNumbericSql = "select LOC as ClientID, " +
			"su.MEDICAID_ID AS PATIENTMEDICAIDID, su.CLIENT_ID_CUSTOM1 AS PATIENTOTHERID " +
			"FROM STX.CLIENTS cl, STX.CLIENTS_SUPP su \n" +
			"WHERE cl.ACCOUNT = '%s' AND cl.CLIENTKEY = su.CLIENTKEY\n" +
			"AND su.MEDICAID_ID IS NOT NULL \n" +
			"AND su.CLIENT_ID_CUSTOM1 IS NOT NULL " +
			"AND LENGTH(TRIM(TRANSLATE(LOC , ' +-.0123456789',' '))) IS NULL " +
			"AND cl.end_date > sysdate " +
			"AND ROWNUM <= 100";
	public String OpenEvvClientSql = "select LOC as ClientID, " +
			"su.MEDICAID_ID AS PATIENTMEDICAIDID, su.CLIENT_ID_CUSTOM1 AS PATIENTOTHERID " +
			"FROM STX.CLIENTS cl, STX.CLIENTS_SUPP su \n" +
			"WHERE cl.ACCOUNT = '%s' AND cl.CLIENTKEY = su.CLIENTKEY\n" +
			"AND su.CLIENT_ID_CUSTOM1 IS NOT NULL " +
			"AND LENGTH(TRIM(TRANSLATE(LOC , ' +-.0123456789',' '))) IS NULL " +
            "AND LENGTH(LOC) = 5 " +
			"AND cl.end_date > sysdate " +
			"AND ROWNUM <= 100";
    public String OpenEvvClientSql_Vermont = "select LOC as ClientID, " +
            "su.MEDICAID_ID AS MEDICAID_ID, su.CLIENT_ID_CUSTOM1 AS CLIENT_ID_CUSTOM1 " +
            "FROM STX.CLIENTS cl, STX.CLIENTS_SUPP su \n" +
            "WHERE cl.ACCOUNT = '%s' AND cl.CLIENTKEY = su.CLIENTKEY\n" +
            "AND su.MEDICAID_ID IS NOT NULL \n" +
            "AND su.CLIENT_ID_CUSTOM1 IS NOT NULL AND LENGTH(LOC) =7  " +
            "AND cl.end_date > sysdate " +
            "AND ROWNUM <= 100";
	public String random_Worker_AltEVVGeneric =
			"select wo.STX_ID as EmployeeIdentifier, " +
					"su.WORKER_ID_CUSTOM1 as StaffOtherId, su.WORKER_SSN " +
					"FROM STX.WORKERS wo, stx.WORKERS_SUPP su  " +
					"WHERE wo.ACCOUNT = '%s' AND wo.WORKERKEY = su.WORKERKEY " +
					"AND wo.STX_ID IS NOT NULL " +
					"AND su.WORKER_ID_CUSTOM1 IS NOT NULL " +
					"AND wo.end_date > sysdate " +
					"AND ROWNUM <= 100";
	String selectLOCInbox =
			"select Error_code, LOC from inbox.clients where client_ssn ='%s'";
	String claimValidationSql =
			"select payer_name as Payer, provider_id as ProviderID, provider_id_typ_qlfr as ProviderQualifier," +
					"visitkey as VisitKey,"
					+ "visit_tz_name as VisitTimeZone,visit_found_ind as VisitFound"
					+ ",client_id as PatientID,dln as DLN , icn as ICN,bill_unit_count as Units ,modifier1 as Modifier1,"
					+ "modifier2 as Modifier2,modifier3 as Modifier3,modifier4 as Modifier4 from iodata.intf_rsp_txn_claim_stack where INTF_REQ_TXN_ID='%s'";
	String clientAddressSql_AltEVVMolina =
			"select Error_code, addr1 as ClientAddressLine1,addr2 as ClientAddressLine2, state as ClientState, city as ClientCity" +
					", zip_code as ClientZip, county as ClientCounty, latitude as ClientAddressLatitude, longitude as ClientAddressLongitude, addr_type_qlfr as ClientAddressType"
					+ " from inbox.clients_address where LOC = '%s' and addr1='%s'";
	String clientAddressSql_AltEVVGenric =
			"select Error_code, addr1 as ClientAddressLine1,addr2 as ClientAddressLine2, state as ClientState, city as ClientCity" +
					", zip_code as ClientZip, county as ClientCounty, latitude as ClientAddressLatitude, longitude as ClientAddressLongitude, addr_type_qlfr as ClientAddressType"
					+ " from inbox.clients_address where LOC = '%s' and addr1='%s'";
	String stxClientAddressSql_AltEVVGenric =
			"select addr1 as ClientAddressLine1,addr2 as ClientAddressLine2, state as ClientState, city as ClientCity" +
					", zip_code as ClientZip, county as ClientCounty, addr_type_qlfr as ClientAddressType"
					+ " from stx.clients_address where LOC = '%s' and addr1='%s'";
	String clientAddressSql_OpenEVV =
			"select Error_Code, addr1 as ClientAddressLine1, addr2 as ClientAddressLine2, state as ClientState, city as ClientCity, zip_code as ClientZip"
					+ " from inbox.clients_address where LOC = '%s' and addr1='%s'";
	String StxclientAddressSql_OpenEVV =
			"select addr1 as ClientAddressLine1, addr2 as ClientAddressLine2, state as ClientState, city as ClientCity, zip_code as ClientZip"
					+ " from inbox.clients_address where LOC = '%s' and addr1='%s'";
	String inboxAniOpenevvSql =
			"select Error_code as error_code, LOC as ClientID, ANI as ClientPhone, description as ClientPhoneType"
					+ " from inbox.ani where LOC = '%s' and ANI='%s'";
	String stxAniOpenevvSql =
			"select LOC as ClientID, ANI as ClientPhone, description as ClientPhoneType"
					+ " from stx.ani where LOC = '%s' and ANI='%s'";
	String inboxClientOpenevvSql =
			"select Error_code, LOC as ClientID, client_ssn as ClientSSN, f_name as ClientFirstName," +
					"m_name as ClientMiddleName,l_name as ClientLastName," +
					"client_id_custom1 as RecipientIDCustom1, account as Account," +
					"state as ClientState,city as ClientCity,zip_code as ClientZip,sex as ClientGender,medicaid_id as ClientMedicaidID," +
					"e_mail as ClientEmailAddress, marital_status_code as ClientMaritalStatus," +
					"addr1 as ClientAddressLine1, addr2 as ClientAddressLine2, name_suffix as ClientSuffix ,DOB as ClientBirthDate," +
					"SERVICE as Service,SPV as Coordinator, addr_type_qlfr as ClientAddressType from inbox.clients where Loc='%s' and f_name= '%s' " +
					"AND MEDICAID_ID = '%s'";
	String inboxClientAltevvMolinaSql =
			"select Error_code as error_code, LOC as ClientID, client_ssn as ClientSSN, f_name as ClientFirstName, m_name as ClientMiddleInitial," +
					"l_name as ClientLastName, medicaid_id as ClientIdentifier from inbox.clients where Loc='%s' and f_name= '%s'";
	String stxClientAltEVVmolinaSql =
			"select LOC as ClientID, CLIENT_VERSION_NUMBER as SequenceID, f_name as ClientFirstName, m_name as ClientMiddleInitial," +
					"l_name as ClientLastName, f_name as ClientFirstName from stx.clients where Loc='%s' and f_name= '%s'";
	String stxClientSql_OhioV2 =
			"select  LOC as ClientID, ACCOUNT as BusinessEntityID, F_NAME as PatientFirstName,"
					+ "L_Name as PatientLastName, client_version_number as SequenceID from stx.clients where client_version_number ='%s' and ACCOUNT='%s'";
	String stxaccountsspvClientSql_OpenEvv =
			"select ACCOUNT as Account, SPV as Coordinator"
					+ " from stx.accounts_spv where ACCOUNT ='%s' and SPV='%s'";
	String inboxXrefSql =
			"select Error_code , LOC as ClientID, account as Account, CLIENT_ID_QLFR as ClientIDQualifier,"
					+ " WORKER_ID_QLFR as EmployeeQualifier, WORKER_ID as EmployeeID, SERVICE as Service, BEG_DATE as XRefStartDate, END_DATE as XRefEndDate "
					+ "from inbox.xref_services where LOC='%s' and WORKER_ID = '%s'";
	String stxXrefSql =
			"select LOC as ClientID, account as Account, SERVICE as Service, BEG_DATE as XRefStartDate, END_DATE as XRefEndDate"
					+ " from stx.xref_services where LOC='%s' and stx_id='%s'";
	String stxAppUsersSql =
			"select Account as Account, user_f_name as ClientDesigneeFirstName"
					+ ", user_l_name as ClientDesigneeLastName, username as ClientDesigneeEmail"
					+ " from stx.app_users where USERNAME ='%s' and user_f_name='%s'";
	String iodataOhioSql =
			"select intf_req_sk as intf_req_sk, intf_req_id as intf_req_id from iodata.intf_req where intf_req_id ='%s'";
	String inboxClientContactSql_AltEVVGenric =
			"select LOC as ClientID, ERROR_CODE as error_code, L_NAME as ClientContactLastName,"
					+ " F_NAME as ClientContactFirstName,E_MAIL as ClientContactEmailAddress, ADDR1 as ClientContactAddressLine1, ADDR2 as ClientContactAddressLine2,"
					+ " CITY as ClientContactCity, STATE as ClientContactState,ZIP_CODE as ClientContactZip from inbox.clients_contact where LOC= '%s' and F_NAME='%s'";

	//----------------------------------------------------Worker------------------------------------
	String stxClientContactSql_AltEVVGenric =
			"select LOC as ClientID, L_NAME as ClientContactLastName,"
					+ " F_NAME as ClientContactFirstName,E_MAIL as ClientContactEmailAddress, ADDR1 as ClientContactAddressLine1, ADDR2 as ClientContactAddressLine2,"
					+ " CITY as ClientContactCity, STATE as ClientContactState,ZIP_CODE as ClientContactZip from stx.clients_contact where LOC= '%s' and F_NAME='%s'";
	String inboxClientContactSql_AltEVVmolina =
			"select LOC as ClientID, ERROR_CODE as error_code, L_NAME as ClientContactLastName,"
					+ " F_NAME as ClientContactFirstName,E_MAIL as ClientContactEmailAddress, ADDR1 as ClientContactAddressLine1, ADDR2 as ClientContactAddressLine2,"
					+ " CITY as ClientContactCity, STATE as ClientContactState,ZIP_CODE as ClientContactZip from inbox.clients_contact where LOC= '%s' and F_NAME='%s'";
	String stxClientContactSql_AltEVVMolina =
			"select LOC as ClientID, L_NAME as ClientContactLastName,"
					+ " F_NAME as ClientContactFirstName,E_MAIL as ClientContactEmailAddress, ADDR1 as ClientContactAddressLine1, ADDR2 as ClientContactAddressLine2,"
					+ " CITY as ClientContactCity, STATE as ClientContactState,ZIP_CODE as ClientContactZip from stx.clients_contact where LOC= '%s' and F_NAME='%s'";
	String inboxClientmember =
			"select Error_code, LOC as ClientID, client_ssn as ClientSSN, f_name as ClientFirstName," +
					"l_name as ClientLastName, sex as ClientGender, marital_status_code as ClientMaritalStatus,"
					+ " name_suffix as ClientSuffix ,DOB as ClientBirthDate  from inbox.clients where Loc='%s' and f_name= '%s'";
	String inboxClientContactSql_member =
			"select ERROR_CODE as error_code, L_NAME as ClientContactLastName,"
					+ " F_NAME as ClientContactFirstName,E_MAIL as ClientContactEmailAddress, ADDR1 as ClientContactAddressLine1, ADDR2 as ClientContactAddressLine2,"
					+ " CITY as ClientContactCity, STATE as ClientContactState,ZIP_CODE as ClientContactZip from inbox.clients_contact where LOC= '%s' and F_NAME='%s'";
	String stxClientContactSql_member =
			"select  L_NAME as ClientContactLastName,"
					+ " F_NAME as ClientContactFirstName,E_MAIL as ClientContactEmailAddress, ADDR1 as ClientContactAddressLine1, ADDR2 as ClientContactAddressLine2,"
					+ " CITY as ClientContactCity, STATE as ClientContactState,ZIP_CODE as ClientContactZip from stx.clients_contact where LOC= '%s' and F_NAME='%s'";
	//Pending
	String inboxAuthrization_Member =
			"select Error_code, loc as ClientID, end_date as end_date, Beg_date as Beg_date, PROVIDER_ID as ProviderID,payor_id as PayerID"
					+ " from inbox.authorizations where LOC ='%s' and payor_id ='%s'";
	String stxAuthrization_Member =
			"select loc as ClientID, end_date as end_date, Beg_date as Beg_date, PROVIDER_ID as ProviderID,payor_id as PayerID"
					+ " from inbox.authorizations where LOC ='%s' and payor_id ='%s'";
	String inboxAuthLimit_member =
			"select Error_code, PROGRAM as PayerProgram, MODIFIER1 as Modifier1, MODIFIER2 as Modifier2, MODIFIER3 as Modifier3, MODIFIER4 as Modifier4 "
					+ "from inbox.auth_limits where authkey in (select authkey from inbox.authorizations where LOC ='%s' and payor_id ='%s')";
	String clientAddressSql_Member =
			"select Error_code, addr1 as ClientAddressLine1,addr2 as ClientAddressLine2, state as ClientState, city as ClientCity" +
					", zip_code as ClientZip, county as ClientCounty,  addr_type_qlfr as ClientAddressType"
					+ " from inbox.clients_address where LOC = '%s' and addr1='%s'";
	String stxclientAddressSql_Member =
			"select addr1 as ClientAddressLine1,addr2 as ClientAddressLine2, state as ClientState, city as ClientCity" +
					", zip_code as ClientZip, county as ClientCounty,  addr_type_qlfr as ClientAddressType"
					+ " from stx.clients_address where LOC = '%s' and addr1='%s'";
	String stxClientContactSql =
			"select LOC as ClientID, ERROR_CODE as error_code, L_NAME as ClientContactLastName, F_NAME as ClientContactFirstName"
					+ "from stx.clients_contact where CLIENTKEY in (select CLIENTKEY from stx.clients where LOC = '%s' and F_NAME ='%s')";
	String inboxAuthLimit_Ohio =
			"select Error_code, PROGRAM as PayerProgram, SERVICE as ProcedureCode"
					+ " from inbox.auth_limits where authkey in (select authkey from inbox.authorizations where LOC ='%s' and Payor_id='%s')";
	String stxAuthLimit_Ohio =
			"select PROGRAM as PayerProgram, SERVICE as ProcedureCode"
					+ " from stx.auth_limits where AUTH_ID in (select AUTH_ID from stx.authorizations where LOC ='%s' and Payor_id='%s')";
	String inboxAuthLimit_AltEvvMolina =
			"select error_code, SERVICE as ProcedureCode, PROGRAM as PayerProgram "
					+ " from inbox.auth_limits where authkey in (select authkey from inbox.authorizations where LOC ='%s' and payor_id ='%s')";
	String stxAuthLimit_AltevvMolina =
			"select PROGRAM as PayerProgram, SERVICE as ProcedureCode"
					+ " from stx.auth_limits where AUTH_ID in (select AUTH_ID from stx.authorizations where LOC ='%s' and payor_id='%s')";
	String inboxAuthLimit_OpenEvv =
			"select ERROR_CODE as error_code, PROGRAM as PayerProgram"
					+ " from inbox.auth_limits where authkey in (select AUTHKEY from inbox.authorizations where CLIENT_ID ='%s')";
	String stxAuthLimit_OpenEVV =
			"select PROGRAM as PayerProgram"
					+ " from stx.auth_limits where AUTH_ID in (select AUTH_ID from stx.authorizations where AUTH_REF_NUMBER ='%s' and payor_id ='%s')";
	String stxAuthorization_ClientDiagnosis =
			"select DIAGNOSIS_CODE as ClientDiagnosisCode"
					+ " from stx.authorizations where loc='%s'";
	String inboxWorker_OpenEvv =
			"select PAYRATE as PayRate, account as Account, stx_id as EmployeePIN, l_name as EmployeeLastName, F_NAME as EmployeeFirstName, m_initial as EmployeeMiddleInitial,"
					+ " dept as Department, w_type as EmployeeType, att_id as EmployeeID, Error_Code as error_code, discipline as Discipline, e_mail as EmployeeEmailAddress,"
					+ "addr1 as EmployeeAddress1, addr2 as EmployeeAddress2, city as EmployeeCity,  state as EmployeeState, zip_code as EmployeeZipCode, phone as EmployeePhone, phone_other1 as EmployeeAltPhone,"
					+ " phone_other2 as EmployeeAltPhone2, worker_id_custom1 as EmployeeIDCustom1 ,worker_ssn as EmployeeSocialSecurity, worker_id_custom2 as EmployeeIDCustom2 "
					+ "from inbox.workers where STX_ID='%s' and F_NAME='%s'";
	String StxWorker_OpenEvv =
			"select Account as Account,Dept as Department,W_TYPE as EmployeeType, l_name as EmployeeLastName, F_NAME as EmployeeFirstName from stx.workers where STX_ID='%s' and F_NAME='%s'";
	String inboxWorker_AltEvvMolina =
			"select stx_id as EmployeeIdentifier, l_name as EmployeeLastName, F_NAME as EmployeeFirstName, Error_Code as error_code, worker_api as EmployeeAPI,"
					+ "e_mail as EmployeeEmail, worker_ssn as EmployeeSSN, worker_id_custom1 as EmployeeOtherID, discipline as EmployeePosition from inbox.workers where WORKER_VERSION_NUMBER='%s' and L_Name='%s'";
	String StxAppUserEmp =
			"select Account as Account, USER_l_name as EmployeeLastName, USER_F_NAME as EmployeeFirstName from stx.app_users where USERNAME='%s' and Account='%s'";
	String stxWorkerSupp =
			"select WORKER_SSN as EmployeeSocialSecurity, ADDR2 as EmployeeAddress2, ADDR1 as EmployeeAddress1, WORKER_API as EmployeeAPI,"
					+ " worker_beg_date as EmployeeHireDate, worker_end_date as EmployeeEndDate  from stx.workers_supp where WORKER_SSN='%s'";
	String stxWorkerSupp_molina =
			"select WORKER_SSN as EmployeeSSN, WORKER_API as EmployeeAPI, discipline as EmployeePosition, "
					+ " e_mail as EmployeeEmail, worker_manager_e_mail as EmployeeManagerEmail  from stx.workers_supp where WORKER_SSN='%s'";
	String stxSchedule_OpenEvv =
			"select account as Account, stx_id as EmployeePIN, loc as ClientID, payrate as PayRate, "
					+ "AR_NO as Arnumber, BILLCODE as Billcode from stx.schedule where STX_id ='%s'";
	String stxAccountinfo =
			"select Account, EFFECTIVE_BEG_DATE, EFFECTIVE_END_DATE from stx.accounts_info where account='%s'";
	String stxprovider =
			"select PROVIDER_ID from stx.accounts_interfaces where account='%s'";
	String visitclaimStatus =
			"select lib.getvisitstatus_custom('%s')from dual";
	String stxAccountprovider =
			"select PROVIDER_ID_QLFR as ProviderQualifier from stx.accounts_interfaces where PROVIDER_ID='%s'";
	String stxAccountsWeb =
			"Select WEBUSER as WebUsername, WEBPASS as WebPassword from stx.accounts_web where account='%s'";
	String stxAccounts_csv =
			"select  COMPNAME as ProviderName, PROVIDER_NAME as ProviderName, PROVIDER_ID as ProviderID, ADDR1 as AddressLine1, "
					+ "ADDR2 as AddressLine2,CITY as AddressCity, ZIP_CODE as AddressZip, STATE as AddressState, CONTACT_F_NAME as PrimaryContactFirstName,"
					+ " CONTACT_L_NAME as PrimaryContactLastName from stx.accounts where provider_id='%s'";
	String inboxprovider =
			"select ERROR_CODE as ERROR_CODE, COMPNAME as ProviderName, provider_id_qlfr as ProviderQualifier, "
					+ "PROVIDER_ID as ProviderID, PAYOR_ID as PayerID, ADDR1 as AddressLine1, ADDR2 as AddressLine2, CITY as AddressCity, ZIP_CODE as AddressZip, "
					+ "STATE as AddressState, CONTACT_F_NAME as PrimaryContactFirstName, CONTACT_L_NAME as PrimaryContactLastName, E_MAIL as AgencyEmail,"
					+ " federal_id as TaxID, fax as ProviderFax, npi as ProviderNPI, api as ProviderAPI from inbox.providers where provider_id='%s' and COMPNAME='%s'";
	String inboxproviderTaxonomy =
			"select Error_code, PROVIDER_TAXONOMY_CODE as ProviderTaxonomy from inbox.providers where PROVIDER_ID='%s'";
	String inboxproviderupdated =
			"select Error_code, PROVIDER_TAXONOMY_CODE as ProviderTaxonomy, AUTH_ENABLED as ProviderRequireAuth,"
					+ "PROVIDER_BEG_DATE as ProviderDateBegin, SUSP_DATE as SuspensionDate, TERM_DATE as TerminationDate from inbox.providers where PROVIDER_ID='%s'";
	String inboxprovider_without_nonmandate =
			"select ERROR_CODE as ERROR_CODE, COMPNAME as ProviderName, provider_id_qlfr as ProviderQualifier, "
					+ "PROVIDER_ID as ProviderID, PAYOR_ID as PayerID, ADDR1 as AddressLine1, CITY as AddressCity, ZIP_CODE as AddressZip, "
					+ "STATE as AddressState, CONTACT_F_NAME as PrimaryContactFirstName, CONTACT_L_NAME as PrimaryContactLastName,"
					+ " E_MAIL as AgencyEmail from inbox.providers where provider_id='%s' and COMPNAME='%s'";
	String stxAccounts_info =
			"Select compname As ProviderName, addr1 AS AddressLine1, addr2 AS AddressLine2, city AS AddressCity, state AS AddressState, zip_code AS AddressZip, county AS County, phone AS AgencyPhone, "
					+ "e_mail AS AgencyEmail, contact_l_name AS PrimaryContactLastName , contact_f_name AS PrimaryContactFirstName, fax AS ProviderFax, npi AS ProviderNPI,"
					+ "api AS ProviderAPI from stx.accounts_info where compname='%s'";
	String stxAccouts_interfaces =
			"select Provider_id_qlfr AS ProviderQualifier,provider_id AS ProviderID, provider_dba_name AS ProviderDoingBusinessAs"
					+ " from stx.Accounts_Interfaces where provider_id='%s'";
	String stxAccounts_TaxID =
			"select compname AS ProviderName,federal_id AS TaxID from stx.accounts where compname='%s'";
	//------------------------------------------------Visit method-----------------..............//
	String inboxAuthLimit_AltEvvGeneric =
			"select Error_code, PROGRAM as PayerProgram, SERVICE_CODE"
					+ " from inbox.auth_limits where authkey in (select authkey from inbox.authorizations where LOC ='%s' and payor_id ='%s')";
	String stxAuthLimit_AltevvGeneric =
			"select PROGRAM as PayerProgram, SERVICE as ProcedureCode"
					+ " from stx.auth_limits where AUTH_ID in (select AUTH_ID from stx.authorizations where LOC ='%s' and payor_id='%s')";
	String inboxClientAltEVVGenericSql =
			"select Error_code as error_code, LOC as ClientID, client_ssn as ClientSSN, f_name as ClientFirstName, m_name as ClientMiddleInitial," +
					"l_name as ClientLastName, medicaid_id as ClientMedicaidID from inbox.clients where Loc='%s' and f_name= '%s' " +
					"AND ACCOUNT = '%s'";
	String inboxClientAltEVVGenericSqlWithoutClientID =
			"select Error_code as error_code, client_ssn as ClientSSN, f_name as ClientFirstName, m_name as ClientMiddleInitial," +
					"l_name as ClientLastName, medicaid_id as ClientMedicaidID from inbox.clients where f_name= '%s'  and l_name= '%s'" +
					"AND ACCOUNT = '%s'";
	String stxClientAltEVVGenericSql =
			"select LOC as ClientID, CLIENT_VERSION_NUMBER as SequenceID, f_name as ClientFirstName, m_name as ClientMiddleInitial," +
					"l_name as ClientLastName, f_name as ClientFirstName from stx.clients " +
					"where Loc='%s' and f_name= '%s' AND CLIENT_VERSION_NUMBER IS NOT NULL";
	String inboxWorker_AltEVVGeneric =
            "select l_name as EmployeeLastName, F_NAME as EmployeeFirstName, Error_Code as error_code,"
					+ "e_mail as EmployeeEmail, worker_ssn as EmployeeSSN, worker_id_custom1 as EmployeeOtherID, discipline as EmployeePosition from inbox.workers where WORKER_VERSION_NUMBER='%s' and L_Name='%s'";
	String stxWorker_AltEVVGeneric =
            "select l_name as EmployeeLastName, F_NAME as EmployeeFirstName from stx.workers where WORKER_VERSION_NUMBER='%s' and L_Name='%s'";
	String inboxVisitAltEvvGeneric =
			"select SID, VISITKEY as VISITKEY, visit_id as VisitOtherID, visit_version_number as SequenceID, worker_id as EmployeeIdentifier,"
					+ " error_code, WORKER_ID_QLFR as EmployeeQualifier, client_id as ClientIdentifier, CLIENT_ID_QLFR as ClientIDQualifier, "
					+ "PROC_CODE as ProcedureCode, VISIT_MEMO as Memo, PAYOR_PROGRAM as PayerProgram, tzname as VisitTimeZone "
					+ "from inbox.visits where visit_id='%s' and visit_version_number='%s'";
	String stxVisitAltEvvGeneric =
			"select VISITKEY as VISITKEY, visit_id as VisitOtherID, visit_version_number as SequenceID, STX_ID as EmployeeIdentifier "
					+ "from stx.visits where visit_id='%s' and visit_version_number='%s'";
	String inboxVisitChangeGeneric =
			"select error_code as error_code, visit_version_number as SequenceID,"
					+ "reason_code as ReasonCode, resolution_code as ResolutionCode,"
					+ " REASON_CODE_MEMO as ChangeReasonMemo, VISIT_CHANGE_USERNAME as ChangeMadeBy"
					+ " from inbox.visits_changes where visit_id='%s' and visit_version_number='%s'";
	String stxVisitChangeLogGeneric =
			"select reason_code as ReasonCode, resolution_code as ResolutionCode,"
					+ " REASON_CODE_MEMO as ChangeReasonMemo"
					+ " from stx.visits_log where visit_id='%s' and visit_version_number='%s'";
	String inboxVisitCalls =
			"select error_code as error_code, Ani as OriginatingPhoneNumber, call_id as CallExternalID, Service as ProcedureCode,"
					+ "call_username as MobileLogin, latitude as CallLatitude, longitude  as CallLongitude,"
					+ " stx_id as TelephonyPIN, CALL_LOCATION as Location from inbox.calls where visit_id='%s' and call_assignment_qlfr='%s'";
	String stxVisitCalls =
			"select Ani as OriginatingPhoneNumber, call_id as CallExternalID, Service as ProcedureCode,"
					+ "call_username as MobileLogin, latitude as CallLatitude, longitude  as CallLongitude,"
					+ " stx_id as TelephonyPIN, CALL_LOCATION as Location from stx.calls where visit_id='%s' and call_id='%s'";
	String inboxVisitAltEvvMolina =
			"select VISITKEY as VISITKEY, visit_id as VisitOtherID, visit_version_number as SequenceID, worker_id as EmployeeIdentifier,"
					+ " error_code as error_code,WORKER_ID_QLFR as EmployeeQualifier, client_id as ClientIdentifier, CLIENT_ID_QLFR as ClientIDQualifier, "
					+ " tzname as VisitTimeZone,SERVICE as ProcedureCode, VISIT_MEMO as Memo, PAYOR_PROGRAM as PayerProgram "
					+ "from inbox.visits where visit_id='%s' and visit_version_number='%s'";
	String stxVisitAltEVVMolina =
			"select VISITKEY as VISITKEY, visit_id as VisitOtherID, visit_version_number as SequenceID, STX_ID as EmployeeIdentifier "
					+ "from stx.visits where visit_id='%s' and visit_version_number='%s'";
	String inboxVisitChangeMolina =
			"select error_code as error_code, visit_version_number as SequenceID,"
					+ "reason_code as ReasonCode, resolution_code as ResolutionCode,"
					+ " REASON_CODE_MEMO as ChangeReasonMemo"
					+ " from inbox.visits_changes where visit_id='%s' and visit_version_number='%s'";
	String stxVisitChangeLogMolina =
			"select reason_code as ReasonCode, resolution_code as ResolutionCode,"
					+ " REASON_CODE_MEMO as ChangeReasonMemo"
					+ " from stx.visits_log where visit_id='%s' and visit_version_number='%s'";
	String inboxVisitOhio =
			"select  PAYOR_NAME as Payer, PAYOR_PROGRAM as PayerProgram, error_code as error_code, VISITKEY as VISITKEY, visit_id as VisitOtherID, visit_version_number as SequenceID"
					+ " from inbox.visits where visit_id='%s' and visit_version_number='%s'";
	String stxVisitOhio =
			"select  PROGRAM as PayerProgram, VISITKEY as VISITKEY, visit_id as VisitOtherID, visit_version_number as SequenceID"
					+ " from stx.visits where visit_id='%s' and visit_version_number='%s'";
	String inboxvisitkey =
			"select VISITKEY from inbox.visits where visit_id='%s'";
	String inboxVisitException =
			"select Error_code, exception_id as exception_id, exception_ack_ind as ExceptionAcknowledged from inbox.visits_exceptions where visit_id='%s'";
	String inboxVisitSchedule =
			"select ERROR_CODE, CLIENT_ID as ClientID, CLIENT_ID_QLFR as ClientIDQualifier, WORKER_ID as EmployeeIdentifier, WORKER_ID_QLFR as EmployeeQualifier from inbox.schedule where sid ='%s'";
	String sql_memberImportSTX = "select  clientsupp.client_ssn as clientSsn, "
			+ "clientsupp.mrn as ClientMedicalRecordNum, clientsupp.medicaid_id as clientCustomID,"
			+ "clientsupp.client_id_custom1 as clientOtherID,"
			+ " clients.f_name as clientFirstName, clientsupp.addr_type_qlfr"
			+ " as clientAddressType, clientsupp.addr1 as clientAddressLine1" +
			", clientsupp.addr2 as clientAddressLine2,  clientsupp.city as clientCity"
			+ ", clientsupp.state as clientState, clientsupp.zip_code as clientZip, clients.m_name as clientMiddleInitial, "
			+ " clients.l_name as clientLastName, "
			+ " auth.payor_id as payerId"
			//+" ,clients.Loc as LOC "
			+ ",  auth_lim.service as payerService, auth_lim.program as payerProgram"
			+ " from STX.clients_supp clientsupp LEFT JOIN STX.clients clients on clients.clientkey = clientsupp.clientkey"
			+ " LEFT JOIN STX.authorizations auth on clients.loc = auth.loc LEFT JOIN STX.auth_limits auth_lim on auth.auth_id = auth_lim.auth_id"
			+ " where clientsupp.client_ssn='%s'";
	String sql_memberImportSTXMemberMolina = "select  clientsupp.client_ssn as clientSsn, "
			+ " clientsupp.medicaid_id as clientCustomID,"
			+ "clientsupp.client_id_custom1 as clientOtherID,"
			+ " clients.f_name as clientFirstName, clientsupp.addr_type_qlfr"
			+ " as clientAddressType, clientsupp.addr1 as clientAddressLine1" +
			", clientsupp.addr2 as clientAddressLine2,  clientsupp.city as clientCity"
			+ ", clientsupp.state as clientState, clientsupp.zip_code as clientZip, clients.m_name as clientMiddleInitial, "
			+ " clients.l_name as clientLastName, "
			+ " auth.payor_id as payerId"
			+ " from STX.clients_supp clientsupp LEFT JOIN STX.clients clients on clients.clientkey = clientsupp.clientkey"
			+ " LEFT JOIN STX.authorizations auth on clients.loc = auth.loc LEFT JOIN STX.auth_limits auth_lim on auth.auth_id = auth_lim.auth_id"
			+ " where clientsupp.client_ssn ='%s'";
	String sql_GetProviderIdIndiana = "select  provider_id from stx.accounts_interfaces where provider_id is not null"
			+ " and account in(select account  from stx.accounts_groups_setup where groupkey='%s' and "
			+ "account in( select account from stx.app_users where expire_date > (SELECT  CURRENT_DATE FROM DUAL)))"
			+ "and rownum = 1";
	String payerCodeValidation_Ohio = "SELECT SERVICE as ProcedureCode FROM stx.payor_data_validation where PROC_CODE='%s' and Program='%s' and payor_ID='%s'"; //old : 	String payerCodeValidation_Ohio= "SELECT SERVICE as ProcedureCode FROM stx.payor_data_validation where PROC_CODE='%s' and Program='%s' and payor_ID='%s' and SERVICE = '%s'";
	String payerCodeValidation_Altevv = "SELECT SERVICE as ProcedureCode FROM stx.payor_data_validation where PROC_CODE='%s' and Program='%s' and payor_ID='%s'";
	String random_ClientAltEVVGenericSql_Colorado = "select LOC as ClientID, " +
            "su.MEDICAID_ID AS PATIENTMEDICAIDID, su.CLIENT_ID_CUSTOM1 AS PATIENTOTHERID, su.CLIENT_ID_CUSTOM2  " +
			"FROM STX.CLIENTS cl, STX.CLIENTS_SUPP su \n" +
			"WHERE cl.ACCOUNT = '%s' AND cl.CLIENTKEY = su.CLIENTKEY\n" +
			"AND cl.end_date > sysdate " +
			"AND ROWNUM <= 100";
	String random_Worker_AltEVVGeneric_PA =
			"select wo.STX_ID as santrax, " +
					"su.WORKER_ID_CUSTOM1 as custom1 " +
					"FROM STX.WORKERS wo, stx.WORKERS_SUPP su  " +
					"WHERE wo.ACCOUNT = '%s' AND wo.WORKERKEY = su.WORKERKEY " +
					"AND wo.STX_ID IS NOT NULL AND su.WORKER_ID_CUSTOM1 IS NOT NULL " +
					"AND (LENGTH(su.WORKER_ID_CUSTOM1) < 7 ) " +
					"AND wo.end_date > sysdate  " +
					"AND ROWNUM <= 100";
	String inboxVisitAltEvvGeneric_Connecticut =
			"select SID, VISITKEY as VISITKEY, visit_id as VisitOtherID, visit_version_number as SequenceID, worker_id as EmployeeIdentifier,"
					+ " error_code, WORKER_ID_QLFR as EmployeeQualifier, client_id as ClientIdentifier, CLIENT_ID_QLFR as ClientIDQualifier, "
					+ "SERVICE as ProcedureCode, VISIT_MEMO as Memo, PAYOR_PROGRAM as PayerProgram, tzname as VisitTimeZone "
					+ "from inbox.visits where visit_id='%s' and visit_version_number='%s'";

	String stxEmployeeSSN = "select w.stx_id\n" +
			"from stx.workers w, stx.WORKERS_SUPP s \n" +
			"where w.WORKERKEY = s.WORKERKEY AND w.ACCOUNT = '%s'";

	String stxAppUsers = "SELECT * FROM stx.APP_USERS WHERE ACCOUNT = '%s' and USERNAME = '%s'";

	String stxMVVUsersREG = "SELECT * FROM stx.MVV_USERS_REG WHERE ACCOUNT = '%s' and MVV_USERNAME = '%s'";

	String ioData =
			"select VISIT_FOUND_IND from iodata.intf_rsp_txn_claim_stack where DLN = '%s' and ICN = '%s'";

	String verified_Visit =
			"SELECT stx.lib.GetVisitStatus_custom(v.visitkey), to_char(v.VISIT_DATE, 'YYYY-MM-DD')     as VISIT_DATE,to_char(v.VISIT_EDATE, 'YYYY-MM-DD')    as VISIT_EDATE, to_char(v.BEG_CALL_DTIME, 'YYYY-MM-DD') as BEG_CALL_DTIME, to_char(v.END_CALL_DTIME, 'YYYY-MM-DD') as END_CALL_DTIME, v.SERVICE, v.PAYOR_ID, v.BILL_HOURS, v.ACCOUNT, cs.medicaid_id, stx.lib.getVisitBillUnits(v.visitkey)   as bill_units FROM stx.visits PARTITION (visits_2019) v INNER JOIN STX.CLIENTS_SUPP cs ON cs.CLIENTKEY = v.CLIENTKEY WHERE v.account = '%s' AND stx.lib.GetVisitStatus_custom(v.visitkey) = 'Processed' and LENGTH(cs.medicaid_id) > 10 AND v.BEG_CALL_DTIME IS NOT NULL AND v.END_CALL_DTIME IS NOT NULL AND rownum = 1 AND stx.lib.getVisitBillUnits(v.visitkey) IS NOT null AND PAYOR_ID IS NOT NULL";

	String getProviderID =
			"SELECT avc.ws_authentication_username, avc.ws_authentication_pwd_hash, avc.account, ai.provider_id FROM stx.accounts_vendor_config avc JOIN stx.accounts_interfaces ai ON ai.account = avc.account WHERE ai.account = '%s' AND (end_date > sysdate OR end_date IS NULL)";

}