package generic;

import com.sandata.common.Constant;
import com.sandata.models.dwh.ohio.ClaimStackRequests;
import com.sandata.models.dwh.ohio.DwhExtract;
import com.sandata.models.dwh.ohio.Visit;
import com.sandata.models.molina.visit.VisitClaimstModel;
import org.testng.Assert;

import java.util.List;

public class VisitClaimstGenericTest extends VisitGenericTest{

    public void validateVisitClaimstAsExpectedResults(){
        List<VisitClaimstModel> datas = filterVisitClaimstBy();
        Assert.assertTrue(datas.size() > 0, "File data is not generated");
    }

    public void validateVisitClaimstAsExpectedFormat(){
        List<VisitClaimstModel> datas = filterVisitClaimstBy();
        Assert.assertTrue(datas.size() > 0, "File data is incorrect Format");
    }

    public List<VisitClaimstModel> filterVisitClaimstBy() {
        return mapDataFileToModel(baseObj.readDataValue("Extension"),
                Constant.DOWNLOAD_FOLDER + "/" + fileName, VisitClaimstModel.class);
    }

    public void validateOhioVisitClaimFromJsonData(){
        DwhExtract exportedFile = getDataOhioExported(ohioExportedFileName);
        List<Visit> visits =  exportedFile.getVisit();
        if(visits != null){
            List<ClaimStackRequests> claims = visits.get(0).getClaimStackRequests();
            if(claims != null && claims.size() > 0)
                Assert.assertTrue(claims.get(0).getDataIsNotNull(), "Visit claim is not expected result");
        }
    }

}
