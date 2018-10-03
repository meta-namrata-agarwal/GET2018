package com.metacube.training.SetCollectionWithAnnotation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfigCollection {

	@Bean
	public SetCollectionEntity SetTest()
	{
		return new SetCollectionEntity();
	}
	
	@Bean
    public Set<String> set() {
        Set<String> s=new HashSet<String>();
        
        s.add("happy");
        s.add("khushi");
        s.add("happy");
        return s;
    }
}
