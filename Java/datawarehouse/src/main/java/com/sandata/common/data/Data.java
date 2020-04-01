package com.sandata.common.data;

import com.interop.common.TestDataHelper;
import com.sandata.core.Wrapper;

import java.util.HashMap;
import java.util.Map;

public class Data {
    private Data(){}
    public static final Wrapper baseObj = new Wrapper();
    public final static Map<String, TestDataHelper> testCases = new HashMap<>();

    public static TestDataHelper get(String testCaseId) {
        if (testCases.containsKey(testCaseId)) {
            return testCases.get(testCaseId);
        }
        return null;
    }

    public static void set(String testCaseId, TestDataHelper testDataHelper) {
        if (testCases.containsKey(testCaseId)) {
            testCases.put(testCaseId, testDataHelper);
        }
    }
}
