package com.fastcamp.tddstarter.ch02;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @GetMapping
    public ResponseEntity<String> test() throws InterruptedException {
        return new ResponseEntity<>(
                "nGrinder Testing",
                HttpStatus.OK);
    }
}
