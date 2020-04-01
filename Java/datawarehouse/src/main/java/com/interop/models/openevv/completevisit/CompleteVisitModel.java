package com.interop.models.openevv.compeletevisit;

import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.List;

public class CompleteVisitModel {
    private String id;
    private String sessionId;
    private String status;
    private int totalRows;
    private int page;
    private int pageSize;
    private List<com.interop.models.openevv.completevisit.Visit> data;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<com.interop.models.openevv.completevisit.Visit> getData() {
        return data;
    }

    public void setData(List<com.interop.models.openevv.completevisit.Visit> data) {
        this.data = data;
    }

    @Override
    public String toString () {
        return ToStringBuilder.reflectionToString(this);
    }
}
