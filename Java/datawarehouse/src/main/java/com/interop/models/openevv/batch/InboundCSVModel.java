package com.interop.models.openevv.batch;

import com.interop.models.openevv.OpenEvvBaseModel;
import com.sandata.core.annotation.CsvHeader;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class InboundCSVModel extends OpenEvvBaseModel {
    @CsvHeader("FileName")
    public String fileName;

    @CsvHeader("RecordCount")
    public String recordCount;

    @CsvHeader("StartDateTime")
    public String startDateTime;

    @CsvHeader("EndDateTime")
    public String endDateTime;

    @CsvHeader("Hash")
    public String hash;

    @CsvHeader("Success Count")
    public String successCount;

    @CsvHeader("Failed Count")
    public String failedCount;
}
