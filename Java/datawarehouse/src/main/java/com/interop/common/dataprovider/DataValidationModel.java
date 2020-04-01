package com.interop.common.dataprovider;

import com.sandata.core.annotation.CsvHeader;
import lombok.Data;

@Data
public class DataValidationModel {
    @CsvHeader("Description")
    private String description;
    @CsvHeader("Name")
    private String propertyName;
    @CsvHeader("Type")
    private String propertyType;
    @CsvHeader("Value")
    private String propertyValue;
    @CsvHeader("POST Status")
    private String postStatus;
    @CsvHeader("Error Message in POST")
    private String expectedMessage;
    @CsvHeader("GET Status")
    private String uuidStatus;
    @CsvHeader("Error Message in GET")
    private String uuidExpectedError;
    @CsvHeader("isCheckedDatabase")
    private String isVerifyExistingDatabase;

    public DataValidationModel() {
    }

    public DataValidationModel(DataValidationModel data) {
        this.description = data.description;
        this.propertyName = data.propertyName;
        this.propertyType = data.propertyType;
        this.propertyValue = data.propertyValue;
        this.postStatus = data.postStatus;
        this.expectedMessage = data.expectedMessage;
        this.uuidStatus = data.uuidStatus;
        this.uuidExpectedError = data.uuidExpectedError;
        this.isVerifyExistingDatabase = data.isVerifyExistingDatabase;
    }

    @Override
    public String toString() {
        return "DataValidationModel{" +
                "description='" + description + '\'' +
                ", propertyName='" + propertyName + '\'' +
                ", propertyType='" + propertyType + '\'' +
                ", propertyValue='" + propertyValue + '\'' +
                ", postStatus='" + postStatus + '\'' +
                ", expectedMessage='" + expectedMessage + '\'' +
                ", uuidStatus='" + uuidStatus + '\'' +
                ", uuidExpectedError='" + uuidExpectedError + '\'' +
                ", isVerifyExistingDatabase='" + isVerifyExistingDatabase + '\'' +
                '}';
    }
}
