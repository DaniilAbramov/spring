package ru.itsjava;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Notebook implements Computer {
    private final String brand;

    @Override
    public String getBrand() {
        return brand;
    }
}
