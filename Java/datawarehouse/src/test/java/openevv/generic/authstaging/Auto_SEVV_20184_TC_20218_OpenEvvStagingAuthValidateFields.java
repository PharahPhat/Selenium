package openevv.generic.authstaging;

import com.interop.common.StateAccount;
import com.interop.common.TestDataHelper;
import com.interop.common.dataprovider.DataValidationModel;
import com.interop.models.openevv.authorization.OpenEvvAuthorization;
import com.interop.models.openevv.authorization.OpenEvvAuthorizationDataGenerator;
import com.interop.services.base.DataValidationTest;
import com.interop.services.openevv.OpenEVVAuthStagingService;
import com.sandata.core.annotation.FieldValidation;
import com.sandata.qtest.QTest;
import generic.GenericTest;
import io.qameta.allure.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeoutException;

/**
 * Script run for AZ and HI
 */

public class Auto_SEVV_20184_TC_20218_OpenEvvStagingAuthValidateFields extends GenericTest {
    private static String stateKey = StateAccount.loadStateAccount().getStateEnum().getStringKey();
    private static final String fileName = "OpenEvv/AuthStaging/OpenEvvStagingAuth_" + stateKey + "_ValidationFields.csv";
    private DataValidationTest dataValidationTest;
    private OpenEVVAuthStagingService authStagingService;
    private OpenEvvAuthorization model;


    @DataProvider(name = "OpenEvvStagingAuthFieldValidation")
    public Object[][] getInValidDataDriven(Method method) {
        authStagingService = new OpenEVVAuthStagingService();
        authStagingService.setEntityGuid(true);
        model = OpenEvvAuthorizationDataGenerator.getDefaultOpenEvvAuthorization();
        dataValidationTest = new DataValidationTest(authStagingService, model);
        FieldValidation annotation = method.getAnnotation(FieldValidation.class);
        String dataFilter = "";
        if (method.getAnnotationsByType(FieldValidation.class).length > 0) {
            dataFilter = annotation.propertyFilter();
        }
        return TestDataHelper.getFieldValidationDataRows(state, fileName, dataFilter);
    }

    @Test(dataProvider = "OpenEvvStagingAuthFieldValidation", groups = {"openEVVAuthStaging", "smoke", "high"}, testName = "PayerID")
    @FieldValidation(propertyFilter = "PayerID")
    @QTest(keys = {"TC-23137"})
    @Description("Field Validation Test for openevv Auth endpoint and smoke test state: AZ_AMP")
    public void Field_PayerID_Validation(DataValidationModel dataTest) throws URISyntaxException, TimeoutException, NoSuchAlgorithmException, KeyManagementException {
        model = OpenEvvAuthorizationDataGenerator.getDefaultOpenEvvAuthorization();
        dataValidationTest = new DataValidationTest(authStagingService, model);
        dataValidationTest.validateDataValidationField(dataTest);
    }

    @Test(dataProvider = "OpenEvvStagingAuthFieldValidation", groups = {"openEVVAuthStaging"}, testName = "ClientQualifier")
    @FieldValidation(propertyFilter = "ClientQualifier")
    @QTest(keys = "TC-23145")
    @Description("Field Validation Test for openevv Auth endpoint")
    public void Field_ClientQualifier_Validation(DataValidationModel dataTest) throws URISyntaxException, TimeoutException, NoSuchAlgorithmException, KeyManagementException {
        model = OpenEvvAuthorizationDataGenerator.getDefaultOpenEvvAuthorization();
        dataValidationTest = new DataValidationTest(authStagingService, model);
        dataValidationTest.validateDataValidationField(dataTest);

    }

    @Test(dataProvider = "OpenEvvStagingAuthFieldValidation", groups = {"openEVVAuthStaging"}, testName = "ClientIdentifier")
    @FieldValidation(propertyFilter = "ClientIdentifier")
    @QTest(keys = "TC-23146")
    @Description("Field Validation Test for openevv Auth endpoint")
    public void Field_ClientIdentifier_Validation(DataValidationModel dataTest) throws URISyntaxException, TimeoutException, NoSuchAlgorithmException, KeyManagementException {
        model = OpenEvvAuthorizationDataGenerator.getDefaultOpenEvvAuthorization();
        dataValidationTest = new DataValidationTest(authStagingService, model);
        dataValidationTest.validateDataValidationField(dataTest);
    }

