package com.metacube.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainScope {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("Bean.xml");
		ScopeExample ex=(ScopeExample)context.getBean("scopeSingleton");
		ex.setMessage("obj A  singleton called");
		System.out.println(ex.getMessage());
		
		ScopeExample ex1=(ScopeExample)context.getBean("scopeSingleton");
		System.out.println(ex1.getMessage());
		
		ScopeExample ex2=(ScopeExample)context.getBean("scopePrototype");
		ex2.setMessage("obj A prototype called");
		System.out.println(ex2.getMessage());
		
		ScopeExample ex3=(ScopeExample)context.getBean("scopePrototype");
		System.out.println(ex3.getMessage());
	}

}
