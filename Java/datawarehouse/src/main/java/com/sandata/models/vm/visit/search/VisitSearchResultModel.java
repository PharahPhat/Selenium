package com.sandata.models.vm.visit.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.stream.Collectors;

@JsonIgnoreProperties(ignoreUnknown=true)
public class VisitSearchResultModel {

    public List<VisitSearchResultRowModel> getRows() {
        return rows;
    }

    public void setRows(List<VisitSearchResultRowModel> rows) {
        this.rows = rows;
    }

    List<VisitSearchResultRowModel> rows;

    public String getVisitKeyByFirstName(String firstname) {
        List<VisitSearchResultRowModel> rows = this.rows.stream()
                .filter(row ->
                        (row.EmployeeName != null && row.getEmployeeName().contains(firstname)))
                .collect(Collectors.toList());
        if( rows.size() > 0 ) {
            return rows.get(0).getVisitKey();
        }
        return "";
    }

    public String getWorkerKeyByFirstName(String firstname) {
        List<VisitSearchResultRowModel> rows = this.rows.stream()
                .filter(row ->
                        (row.EmployeeName != null && row.getEmployeeName().contains(firstname)))
                .collect(Collectors.toList());
        if( rows.size() > 0 ) {
            return String.valueOf(rows.get(0).getWorkerKey());
        }
        return "";
    }

    public String getUpdateIdByFirstName(String firstname) {
        List<VisitSearchResultRowModel> rows = this.rows.stream()
                .filter(row ->
                        (row.EmployeeName != null && row.getEmployeeName().contains(firstname)))
                .collect(Collectors.toList());
        if( rows.size() > 0 ) {
            return String.valueOf(rows.get(0).getUpdateId());
        }
        return "";
    }

    public String getUpdateIdByVisitKey(String visitKey) {
        List<VisitSearchResultRowModel> rows = this.rows.stream()
                .filter(row ->
                        (row.getVisitKey() != null && row.getVisitKey().contains(visitKey)))
                .collect(Collectors.toList());
        if( rows.size() > 0 ) {
            return String.valueOf(rows.get(0).getUpdateId());
        }
        return "";
    }
}
