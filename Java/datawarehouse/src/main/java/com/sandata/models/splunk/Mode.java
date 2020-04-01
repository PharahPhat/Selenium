package com.sandata.models.splunk;

public class Mode {
    public String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean checkValueExists(String message) {
        return value.contains(message);
    }
}
