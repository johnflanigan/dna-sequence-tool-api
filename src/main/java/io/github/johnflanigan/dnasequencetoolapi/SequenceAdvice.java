package io.github.johnflanigan.dnasequencetoolapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class SequenceAdvice {

	@ResponseBody
	@ExceptionHandler(DuplicateSequenceException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	Map<String, String> duplicateSequenceHandler(DuplicateSequenceException ex) {
		Map<String, String> map = new HashMap<>();
		map.put("errorMessage", ex.getMessage());
		return map;
	}

	@ResponseBody
	@ExceptionHandler(SequenceNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	Map<String, String> sequenceNotFoundHandler(SequenceNotFoundException ex) {
		Map<String, String> map = new HashMap<>();
		map.put("errorMessage", ex.getMessage());
		return map;
	}
}
