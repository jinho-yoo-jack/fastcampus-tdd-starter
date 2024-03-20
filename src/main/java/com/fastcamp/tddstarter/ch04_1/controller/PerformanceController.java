package com.fastcamp.tddstarter.ch04_1.controller;

import com.fastcamp.tddstarter.ch04_1.domain.dto.PerformanceInfo;
import com.fastcamp.tddstarter.ch04_1.domain.dto.Ticket;
import com.fastcamp.tddstarter.ch04_1.repository.PerformanceRepository;
import com.fastcamp.tddstarter.ch04_1.service.PerformanceService;
import com.fastcamp.tddstarter.ch04_1.service.TicketingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

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
