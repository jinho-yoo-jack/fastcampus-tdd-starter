package com.fastcamp.tddstarter.ch04;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

public class RepeatTestExample {
    @DisplayName("RepeatTest#1")
    @RepeatedTest(value = 10, name = RepeatedTest.LONG_DISPLAY_NAME)
    void repeatTest(RepetitionInfo repetitionInfo) {
        System.out.println("repetitionInfo = " + repetitionInfo.getCurrentRepetition() + "/" +
            repetitionInfo.getTotalRepetitions());
    }
}
