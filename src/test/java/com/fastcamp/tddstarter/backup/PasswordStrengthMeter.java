package com.fastcamp.tddstarter.backup;

public class PasswordStrengthMeter {
    public PasswordStrength meter(String password){
        if(password.length() < 8) return PasswordStrength.NORMAL;
        return PasswordStrength.STRONG;
    }
}
