package io.github.johnflanigan.dnasequencetoolapi;

public class DuplicateSequenceException extends RuntimeException {

    DuplicateSequenceException(Sequence sequence) {
        super(String.format("Sequence \"%s\" already exists under name \"%s\".", sequence.getSequence(), sequence.getName()));
    }
}
