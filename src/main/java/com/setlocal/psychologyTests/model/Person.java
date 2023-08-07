package com.setlocal.psychologyTests.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Person {
    @NotEmpty(message = "Имя не должно быть пустым")
    @Size(min = 2, max = 20, message = "Логин от 2 до 20 символов")
    private String username;
    private String password;
    private byte enabled;
}
