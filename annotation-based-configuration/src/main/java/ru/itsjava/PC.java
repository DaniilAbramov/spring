package ru.itsjava;

import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service("myComp")
public class PC implements Computer {
    @Override
    public String getBrand() {
        return getBrand();
    }
}
