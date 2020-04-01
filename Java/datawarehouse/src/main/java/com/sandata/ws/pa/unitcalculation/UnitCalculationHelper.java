package com.sandata.ws.pa.unitcalculation;

import java.util.Arrays;
import java.util.List;

public class UnitCalculationHelper {
    private static final String[] RULE_01 = {"W1724","W1725","W1726","W7058","W7059","W7060","W7061","W7068","W7069","W7201"
            , "W7204", "W7205", "W7213", "W7286", "W8095", "W8096", "W9596", "W9860", "W9861", "W9862", "W9863", "W9864", "G0156", "T1001","H2014"};
    private static final String[] RULE_02 = {"W7283"};
    private static final String[] RULE_03 = {"W7285","W9795","W9796","W9797","W9798","W9799","W9800","W9801"};

    private static final int RULE_01_BLOCK = 15;
    private static final int RULE_02_BLOCK = 60;
    private static final int RULE_03_BLOCK = 960;

    public static int calculateUnit(String serviceId, int durationInMinutes){
        int blockValue = RULE_03_BLOCK;
        if(Arrays.asList(RULE_01).contains(serviceId)){
            blockValue = RULE_01_BLOCK;
        } else if (Arrays.asList(RULE_02).contains(serviceId)){
            blockValue = RULE_02_BLOCK;
        } else if (Arrays.asList(RULE_03).contains(serviceId)){
            blockValue = RULE_03_BLOCK;
        } else {

        }
//        return durationInMinutes/blockValue + addExtraUnit(durationInMinutes, blockValue);
        return durationInMinutes/blockValue;
    }

    private static int addExtraUnit(int duration, int blockUnit){
        if (duration% blockUnit > 0)  {
            return 1;
        } else {
            return 0;
        }
    }
    public static int getCareWorkerRatio(String procedureCode){
        List<String> serviceRequire2Workers = Arrays.asList("W7068","W9864","W9800","W8095","W7069","W9801");
        if(serviceRequire2Workers.contains(procedureCode))
            return 2;
        else
            return 1;
    }
}

