package com.fastcamp.tddstarter.ch04.controller;

import com.fastcamp.tddstarter.ch04.domain.dto.PerformanceInfo;
import com.fastcamp.tddstarter.ch04.service.PerformanceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/performance")
@Slf4j
public class PerformanceController {
    private final PerformanceService performanceService;
//    private final PerformanceRepository performanceRepository;

    @GetMapping
    public ResponseEntity<List<PerformanceInfo>> getPerformanceAllList() {
        log.info("Requested ::: getInfo");
//        performanceRepository.findAll();
        return ResponseEntity.ok().body(performanceService.getAllPerformanceInfo());
    }
}
