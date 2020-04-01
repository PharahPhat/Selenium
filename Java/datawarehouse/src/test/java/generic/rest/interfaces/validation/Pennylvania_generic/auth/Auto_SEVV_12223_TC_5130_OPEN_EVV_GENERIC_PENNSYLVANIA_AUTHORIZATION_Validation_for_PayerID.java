package generic.rest.interfaces.validation.Pennylvania_generic.auth;

import com.sandata.models.DataModel;
import generic.rest.interfaces.InterfacesGenericTest;
import org.testng.annotations.Test;

public class Auto_SEVV_12223_TC_5130_OPEN_EVV_GENERIC_PENNSYLVANIA_AUTHORIZATION_Validation_for_PayerID extends InterfacesGenericTest {

    @Test
    public void Auto_SEVV_12223_TC_5130_OPEN_EVV_GENERIC_PENNSYLVANIA_AUTHORIZATION_Validation_for_PayerID() {
        InitData("TC_5130.json");
        for(int i = 0; i < data.length; i++){
            DataModel currentData = data[i];
            if(openEVV_Pennsylvania_Auth.PayerID(currentData.getDataType(), currentData.maxLength,currentData.input, currentData.expected) == false)
                errors.add(openEVV_Pennsylvania_Auth.errorMessage);
        }
        ValidateTestResult(errors);
    }

    @Test
    public void Auto_SEVV_12223_TC_5131_OPEN_EVV_GENERIC_PENNSYLVANIA_AUTHORIZATION_Validation_for_PayerProgram() {
        InitData("TC_5131.json");
        for(int i = 0; i < data.length; i++){
            DataModel currentData = data[i];
            if(openEVV_Pennsylvania_Auth.PayerProgram(currentData.getDataType(), currentData.maxLength,currentData.input, currentData.expected) == false)
                errors.add(openEVV_Pennsylvania_Auth.errorMessage);
        }
        ValidateTestResult(errors);
    }

}
