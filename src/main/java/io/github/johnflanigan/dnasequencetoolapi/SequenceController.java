package io.github.johnflanigan.dnasequencetoolapi;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class SequenceController {

    private final SequenceRepository repository;

    public SequenceController(SequenceRepository repository) {
        this.repository = repository;
    }

    @CrossOrigin(origins = {"http://localhost:3000", "https://dna-sequence-tool.herokuapp.com"})
    @GetMapping("/sequences")
    List<Sequence> all() {
        return repository.findAll();
    }

    @CrossOrigin(origins = {"http://localhost:3000", "https://dna-sequence-tool.herokuapp.com"})
    @PostMapping("/sequences")
    Sequence newSequence(@RequestBody Sequence newSequence) {
        Optional<Sequence> sequenceOptional = repository.findFirstBySequence(newSequence.getSequence());

        if (sequenceOptional.isPresent()) {
            throw new DuplicateSequenceException(sequenceOptional.get());
        } else {
            return repository.save(newSequence);
        }
    }
}
