package altevv.generic.client;

import com.interop.common.StateAccount;
import com.interop.common.TestDataHelper;
import com.interop.common.dataprovider.DataValidationModel;
import com.interop.models.altevv.client.AltEvvClient;
import com.interop.models.altevv.client.AltEvvClientDataGenerator;
import com.interop.services.atlevv.AltEvvClientService;
import com.interop.services.base.DataValidationTest;
import com.sandata.core.annotation.FieldValidation;
import com.sandata.qtest.QTest;
import generic.GenericTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * Make Sure The Testing Account Is Turn Off Bit 14 In Transfer_explain In Table Account_transfer
 * If not turning off this bit, the script will be failed when checking db
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public class Auto_SEVV_TC_20218_AltClientValidateFields extends GenericTest {
    private static String stateKey = StateAccount.loadStateAccount().getStateEnum().getStringKey();
    private static final String fileName = "AltEVV/Client/AltGenericClient_" + stateKey + "_FieldValidation.csv";
    private AltEvvClientService altEVVGenericClient = new AltEvvClientService();

    @DataProvider(name = "CustomFieldValidation")
    public Object[][] getDataCustomFieldValidation(Method method) {
        FieldValidation annotation = method.getAnnotation(FieldValidation.class);
        String dataFilter = "";
        if (method.getAnnotationsByType(FieldValidation.class).length > 0) {
            method.getAnnotation(FieldValidation.class);
            dataFilter = annotation.propertyFilter();
        }
        return TestDataHelper.getFieldValidationDataRows(this.state, fileName, dataFilter);
    }

    @Test(dataProvider = "CustomFieldValidation", groups = {"generic", "altClient", "smoke", "high"},
            testName = "ProviderIdentification.ProviderID Validation")
    @FieldValidation(propertyFilter = "ProviderIdentification.ProviderID")
    @QTest(keys = {"TC-22778"})
    public void Auto_SEVV_TC_38807_AltGeneric_ProviderIdentification_ProviderID(DataValidationModel dataTest) {
        AltEvvClient model = AltEvvClientDataGenerator.getDefaultAltEvvClientWithUniqueValue(StateAccount.loadStateAccount());
        DataValidationTest dataValidationTest = new DataValidationTest(this.altEVVGenericClient, model);
        dataValidationTest.validateDataValidationField(dataTest);
    }

    @Test(dataProvider = "CustomFieldValidation", groups = {"generic", "altClient", "smoke", "high"},
            testName = "Client Qualifier Validation")
    @FieldValidation(propertyFilter = "ClientQualifier")
    @QTest(keys = {"TC-22778", "TC-22642"})
    public void Auto_SEVV_TC_38770_AltGeneric_ClientQualifier(DataValidationModel dataTest) {
        AltEvvClient model = AltEvvClientDataGenerator.getDefaultAltEvvClientWithUniqueValue(StateAccount.loadStateAccount());
        DataValidationTest dataValidationTest = new DataValidationTest(this.altEVVGenericClient, model);
        dataValidationTest.validateDataValidationField(dataTest);
    }

    @Test(dataProvider = "CustomFieldValidation", groups = {"generic", "altClient", "smoke", "high"},
            testName = "ProviderIdentification.ProviderQualifier Validation")
    @FieldValidation(propertyFilter = "ProviderIdentification.ProviderQualifier")
    @QTest(keys = {"TC-22778", "TC-22647"})
    public void Auto_SEVV_TC_38807_AltGeneric_ProviderIdentification_ProviderQualifier(DataValidationModel dataTest) {
        AltEvvClient model = AltEvvClientDataGenerator.getDefaultAltEvvClientWithUniqueValue(StateAccount.loadStateAccount());
        DataValidationTest dataValidationTest = new DataValidationTest(this.altEVVGenericClient, model);
        dataValidationTest.validateDataValidationField(dataTest);
    }

    @Test(dataProvider = "CustomFieldValidation", groups = {"generic", "altClient", "smoke", "high"}, testName = "ClientPayerInformation Validation")
    @FieldValidation(propertyFilter = "ClientPayerInformation[0].ProcedureCode")
    @QTest(keys = {"TC-22778"})
    public void Auto_SEVV_TC_38784_AltGeneric_ProcedureCode(DataValidationModel dataTest) {
        AltEvvClient model = AltEvvClientDataGenerator.getDefaultAltEvvClientWithUniqueValue(StateAccount.loadStateAccount());
        DataValidationTest dataValidationTest = new DataValidationTest(this.altEVVGenericClient, model);
        dataValidationTest.validateDataValidationField(dataTest);
    }

    @Test(dataProvider = "CustomFieldValidation", groups = {"generic", "altClient", "smoke", "high"}, testName = "ClientPayerInformation Validation")
    @FieldValidation(propertyFilter = "ClientPayerInformation[0].PayerProgram")
    @QTest(keys = {"TC-22778"})
    public void Auto_SEVV_TC_38784_AltGeneric_PayerProgram(DataValidationModel dataTest) {
        AltEvvClient model = AltEvvClientDataGenerator.getDefaultAltEvvClientWithUniqueValue(StateAccount.loadStateAccount());
        DataValidationTest dataValidationTest = new DataValidationTest(this.altEVVGenericClient, model);
        dataValidationTest.validateDataValidationField(dataTest);
    }

    @Test(dataProvider = "CustomFieldValidation", groups = {"generic", "altClient", "smoke", "high"}, testName = "ClientPayerInformation Validation")
    @FieldValidation(propertyFilter = "ClientPayerInformation[0].PayerID")
    @QTest(keys = {"TC-22778"})
    public void Auto_SEVV_TC_38784_AltGeneric_PayerID(DataValidationModel dataTest) {
        AltEvvClient model = AltEvvClientDataGenerator.getDefaultAltEvvClientWithUniqueValue(StateAccount.loadStateAccount());
        DataValidationTest dataValidationTest = new DataValidationTest(this.altEVVGenericClient, model);
        dataValidationTest.validateDataValidationField(dataTest);
    }

    @Test(dataProvider = "CustomFieldValidation", groups = {"generic", "altClient", "ClientMedicaidID"}, testName = "ClientMedicaidID Validation")
    @FieldValidation(propertyFilter = "ClientMedicaidID")
    @QTest(keys = {"TC-22778", "TC-22643"})
    public void Auto_SEVV_TC_12344_AltGeneric_ClientMedicaidID(DataValidationModel dataTest) {
        AltEvvClient model = AltEvvClientDataGenerator.getDefaultAltEvvClientWithUniqueValue(StateAccount.loadStateAccount());
        DataValidationTest dataValidationTest = new DataValidationTest(this.altEVVGenericClient, model);
        dataValidationTest.validateDataValidationField(dataTest);
    }

    @Test(dataProvider = "CustomFieldValidation", groups = {"generic", "altClient", "ClientIdentifier"}, testName = "ClientIdentifier Validation")
    @FieldValidation(propertyFilter = "ClientIdentifier")
    @QTest(keys = {"TC-22778"})
    public void Auto_SEVV_TC_38772_AltGeneric_ClientIdentifier(DataValidationModel dataTest) {
        AltEvvClient model = AltEvvClientDataGenerator.getDefaultAltEvvClientWithUniqueValue(StateAccount.loadStateAccount());
        DataValidationTest dataValidationTest = new DataValidationTest(this.altEVVGenericClient, model);
        dataValidationTest.validateDataValidationField(dataTest);
    }

    @Test(dataProvider = "CustomFieldValidation", groups = {"generic", "altClient", "ClientCustomID"}, testName = "ClientCustomID Validation")
    @FieldValidation(propertyFilter = "ClientCustomID")
    @QTest(keys = {"TC-22778", "TC-22645"})
    public void Auto_SEVV_TC_38787_AltGeneric_ClientCustomID(DataValidationModel dataTest) {
        AltEvvClient model = AltEvvClientDataGenerator.getDefaultAltEvvClientWithUniqueValue(StateAccount.loadStateAccount());
        DataValidationTest dataValidationTest = new DataValidationTest(this.altEVVGenericClient, model);
        dataValidationTest.validateDataValidationField(dataTest);
    }

    @Test(dataProvider = "CustomFieldValidation", groups = {"generic", "altClient", "ClientOtherID"}, testName = "ClientOtherID Validation")
    @FieldValidation(propertyFilter = "ClientOtherID")
    @QTest(keys = {"TC-22778", "TC-22646"})
    public void Auto_SEVV_TC_38788_AltGeneric_ClientOtherID(DataValidationModel dataTest) {
        AltEvvClient model = AltEvvClientDataGenerator.getDefaultAltEvvClientWithUniqueValue(StateAccount.loadStateAccount());
        DataValidationTest dataValidationTest = new DataValidationTest(this.altEVVGenericClient, model);
        dataValidationTest.validateDataValidationField(dataTest);
    }

    @Test(dataProvider = "CustomFieldValidation", groups = {"generic", "altClient", "MissingMedicaidID"}, testName = "MissingMedicaidID Validation")
    @FieldValidation(propertyFilter = "MissingMedicaidID")
    @QTest(keys = {"TC-22778", "TC-22649"})
    public void Auto_SEVV_TC_39707_AltGeneric_MissingMedicaidID(DataValidationModel dataTest) {
        AltEvvClient model = AltEvvClientDataGenerator.getDefaultAltEvvClientWithUniqueValue(StateAccount.loadStateAccount());
        DataValidationTest dataValidationTest = new DataValidationTest(this.altEVVGenericClient, model);
        dataValidationTest.validateDataValidationField(dataTest);
    }

    @Test(dataProvider = "CustomFieldValidation", groups = {"generic", "altClient", "ClientAddress"}, testName = "ClientAddress Validation")
    @FieldValidation(propertyFilter = "ClientAddress[0]")
    @QTest(keys = {"TC-22778"})
    public void Auto_SEVV_TC_38774_AltGeneric_ClientAddress(DataValidationModel dataTest) {
        AltEvvClient model = AltEvvClientDataGenerator.getDefaultAltEvvClientWithUniqueValue(StateAccount.loadStateAccount());
        DataValidationTest dataValidationTest = new DataValidationTest(this.altEVVGenericClient, model);
        dataValidationTest.validateDataValidationField(dataTest);
    }

    @Test(dataProvider = "CustomFieldValidation", groups = {"generic", "altClient", "ClientPhone"}, testName = "ClientPhone Validation")
    @FieldValidation(propertyFilter = "ClientPhone[0]")
    @QTest(keys = {"TC-22778"})
    public void Auto_SEVV_TC_38803_AltGeneric_ClientPhone(DataValidationModel dataTest) {
        AltEvvClient model = AltEvvClientDataGenerator.getDefaultAltEvvClientWithUniqueValue(StateAccount.loadStateAccount());
        DataValidationTest dataValidationTest = new DataValidationTest(this.altEVVGenericClient, model);
        dataValidationTest.validateDataValidationField(dataTest);
    }

    @Test(dataProvider = "CustomFieldValidation", groups = {"generic", "altClient", "ClientResponsibleParty"}, testName = "ClientResponsibleParty Validation")
    @FieldValidation(propertyFilter = "ClientResponsibleParty[0]")
    @QTest(keys = {"TC-22778"})
    public void Auto_SEVV_TC_38790_AltGeneric_ClientResponsibleParty(DataValidationModel dataTest) {
        AltEvvClient model = AltEvvClientDataGenerator.getDefaultAltEvvClientWithUniqueValue(StateAccount.loadStateAccount());
        DataValidationTest dataValidationTest = new DataValidationTest(this.altEVVGenericClient, model);
        dataValidationTest.validateDataValidationField(dataTest);
    }

    @Test(dataProvider = "CustomFieldValidation", groups = {"generic", "altClient", "ProviderIdentification"}, testName = "ProviderIdentification Validation")
    @FieldValidation(propertyFilter = "ProviderIdentification")
    @QTest(keys = {"TC-22778"})
    public void Auto_SEVV_TC_38808_AltGeneric_ProviderIdentification(DataValidationModel dataTest) {
        AltEvvClient model = AltEvvClientDataGenerator.getDefaultAltEvvClientWithUniqueValue(StateAccount.loadStateAccount());
        DataValidationTest dataValidationTest = new DataValidationTest(this.altEVVGenericClient, model);
        dataValidationTest.validateDataValidationField(dataTest);
    }

    @Test(dataProvider = "CustomFieldValidation", groups = {"generic", "altClient", "SequenceID"}, testName = "SequenceID Validation")
    @FieldValidation(propertyFilter = "SequenceID")
    @QTest(keys = {"TC-22778"})
    public void Auto_SEVV_TC_38773_AltGeneric_SequenceID(DataValidationModel dataTest) {
        AltEvvClient model = AltEvvClientDataGenerator.getDefaultAltEvvClientWithUniqueValue(StateAccount.loadStateAccount());
        DataValidationTest dataValidationTest = new DataValidationTest(this.altEVVGenericClient, model);
        dataValidationTest.validateDataValidationField(dataTest);
    }

    @Test(dataProvider = "CustomFieldValidation", groups = {"generic", "altClient", "ClientTimeZone"}, testName = "Client Timezone Validation")
    @FieldValidation(propertyFilter = "ClientTimezone")
    @QTest(keys = {"TC-22778", "TC-22644"})
    public void Auto_SEVV_TC_38780_AltGeneric_ClientTimeZone(DataValidationModel dataTest) {
        AltEvvClient model = AltEvvClientDataGenerator.getDefaultAltEvvClientWithUniqueValue(StateAccount.loadStateAccount());
        DataValidationTest dataValidationTest = new DataValidationTest(this.altEVVGenericClient, model);
        dataValidationTest.validateDataValidationField(dataTest);
    }

    @Test(dataProvider = "CustomFieldValidation", groups = {"generic", "altClient", "ClientFirstName"}, testName = "Client First Name Validation")
    @FieldValidation(propertyFilter = "ClientFirstName")
    @QTest(keys = {"TC-22778"})
    public void Auto_SEVV_TC_38768_AltGeneric_ClientFirstName(DataValidationModel dataTest) {
        AltEvvClient model = AltEvvClientDataGenerator.getDefaultAltEvvClientWithUniqueValue(StateAccount.loadStateAccount());
        DataValidationTest dataValidationTest = new DataValidationTest(this.altEVVGenericClient, model);
        dataValidationTest.validateDataValidationField(dataTest);
    }

    @Test(dataProvider = "CustomFieldValidation", groups = {"generic", "altClient", "ClientLastName"}, testName = "Client Last Name Validation")
    @FieldValidation(propertyFilter = "ClientLastName")
    @QTest(keys = {"TC-22778"})
    public void Auto_SEVV_TC_38769_AltGeneric_ClientLastName(DataValidationModel dataTest) {
        AltEvvClient model = AltEvvClientDataGenerator.getDefaultAltEvvClientWithUniqueValue(StateAccount.loadStateAccount());
        DataValidationTest dataValidationTest = new DataValidationTest(this.altEVVGenericClient, model);
        dataValidationTest.validateDataValidationField(dataTest);
    }

    @Test(dataProvider = "CustomFieldValidation", groups = {"generic", "altClient", "smoke", "high"}, testName = "Client ID Validation")
    @FieldValidation(propertyFilter = "ClientID")
    @QTest(keys = {"TC-22778", "TC-22652", "TC-22653"})
    public void Auto_SEVV_TC_20218_AltGeneric_ClientID(DataValidationModel dataTest) {
        AltEvvClient model = AltEvvClientDataGenerator.getDefaultAltEvvClientWithUniqueValue(StateAccount.loadStateAccount());
        DataValidationTest dataValidationTest = new DataValidationTest(this.altEVVGenericClient, model);
        dataValidationTest.validateDataValidationField(dataTest);
    }

    @Test(dataProvider = "CustomFieldValidation", groups = {"generic", "altClient", "ClientSSN"}, testName = "Client SSN Validation")
    @FieldValidation(propertyFilter = "ClientSSN")
    @QTest(keys = {"TC-22778"})
    public void Auto_SEVV_TC_38789_AltGeneric_ClientSSN(DataValidationModel dataTest) {
        AltEvvClient model = AltEvvClientDataGenerator.getDefaultAltEvvClientWithUniqueValue(StateAccount.loadStateAccount());
        DataValidationTest dataValidationTest = new DataValidationTest(this.altEVVGenericClient, model);
        dataValidationTest.validateDataValidationField(dataTest);
    }

    @Test(dataProvider = "CustomFieldValidation", groups = {"generic", "altClient", "ClientCounty"}, testName = "ClientCounty Validation")
    @FieldValidation(propertyFilter = "$.ClientAddress[0].ClientCounty")
    @QTest(keys = {"TC-22778", "TC-22650"})
    public void Auto_SEVV_TC_38789_AltGeneric_ClientCounty(DataValidationModel dataTest) {
        AltEvvClient model = AltEvvClientDataGenerator.getDefaultAltEvvClientWithUniqueValue(StateAccount.loadStateAccount());
        DataValidationTest dataValidationTest = new DataValidationTest(this.altEVVGenericClient, model);
        dataValidationTest.validateDataValidationField(dataTest);
    }

    @Test(dataProvider = "CustomFieldValidation", groups = {"generic", "altClient", "ProviderAssentContPlan"}, testName = "ProviderAssentContPlan Validation")
    @FieldValidation(propertyFilter = "$.ProviderAssentContPlan")
    @QTest(keys = {"TC-22941", "TC-22942"})
    public void Auto_SEVV_TC_38789_AltGeneric_ProviderAssentContPlan(DataValidationModel dataTest) {
        AltEvvClient model = AltEvvClientDataGenerator.getDefaultAltEvvClientWithUniqueValue(StateAccount.loadStateAccount());
        DataValidationTest dataValidationTest = new DataValidationTest(this.altEVVGenericClient, model);
        dataValidationTest.validateDataValidationField(dataTest);
    }

    @Test(dataProvider = "CustomFieldValidation", groups = {"generic", "altClient", "ClientStatus"}, testName = "ClientStatus Validation")
    @FieldValidation(propertyFilter = "$.ClientPayerInformation[0].ClientStatus")
    @QTest(keys = {"TC-23328"})
    public void Auto_SEVV_TC_38789_AltGeneric_ClientStatus(DataValidationModel dataTest) {
        AltEvvClient model = AltEvvClientDataGenerator.getDefaultAltEvvClientWithUniqueValue(StateAccount.loadStateAccount());
        if (!dataTest.getExpectedMessage().isEmpty()) {
            model.getClientPayerInformation().get(0).setClientEligibilityDateBegin("");
            model.getClientPayerInformation().get(0).setClientEligibilityDateEnd("");
        }
        DataValidationTest dataValidationTest = new DataValidationTest(this.altEVVGenericClient, model);
        dataValidationTest.validateDataValidationField(dataTest);
    }

    @Test(dataProvider = "CustomFieldValidation", groups = {"generic", "altClient", "ClientAddress[0].ClientAddressIsPrimary"}, testName = "ClientAddress[0].ClientAddressIsPrimary Validation")
    @FieldValidation(propertyFilter = "$.ClientAddress[0].ClientAddressIsPrimary")
    @QTest(keys = {"TC-22651"})
    public void Auto_SEVV_TC_38789_AltGeneric_ClientAddressIsPrimary(DataValidationModel dataTest) {
        AltEvvClient model = AltEvvClientDataGenerator.getDefaultAltEvvClientWithUniqueValue(StateAccount.loadStateAccount());
        DataValidationTest dataValidationTest = new DataValidationTest(this.altEVVGenericClient, model);
        dataValidationTest.validateDataValidationField(dataTest);
    }
}
