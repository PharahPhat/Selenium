package com.interop.models.altevv.visit;

public enum CallAssignment {
    TIME_IN("Time In"), TIME_OUT("Time Out");

    private String value;

    CallAssignment(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }

    }
