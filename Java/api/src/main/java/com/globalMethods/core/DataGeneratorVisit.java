package com.globalMethods.core;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import com.globalMethods.core.CommonMethods;

/**
 * @author Anupam
 *
 */

public class DataGeneratorVisit {

	public static String[] PayerProgramList = { "ODM", "FD", "O"};
	public static String[] booleanValues= {"true","false"};
	public static String[] CallAssignmentList = { "Time In", "Time Out", "Other" };

	public static String AdjInDateTime(String dateToFormat) throws InterruptedException, java.text.ParseException,  ParseException, java.text.ParseException
	{

		Date dateConverted=new SimpleDateFormat("MMddyyyy").parse(dateToFormat);

		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String dt =simpleDateFormat.format(dateConverted);
		return (dt+".0");
	}

	public static String generateAdjOutDateTime(String dateToFormat) throws InterruptedException, java.text.ParseException,  ParseException, java.text.ParseException
	{

		Date dateConverted=new SimpleDateFormat("MMddyyyy").parse(dateToFormat);

		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String dt =simpleDateFormat.format(dateConverted);
		return (dt+".0");
	}

	public static String generateClientID(int i)
	{
		String ClientID = CommonMethods.generateRandomNumberOfFixLength(i);
		return ClientID;
	}

	public static String AgencyIdentifier(int i) {
		String AgencyIdentifier = CommonMethods.generateRandomStringOfFixLength(i);
		return AgencyIdentifier;
	}

	// Max length : ClientSignatureAvailable: 'true','false'
	public static String generateClientSignatureAvailable() {
		String SignatureAvailable = booleanValues[CommonMethods.getRandomInt(0, (booleanValues.length) - 1)];

		return SignatureAvailable;
	}


	// Max length : BillVisit: 'true','false'
	public static String generateBillVisit() {
		String Visit = booleanValues[CommonMethods.getRandomInt(0, (booleanValues.length) - 1)];

		return Visit;
	}			
	// Max length : ClientVerifiedService: 'true','false'
	public static String generateClientVerifiedService() {
		String VerifiedService = booleanValues[CommonMethods.getRandomInt(0, (booleanValues.length) - 1)];

		return VerifiedService;
	}

	public static String generateCallAssignment() {
		String Assignment = CallAssignmentList[CommonMethods.getRandomInt(0, (CallAssignmentList.length) - 1)];
		return Assignment;
	}


	// Max length : ClientVerifiedTasks: 'true','false'
	public static String generateClientVerifiedTasks() {
		String VerifiedTasks = booleanValues[CommonMethods.getRandomInt(0, (booleanValues.length) - 1)];

		return VerifiedTasks;
	}

	public static String generateRecipientIDCustom2(int i) {
		String RecipientIDCustom2 = CommonMethods.generateRandomAlphaNumeric(i);
		return RecipientIDCustom2;
	}

	public static String generateClientQualifier(int i) {
		String clientfname = CommonMethods.generateRandomStringOfFixLength(i);
		return clientfname;
	}

	//Max length : Alphanumeric : 30
	public static String generateClientLastName(int i) {
		String ClientLastName = CommonMethods.generateRandomStringOfFixLength(i);
		return ClientLastName;
	}

	// Max length : ClientVerifiedTimes: 'true','false'
	public static String generateClientVerifiedTimes() {
		String VerifiedTimes = booleanValues[CommonMethods.getRandomInt(0, (booleanValues.length) - 1)];

		return VerifiedTimes;
	}

	// Max length : ClientVoiceRecording: 'true','false'
	public static String generateClientVoiceRecording() {
		String VoiceRecording = booleanValues[CommonMethods.getRandomInt(0, (booleanValues.length) - 1)];

		return VoiceRecording;
	}

	// Max length : VisitCancelledIndicator: 'true','false'
	public static String generateVisitCancelledIndicator() {
		String CancelledIndicator = booleanValues[CommonMethods.getRandomInt(0, (booleanValues.length) - 1)];

		return CancelledIndicator;
	}
	public static String generateCallLongitude() {
		Long Longitude = CommonMethods.getRandomLong(-180, 180);  // changed Min and Max Value
		return Longitude.toString();
	}

	public static String generateCallLatitude() {
		Long Latt = CommonMethods.getRandomLong(-90, 90);        // changed Min and Max Value
		return Latt.toString();
	}

	public static String generateScheduleStartTime()
	{
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String ScheduleStartTime = dateFormat.format(date);
		return ScheduleStartTime;
	}

	public static String generateScheduleEndTime()
	{
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String ScheduleEndTime = dateFormat.format(date);
		return ScheduleEndTime;
	}
	
	public static String generateCallDateTime()
	{
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String callDateTime = dateFormat.format(date);
		return callDateTime;
	}
	
