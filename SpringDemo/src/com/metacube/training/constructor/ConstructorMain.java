package com.metacube.training.constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ConstructorMain {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("constructorBean.xml");
		TextEditor editor = (TextEditor) factory.getBean("constructorInjection");
		System.out.println(editor.getMessage());
	}

}
