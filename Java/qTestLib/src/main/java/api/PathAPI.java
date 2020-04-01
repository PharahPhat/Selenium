package api;

class PathAPI {
    private static final String LOGINPATH = "/oauth/token";
    private static final String PROJECTSPATH = "/api/v3/projects";
    private static final String RELEASESPATH = "/%s/releases";
    private static final String TESTCYCLESPATH = "/%1$s/test-cycles?parentId=%s&parentType=release";
    private static final String TESTSUITESFROMCYCLEPATH = "/%s/test-suites?parentId=%s&parentType=test-cycle";
    private static final String TESTSUITESFROMRELEASEPATH = "/%s/test-suites?parentId=%s&parentType=release";
    private static final String TESTRUNFROMTESTSUITEPATH = "/%s/test-runs?parentId=%s&parentType=test-suite";
    private static final String TESTRUNFROMCYCLEPATH = "/%s/test-runs?parentId=%s&parentType=test-cycle";
    private static final String TESTRUNPATH = "/%s/test-runs/%s";
    private static final String TESTLOGPATH = "/test-logs";
    private static final String TESTCACESPATH = "/%s/test-cases?parentId=%s&page=0&size=0&expandProps=True&expandSteps=false";
    private static final String TESTCACEPATH = "/%s/test-cases/%s";
    private static final String CREATETESTCYCLESPATH = "/%s/test-cycles?parentType=root";
    private static final String CREATETESTRUNPATH = "/%s/test-runs?parentId=%s&parentType=test-cycle";
    private static final String TESTCASEFIELD = "/%s/settings/test-cases/fields";
    private static final String APPROVETESTCACEPATH = "/%s/test-cases/%s/approve";
    private static final String CREATETESTRUNFROMTESTSUITEPATH = "/%s/test-runs?parentId=%s&parentType=test-suite";
    private static final String MODULESPATH = "/%s/modules?parentId=%s";


    protected PathAPI() {

    }

    static String getLOGINPATH() {
        return LOGINPATH;
    }

    static String getPROJECTSPATH() {
        return PROJECTSPATH;
    }

    static String getRELEASESPATH() {
        return RELEASESPATH;
    }

    static String getTESTCYCLESPATH() {
        return TESTCYCLESPATH;
    }

    static String getTESTSUITESFROMCYCLEPATH() {
        return TESTSUITESFROMCYCLEPATH;
    }

    static String getTESTSUITESFROMRELEASEPATH() {
        return TESTSUITESFROMRELEASEPATH;
    }

    static String getTESTRUNFROMTESTSUITEPATH() {
        return TESTRUNFROMTESTSUITEPATH;
    }

    static String getTESTRUNFROMCYCLEPATH() {
        return TESTRUNFROMCYCLEPATH;
    }

    static String getTESTRUNPATH() {
        return TESTRUNPATH;
    }

    static String getTESTLOGPATH() {
        return TESTLOGPATH;
    }

    public static String getTESTCACESPATH() {
        return TESTCACESPATH;
    }

    public static String getTESTCACEPATH() {
        return TESTCACEPATH;
    }

    public static String getCREATETESTCYCLESPATH() {
        return CREATETESTCYCLESPATH;
    }

    public static String getCREATETESTRUNPATH() {
        return CREATETESTRUNPATH;
    }

    public static String getTESTCASEFIELD() {
        return TESTCASEFIELD;
    }

    public static String getAPPROVETESTCACEPATH() {
        return APPROVETESTCACEPATH;
    }

    public static String getMODULESPATH() {
        return MODULESPATH;
    }
}
