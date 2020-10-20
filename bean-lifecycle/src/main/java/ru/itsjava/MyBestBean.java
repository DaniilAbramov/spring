package ru.itsjava;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MyBestBean implements InitializingBean, BeanNameAware, ApplicationContextAware, BeanFactoryAware, DisposableBean {


    public MyBestBean() {
        System.out.println("2. constructor");
    }

    @PostConstruct
    public void postConstr() {
        System.out.println("PostConstruct");

    }

    @PostConstruct
    public void preDestroy() {
        System.out.println("PreDestroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("3. BeanNameAware: setBeanName");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("5. ApplicationContextAware :setApplicationContext");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("4. BeanFactoryAware: setBeanFactory");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean: destroy");
    }
}
