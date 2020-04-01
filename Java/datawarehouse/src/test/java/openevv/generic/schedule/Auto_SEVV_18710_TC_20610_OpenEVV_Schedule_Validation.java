package openevv.generic.schedule;

import com.interop.common.Commons;
import com.interop.common.StateAccount;
import com.interop.common.TestDataHelper;
import com.interop.common.dataprovider.DataValidationModel;
import com.interop.models.openevv.schedule.OpenEVVScheduleDataGenerator;
import com.interop.models.openevv.schedule.OpenEvvSchedule;
import com.interop.services.base.DataValidationTest;
import com.interop.services.openevv.OpenEvvScheduleService;
import com.sandata.core.annotation.FieldValidation;
import com.sandata.qtest.QTest;
import generic.GenericTest;
import io.qameta.allure.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * Author by NhonNguyen
 * Script could be run on AZ, HI, AZ_AMP
 */

@SuppressWarnings({"rawtypes", "unchecked"})
public class Auto_SEVV_18710_TC_20610_OpenEVV_Schedule_Validation extends GenericTest {
    private final String stringKey = stateAccount.getStateEnum().getStringKey();
    private DataValidationTest dataValidationTest;
    private OpenEvvScheduleService openEvvSchedule = new OpenEvvScheduleService();
    @DataProvider(name = "dataProvider")
    public Object[][] getDataCustomFieldValidation(Method method) {
        FieldValidation annotation = method.getAnnotation(FieldValidation.class);
        String dataFilter = "";
        String fileName;
        if (method.getAnnotationsByType(FieldValidation.class).length > 0) {
            method.getAnnotation(FieldValidation.class);
            dataFilter = annotation.propertyFilter();
        }
        if (Commons.AccountType.AMP.toString().equalsIgnoreCase(stateAccount.getAccountType())) {
            fileName = "OpenEVV/Schedule/OpenEVVSchedule_Generic_FieldValidation.csv";
            openEvvSchedule.setAMPAccount(true);
            return TestDataHelper.getFieldValidationDataRows(Commons.AccountType.GENERIC.toString(), fileName, dataFilter);
        }
        else {
            fileName = "OpenEVV/Schedule/OpenEVVSchedule_" + stringKey + "_FieldValidation.csv";
            return TestDataHelper.getFieldValidationDataRows(state, fileName, dataFilter);
        }
    }

    @Test(dataProvider = "dataProvider")
    @Description("Field Validation Test for OpenEVV Generic Schedule endpoint")
    @QTest(keys = {"TC-23063"})
    public void TC_20610_OpenEVV_Schedule_Validation(DataValidationModel dataTest) {
        OpenEvvSchedule model = OpenEVVScheduleDataGenerator.initSchedule(openEvvSchedule.getStateAccount());
        dataValidationTest = new DataValidationTest(openEvvSchedule, model);
        dataValidationTest.validateDataValidationField(dataTest);
    }

    @Test(dataProvider = "dataProvider", groups = {"smoke", "high"})
    @FieldValidation(propertyFilter = "PayerProgram")
    @Description("Smoke test. State: AZ_AMP")
    public void TC_20610_OpenEVV_Schedule_PayerProgram_Validation(DataValidationModel dataTest) {
        OpenEvvSchedule model = OpenEVVScheduleDataGenerator.initSchedule(openEvvSchedule.getStateAccount());
        dataValidationTest = new DataValidationTest(openEvvSchedule, model);
        dataValidationTest.validateDataValidationField(dataTest);
    }

    @Test(dataProvider = "dataProvider", groups = {"smoke", "high"})
    @FieldValidation(propertyFilter = "ClientIDQualifier")
    @Description("Smoke test. State: AZ_AMP")
    public void TC_20610_OpenEVV_Schedule_ClientIDQualifier_Validation(DataValidationModel dataTest) {
        OpenEvvSchedule model = OpenEVVScheduleDataGenerator.initSchedule(openEvvSchedule.getStateAccount());
        dataValidationTest = new DataValidationTest(openEvvSchedule, model);
        dataValidationTest.validateDataValidationField(dataTest);
    }

}
