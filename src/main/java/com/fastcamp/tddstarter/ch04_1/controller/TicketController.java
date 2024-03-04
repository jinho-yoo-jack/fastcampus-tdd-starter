package com.fastcamp.tddstarter.ch04_1.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TicketController {

    @GetMapping
    public ResponseEntity<String> test(){
        return ResponseEntity.ok().body("Test");
    }
}
