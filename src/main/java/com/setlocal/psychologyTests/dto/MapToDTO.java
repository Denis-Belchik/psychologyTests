package com.setlocal.psychologyTests.dto;

public interface MapToDTO<T, K> {
    T convertToDto(K object);
}
