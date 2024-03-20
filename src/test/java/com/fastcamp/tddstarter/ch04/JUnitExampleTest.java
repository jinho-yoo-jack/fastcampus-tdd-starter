package com.fastcamp.tddstarter.ch04;

import com.fastcamp.tddstarter.ch04_1.domain.dto.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static java.lang.Thread.sleep;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JUnitExampleTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    void parameterizedTestExample2(int i){
        System.out.println(i);
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "fastcamp-ttd-jinho"})
    @NullAndEmptySource
    void createUserException(String text) {
        System.out.println("test argument  => " + text);
        assertThatThrownBy(() -> new User(text))
            .isInstanceOf(IllegalArgumentException.class);
    }
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
    @CsvSource(value = {"1,2", "2, 4","3, 6"})
    void csvSourceTest(int input, int expected){
        System.out.println(input + " * 2 = " + expected);
        assertEquals(expected, input * 2);
    }

    @Test
    @Timeout(3) // 시간 단위: Second(세컨드)
    void timeoutExampleTest() throws InterruptedException{
        sleep(4000); // 시간 단위: Millisecond(밀리세컨드)
    }

    @Test
    void selfValidatingExample1Test(){
        int expectedValue = 1;
        int actualValue = 2;
        System.out.println("expected Value => " + expectedValue);
        System.out.println("actual Value => " + actualValue);
    }

    @Test
    void selfValidatingExample2Test(){
        int expectedValue = 1;
        int actualValue = 2;
        assertEquals(expectedValue, actualValue);
    }


}
