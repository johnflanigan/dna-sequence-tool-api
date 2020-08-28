package io.github.johnflanigan.dnasequencetoolapi;

public class SequenceNotFoundException extends RuntimeException {

    SequenceNotFoundException(Long id) {
        super("Could not find sequence " + id);
    }
}
