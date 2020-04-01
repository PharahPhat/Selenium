package dwh.generic;

import com.interop.models.altevv.dwh.DwhExport;
import com.interop.models.altevv.dwh.DwhExportDataGenerator;
import com.interop.services.dwh.DwhExportService;
import generic.GenericTest;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_DWH_Export_Files extends GenericTest {
    private DwhExport model = DwhExportDataGenerator.getDefaultDwhExportBuilder();
    private DwhExportService dwhExportService = new DwhExportService();

    @Test
    public void Auto_SEVV_TC_DWH_Export_Files() {
        dwhExportService.setModel(model);
        dwhExportService.post();
        dwhExportService.verifyPostStatus("200");
    }
}
