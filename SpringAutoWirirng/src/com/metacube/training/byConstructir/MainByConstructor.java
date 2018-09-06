package com.metacube.training.byConstructir;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MainByConstructor {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("ConstructorBean.xml");
		TextEditor editor = (TextEditor) factory.getBean("constructorInjection");
		System.out.println(editor.getMessage());
	}

}
