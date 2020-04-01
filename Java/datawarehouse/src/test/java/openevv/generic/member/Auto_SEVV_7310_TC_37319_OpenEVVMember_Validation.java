package openevv.generic.member;

import com.interop.common.TestDataHelper;
import com.interop.common.dataprovider.DataValidationModel;
import com.interop.models.openevv.member.OpenEvvMember;
import com.interop.models.openevv.member.OpenEvvMemberDataGenerator;
import com.interop.services.base.DataValidationTest;
import com.interop.services.openevv.OpenEvvMemberService;
import com.sandata.core.annotation.FieldValidation;
import com.sandata.qtest.QTest;
import generic.GenericTest;
import io.qameta.allure.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * Author by: NhonNguyen
 * Run Script for HI, AZ, VT
 * TC-19494, TC-19495, TC-19496, TC-19497, TC-19498, TC-19499, TC-19500: Validation Fields
 */

@SuppressWarnings({"unchecked", "rawtypes"})
public class Auto_SEVV_7310_TC_37319_OpenEVVMember_Validation extends GenericTest {
    private final String stringKey = this.stateAccount.getStateEnum().getStringKey();
    private final String fileName = "OpenEVV/Member/OpenEVVMember_" + this.stringKey + "_Validation.csv";
    private DataValidationTest dataValidationTest;
    private OpenEvvMemberService openEvvMemberService = new OpenEvvMemberService();

    @DataProvider(name = "FieldValidation")
    public Object[][] getDataDriven(Method method) {
        FieldValidation annotation = method.getAnnotation(FieldValidation.class);
        String dataFilter = "";
        if (method.getAnnotationsByType(FieldValidation.class).length > 0) {
            method.getAnnotation(FieldValidation.class);
            dataFilter = annotation.propertyFilter();
        }
        return TestDataHelper.getFieldValidationDataRows(this.state, this.fileName, dataFilter);
    }

    @Test(dataProvider = "FieldValidation", groups = {"arizona", "member"})
    @Description("Field Validation Test for Open EVV Member endpoint")
    @QTest(keys = {"TC-19495", "TC-756"})
    public void OpenEVVMember_Validation(DataValidationModel dataTest) {
        OpenEvvMember openEvvMember = OpenEvvMemberDataGenerator.getOpenEVVMemberByState(this.stateAccount);
        this.dataValidationTest = new DataValidationTest(this.openEvvMemberService, openEvvMember);
        this.dataValidationTest.validateDataValidationField(dataTest);
    }

    @Test(dataProvider = "FieldValidation", groups = {"smoke", "high"}, testName = "ClientLanguage")
    @FieldValidation(propertyFilter = "ClientLanguage")
    public void OpenEVVMember_ClientLanguage_Validation(DataValidationModel dataTest) {
        OpenEvvMember openEvvMember = OpenEvvMemberDataGenerator.getOpenEVVMemberByState(this.stateAccount);
        this.dataValidationTest = new DataValidationTest(this.openEvvMemberService, openEvvMember);
        this.dataValidationTest.validateDataValidationField(dataTest);
    }

    @Test(dataProvider = "FieldValidation", groups = {"smoke", "high"}, testName = "ClientPhone[0].ClientPhoneType")
    @FieldValidation(propertyFilter = "ClientPhone[0].ClientPhoneType")
    public void OpenEVVMember_ClientPhoneType_Validation(DataValidationModel dataTest) {
        OpenEvvMember openEvvMember = OpenEvvMemberDataGenerator.getOpenEVVMemberByState(this.stateAccount);
        this.dataValidationTest = new DataValidationTest(this.openEvvMemberService, openEvvMember);
        this.dataValidationTest.validateDataValidationField(dataTest);
    }
}
