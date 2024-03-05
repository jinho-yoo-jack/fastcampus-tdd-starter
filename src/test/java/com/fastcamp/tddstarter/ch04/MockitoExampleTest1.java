package com.fastcamp.tddstarter.ch04;

import com.fastcamp.tddstarter.ch04_1.domain.dto.Ticket;
import com.fastcamp.tddstarter.ch04_1.repository.ReservationRepository;
import com.fastcamp.tddstarter.ch04_1.service.PerformanceService;
import com.fastcamp.tddstarter.ch04_1.service.TicketingService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class MockitoExampleTest1 {
    private TicketingService ticketingService;

    @DisplayName("Mockito를 이용한 ticketing 메서드 테스트 코드 Example#1")
    @Test
    public void MockitoMockInstanceTest() {
        PerformanceService performanceService = Mockito.mock(PerformanceService.class);
        ReservationRepository reservationRepository = Mockito.mock(ReservationRepository.class);

        // Mock 객체를 이용한 의존성 문제 해결
        ticketingService = new TicketingService(performanceService, reservationRepository);
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

        // 호출이 되는 것을 기대하는 메서드에 대한 기대 행위를 명시
        Mockito.when(performanceService.isEnableReserve(any()))
                .then(invocationOnMock -> {
                    System.out.println("Execute Stub logic");
                    return "enable";
                });
        ticketingService.ticketing(t);

        Mockito.verify(performanceService, Mockito.times(1)).isEnableReserve(any());
        Mockito.verify(reservationRepository, Mockito.times(1)).save(any());
    }
}
