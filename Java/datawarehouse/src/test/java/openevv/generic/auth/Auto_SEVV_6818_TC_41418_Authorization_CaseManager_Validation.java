package openevv.generic.auth;

import com.interop.services.openevv.OpenEvvAuthService;
import com.interop.common.TestDataHelper;
import com.sandata.core.annotation.FieldValidation;
import com.interop.common.dataprovider.DataValidationModel;
import com.sandata.qtest.QTest;
import generic.GenericTest;
import io.qameta.allure.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.sql.SQLException;

/**
 * Author by Nhon Nguyen
 * Script run for AZ and HI
 */

public class Auto_SEVV_6818_TC_41418_Authorization_CaseManager_Validation extends GenericTest {
    private final String stringKey = stateAccount.getStateEnum().getStringKey();
    private final String fileName = "OpenEVV/Auth/OpenEVVAuth_" + stringKey + "_CaseManager_Validation.csv";
    private OpenEvvAuthService openEVVAuth = new OpenEvvAuthService();

    @DataProvider(name = "ValidationData")
    public Object[][] getInValidDataDriven(Method method) {
        FieldValidation annotation = method.getAnnotation(FieldValidation.class);
        String dataFilter = "";
        if (method.getAnnotationsByType(FieldValidation.class).length > 0) {
            dataFilter = annotation.propertyFilter();
        }
        return TestDataHelper.getFieldValidationDataRows(state, fileName, dataFilter);
    }

    @Test(dataProvider = "ValidationData", groups = {"openEVVAuth"}, testName = "CaseManagerFirstName")
    @QTest(keys = {"TC-41418"})
    @FieldValidation(propertyFilter = "CaseManagerFirstName")
    @Description("Field Validation Test for openevv Auth endpoint")
    public void Auto_SEVV_6818_TC_41418_OpenEVV_CaseManagerFirstName_Validation(DataValidationModel dataTest) throws SQLException {
        openEVVAuth.validateCaseManager(dataTest);
    }

    @Test(dataProvider = "ValidationData", groups = {"openEVVAuth"}, testName = "CaseManagerLastName")
    @QTest(keys = {"TC-41414"})
    @FieldValidation(propertyFilter = "CaseManagerLastName")
    @Description("Field Validation Test for openevv Auth endpoint")
    public void Auto_SEVV_6818_TC_41414_OpenEVV_CaseManagerLastName_Validation(DataValidationModel dataTest) throws SQLException {
        openEVVAuth.validateCaseManager(dataTest);
    }

    @Test(dataProvider = "ValidationData", groups = {"openEVVAuth"}, testName = "CaseManagerEmail")
    @FieldValidation(propertyFilter = "CaseManagerEmail")
    @QTest(keys = {"TC-41419"})
    @Description("Field Validation Test for openevv Auth endpoint")
    public void Auto_SEVV_6818_TC_41419_OpenEVV_CaseManagerEmail_Validation(DataValidationModel dataTest) throws SQLException {
        openEVVAuth.validateCaseManager(dataTest);
    }
}
