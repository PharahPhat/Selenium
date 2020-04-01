package com.sandata.models.splunk;

import com.sandata.models.GenericModel;

import java.util.List;

public class Message extends GenericModel {
    public List<Mode> modes;

    public List<Mode> getModes() {
        return modes;
    }

    public void setModes(List<Mode> modes) {
        this.modes = modes;
    }

    public boolean checkValueExists(String message) {
        for (int i=0; i <= modes.size() - 1; i++ ) {
            if (modes.get(i).checkValueExists(message)) {
                logInfo(String.format("Found message: %s", modes.get(i).value));
                return true;
            }
        }
        return false;
    }


    @Override
    public boolean verifyFieldValue(Object obj) {
        return false;
    }

    @Override
    public boolean verifyFieldsNotNull() {
        return false;
    }

}
