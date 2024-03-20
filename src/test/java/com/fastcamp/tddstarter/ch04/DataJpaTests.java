package com.fastcamp.tddstarter.ch04;

import com.fastcamp.tddstarter.ch04.domain.entity.ticketing.Performance;
import com.fastcamp.tddstarter.ch04.repository.PerformanceRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE, connection = EmbeddedDatabaseConnection.NONE)
public class DataJpaTests {
    @Autowired
    private PerformanceRepository performanceRepository;

    @Autowired
    TestEntityManager testEntityManager;

    @Test
    void newPerformanceSaveTest(){
        Performance newPerformance = Performance.builder()
            .name("SpringBoot 기초 수업")
            .type(0)
            .isReserve("enable")
            .round(1)
            .start_date(Date.valueOf(LocalDate.now()))
            .price(50000)
            .policies(new ArrayList<>())
            .build();

        testEntityManager.persist(newPerformance);
        Performance savedPerformance = performanceRepository.findByName("SpringBoot 기초 수업");
        assertNotNull(savedPerformance);
        assertEquals(newPerformance.getId(), savedPerformance.getId());

    }


}
