package com.metacube.training.textEditor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SetterMain {

	public static void main(String[] args) {
		ApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class);
		TextEditor editor = (TextEditor) factory.getBean(TextEditor.class);
		System.out.println(editor.getSpellCheck().getCheck());
	}

}
