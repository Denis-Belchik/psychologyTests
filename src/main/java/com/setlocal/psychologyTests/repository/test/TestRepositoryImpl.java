package com.setlocal.psychologyTests.repository.test;

import com.setlocal.psychologyTests.model.Test;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;

@Primary
public interface TestRepositoryImpl extends TestRepository, JpaRepository<Test, Integer> {
}
