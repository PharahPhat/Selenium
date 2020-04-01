package com.interop.models.openevv.batch;


import com.interop.models.openevv.OpenEvvBaseModel;
import com.sandata.core.annotation.CsvHeader;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class OutboundCSVModel extends OpenEvvBaseModel {

    @CsvHeader("FileName")
    public String filename;

    @CsvHeader("RecordCount")
    public String recordCount;
}
