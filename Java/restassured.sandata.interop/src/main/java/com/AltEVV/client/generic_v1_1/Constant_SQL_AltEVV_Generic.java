package com.AltEVV.client.generic_v1_1;

public  class Constant_SQL_AltEVV_Generic {
	

	public  String inboxClientAltEVVGenericSql = 
			"select Error_code as error_code, LOC as ClientID, client_ssn as ClientSSN, f_name as ClientFirstName, m_name as ClientMiddleInitial,"+
					"l_name as ClientLastName, medicaid_id as ClientMedicaidID from inbox.clients where Loc='%s' and f_name= '%s'";
	
	public  String inboxClientAltEVVGenericSql_TC = 
			"select Error_code as error_code, LOC as ClientID, client_ssn as ClientSSN, CLIENT_ID_CUSTOM2 as ClientOtherID, CLIENT_ID_CUSTOM1 as ClientIdentifier, MEDICAID_ID_UNAVAIL_IND as MissingMedicaidID, f_name as ClientFirstName, m_name as ClientMiddleInitial,"+
					"l_name as ClientLastName, medicaid_id as ClientMedicaidID from inbox.clients where Loc='%s' and f_name= '%s'";
	
	public  String stxClientAltEVVGenericSql = 
			"select LOC as ClientID, CLIENT_VERSION_NUMBER as SequenceID, f_name as ClientFirstName, m_name as ClientMiddleInitial,"+
					"l_name as ClientLastName, f_name as ClientFirstName from stx.clients where Loc='%s' and f_name= '%s'";


}
