package com.springtest;

import com.springtest.entity.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringtestApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(SpringtestApplication.class, args);
		Person person = applicationContext.getBean(Person.class);
		Person person1 = applicationContext.getBean(Person.class);
		System.out.println(person.getUsername()+" : "+person.getAge());
		System.out.println(person == person1);
		person.getPet().move();
	}

}
