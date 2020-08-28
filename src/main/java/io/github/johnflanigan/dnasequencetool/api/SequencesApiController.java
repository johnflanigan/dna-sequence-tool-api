package io.github.johnflanigan.dnasequencetool.api;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.johnflanigan.dnasequencetool.model.Sequences;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

import java.io.IOException;

@Controller
public class SequencesApiController implements SequencesApi {

    private static final Logger log = LoggerFactory.getLogger(SequencesApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    public SequencesApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> createSequences() {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Sequences> listSequences() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Sequences>(objectMapper.readValue("[ {\n  \"sequence\" : \"sequence\",\n  \"name\" : \"name\",\n  \"description\" : \"description\",\n  \"id\" : 0\n}, {\n  \"sequence\" : \"sequence\",\n  \"name\" : \"name\",\n  \"description\" : \"description\",\n  \"id\" : 0\n} ]", Sequences.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Sequences>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Sequences>(HttpStatus.NOT_IMPLEMENTED);
    }
}
