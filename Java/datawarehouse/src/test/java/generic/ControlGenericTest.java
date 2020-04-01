package generic;

import com.interop.common.Commons;
import com.sandata.utilities.sftp.utils.SftpUtils;
import org.testng.Assert;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static com.sandata.common.Constant.DOWNLOAD_FOLDER;
import static com.sandata.utilities.sftp.utils.SftpUtils.DEVSWARMEXPORTDWH;

public class ControlGenericTest extends V8VisitGenericTest{

    Commons common = new Commons();

    public String GetCorrectFileName(String type){
        for(String exportedFile : exportedFileNames){
            if(exportedFile.contains(type))
                return exportedFile;
        }
        return null;
    }

    public boolean IsExistingFileName(String type){
        for(String exportedFile : exportedFileNames){
            if(exportedFile.contains(type))
                return true;
        }
        return false;
    }

    public void AddDataForTestingForDebug()
    {
        //Add for testing
        exportedFileNames = new ArrayList<String>();
        if(exportedFileNames.size() <= 0)
        {
            exportedFileNames.add("MEDHHS_EVV_DWExtract_PROVIDER_GENERAL_012519_03_08_08.txt");
            exportedFileNames.add("MEDHHS_EVV_DWExtract_PROVIDER_LOC_012519_03_08_08.txt");
            exportedFileNames.add("MEDHHS_EVV_DWExtract_CLIENT_GENERAL_012519_03_08_08.txt");
            exportedFileNames.add("MEDHHS_EVV_DWExtract_CLIENT_PROG_012519_03_08_08.txt");
            exportedFileNames.add("MEDHHS_EVV_DWExtract_CLIENT_ELIG_012519_03_08_08.txt");
            exportedFileNames.add("MEDHHS_EVV_DWExtract_CLIENT_DIAG_012519_03_08_08.txt");
            exportedFileNames.add("MEDHHS_EVV_DWExtract_CLIENT_ADDR_012519_03_08_08.txt");
            exportedFileNames.add("MEDHHS_EVV_DWExtract_CLIENT_PHONE_012519_03_08_08.txt");
            exportedFileNames.add("MEDHHS_EVV_DWExtract_CLIENT_SCHEDULE_012519_03_08_08.txt");
            exportedFileNames.add("MEDHHS_EVV_DWExtract_EMP_GENERAL_012519_03_08_08.txt");
            exportedFileNames.add("MEDHHS_EVV_DWExtract_EMP_DISC_012519_03_08_08.txt");
            exportedFileNames.add("MEDHHS_EVV_DWExtract_VISIT_GENERAL_012519_03_08_08.txt");
            exportedFileNames.add("MEDHHS_EVV_DWExtract_VISIT_CALLS_012519_03_08_08.txt");
            exportedFileNames.add("MEDHHS_EVV_DWExtract_VISIT_TASKS_012519_03_08_08.txt");
            exportedFileNames.add("MEDHHS_EVV_DWExtract_VISIT_EXCP_012519_03_08_08.txt");
            exportedFileNames.add("MEDHHS_EVV_DWExtract_VISIT_CHANGES_012519_03_08_08.txt");
            exportedFileNames.add("MEDHHS_EVV_DWExtract_VISIT_CLAIMST_012519_03_08_08.txt");
        }
    }

