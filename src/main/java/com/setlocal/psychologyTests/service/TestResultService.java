package com.setlocal.psychologyTests.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Scope("session")
public class TestResultService {

    private final Map<Integer, List<Integer>> repositoryResultTest = new LinkedHashMap<>();

    public void addResult(Integer position, Integer[] id) {
        List<Integer> list;
        if (id == null) {
            list = new ArrayList<>(List.of(0));
        } else {
            list = new ArrayList<>(List.of(id));
        }
        repositoryResultTest.put(position, list);
    }

    public Collection<List<Integer>> getResultQuest() {
        return repositoryResultTest.values();
    }

    public void resultClear() {
        repositoryResultTest.clear();
    }
}