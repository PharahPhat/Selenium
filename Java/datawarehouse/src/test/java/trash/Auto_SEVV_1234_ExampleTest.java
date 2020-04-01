package trash;

import com.sandata.core.BaseTest;
import com.sandata.qtest.QTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Auto_SEVV_1234_ExampleTest extends BaseTest {
    @Override
    public String getTestType() {
        return "api";
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method called.");
    }

    @Test(description = "Example Test for update result to qTest")
    @QTest(keys = {"TC-21670", "TC-19458", "TC-19459", "TC-19460", "TC-19461"})
    public void Auto_Test_Upload_To_QTest() {
        System.out.println("Test Upload");
//        Assert.fail();
    }
}
