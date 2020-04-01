

package openevv.PA.Provider;



//import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.security.crypto.keygen.KeyGenerators;


        import com.globalMethods.core.Assertion_DbVerifier;
        import com.globalMethods.core.GenerateUniqueParam;

        import Utills_ExtentReport_Log4j.BaseTest;


import org.testng.annotations.Test;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
	

	public class TC10172 extends BaseTest{

		private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
		private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	
		 public static String encrypt(String secret, String salt, String data) throws Exception {
	            try {
	                IvParameterSpec iv = new IvParameterSpec(salt.getBytes("UTF-8"));
	                SecretKeySpec skeySpec = new SecretKeySpec(secret.getBytes("UTF-8"), "AES");

	                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
	                cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

	                byte[] encrypted = cipher.doFinal(data.getBytes());
	                return new String(Base64.getEncoder().encode(encrypted));

	            } catch (Exception e) {
	                e.printStackTrace();
	                throw new Exception(String.format("Security.AES: encrypt: %s: %s", e.getClass().getName(), e.getMessage()), e);
	            }
	        }

	        public static String decrypt(String secret, String salt, String encryptedData) throws Exception {
	            try {
	                IvParameterSpec iv = new IvParameterSpec(salt.getBytes("UTF-8"));
	                SecretKeySpec skeySpec = new SecretKeySpec(secret.getBytes("UTF-8"), "AES");

	                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
	                cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

	                byte[] original = cipher.doFinal(Base64.getDecoder().decode(encryptedData));

	                return new String(original);
	                
	            }
	            catch (Exception e) {
	                e.printStackTrace();
	                throw new Exception(String.format("Security.AES: decrypt: %s: %s", e.getClass().getName(), e.getMessage()), e);
	            }
	        }
	        
	 

	   @Test
	    public void Encryption_get() throws Exception {

	                  String secret = "9b22ea182ad61fcd";

	                  String text = "W+x3nvre";
	                  
	                  // logger = extent.startTest("TC89277_OpenEVV_Provider_ProviderName_maxlength");

	          		//JSONArray jsonArray = GenerateUniqueParam.ProviderParams_OpenEVV(globalVariables.openevv_provider_json);
	          		//JSONObject jsonObject = (JSONObject) jsonArray.get(0);

	          		//jsonObject.put("ProviderName", CommonMethods.generateRandomNumberOfFixLength(30));

	          		//String bodyAsString = CommonMethods.captureResponseOpenEVV_Provider(jsonArray, CommonMethods.propertyfileReader(globalVariables.provider_post_url).toString());
	          		//System.out.println(bodyAsString);
	          		//Assertion_DbVerifier.jsonAssert_inbox_Provider(bodyAsString, jsonObject);

	        
	          		String salt = KeyGenerators.string().generateKey(); // User generated salt value

	          		//select  password from  stx.app_users where account='10011' and USERNAMe='SANTRAX''

	        System.out.println("Salt: " + salt);

	 

	        String encryptedString = encrypt(secret, salt,text );

	 
           if (encryptedString==text)
           {
        	   System.out.println("Data not encrypted successfully!");
           }
	      
	 
	        System.out.println("Encrypted: " + encryptedString);

	 

	        String decryptedString = decrypt(secret, salt, encryptedString);

	 
             if (decryptedString==text)
             {
            	 System.out.println("Data decrypted successfully!");

             }
	        System.out.println("Decrypted: " + decryptedString);

	    }

	 

	    @Test

	    public void Decryption_TEST() throws Exception {

	                 String secret = "9b22ea182ad61fcd";

	        String encryptedUsername = "EeKWpBW7VDmLPXFW2LtqWQ==";

	        String encryptedPassword = "EeKWpBW7VDmLPXFW2LtqWQ==";

	        String salt = "9b22ea182ad61fcd";

	 

	        String username = decrypt(secret, salt, encryptedUsername);

	      //  Assert.isTrue(username.endsWith("Username"), "Expected encrypted string to decrypt as \"Username\"");
     System.out.println(encryptedUsername);
	 System.out.println(username);

	        String password = decrypt(secret, salt, encryptedPassword);

	       // Assert.isTrue(password.endsWith("Password"), "Expected encrypted string to decrypt as \"Password\"");

	    }

	}

