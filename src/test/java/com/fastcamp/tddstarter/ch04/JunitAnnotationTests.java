package com.fastcamp.tddstarter.ch04;

import com.fastcamp.tddstarter.ch04.domain.dto.User;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest; import org.junit.jupiter.params.provider.CsvSource; import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class JunitAnnotationTests {

    @TestFactory
    List<DynamicNode> testFactoryExampleTest(){
        int size = 10;
        List<DynamicNode> result = new ArrayList<>();
        for(int i = 0; i < size; i ++){
            int finalI = i;
            result.add(dynamicTest("Test CaseName" + i, () -> System.out.println("Dynamic Test #" + finalI)));

        }
        return result;
    }

    @RepeatedTest(value = 10)
    void repeatedTestExample(RepetitionInfo info){
        System.out.println("repetitionInfo = " + info.getCurrentRepetition() + "/" + info.getTotalRepetitions());

    }

    @ParameterizedTest
    @CsvSource(value = {"1||2", "2||4", "3||6", "4||8"}, delimiterString = "||")
    void csvSourceExampleTest(int input, int expected){
        assertEquals(expected, input * 2);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @NullAndEmptySource
    void parameterizedTestExample(String userName){
        System.out.println("userName => "+ userName);
        assertThatThrownBy(() -> new User(userName))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("User의 이름이 Null이면 예외발생 한다.")
    void userNameValidatorTests(){
        String[] names = new String[]{"", " ", null};
        for(int i = 0; i < names.length; i++){
            int finalI = i;
            assertThatThrownBy(() -> new User(names[finalI]))
                .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    @DisplayName("User의 이름이 Null이면 예외발생 한다.")
    void userNameNullThenException(){
        assertThatThrownBy(() -> new User(null))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("User의 이름은 공백이면 예외처리가 되어야 한다.")
    void userNameIsBlankThenException(){
        assertThatThrownBy(() -> new User(""))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
