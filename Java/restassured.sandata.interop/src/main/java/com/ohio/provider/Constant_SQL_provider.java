package com.ohio.provider;

public  class Constant_SQL_provider {
	
	public String rowofprovider =
			"select * from stx.accounts where provider_id='%s'";
	
	public String getAccountFromProvider =
			"select account from stx.accounts where provider_id='%s'";

	public  String StatusCodeAuth = 
			"select distinct  au.status_code from intfstagedb.auth au where client_id='%s'";

	public  String StatusCodeClient = 
			"select distinct  cl.status_code from intfstagedb.client cl where client_id='%s'";

	public  String selectStatusCodeInbox =
			"select ERROR_CODE from inbox.clients where client_id_custom1 ='%s'";
	
	public  String selectLOCInbox =
			"select LOC from inbox.clients where client_ssn ='%s'";

	public  String selectxref_serivices =
			"select LOC,SID from inbox.xref_services where LOC='%s'";
	
	public  String claimValidationSql =
			"select payer_name as Payer, provider_id as ProviderID, provider_id_typ_qlfr as ProviderQualifier,"+
					"visitkey as VisitKey,"
					+ "visit_tz_name as VisitTimeZone,visit_found_ind as VisitFound"
					+ ",client_id as PatientID,dln as DLN , icn as ICN,bill_unit_count as Units ,modifier1 as Modifier1,"
					+"modifier2 as Modifier2,modifier3 as Modifier3,modifier4 as Modifier4 from iodata.intf_rsp_txn_claim_stack where INTF_REQ_TXN_ID='%s'";

	public  String claimValidationSqlAdj =
			"select payer_name as Payer, provider_id as ProviderID, provider_id_typ_qlfr as ProviderQualifier,"+
					"visitkey as VisitKey,visit_beg_adj_dtime as AdjInDateTime,visit_end_adj_dtime as AdjOutDateTime,"
					+ "visit_tz_name as VisitTimeZone,visit_found_ind as VisitFound"
					+ ",client_id as PatientID,dln as DLN , icn as ICN,bill_unit_count as Units ,modifier1 as Modifier1,"
					+"modifier2 as Modifier2,modifier3 as Modifier3,modifier4 as Modifier4 from iodata.intf_rsp_txn_claim_stack where INTF_REQ_TXN_ID='%s'";

	public  String clientAddressSql_AltEVVMolina =
			"select addr1 as ClientAddressLine1,addr2 as ClientAddressLine2, state as ClientState, city as ClientCity" + 
					", zip_code as ClientZip, county as ClientCounty, latitude as ClientAddressLatitude, longitude as ClientAddressLongitude, addr_type_qlfr as ClientAddressType"
					+ " from inbox.clients_address where LOC = '%s' and addr1='%s'";

	public  String clientAddressSql_Ohio3P =
			"select addr1 as PatientAddressLine1,addr2 as PatientAddressLine2, state as PatientState, city as PatientCity" + 
					", zip_code as PatientZip, addr_type_qlfr as PatientAddressType"
					+ " from inbox.clients_address where LOC = '%s' and addr1='%s'";

	public  String clientAddressSql_AltEVVGenric =
			"select addr1 as ClientAddressLine1,addr2 as ClientAddressLine2, state as ClientState, city as ClientCity" + 
					", zip_code as ClientZip, county as ClientCounty, latitude as ClientLatitude, longitude as ClientLongitude, addr_type_qlfr as ClientAddressType"
					+ " from inbox.clients_address where LOC = '%s' and addr1='%s'";

	public  String clientAddressSql_Member =
			"select addr1 as ClientAddressLine1,addr2 as ClientAddressLine2, state as ClientState, city as ClientCity" + 
					", zip_code as ClientZip, county as ClientCounty,  addr_type_qlfr as ClientAddressType"
					+ " from inbox.clients_address where LOC = '%s' and addr1='%s'";

	public  String clientAddressSql_OpenEVV =
			"select addr1 as ClientAddressLine1, addr2 as ClientAddressLine2, state as ClientState, city as ClientCity, zip_code as ClientZip"
					+ " from inbox.clients_address where LOC = '%s' and addr1='%s'";

