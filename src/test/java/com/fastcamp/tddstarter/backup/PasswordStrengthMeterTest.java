package com.fastcamp.tddstarter.backup;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import java.time.LocalDate;

public class PasswordStrengthMeterTest {
    @Test
    void meetsAllCriteria_Then_Strong() {
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result = meter.meter("ab12!@AB");
        assertEquals(PasswordStrength.STRONG, result);
    }

    @Test
    void meetsOtherCriteria_expect_for_Length_Then_Normal() {
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result = meter.meter("ab12!@A");
        assertEquals(PasswordStrength.NORMAL, result);
    }

    @Test
    void assertEquals_test(){
        LocalDate dateTime1 = LocalDate.now(); // yyyy-mm-dd
        LocalDate dateTime2 = LocalDate.now(); // yyyy-mm-dd
        System.out.println(dateTime2);
        assertEquals(dateTime1, dateTime2);
    }

}
