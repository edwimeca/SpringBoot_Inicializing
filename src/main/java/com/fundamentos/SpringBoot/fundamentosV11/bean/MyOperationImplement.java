package com.fundamentos.SpringBoot.fundamentosV11.bean;

import org.springframework.stereotype.Component;


public class MyOperationImplement implements MyOperation{
    @Override
    public int sum(int number) {
        return number+1;
    }
}
