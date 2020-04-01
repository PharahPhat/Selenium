package com.sandata.ws.pa.unitcalculation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VisitUnitAggregation {
    private List<Integer> durations = new ArrayList<>();
    private ClaimUnitRule unitRule;
    private String serviceId;

    public List<Integer> getDurations() {
        return durations;
    }

    public void setDurations(List<Integer> durations) {
        this.durations = durations;
    }

    public void addDuration(int duration) {
        durations.add(duration);
    }

    public ClaimUnitRule getUnitRule() {
        return unitRule;
    }

    public void setUnitRule(ClaimUnitRule unitRule) {
        this.unitRule = unitRule;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    private int getVisitUnitAggregationByAddTimeLogic(){
        int sumDurations = durations.stream().collect(Collectors.summingInt(Integer::intValue));
        return UnitCalculationHelper.calculateUnit(serviceId, sumDurations);
    }

    private int getVisitUnitAggregationByAddUnitLogic(){
        return durations.stream().map(
                duration -> UnitCalculationHelper.calculateUnit(serviceId, duration)
        ).collect(Collectors.summingInt(Integer::intValue));
    }

    public int getVisitUnitAggregation(){
        if(unitRule == ClaimUnitRule.ADD_TIME){
            return getVisitUnitAggregationByAddTimeLogic();
        } else {
            return getVisitUnitAggregationByAddUnitLogic();
        }
    }
    public static void main(String[] args){
        VisitUnitAggregation aggregation = new VisitUnitAggregation();
        aggregation.setUnitRule(ClaimUnitRule.ADD_TIME);
        aggregation.addDuration(52);
        aggregation.addDuration(23);
        aggregation.setServiceId("W1724");
        int visitUnit = aggregation.getVisitUnitAggregation();
        System.out.println("Visit Unit By Add Time (expected is 5) - actual " + visitUnit);

        aggregation.setUnitRule(ClaimUnitRule.ADD_UNITS);
        int visitUnit2 = aggregation.getVisitUnitAggregation();
        System.out.println("Visit Unit by Add Unit (expected is 4) - actual " + visitUnit2);
    }
}
