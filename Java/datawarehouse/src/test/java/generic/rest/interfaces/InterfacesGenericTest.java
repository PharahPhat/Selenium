package generic.rest.interfaces;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.sandata.models.DataModel;
import com.sandata.models.interfaces.alt_evv_generic.client.AltEVV_Generic_Client;
import com.sandata.models.interfaces.alt_evv_molina.employee.AltEVV_Molina_Employee;
import com.sandata.models.interfaces.alt_evv_pennylvania.employee.AltEVV_Pennylvania_Employee;
import com.sandata.models.interfaces.open_evv_generic.auth.OpenEVV_Pennsylvania_Auth;
import com.sandata.models.interfaces.open_evv_generic.member.OpenEVVMemberModel;
import com.sandata.models.interfaces.open_evv_generic.provider.Generic.Pennsylvania_Provider;
import generic.GenericTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class InterfacesGenericTest extends GenericTest {

    public List<String> errors =  new ArrayList<>();
    public DataModel[] data = null;

    public static String defaultFolder = System.getProperty("user.dir");
    public static String testDataFolder = "data";

    public AltEVV_Molina_Employee       altEVV_molina_employee = new AltEVV_Molina_Employee();
    public AltEVV_Pennylvania_Employee altEVV_pa_employee = new AltEVV_Pennylvania_Employee();
    public OpenEVVMemberModel openEVVMemberModel = new OpenEVVMemberModel();
    public Pennsylvania_Provider pennsylvania_provider = new Pennsylvania_Provider();
    public AltEVV_Generic_Client altEVV_Generic_Pennsylvania_client = new AltEVV_Generic_Client();
    public OpenEVV_Pennsylvania_Auth openEVV_Pennsylvania_Auth = new OpenEVV_Pennsylvania_Auth();

    public void InitData(String testcaseId){
        errors.clear();
        data = getDataTest(testcaseId);
        System.out.println();
    }


    public DataModel[] getDataTest(String testcaseId) {
        Gson gson = new Gson();
        try {
            JsonReader reader = new JsonReader(new FileReader(defaultFolder + File.separator + testDataFolder + File.separator + testcaseId));
            return gson.fromJson(reader, DataModel[].class); // contains the whole reviews list
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return  null;
    }

    public void ValidateTestResult(List<String> errors)
    {
        if(errors.size() > 0) {
            String resultError = "\n";
            for (String error : errors) {
                resultError += error + "\n";
            }
            logError(resultError);
        }
    }
}
