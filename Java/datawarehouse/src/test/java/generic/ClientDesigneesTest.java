package generic;

import com.sandata.db.ClientDbService;
import com.sandata.utilities.TextUtil;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static com.sandata.common.Constant.DOWNLOAD_FOLDER;

public class ClientDesigneesTest extends ClientGenericTest{

    public void validateHeaderClientDesigneeAsExpectedResults(){
        List<String> records = TextUtil.readTextFileRecords(DOWNLOAD_FOLDER + "/" + fileName);
        String headerExpected =  baseObj.readDataValue("headerDesignee");
        headerExpected = headerExpected.replace("\"","");
        String header = records.get(0).replace("\"","");
        Assert.assertTrue(header.equalsIgnoreCase(headerExpected),"Client Designee header is not expected results");
    }

    public void validateHeaderClientGeneralAsExpectedResults(){
        List<String> records = TextUtil.readTextFileRecords(DOWNLOAD_FOLDER + "/" + fileName);
        String headerExpected =  baseObj.readDataValue("headerClientGen");
        headerExpected = headerExpected.replace("\"","");
        String header = records.get(0).replace("\"","");
        Assert.assertTrue(header.equalsIgnoreCase(headerExpected),"Client General header is not expected results");
    }

    public void validateAllRecordsClientDesigneesFileAreClientDesigneesInDB(){
        List<String> records = TextUtil.readTextFileRecords(DOWNLOAD_FOLDER + "/" + fileName);
        List<String> clientIDs = new ArrayList<>();
        for(int i=1 ; i< records.size(); i++){
            String curr = records.get(i).replace("\"","");
            String[] items = curr.split("\\|", -1);
            clientIDs.add(items[0]);
        }
        Assert.assertTrue(clientDbService.validateClientDesigneeInDatabase(account, clientIDs),"Client Designee is exist in db");
    }

}
