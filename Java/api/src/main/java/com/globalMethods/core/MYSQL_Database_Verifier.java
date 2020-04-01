package com.globalMethods.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class MYSQL_Database_Verifier {

	private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DATABASE_URL = CommonMethods.propertyfileReader("DbConnectionur_mysql");
	private static final String USERNAME =  CommonMethods.propertyfileReader("USERNAME_mysql");
	private static final String PASSWORD = CommonMethods.propertyfileReader("PASSWORD_mysql");
	private static final String MAX_POOL = "250";

	private static Connection con;

	private static Properties properties;

	public static String status_code, account,clientFirstName,clientLastName,client_m_name,client_ssn,client_medicaid_id,client_id,client_name_suffix,Action_code;
	public static String client_id_address,client_addr_typ_qlfr, client_addr1,client_addr2,client_country, client_city,client_state, client_zip_code;
	public static String client_id_Elig,Action_code_elig,payor_id, program,client_elig_beg_date,client_elig_end_date,client_start_of_care_date, client_end_of_care_date,client_prmy_dx_code, client_scndry_dx_code,client_status, client_status_date;
	public static String payor_id_payor,program_payor,service,region,client_id_qlfr,client_phone_typ,client_phone_num;
	public static String payor_id_auth,program_auth,client_id_qlfr_auth,provider_id_qlfr_auth,provider_id_auth,auth_ref_num,service_auth,auth_billing_typ,Modifier1,Modifier2,Modifier3,Modifier4,auth_amt_typ,
	auth_max,auth_start_date,auth_end_date,auth_shared_ind,auth_cmnt,auth_lmt_typ,auth_status,auth_sk;
	public static String auth_lmt,auth_week_start,auth_lmt_day_of_week,auth_lmt_start_time,auth_lmt_end_time,prmy_dx_code,client_id_auth,worker_id_auth,worker_id_qlfr;


	// create properties
	private static Properties getProperties() {
		if (properties == null) {
			properties = new Properties();
			properties.setProperty("user", USERNAME);
			properties.setProperty("password", PASSWORD);
			properties.setProperty("MaxPooledStatements", MAX_POOL);
		}
		return properties;
	}

	// connect database
	public static Connection CreateConnection() {
		if (con == null) {
			try {
				Class.forName(DATABASE_DRIVER);
				con = DriverManager.getConnection(DATABASE_URL, getProperties());
			} catch (ClassNotFoundException | SQLException e) {
				// Java 7+
				e.printStackTrace();
			}
		}
		return con;
	}

	// disconnect database
	public static void disconnect() {
		if (con != null) {
			try {
				con.close();
				con = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void DataBaseVerificationClient(String clientId) throws InterruptedException, java.text.ParseException,  SQLException

	{
		con=CreateConnection();
		String query = "select * from intfstagedb.client where client_id='" +clientId+"';";
		System.out.println(query);

		// create the java statement

		Statement st = con.createStatement();
		// execute the query, and get a java resultset
		ResultSet rs = st.executeQuery(query);

		// iterate through the java resultset
		while (rs.next())
		{
			status_code=rs.getString("status_code");
			account=rs.getString("account");
			clientFirstName=rs.getString("client_f_name");
			clientLastName=rs.getString("client_l_name");
			client_m_name=rs.getString("client_m_name");
			client_ssn=rs.getString("client_ssn");
			client_medicaid_id=rs.getString("client_medicaid_id");
			client_id=rs.getString("client_id");
			client_name_suffix=rs.getString("client_name_suffix");
			Action_code=rs.getString("Action_code");



		}
		st.close();

		MYSQL_Database_Verifier.disconnect();
		DataBaseVerificationClientAddress(clientId);
		DataBaseVerificationClientElig(clientId);
		DataBaseVerificationClientPayor(clientId);
		DataBaseVerificationClientPhone(clientId);


	}
	public static void DataBaseVerificationClientAddress(String clientId) throws InterruptedException, java.text.ParseException,  SQLException

	{
		con=CreateConnection();
		String query = "select * from intfstagedb.client_addr where client_id='" +clientId+"';";
		System.out.println(query);

		// create the java statement

		Statement st = con.createStatement();
		// execute the query, and get a java resultset
		ResultSet rs = st.executeQuery(query);

		// iterate through the java resultset
		while (rs.next())
		{
			client_addr_typ_qlfr=rs.getString("client_addr_typ_qlfr");
			client_addr1=rs.getString("client_addr1");
			client_addr2=rs.getString("client_addr2");
			client_country=rs.getString("client_county");
			client_city=rs.getString("client_city");
			client_state=rs.getString("client_state");
			client_zip_code=rs.getString("client_zip_code");


		}
		st.close();

		MYSQL_Database_Verifier.disconnect();

	}
	public static void DataBaseVerificationClientElig(String clientId) throws InterruptedException, java.text.ParseException,  SQLException

	{
		con=CreateConnection();
		String query = "select * from intfstagedb.client_elig where client_id='" +clientId+"';";
		System.out.println(query);

		// create the java statement

		Statement st = con.createStatement();
		// execute the query, and get a java resultset
		ResultSet rs = st.executeQuery(query);

		// iterate through the java resultset
		while (rs.next())
		{
			client_id_Elig=rs.getString("client_id");
			Action_code_elig=rs.getString("Action_code");
			payor_id=rs.getString("payor_id");
			program=rs.getString("program");
			client_elig_beg_date=rs.getString("client_elig_beg_date");
			client_elig_end_date=rs.getString("client_elig_end_date");
			client_start_of_care_date=rs.getString("client_start_of_care_date");
			client_end_of_care_date=rs.getString("client_end_of_care_date");
			client_prmy_dx_code=rs.getString("client_prmy_dx_code");
			client_scndry_dx_code=rs.getString("client_scndry_dx_code");
			client_status=rs.getString("client_status");
			client_status_date=rs.getString("client_status_date");

		}
		st.close();

		MYSQL_Database_Verifier.disconnect();

	}
	public static void DataBaseVerificationClientPayor(String clientId) throws InterruptedException, java.text.ParseException,  SQLException

	{
		con=CreateConnection();
		String query = "select * from intfstagedb.client_payor where client_id='" +clientId+"';";
		System.out.println(query);

		// create the java statement

		Statement st = con.createStatement();
		// execute the query, and get a java resultset
		ResultSet rs = st.executeQuery(query);

		// iterate through the java resultset
		while (rs.next())
		{
			payor_id_payor=rs.getString("payor_id");
			program_payor=rs.getString("program");
			service=rs.getString("service");
			region=rs.getString("region");
			client_id_qlfr=rs.getString("client_id_qlfr");



		}
		st.close();

		MYSQL_Database_Verifier.disconnect();

	}
	public static void DataBaseVerificationClientPhone(String clientId) throws InterruptedException, java.text.ParseException,  SQLException

	{
		con=CreateConnection();
		String query = "select * from intfstagedb.client_phone where client_id='" +clientId+"';";
		System.out.println(query);

		// create the java statement

		Statement st = con.createStatement();
		// execute the query, and get a java resultset
		ResultSet rs = st.executeQuery(query);

		// iterate through the java resultset
		while (rs.next())
		{
			client_phone_typ=rs.getString("client_phone_typ");
			client_phone_num=rs.getString("client_phone_num");



		}
		st.close();

		MYSQL_Database_Verifier.disconnect();

	}
	
	public static void DataBaseVerificationClientAuth(String clientId) throws InterruptedException, java.text.ParseException,  SQLException

	{
		con=CreateConnection();
		String query = "select * from intfstagedb.auth where client_id='" +clientId+"';";
		System.out.println(query);

		// create the java statement

		Statement st = con.createStatement();
		// execute the query, and get a java resultset
		ResultSet rs = st.executeQuery(query);

		// iterate through the java resultset
		while (rs.next())
		{
			payor_id_auth=rs.getString("payor_id");
			program_auth=rs.getString("program");
			client_id_auth=rs.getString("client_id");
			client_id_qlfr=rs.getString("client_id_qlfr");
			provider_id_qlfr_auth=rs.getString("provider_id_qlfr");
			provider_id_auth=rs.getString("provider_id");
			auth_ref_num=rs.getString("auth_ref_num");
			service_auth=rs.getString("service");
			auth_billing_typ=rs.getString("auth_billing_typ");
			Modifier1=rs.getString("Modifier1");
			Modifier2=rs.getString("Modifier2");
			Modifier3=rs.getString("Modifier3");
			Modifier4=rs.getString("Modifier4");
			auth_amt_typ=rs.getString("auth_amt_typ");
			auth_max=rs.getString("auth_max");
			auth_start_date=rs.getString("auth_start_date");
			auth_end_date=rs.getString("auth_end_date");
			auth_shared_ind=rs.getString("auth_shared_ind");
			auth_cmnt=rs.getString("auth_cmnt");
			auth_lmt_typ=rs.getString("auth_lmt_typ");
			auth_status=rs.getString("auth_status");
			auth_sk=rs.getString("auth_sk");

		}
		query = "select * from intfstagedb.auth_limit  where auth_sk='"+auth_sk+"';";
		System.out.println(query);

		// create the java statement

		st = con.createStatement();
		// execute the query, and get a java resultset
		rs = st.executeQuery(query);

		// iterate through the java resultset
		while (rs.next())
		{
			auth_lmt=rs.getString("auth_lmt");
			auth_week_start=rs.getString("auth_week_start");
			auth_lmt_end_time=rs.getString("auth_lmt_end_time");
			auth_lmt_day_of_week=rs.getString("auth_lmt_day_of_week");
			auth_lmt_start_time=rs.getString("auth_lmt_start_time");
			prmy_dx_code=rs.getString("prmy_dx_code");

		}
		st.close();

		MYSQL_Database_Verifier.disconnect();

	}

	public static String executeQueryMySql(String sql_Query) throws InterruptedException, java.text.ParseException,  SQLException

	{
		String col_Data = null;
		Statement stmt =null;
		con=CreateConnection();
		System.out.println(sql_Query);
		try{
			stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(sql_Query);
			while (rs.next())
			{
				col_Data =rs.getString(1);
			}
		}
		finally{
			if(stmt!=null){
				stmt.close();
			}
		}

		return col_Data;

}
}
