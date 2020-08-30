package io.github.johnflanigan.dnasequencetoolapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SequenceController {

    private static final Logger log = LoggerFactory.getLogger(SequenceController.class);

    private final SequenceRepository repository;

    public SequenceController(SequenceRepository repository) {
        this.repository = repository;
    }

    @CrossOrigin(origins = {"http://localhost:3000", "https://dna-sequence-tool.herokuapp.com/"})
    @GetMapping("/sequences")
    List<Sequence> all() {
        return repository.findAll();
    }

    @CrossOrigin(origins = {"http://localhost:3000", "https://dna-sequence-tool.herokuapp.com/"})
    @PostMapping("/sequences")
    Sequence newSequence(@RequestBody Sequence newSequence) {
        Optional<Sequence> sequenceOptional = repository.findFirstBySequence(newSequence.getSequence());

        if (sequenceOptional.isPresent()) {
            throw new DuplicateSequenceException(sequenceOptional.get());
        } else {
            return repository.save(newSequence);
        }
    }

    @GetMapping("/sequences/{id}")
    Sequence one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new SequenceNotFoundException(id));
    }

    @PutMapping("/sequences/{id}")
    Sequence replaceSequence(@RequestBody Sequence newSequence, @PathVariable Long id) {

        return repository.findById(id)
                .map(sequence -> {
                    sequence.setName(newSequence.getName());
                    sequence.setDescription(newSequence.getDescription());
                    sequence.setSequence(newSequence.getSequence());
                    return repository.save(sequence);
                })
                .orElseGet(() -> {
                    newSequence.setId(id);
                    return repository.save(newSequence);
                });
    }

    @DeleteMapping("/sequences/{id}")
    void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
