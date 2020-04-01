package openevv.generic.client;

import com.interop.common.Commons;
import com.interop.common.TestDataHelper;
import com.interop.common.dataprovider.DataValidationModel;
import com.interop.models.openevv.client.OpenEvvClient;
import com.interop.models.openevv.client.OpenEvvClientDataGenerator;
import com.interop.models.openevv.client.OpenEvvClientV1;
import com.interop.services.base.DataValidationTest;
import com.interop.services.openevv.OpenEvvClientService;
import com.interop.services.openevv.OpenEvvClientServiceV1;
import com.sandata.core.annotation.FieldValidation;
import com.sandata.qtest.QTest;
import generic.GenericTest;
import io.qameta.allure.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * Author by: NhonNguyen
 * Run Script for HI, AZ, VT, AZ_AMP, HI_AMP
 */

@SuppressWarnings({"rawtypes", "unchecked"})
public class Auto_SEVV_6462_TC_20665_OpenEVVClient_Validation extends GenericTest {
    private final String stringKey = stateAccount.getStateEnum().getStringKey();
    private DataValidationTest dataValidationTest;

    @DataProvider(name = "OpenEVVClientDataDriven")
    public Object[][] getDataDriven(Method method) {
        OpenEvvClient client = OpenEvvClientDataGenerator.getOpenEvvClientByState(stateAccount);
        OpenEvvClientService openEvvClientService = new OpenEvvClientService();
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
            return TestDataHelper.getFieldValidationDataRows(Commons.AccountType.GENERIC.toString(), fileName, dataFilter);
        }
        else {
            fileName = "OpenEVV/Client/OpenEVVClient_" + stringKey + "_Validation.csv";
            return TestDataHelper.getFieldValidationDataRows(state, fileName, dataFilter);
        }
    }

    @Test(dataProvider = "OpenEVVClientDataDriven")
    @QTest(keys = {"TC-23043"})
    public void SEVV_6462_TC_20665_OpenEVVClient_Validation(DataValidationModel dataTest) {
        dataValidationTest.validateDataValidationField(dataTest);
    }

    @Test(dataProvider = "OpenEVVClientDataDriven", groups = {"smoke","high"})
    @Description("Field Validation Test for Open EVV ClientGender and Smoke test. State: AZ_AMP")
    @QTest(keys = {"TC-23043","TC-23061"})
    @FieldValidation(propertyFilter = "ClientGender")
    public void TC_20755_OpenEvvClient_Validation_Fields_valid_ClientGender(DataValidationModel dataTest) {
        dataValidationTest.validateDataValidationField(dataTest);
    }

    @Test(dataProvider = "OpenEVVClientDataDriven", groups = {"smoke","high"})
    @Description("Field Validation Test for Open EVV ClientBirthDate")
    @QTest(keys = {"TC-23043","TC-23061"})
    @FieldValidation(propertyFilter = "ClientBirthDate")
    public void TC_20755_OpenEvvClient_Validation_Fields_valid_ClientBirthDate(DataValidationModel dataTest) {
        dataValidationTest.validateDataValidationField(dataTest);
    }
}
