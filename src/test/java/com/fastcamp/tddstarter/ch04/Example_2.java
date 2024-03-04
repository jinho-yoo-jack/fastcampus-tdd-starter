package com.fastcamp.tddstarter.ch04;

import com.fastcamp.tddstarter.ch04_1.repository.PerformanceRepository;
import com.fastcamp.tddstarter.ch04_1.service.PerformanceService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.Collections;

@ExtendWith(MockitoExtension.class)
public class Example_2 {
    @Mock
    private PerformanceRepository repository;
    private PerformanceService performanceService;

    @DisplayName("Mockito Example_1")
    @Test
    public void getAllPerformanceInfoTest() {
        PerformanceRepository repository = Mockito.mock(PerformanceRepository.class);
        performanceService = new PerformanceService(repository);

        Mockito.when(repository.findByIsReserve("enable"))
            .then(invocation -> {
                return Collections.emptyList();
            });

        performanceService.getAllPerformanceInfo();

        Mockito.verify(repository, Mockito.times(1)).findByIsReserve("enable");
    }

    @DisplayName("Mockito Example_2")
    @Test
    public void getAllPerformanceInfoMockAnnoTest() {

        Mockito.when(repository.findByIsReserve("enable"))
            .then(invocation -> {
                return Collections.emptyList();
            });

        performanceService.getAllPerformanceInfo();

        Mockito.verify(repository, Mockito.times(1)).findByIsReserve("enable");
    }

    @DisplayName("Mockito Not Stub Example")
    @Test
    public void notStub() {

        performanceService.getAllPerformanceInfo();

        Mockito.verify(repository, Mockito.times(1)).findByIsReserve("enable");
    }
}
