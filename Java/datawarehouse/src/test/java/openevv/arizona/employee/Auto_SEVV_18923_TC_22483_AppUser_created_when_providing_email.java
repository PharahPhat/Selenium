package openevv.arizona.employee;

import com.interop.common.StateAccount;
import com.interop.models.db.stx.STXAppUser;
import com.interop.services.openevv.OpenEvvEmployeeService;
import com.sandata.qtest.QTest;
import generic.GenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Auto_SEVV_18923_TC_22483_AppUser_created_when_providing_email extends GenericTest {

    /**
     * Precondition: The account must turn ON auto assign STX ID
     */
    @Test
    @QTest(keys = "TC-22483")
    public void provideEmailTheAppUserIsCreated() {
        baseObj.info("Step 1: Prepare to create Client with multi Client Designees having same email");
        OpenEvvEmployeeService openEvvEmployeeService = OpenEvvEmployeeService.init();
        openEvvEmployeeService.post();

        baseObj.info("Step 2: Verify Post successfully");
        baseObj.validateActualAndExpectedText(openEvvEmployeeService.getStatusModel().status, "SUCCESS");

        baseObj.info("Step 3: Get and Verify STX employee record");
        openEvvEmployeeService.getAndVerifySTXEmployeeByName();

        baseObj.info("Step 4: Verify STX App user");
        String employeeEmailAddress = openEvvEmployeeService.getModels().get(0).getEmployeeEmailAddress();
        List<STXAppUser> listStxAppUser = STXAppUser.getSTXAppUser(StateAccount.loadStateAccount().getAccountID(), employeeEmailAddress);
        STXAppUser user = listStxAppUser.get(0);
        Assert.assertEquals(listStxAppUser.size(), 1);
        Assert.assertEquals(user.USERNAME, employeeEmailAddress);
    }
}
