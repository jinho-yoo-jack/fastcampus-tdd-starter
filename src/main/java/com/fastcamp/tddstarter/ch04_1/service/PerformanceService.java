package com.fastcamp.tddstarter.ch04_1.service;

import com.fastcamp.tddstarter.ch04_1.domain.dto.PerformanceInfo;
import com.fastcamp.tddstarter.ch04_1.repository.PerformanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PerformanceService {
    private final PerformanceRepository performanceRepository;

    public List<PerformanceInfo> getAllPerformanceInfo(){
//        return performanceRepository.findByIsReserve("enable")
//            .stream()
//            .map(PerformanceInfo::of)
//            .toList();
        return Collections.emptyList();
    }

    public String getTicketName(){
        return "TicketName";
    }

    public int calculatePrice(){
        return 10000;
    }
}
