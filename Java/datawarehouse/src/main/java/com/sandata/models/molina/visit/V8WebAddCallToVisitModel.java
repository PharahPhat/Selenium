package com.sandata.models.molina.visit;

import com.sandata.utilities.DateTimeUtil;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

public class V8WebAddCallToVisitModel {
    public String visitKey = "";
    public String updateId = "";
    public String clientId = "253915";
    public String stxId = "";
    public String callDTime = new SimpleDateFormat("hh:mm a").format(new Date());
    public String timeZone = "US%2FEastern";
    public String reasonCode = "";
    public String reasonCodeMemo = "";
    public String resolutionCode = "";
    public String service = "G0151_40";



    public V8WebAddCallToVisitModel() {
        try {
            callDTime = DateTimeUtil.addDays(new SimpleDateFormat("MM/dd/yyyy").format(new Date()), -1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getVisitKey() {
        return visitKey;
    }

    public void setVisitKey(String visitKey) {
        this.visitKey = visitKey;
    }

    public String getUpdateId() {
        return updateId;
    }

    public void setUpdateId(String updateId) {
        this.updateId = updateId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getStxId() {
        return stxId;
    }

    public void setStxId(String stxId) {
        this.stxId = stxId;
    }

    public String getCallDTime() {
        return callDTime;
    }

    public void setCallDTime(String callDTime) {
        this.callDTime = callDTime;
    }

    public String getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(String reasonCode) {
        this.reasonCode = reasonCode;
    }

    public String getReasonCodeMemo() {
        return reasonCodeMemo;
    }

    public void setReasonCodeMemo(String reasonCodeMemo) {
        this.reasonCodeMemo = reasonCodeMemo;
    }

    public String getResolutionCode() {
        return resolutionCode;
    }

    public void setResolutionCode(String resolutionCode) {
        this.resolutionCode = resolutionCode;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        try {
            sb.append("visitKey='").append(visitKey).append('&');
            sb.append(", updateId='").append(updateId).append('&');
            sb.append(", clientId='").append(clientId).append('&');
            sb.append(", stxId='").append(stxId).append('&');
            sb.append(", callDTime='").append(URLEncoder.encode(callDTime,"UTF-8")).append('&');
            sb.append(", timeZone='").append(timeZone).append('&');
            sb.append(", reasonCode='").append(reasonCode).append('&');
            sb.append(", reasonCodeMemo='").append(reasonCodeMemo).append('&');
            sb.append(", resolutionCode='").append(resolutionCode).append('&');
            sb.append(", service='").append(service);
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        return sb.toString();
    }
}
