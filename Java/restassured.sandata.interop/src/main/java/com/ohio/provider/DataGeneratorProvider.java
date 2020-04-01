package com.ohio.provider;

import java.util.HashMap;
import java.util.Map;



public class DataGeneratorProvider {
	Object key ;
	HashMap<String,Map<String,String>> PID_PMID;
	
	String Provider[]= {"2309617","3153606","6306418","6368871","6067678","7559576","1967917","7009180","9240072","5739127","8807234","7351284","1967917"};
	String state[]= {"AL" , "AK" , "AZ" , "AR" , "CA" , "CO" , "CT" ,"DE" , "DC" ,"FL" ,"GA" ,"HI" , "ID" , "IL" ,"IN" ,"IA" , "KS" , "KY" , "LA" , "ME" , "MD" , "MA" , "MI" , "MN" , "MS" , "MO" , "MT"};
	
	// Max Length 7 : Number
		public String generateProviderID() {
			Long Sid = CommonMethodsProvider.getRandomLong(1111111L, 9999999L);
			return Sid.toString();
		}

		public String generateProviderFname() {
			String PLN = "Auto_" + CommonMethodsProvider.getSaltString(20);
			return PLN;
		}
		
		public String generateProviderLname() {
			String PLN = "Auto_" + CommonMethodsProvider.getSaltString(20);
			return PLN;
		}
		
		public String space(int spaceCount) {
			String space="";
			for(int i=1; i<=spaceCount; i++) {
				space=space+" ";
			}
			return space;
		}

		// Max Length 9 : Number
				public String generateTaxID() {
					String Sid = CommonMethodsProvider.generateRandomAlphaNumeric(9);
					return Sid;
				}

		
				// Max Length 9 : Number
				public String generateSsn() {
					Long Sid = CommonMethodsProvider.getRandomLong(111111111L, 999999999L);
					return Sid.toString();
				}
				
				// Max Length 10 : Number
				public String generatePhone() {
					Long Sid = CommonMethodsProvider.getRandomLong(1111111111L, 9999999999L);
					return Sid.toString();
				}

				public String generateStreet1() {
					String PLN = CommonMethodsProvider.getSaltString(30);
					return PLN;
				}
				
				public String generateStreet2() {
					String PLN = CommonMethodsProvider.getSaltString(30);
					return PLN;
				}
				
				
				public String generateCity() {
					String PLN = CommonMethodsProvider.getSaltString(30);
					return PLN;
				}
				
				public String generateState() {
					String PLN = state[CommonMethodsProvider.getRandomInt(0, (state.length) - 1)];
					return PLN;
				}
				
				public String generateZip() {
					Long Sid = CommonMethodsProvider.getRandomLong(111111111L, 999999999L);
					return Sid.toString();
				}
				
				public String generateEmail(String provID) {
					String PLN = CommonMethodsProvider.getSaltString(5)+provID;
					return PLN;
				}
				
				public String generateSpecificNonAgencyProvider() {
					String NAP_ID = Provider[CommonMethodsProvider.getRandomInt(0, (Provider.length) - 1)];
					return NAP_ID;
				}

}
