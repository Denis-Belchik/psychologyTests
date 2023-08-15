package com.setlocal.psychologyTests.dto;

public interface MapToEmpty<T, K> {
    T convertToEmpty(K object);
}
