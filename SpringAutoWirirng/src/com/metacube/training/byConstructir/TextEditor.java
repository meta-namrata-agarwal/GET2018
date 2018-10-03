package com.metacube.training.byConstructir;

public class TextEditor {

	private SpellChecker spellCheck;
	private String word;
	
	public TextEditor(SpellChecker spellCheck) {
		this.spellCheck = spellCheck;
		
	}

	/**
	 * @return the spellCheck
	 */
	public SpellChecker getSpellCheck() {
		return spellCheck;
	}
	
	/**
	 * @return the word
	 */
	public String getWord() {
		return word;
	}
	
	public String getMessage()
	{
		return spellCheck.spellCheck();
		
	}
}
