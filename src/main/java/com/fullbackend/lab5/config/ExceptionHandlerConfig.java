package com.fullbackend.lab5.config;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import com.fullbackend.lab5.exeception.AlreadyExistException;
import com.fullbackend.lab5.exeception.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerConfig {

    @ExceptionHandler(NotFoundException.class)
    private ResponseEntity<Object> notFoundException(NotFoundException notFoundException) {
        Map<String, String> map = new HashMap<>();

        map.put("timestamp", Instant.now().toString());
        map.put("message", notFoundException.getMessage());
        map.put("status", notFoundException.getStatus().toString());

        return ResponseEntity.status(notFoundException.getStatus()).body(map);
    }

    @ExceptionHandler(AlreadyExistException.class)
    private ResponseEntity<Object> alreadyExistException(AlreadyExistException alreadyExistException) {
        Map<String, String> map = new HashMap<>();

        map.put("timestamp", Instant.now().toString());
        map.put("message", alreadyExistException.getMessage());
        map.put("status", alreadyExistException.getStatus().toString());

        return ResponseEntity.status(alreadyExistException.getStatus()).body(map);
    }
}
