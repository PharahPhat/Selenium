package generic;

import org.testng.annotations.Test;

import static com.sandata.common.Constant.CLIENT_AUTH;

public class Auto_SEVV_TC_41832_Validate_Client_Auth_Export_Expected_Result extends EmployeeGeneralGenericTest{

    /**
     * Precondition: specNumber = 7.x
     * Expected result: CLIENT_AUTH col header display CaseManagerLastName, CaseManagerFirstName, CaseManagerEmail
     * Description: SEVV-17155 Inter-Op - EVV DWH Export - Add Case Manager Fields to Export
     * NOTE: exception: PA doesn't use Case Manager feature
     *                  the fields would be exported and be null
     */
    @Test
    public void Auto_SEVV_TC_41832_Validate_Client_Auth_Export_Expected_Result(){
        initStateInfo();
        DWHExport(dwh_startDate_sevv_17155, dwh_endDate_sevv_17155);
        verifyExportedFileExistInSFTP(CLIENT_AUTH);
        downloadExportedFile(CLIENT_AUTH);
        validateCaseManagerDataAsExpectedResult();
    }

    /**
     * Precondition: SpecNumber: 6.x
     * Expected result: CLIENT_AUTH col header don't display CaseManagerLastName, CaseManagerFirstName, CaseManagerEmail
     * Description: SEVV-17155 Inter-Op - EVV DWH Export - Add Case Manager Fields to Export
     */

    @Test
    public void Auto_SEVV_TC_41833_Validate_Client_Auth_Not_Contain_Case_Manager_Header(){
        initStateInfo();
        specNumber = "6.0";
        DWHExport(dwh_startDate_sevv_17155, dwh_endDate_sevv_17155);
        verifyExportedFileExistInSFTP(CLIENT_AUTH);
        downloadExportedFile(CLIENT_AUTH);
        validateHeaderAsExpectedResults("headerVisitCall6.x");
    }
}
