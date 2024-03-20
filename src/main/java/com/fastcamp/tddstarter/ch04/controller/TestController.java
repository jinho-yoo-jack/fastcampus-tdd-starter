package com.fastcamp.tddstarter.ch04.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {
    @GetMapping
    public ResponseEntity<String> test() throws InterruptedException {
//        log.info("Requested");
        return new ResponseEntity<>(
                "nGrinder and JMeter Testing",
                HttpStatus.OK);
    }
}
