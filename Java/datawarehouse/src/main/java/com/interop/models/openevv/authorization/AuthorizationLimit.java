package com.interop.models.openevv.authorization;

import com.google.gson.annotations.SerializedName;
import com.interop.common.StateAccount;
import com.interop.models.altevv.AltBaseModel;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Builder
@Data
public class AuthorizationLimit extends AltBaseModel {
    @SerializedName("PayerProgram")
    @Builder.Default
    private String payerProgram = StateAccount.loadStateAccount().getDefaultPayerProgram();
    @SerializedName("AuthorizationServiceID")
    @Builder.Default
    private String authorizationServiceID = StateAccount.loadStateAccount().getDefaultProcedureCode();
    @SerializedName("AuthorizationBillingType")
    private String authorizationBillingType;
    @SerializedName("AuthorizationLimit")
    @Builder.Default
    private String authorizationLimit = "10";
    @SerializedName("AuthorizationLimitStartTime")
    private String authorizationLimitStartTime;
    @SerializedName("AuthorizationLimitEndTime")
    private String authorizationLimitEndTime;
    @SerializedName("Modifier1")
    @Builder.Default
    private String modifier1 = null;
    @SerializedName("Modifier2")
    @Builder.Default
    private String modifier2 = null;
    @SerializedName("Modifier3")
    @Builder.Default
    private String modifier3 = null;
    @SerializedName("Modifier4")
    @Builder.Default
    private String modifier4 = null;
    @SerializedName("ServiceAuthorizedDate")
    @Builder.Default
    private String serviceAuthorizedDate = "2030-02-02";
    @SerializedName("AuthorizationLimitDayOfWeek")
    @Builder.Default
    private String authorizationLimitDayOfWeek = "MON";
    @SerializedName("AuthorizationWeekStart")
    @Builder.Default
    private String authorizationWeekStart = "MON";

    @Override
    public boolean equals(Object object2) {
        return payerProgram.equals(((AuthorizationLimit) object2).payerProgram)
                && authorizationServiceID.equals(((AuthorizationLimit) object2).authorizationServiceID)
                && authorizationLimit.equals(((AuthorizationLimit) object2).authorizationLimit)
                && modifier1.equals(((AuthorizationLimit) object2).modifier1)
                && modifier2.equals(((AuthorizationLimit) object2).modifier2)
                && modifier3.equals(((AuthorizationLimit) object2).modifier3)
                && modifier4.equals(((AuthorizationLimit) object2).modifier4);
    }
}
