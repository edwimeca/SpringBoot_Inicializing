package com.fundamentos.SpringBoot.fundamentosV11.bean;

public class MyBeanImplement implements MyBean{

    @Override
    public void print() {
        System.out.println("Hi, from my Bean's own implementation ");

    }
}