    public void VerifyTotalOfRecordsGeneratePerEntity()
    {
        try{
            List<String> listRecord = new ArrayList<String>();

            String controlFileName  = GetControlFileIsGenerated(exportedFileNames);
            Stream<String> stream = Files.lines(Paths.get(DOWNLOAD_FOLDER + "/" + controlFileName), StandardCharsets.UTF_8);
            stream.forEach(s -> listRecord.add(s));
            for (String record : listRecord) {
                record = record.replace("\"","");
                String[] CurrData = record.split("\\|");
                if( CurrData[0].equals("Total Files")){
                    Assert.assertTrue(Integer.parseInt(CurrData[1]) == 17, "Total files should be 17");
                }
                else {
                    if(CurrData[0].contains("EVV_DWExtract"))
                        Assert.assertTrue(IsExistingFileName(CurrData[0]), String.format("The file name is '%s' is not existed in control file", CurrData[0]));
                }
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Read data of the control file and contain records are correct with records of export files
     */
    public void VerifyControlFileSaveCorrectDataAsExpectedResult()
    {
        try{
            List<String> listRecord = new ArrayList<String>();

            String controlFileName  = fileName = GetControlFileIsGenerated(exportedFileNames);
            Stream<String> stream = Files.lines(Paths.get(DOWNLOAD_FOLDER + "/" + controlFileName), StandardCharsets.UTF_8);
            stream.forEach(s -> listRecord.add(s));
            for (String record : listRecord) {
                record = record.replace("\"","");
                String[] CurrData = record.split("\\|");
                if( CurrData[0].equals("Total Files"))
                    Assert.assertTrue(Integer.parseInt(CurrData[1]) == 17, "Total files should be 17");
                String exportedFile = GetCorrectFileName(CurrData[0]);
                if(exportedFile != null){
                    Stream<String> streamEx = Files.lines(Paths.get(DOWNLOAD_FOLDER + "/" + CurrData[0]), StandardCharsets.UTF_8);
                    String count = Long.toString(streamEx.count());
                    Assert.assertTrue(count.equals(CurrData[1]), String.format("The records is not correct as expected results at of file name : %s",CurrData[0]));
                }
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void DownloadControlExportFile(){
        String controlFileName  = fileName = GetControlFileIsGenerated(exportedFileNames);
        File file = SftpUtils.getFile(DEVSWARMEXPORTDWH, DOWNLOAD_FOLDER, controlFileName);
        Assert.assertTrue(file != null, "Control file should be found");
    }

    public void VerifyControlExportFile(){
        String controlFileName  = fileName = GetControlFileIsGenerated(exportedFileNames);
        File file = SftpUtils.getFile(DEVSWARMEXPORTDWH, DOWNLOAD_FOLDER, controlFileName);
        Assert.assertTrue(file != null, "Control file should be found");
    }

    public void VerifyControlTotalRecordsEqualsEachSegments()
    {
        try{
            List<String> listRecord = new ArrayList<String>();

            String controlFileName  = fileName = GetControlFileIsGenerated(exportedFileNames);
            Stream<String> stream = Files.lines(Paths.get(DOWNLOAD_FOLDER + "/" + controlFileName), StandardCharsets.UTF_8);
            stream.forEach(s -> listRecord.add(s));
            int countRec  = 0;
            int TotalRec  = 0;
            for (String record : listRecord) {
                record = record.replace("\"","");
                String[] CurrData = record.split("\\|");
                if( CurrData[0].equals("Grand total of records generated"))
                    TotalRec = Integer.parseInt(CurrData[1]);
                String exportedFile = GetCorrectFileName(CurrData[0]);
                if(exportedFile != null){
                    countRec += Integer.parseInt(CurrData[1]);
                }
            }
            Assert.assertTrue(TotalRec == countRec, "Total records should be equal with count of records of segments");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void VerifyCorrectDateFormat()
    {
        try{
            List<String> listRecord = new ArrayList<String>();
            String controlFileName  = fileName = GetControlFileIsGenerated(exportedFileNames);
            Stream<String> stream = Files.lines(Paths.get(DOWNLOAD_FOLDER + "/" + controlFileName), StandardCharsets.UTF_8);
            stream.forEach(s -> listRecord.add(s));
            for (String record : listRecord) {
                record = record.replace("\"","");
                String[] CurrData = record.split("\\|");
                if( CurrData[0].equals("Export Start Date Time"))
                    Assert.assertTrue(common.isValidUTCFormatDate(CurrData[1]), "Start date is not UTC time");
                if( CurrData[0].equals("Export End Date Time"))
                    Assert.assertTrue(common.isValidUTCFormatDate(CurrData[1]), "End date is not UTC time");
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void VerifyDateRangeControlFileExactWithDateTimeRangeInExportApi(String startDate, String endDate)
    {
        try{
            List<String> listRecord = new ArrayList<String>();
            String controlFileName  = fileName = GetControlFileIsGenerated(exportedFileNames);
            Stream<String> stream = Files.lines(Paths.get(DOWNLOAD_FOLDER + "/" + controlFileName), StandardCharsets.UTF_8);
            stream.forEach(s -> listRecord.add(s));
            for (String record : listRecord) {
                record = record.replace("\"","");
                String[] CurrData = record.split("\\|");
                if( CurrData[0].equals("Export Start Date Time"))
                    Assert.assertTrue(CurrData[1].equals(startDate), "Start date is not UTC time");
                if( CurrData[0].equals("Export End Date Time"))
                    Assert.assertTrue(CurrData[1].equals(endDate), "End date is not UTC time");
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
}
