package io.github.johnflanigan.dnasequencetoolapi;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class DuplicateSequenceAdvice {

    @ResponseBody
    @ExceptionHandler(DuplicateSequenceException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String duplicateSequenceHandler(DuplicateSequenceException ex) {
        return ex.getMessage();
    }
}
