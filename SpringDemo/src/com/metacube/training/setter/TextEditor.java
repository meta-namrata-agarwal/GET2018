package com.metacube.training.setter;

public class TextEditor {

	private SpellChecker spellCheck;
	private String word;
	/**
	 * @return the spellCheck
	 */
	public SpellChecker getSpellCheck() {
		return spellCheck;
	}
	/**
	 * @param spellCheck the spellCheck to set
	 */
	public void setSpellCheck(SpellChecker spellCheck) {
		this.spellCheck = spellCheck;
	}
	/**
	 * @return the word
	 */
	public String getWord() {
		return word;
	}
	/**
	 * @param word the word to set
	 */
	public void setWord(String word) {
		this.word = word;
	}
	
	public String getMessage()
	{
		return spellCheck.spellCheck();
		
	}
}
