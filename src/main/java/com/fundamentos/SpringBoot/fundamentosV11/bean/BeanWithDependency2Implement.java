package com.fundamentos.SpringBoot.fundamentosV11.bean;

public class BeanWithDependency2Implement implements BeanWithDependency2{

    private MyOperation myOperation;

    public BeanWithDependency2Implement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void print() {
        System.out.println("Printing dependency 2!");
        int num2 = 3;
        System.out.println("Printing Dependency MyOperation : "+myOperation.sum(num2));

    }
}
