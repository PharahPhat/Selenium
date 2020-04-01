package openevv.arizona.employee;

import com.interop.common.StateAccount;
import com.interop.models.db.inbox.InboxAppUser;
import com.interop.models.openevv.employee.OpenEvvEmployee;
import com.interop.services.openevv.OpenEvvEmployeeService;
import com.sandata.qtest.QTest;
import generic.GenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Auto_SEVV_18923_TC_22482_AppUser_not_created_when_not_providing_email extends GenericTest {

    /**
     * Precondition: The account must turn ON auto assign STX ID
     */
    @Test()
    @QTest(keys = "TC-22482")
    public void notProvideEmailTheAppUserIsNotCreated() {
        baseObj.info("Step 1: Prepare to create Client with multi Client Designees having same email");
        OpenEvvEmployeeService openEvvEmployeeService = OpenEvvEmployeeService.init();
        OpenEvvEmployee modifiedModel = OpenEvvEmployee.builder().employeeEmailAddress("").build();
        openEvvEmployeeService.getModels().set(0, modifiedModel);
        openEvvEmployeeService.loadPayload(openEvvEmployeeService.getModels());
        openEvvEmployeeService.post();
        baseObj.sleep(60000);//S

        baseObj.info("Step 2: Verify Post successfully");
        baseObj.validateActualAndExpectedText(openEvvEmployeeService.getStatusModel().status, "SUCCESS");

        baseObj.info("Step 3: Get and Verify STX employee record");
        openEvvEmployeeService.getAndVerifySTXEmployeeByName();

        baseObj.info("Step 4: Verify STX App user");
        String employeeName = modifiedModel.getEmployeeFirstName();
        List<InboxAppUser> appUsers = InboxAppUser.getINBOXAppUsers(StateAccount.loadStateAccount().getAccountID(), employeeName);
        Assert.assertEquals(appUsers.size(), 0);
    }
}
