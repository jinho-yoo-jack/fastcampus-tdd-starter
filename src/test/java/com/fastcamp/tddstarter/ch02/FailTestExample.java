package com.fastcamp.tddstarter.ch02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class FailTestExample {
    private String toUpperCase(String name) throws NullPointerException {
        if (name == null) throw new NullPointerException();
        return name.toUpperCase();
    }

    @Test
    void fail_test() {
        try {
            String name = toUpperCase(null);
            fail();
            assertEquals("JINHO", name);
        } catch (NullPointerException e) {
        }
    }

    @Test
    void throw_exception_test(){
        Assertions.assertThrows(NullPointerException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                toUpperCase(null);
            }
        });
    }
}
