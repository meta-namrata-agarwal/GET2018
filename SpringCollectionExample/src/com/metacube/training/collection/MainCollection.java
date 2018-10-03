package com.metacube.training.collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainCollection {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Bean.xml");
		CollectionEntity collection=(CollectionEntity)context.getBean("collection");
		System.out.println(collection.getNameList());
		System.out.println(collection.getNameSet());
		System.out.println(collection.getNameMap());
	}
}
