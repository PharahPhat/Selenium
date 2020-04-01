package com.interop.services.openevv;

import com.google.gson.Gson;
import com.interop.common.constants.utils.db.EmployeeDbUtils;
import com.interop.common.dataprovider.DataValidationModel;
import com.interop.models.db.stx.STXEmployee;
import com.interop.models.openevv.employee.OpenEvvEmployee;
import com.interop.models.openevv.employee.OpenEvvEmployeeDataGenerator;
import com.interop.services.base.RestfulService;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static com.interop.services.base.ImportBaseTest.stateAccount;

public class OpenEvvEmployeeService extends RestfulService {
    private List<OpenEvvEmployee> models = new ArrayList<>();

    /**
     * Create a list of employee
     *
     * @param count: number array employee
     * @return Open EVV employees
     */
    public static OpenEvvEmployeeService init(int count, String fName, String acc, String username, String password, String providerId) {
        OpenEvvEmployeeService openEvvGenericEmployee = new OpenEvvEmployeeService();
        if (acc != null && username != null && password != null && providerId != null) {
            openEvvGenericEmployee.getStateAccount().setProviderID(providerId);
            openEvvGenericEmployee.getStateAccount().setAccountID(acc);
            openEvvGenericEmployee.getStateAccount().setWsUserName(username);
            openEvvGenericEmployee.getStateAccount().setWsPassword(password);
        }
        for (int i = 0; i < count; i++) {
            OpenEvvEmployee employee = OpenEvvEmployeeDataGenerator.getOpenEvvEmployeeByState(openEvvGenericEmployee.getStateAccount().getStateEnum());
            employee.setEmployeeFirstName(fName);
            openEvvGenericEmployee.addModelOnly(employee);
        }
        openEvvGenericEmployee.loadPayload(openEvvGenericEmployee.getModels());
        return openEvvGenericEmployee;

    }

    public static OpenEvvEmployeeService init() {
        OpenEvvEmployeeService openEvvGenericEmployee = new OpenEvvEmployeeService();
        OpenEvvEmployee employee = OpenEvvEmployeeDataGenerator.getOpenEvvEmployeeByState(openEvvGenericEmployee.getStateAccount().getStateEnum());
        openEvvGenericEmployee.addModel(employee);
        return openEvvGenericEmployee;

    }

    @Override
    public String getURI() {
        return "interfaces/intake/employees/rest/api/v1/evv";
    }

    private void addModel(OpenEvvEmployee model) {
        getModels().add(model);
        loadPayload(getModels());
    }

    private void addModelOnly(OpenEvvEmployee model) {
        getModels().add(model);
    }

    @Override
    public void loadPayload(List employee) {
        payload = new Gson().toJsonTree(employee);
    }

    @Override
    public void verifyOracleDb(DataValidationModel data) {
        if ("yes".equalsIgnoreCase(data.getIsVerifyExistingDatabase())) {
            getAndVerifySTXEmployeeByName();
        }
    }

    @Override
    public void verifyOracleDbByUpdate(DataValidationModel data, String serviceName) {
        if ("yes".equalsIgnoreCase(data.getIsVerifyExistingDatabase())) {
            if (serviceName.equalsIgnoreCase("EmployeePIN")) {
                getAndVerifySTXEmployeeByStxID();
            } else if (serviceName.equalsIgnoreCase("EmployeeID")) {
                getAndVerifySTXEmployeeByAttId();
            }
        }
    }

    public void getAndVerifySTXEmployeeByName() {
        for (int i = 0; i < getModels().size(); i++) {
            List<STXEmployee> result = EmployeeDbUtils.getEmployee(stateAccount.getAccountID(),
                    getModels().get(i).getEmployeeFirstName(),
                    getModels().get(i).getEmployeeLastName());
            STXEmployee stxEmployee = result.get(i);
            OpenEvvEmployee modelOpenEvvEmployee = models.get(i);
            baseObj.validateActualAndExpectedText(stxEmployee.EMPLOYEEFIRSTNAME, modelOpenEvvEmployee.getEmployeeFirstName());
            baseObj.validateActualAndExpectedText(stxEmployee.EMPLOYEELASTNAME, modelOpenEvvEmployee.getEmployeeLastName());
        }
    }

    public void getAndVerifySTXEmployeeByStxID() {
        int retry = 1;
        int retryNum = 3;
        boolean isPass = false;
        for (int i = 0; i < getModels().size(); i++) {
            while (retry < retryNum) {
                List<STXEmployee> result = EmployeeDbUtils.getEmployee(stateAccount.getAccountID(),
                        getModels().get(i).getEmployeePIN());
                if (result.size() != 2) {
                    commons.wait(3);
                    retry++;
                    continue;
                }
                if (result.size() == 2) {
                    isPass = true;
                }
                retry = retryNum;
            }
            Assert.assertTrue(isPass, "The record is updated as expected result");
        }
    }

    public void getAndVerifySTXEmployeeByAttId() {
        for (int i = 0; i < getModels().size(); i++) {
            List<STXEmployee> result = EmployeeDbUtils.getEmployeeByAttID(stateAccount.getAccountID(),
                    getModels().get(i).getEmployeeFirstName(),
                    getModels().get(i).getEmployeeLastName(),
                    getModels().get(i).getEmployeeID());
            STXEmployee stxEmployee = result.get(i);
            OpenEvvEmployee modelOpenEvvEmployee = models.get(i);
            baseObj.validateActualAndExpectedText(stxEmployee.EMPLOYEEFIRSTNAME, modelOpenEvvEmployee.getEmployeeFirstName());
            baseObj.validateActualAndExpectedText(stxEmployee.EMPLOYEELASTNAME, modelOpenEvvEmployee.getEmployeeLastName());
        }
    }

    public List<OpenEvvEmployee> getModels() {
        return models;
    }

    @Override
    @SuppressWarnings({"rawtypes", "unchecked"})
    public void setModels(List model) {
        models = model;
        loadPayload(getModels());
    }
}
