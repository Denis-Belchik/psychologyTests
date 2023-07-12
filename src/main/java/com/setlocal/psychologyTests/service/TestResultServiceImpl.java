package com.setlocal.psychologyTests.service;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TestResultServiceImpl implements TestResultService {

    private final Map<Integer, List<Integer>> repositoryResultTest = new LinkedHashMap<>();

    @Override
    public void addResult(Integer position, Integer[] id) {
        List<Integer> list;
        if (id == null) {
            list = new ArrayList<>(List.of(0));
        } else {
            list = new ArrayList<>(List.of(id));
        }
        repositoryResultTest.put(position, list);
    }

    @Override
    public Map<Integer, List<Integer>> getResultTest() {
        return repositoryResultTest;
    }

    @Override
    public Set<Integer> getNumberQuest() {
        return repositoryResultTest.keySet();
    }

    @Override
    public Collection<List<Integer>> getResultQuest() {
        return repositoryResultTest.values();
    }
}