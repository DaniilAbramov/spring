package ru.itsjava;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Programmer {
    private final Computer computer;

    public String HelloWorld() {
        return computer.getBrand() + "Hello world";
    }
}
