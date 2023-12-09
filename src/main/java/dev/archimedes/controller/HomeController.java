package dev.archimedes.controller;

import dev.archimedes.entities.Greetings;
import dev.archimedes.repositories.GreetingRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/add")
    public ResponseEntity<?> saveGreet(@RequestBody Greetings greetings){
        try {
            greetingRepository.save(greetings);
            return new ResponseEntity<>("Greeting saved", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
