package com.sandata.models.importModel.Control;

public class OutboundControlModel {
    public String FileName;
    public String RecordCount;

    public String toLine() {
        return "\"" + FileName + "\"" + "|" +
                "\"" + RecordCount + "\"";
    }

}
