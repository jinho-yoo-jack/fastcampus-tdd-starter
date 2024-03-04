package com.fastcamp.tddstarter.ch02;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class AssertExample {

    public AssertExample(){
        System.out.println("Constructor");
    }

    @BeforeAll
    static void setUpAll(){
        System.out.println("BeforeAll setUpAll");
    }

    @BeforeEach
    void setUp(){
        System.out.println("BeforeEach setUp");
    }

    @Test
    void basicTest(){
        System.out.println("Execute test");
        assertEquals(1,1);
    }

    @AfterAll
    static void endAll(){
        System.out.println("AfterAll endAll");
    }

    @AfterEach
    void end(){
        System.out.println("AfterEach end");
    }

    @Test
    void fail_test(){
        try{
            String name = toUpperCase("jinho");
            fail();
            assertEquals("JINHO", name);
        }catch (NullPointerException e){

        }
    }

    @Test
    void exception_execute_test(){
        assertThrows(NullPointerException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                toUpperCase(null);
            }
        });
    }

    private String toUpperCase(String name) throws NullPointerException{
        if(name == null) throw new NullPointerException();
        return name.toUpperCase();
    }
}
