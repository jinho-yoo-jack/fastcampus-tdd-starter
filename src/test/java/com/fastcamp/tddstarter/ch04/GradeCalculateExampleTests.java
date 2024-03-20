package com.fastcamp.tddstarter.ch04;

import com.fastcamp.tddstarter.ch04.domain.dto.test_doubles.Student;
import com.fastcamp.tddstarter.ch04.repository.StubGradeRepository;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GradeCalculateExampleTests {
    private StubGradeRepository stubGradeRepository;

    public GradeCalculateExampleTests() {
        stubGradeRepository = new StubGradeRepository();
    }

    private Map<String, Integer> grades(Student s) {
        return stubGradeRepository.findByName(s.getName());
    }

    @Test
    void averageGradesTest() {
        Student s = new Student("fastcamp", 0, new HashMap<>(), 'M', "01012341234");
        Map<String, Integer> result = grades(s);
        int gradesTotal = 0;
        int expected = 8;
        for (String grade : result.keySet()) {
            gradesTotal += result.get(grade);
        }
        assertEquals(expected, gradesTotal / result.size());
    }
}