	public  String inboxAniOpenevvSql =
			"select LOC as ClientID, ANI as ClientPhone, description as ClientPhoneType"
					+ " from inbox.ani where LOC = '%s' and ANI='%s'";

	public  String inboxClientOpenevvSql = 
			"select Error_code, LOC as ClientID, client_ssn as ClientSSN, f_name as ClientFirstName," + 
					"m_name as ClientMiddleName,l_name as ClientLastName," + 
					"client_id_custom2 as RecipientIDCustom2, client_id_custom1 as RecipientIDCustom1, account as Account," + 
					"state as ClientState,city as ClientCity,zip_code as ClientZip,sex as ClientGender,medicaid_id as ClientMedicaidID," + 
					"e_mail as ClientEmailAddress, marital_status_code as ClientMaritalStatus," + 
					"addr1 as ClientAddressLine1, addr2 as ClientAddressLine2, name_suffix as ClientSuffix ,DOB as ClientBirthDate," + 
					"dis_date as DischargeDate,SERVICE as Service, addr_type_qlfr as ClientAddressType from inbox.clients where Loc='%s' and f_name= '%s'";

	public  String inboxClientAltEVVGenericSql = 
			"select Error_code as error_code, LOC as ClientID, client_ssn as ClientSSN, f_name as ClientFirstName, m_name as ClientMiddleInitial,"+
					"l_name as ClientLastName, medicaid_id as ClientMedicaidID from inbox.clients where Loc='%s' and f_name= '%s'";

	public  String inboxClientAltevvMolinaSql = 
			"select Error_code as error_code, LOC as ClientID, client_ssn as ClientSSN, f_name as ClientFirstName, m_name as ClientMiddleInitial,"+
					"l_name as ClientLastName, medicaid_id as ClientMedicaidID from inbox.clients where Loc='%s' and f_name= '%s'";

	public  String stxClientSql_Ohio= 
			"select LOC as PatientID, clientkey as CLIENTKEY, ACCOUNT as BusinessEntityID, F_NAME as PatientFirstName,"
					+ "L_Name as PatientLastName, client_version_number as SequenceID from stx.clients where client_version_number ='%s' and ACCOUNT='%s'";

	public  String stxClientSql_OhioV2= 
			"select  LOC as LOC, ACCOUNT as BusinessEntityID, F_NAME as PatientFirstName,"
					+ "L_Name as PatientLastName, client_version_number as SequenceID from stx.clients where client_version_number ='%s' and ACCOUNT='%s'";

	public  String stxClientSuppSql_Ohio= 
			"select ADDR1 as PatientAddressLine1, ADDR2 as PatientAddressLine2, "
					+ "CITY as PatientCity, STATE as PatientState, ZIP_CODE as PatientZip "
					+ "from stx.clients_supp  where clientkey='%s'";

	public  String inboxClientsql_Ohio =
			"select ACCOUNT as BusinessEntityID, F_NAME as PatientFirstName, "
			+ "L_Name as PatientLastName, MEDICAID_ID as PatientMedicaidID, CLIENT_ID_CUSTOM1 as PatientOtherID, "
			+ "client_version_number as SequenceID, CLIENT_NEWBORN_IND as IsPatientNewborn"
					+ " from inbox.clients where F_NAME = '%s' and client_version_number='%s'";
	
	public  String stxClientSql_OpenEvv= 
			"select ACCOUNT as Account, LOC as ClientID, F_NAME as ClientFirstName,"
					+ "L_Name as ClientLastName from stx.clients where LOC ='%s' and L_Name='%s'";
	
	public  String inboxXrefSql = 
			"select Error_code, LOC as ClientID, account as Account, CLIENT_ID_QLFR as ClientIDQualifier,"
					+ " WORKER_ID_QLFR as EmployeeQualifier, WORKER_ID as EmployeeID, SERVICE as Service, BEG_DATE as XRefStartDate, END_DATE as XRefEndDate "
					+ "from inbox.xref_services where LOC='%s' and WORKER_ID = '%s'";

	public  String stxXrefSql = 
			"select LOC as ClientID, account as Account, SERVICE as Service, BEG_DATE as XRefStartDate, END_DATE as XRefEndDate"
					+ " from stx.xref_services where LOC='%s' and stx_id='%s'";

