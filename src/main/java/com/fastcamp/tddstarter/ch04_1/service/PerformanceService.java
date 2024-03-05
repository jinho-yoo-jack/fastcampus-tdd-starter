package com.fastcamp.tddstarter.ch04_1.service;

import com.fastcamp.tddstarter.ch04_1.domain.dto.PerformanceInfo;
import com.fastcamp.tddstarter.ch04_1.repository.PerformanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PerformanceService {
    private final PerformanceRepository performanceRepository;

    public List<PerformanceInfo> getAllPerformanceInfo() {
        List<PerformanceInfo> reservablePerformanceInfos = performanceRepository.findByIsReserve("enable")
                .stream()
                .map(PerformanceInfo::of)
                .toList();
        if (reservablePerformanceInfos.isEmpty()) {
            return setReadyToPerformanceInfo();
        }
        return reservablePerformanceInfos;
    }

    public String isEnableReserve(UUID performanceId){
        return performanceRepository.findById(performanceId)
                .orElseThrow()
                .getIsReserve();
    }

    private List<PerformanceInfo> setReadyToPerformanceInfo(){
        PerformanceInfo readyToPerformance = PerformanceInfo.builder()
                .performanceId(UUID.fromString("0000-0000-0000-0000"))
                .performanceName("공연 준비중")
                .performanceType("none")
                .isReserve("disable")
                .build();
        return Arrays.asList(new PerformanceInfo[]{readyToPerformance});
    }

    public String getTicketName() {
        return "TicketName";
    }

}
