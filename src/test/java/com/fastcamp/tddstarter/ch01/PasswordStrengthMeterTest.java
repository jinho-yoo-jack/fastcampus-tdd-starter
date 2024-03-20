package com.fastcamp.tddstarter.ch01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswordStrengthMeterTest {
    @Test
    void name(){

    }

    @Test
    void meetsAllCriteriaThenStrong(){
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result = meter.meter("ab12!@ABC"); // Expected: STRONG
        assertEquals(PasswordStrength.STRONG, result);
    }

    @Test
    void meetsOtherCriteriaExpectForLengthThenNormal(){
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result = meter.meter("ab12!AB"); // Expected: NORMAL
        assertEquals(PasswordStrength.NORMAL, result);
    }
}
