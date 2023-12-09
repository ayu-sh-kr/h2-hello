package dev.archimedes.controller;

import dev.archimedes.entities.Greetings;
import dev.archimedes.repositories.GreetingRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {

    private final GreetingRepository greetingRepository;

    public HomeController(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @GetMapping("/hello")
    public List<Greetings> getGreet(){
        return greetingRepository.findAll();
    }
}
