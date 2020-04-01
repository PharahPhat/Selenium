package com.interop.services.atlevv;

import com.google.gson.Gson;
import com.interop.common.constants.utils.db.EmployeeDbUtils;
import com.interop.common.dataprovider.DataValidationModel;
import com.interop.models.altevv.client.AltEvvClient;
import com.interop.models.altevv.employee.AltEvvEmployee;
import com.interop.models.db.stx.STXEmployee;
import com.interop.services.base.RestfulService;
import org.apache.log4j.Logger;

import java.util.List;

import static com.interop.services.base.ImportBaseTest.stateAccount;

@SuppressWarnings({"unchecked", "rawtypes"})
public class AltEvvEmployeeService extends RestfulService {
    public static final Logger LOGGER = Logger.getLogger(AltEvvEmployeeService.class);

    protected List<AltEvvEmployee> models;

    public static AltEvvEmployeeService init() {
        AltEvvEmployeeService evvEmployeeService = new AltEvvEmployeeService();
        AltEvvEmployee employee = AltEvvEmployee.builder().build();
        evvEmployeeService.addModel(employee);
        return evvEmployeeService;
    }

    public static AltEvvEmployeeService init(int count) {
        AltEvvEmployeeService evvEmployeeService = new AltEvvEmployeeService();
        for (int i = 1; i <= count; i++) {
            AltEvvEmployee employee = AltEvvEmployee.builder().build();
            evvEmployeeService.addModel(employee);
        }

        evvEmployeeService.loadPayload(evvEmployeeService.models);
        return evvEmployeeService;
    }

    @Override
    public String getURI() {
        return "interfaces/intake/employees/rest/api/v1.1";
    }

    @Override
    public void verifyOracleDb(DataValidationModel data) {
        if ("Yes".equalsIgnoreCase(data.getIsVerifyExistingDatabase())) {
            for (int i=0; i < this.models.size(); i++) {
                AltEvvEmployee altEvvEmployee = this.getModels().get(i);
                STXEmployee result = EmployeeDbUtils.getEmployee(stateAccount.getAccountID(),
                        altEvvEmployee.getEmployeeFirstName(), altEvvEmployee.getEmployeeLastName()).get(i);
                baseObj.validateActualAndExpectedText(result.EMPLOYEELASTNAME, altEvvEmployee.getEmployeeLastName());
                baseObj.validateActualAndExpectedText(result.EMPLOYEEFIRSTNAME, altEvvEmployee.getEmployeeFirstName());
            }
        }
    }

    public void addModel(AltEvvEmployee model) {
        this.models.add(model);
        loadPayload(this.models);
    }

    @Override
    public void setModels(List model) {
        this.models = model;
        loadPayload(this.models);
    }

    @Override
    public void loadPayload(List employee) {
        payload = new Gson().toJsonTree(employee);
    }

    public List<AltEvvEmployee> getModels() {
        return models;
    }
}
