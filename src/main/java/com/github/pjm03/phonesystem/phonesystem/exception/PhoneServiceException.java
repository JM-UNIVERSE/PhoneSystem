package com.github.pjm03.phonesystem.phonesystem.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class PhoneServiceException extends RuntimeException {
    private final HttpStatus status;

    public PhoneServiceException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }
}