	public  String stxAppUsersSql=
			"select Account as Account, user_f_name as ClientDesigneeFirstName"
					+ ", user_l_name as ClientDesigneeLastName, username as ClientDesigneeEmail"
					+ " from stx.app_users where USERNAME ='%s' and user_f_name='%s'";

	public  String iodataOhioSql=
			"select intf_req_sk as intf_req_sk, intf_req_id as intf_req_id from iodata.intf_req where intf_req_id ='%s'";

	public  String inboxClientContactSql_AltEVVGenric= 
			"select LOC as ClientID, ERROR_CODE as error_code, L_NAME as ClientContactLastName,"
					+ " F_NAME as ClientContactFirstName,E_MAIL as ClientContactEmailAddress, ADDR1 as ClientContactAddressLine1, ADDR2 as ClientContactAddressLine2,"
					+ " CITY as ClientContactCity, STATE as ClientContactState,ZIP_CODE as ClientContactZip from inbox.clients_contact where LOC= '%s' and F_NAME='%s'";

	public  String inboxClientContactSql_AltEVVmolina= 
			"select LOC as ClientID, ERROR_CODE as error_code, L_NAME as ClientContactLastName,"
					+ " F_NAME as ClientContactFirstName,E_MAIL as ClientContactEmailAddress, ADDR1 as ClientContactAddressLine1, ADDR2 as ClientContactAddressLine2,"
					+ " CITY as ClientContactCity, STATE as ClientContactState,ZIP_CODE as ClientContactZip from inbox.clients_contact where LOC= '%s' and F_NAME='%s'";

	public  String inboxClientContactSql_member= 
			"select ERROR_CODE as error_code, L_NAME as ClientContactLastName,"
					+ " F_NAME as ClientContactFirstName,E_MAIL as ClientContactEmailAddress, ADDR1 as ClientContactAddressLine1, ADDR2 as ClientContactAddressLine2,"
					+ " CITY as ClientContactCity, STATE as ClientContactState,ZIP_CODE as ClientContactZip from inbox.clients_contact where LOC= '%s' and F_NAME='%s'";

	public  String stxClientContactSql=
			"select LOC as ClientID, ERROR_CODE as error_code, L_NAME as ClientContactLastName, F_NAME as ClientContactFirstName"
					+ "from stx.clients_contact where CLIENTKEY in (select CLIENTKEY from stx.clients where LOC = '%s' and F_NAME ='%s')";

	public  String inboxAuthLimit_member=
			"select PROGRAM as PayerProgram, MODIFIER1 as Modifier1, MODIFIER2 as Modifier2, MODIFIER3 as Modifier3, MODIFIER4 as Modifier4 "
					+ "from inbox.auth_limits where authkey in (select authkey from inbox.authorizations where LOC ='%s' and payor_id ='%s')";

	public  String inboxAuthLimit_AltEvvGeneric=
			"select PROGRAM as PayerProgram "
					+ " from inbox.auth_limits where authkey in (select authkey from inbox.authorizations where LOC ='%s' and payor_id ='%s')";

	public  String inboxAuthLimit_Ohio=
			"select PROGRAM as PayerProgram, SERVICE as ProcedureCode"
					+ " from inbox.auth_limits where authkey in (select authkey from inbox.authorizations where LOC ='%s' and SID='%s')";

	public  String inboxAuth_Ohio="select SID as SID from inbox.authorizations where LOC ='%s' and ACCOUNT='%s'";

	public  String stxAuthLimit_Ohio=
			"select PROGRAM as PayerProgram, SERVICE as ProcedureCode"
					+ " from stx.auth_limits where AUTH_ID in (select AUTH_ID from stx.authorizations where LOC ='%s' and Account='%s')";

	public  String inboxAuthLimit_AltEvvMolina=
			"select PROGRAM as PayerProgram "
					+ " from inbox.auth_limits where authkey in (select authkey from inbox.authorizations where LOC ='%s' and payor_id ='%s')";

