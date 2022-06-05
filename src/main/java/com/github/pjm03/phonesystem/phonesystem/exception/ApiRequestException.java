package com.github.pjm03.phonesystem.phonesystem.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public class ApiRequestException extends RuntimeException {
    private final HttpStatus status;
    private final String errorMessage;
    private final String message;
}
