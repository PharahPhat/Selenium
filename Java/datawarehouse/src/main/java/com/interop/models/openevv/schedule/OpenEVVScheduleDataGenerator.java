package com.interop.models.openevv.schedule;

import com.interop.common.Commons;
import com.interop.common.StateAccount;
import com.interop.common.TestDataHelper;
import com.interop.models.db.stx.STXPayorID;
import com.sandata.db.ClientDbService;
import com.sandata.db.EmployeeDbService;

import java.util.List;

import static com.interop.common.constants.FieldConstants.*;

public class OpenEVVScheduleDataGenerator {
    StateAccount account;
    ClientDbService clientDbService;
    EmployeeDbService employeeDbService;

    public OpenEVVScheduleDataGenerator(StateAccount account) {
        this.account = account;
        clientDbService = new ClientDbService(account);
        employeeDbService = new EmployeeDbService(account);
    }

    public static OpenEvvSchedule initSchedule(StateAccount account) {
        OpenEVVScheduleDataGenerator dataGenerator = new OpenEVVScheduleDataGenerator(account);
        STXPayorID combinationService = TestDataHelper.getListAuthorizationServicesIDCombination().get(0);
        return OpenEvvSchedule.builder()
                .clientID(dataGenerator.assignRandomClient())
                .employeePIN(dataGenerator.assignRandomEmployee())
                .modifier1(combinationService.MODIFIER1)
                .modifier2(combinationService.MODIFIER2)
                .modifier3(combinationService.MODIFIER3)
                .modifier4(combinationService.MODIFIER4)
                .contract(combinationService.PAYOR_ID)
                .payerProgram(combinationService.PROGRAM)
                .procedureCode(combinationService.PROC_CODE)
                .service(combinationService.PROC_CODE)
                .build();
    }

    public String assignRandomClient() {
        return clientDbService.getRandomClient().get(getClientDBHeaderName()).toString();
    }

    public String assignRandomEmployee() {
        return employeeDbService.getRandomEmployee().get(getEmployeeDBHeaderName()).toString();
    }

    public String getClientDBHeaderName() {
        switch (this.account.getStateEnum()) {
            case RHODEISLAND:
            case COLORADO:
                return CLIENT_CUSTOM_ID2;
            case CONNECTICUT:
                return CLIENT_ID;
            default:
                if (this.account.getAccountType().equalsIgnoreCase(Commons.AccountType.AMP.toString())) {
                    return CLIENT_ID;
                }
                return CLIENT_CUSTOM_ID1;
        }
    }

    public String getEmployeeDBHeaderName() {
        switch (this.account.getStateEnum()) {
            case CONNECTICUT:
            case RHODEISLAND:
                return EMPLOYEEIDENTIFIER;
            case HAWAII:
            case ARIZONA:
                return WORKER_SSN;
            default:
                return WORKER_CUSTOM_ID1;
        }
    }
}
