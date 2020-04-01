package com.sandata.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("squid:S00115")
public class Constant {
    public static int exported = 0;
    public static final int CONS_SFTP_SEND_FILE_RETRYCOUNT = 15;
    public static final String CONS_UTC_DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";
    public static final String DOWNLOAD_FOLDER = "download";
    public static final String SFTP_FOLDER = "DevOhioInterfaces/DevSwarmExportDataWarehouse";
    public static final String CONS_RESOURCES_JSON = "src/main/java/Resources/DWHExport/";

    public static final String PROVIDER_GENERAL = "PROVIDER_GENERAL";
    public static final String CLIENT_GENERAL = "CLIENT_GENERAL";
    public static final String CLIENT_PROG = "CLIENT_PROG";
    public static final String CLIENT_ELIG = "CLIENT_ELIG";
    public static final String CLIENT_DIAG = "CLIENT_DIAG";
    public static final String CLIENT_ADDR = "CLIENT_ADDR";
    public static final String CLIENT_PHONE = "CLIENT_PHONE";
    public static final String CLIENT_SCHEDULE = "CLIENT_SCHEDULE";
    public static final String CLIENT_DESIGNEE = "CLIENT_DESIGNEE";
    public static final String CLIENT_AUTH = "CLIENT_AUTH";
    public static final String EMP_GENERAL = "EMP_GENERAL";
    public static final String EMP_DISC = "EMP_DISC";
    public static final String VISIT_GENERAL = "VISIT_GENERAL";
    public static final String VISIT_CALLS = "VISIT_CALLS";
    public static final String VISIT_TASKS = "VISIT_TASKS";
    public static final String VISIT_CHANGES = "VISIT_CHANGES";
    public static final String VISIT_CLAIMST = "VISIT_CLAIMST";
    public static final String VISIT_EXCP = "VISIT_EXCP";
    public static final String ODM_EVV_DWExtract = "ODM_EVV_DWExtract";
    public static final String DODD_EVV_DWExtract = "DODD_EVV_DWExtract";
    public static final String UHC_EVV_DWEXTRACT = "UHC_EVV_DWExtract";
    public static final String MOLINA_EVV_DWEXTRACT = "Molina_EVV_DWExtract";

    public static final List<String> MOLINA_ACCOUNT = new ArrayList<>(Arrays.asList("28625"));

    public static final String MOLINA = "MOLINA";
    public static final String OHIO = "OHIO";
    public static final String CONNECTICUT = "CONNECTICUT";
    public static final String MOLINA_PROVIDER_BODY_JSON = "json/Molina/ProvidersWithConfiguration.json";

    public static final String TOTAL_FILES = "Total Files";
    public static final String PROVIDER_LOC = "PROVIDER_LOC";
    public static final String TOTAL_RECORD = "Grand total of records generated";
    public static final String[] EXPORT_FILES = {PROVIDER_GENERAL, PROVIDER_LOC, CLIENT_GENERAL, CLIENT_PROG, CLIENT_ELIG,
            CLIENT_DIAG, CLIENT_ADDR, CLIENT_PHONE, CLIENT_SCHEDULE, EMP_GENERAL,
            EMP_DISC, VISIT_GENERAL, VISIT_CALLS, VISIT_TASKS, VISIT_EXCP, VISIT_CHANGES, VISIT_CLAIMST};

    public static final String SFTP_HOST = "nhdevftp.sandata.com";
    public static final int SFTP_PORT = 22;
    public static final String SFTP_IMPORT_USERNAME = "H4mAD4DM";
    public static final String SFTP_IMPORT_MATKHAU = "ckgz4zcU";
    public static final String SFTP_IMPORT_MOLINA_FOLDER = "/DEV_4_QA/Molina_Interfaces/28000";
    public static final String SFTP_IMPORT_INDIANA_FOLDER = "/DEV_4_QA/Indiana_Interfaces/29000";

    public enum ClientDBColumns {
        CL_ACCOUNT, CL_LOC, CL_CLIENTKEY, CL_F_NAME, CL_M_NAME, CL_L_NAME, CL_NAME_SUFFIX, CL_SPV_E_MAIL, CL_TZNAME,

        CLS_ADDR1, CLS_ADDR2, CLS_CITY, CLS_STATE, CLS_ZIP_CODE, CLS_COUNTY, CLS_ADDR_TYPE_QLFR,
        CLS_CLIENT_SSN, CLS_CLIENT_ID_CUSTOM1, CLS_CLIENT_ID_CUSTOM2,
        CLS_MEDICAID_ID, CLS_MRN, CLS_CONTRACT, CLS_REGION, CLS_CASE_MANAGER, CLS_LANGUAGE, CLS_CASE_MANAGER_E_MAIL,
        CLS_SEX, CLS_MARITAL_STATUS_CODE, CLS_DOB, CLS_EMAIL, CLS_CLIENT_PRIORITY,

        AU_PAYOR_ID, AU_CONTRACT, AU_PROVIDER, AU_AUTH_REF_NUMBER, AU_BEG_DATE,
        AU_END_DATE, AU_DIAGNOSIS_CODE,

        AL_PROGRAM, AL_SERVICE, AL_MODIFIER1, AL_MODIFIER2, AL_MODIFIER3, AL_MODIFIER4,
        AL_BEG_TIME, AL_END_TIME,

