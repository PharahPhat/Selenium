package com.interop.models.db.stx;

import com.sandata.core.annotation.DataTableColumn;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class STXClientAuth extends STXClient {

    @DataTableColumn //(optional = true)
    public String MEDICAID_ID;

    @DataTableColumn //(optional = true)
    public String PROVIDER_ID;

    @Override
    public String toString() {
        return "STXClient{" +
                "ACCOUNT=" + ACCOUNT +
                ", CLIENTKEY=" + CLIENTKEY +
                ", BEG_DATE=" + BEG_DATE +
                ", END_DATE=" + END_DATE +
                ", LOC=" + LOC +
                ", F_NAME='" + F_NAME + '\'' +
                ", L_NAME='" + L_NAME + '\'' +
                ", SPV='" + SPV + '\'' +
                ", TTX_FLAG='" + TTX_FLAG + '\'' +
                ", DIS_DATE=" + DIS_DATE +
                ", CLI_EXPLAIN=" + CLI_EXPLAIN +
                ", UPDATE_ID=" + UPDATE_ID +
                ", M_NAME='" + M_NAME + '\'' +
                ", DESCRIPTION='" + DESCRIPTION + '\'' +
                ", TZNAME='" + TZNAME + '\'' +
                ", CLIENT_VERSION_NUMBER=" + CLIENT_VERSION_NUMBER +
                ", NAME_SUFFIX='" + NAME_SUFFIX + '\'' +
                ", SPV_E_MAIL='" + SPV_E_MAIL + '\'' +
                ", CLIENT_ID_CUSTOM1='" + CLIENT_ID_CUSTOM1 + '\'' +
                '}';
    }
}
