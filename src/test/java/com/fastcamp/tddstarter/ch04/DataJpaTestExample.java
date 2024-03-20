package com.fastcamp.tddstarter.ch04;

import com.fastcamp.tddstarter.ch04.domain.entity.ticketing.Performance;
import com.fastcamp.tddstarter.ch04.repository.PerformanceRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE, connection = EmbeddedDatabaseConnection.NONE)
@ActiveProfiles("chaos-monkey")
public class DataJpaTestExample {
    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private PerformanceRepository performanceRepository;

    @Test
    void PerformanceSaveTest(){
        Performance p = Performance.builder()
            .name("Test")
            .type(0)
            .isReserve("disable")
            .round(1)
            .start_date(Date.valueOf(LocalDate.now()))
            .price(10000)
            .policies(new ArrayList<>())
            .build();
        testEntityManager.persist(p);
        Performance insertedPerformance = performanceRepository.findById(p.getId()).orElse(null);

        assertNotNull(insertedPerformance);
        assertEquals(insertedPerformance.getId(), p.getId());
    }
}
