package ru.itsjava;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class MyApp {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(MyApp.class);
        System.out.println("context.getBean(MyBestBean.class) = " + context.getBean(MyBestBean.class));
        context.close();


    }
}
