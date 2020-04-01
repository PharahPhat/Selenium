package com.interop.models.altevv.dwh;
import com.interop.common.StateAccount;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode()
@Builder
@Data

public class DwhExportDataGenerator {
    private DwhExportDataGenerator(){
    }

    public static DwhExport getDefaultDwhExportBuilder() {
        return new DwhExport.DwhExportBuilder().build();
    }
}
