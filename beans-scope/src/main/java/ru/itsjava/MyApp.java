package ru.itsjava;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class MyApp {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(MyApp.class);

        Programmer programmer = context.getBean(Programmer.class);
        System.out.println("programmer = " + programmer);

//        Programmer programmer2 = context.getBean(Programmer.class);
//        System.out.println("programmer2 = " + programmer2);

        Notebook notebook = context.getBean(Notebook.class);
        System.out.println("notebook = " + notebook);
        Notebook notebook2 = context.getBean(Notebook.class);
        System.out.println("notebook2 = " + notebook2);
    }
}
