package dev.archimedes.repositories;

import dev.archimedes.entities.CustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDetailsRepository extends JpaRepository<CustomerDetails, Integer> {

    boolean existsByEmail(String email);
}
