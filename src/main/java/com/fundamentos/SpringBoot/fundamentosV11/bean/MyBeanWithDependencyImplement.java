package com.fundamentos.SpringBoot.fundamentosV11.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency{

    Log LOGGER = LogFactory.getLog(MyBeanWithDependencyImplement.class);

    //En esta implementacion estoy inyectando otra dependencia
    private MyOperation myOperation;

    public MyBeanWithDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        LOGGER.info("We have entered to the method print with dependency");
        int number =1;
        LOGGER.debug("The number sent from the app is "+number);
        System.out.println(myOperation.sum(number));
        System.out.println("Hi from the implementation of a bean with dependency");
    }
}
