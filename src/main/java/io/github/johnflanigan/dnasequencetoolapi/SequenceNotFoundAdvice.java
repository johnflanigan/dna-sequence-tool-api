package io.github.johnflanigan.dnasequencetoolapi;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class SequenceNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(SequenceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String employeeNotFoundHandler(SequenceNotFoundException ex) {
        return ex.getMessage();
    }
}
