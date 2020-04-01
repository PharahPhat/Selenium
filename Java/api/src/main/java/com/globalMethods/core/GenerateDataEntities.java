package com.globalMethods.core;

import com.globalMethods.core.DataGeneratorClient;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import com.globalMethods.core.DataGeneratorEmployee;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GenerateDataEntities {

    public GenerateDataEntities(){

    }

    public JSONArray loadDWHJsonData(String jsonFileName) throws InterruptedException, java.text.ParseException,  IOException, ParseException{
        JSONParser parser = new JSONParser();
        JSONArray j = (JSONArray) parser.parse(new FileReader(System.getProperty("user.dir") + File.separator +"src" + File.separator + "main"+ File.separator
                + "java" +File.separator+ "Resources"+ File.separator+ "DWHExport"+File.separator +jsonFileName+".json"));
        return j;
    }

    @SuppressWarnings("unchecked")
    public JSONArray generateClientData(String jsonClientName, String providerId)  {
        try {
            JSONArray j = loadDWHJsonData(jsonClientName);
            JSONObject js = (JSONObject) j.get(0);

            js.put("ClientID", DataGeneratorClient.generateClientID(5));

            js.put("ClientSSN", DataGeneratorClient.generateClientSSN(9));

            js.put("ClientOtherID", DataGeneratorClient.generateRecipientIDCustom2(12));

            js.put("ClientFirstName", DataGeneratorClient.generateClientFirstName(10));

            js.put("ClientLastName", DataGeneratorClient.generateClientLastName(10));

            js.put("ClientMedicaidID", CommonMethods.generateRandomNumberOfFixLength(10));

            js.put("ClientIdentifier", DataGeneratorClient.generateClientID(9));

            js.put("SequenceID", DataGeneratorClient.generateClientID(8));

            JSONObject providerIdentification = (JSONObject) js.get("ProviderIdentification");
            providerIdentification.put("ProviderID", providerId);

            //create new unique phone number to compare with CLIENT_PHONE file
            String newClientPhone = DataGeneratorClient.generateClientPhone(10);
            JSONArray clientPhones = (JSONArray) js.get("ClientPhone");
            JSONObject clientPhone = (JSONObject) clientPhones.get(0);
            clientPhone.put("ClientPhone", newClientPhone);

            JSONObject clientPhone2 = (JSONObject) clientPhones.get(1);
            clientPhone2.put("ClientPhone", newClientPhone);

            return j;
        }catch (Exception ex){
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public JSONArray GenerateEmployeeData_OpenEVV(String jsonnameemp, String account) throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException {

        JSONArray j=CommonMethods.LoadJSON_OpenEVV(jsonnameemp);

        JSONObject js = (JSONObject) j.get(0);

        js.put("Account", account);

        js.put("EmployeePIN", DataGeneratorEmployee.generateEmpPIN(9));

        js.put("EmployeeFirstName", CommonMethods.generateRandomStringOfFixLength(5));

        js.put("EmployeeLastName", CommonMethods.generateRandomStringOfFixLength(5));

        js.put("EmployeePhone", CommonMethods.generateRandomNumberOfFixLength(10));

        js.put("EmployeeAltPhone", CommonMethods.generateRandomNumberOfFixLength(10));

        js.put("EmployeeAltPhone2", CommonMethods.generateRandomNumberOfFixLength(10));

        js.put("EmployeeID", CommonMethods.generateRandomNumberOfFixLength(5));

        js.put("EmployeeSocialSecurity", CommonMethods.generateRandomNumberOfFixLength(9));

        return j;

    }

    @SuppressWarnings("unchecked")
    public JSONArray GenerateEmployeeData_AltEVV(String jsonnameemp, String providerId) throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException {

        JSONArray j=CommonMethods.LoadJSON_AltEVV(jsonnameemp);

        JSONObject js = (JSONObject) j.get(0);

        String empssn = DataGeneratorEmployee.generateEmpPIN(9);

        js.put("EmployeeFirstName", CommonMethods.generateRandomStringOfFixLength(10));

        js.put("EmployeeLastName", CommonMethods.generateRandomStringOfFixLength(10));

        js.put("SequenceID", CommonMethods.generateRandomNumberOfFixLength(8));

        js.put("EmployeeSSN", empssn);

        js.put("EmployeeEmail", DataGeneratorEmployee.generateEmpEmail(14));

        js.put("EmployeeIdentifier", empssn);

        JSONObject providerIdentification = (JSONObject) js.get("ProviderIdentification");
        providerIdentification.put("ProviderID", providerId);

        return j;

    }
}
