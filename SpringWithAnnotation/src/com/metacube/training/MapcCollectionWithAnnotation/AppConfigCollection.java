package com.metacube.training.MapcCollectionWithAnnotation;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfigCollection {

	@Bean
	public MapCollectionEntity mapTest()
	{
		return new MapCollectionEntity();
	}
	
	@Bean
    public Map<String, Integer> map () {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        return map;
    }
}
