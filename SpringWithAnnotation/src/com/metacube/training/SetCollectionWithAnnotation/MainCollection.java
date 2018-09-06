package com.metacube.training.SetCollectionWithAnnotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainCollection {

	public static void main(String[] args) {
	    ApplicationContext context =new AnnotationConfigApplicationContext(AppConfigCollection.class);
		SetCollectionEntity collection=(SetCollectionEntity)context.getBean(SetCollectionEntity.class);
		System.out.println(collection.getSet());
	}
}
