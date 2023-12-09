package dev.archimedes.repositories;

import dev.archimedes.entities.Greetings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GreetingRepository extends JpaRepository<Greetings, Integer> {
}