	public  String inboxAuthLimit_OpenEvv=
			"select PROGRAM as PayerProgram "
					+ " from inbox.auth_limits where authkey in (select authkey from inbox.authorizations where LOC ='%s')";

	//Pending
	public  String inboxAuthrization_Member=
			"select loc as ClientID, end_date as end_date, Beg_date as Beg_date, PROVIDER_ID as ProviderID,payor_id as PayerID"
					+ " from inbox.authorizations where LOC ='%s' and payor_id ='%s'";

	//----------------------------------------------------Worker------------------------------------

	public  String inboxWorker_OpenEvv= 
			"select PAYRATE as PayRate, account as Account, stx_id as EmployeePIN, l_name as EmployeeLastName, F_NAME as EmployeeFirstName, m_initial as EmployeeMiddleInitial," 
					+ " dept as Department, w_type as EmployeeType, att_id as EmployeeID, Error_Code as error_code, discipline as Discipline, e_mail as EmployeeEmailAddress,"
					+"addr1 as EmployeeAddress1, addr2 as EmployeeAddress2, city as EmployeeCity,  state as EmployeeState, zip_code as EmployeeZipCode, phone as EmployeePhone, phone_other1 as EmployeeAltPhone,"
					+ " phone_other2 as EmployeeAltPhone2, worker_id_custom1 as EmployeeIDCustom1 ,worker_ssn as EmployeeSocialSecurity, worker_id_custom2 as EmployeeIDCustom2 "
					+ "from inbox.workers where STX_ID='%s' and Account='%s'";

	public  String inboxWorker_AltEVVGeneric= 
			"select stx_id as EmployeeIdentifier, l_name as EmployeeLastName, F_NAME as EmployeeFirstName, Error_Code as error_code," 
					+"e_mail as EmployeeEmail, worker_ssn as EmployeeSSN, worker_id_custom1 as EmployeeOtherID, discipline as EmployeePosition from inbox.workers where WORKER_VERSION_NUMBER='%s' and L_Name='%s'";

	public  String inboxWorker_AltEvvMolina= 
			"select stx_id as EmployeeIdentifier, l_name as EmployeeLastName, F_NAME as EmployeeFirstName, Error_Code as error_code, worker_api as EmployeeAPI,"
					+ "e_mail as EmployeeEmail, worker_ssn as EmployeeSSN, worker_id_custom1 as EmployeeOtherID, discipline as EmployeePosition from inbox.workers where WORKER_VERSION_NUMBER='%s' and L_Name='%s'";

	public  String inboxWorker_NAPohio= 
			"select stx_id as EmployeeIdentifier, l_name as EmployeeLastName, F_NAME as EmployeeFirstName, Error_Code as error_code, worker_api as EmployeeAPI,"
					+ "e_mail as EmployeeEmail, worker_ssn as EmployeeSSN, worker_id_custom1 as EmployeeOtherID, discipline as EmployeePosition from inbox.workers where e_mail='%s'";

	public  String inboxWorker_3P= 
			"select account as BusinessEntityID,  l_name as StaffLastName, F_NAME as StaffFirstName, att_id as StaffID, Error_Code as error_code, "
					+ "worker_ssn as StaffSSN from inbox.workers where worker_ssn='%s' and Account='%s'";

	public  String StxWorker_3P= 
			"select account as BusinessEntityID,  l_name as StaffLastName, F_NAME as StaffFirstName, att_id as StaffID, "
					+ "stx_id as StaffID from stx.workers where worker_version_number='%s' and Account='%s'";

	public  String StxAppUserEmp= 
			"select Account as Account, USER_l_name as EmployeeLastName, USER_F_NAME as EmployeeFirstName from stx.app_users where USERNAME='%s' and Account='%s'";

	public  String StxWorker_OpenEvv =
			"select Account as Account, USER_l_name as EmployeeLastName, USER_F_NAME as EmployeeFirstName from stx.worker where USERNAME='%s' and Account='%s'";

	public  String inboxCall= 
			"select Call_username as from inbox.calls where ";

	public  String  stxWorkerSupp=
			"select WORKER_SSN as EmployeeSocialSecurity, ADDR2 as EmployeeAddress2, ADDR1 as EmployeeAddress1, WORKER_API as EmployeeAPI,"
					+ " worker_beg_date as EmployeeHireDate, worker_end_date as EmployeeEndDate  from stx.workers_supp where WORKER_SSN='%s'";

