package com.setlocal.psychologyTests.exception;

public class TestNotRunException extends RuntimeException {

    public TestNotRunException() {
    }

    public TestNotRunException(String message) {
        super(message);
    }

    public TestNotRunException(String message, Throwable cause) {
        super(message, cause);
    }

    public TestNotRunException(Throwable cause) {
        super(cause);
    }

    public TestNotRunException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}