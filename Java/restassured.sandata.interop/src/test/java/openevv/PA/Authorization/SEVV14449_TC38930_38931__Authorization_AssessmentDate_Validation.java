package openevv.PA.Authorization;

import Utills_ExtentReport_Log4j.BaseTest;
import com.common.Validation;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.globalMethods.core.globalVariables.*;

public class SEVV14449_TC38930_38931__Authorization_AssessmentDate_Validation extends BaseTest {
    private GenerateUniqueParam generateUniqueParam=new GenerateUniqueParam();

    @DataProvider(name = "dataProvider")
    public static Object[][] dataProvider() {
        return new Object[][]
                {
                        {true, "2018-12-31", ""},
                        {true, null, ""},
                        {true, "", ""},
                        {true, CommonMethods.generateTodayDate("yyyy-MM-dd"), ""},
                        {false, "20181231", AssessmentDateFormatError},
                        {false, "2018/12/31", AssessmentDateFormatError},
                        {false, "31-12-2018", AssessmentDateFormatError},
                        {false, "12/31/2018", AssessmentDateFormatError},
                        {false, "12-31-2018", AssessmentDateFormatError},
                        {false, "31/12/2018", AssessmentDateFormatError},
                        {false, "31122018", AssessmentDateFormatError},
                };
    }

    @Test(dataProvider = "dataProvider")
    public void TC38930_38931_Authorization_AssessmentDate_Validation(boolean isValid, String value, String errorMessage)
            throws IOException, ParseException, java.text.ParseException, InterruptedException {
        JSONArray altEVVJsonArray = generateUniqueParam.OpenEVV_auth(globalVariables.Auth_json);
        Validation.validationField(altEVVJsonArray, AssessmentDate, isValid, value, errorMessage,
                CommonMethods.propertyfileReader(openEVV_auth));
    }
}
