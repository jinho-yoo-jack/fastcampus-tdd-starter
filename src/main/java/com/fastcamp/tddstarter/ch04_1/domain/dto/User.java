package com.fastcamp.tddstarter.ch04_1.domain.dto;

public class User {
    private final String name;

    public User(String name) {
        validateName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validateName(String name) {
        validateNotNull(name);
        validateLength(name);
    }

    private void validateNotNull(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름은 공백일 수 없습니다.");
        }
    }

    private void validateLength(String name) {
        if (name.length() > 10) {
            throw new IllegalArgumentException("이름은 10자 이하여야 합니다.");
        }
    }
}