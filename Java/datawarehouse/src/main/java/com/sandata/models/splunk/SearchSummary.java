package com.sandata.models.splunk;

public class SearchSummary {
    public Fields fields;

    public Fields getFields() {
        return fields;
    }

    public void setFields(Fields fields) {
        this.fields = fields;
    }

    public boolean checkMessage(String message) {
        return fields.message.checkValueExists(message);
    }
}
