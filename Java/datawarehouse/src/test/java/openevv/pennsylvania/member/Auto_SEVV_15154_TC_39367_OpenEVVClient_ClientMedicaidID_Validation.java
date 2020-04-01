package openevv.pennsylvania.member;

import com.interop.models.openevv.member.OpenEvvMember;
import com.interop.models.openevv.member.OpenEvvMemberDataGenerator;
import com.interop.services.base.DataValidationTest;
import com.interop.services.openevv.OpenEvvMemberService;
import com.interop.common.TestDataHelper;
import com.interop.common.dataprovider.DataValidationModel;
import generic.GenericTest;
import io.qameta.allure.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@SuppressWarnings({"unchecked", "rawtypes"})
public class Auto_SEVV_15154_TC_39367_OpenEVVClient_ClientMedicaidID_Validation extends GenericTest {
    private DataValidationTest dataValidationTest;

    @DataProvider(name = "invalidFieldValidation")
    public Object[][] getDataDriven() {
        OpenEvvMember openEvvMember = OpenEvvMemberDataGenerator.getOpenEVVMemberByState(stateAccount);
        OpenEvvMemberService openEvvMemberService = new OpenEvvMemberService();
        dataValidationTest = new DataValidationTest(openEvvMemberService, openEvvMember);
        String fileName = "OpenEVV/client/OpenEVV_Pennsylvania_ClientMeidcaidid_Validation.csv";
        return TestDataHelper.getFieldValidationDataRows(state, fileName);
    }

    @Test(dataProvider = "invalidFieldValidation", groups = "openEVVClient")
    @Description("Field Validation Test for openevv Client endpoint")

    public void TC_39367_OpenEVVClient_ClientMedicaidID_Validation(DataValidationModel dataTest) {
        dataValidationTest.validateDataValidationField(dataTest);
    }
}