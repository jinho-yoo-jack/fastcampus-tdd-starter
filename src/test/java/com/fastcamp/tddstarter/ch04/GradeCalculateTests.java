package com.fastcamp.tddstarter.ch04;

import com.fastcamp.tddstarter.ch04_1.domain.dto.test_doubles.Student;
import com.fastcamp.tddstarter.ch04_1.repository.StubGradeRepository;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GradeCalculateTests {
    private StubGradeRepository stubGradeRepository;

    public GradeCalculateTests(){
        stubGradeRepository = new StubGradeRepository();
    }

    private Map<String, Integer> grades(Student s){
        return stubGradeRepository.findByName(s.getName());
    }

    @Test
    void averageGradesTests(){
        Student s = new Student("jinho", 0, new HashMap<>(), 'M', "01012341234");
        Map<String, Integer> result = grades(s);
        int total = 0;
        int expected = 10;
        for(String grade : result.keySet()){
            total += result.get(grade);
        }
        assertEquals(expected, total/result.size());
    }


}
