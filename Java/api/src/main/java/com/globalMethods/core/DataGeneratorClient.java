package com.globalMethods.core;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

public class DataGeneratorClient {

	public static String[] addTypeList = { "Business", "Home", "Other" };

	public static String[] clientcontactlist_altevv = { "Child","Friend", "Other", "Parent","Sibling", "Spouse" };

	public static String[] clientcontactlist_altevv_molina = { "Family","Other"};

	public static String[] clientcontactlist = { "Child","Family", "Friend", "Other", "Parent","Sibling", "Spouse" };


	public static String[] clientStatusList = { "01", "02", "03", "04"};

	public static String[] phoneTypeList = { "Business", "Home", "Mobile", "Other" };

	public static String[] gender = { "M", "F", "O"};

	public static String[] servicecodeList= {"T1001", "G0299", "G0300"};

	public static String[] stateList = { "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN",
			"IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY",
			"NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WI", "WV", "WY" };


	// Max Length :30 :String
	public static String generatePatientCity(int i) {
		String city = CommonMethods.getSaltString(i);
		return city;
	}

	// Max length: 30 :String
	public String generatePatientAddressLine2(int i) {
		String Line2 = CommonMethods.getSaltString(i);
		return Line2;
	}

	//Max length : Alphanumeric : 30
	public static String generateClientFirstName(int i) {
		String empfname = CommonMethods.generateRandomStringOfFixLength(i);
		return empfname;
	}

	//Max length : Alphanumeric : 30
	public static String generateClientMiddleName(int i) {
		String empmname = CommonMethods.generateRandomStringOfFixLength(i);
		return empmname;
	}

	// Max length : 12 String StaticList: "Business”, “Home”, “School”, “Other”
	public static String clientAddressType()
	{
		String clientAddressType = addTypeList[CommonMethods.getRandomInt(0, (addTypeList.length) - 1)];
		return clientAddressType;

	}
	public static String clientAddressType(String addtype) {

		return addtype;
	}
	// Max length : 12 String StaticList: Family|Friend|Other|Parent|Sibling|Spouse"
	public static String clientContactType(String addtype) {
		return addtype;
	}

	public static String clientContactType() {
		String Clientstatus = clientcontactlist[CommonMethods.getRandomInt(0, (clientcontactlist.length) - 1)];
		return Clientstatus;
	}

	public static String clientContactType_altevv() {
		String Clientstatus = clientcontactlist_altevv[CommonMethods.getRandomInt(0, (clientcontactlist_altevv.length) - 1)];
		return Clientstatus;
	}
	public static String clientContactType_altevv_molina() {
		String Clientstatus = clientcontactlist_altevv_molina[CommonMethods.getRandomInt(0, (clientcontactlist_altevv_molina.length) - 1)];
		return Clientstatus;
	}


	// Max length : 12 String StaticList: Business, Home, Mobile, Other"
	public static String clientPhoneType()
	{  String clientPhonetype = phoneTypeList[CommonMethods.getRandomInt(0, (phoneTypeList.length) - 1)];
	return clientPhonetype;

	}

	public static String clientStatus()
	{  String Clientstatus = clientStatusList[CommonMethods.getRandomInt(0, (clientStatusList.length) - 1)];
	return Clientstatus;

	}

	// Max length 20 SandataID, NPI, API, MedicaidID, TaxID, Taxonomy, Legacy, Other".
	public static String providerQualifierType(String addtype) {
		return addtype;

	}
	// Max Length : String : 2
	public static String generateClientState() {
		String clientstate = stateList[CommonMethods.getRandomInt(0, (stateList.length) - 1)];
		return clientstate;
	}
	
	
	// Max length: 30 :String
	public static String generateClientAddressLine2(int i) {
		String ClientAddressLine2 = CommonMethods.generateRandomStringOfFixLength(i);
		return ClientAddressLine2;
	}

	// Max length: 30 :String
	public static String generateClientAddressLine1(int i) {
		String ClientAddressLine2 = CommonMethods.generateRandomStringOfFixLength(i);
		return ClientAddressLine2;
	}

	//Max length : Alphanumeric : 30
	public static String generateClientLastName(int i) {
		String ClientLastName = CommonMethods.generateRandomStringOfFixLength(i);
		return ClientLastName;
	}

	//Max length : Numeric : 9
	public static String generateClientSSN(int i){
		String ClientSSN = CommonMethods.generateRandomNumberOfFixLength(i);
		return ClientSSN;
	}

	//Max length : Numeric : 10
	public static String generateAccount(int i){
		String Account = CommonMethods.generateRandomNumberOfFixLength(i);
		return Account;
	}

	//Max length : Numeric : 10
	public static String generateClientID(int i){
		String ClientID = CommonMethods.generateRandomNumberOfFixLength(i);
		return ClientID;
	}

