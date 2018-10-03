package com.metacube.training.textEditor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class AppConfig {

	@Bean
	public TextEditor text()
	{
		   TextEditor textEditor=new TextEditor();
	       textEditor.setSpellCheck(spellChecker());
	       return textEditor;
	   }
	   
	   @Bean 
	   public SpellChecker spellChecker()
	   {
	       SpellChecker spellChecker=new SpellChecker();
	       spellChecker.setCheck("checking spelling");
	       return spellChecker;
	   }
	
}
