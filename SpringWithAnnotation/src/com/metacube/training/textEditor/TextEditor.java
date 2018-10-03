package com.metacube.training.textEditor;

import org.springframework.beans.factory.annotation.Autowired;

public class TextEditor {

	private SpellChecker spellCheck;
	
	/**
	 * @return the spellCheck
	 */
	public SpellChecker getSpellCheck() {
		return spellCheck;
	}
	/**
	 * @param spellCheck the spellCheck to set
	 */
	@Autowired
	public void setSpellCheck(SpellChecker spellCheck) {
		this.spellCheck = spellCheck;
	}	

}
