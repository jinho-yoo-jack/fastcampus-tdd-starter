package com.fastcamp.tddstarter.ch04;

import com.fastcamp.tddstarter.ch04_1.domain.dto.PerformanceInfo;
import com.fastcamp.tddstarter.ch04_1.repository.PerformanceRepository;
import com.fastcamp.tddstarter.ch04_1.service.PerformanceService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.util.Collections;
import java.util.List;

@SpringBootTest
public class Example_3 {
    @SpyBean
    private PerformanceRepository repository;

    @Autowired
    private PerformanceService performanceService;

    @DisplayName("Mockito Not Stub Example")
    @Test
    public void notStub() {

        List<PerformanceInfo> infos = performanceService.getAllPerformanceInfo();

        Mockito.verify(repository, Mockito.times(1)).findByIsReserve("enable");
    }
}
