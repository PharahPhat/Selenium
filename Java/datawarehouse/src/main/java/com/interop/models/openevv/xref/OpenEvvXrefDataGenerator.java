package com.interop.models.openevv.xref;

import com.interop.common.StateAccount;
import com.interop.models.openevv.OpenEvvBaseModel;

public class OpenEvvXrefDataGenerator extends OpenEvvBaseModel {
    public static OpenEvvXref getOpenEvvXrefByState(StateAccount stateAccount) {
        OpenEvvXref openEvvXref = OpenEvvXref.builder().build();
        switch (stateAccount.getStateEnum()) {
            case VERMONT:
                openEvvXref.setClientID("P" + commons.generateRandomNumberOfFixLength(6));
                openEvvXref.setEmployeeID("D" + commons.generateRandomNumberOfFixLength(6));
                break;
            case HAWAII:
            case ARIZONA:
                openEvvXref.setClientID(commons.generateRandomNumberOfFixLength(10));
                openEvvXref.setEmployeeID(commons.generateRandomNumberOfFixLength(9));
                openEvvXref.setEmployeePIN(commons.generateRandomNumberOfFixLength(9));
                break;
            default:
                openEvvXref.setClientID(commons.generateRandomNumberOfFixLength(13));
                openEvvXref.setEmployeeID(commons.generateRandomNumberOfFixLength(13));
        }
        openEvvXref.setService(stateAccount.getDefaultProcedureCode());
        return openEvvXref;
    }
}
