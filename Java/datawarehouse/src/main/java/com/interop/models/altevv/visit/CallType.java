package com.interop.models.altevv.visit;

public enum CallType {
    IVR("Telephone"), FVV("FVV"), MVV("Mobile"), MANUAL("Manual"), NONSTX("Unknown"), OTHER("Other");
    private String value;

    CallType(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }
}
