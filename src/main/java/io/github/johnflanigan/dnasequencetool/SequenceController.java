package io.github.johnflanigan.dnasequencetool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SequenceController {

    private static final Logger log = LoggerFactory.getLogger(SequenceController.class);

    private final SequenceRepository repository;

    public SequenceController(SequenceRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/sequences")
    List<Sequence> all() {
        return repository.findAll();
    }

    @PostMapping("/sequences")
    Sequence newSequence(@RequestBody Sequence newSequence) {
        return repository.save(newSequence);
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
