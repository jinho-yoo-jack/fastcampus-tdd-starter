package com.fastcamp.tddstarter.ch04;

import com.fastcamp.tddstarter.ch04_1.controller.TicketController;
import com.fastcamp.tddstarter.ch04_1.service.TicketingService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(TicketController.class)
public class MockitoExampleTest5 {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    TicketingService ticketingService;

    @DisplayName("WebMvcTest를 이용한 Controller Test")
    @Test
    public void ticketingControllerTest() throws Exception {
        // given
        String contents = "Test";

        mockMvc.perform(get("/ticket"))
                .andExpect(status().isOk())
                .andExpect(content().string(contents));
    }
}
