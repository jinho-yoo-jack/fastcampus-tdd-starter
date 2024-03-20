package com.fastcamp.tddstarter.ch04;

import com.fastcamp.tddstarter.ch04.domain.dto.Ticket;
import com.fastcamp.tddstarter.ch04.domain.entity.ticketing.Performance;
import com.fastcamp.tddstarter.ch04.repository.PerformanceRepository;
import com.fastcamp.tddstarter.ch04.service.TicketingService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;

@SpringBootTest
@Transactional
@ActiveProfiles("chaos-monkey")
public class SpringBootExampleTest2 {
    @Autowired
    private TicketingService ticketingService;

    @Autowired
    private PerformanceRepository performanceRepository;

    @DisplayName("SpringBootTest를 이용한 통합 테스트")
    @Test
    public void springBootExample1Test() {
        // 첫 번째 데이터 insert
        // Given
        Performance performanceInfo = performanceRepository.findByName("레베카");
        Ticket t = Ticket.builder()
            .performanceId(performanceInfo.getId())
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
    }
}
