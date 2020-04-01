package com.sandata.utils;


import com.sandata.utilities.CSVReader;

import java.io.File;

public class DataDrivenUtils {
    private DataDrivenUtils() {
    }
    public static final String FILE_PATH_DATA_DRIVEN = System.getProperty("user.dir")+File.separator;

    /**
     * This method support load data driven in CSV files
     * @param csvReader
     * @return
     */
    public static Object[][] initDataDriven(CSVReader csvReader) {
        Object[][] dataDriven = new Object[csvReader.getDataRows().size()][100];
        for (int x = 0; x < csvReader.getDataRows().size(); x++) {
            Object fieldName = csvReader.getValue(x, 0);
            Object fieldValue = csvReader.getValue(x, 1);
            Object typeOfTesting = csvReader.getValue(x, 2);
            Object errorCode = csvReader.getValue(x, 3);
            dataDriven[x] = new Object[]{fieldName, fieldValue, typeOfTesting, errorCode};
        }
        return dataDriven;
    }

}