	//Max length : Numeric : 10
	public static String generateClientPhone(int i){
		String ClientPhone = CommonMethods.generateRandomNumberOfFixLength(i);
		return ClientPhone;
	}

	//Max length : Numeric : 9
	public static String generateClientZip(int i){
		String ClientZip = CommonMethods.generateRandomNumberOfFixLength(i);
		return ClientZip;
	}

	// Max Length :30 :String
	public static String generateClientState(int i) {
		String ClientState = CommonMethods.generateRandomStringOfFixLength(i);
		return ClientState;
	}

	// Max Length :30 :String
	public static String generateClientCity(int i) {
		String ClientCity = CommonMethods.generateRandomStringOfFixLength(i);
		return ClientCity;
	}

	// Max length: 30 :String
	public static String generateContactAddressLine1(int i) {
		String ContactAddressLine1 = CommonMethods.generateRandomStringOfFixLength(i);
		return ContactAddressLine1;
	}

	public static String generateClientDesigneeStatus(int i){
		String ClientDesigneeStatus = CommonMethods.generateRandomNumberOfFixLength(i);
		return ClientDesigneeStatus;
	}

	public static String generateRecipientIDCustom2(int i) {
		String RecipientIDCustom2 = CommonMethods.generateRandomAlphaNumeric(i);
		return RecipientIDCustom2;
	}

	public static String generateRecipientIDCustom1(int i) {
		String RecipientIDCustom1 = CommonMethods.generateRandomAlphaNumeric(i);
		return RecipientIDCustom1;
	}

	public static String generateCoordinator(int i) {
		String coordinator = CommonMethods.generateRandomAlphaNumeric(i);
		return coordinator;
	}

	public static String generatefutureDate()
	{
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		Date tomorrow = calendar.getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String empfuturedate = dateFormat.format(tomorrow);
		return empfuturedate;
	}

	public static String DeleteStatusDate_client_threedayadvance() throws InterruptedException, java.text.ParseException,  java.text.ParseException
	{
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, 3);
		Date tomorrow = calendar.getTime();

		DateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
		String empfuturedate = dateFormat.format(tomorrow);
		Date dateConverted=new SimpleDateFormat("MMddyyyy").parse(empfuturedate);

		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String dt =simpleDateFormat.format(dateConverted);
		return (dt+".0");

	}

	public static String dateToDateTimeFormat(String dateToFormat) throws InterruptedException, java.text.ParseException,  java.text.ParseException
	{

		Date dateConverted=new SimpleDateFormat("MMddyyyy").parse(dateToFormat);

		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String dt =simpleDateFormat.format(dateConverted);
		return (dt+".0");
	}

	public static String generateStartDate()
	{
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String emphiredate = dateFormat.format(date);
		return emphiredate;
	}

	public static String generateEndDate()
	{
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String empenddate = dateFormat.format(date);
		return empenddate;
	}
	public static String generatePastDate()
	{
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, -5);
		Date yestarday = calendar.getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String emppastdate = dateFormat.format(yestarday);
		return emppastdate;
	}

	public static String generateDischargeDate()
	{
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, -5);
		Date yestarday = calendar.getTime();
		DateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
		String empdischargedate = dateFormat.format(yestarday);
		return empdischargedate;
	}

	public static String generatePayerid(int i) {
		String generatePayerid = CommonMethods.generateRandomStringOfFixLength(i);
		return generatePayerid;
	}

	public static String generatePayerprogram(int i) {
		String generatePayerprogram = CommonMethods.generateRandomStringOfFixLength(i);
		return generatePayerprogram;
	}

	//Email address of the Client Designee. Max length : Alphanumeric : 50
	public static String generateClientDesigneeEmail(int i)
	{
		String domain="@mailinator.com";
		String ClientDesigneeEmail = CommonMethods.generateRandomAlphaNumeric(i);
		return ClientDesigneeEmail.concat(domain);
	}
	public static String generateClientEmailAddress_alphanum(int i)
	{
		String domain="@mailinator.com";
		String ClientEmailAddress = CommonMethods.generateRandomAlphaNumeric(i);
		return ClientEmailAddress.concat(domain);
	}

	public static String generateClientEmailAddress_num(int i)
	{
		String domain="@mailinator.com";
		String ClientEmailAddress = CommonMethods.generateRandomNumberOfFixLength(i);
		return ClientEmailAddress.concat(domain);
	}

	public static String generateClientEmailAddress_alpha(int i)
	{
		String domain="@mailinator.com";
		String ClientEmailAddress = CommonMethods.generateRandomStringOfFixLength(i);
		return ClientEmailAddress.concat(domain);
	}

	// Max length : 12 String PhoneType: "Home", "Mobile", "Business" and "Other"
	public static String ClientPhoneType(String phonetype) {
		return phonetype;
	}

	public static String generateSequenceID(int i) {
		String generateSequenceID = CommonMethods.generateRandomNumberOfFixLength(i);
		return generateSequenceID;
	}

	public static String servicecodeList() {
		String servicecodetype = servicecodeList[CommonMethods.getRandomInt(0, (addTypeList.length) - 1)];
		return servicecodetype;
	}

	public static void clientQualifierValueAssigned(JSONObject jsonObject_mainArray) 
	{
		//	if ClientQualifier is "ClientSSN", ClientSSN will be overwritten by ClientIdentifier.
		//	if ClientQualifier is "ClientOtherID", ClientOtherID will be overwritten by ClientIdentifier.
		//	if ClientCustomID is "ClientCustomID", ClientCustomID will be overwritten by ClientIdentifier.

		if(jsonObject_mainArray.get("ClientQualifier").toString().equals("ClientSSN"))
		{
			jsonObject_mainArray.put("ClientSSN", jsonObject_mainArray.get("ClientIdentifier").toString());
			
		}
		else if (jsonObject_mainArray.get("ClientQualifier").toString().equals("ClientOtherID")) 
		{
			jsonObject_mainArray.put("ClientOtherID",jsonObject_mainArray.get("ClientIdentifier").toString());
		}

		else if (jsonObject_mainArray.get("ClientQualifier").toString().equals("ClientCustomID")) 
		{
			jsonObject_mainArray.put("ClientCustomID", jsonObject_mainArray.get("ClientIdentifier").toString());
		}
	}

	public static void missingMedicatedIDValueasTrue(JSONObject jsonObject_mainArray)
	{		
		String missingmedicatedID=String.valueOf(jsonObject_mainArray.get("MissingMedicaidID"));

		if (Boolean.valueOf(missingmedicatedID)==true )
		{
			jsonObject_mainArray.put("ClientMedicaidID", null);
		} 
	}

	@SuppressWarnings("unchecked")
	public static void objectCharTruncation(JSONObject jsonobject, String objectName, int i)
	{
		if (String.valueOf(jsonobject.get(objectName)).length() > i)
		{
			jsonobject.put(objectName, jsonobject.get(objectName).toString().substring(0,i));

		}
		
	}

	public static void ClienteligibilityDateScenario(JSONObject jsonobject_Map) throws InterruptedException, java.text.ParseException, ParseException, java.text.ParseException
	{
		JSONArray jsonArrayElig = (JSONArray) jsonobject_Map.get("ClientEligibility");
		JSONObject jsonObjectElig = (JSONObject) jsonArrayElig.get(0);

		if(String.valueOf(jsonObjectElig.get("ClientEligibilityDateEnd")).equalsIgnoreCase("null"))
		{
			jsonobject_Map.put("BEG_DATE", CommonMethods.dateToDateTimeFormat_yyyy_mm_dd(jsonObjectElig.get("ClientEligibilityDateBegin").toString()));
			jsonobject_Map.put("END_DATE", "2999-12-31 00:00:00.0");
			
		}else if(String.valueOf(jsonObjectElig.get("ClientStartOfCareDate")).equalsIgnoreCase("null") && 
				
				String.valueOf(jsonObjectElig.get("ClientEndOfCareDate")).equalsIgnoreCase("null"))
			
		{
			jsonobject_Map.put("BEG_DATE", CommonMethods.dateToDateTimeFormat_yyyy_mm_dd(jsonObjectElig.get("ClientEligibilityDateBegin").toString()));
			jsonobject_Map.put("END_DATE", CommonMethods.dateToDateTimeFormat_yyyy_mm_dd(jsonObjectElig.get("ClientEligibilityDateEnd").toString()));
		}
		else 
		{
			jsonobject_Map.put("BEG_DATE", CommonMethods.dateToDateTimeFormat_yyyy_mm_dd(jsonObjectElig.get("ClientEligibilityDateBegin").toString()));
			jsonobject_Map.put("END_DATE", CommonMethods.dateToDateTimeFormat_yyyy_mm_dd(jsonObjectElig.get("ClientEligibilityDateEnd").toString()));
		}
	
	}
	public static void Provider_primarycontactlastname(JSONObject jsonobject) 
	{


		if(String.valueOf(jsonobject.get("PrimaryContactFirstName")).equalsIgnoreCase("null")|| String.valueOf(jsonobject.get("PrimaryContactFirstName")).isEmpty())
		{
			jsonobject.put("PrimaryContactFirstName", jsonobject.get("PrimaryContactLastName").toString());
		}
	}
	public static void Provider_primarycontactlastnameBatch(Map<String ,String > mapdataValue) 
	{


		if(String.valueOf(mapdataValue.get(globalVariables.PrimaryContactFirstName)).equalsIgnoreCase("null")|| String.valueOf(mapdataValue.get(globalVariables.PrimaryContactFirstName)).isEmpty())
		{
			mapdataValue.put(globalVariables.PrimaryContactFirstName, mapdataValue.get(globalVariables.PrimaryContactLastName));
		}
	}
}



