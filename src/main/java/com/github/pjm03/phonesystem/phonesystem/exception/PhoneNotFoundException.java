package com.github.pjm03.phonesystem.phonesystem.exception;

import org.springframework.http.HttpStatus;

public class PhoneNotFoundException extends PhoneServiceException {
    public PhoneNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}
