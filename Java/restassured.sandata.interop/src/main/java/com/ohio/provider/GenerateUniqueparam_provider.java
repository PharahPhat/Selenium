package com.ohio.provider;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.globalMethods.core.CommonMethods;

public class GenerateUniqueparam_provider {
	DataGeneratorProvider dataGeneratorProvider= new DataGeneratorProvider();
	@SuppressWarnings("unchecked")
		public Map<String,String>	generateUnigueParamProvider(String specialType )
	{
		Map<String,String> providerData =new HashMap<String,String>();
		providerData.put("ID_PROVIDER_MCD", dataGeneratorProvider.generateProviderID());
		
		providerData.put("Prov_fname", dataGeneratorProvider.generateProviderFname());
		
		providerData.put("Prov_lname",dataGeneratorProvider.generateProviderLname());

		
		providerData.put("NUM_TAX_ID",dataGeneratorProvider.generateTaxID());

		providerData.put("NUM_PROV_SSN",dataGeneratorProvider.generateSsn());
		providerData.put("NUM_PHONE",dataGeneratorProvider.generatePhone());
	    providerData.put("ADR_MAIL_STRT1",dataGeneratorProvider.generateStreet1());
		providerData.put("ADR_MAIL_STRT2",dataGeneratorProvider.generateStreet2());
		providerData.put("ADR_MAIL_CITY",dataGeneratorProvider.generateCity());
		providerData.put("ADR_MAIL_STATE",dataGeneratorProvider.generateState());
		providerData.put("ADR_MAIL_ZIP",dataGeneratorProvider.generateZip());
		
		providerData.put("ADR2_MAIL_STRT1",dataGeneratorProvider.generateStreet1());
		providerData.put("ADR2_MAIL_STRT2",dataGeneratorProvider.generateStreet2());
		providerData.put("ADR2_MAIL_CITY",dataGeneratorProvider.generateCity());
		providerData.put("ADR2_MAIL_STATE",dataGeneratorProvider.generateState());
		providerData.put("ADR2_MAIL_ZIP",dataGeneratorProvider.generateZip());

		providerData.put("ADR3_MAIL_STRT1",dataGeneratorProvider.generateStreet1());
		providerData.put("ADR3_MAIL_STRT2",dataGeneratorProvider.generateStreet2());
		providerData.put("ADR3_MAIL_CITY",dataGeneratorProvider.generateCity());
		providerData.put("ADR3_MAIL_STATE",dataGeneratorProvider.generateState());
		providerData.put("ADR3_MAIL_ZIP",dataGeneratorProvider.generateZip());
		providerData.put("ADR_EMAIL","NAP"+dataGeneratorProvider.generateEmail(providerData.get("ID_PROVIDER_MCD")+"@svam.com"));
		
		providerData.put("NUM_PHONE1",dataGeneratorProvider.generatePhone());
		providerData.put("special2","   1366523961"+specialType+"/21/198212/31/2299");
		providerData.put("ProvTypeSpeciality", specialType);
		
		return providerData;
	}
				

}
