package openevv.hawaii.client;

import com.interop.common.Commons;
import com.interop.common.TestDataHelper;
import com.interop.common.dataprovider.DataValidationModel;
import com.interop.models.openevv.client.OpenEvvClientDataGenerator;
import com.interop.models.openevv.client.OpenEvvClientV1;
import com.interop.services.base.DataValidationTest;
import com.interop.services.openevv.OpenEvvClientServiceV1;
import com.sandata.core.annotation.FieldValidation;
import com.sandata.qtest.QTest;
import generic.GenericTest;
import io.qameta.allure.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * Author by NhonNguyen
 * Script could be run on HI
 */

@SuppressWarnings({"rawtypes", "unchecked"})
public class Auto_SEVV_19556_TC_22320_OpenEVVGeneric_Client_ClientContactSegment_Validation extends GenericTest{
    private final String stringKey = stateAccount.getStateEnum().getStringKey();
    private final String fileName = "OpenEVV/Client/OpenEVVClient_" + stringKey + "_MultiContactSegmentValidation.csv";
    private DataValidationTest dataValidationTest;
    @DataProvider(name = "FieldValidation")
    public Object[][] getDataDriven(Method method) {
        OpenEvvClientV1 client = OpenEvvClientDataGenerator.getOpenEvvClientByStateV1(stateAccount.getStateEnum());
        OpenEvvClientServiceV1 openEvvClientServiceV1 = new OpenEvvClientServiceV1();
        dataValidationTest = new DataValidationTest(openEvvClientServiceV1, client);
        FieldValidation annotation = method.getAnnotation(FieldValidation.class);
        String dataFilter = "";
        if (method.getAnnotationsByType(FieldValidation.class).length > 0) {
            method.getAnnotation(FieldValidation.class);
            dataFilter = annotation.propertyFilter();
        }
        return TestDataHelper.getFieldValidationDataRows(state, fileName, dataFilter);
    }

    @Test(dataProvider = "FieldValidation", groups = {"arizona", "client"}, testName = "ClientDesigneeEmail Validation")
    @FieldValidation(propertyFilter = "ClientContacts[0]")
    @Description("Field Validation Test for Open EVV Member endpoint")
    @QTest(keys = {"TC-22320"})
    public void Auto_SEVV_19556_OpenEVVGeneric_Client_ClientContactSegment_Validation(DataValidationModel dataTest) {
        dataValidationTest.validateDataValidationField(dataTest);
    }

    @DataProvider(name = "OpenEVVClientV1DataDriven")
    public Object[][] getDataDrivenV1(Method method) {
        OpenEvvClientV1 client = OpenEvvClientDataGenerator.getOpenEvvClientByStateV1(stateAccount.getStateEnum());
        OpenEvvClientServiceV1 openEvvClientService = new OpenEvvClientServiceV1();
        String fileName;
        dataValidationTest = new DataValidationTest(openEvvClientService, client);
        FieldValidation annotation = method.getAnnotation(FieldValidation.class);
        String dataFilter = "";
        if (method.getAnnotationsByType(FieldValidation.class).length > 0) {
            dataFilter = annotation.propertyFilter();
        }
        if (Commons.AccountType.AMP.toString().equalsIgnoreCase(stateAccount.getAccountType())) {
            fileName = "OpenEVV/Client/OpenEVVClient_Generic_Validation.csv";
            openEvvClientService.setAMPAccount(true);
            return TestDataHelper.getFieldValidationDataRows("Generic", fileName, dataFilter);
        }
        else {
            fileName = "OpenEVV/Client/OpenEVVClient_" + stringKey + "_Validation.csv";
            return TestDataHelper.getFieldValidationDataRows(state, fileName, dataFilter);
        }
    }

    @Test(dataProvider = "OpenEVVClientV1DataDriven")
    public void SEVV_6462_TC_20665_OpenEVVClientV1_Validation(DataValidationModel dataTest) {
        dataValidationTest.validateDataValidationField(dataTest);
    }

}