    @Test(dataProvider = "OpenEvvStagingAuthFieldValidation", groups = {"openEVVAuthStaging"}, testName = "ProviderQualifier")
    @FieldValidation(propertyFilter = "ProviderQualifier")
    @QTest(keys = "TC-23147")
    @Description("Field Validation Test for openevv Auth endpoint")
    public void Field_ProviderQualifier_Validation(DataValidationModel dataTest) throws URISyntaxException, TimeoutException, NoSuchAlgorithmException, KeyManagementException {
        model = OpenEvvAuthorizationDataGenerator.getDefaultOpenEvvAuthorization();
        dataValidationTest = new DataValidationTest(authStagingService, model);
        dataValidationTest.validateDataValidationField(dataTest);
    }

    @Test(dataProvider = "OpenEvvStagingAuthFieldValidation", groups = {"openEVVAuthStaging"}, testName = "ProviderID")
    @FieldValidation(propertyFilter = "ProviderID")
    @QTest(keys = "TC-23144")
    @Description("Field Validation Test for openevv Auth endpoint")
    public void Field_ProviderID_Validation(DataValidationModel dataTest) throws URISyntaxException, TimeoutException, NoSuchAlgorithmException, KeyManagementException {
        model = OpenEvvAuthorizationDataGenerator.getDefaultOpenEvvAuthorization();
        dataValidationTest = new DataValidationTest(authStagingService, model);
        dataValidationTest.validateDataValidationField(dataTest);
    }

    @Test(dataProvider = "OpenEvvStagingAuthFieldValidation", groups = {"openEVVAuthStaging"}, testName = "AuthorizationEndDate")
    @FieldValidation(propertyFilter = "AuthorizationEndDate")
    @QTest(keys = "TC-23148")
    @Description("Field Validation Test for openevv Auth endpoint")
    public void Field_AuthorizationEndDate_Validation(DataValidationModel dataTest) throws URISyntaxException, TimeoutException, NoSuchAlgorithmException, KeyManagementException {
        model = OpenEvvAuthorizationDataGenerator.getDefaultOpenEvvAuthorization();
        dataValidationTest = new DataValidationTest(authStagingService, model);
        dataValidationTest.validateDataValidationField(dataTest);
    }

    @Test(dataProvider = "OpenEvvStagingAuthFieldValidation", groups = {"openEVVAuthStaging"}, testName = "AuthorizationLimit[0].AuthorizationServiceID")
    @FieldValidation(propertyFilter = "AuthorizationLimit[0].AuthorizationServiceID")
    @QTest(keys = "TC-23139")
    @Description("Field Validation Test for openevv Auth endpoint")
    public void Field_AuthorizationServiceID_Validation(DataValidationModel dataTest) throws URISyntaxException, TimeoutException, NoSuchAlgorithmException, KeyManagementException {
        model = OpenEvvAuthorizationDataGenerator.getDefaultOpenEvvAuthorization();
        dataValidationTest = new DataValidationTest(authStagingService, model);
        dataValidationTest.validateDataValidationField(dataTest);
    }

    @Test(dataProvider = "OpenEvvStagingAuthFieldValidation", groups = {"openEVVAuthStaging"}, testName = "AuthorizationLimit[0].PayerProgram")
    @FieldValidation(propertyFilter = "AuthorizationLimit[0].PayerProgram")
    @QTest(keys = "TC-23138")
    @Description("Field Validation Test for openevv Auth endpoint")
    public void Field_PayerProgram_Validation(DataValidationModel dataTest) throws URISyntaxException, TimeoutException, NoSuchAlgorithmException, KeyManagementException {
        model = OpenEvvAuthorizationDataGenerator.getDefaultOpenEvvAuthorization();
        dataValidationTest = new DataValidationTest(authStagingService, model);
        dataValidationTest.validateDataValidationField(dataTest);
    }

    @Test(dataProvider = "OpenEvvStagingAuthFieldValidation", groups = {"openEVVAuthStaging"}, testName = "AuthorizationLimit[0].Modifier1")
    @FieldValidation(propertyFilter = "AuthorizationLimit[0].Modifier1")
    @QTest(keys = "TC-23140")
    @Description("Field Validation Test for openevv Auth endpoint")
    public void Field_Modifier1_Validation(DataValidationModel dataTest) throws URISyntaxException, TimeoutException, NoSuchAlgorithmException, KeyManagementException {
        model = OpenEvvAuthorizationDataGenerator.getDefaultOpenEvvAuthorization();
        dataValidationTest = new DataValidationTest(authStagingService, model);
        dataValidationTest.validateDataValidationField(dataTest);
    }

