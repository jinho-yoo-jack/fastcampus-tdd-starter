package com.fastcamp.tddstarter.ch01;

public class PasswordStrengthMeter {
    public PasswordStrength meter(String password){
        if(password.length() < 8) return PasswordStrength.NORMAL;
        return PasswordStrength.STRONG;
    }
}
