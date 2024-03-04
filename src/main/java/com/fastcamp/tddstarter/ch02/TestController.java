package com.fastcamp.tddstarter.ch02;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