        CLA_ADDR1, CLA_ADDR2, CLA_CITY, CLA_COUNTY, CLA_STATE,
        CLA_ZIP_CODE, CLA_LATITUDE, CLA_LONGITUDE, CLA_ADDR_TYPE_QLFR,

        CLC_CLIENTKEY, CLC_CONTACT_TYPE_CODE, CLC_F_NAME,
        CLC_L_NAME, CLC_ADDR1, CLC_ADDR2,
        CLC_CITY, CLC_STATE, CLC_ZIPCODE, CLC_PHONENUM_HOME, CLC_STATUS,
        CLC_PHONENUM_BUSINESS,
        CLC_PHONENUM_MOBILE, CLC_PHONENUM_OTHER, CLC_E_MAIL,

        AN_DESCRIPTION, ANI_ANI,

        APP_U_USER_F_NAME, APP_U_USER_L_NAME, APP_U_USERNAME,
        APP_U_ACCOUNT_STATUS,
        APP_U_INSERT_TMSTP,
        APP_U_DESCRIPTION, APP_U_EXPIRE_DATE, APP_U_LOCK_DATE, APP_U_CREATED,
        APP_U_DELETED, APP_U_USER_TYPE_ID,

        XREF_BEG_DATE,
        XREF_END_DATE,
        XREF_ACCOUNT,
        XREF_LOC,
        XREF_STX_ID,
        XREF_SERVICE
    }

    public enum ClientType {
        basic_info, auth_limit, address, contact, ani, app_user, xref
    }
    public enum DataType {
        alphabetic, numeric, alphaNumeric, userInput, randomString, NULL
    }

    public enum ClientContactPhoneType {
        Home, Mobile, Business, Other
    }

    public enum ClientContactType {
        Family, Other
    }

    public enum ClientAddressType {
        Home, Business, Other
    }

    public enum ClientPhoneType {
        Home, Mobile, Business, Other
    }

    public enum ClientStatus {
        Pending {
            @Override
            public String toString() {
                return "01";
            }
        },
        Active {
            @Override
            public String toString() {
                return "02";
            }
        },
        Hold {
            @Override
            public String toString() {
                return "03";
            }
        },
        Inactive {
            @Override
            public String toString() {
                return "04";
            }
        }
    }

    public enum IMPORT_PREFIX {
        EVV_Member,
        EVV_PriorAuth,
        EVV_Provider,
        EVV_Outbound,
        ControlFile
    }

    public enum SPEC_VERSION {
        maine,
        generic
    }

    public enum PAYER_ID {
        MEDHHS,
        ODM,
        CTDSS,
        FSSA,
        ODA,
        DODD,
        UHC,
        Molina,
        Aetna,
        Buckeye,
        CareSource,
        Paramount,
        COHCPF,
        DVHA,
        PADHS,
        INFSSA,
        AHCCCS,
        HI_AC

    }

    public enum PROGRAM_SERVICE_CODE {
        Indep19PTPT {
            @Override
            public String toString() {
                return "G0151_19";
            }
        },
        T1000 {
            @Override
            public String toString() {
                return "T1000";
            }
        }
    }

    public enum VERSION {
        v1,
        v2,
        v3
    }

    public static final String[] CLIENTSTATE = {"AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN",
            "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH",
            "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"};

    public enum HEADER {
        ContentType {
            @Override
            public String toString() {
                return "Content-Type";
            }
        },
        Authorization {
            @Override
            public String toString() {
                return "Authorization";
            }
        },
        Account {
            @Override
            public String toString() {
                return "Account";
            }
        }
    }

    public enum CONTENT_TYPE {
        ApplicationJson {
            @Override
            public String toString() {
                return "application/json";
            }
        }
    }

    public enum EXTENSION {
        txt, csv, dat, gpg, pgp, dsv
    }

    public enum ACCOUNT_TYPE {
        MOLINA, OHIO, CONNECTICUT, INDIANA, PA
    }

    public enum VISIT_EXCEPTION {
        VisitsWithoutOutCalls(4),
        VisitVerificationException(28),
        UnauthorizedService(34),
        ClientSignatureException(39),
        ServiceVerificationException(40);

        private final int value;

        VISIT_EXCEPTION(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public enum REQUEST_TYPE {
        HTTP_REQUEST, INTAKE
    }

    public enum ProviderQualifier {
        SandataID, NPI, API, MedicaidID, TaxID, Taxonomy, Legacy, Other
    }

    public enum EmployeeQualifier {
        EmployeeSSN, EmployeeRegID, EmployeeCustomID
    }

    public enum CallAssignment {
        TimeIn {
            @Override
            public String toString() {
                return "Time In";
            }
        },
        TimeOut {
            @Override
            public String toString() {
                return "Time Out";
            }
        },
        CallIn {
            @Override
            public String toString() {
                return "Call In";
            }
        },
        CallOut {
            @Override
            public String toString() {
                return "Call Out";
            }
        },
        Interim {
            @Override
            public String toString() {
                return "Interim";
            }
        },
        Other
    }

    public enum ClientQualifier {
        ClientSSN, ClientOtherID, ClientCustomID
    }

    public enum RI_EMPLOYEE_POSITION {
        HHA, HCA, RN, LPN, PCA
    }

    public enum CallType {
        IVR, FVV, MVV, MANUAL, NONSTX, Other
    }
}
