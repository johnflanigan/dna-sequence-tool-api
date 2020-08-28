package io.github.johnflanigan.dnasequencetool;

public class SequenceNotFoundException extends RuntimeException {

    SequenceNotFoundException(Long id) {
        super("Could not find sequence " + id);
    }
}
