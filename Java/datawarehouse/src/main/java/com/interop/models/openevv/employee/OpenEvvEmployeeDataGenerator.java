package com.interop.models.openevv.employee;

import com.interop.common.State;
import com.interop.common.StateAccount;
import org.apache.commons.lang.RandomStringUtils;

import static com.interop.common.Commons.AccountType.AMP;

public class OpenEvvEmployeeDataGenerator {
    private OpenEvvEmployeeDataGenerator() {
    }

    public static OpenEvvEmployee getDefaultOpenEvvEmployee() {
        return OpenEvvEmployee.builder().build();
    }

    public static OpenEvvEmployee getOpenEvvEmployeeByState(State state) {
        OpenEvvEmployee openEvvEmployee = getDefaultOpenEvvEmployee();
        switch (state) {
            case VERMONT:
                openEvvEmployee.setEmployeeID("D" + RandomStringUtils.randomNumeric(6));
                break;
            case CONNECTICUT:
                openEvvEmployee.setEmployeeHireDate("12122019");
                openEvvEmployee.setEmployeeEndDate("12122019");
                openEvvEmployee.setEmployeeBirthDate("12101990");
                break;
            case ARIZONA:
            case HAWAII:
                openEvvEmployee.setEmployeeID(RandomStringUtils.randomNumeric(9));
                openEvvEmployee.setEmployeePIN(RandomStringUtils.randomNumeric(9));
                openEvvEmployee.setEmployeeZipCode(RandomStringUtils.randomNumeric(9));
                break;
            default:
                openEvvEmployee.setEmployeeID(RandomStringUtils.randomNumeric(7));
                break;
        }
        if (AMP.toString().equalsIgnoreCase(StateAccount.loadStateAccount().getAccountType())) {
            openEvvEmployee.setEmployeeZipCode("00001-3541");
        }
        return openEvvEmployee;
    }
}
