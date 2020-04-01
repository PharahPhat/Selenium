package com.sandata.ws.molina.account;

import com.sandata.ws.GenericWebService;
import io.restassured.response.Response;
import com.sandata.utilities.DbUtilsCon;
import java.util.List;
import java.util.Map;
import static com.interop.sql.Sql.SQL_GET_LIST_ACCOUNT_NOT_IN_GROUP;

import static io.restassured.RestAssured.given;

public class AccountWebService extends GenericWebService {
    public Response sendPOSTWithAccountInHeader(String requestUrl, String altEVVJsonArray, String username, String password, String accountId) {
        Response response = given().
                relaxedHTTPSValidation().
                body(altEVVJsonArray).header("Content-Type", "application/json").
                auth().preemptive().
                basic(username, password).
                header("Account", accountId).log().all().
                when().post(requestUrl).
                then().assertThat().statusCode(200).and().extract().response();
        return response;
    }

    public boolean accountNotInGroup(String account, String groupKey) {
        String sql = String.format(SQL_GET_LIST_ACCOUNT_NOT_IN_GROUP, groupKey);
        boolean state = false;
        List<Map<String, Object>> dataTable = DbUtilsCon.getDataTable( getTestEnvironment().getOracleUrl(), getTestEnvironment(), sql);
        for(int i = 0; i < dataTable.size(); i++){
            String accountId = dataTable.get(i).get("ACCOUNT").toString();
            if(accountId.contains(account)){
                return true;
            }
        }
        return state;
    }
}
