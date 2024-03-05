package com.fastcamp.tddstarter.ch04;

import com.fastcamp.tddstarter.ch04_1.domain.dto.Ticket;
import com.fastcamp.tddstarter.ch04_1.service.TicketingService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
public class SpringBootExampleTest1 {
    @Autowired
    private TicketingService ticketingService;

    @DisplayName("Mockito를 이용한 ticketing 메서드 테스트 코드 Example#1")
    @Test
    public void springBootExample1Test() {

        // Given
        Ticket t = Ticket.builder()
                .performanceId(UUID.fromString("adc45fd5-dab9-11ee-9743-0242ac130002"))
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
