package com.metacube.training.ListCollectionWithAnnotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainCollection {

	public static void main(String[] args) {
	    ApplicationContext context =new AnnotationConfigApplicationContext(AppConfigCollection.class);
		ListCollectionEntity collection=(ListCollectionEntity)context.getBean(ListCollectionEntity.class);
		System.out.println(collection.getList());
	}
}
