package com.interop.models.db.staging;

import com.sandata.core.annotation.DataTableColumn;
import lombok.Data;

@Data
public class ExclusionProviderId {
    @DataTableColumn
    private String id;

    @DataTableColumn
    private String providerId;
}
