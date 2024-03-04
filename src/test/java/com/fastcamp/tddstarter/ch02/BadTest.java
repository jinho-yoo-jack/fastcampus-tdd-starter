package com.fastcamp.tddstarter.ch02;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class BadTest {
    private FileOperator fileOperator = new FileOperator();
    private static File file;

    @Test
    void fileCreationTest(){
        try{
            File createFile = fileOperator.createFile();
            assertTrue(createFile.exists());
        }catch (IOException e){
            System.out.println(e.getMessage());
            fail();
        }
    }


    @Test
    void readFileTest(){
        try{
            long count = fileOperator.readFile(file);
            assertTrue(count > 0);
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
            fail();
        }
    }
}
