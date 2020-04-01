package com.interop.common.constants.utils.exceptions;

public class PGPDecryptException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public PGPDecryptException(String message) {
        super(message);
    }

    public PGPDecryptException(String message, Throwable cause) {
        super(message, cause);
    }

    public PGPDecryptException(Throwable cause) {
        super(cause);
    }
}
