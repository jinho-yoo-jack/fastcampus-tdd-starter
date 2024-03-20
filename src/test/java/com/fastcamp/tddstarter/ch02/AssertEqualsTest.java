package com.fastcamp.tddstarter.ch02;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;


public class AssertEqualsTest {
    private int sum(int x, int y) {
        return x + y;
    }

    @Test
    void assertEqualsExample1Test() {
        int actual = 2;
        int expected = 2;
        assertEquals(expected, actual);
    }

    private String toUpperCase(String name) throws NullPointerException {
        if (name == null) throw new NoSuchMethodError();
        return name.toUpperCase();
    }

    @Test
    void toUpperCaseThrowNullPointExceptionTrueTest(){
        assertThrows(NullPointerException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                toUpperCase(null);
            }
        });
    }

    @Test
    void toUpperCaseThrowNullPointerExceptionTest() {
        try {
            String name = toUpperCase(null);
            fail();
            assertEquals("JINHO", name);
        } catch (NullPointerException e) {


        }

    }
}
