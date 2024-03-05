package com.fastcamp.tddstarter.ch04;

import com.fastcamp.tddstarter.ch04_1.domain.dto.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class UserTest {
    @Test
    @DisplayName("이름으로 null 값 예외처리")
    void createUserUsingNullName() {
        assertThatThrownBy(() -> new User(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("공백 이름 예외처리")
    void createUserUsingNameVacuum() {
        assertThatThrownBy(() -> new User(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("10자를 초과하는 이름 예외처리")
    void createUserUsingLengthExceed10Name() {
        assertThatThrownBy(() -> new User("fastcamp-ttd-jinho"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("ValueSource를 이용한 User 생성 테스트")
    @ValueSource(strings = {" ", "fastcamp-ttd-jinho"})
    @NullAndEmptySource
    void createUserException(String text) {
        System.out.println("test argument  => " + text);
        assertThatThrownBy(() -> new User(text))
                .isInstanceOf(IllegalArgumentException.class);
    }


}
