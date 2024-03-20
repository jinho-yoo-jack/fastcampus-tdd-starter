package com.fastcamp.tddstarter.ch04;

import com.fastcamp.tddstarter.ch04_1.domain.dto.Ticket;
import com.fastcamp.tddstarter.ch04_1.domain.entity.ticketing.Performance;
import com.fastcamp.tddstarter.ch04_1.repository.PerformanceRepository;
import com.fastcamp.tddstarter.ch04_1.service.TicketingService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

@SpringBootTest
@Transactional
@ActiveProfiles("chaos-monkey")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE, connection = EmbeddedDatabaseConnection.NONE)
public class SpringBootTestExample2Tests {
    @Autowired
    private TicketingService ticketingService;
    @Autowired
    private PerformanceRepository performanceRepository;

    @TestFactory
    Stream<DynamicTest> refactorTest() {
        return Stream.of(
            dynamicTest("공연정보 저장", () -> {
                // Given
                Performance p = Performance.builder()
                    .name("FastCamp 실전에 바로 사용이 가능 테스트 개발방법론 배우기")
                    .type(0)
                    .isReserve("enable")
                    .round(1)
                    .start_date(Date.valueOf(LocalDate.now()))
                    .price(1000000000)
                    .policies(new ArrayList<>())
                    .build();
                // When
                performanceRepository.save(p);
                // Then
                Performance insertedTestPerformance = performanceRepository.findByName("FastCamp 실전에 바로 사용이 가능 테스트 개발방법론 배우기");
                assertNotNull(insertedTestPerformance);
                assertEquals(p.getName(), insertedTestPerformance.getName());
                assertEquals(p.getStart_date(), insertedTestPerformance.getStart_date());
            }), dynamicTest("공연 예약", () -> {
                // Given
                Performance insertedTestPerformance = performanceRepository.findByName("FastCamp 실전에 바로 사용이 가능 테스트 개발방법론 배우기");
                Ticket t = Ticket.builder()
                    .performanceId(insertedTestPerformance.getId())
                    .performanceName(insertedTestPerformance.getName())
                    .reservationName("유진호")
                    .reservationPhoneNumber("010-7777-7777")
                    .reservationStatus("reserve")
                    .round(1)
                    .line('A')
                    .seat(1)
                    .appliedPolicies(new ArrayList<>())
                    .build();
                // When
                Ticket reservedTicket = ticketingService.ticketing(t);
                // Then
                assertEquals(t, reservedTicket);
            })
        );
    }

    @Test
    void ticketingReserveIntegrationTest() {
        // Given
        Performance p = Performance.builder()
            .name("FastCamp 실전에 바로 사용이 가능 테스트 개발방법론 배우기")
            .type(0)
            .isReserve("enable")
            .round(1)
            .start_date(Date.valueOf(LocalDate.now()))
            .price(1000000000)
            .policies(new ArrayList<>())
            .build();
        // When
        performanceRepository.save(p);
        // Then
        Performance insertedTestPerformance = performanceRepository.findByName("FastCamp 실전에 바로 사용이 가능 테스트 개발방법론 배우기");
        assertNotNull(insertedTestPerformance);
        assertEquals(p.getName(), insertedTestPerformance.getName());
        assertEquals(p.getStart_date(), insertedTestPerformance.getStart_date());

        // Given
        Ticket t = Ticket.builder()
            .performanceId(insertedTestPerformance.getId())
            .performanceName(insertedTestPerformance.getName())
            .reservationName("유진호")
            .reservationPhoneNumber("010-7777-7777")
            .reservationStatus("reserve")
            .round(1)
            .line('A')
            .seat(1)
            .appliedPolicies(new ArrayList<>())
            .build();
        // When
        Ticket reservedTicket = ticketingService.ticketing(t);
        // Then
        assertEquals(t, reservedTicket);

    }
}
