package com.metacube.training.SingletonScopeWithAnnotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class); 
		Person person=(Person)context.getBean(Person.class);
		person.setName("jai");
		System.out.println(person.getName());
		
		Person person1=(Person)context.getBean(Person.class);
		person1.setName("jai veeru");
		System.out.println(person1.getName());
		System.out.println(person.getName());
		
		
	}
}
