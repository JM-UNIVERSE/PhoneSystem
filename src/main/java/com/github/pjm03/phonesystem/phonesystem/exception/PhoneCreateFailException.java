package com.github.pjm03.phonesystem.phonesystem.exception;

import org.springframework.http.HttpStatus;

public class PhoneCreateFailException extends PhoneServiceException {
    public PhoneCreateFailException(String message) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, message);
    }
}
