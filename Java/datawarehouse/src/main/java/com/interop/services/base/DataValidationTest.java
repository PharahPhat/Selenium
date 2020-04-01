package com.interop.services.base;

import com.interop.common.TestDataHelper;
import com.interop.common.dataprovider.DataPayerProgramCombination;
import com.interop.common.dataprovider.DataValidationModel;
import com.sandata.core.BaseTest;
import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.AfterSuite;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"rawtypes", "unchecked"})
public class DataValidationTest<T extends RestfulService, G> extends BaseTest {
    private static final String MESSAGE_SUMMARY_FOR_SUCCESS = "[1] Records uploaded, please check errors/warnings and try again.";
    private T service;
    private G model;

    public DataValidationTest(T service, G model) {
        this.service = service;
        this.model = model;
    }

    @AfterSuite(alwaysRun = true)
    void closeDBConnection() throws SQLException {
        TestDataHelper.closeDBConnections();
    }

    @Override
    public String getTestType() {
        return "validation";
    }

    public void validateDataValidationField(DataValidationModel dataTest) {
        List models = new ArrayList<>();
        models.add(this.model);
        this.service.setModels(models);
        this.service.modifyPropertyValue(dataTest.getPropertyName(), dataTest.getPropertyType(), dataTest.getPropertyValue());
        this.service.setModels(this.service.getPayLoad(model.getClass()));
        this.sendAndVerifyPost(dataTest);
        this.sendAndVerifyGet(dataTest);
        this.service.verifyOracleDb(dataTest);
    }

    public void validateDataUpdateField(DataValidationModel dataTest, String serviceName) {
        List models = new ArrayList<>();
        models.add(this.model);
        this.service.setModels(models);
        this.service.modifyPropertyValue(dataTest.getPropertyName(), dataTest.getPropertyType(), dataTest.getPropertyValue());
        this.service.setModels(this.service.getPayLoad(model.getClass()));
        this.sendAndVerifyPost(dataTest);
        this.sendAndVerifyGet(dataTest);
        this.service.verifyOracleDbByUpdate(dataTest, serviceName);
    }

    private void sendAndVerifyGet(DataValidationModel dataTest) {
        if (!StringUtils.isBlank(dataTest.getUuidStatus())) {
            this.service.requestUUIDStatus();
            this.service.verifyUUIDStatus(dataTest.getUuidStatus());
            if (!StringUtils.isBlank(dataTest.getUuidExpectedError())) {
                this.service.verifyUUIDFailedWithErrorMessage("", dataTest.getUuidExpectedError());
            }
        }
    }

    private void sendAndVerifyPost(DataValidationModel dataTest) {
        this.service.post();
        this.service.verifyPostStatus(dataTest.getPostStatus());
        if (!StringUtils.isBlank(dataTest.getExpectedMessage())) {
            this.service.verifyMDWFailedWithMessageSummary(
                    MESSAGE_SUMMARY_FOR_SUCCESS, dataTest.getExpectedMessage());
        }
    }

    public void validateDataPayerProgramCombination(DataPayerProgramCombination dataCombination) {
        throw new UnsupportedOperationException();
    }
}
