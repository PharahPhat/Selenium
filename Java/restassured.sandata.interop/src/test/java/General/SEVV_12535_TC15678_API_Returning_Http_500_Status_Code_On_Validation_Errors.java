package General;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.globalVariables;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SEVV_12535_TC15678_API_Returning_Http_500_Status_Code_On_Validation_Errors extends BaseTest {

    @Test(groups = {"All"})
    public void SEVV_12535_TC15678_API_Returning_Http_500_Status_Code_On_Validation_Errors() throws InterruptedException{
        Assert.assertTrue(CommonMethods.captureResponseAltEVVGetWithIsNotExistUID(CommonMethods.propertyfileReader(globalVariables.status_evv_client), openEVVUser, openEVVPass, openEvvAcc, openEVVAccId));
        Assert.assertTrue(CommonMethods.captureResponseAltEVVGetWithIsNotExistUID(CommonMethods.propertyfileReader(globalVariables.status_evv_xref), openEVVUser, openEVVPass, openEvvAcc, openEVVAccId));
        Assert.assertTrue(CommonMethods.captureResponseAltEVVGetWithIsNotExistUID(CommonMethods.propertyfileReader(globalVariables.status_evv_provider), openEVVUser, openEVVPass, openEvvAcc, openEVVAccId));
        Assert.assertTrue(CommonMethods.captureResponseAltEVVGetWithIsNotExistUID(CommonMethods.propertyfileReader(globalVariables.status_evv_members), openEVVUser, openEVVPass, openEvvAcc, openEVVAccId));
        Assert.assertTrue(CommonMethods.captureResponseAltEVVGetWithIsNotExistUID(CommonMethods.propertyfileReader(globalVariables.status_evv_employees_evv), openEVVUser, openEVVPass, openEvvAcc, openEVVAccId));
        Assert.assertTrue(CommonMethods.captureResponseAltEVVGetWithIsNotExistUID(CommonMethods.propertyfileReader(globalVariables.status_rest_employees), altEVVUser, altEVVPass, altEvvAcc, altEVVAccId));
        Assert.assertTrue(CommonMethods.captureResponseAltEVVGetWithIsNotExistUID(CommonMethods.propertyfileReader(globalVariables.status_rest_clients), altEVVUser, altEVVPass, altEvvAcc, altEVVAccId));
        Assert.assertTrue(CommonMethods.captureResponseAltEVVGetWithIsNotExistUID(CommonMethods.propertyfileReader(globalVariables.status_rest_visits), altEVVUser, altEVVPass, altEvvAcc, altEVVAccId));
        Assert.assertTrue(CommonMethods.captureResponseAltEVVGetWithIsNotExistUID(CommonMethods.propertyfileReader(globalVariables.status_rest_auths), altEVVUser, altEVVPass, altEvvAcc, altEVVAccId));
        Assert.assertTrue(CommonMethods.captureResponseAltEVVGetWithIsNotExistUID(CommonMethods.propertyfileReader(globalVariables.status_rest_employees_v1), altEVVUserV1, altEVVPassV1, altEvvAccV1, altEVVAccIdV1));
        Assert.assertTrue(CommonMethods.captureResponseAltEVVGetWithIsNotExistUID(CommonMethods.propertyfileReader(globalVariables.status_rest_clients_v1), altEVVUserV1, altEVVPassV1, altEvvAccV1, altEVVAccIdV1));
        Assert.assertTrue(CommonMethods.captureResponseAltEVVGetWithIsNotExistUID(CommonMethods.propertyfileReader(globalVariables.status_rest_visits_v1), altEVVUserV1, altEVVPassV1, altEvvAccV1, altEVVAccIdV1));
    }
}
