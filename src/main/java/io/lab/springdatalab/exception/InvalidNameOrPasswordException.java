package io.lab.springdatalab.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class InvalidNameOrPasswordException extends RuntimeException {

    public InvalidNameOrPasswordException(String message) {
        super(message);
    }
}