    @Test(dataProvider = "OpenEvvStagingAuthFieldValidation", groups = {"openEVVAuthStaging"}, testName = "AuthorizationLimit[0].Modifier2")
    @FieldValidation(propertyFilter = "AuthorizationLimit[0].Modifier2")
    @Description("Field Validation Test for openevv Auth endpoint")
    @QTest(keys = "TC-23141")
    public void Field_Modifier2_Validation(DataValidationModel dataTest) throws URISyntaxException, TimeoutException, NoSuchAlgorithmException, KeyManagementException {
        model = OpenEvvAuthorizationDataGenerator.getDefaultOpenEvvAuthorization();
        dataValidationTest = new DataValidationTest(authStagingService, model);
        dataValidationTest.validateDataValidationField(dataTest);
    }

    @Test(dataProvider = "OpenEvvStagingAuthFieldValidation", groups = {"openEVVAuthStaging"}, testName = "AuthorizationLimit[0].Modifier3")
    @FieldValidation(propertyFilter = "AuthorizationLimit[0].Modifier3")
    @QTest(keys = "TC-23142")
    @Description("Field Validation Test for openevv Auth endpoint")
    public void Field_Modifier3_Validation(DataValidationModel dataTest) throws URISyntaxException, TimeoutException, NoSuchAlgorithmException, KeyManagementException {
        model = OpenEvvAuthorizationDataGenerator.getDefaultOpenEvvAuthorization();
        dataValidationTest = new DataValidationTest(authStagingService, model);
        dataValidationTest.validateDataValidationField(dataTest);
    }

    @Test(dataProvider = "OpenEvvStagingAuthFieldValidation", groups = {"openEVVAuthStaging"}, testName = "AuthorizationLimit[0].Modifier4")
    @FieldValidation(propertyFilter = "AuthorizationLimit[0].Modifier4")
    @QTest(keys = "TC-23143")
    @Description("Field Validation Test for openevv Auth endpoint")
    public void Field_Modifier4_Validation(DataValidationModel dataTest) throws URISyntaxException, TimeoutException, NoSuchAlgorithmException, KeyManagementException {
        model = OpenEvvAuthorizationDataGenerator.getDefaultOpenEvvAuthorization();
        dataValidationTest = new DataValidationTest(authStagingService, model);
        dataValidationTest.validateDataValidationField(dataTest);
    }

    @Test(dataProvider = "OpenEvvStagingAuthFieldValidation", groups = {"openEVVAuthStaging", "smoke", "high"}, testName = "MedicalNecessityDeterminationDate")
    @FieldValidation(propertyFilter = "MedicalNecessityDeterminationDate")
    @Description("Field Validation Test for openevv Auth endpoint and smoke test. State: AZ_AMP")
    public void Field_AssessmentDate_Validation(DataValidationModel dataTest) throws URISyntaxException, TimeoutException, NoSuchAlgorithmException, KeyManagementException {
        model = OpenEvvAuthorizationDataGenerator.getDefaultOpenEvvAuthorization();
        dataValidationTest = new DataValidationTest(authStagingService, model);
        dataValidationTest.validateDataValidationField(dataTest);
    }

    @Test(dataProvider = "OpenEvvStagingAuthFieldValidation", groups = {"openEVVAuthStaging"}, testName = "PayerRegion")
    @FieldValidation(propertyFilter = "PayerRegion")
    @QTest(keys = "TC-23150")
    @Description("Field Validation Test for openevv Auth endpoint")
    public void Field_PayerRegion_Validation(DataValidationModel dataTest) throws URISyntaxException, TimeoutException, NoSuchAlgorithmException, KeyManagementException {
        model = OpenEvvAuthorizationDataGenerator.getDefaultOpenEvvAuthorization();
        dataValidationTest = new DataValidationTest(authStagingService, model);
        dataValidationTest.validateDataValidationField(dataTest);

    }

    @Test(dataProvider = "OpenEvvStagingAuthFieldValidation", groups = {"openEVVAuthStaging"}, testName = "DiagnosisCode[0].ClientDiagnosisCodeIsPrimary")
    @FieldValidation(propertyFilter = "DiagnosisCode[0].ClientDiagnosisCodeIsPrimary")
    @QTest(keys = "TC-23151")
    @Description("Field Validation Test for openevv Auth endpoint")
    public void Field_ClientDiagnosisCodeIsPrimary_Validation(DataValidationModel dataTest) throws URISyntaxException, TimeoutException, NoSuchAlgorithmException, KeyManagementException {
        model = OpenEvvAuthorizationDataGenerator.getDefaultOpenEvvAuthorization();
        dataValidationTest = new DataValidationTest(authStagingService, model);
        dataValidationTest.validateDataValidationField(dataTest);
    }

