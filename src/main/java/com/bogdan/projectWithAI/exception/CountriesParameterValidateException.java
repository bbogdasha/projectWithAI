package com.bogdan.projectWithAI.exception;

public class CountriesParameterValidateException extends RuntimeException {
    public CountriesParameterValidateException() {
        super();
    }

    public CountriesParameterValidateException(String message) {
        super(message);
    }
}
