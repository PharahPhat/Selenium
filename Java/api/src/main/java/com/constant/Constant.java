package com.constant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Constant {
    public static final int CONS_SFTP_SEND_FILE_RETRYCOUNT = 15;
    public static final String CONS_UTC_DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";
    public static final String DOWNLOAD_FOLDER = "download";
    public static final String SFTP_FOLDER = "DevOhioInterfaces/DevSwarmExportDataWarehouse";
    public static final String CONS_RESOURCES_JSON = "src/main/java/Resources/DWHExport/";

    public static final String PROVIDER_GENERAL = "PROVIDER_GENERAL";
    public static final String PROVIDER_LOC = "PROVIDER_LOC";
    public static final String CLIENT_GENERAL = "CLIENT_GENERAL";
    public static final String CLIENT_PROG = "CLIENT_PROG";
    public static final String CLIENT_ELIG = "CLIENT_ELIG";
    public static final String CLIENT_DIAG = "CLIENT_DIAG";
    public static final String CLIENT_ADDR = "CLIENT_ADDR";
    public static final String CLIENT_PHONE = "CLIENT_PHONE";
    public static final String CLIENT_SCHEDULE = "CLIENT_SCHEDULE";
    public static final String EMP_GENERAL = "EMP_GENERAL";
    public static final String EMP_DISC = "EMP_DISC";
    public static final String VISIT_GENERAL = "VISIT_GENERAL";
    public static final String VISIT_CALLS = "VISIT_CALLS";
    public static final String VISIT_TASKS = "VISIT_TASKS";
    public static final String VISIT_EXCP = "VISIT_EXCP";
    public static final String VISIT_CHANGES = "VISIT_CHANGES";
    public static final String VISIT_CLAIMST = "VISIT_CLAIMST";
    public static final List<String> MOLINA_ACCOUNT = new ArrayList<>(Arrays.asList("28625"));
    public static final String TO_DECRYPT_PATH = System.getProperty("user.dir") + "/to_decrypt/";
    public static final String MOLINA_PUBLIC_KEY_PATH = System.getProperty("user.dir") + "/lib/intf_molina_publickey.asc";
    public static final String MOLINA_PRIVATE_KEY_PATH = System.getProperty("user.dir") + "/lib/intf_san_molina_pkey.asc";




}
