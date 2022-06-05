package com.github.pjm03.phonesystem.phonesystem.phone;

import com.github.pjm03.phonesystem.phonesystem.api.ApiRequest;
import com.github.pjm03.phonesystem.phonesystem.api.Response;
import com.github.pjm03.phonesystem.phonesystem.exception.PhoneCreateFailException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLIntegrityConstraintViolationException;

@RequiredArgsConstructor
@RestControllerAdvice
@RequestMapping("phone")
public class PhoneController {
    private final ApiRequest api;
    private final PhoneService phoneService;

    @ExceptionHandler(PhoneCreateFailException.class)
    public ResponseEntity<?> createFailHandler(PhoneCreateFailException e) {
        return Response.fail(HttpStatus.INTERNAL_SERVER_ERROR, e.getCause().getClass().getSimpleName());
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<?> phoneNumberDuplicate(SQLIntegrityConstraintViolationException e) {
        return Response.fail(HttpStatus.CONFLICT, "전화번호가 중복되었습니다.");
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<?> exceptionHandler(Throwable t) {
        t.printStackTrace();
        return Response.fail(HttpStatus.INTERNAL_SERVER_ERROR, "서버 내부 오류");
    }

    @GetMapping("/{humanSerial}/create")
    public ResponseEntity<?> createPhone(
            @PathVariable String humanSerial,
            @RequestParam String phoneNumber
    ) {
        Phone phone = phoneService.create(humanSerial, phoneNumber);
        return Response.success(phone);
    }

    @GetMapping("/{humanSerial}")
    public ResponseEntity<?> getPhoneNumber(
            @PathVariable String humanSerial
    ) {
        return Response.success(phoneService.getPhones(humanSerial));
    }
}