	public  String  stxWorkerSupp_openevv=
			"select WORKER_SSN as EmployeeSSN, ADDR2 as EmployeeAddress2, ADDR1 as EmployeeAddress1, WORKER_API as EmployeeAPI,"
					+ " worker_beg_date as EmployeeHireDate, worker_end_date as EmployeeEndDate  from stx.workers_supp where WORKER_SSN='%s'";

	public  String  stxWorkerSupp_molina=
			"select WORKER_SSN as EmployeeSSN, WORKER_API as EmployeeAPI, discipline as EmployeePosition, "
					+ " e_mail as EmployeeEmail, worker_manager_e_mail as EmployeeManagerEmail  from stx.workers_supp where WORKER_SSN='%s'";

	public  String  stxWorkerSupp_3p=
			"select WORKER_SSN as StaffSSN, account as BusinessEntityID from stx.workers_supp where WORKER_SSN='%s'";

	public  String stxSchedule_OpenEvv= 
			"select account as Account, stx_id as EmployeePIN, loc as ClientID, payrate as PayRate, "
					+ "AR_NO as Arnumber, BILLCODE as Billcode from stx.schedule where STX_id ='%s'";

	public  String stxAccount=
			"select Account, PROVIDER_ID from stx.accounts_interfaces where account='%s'";
	
	public  String stxprovider=
			"select PROVIDER_ID from stx.accounts_interfaces where account='%s'";
	
	public  String visitclaimStatus=
			"select lib.getvisitstatus_custom('%s')from dual";
			
	public  String stxAccountprovider=
			"select PROVIDER_ID_QLFR as ProviderQualifier from stx.accounts_interfaces where PROVIDER_ID='%s'";

	public String stxAccountsWeb=
			"Select WEBUSER as WebUsername, WEBPASS as WebPassword from stx.accounts_web where account='%s'";
	
	
	public String 	stxAccounts_csv =
			"select  COMPNAME as ProviderName, PROVIDER_NAME as ProviderName, PROVIDER_ID as ProviderID, ADDR1 as AddressLine1, "
					+ "ADDR2 as AddressLine2,CITY as AddressCity, ZIP_CODE as AddressZip, STATE as AddressState, CONTACT_F_NAME as PrimaryContactFirstName,"
					+ " CONTACT_L_NAME as PrimaryContactLastName from stx.accounts where provider_id='%s'";

	public String 	inboxprovider=
			"select ERROR_CODE as ERROR_CODE, COMPNAME as ProviderName, provider_id_qlfr as ProviderQualifier, "
					+ "PROVIDER_ID as ProviderID, PAYOR_ID as PayerID, ADDR1 as AddressLine1, ADDR2 as AddressLine2, CITY as AddressCity, ZIP_CODE as AddressZip, "
					+ "STATE as AddressState, CONTACT_F_NAME as PrimaryContactFirstName, CONTACT_L_NAME as PrimaryContactLastName, E_MAIL as AgencyEmail,"
					+ " federal_id as TaxID, fax as ProviderFax, npi as ProviderNPI, api as ProviderAPI from inbox.providers where provider_id='%s' and COMPNAME='%s'";
	public String inboxproviderTaxonomy=
			"select PROVIDER_TAXONOMY_CODE as ProviderTaxonomy from inbox.providers where PROVIDER_ID='%s'";
	
	public String inboxproviderupdated=
			"select PROVIDER_TAXONOMY_CODE as ProviderTaxonomy, AUTH_ENABLED as ProviderRequireAuth,"
			+"PROVIDER_BEG_DATE as ProviderDateBegin, SUSP_DATE as SuspensionDate, TERM_DATE as TerminationDate from inbox.providers where PROVIDER_ID='%s'";

