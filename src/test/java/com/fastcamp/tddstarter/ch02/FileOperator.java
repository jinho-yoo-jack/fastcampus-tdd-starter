package com.fastcamp.tddstarter.ch02;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FileOperator {

    public File createFile() throws IOException {
        // Creating an object of a file
        File file = new File("src/test/resources/FileOperationExample.txt");
        if (file.createNewFile()) {
            System.out.println("File " + file.getName() + " is created successfully.");
        }
        return file;
    }

    public long readFile(File file) throws FileNotFoundException {
//        File file = new File("src/test/resources/FileOperationExample.txt");
        Scanner dataReader = new Scanner(file);
        long count = 0;
        while (dataReader.hasNextLine()) {
            String fileData = dataReader.nextLine();
            count++;
        }
        dataReader.close();
        return count;
    }
}
