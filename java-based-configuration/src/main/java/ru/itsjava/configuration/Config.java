package ru.itsjava.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.itsjava.Computer;
import ru.itsjava.Notebook;
import ru.itsjava.PC;
import ru.itsjava.Programmer;

@Configuration
public class Config {

    @Bean
    public Computer myComp() {
        return new PC();
    }
    @Bean
    public Computer myComp2() {
        return new Notebook("Asus");
    }

    @Bean
    public Programmer myProgrammer(@Qualifier("myComp2") Computer computer) {
        return new Programmer(computer);
    }
}
