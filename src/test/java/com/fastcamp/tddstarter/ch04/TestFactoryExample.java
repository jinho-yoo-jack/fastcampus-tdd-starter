package com.fastcamp.tddstarter.ch04;

import com.fastcamp.tddstarter.ch04.domain.dto.Ticket;
import com.fastcamp.tddstarter.ch04.domain.entity.ticketing.Performance;
import com.fastcamp.tddstarter.ch04.repository.PerformanceRepository;
import com.fastcamp.tddstarter.ch04.service.TicketingService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.DynamicTest.dynamicTest;

@SpringBootTest
@Transactional
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY, connection = EmbeddedDatabaseConnection.H2)
@ActiveProfiles("test")
public class TestFactoryExample {
    @Autowired
    private PerformanceRepository performanceRepository;
    @Autowired
    private TicketingService ticketingService;

    @TestFactory
    List<DynamicNode> testFactory() {
        return List.of(
            dynamicTest("Test1", () -> System.out.println("Dynamic Test1!!")),
            dynamicTest("Test2", () -> System.out.println("Dynamic Test2!!"))
        );
    }

    @TestFactory
    Stream<DynamicTest> 통합_테스트_예시1() {
        return Stream.of(
            dynamicTest("공연 정보 저장 테스트", () -> {
                Performance p = Performance.builder()
                    .name("레베카")
                    .type(0)
                    .isReserve("enable")
                    .round(1)
                    .start_date(Date.valueOf(LocalDate.now()))
                    .price(10000)
                    .policies(new ArrayList<>())
                    .build();

                // When
                performanceRepository.save(p);
                Performance insertedPerformance = performanceRepository.findByName("레베카");

                // Then
                Assertions.assertNotNull(insertedPerformance);
                Assertions.assertEquals(p.getName(), insertedPerformance.getName());
                Assertions.assertEquals(p.getStart_date(), insertedPerformance.getStart_date());
            }),
            dynamicTest("공연 예약 테스트", () -> {
                // 두 번째 데이터 조회
                // Given
                Performance insertedPerformance = performanceRepository.findByName("레베카");
                Ticket t = Ticket.builder()
                    .performanceId(insertedPerformance.getId())
                    .performanceName("레베카")
                    .reservationName("유진호")
                    .reservationPhoneNumber("010-1234-1234")
                    .reservationStatus("reserve")
                    .round(1)
                    .line('A')
                    .seat(1)
                    .appliedPolicies(Arrays.asList(new String[]{"telecome"}))
                    .build();

                // When
                Ticket reservedTicket = ticketingService.ticketing(t);

                // Then
                Assertions.assertEquals(t, reservedTicket);
            })
        );
    }
}