	/**
	import com.globalMethods.core.Assertion_DbVerifier; public class calendar {
	static Calendar gc = Calendar.getInstance(); 
	 int random1()
	{		 
		  int year = randBetween(2017, 2018);
	      gc.set(Calendar.YEAR, year);
	      int dayOfYear = randBetween(1, gc.getActualMaximum(Calendar.DAY_OF_YEAR));
	      gc.set(Calendar.DAY_OF_YEAR, dayOfYear);
	      int day = gc.get(Calendar.DAY_OF_WEEK);
	      switch(day)
	      {
	      case 1:
	    	  day=day+5;
	    	//  System.out.println(day);
	    	  return(day);
	    	 
	      case 2:
	    	  day=day+4;
	    	 // System.out.println(day);
	    	  return(day);
	    	
	      case 3:
	    	  day=day+3;
	    	//  System.out.println(day);
	    	  return(day);
	    	
	    	  
	      case 4:
	    	  day=day+2;
	    	 // System.out.println(day);
	    	  return(day);
	    	 
	      case 5:
	    	  
	    	  day=day+1;
	    	  //System.out.println(day);
	    	  return(day);
	    	 
	      default:
	    	  //System.out.println(day);
	    	  
	    	  return(day);
	    
	      }   
	}
	
    public static void main(String[] args) {

    	//Calendar gc = new GregorianCalendar();
       calendar t1=new calendar();
      int day= t1.random1();
      gc.set(Calendar.DAY_OF_WEEK, day+1);
      System.out.println(gc.get(Calendar.YEAR) + "-" + (gc.get(Calendar.MONTH) + 1) + "-" + gc.get(Calendar.DAY_OF_MONTH));  
    }

    public int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }
	}

	 public static int randBetween(int start, int end) {
	        return start + (int)Math.round(Math.random() * (end - start));
	    }
	 
	 **/
	 
	public static String generatePastDateTime()
	{
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, -5);
		Date yestarday = calendar.getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String CallDateTime = dateFormat.format(yestarday);
		return CallDateTime;
	}

	//Max length : Alphanumeric : 30
	public static String generateClientIdentifier(int i) {
		String ClientIdentifier = CommonMethods.generateRandomStringOfFixLength(i);
		return ClientIdentifier;
	}

	//Max length : Alphanumeric : 30
	public static String generateSequenceID(int i) {
		String SequenceID = CommonMethods.generateRandomNumberOfFixLength(i);
		return SequenceID;
	}

	//Max length : Alphanumeric : 30
	public static String generateVisitOtherID(int i) {
		String VisitOtherID = CommonMethods.generateRandomNumberOfFixLength(i);
		return VisitOtherID;
	}

	//Max length : Alphanumeric : 30
	public static String generateClientOtherID(int i) {
		String ClientOtherID = CommonMethods.generateRandomStringOfFixLength(i);
		return ClientOtherID;
	}

	//Max length : Alphanumeric : 30
	public static String generateEmployeeIdentifier(int i) {
		String EmployeeIdentifier = CommonMethods.generateRandomNumberOfFixLength(i);
		return EmployeeIdentifier;
	}

	//Max length : Alphanumeric : 30
	public static String generateEmployeeQualifier(int i) {
		String EmployeeQualifier = CommonMethods.generateRandomNumberOfFixLength(i);
		return EmployeeQualifier;
	}

	//Max length : Alphanumeric : 30
	public static String generateEmployeeOtherID(int i) {
		String EmployeeOtherID = CommonMethods.generateRandomStringOfFixLength(i);
		return EmployeeOtherID;
	}

	// Max Length :30 :String
	public static String generateErrorCode(int i) {
		String ErrorCode = CommonMethods.generateRandomStringOfFixLength(i);
		return ErrorCode;
	}

	// Max Length :30 :String
	public static String generateErrorMessage(int i) {
		String ErrorMessage = CommonMethods.generateRandomStringOfFixLength(i);
		return ErrorMessage;
	}

	// Max Length :30 :String
	public static String generateHoursToBill(int i) {
		String HoursToBill = CommonMethods.generateRandomNumberOfFixLength(i);
		return HoursToBill;
	}

	// Max Length :30 :String
	public static String generateMemo(int i) {
		String Memo = CommonMethods.generateRandomStringOfFixLength(i);
		return Memo;
	}

	// Max Length :30 :String
	public static String generatePayerID(int i) {
		String PayerID = CommonMethods.generateRandomNumberOfFixLength(i);
		return PayerID;
	}

	// Max Length :30 :String
	public static String generateProcedureCode(int i) {
		String ProcedureCode = CommonMethods.generateRandomStringOfFixLength(i);
		return ProcedureCode;
	}

	// Max Length :30 :String
	public static String generateProviderID(int i) {
		String ProviderID = CommonMethods.generateRandomNumberOfFixLength(i);
		return ProviderID;
	}

	// Max Length :30 :String
	public static String generateProviderQualifier(int i) {
		String ProviderQualifier = CommonMethods.generateRandomNumberOfFixLength(i);
		return ProviderQualifier;
	}

	public static String generatePayerProgram() {
		String PayerProgram = PayerProgramList[CommonMethods.getRandomInt(0, (PayerProgramList.length) - 1)];
		return PayerProgram;
	}

	public static String generateVisitTimeZone() {
		String timeZone = "US/Eastern";
		return timeZone;
	}

	public static void clientIDQualifierKeyAssigned(JSONObject jsonObject_mainArray) 
	{
		
		if(jsonObject_mainArray.get("ClientIDQualifier").toString().equals("ClientID"))
		{
			jsonObject_mainArray.put("ClientIDQualifier", "LOC");
			
		}
	}

}
