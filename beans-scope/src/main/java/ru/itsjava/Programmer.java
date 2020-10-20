package ru.itsjava;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Data
public class Programmer {
    private Notebook notebook;



}
