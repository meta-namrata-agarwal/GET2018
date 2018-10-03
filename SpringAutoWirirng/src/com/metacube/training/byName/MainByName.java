package com.metacube.training.byName;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MainByName {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("NameBean.xml");
		TextEditor editor = (TextEditor) factory.getBean("constructorInjection");
		System.out.println(editor.getSpellCheck().getS());
	}

}
