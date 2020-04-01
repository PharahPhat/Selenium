package com.interop.common.constants;

import static java.io.File.separator;

public class Constant {
    private Constant(){}
    public static final char DEFAULT_DELIMITER = '|';
    public static final String DEFAULT_FOLDER = System.getProperty("user.dir");
    public static final String RESOURCE_FILE_GENERATED = DEFAULT_FOLDER + separator + "generatedFileCSV/";
    public static final String ZIP_EXTENSION = ".zip";
    public static final String GENERIC_PATTERN = "yyyyMMdd_hhmmss.SSS";
    public static final String DOWNLOADED_FILES = DEFAULT_FOLDER + separator + "DownloadedFiles/";
    public static final String PATH_PUBLIC_KEY = DEFAULT_FOLDER + separator + "GPG key/public-key.asc";
    public static final String RESOURCE_PATH_FILES_LOAD_TEST_IMPORT = DEFAULT_FOLDER + separator + "PerformanceDataImportFile/";
}
