package dev.archimedes;

import dev.archimedes.entities.Greetings;
import dev.archimedes.repositories.GreetingRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class H2HelloApplication implements CommandLineRunner {

    private final GreetingRepository greetingRepository;

    public H2HelloApplication(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Greetings> greetings = List.of(
                new Greetings("Hello", "This is message"),
                new Greetings("Wish", "This is wish message")
        );
        greetingRepository.saveAll(greetings);
    }

    public static void main(String[] args) {
        SpringApplication.run(H2HelloApplication.class, args);
    }

}
