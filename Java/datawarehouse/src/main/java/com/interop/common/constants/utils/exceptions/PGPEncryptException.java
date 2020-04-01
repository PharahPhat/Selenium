package com.interop.common.constants.utils.exceptions;

public class PGPEncryptException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public PGPEncryptException(String message) {
        super(message);
    }

    public PGPEncryptException(String message, Throwable cause) {
        super(message, cause);
    }

    public PGPEncryptException(Throwable cause) {
        super(cause);
    }

}
