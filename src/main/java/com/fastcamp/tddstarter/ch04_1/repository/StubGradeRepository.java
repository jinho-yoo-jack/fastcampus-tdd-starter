package com.fastcamp.tddstarter.ch04_1.repository;

import com.fastcamp.tddstarter.ch04_1.domain.dto.test_doubles.Student;

import java.util.HashMap;
import java.util.Map;

public class StubGradeRepository {
    public Map<String, Integer> findByName(String name){
        Map<String, Integer> result = new HashMap<String, Integer>();
        result.put("OOP", 8);
        result.put("FP", 6);
        result.put("DB", 10);
        return result;
    }
}
