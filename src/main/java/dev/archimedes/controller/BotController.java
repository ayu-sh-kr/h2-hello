package dev.archimedes.controller;

import dev.archimedes.entities.CustomerDetails;
import dev.archimedes.repositories.CustomerDetailsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/bot")
@CrossOrigin("*")
public class BotController {

    private final CustomerDetailsRepository customerDetailsRepository;

    public BotController(CustomerDetailsRepository customerDetailsRepository) {
        this.customerDetailsRepository = customerDetailsRepository;
    }

    @PostMapping("/details")
    public ResponseEntity<?> saveDetails(@RequestBody CustomerDetails customerDetails){
        if(null != customerDetails && !customerDetailsRepository.existsByEmail(customerDetails.getEmail())){
            customerDetailsRepository.save(customerDetails);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/get")
    public ResponseEntity<?> getDetails(){
        return new ResponseEntity<>(customerDetailsRepository.findAll(), HttpStatus.OK);
    }
}
