package io.github.johnflanigan.dnasequencetoolapi;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SequenceRepository extends JpaRepository<Sequence, Long> {
}
