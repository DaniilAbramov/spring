package ru.itsjava;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:application.properties")
@ComponentScan
public class ItCompany {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ItCompany.class);

        Computer computer = context.getBean("myComp", Computer.class);

        System.out.println("computer = " + computer);

        Programmer programmer = context.getBean(Programmer.class);

        System.out.println("programmer = " + programmer);

        Notebook notebook = context.getBean("myComp2", Notebook.class);
        System.out.println("notebook.getSerialNumber() = " + notebook.getSerialNumber());

    }
}
