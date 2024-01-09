package com.fullbackend.lab5.exeception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

public class NotFoundException extends RuntimeException {

    @Setter
    private String message;

    @Getter
    private HttpStatus status = HttpStatus.NOT_FOUND;

    public NotFoundException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
