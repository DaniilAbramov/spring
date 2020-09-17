package ru.itsjava;

import lombok.Data;

@Data
public class PC implements Computer {
    @Override
    public String getBrand() {
        return getBrand();
    }
}
