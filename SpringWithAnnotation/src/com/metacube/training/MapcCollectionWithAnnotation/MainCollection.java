package com.metacube.training.MapcCollectionWithAnnotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainCollection {

	public static void main(String[] args) {
		ApplicationContext context =new AnnotationConfigApplicationContext(AppConfigCollection.class);
		MapCollectionEntity collection=(MapCollectionEntity)context.getBean(MapCollectionEntity.class);
		System.out.println(collection.getNameMap());
	}
}
