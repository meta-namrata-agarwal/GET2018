package com.metacube.training.byType;

public class TextEditor {

	private SpellChecker spellCheck;
	private String word;

	/**
	 * @param spellCheck
	 *            the spellCheck to set
	 */
	public void setSpellCheck(SpellChecker spellCheck) {
		this.spellCheck = spellCheck;
	}

	/**
	 * @param word
	 *            the word to set
	 */
	public void setWord(String word) {
		this.word = word;
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

}
