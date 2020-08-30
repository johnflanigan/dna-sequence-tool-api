package io.github.johnflanigan.dnasequencetoolapi;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SequenceRepository extends JpaRepository<Sequence, Long> {

    Optional<Sequence> findFirstBySequence(String sequence);
}
