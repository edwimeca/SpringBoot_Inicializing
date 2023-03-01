package com.fundamentos.SpringBoot.fundamentosV11.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentTwoImplement implements ComponentDependency{
    @Override
    public void sayHi() {
        System.out.println("Hi, from my component two");
    }
}
