package com.sandata.common;

import com.sandata.utilities.CompareUtil;
import org.apache.log4j.Logger;
import org.testng.Assert;

import java.util.List;

public class Validation {
    private static final Logger LOGGER = Logger.getLogger(Validation.class);
    private Validation(){}

    public static <T> void verifyObjectFieldsNotNull(List<T> dataList, List<String> definedField) {
        boolean result = false;
        if (definedField.size() > 0) {
            for(int i = 0; i < dataList.size(); i++) {
                try {
                    result = CompareUtil.isSpecificFieldsNull(dataList.get(i), definedField);
                    Assert.assertFalse(result);
                } catch (Exception e) {
                    LOGGER.error(e.getMessage());
                }
            }
        }
    }
}
