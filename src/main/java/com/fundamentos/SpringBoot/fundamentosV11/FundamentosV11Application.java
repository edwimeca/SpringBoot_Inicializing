package com.fundamentos.SpringBoot.fundamentosV11;

import com.fundamentos.SpringBoot.fundamentosV11.bean.*;
import com.fundamentos.SpringBoot.fundamentosV11.component.ComponentDependency;
import com.fundamentos.SpringBoot.fundamentosV11.entity.User;
import com.fundamentos.SpringBoot.fundamentosV11.pojo.UserPojo;
import com.fundamentos.SpringBoot.fundamentosV11.repository.UserRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

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
	private UserRepository userRepository;



	//Como tenemos dos implementaciones de la clase Dependency, debemos colocar la anotación @Qualifier e indicar cual implementacion queremos usar.
	public FundamentosV11Application(@Qualifier("componentTwoImplement") ComponentDependency componentDependency,
									 									 MyBean myBean,
									 									 MyBeanWithDependency myBeanWithDependency,
																		 BeanWithDependency2 beanWithDependency2,
									 									 MyOperation myOperation,
									 								     MyBeanWithProperties myBeanWithProperties,
																		 UserPojo userPojo,
									 								     UserRepository userRepository) {
		this.componentDependency 		= componentDependency;
		this.myBean 					= myBean;
		this.myBeanWithDependency 		= myBeanWithDependency;
		this.beanWithDependency2 		= beanWithDependency2;
		this.myOperation 				= myOperation;
		this.myBeanWithProperties 		= myBeanWithProperties;
		this.userPojo					= userPojo;
		this.userRepository				= userRepository;

	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosV11Application.class, args);
	}

	@Override
	public void run(String... args){
		//examples();
		saveUserInDatabase();
		getInfoJpqlFromUser();


	}
	private void getInfoJpqlFromUser(){
		LOGGER.info("User : " + userRepository.findByUserEmail("a.com").orElseThrow(() -> new RuntimeException("User does not founded"))+
				"Was founded with findByUserEmail method");
		userRepository.findAndSort("user", Sort.by("id").descending())
				.stream().forEach(user -> LOGGER.info("User with sort method "+user) );

	}
	private void saveUserInDatabase(){
		User  user1 = new User("Edwin", "e.com", LocalDate.of(2023,02,28));
		User  user2 = new User("Andrea", "a.com", LocalDate.of(2022,03,27));
		User  user3 = new User("user3", "3.com", LocalDate.of(2023,03,28));
		User  user4 = new User("user4", "4.com", LocalDate.of(2023,04,28));
		User  user5 = new User("user5", "5.com", LocalDate.of(2023,05,28));
		User  user6 = new User("user6", "6.com", LocalDate.of(2023,06,28));
		User  user7 = new User("user7", "7.com", LocalDate.of(2023,07,28));
		User  user8 = new User("user8", "8.com", LocalDate.of(2022,05,28));
		User  user9 = new User("user9", "9.com", LocalDate.of(2023,04,28));
		User  user10 = new User("user10", "10.com", LocalDate.of(2023,10,28));
		List<User> list = Arrays.asList(user1,user2,user3,user4,user5,user6,user7,user8,user9,user10);
		list.stream().forEach(userRepository::save);

	}

	//Metodos con los ejemplos iniciales
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
			int value = 2;
			LOGGER.debug("Mi value :"+value);
		} catch (Exception e) {
			LOGGER.error("This is an error you are dividing for zero" + e.getMessage());
		}

	}
}
/*
QUERY METHOD
@Query("SELECT fecha FROM tabla WHERE fecha BETWEEN :fechaInicio AND :fechaFin")
List<Date> buscarFechasEntre(@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin);

     List<User>findByNameOrBirthDateBetweenOrderByIdAsc(String name,LocalDate begin,LocalDate end);

Execute
	userRepository.findByNameOrBirthDateBetweenOrderByIdAsc("roa",LocalDate.of(2022,03,04),LocalDate.of(2022,04,06))
				.stream().forEach(user -> LOGGER.info("Usuario findByNameOrBirthDateBetweenOrderByIdAsc: "+user));
 */