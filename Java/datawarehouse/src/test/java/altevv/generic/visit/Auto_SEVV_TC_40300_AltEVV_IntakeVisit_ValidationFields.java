package altevv.generic.visit;

import com.interop.common.StateAccount;
import com.interop.common.TestDataHelper;
import com.interop.common.dataprovider.DataValidationModel;
import com.interop.models.altevv.visit.AltEvvVisit;
import com.interop.models.altevv.visit.AltEvvVisitDataGenerator;
import com.interop.services.atlevv.AltEvvVisitService;
import com.interop.services.base.DataValidationTest;
import com.sandata.core.annotation.FieldValidation;
import com.sandata.qtest.QTest;
import generic.GenericTest;
import io.qameta.allure.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@SuppressWarnings({"rawtypes", "unchecked"})
public class Auto_SEVV_TC_40300_AltEVV_IntakeVisit_ValidationFields extends GenericTest {
    private final String stringKey = stateAccount.getStateEnum().getStringKey();
    private final String ALT_GENERIC_VISIT_VALIDATION_CSV = "AltEVV/Visit/AltEVVVisit_" + stringKey + "_Validation.csv";
    private AltEvvVisitService visit = new AltEvvVisitService();

    @DataProvider(name = "fieldValidation")
    public Object[][] getDataDriven(Method method) {
        FieldValidation annotation = method.getAnnotation(FieldValidation.class);
        String dataFilter = "";
        if (method.getAnnotationsByType(FieldValidation.class).length > 0) {
            dataFilter = annotation.propertyFilter();
        }
        return TestDataHelper.getFieldValidationDataRows(state, ALT_GENERIC_VISIT_VALIDATION_CSV, dataFilter);
    }

    @Test(dataProvider = "fieldValidation", groups = {"altVisit"})
    @Description("Field Validation Test for ALT EVV Generic Client endpoint")
    @QTest(keys = {"TC-22784","TC-23270"})
    public void Auto_AltGenericVisit_Validation(DataValidationModel dataTest) {
        AltEvvVisit altEvvVisit = AltEvvVisitDataGenerator.initAltEvvVisitByState(StateAccount.loadStateAccount());
        DataValidationTest dataValidationTest = new DataValidationTest(visit, altEvvVisit);
        dataValidationTest.validateDataValidationField(dataTest);
    }

    @Test(dataProvider = "fieldValidation", groups = {"smoke", "high"}, testName = "ExceptionID Validation")
    @FieldValidation(propertyFilter = "$.VisitExceptionAcknowledgement[0].ExceptionID")
    @QTest(keys = {"TC-23270"})
    public void Auto_SEVV_TC_38789_AltGeneric_ExceptionID(DataValidationModel dataTest) {
        AltEvvVisit altEvvVisit = AltEvvVisitDataGenerator.initAltEvvVisitByState(StateAccount.loadStateAccount());
        DataValidationTest dataValidationTest = new DataValidationTest(visit, altEvvVisit);
        dataValidationTest.validateDataValidationField(dataTest);
    }

    @Test(dataProvider = "fieldValidation", groups = {"smoke", "high"}, testName = "VisitChanges Validation")
    @FieldValidation(propertyFilter = "$.VisitChanges[0]")
    @QTest(keys = {"TC-23270"})
    public void Auto_SEVV_TC_38789_AltGeneric_VisitChanges(DataValidationModel dataTest) {
        AltEvvVisit altEvvVisit = AltEvvVisitDataGenerator.initAltEvvVisitByState(StateAccount.loadStateAccount());
        DataValidationTest dataValidationTest = new DataValidationTest(visit, altEvvVisit);
        dataValidationTest.validateDataValidationField(dataTest);
    }
}
