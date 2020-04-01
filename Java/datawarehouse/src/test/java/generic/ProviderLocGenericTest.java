package generic;

import com.sandata.common.Constant;
import com.sandata.models.provider.ProviderLocModel;
import org.testng.Assert;

import java.util.List;


public class ProviderLocGenericTest extends V8VisitGenericTest{

    public void validateProviderLocAsExpectedResults(){
        List<ProviderLocModel> datas = filterProviderLocBy();
        Assert.assertTrue(datas.size() > 0, "File data is not generated");
    }

    public void validateProviderLocAsExpectedFormat(){
        List<ProviderLocModel> datas = filterProviderLocBy();
        Assert.assertTrue(datas.size() > 0, "File data is incorrect format");
    }

    public List<ProviderLocModel> filterProviderLocBy() {
        return mapDataFileToModel(baseObj.readDataValue("Extension"),
                Constant.DOWNLOAD_FOLDER + "/" + fileName, ProviderLocModel.class);
    }
}
