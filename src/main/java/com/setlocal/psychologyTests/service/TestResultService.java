package com.setlocal.psychologyTests.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface TestResultService {

    void addResult(Integer position, Integer[] id);

    Map<Integer, List<Integer>> getResultTest();

    Set<Integer> getNumberQuest();

    Collection<List<Integer>> getResultQuest();

}