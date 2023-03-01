package com.fundamentos.SpringBoot.fundamentosV11.configuration;

import com.fundamentos.SpringBoot.fundamentosV11.bean.MyBeanWithProperties;
import com.fundamentos.SpringBoot.fundamentosV11.bean.MyBeanWithPropertiesImplement;
import com.fundamentos.SpringBoot.fundamentosV11.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties(UserPojo.class)//le estamos diciendo a Spring que esta clase es la que se va a usar(habilitada para inyectarla)
public class GeneralConfiguration {
    @Value("${value.name}")
    private String name;

    @Value("${value.lastName}")
    private String lastName;

    @Value("${value.random}")
    private String random;

    @Bean
    public MyBeanWithProperties function (){
        return new MyBeanWithPropertiesImplement(name, lastName);
    }

    //aca utilizamos un bean para inyectar la configuración ela base de datos
    @Bean
    public DataSource dataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.h2.Driver");
        dataSourceBuilder.url("jdbc:h2:mem:testdb");
        dataSourceBuilder.username("SA");
        dataSourceBuilder.password("");
        return dataSourceBuilder.build();
    }

}