	public String 	inboxprovider_without_nonmandate=
			"select ERROR_CODE as ERROR_CODE, COMPNAME as ProviderName, provider_id_qlfr as ProviderQualifier, "
					+ "PROVIDER_ID as ProviderID, PAYOR_ID as PayerID, ADDR1 as AddressLine1, CITY as AddressCity, ZIP_CODE as AddressZip, "
					+ "STATE as AddressState, CONTACT_F_NAME as PrimaryContactFirstName, CONTACT_L_NAME as PrimaryContactLastName,"
					+ " E_MAIL as AgencyEmail from inbox.providers where provider_id='%s' and COMPNAME='%s'";
	
	public  String stxAccountInfoSql=
			"select Account as Account, compname as ProviderName"
					+ " addr2 as AddressLine2, ADDR1 as AddressLine1, CITY as AddressCity, ZIP_CODE as AddressZip, county as County, STATE as AddressState, "
					+ "phone as AgencyPhone, e_mail as AgencyEmail, CONTACT_L_NAME as PrimaryContactLastName, CONTACT_F_NAME as PrimaryContactFirstName, "
					+ "fax as ProviderFax, npi as NPI, api as Provider"
					+ " from stx.accounts_info where compname ='%s'";


	 String stxAccounts_info_date=
				"select EFFECTIVE_BEG_DATE from stx.accounts_info where E_mail='%s'";
	 
	
	public String stxAccouts_interfaces=
			"select Provider_id_qlfr AS ProviderQualifier,provider_id AS ProviderID, provider_dba_name AS ProviderDoingBusinessAs"
			+" from stx.Accounts_Interfaces where provider_id='%s'";
	
	public String stxAccounts_TaxID=
			"select compname AS ProviderName,federal_id AS TaxID from stx.accounts where compname='%s'";
	
	//------------------------------------------------Visit method-----------------..............//

	public String inboxVisitAltEvvGeneric= 
			"select VISITKEY as VISITKEY, visit_id as VisitOtherID, visit_version_number as SequenceID, worker_id as EmployeeIdentifier,"
					+ " error_code as error_code,WORKER_ID_QLFR as EmployeeQualifier, client_id as ClientIdentifier, CLIENT_ID_QLFR as ClientIDQualifier, "
					+ "PROC_CODE as ProcedureCode, VISIT_MEMO as Memo, PAYOR_PROGRAM as PayerProgram, tzname as VisitTimeZone "
					+ "from inbox.visits where visit_id='%s' and visit_version_number='%s'";
	
	public String inboxVisitAltEvvGenericSID= 
			"select SID as SID, VISITKEY as VISITKEY, visit_id as VisitOtherID, visit_version_number as SequenceID, worker_id as EmployeeIdentifier,"
					+ " error_code as error_code,WORKER_ID_QLFR as EmployeeQualifier, client_id as ClientIdentifier, CLIENT_ID_QLFR as ClientIDQualifier, "
					+ "PROC_CODE as ProcedureCode, tzname as VisitTimeZone "
					+ "from inbox.visits where visit_id='%s' and visit_version_number='%s'";

	public String inboxVisitOhio= 
			"select  PAYOR_NAME as Payer, PAYOR_PROGRAM as PayerProgram, SERVICE as ProcedureCode, error_code as error_code, VISITKEY as VISITKEY, visit_id as VisitOtherID, visit_version_number as SequenceID"
					+ " from inbox.visits where visit_id='%s' and visit_version_number='%s'";

	public String inboxvisitkey=
			"select VISITKEY from inbox.visits where visit_id='%s'";

	public String inboxVisitAltEvvMolina= 
			"select VISITKEY as VISITKEY, visit_id as VisitOtherID, visit_version_number as SequenceID, worker_id as EmployeeIdentifier,"
					+ " error_code as error_code,WORKER_ID_QLFR as EmployeeQualifier, client_id as ClientIdentifier, CLIENT_ID_QLFR as ClientIDQualifier, "
					+ " tzname as VisitTimeZone "
					+ "from inbox.visits where visit_id='%s' and visit_version_number='%s'";

	public String inboxVisitChangeGeneric=
			"select error_code as error_code, visit_version_number as SequenceID,"
					+ "reason_code as ReasonCode, resolution_code as ResolutionCode,"
					+ " REASON_CODE_MEMO as ChangeReasonMemo, VISIT_CHANGE_USERNAME as ChangeMadeBy"
					+ " from inbox.visits_changes where visit_id='%s' and visit_version_number='%s'";
	
