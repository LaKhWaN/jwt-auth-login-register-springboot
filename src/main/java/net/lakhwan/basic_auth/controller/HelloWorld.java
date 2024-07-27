package net.lakhwan.basic_auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class HelloWorld {

    @GetMapping("/helloworld")
    public ResponseEntity<String> helloWorld(){
        return ResponseEntity.ok("Hello World");
    }
}
