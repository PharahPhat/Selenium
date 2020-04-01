package com.sandata.common;

import java.util.Base64;

public class PasswordUtils {
    private PasswordUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static String getDecodedPassword(String encodedStr) {
        byte[] decodedBytes = Base64.getDecoder().decode(encodedStr);
        return new String(decodedBytes);
    }
}
