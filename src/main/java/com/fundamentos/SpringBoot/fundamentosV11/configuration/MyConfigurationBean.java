package com.fundamentos.SpringBoot.fundamentosV11.configuration;

import com.fundamentos.SpringBoot.fundamentosV11.bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Se le realiza la anotacion para que SpringBoot determine que vamos a tener una configuración adicional de nuestros beans
@Configuration
public class MyConfigurationBean {
    //Implementando nuestro bean
    @Bean
    public MyBean beanOperation () {
        return new MyBean2Implement();//Aqui podemos configurar cual de las dos implementaciones queremos usar en el main
    }

    @Bean
    public MyOperation beanOperationOperation () {
        return new MyOperationImplement();
    }

    @Bean  //Como esta dependencia trae otra dependencia como parametro hay que incluir su interface"MyOperation"
    public MyBeanWithDependency beanMyOperationImplementWithDependency (MyOperation myOperation) {
        return new MyBeanWithDependencyImplement(myOperation);
    }

    @Bean  //Como esta dependencia trae otra dependencia como parametro hay que incluir su interface"MyOperation"
    public BeanWithDependency2 beanWithDependency2 (MyOperation myOperation) {
        return new BeanWithDependency2Implement(myOperation);
    }


}
