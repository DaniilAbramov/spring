package ru.itsjava;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("ru.itsjava.configuration")
public class ItCompany {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ItCompany.class);

        Computer computer = context.getBean("myComp", Computer.class);

        System.out.println("notebook = " + computer);

        Programmer programmer = context.getBean(Programmer.class);

        System.out.println("programmer = " + programmer);

    }
}
