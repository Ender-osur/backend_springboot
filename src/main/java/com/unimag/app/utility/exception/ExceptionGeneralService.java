package com.unimag.app.utility.exception;

public class ExceptionGeneralService extends RuntimeException {

    public ExceptionGeneralService() {
        super();
    }

    public ExceptionGeneralService(String message) {
        super(message);
    }

    public ExceptionGeneralService(String message, Throwable cause) {
        super(message, cause);
    }

    public ExceptionGeneralService(Throwable cause) {
        super(cause);
    }

    public ExceptionGeneralService(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
