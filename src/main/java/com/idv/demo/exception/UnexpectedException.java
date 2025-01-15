package com.idv.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UnexpectedException extends ResponseStatusException {

    public UnexpectedException() {
        super(HttpStatus.INTERNAL_SERVER_ERROR, "WARNING.SOMETHING_WENT_WRONG");
    }

    public UnexpectedException(String reason) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, reason);
    }

    public UnexpectedException(String reason, Throwable cause) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, reason, cause);
    }
}
