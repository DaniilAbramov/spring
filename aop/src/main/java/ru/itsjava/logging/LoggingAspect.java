package ru.itsjava.logging;

import lombok.SneakyThrows;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Before("execution(* ru.itsjava.dao.FilmDaoSimple.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Before");
        System.out.println("joinPoint.getThis().getClass() = " + joinPoint.getThis().getClass());

        System.out.println("joinPoint.getTarget().getClass() = " + joinPoint.getTarget().getClass());
    }

    @After("execution(* ru.itsjava.dao.FilmDaoSimple.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("After");
    }

    @SneakyThrows
    @Around("execution(* ru.itsjava.services.FilmService.*(..))")
    public Object logAround(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println("Before" + proceedingJoinPoint.getTarget().getClass());


        Object res = proceedingJoinPoint.proceed();

        System.out.println("After" + proceedingJoinPoint.getTarget().getClass());
        return res;
    }
}

