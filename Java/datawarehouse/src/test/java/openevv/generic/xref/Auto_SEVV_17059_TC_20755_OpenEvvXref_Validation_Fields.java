package openevv.generic.xref;

import com.interop.common.Commons;
import com.interop.common.StateAccount;
import com.interop.common.TestDataHelper;
import com.interop.common.dataprovider.DataValidationModel;
import com.interop.models.openevv.xref.OpenEvvXref;
import com.interop.models.openevv.xref.OpenEvvXrefDataGenerator;
import com.interop.services.base.DataValidationTest;
import com.interop.services.openevv.OpenEvvXrefService;
import com.sandata.core.annotation.FieldValidation;
import com.sandata.qtest.QTest;
import generic.GenericTest;
import io.qameta.allure.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * Author by: NhonNguyen
 * Run script for VT, AZ_AMP, HI_AMP
 */

@SuppressWarnings({"rawtypes", "unchecked"})
public class Auto_SEVV_17059_TC_20755_OpenEvvXref_Validation_Fields extends GenericTest {
    private DataValidationTest dataValidationTest;
    private final String stringKey = StateAccount.loadStateAccount().getStateEnum().getStringKey();
    OpenEvvXrefService service = new OpenEvvXrefService();

    @DataProvider(name = "FieldValidation")
    public Object[][] getDataDriven(Method method) {
        FieldValidation annotation = method.getAnnotation(FieldValidation.class);
        String dataFilter = "";
        String fileName;
        if (method.getAnnotationsByType(FieldValidation.class).length > 0) {
            dataFilter = annotation.propertyFilter();
        }
        if (Commons.AccountType.AMP.toString().equalsIgnoreCase(stateAccount.getAccountType())) {
            fileName = "OpenEVV/Xref/OpenEVVXref_Generic_Validation.csv";
            service.setAMPAccount(true);
            return TestDataHelper.getFieldValidationDataRows(Commons.AccountType.GENERIC.toString(), fileName, dataFilter);
        }
        else {
            fileName = "OpenEVV/Xref/OpenEVVXref_" + stringKey + "_Validation.csv";
            return TestDataHelper.getFieldValidationDataRows(state, fileName, dataFilter);
        }
    }

    @Test(dataProvider = "FieldValidation", groups = {"openEVVXref", "Regression"})
    @Description("Field Validation Test for Open EVV Xref")
    @QTest(keys = {"TC-22874", "TC-20755"})
    public void TC_20755_OpenEvvXref_Validation_Fields_valid(DataValidationModel dataTest) {
        OpenEvvXref openEvvXref = OpenEvvXrefDataGenerator.getOpenEvvXrefByState(StateAccount.loadStateAccount());
        dataValidationTest = new DataValidationTest(service, openEvvXref);
        dataValidationTest.validateDataValidationField(dataTest);
    }

    @Test(dataProvider = "FieldValidation", groups = {"smoke", "high"})
    @FieldValidation(propertyFilter = "ClientIDQualifier")
    @Description("Smoke test. State: AZ_AMP")
    public void TC_20755_OpenEvvXref_Validation_ClientIDQualifier_Field_valid(DataValidationModel dataTest) {
        OpenEvvXref openEvvXref = OpenEvvXrefDataGenerator.getOpenEvvXrefByState(StateAccount.loadStateAccount());
        dataValidationTest = new DataValidationTest(service, openEvvXref);
        dataValidationTest.validateDataValidationField(dataTest);
    }

    @Test(dataProvider = "FieldValidation", groups = {"smoke", "high"})
    @FieldValidation(propertyFilter = "ClientStatus")
    @Description("Smoke test. State: AZ_AMP")
    public void TC_20755_OpenEvvXref_Validation_ClientStatus_Field_valid(DataValidationModel dataTest) {
        OpenEvvXref openEvvXref = OpenEvvXrefDataGenerator.getOpenEvvXrefByState(StateAccount.loadStateAccount());
        dataValidationTest = new DataValidationTest(service, openEvvXref);
        dataValidationTest.validateDataValidationField(dataTest);
    }
}
