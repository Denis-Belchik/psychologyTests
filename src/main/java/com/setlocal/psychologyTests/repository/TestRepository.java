package com.setlocal.psychologyTests.repository;

import com.setlocal.psychologyTests.model.Test;

import java.util.List;
import java.util.Optional;

public interface TestRepository {

    Optional<Test> findById(Integer id);

    List<Test> findAll();

}
