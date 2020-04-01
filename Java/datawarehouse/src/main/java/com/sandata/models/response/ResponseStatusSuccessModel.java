package com.sandata.models.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class ResponseStatusSuccessModel<T> extends ResponseStatusModel{
    public ResponseStatusDataModel data;
}