	public String inboxVisitChangeMolina=
			"select error_code as error_code, visit_version_number as SequenceID,"
					+ "reason_code as ReasonCode, resolution_code as ResolutionCode,"
					+ " REASON_CODE_MEMO as ChangeReasonMemo"
					+ " from inbox.visits_changes where visit_id='%s' and visit_version_number='%s'";

	public String inboxVisitCalls=
			"select error_code as error_code, Ani as OriginatingPhoneNumber, call_id as CallExternalID, Service as ProcedureCode,"
					+ "call_username as MobileLogin, latitude as CallLatitude, longitude  as CallLongitude,"
					+" stx_id as TelephonyPIN, CALL_LOCATION as Location from inbox.calls where visit_id='%s' and call_assignment_qlfr='%s'";

	public String inboxVisitException=
			"select exception_id as exception_id, exception_ack_ind as ExceptionAcknowledged from inbox.visits_exceptions where visit_id='%s'";

	public String inboxVisitSchedule=
			"select ERROR_CODE, CLIENT_ID as ClientID, CLIENT_ID_QLFR as ClientIDQualifier, WORKER_ID as EmployeeIdentifier, WORKER_ID_QLFR as EmployeeQualifier from inbox.schedule where sid ='%s'";

	public String visitStatus=
			"select lib.getvisitstatus_custom('%s')from dual";

	public  String sql_memberImportSTX ="select  clientsupp.client_ssn as clientSsn, "
			+"clientsupp.mrn as ClientMedicalRecordNum, clientsupp.medicaid_id as clientCustomID,"
			+"clientsupp.client_id_custom1 as clientOtherID,"
			+" clients.f_name as clientFirstName, clientsupp.addr_type_qlfr"
			+ " as clientAddressType, clientsupp.addr1 as clientAddressLine1"+
			", clientsupp.addr2 as clientAddressLine2,  clientsupp.city as clientCity"
			+ ", clientsupp.state as clientState, clientsupp.zip_code as clientZip, clients.m_name as clientMiddleInitial, "
			+ " clients.l_name as clientLastName, "
			+" auth.payor_id as payerId"
			//+" ,clients.Loc as LOC "
			+",  auth_lim.service as payerService, auth_lim.program as payerProgram"
			+" from STX.clients_supp clientsupp LEFT JOIN STX.clients clients on clients.clientkey = clientsupp.clientkey"
			+" LEFT JOIN STX.authorizations auth on clients.loc = auth.loc LEFT JOIN STX.auth_limits auth_lim on auth.auth_id = auth_lim.auth_id"
			+" where clientsupp.client_ssn='%s'";

	public  String sql_memberImportSTXMemberMolina ="select  clientsupp.client_ssn as clientSsn, "
			+" clientsupp.medicaid_id as clientCustomID,"
			+"clientsupp.client_id_custom1 as clientOtherID,"
			+" clients.f_name as clientFirstName, clientsupp.addr_type_qlfr"
			+ " as clientAddressType, clientsupp.addr1 as clientAddressLine1"+
			", clientsupp.addr2 as clientAddressLine2,  clientsupp.city as clientCity"
			+ ", clientsupp.state as clientState, clientsupp.zip_code as clientZip, clients.m_name as clientMiddleInitial, "
			+ " clients.l_name as clientLastName, "
			+" auth.payor_id as payerId"
					+" from STX.clients_supp clientsupp LEFT JOIN STX.clients clients on clients.clientkey = clientsupp.clientkey"
			+" LEFT JOIN STX.authorizations auth on clients.loc = auth.loc LEFT JOIN STX.auth_limits auth_lim on auth.auth_id = auth_lim.auth_id"
			+" where clientsupp.client_ssn ='%s'";
	
	public String sql_GetProviderIdIndiana ="select  provider_id from stx.accounts_interfaces where provider_id is not null" 
			+" and account in(select account  from stx.accounts_groups_setup where groupkey='%s' and "
			+"account in( select account from stx.app_users where expire_date > (SELECT  CURRENT_DATE FROM DUAL)))"
			+"and rownum = 1";

}
