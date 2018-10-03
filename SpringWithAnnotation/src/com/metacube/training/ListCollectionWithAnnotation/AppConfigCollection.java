package com.metacube.training.ListCollectionWithAnnotation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfigCollection {

	@Bean
	public ListCollectionEntity ListTest()
	{
		return new ListCollectionEntity();
	}
	
	@Bean
    public List<String> list() {
        List<String> l=new ArrayList<String>();
        l.add("happy");
        l.add("khushi");
        return l;
    }
}
