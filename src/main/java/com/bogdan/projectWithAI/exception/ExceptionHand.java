package com.bogdan.projectWithAI.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHand extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CountriesParameterValidateException.class)
    public ResponseEntity<Map<String, String>> exception(CountriesParameterValidateException exception) {
        return validateException(exception.getMessage());
    }

    private ResponseEntity<Map<String, String>> validateException(String message) {
        Map<String, String> response = prepareResponse(
                message,
                "Check the entered values.",
                HttpStatus.BAD_REQUEST.toString()
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    private Map<String, String> prepareResponse(String error, String solution, String status) {
        Map<String, String> response = new HashMap<>();
        response.put("Cause", error);
        response.put("Solution", solution);
        response.put("Status", status);
        return response;
    }
}
