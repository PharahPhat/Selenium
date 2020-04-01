package com.sandata.models.vm;

public class Service {
    public String Service;
    public String Program;
    public String PayorID;
    public String PayorName;
    public String ServiceDescription;

    public String getService() {
        return Service;
    }

    public void setService(String service) {
        Service = service;
    }

    public String getProgram() {
        return Program;
    }

    public void setProgram(String program) {
        Program = program;
    }

    public String getPayorID() {
        return PayorID;
    }

    public void setPayorID(String payorID) {
        PayorID = payorID;
    }

    public String getPayorName() {
        return PayorName;
    }

    public void setPayorName(String payorName) {
        PayorName = payorName;
    }

    public String getServiceDescription() {
        return ServiceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        ServiceDescription = serviceDescription;
    }
}
