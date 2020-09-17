package ru.itsjava;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Data
//@RequiredArgsConstructor
@Service("myComp2")
public class Notebook implements Computer {
    private final String brand;

    @Value("#{ T(java.lang.Math).random() * 1000}")
    private int serialNumber;


    @Autowired
    public Notebook(@Value("${brand}") String brand) {
        this.brand = brand;
    }
}
