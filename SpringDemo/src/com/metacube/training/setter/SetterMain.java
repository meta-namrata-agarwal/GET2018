package com.metacube.training.setter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SetterMain {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext(
				"setterBean.xml");
		TextEditor editor = (TextEditor) factory.getBean("setterInjection");
		System.out.println(editor.getMessage());
	}

}
