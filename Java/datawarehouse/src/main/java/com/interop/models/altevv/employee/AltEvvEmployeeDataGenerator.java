package com.interop.models.altevv.employee;

import com.interop.common.StateAccount;
import com.interop.models.altevv.AltBaseModel;
import org.apache.commons.lang.RandomStringUtils;

public class AltEvvEmployeeDataGenerator extends AltBaseModel {
    public static AltEvvEmployee getAltEvvEmployeeByState(StateAccount account) {
        AltEvvEmployee altEvvEmployee = AltEvvEmployee.builder().build();
        switch (account.getStateEnum()) {
            case PENNSYLVANIA:
                altEvvEmployee.setEmployeeSSN("0000" + RandomStringUtils.randomNumeric(5));
                altEvvEmployee.setEmployeeIdentifier(altEvvEmployee.employeeSSN);
                break;
            case COLORADO:
                String empSsn = "0000" + RandomStringUtils.randomNumeric(5);
                altEvvEmployee.setEmployeeSSN(empSsn);
                altEvvEmployee.setEmployeeLastName(RandomStringUtils.randomAlphabetic(4));
                String lastName = altEvvEmployee.employeeLastName;
                altEvvEmployee.setEmployeeIdentifier(empSsn.substring(4) + lastName);
                break;
            case RHODEISLAND:
//                String ssn = "00000" + RandomStringUtils.randomNumeric(4); removed by SEVV-22341
                String ssn = RandomStringUtils.randomNumeric(9);
                altEvvEmployee.setEmployeeSSN(ssn);
                altEvvEmployee.setEmployeeIdentifier(ssn);
                String empOtherID = "00000" + RandomStringUtils.randomNumeric(4);
                altEvvEmployee.setEmployeeOtherID(empOtherID);
                break;
            case HAWAII:
                String otherId = commons.generateRandomNumberOfFixLength(9);
                altEvvEmployee.setEmployeeOtherID(otherId);
                altEvvEmployee.setEmployeeIdentifier(otherId);
                break;
            default:
                break;
        }
        return altEvvEmployee;
    }
}
