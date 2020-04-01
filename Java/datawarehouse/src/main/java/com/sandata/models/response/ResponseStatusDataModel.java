package com.sandata.models.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "processId",
        "processCode",
        "executeResult",
        "uuid",
        "account",
        "message",
        "reason",
        "transactionId",
        "data",
        "webPasswordList"
})
public class ResponseStatusDataModel {
        public int processId;
        public int processCode;
        public Boolean executeResult;
        public String uuid;
        public String account;
        public String message;
        public String reason;
        public String transactionId;

        @SerializedName("ErrorCode")
        public String errorCode;
        @SerializedName("ErrorMessage")
        public String errorMessage;

        public JsonElement getData() {
                return data;
        }

        public void setData(JsonElement data) {
                this.data = data;
        }

        transient JsonElement data;
}
