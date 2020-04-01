package com.interop.common.constants.queries;

@SuppressWarnings({"squid:S1192","squid:S1118"})
public class InterOpSQL {

    public static final String SQL_CHECK_SANTRAX_AC_EXISTED =
            "SELECT \n" +
                    "  jalParentID \n" +
                    "FROM \n" +
                    "  nhomeadmin51.dbo.JVAgencyLink \n" +
                    "WHERE \n" +
                    "  jalAgencyID = '%s'\n";


    public static final String SQL_GET_AGENCY_DB =
            "SELECT agencyDB\n" +
                    "FROM nhomeadmin51.dbo.Agency\n" +
                    "WHERE agencyID = '%s'";


    public static final String SQL_GET_AMP_BASIC_CONFIGURATION =
            "SELECT isLive,"+
                    " SantraxServiceName,"+
                    " EnableSantraxSupport,"+
                    " SantraxScheduleProcessingMethod"+
                    " FROM "+
                    "nhomeadmin51.dbo.Agency "+
                    "WHERE "+
                    "agencyDB = '%s'";


    public static final String SQL_GET_SANTRAX_AND_OPEN_EVV_CONFIGURATION =
            "SELECT                                                 \n"+
                    "  '%s',                                        \n"+
                    "  *                                            \n"+
            "FROM                                                   \n"+
                    "  %s.dbo.Configuration                        \n"+
            "WHERE                                                  \n"+
                    "  configName IN (                              \n"+
                    "  'Santrax', 'Use Open EVV', 'Santrax WUID',   \n"+
                    "  'Santrax OPWD'                               \n"+
                    "  )                                            \n"+
                "SELECT                                             \n"+
                    "  pyrTelephony,                                \n"+
                    "  pyrSantraxAcctNo,                            \n"+
                    "  *                                            \n"+
            "FROM                                                   \n"+
                    "  %s.dbo.Payors";

    public static final String SQL_GET_TELEPHONY_CONFIGURATION =
            "SELECT                         "+
                "  pyrTelephony,            "+
                "  pyrSantraxAcctNo         "+
            "FROM                           "+
                "  %s.dbo.Payors";

    public static final String SQL_CHECK_FILE_IMPORT_MEMBER_AND_AUTH =
            "SELECT \n"+
                    "  entFirstName,            \n"+
                    "  entMiddleInitial,        \n"+
                    "  entLastName,             \n"+
                    "  entLanguage,             \n"+
                    "  entSex,                  \n"+
                    "  adrName,                 \n"+
                    "  adrAddress,              \n"+
                    "  adrAddress2,             \n"+
                    "  adrCity,                 \n"+
                    "  adrState,                \n"+
                    "  adrZip,                  \n"+
                    "  adrPhoneWork,            \n"+
                    "  adrPhoneMobile,          \n"+
                    "  clientCustomID,          \n"+
                    "  clientOtherID,           \n"+
                    "  adCompanyID,             \n"+
                    "  adLocationID,            \n"+
                    "  adStatus,                \n"+
                    "  action                   \n"+
                    "FROM                       \n"+
                    "  [nHomeDW51_PA].[dbo].[DataImport_Client] \n"+
                    "Where                      \n"+
                    "  entFirstName = '%s'";

}
