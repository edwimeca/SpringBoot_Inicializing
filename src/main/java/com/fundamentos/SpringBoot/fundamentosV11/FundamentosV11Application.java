package com.fundamentos.SpringBoot.fundamentosV11;

import com.fundamentos.SpringBoot.fundamentosV11.bean.*;
import com.fundamentos.SpringBoot.fundamentosV11.component.ComponentDependency;
import com.fundamentos.SpringBoot.fundamentosV11.pojo.UserPojo;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosV11Application implements CommandLineRunner {


	private Log LOGGER = LogFactory.getLog(FundamentosV11Application.class);
	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private BeanWithDependency2 beanWithDependency2;
	private MyOperation myOperation;

	private MyBeanWithProperties myBeanWithProperties;
	private UserPojo userPojo;




	//Como tenemos dos implementaciones de la clase Dependency, debemos colocar la anotación @Qualifier e indicar cual implementacion queremos usar.
	public FundamentosV11Application(@Qualifier("componentTwoImplement") ComponentDependency componentDependency,
									 									 MyBean myBean,
									 									 MyBeanWithDependency myBeanWithDependency,
																		 BeanWithDependency2 beanWithDependency2,
									 									 MyOperation myOperation,
									 								     MyBeanWithProperties myBeanWithProperties,
																		 UserPojo userPojo ) {
		this.componentDependency 		= componentDependency;
		this.myBean 					= myBean;
		this.myBeanWithDependency 		= myBeanWithDependency;
		this.beanWithDependency2 		= beanWithDependency2;
		this.myOperation 				= myOperation;
		this.myBeanWithProperties 		= myBeanWithProperties;
		this.userPojo					= userPojo;

	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosV11Application.class, args);
	}

	@Override
	public void run(String... args){
		examples();


	}
	private void examples(){
		componentDependency.sayHi();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		beanWithDependency2.print();
		myOperation.sum(3);
		System.out.println(myBeanWithProperties.function());
		System.out.println(userPojo.getEmail()+" - "+userPojo.getPassword());
		System.out.println(String.valueOf(userPojo.getAge()));
		try {
			//error
			int value = 10/0;
			LOGGER.debug("Mi value :"+value);
		} catch (Exception e) {
			LOGGER.error("This is an error you are dividing for zero" + e.getMessage());
		}

	}
}
