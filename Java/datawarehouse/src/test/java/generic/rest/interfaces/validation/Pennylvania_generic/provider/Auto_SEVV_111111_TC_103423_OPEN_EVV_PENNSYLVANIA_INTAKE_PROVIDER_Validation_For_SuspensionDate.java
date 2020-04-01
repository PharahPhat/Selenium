package generic.rest.interfaces.validation.Pennylvania_generic.provider;

import com.sandata.common.Constant;
import generic.rest.interfaces.InterfacesGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_111111_TC_103423_OPEN_EVV_PENNSYLVANIA_INTAKE_PROVIDER_Validation_For_SuspensionDate extends InterfacesGenericTest {
    @Test
    public void Auto_SEVV_111111_TC_103423_OPEN_EVV_PENNSYLVANIA_INTAKE_PROVIDER_Validation_For_SuspensionDate() {
        logStepInfo("Step 1: Validate " +
                "response status FAILED, " +
                "Provider Records are not inserted into STX when format 'SuspensionDate' <> YYYY-MM-DD");

        boolean result1 = pennsylvania_provider.SuspensionDate(Constant.DataType.userInput, 0, "02-02-2019", false);

        logStepInfo("Step 2: Validate " +
                "response status SUCCESS, " +
                "Provider Records are inserted into STX when format 'SuspensionDate' == YYYY-MM-DD");

        boolean result2 = pennsylvania_provider.SuspensionDate(Constant.DataType.userInput, 0, "2019-10-02", true);

        logStepInfo("Step 3: Validate " +
                "response status FAILED, " +
                "When enter invalid day of SuspensionDate");

        boolean result3 = pennsylvania_provider.SuspensionDate(Constant.DataType.userInput, 0, "2019-04-31", false);

        logStepInfo("Step 4: Validate " +
                "response status SUCCESS, " +
                "enter with trim spaces/null in SuspensionDate parameter");

        boolean result4 = pennsylvania_provider.SuspensionDate(Constant.DataType.userInput, 0, "    ", true);
        boolean result5 = pennsylvania_provider.SuspensionDate(Constant.DataType.userInput, 0, null, true);

        logStepInfo("Step 5: Validate " +
                "response status FAILED, " +
                "Provider Records are not inserted into STX when Year of SuspensionDate < 1900 and > 2100");

        boolean result6 = pennsylvania_provider.SuspensionDate(Constant.DataType.userInput, 0, "1899-02-27", false);
        boolean result7 = pennsylvania_provider.SuspensionDate(Constant.DataType.userInput, 0, "2101-02-27", false);

        logStepInfo("Step 6: Validate " +
                "response status FAILED, " +
                "when enter any character in 'SuspensionDate'");

        boolean result8 = pennsylvania_provider.SuspensionDate(Constant.DataType.userInput, 0, "abcTest", false);

        Assert.assertTrue(result1 && result2 && result3 && result4 && result5 && result6 && result7 && result8, "Failed to validation for SuspensionDate of a single open evv pennsylvania provider");
    }
}
