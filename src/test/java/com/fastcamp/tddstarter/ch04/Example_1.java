package com.fastcamp.tddstarter.ch04;

import com.fastcamp.tddstarter.ch04_1.service.PerformanceService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class Example_1 {
    @Mock
    private PerformanceService performanceService;

    @Test
    public void testTicketService(){
        when(performanceService.getTicketName()).thenReturn("JINHO");
        assertEquals("JINHO1", performanceService.getTicketName(), "testTicketService Error");
    }

    @Test
    public void example1() {
        // 1. 모의 객체 생성 : Mock
        List<String> mockList = Mockito.mock(List.class);

        // 2. 메서드 호출 예상 동작 설정 : Stub
        when(mockList.size()).thenReturn(5);

        // 3. 메서드 호출 검증 : Verify
        Mockito.verify(mockList).add("item");
    }
}
