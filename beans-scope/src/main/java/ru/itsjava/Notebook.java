package ru.itsjava;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("prototype")
@Component
public class Notebook {

    public Notebook(){
        System.out.println("ru.itsjava.Notebook");
    }

}