    @Test(dataProvider = "OpenEvvStagingAuthFieldValidation", groups = {"openEVVAuthStaging"}, testName = "DiagnosisCode[0].ClientDiagnosisCode")
    @FieldValidation(propertyFilter = "DiagnosisCode[0].ClientDiagnosisCode")
    @QTest(keys = {"TC-23155", "TC-23152"})
    @Description("Field Validation Test for openevv Auth endpoint")
    public void Field_ClientDiagnosisCode_Validation(DataValidationModel dataTest) throws URISyntaxException, TimeoutException, NoSuchAlgorithmException, KeyManagementException {
        model = OpenEvvAuthorizationDataGenerator.getDefaultOpenEvvAuthorization();
        dataValidationTest = new DataValidationTest(authStagingService, model);
        dataValidationTest.validateDataValidationField(dataTest);
    }

    @Test(dataProvider = "OpenEvvStagingAuthFieldValidation", groups = {"openEVVAuthStaging"}, testName = "HFAAssessmentDate")
    @FieldValidation(propertyFilter = "HFAAssessmentDate")
    @QTest(keys = "TC-23153")
    @Description("Field Validation Test for openevv Auth endpoint")
    public void Field_HFAAssessmentDate_Validation(DataValidationModel dataTest) throws URISyntaxException, TimeoutException, NoSuchAlgorithmException, KeyManagementException {
        model = OpenEvvAuthorizationDataGenerator.getDefaultOpenEvvAuthorization();
        dataValidationTest = new DataValidationTest(authStagingService, model);
        dataValidationTest.validateDataValidationField(dataTest);
    }

    @Test(dataProvider = "OpenEvvStagingAuthFieldValidation", groups = {"openEVVAuthStaging"}, testName = "AuthorizationLimit[0].AuthorizationLimit")
    @FieldValidation(propertyFilter = "AuthorizationLimit[0].AuthorizationLimit")
    @QTest(keys = {"TC-23154", "TC-23158", "TC-23156"})
    @Description("Field Validation Test for openevv Auth endpoint")
    public void Field_AuthorizationLimit_Validation(DataValidationModel dataTest) throws URISyntaxException, TimeoutException, NoSuchAlgorithmException, KeyManagementException {
        model = OpenEvvAuthorizationDataGenerator.getDefaultOpenEvvAuthorization();
        model.setAuthorizationLimitType("D");
        dataValidationTest = new DataValidationTest(authStagingService, model);
        dataValidationTest.validateDataValidationField(dataTest);
    }

    @Test(dataProvider = "OpenEvvStagingAuthFieldValidation", groups = {"openEVVAuthStaging"}, testName = "AuthorizationLimit[0].AuthorizationWeekStart")
    @FieldValidation(propertyFilter = "AuthorizationLimit[0].AuthorizationWeekStart")
    @QTest(keys = "TC-23248")
    @Description("Field Validation Test for openevv Auth endpoint")
    public void Field_AuthorizationWeekStart_Validation(DataValidationModel dataTest) throws URISyntaxException, TimeoutException, NoSuchAlgorithmException, KeyManagementException {
        model = OpenEvvAuthorizationDataGenerator.getDefaultOpenEvvAuthorization();
        model.setAuthorizationLimitType("D");
        dataValidationTest = new DataValidationTest(authStagingService, model);
        dataValidationTest.validateDataValidationField(dataTest);
    }

    @Test(dataProvider = "OpenEvvStagingAuthFieldValidation", groups = {"openEVVAuthStaging"}, testName = "AuthorizationLimit[0].AuthorizationLimitDayOfWeek")
    @FieldValidation(propertyFilter = "AuthorizationLimit[0].AuthorizationLimitDayOfWeek")
    @QTest(keys = "TC-23249")
    @Description("Field Validation Test for openevv Auth endpoint")
    public void Field_AuthorizationLimitDayOfWeek_Validation(DataValidationModel dataTest) throws URISyntaxException, TimeoutException, NoSuchAlgorithmException, KeyManagementException {
        model = OpenEvvAuthorizationDataGenerator.getDefaultOpenEvvAuthorization();
        model.setAuthorizationLimitType("D");
        dataValidationTest = new DataValidationTest(authStagingService, model);
        dataValidationTest.validateDataValidationField(dataTest);
    }
}
